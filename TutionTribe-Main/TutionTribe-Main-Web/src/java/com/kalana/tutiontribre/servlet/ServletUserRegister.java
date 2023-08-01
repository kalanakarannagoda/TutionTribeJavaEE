/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kalana.tutiontribre.servlet;

import com.google.gson.Gson;
import com.kalana.tutiontribe.entity.Branch;
import com.kalana.tutiontribe.entity.User;
import com.kalana.tutiontribe.entity.UserRole;
import com.kalana.tutiontribe.information.BranchManagerRemote;
import com.kalana.tutiontribe.information.UserManagerRemote;
import com.kalana.tutiontribe.information.UserRoleManagerRemote;
import com.kalana.tutiontribe.models.ResponsePayload;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kalana
 */
@WebServlet(name = "ServletUserRegister", urlPatterns = {"/servlet-user-register"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner","Admin"}))
public class ServletUserRegister extends HttpServlet {

    @EJB
    private UserManagerRemote umr;

    @EJB
    private UserRoleManagerRemote userroleManager;

    @EJB
    private BranchManagerRemote branchManager;

    @Override
    public void init() throws ServletException {
        System.out.println("servlet-user-register servlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User dUser = (User) request.getSession().getAttribute("domain-user"); 
        
        Gson gson = new Gson();
        
        System.out.println("servlet-user-register servlet post with " + request.getParameterMap().size() + " params");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String branch = request.getParameter("branch");
        String age = request.getParameter("age");
        String userRole = request.getParameter("role");

        UserRole roleByName = userroleManager.getRoleByName(dUser,userRole);
        
        System.out.println("roleByName "+roleByName.toString());
        
        Branch branchObj = branchManager.getBranchByName(dUser, branch);
        System.out.println("branchByName "+branchObj.toString());

        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setAge(Integer.valueOf(age));
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setContact(number);

        User saveUser = umr.saveUser(user,roleByName,branchObj);
        ResponsePayload responsePayload = new ResponsePayload();
        if (saveUser != null) {
                responsePayload.setCode(200);
                responsePayload.setMassage("Success");
            } else {
                responsePayload.setCode(200);
                responsePayload.setMassage("Error in Data Saving");
            }
        response.getWriter().write(gson.toJson(responsePayload));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
