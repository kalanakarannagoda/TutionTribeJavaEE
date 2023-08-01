/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kalana.tutiontribre.servlet;

import com.google.gson.Gson;
import com.kalana.tutiontribe.entity.Branch;
import com.kalana.tutiontribe.entity.Institute;
import com.kalana.tutiontribe.entity.User;
import com.kalana.tutiontribe.information.BranchManagerRemote;
import com.kalana.tutiontribe.information.InstituteManagerRemote;
import com.kalana.tutiontribe.models.ResponsePayload;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author kalanas
 */
@WebServlet(name = "ServletBranchRegister", urlPatterns = {"/servlet-branch-register"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner","Admin"}))
public class ServletBranchRegister extends HttpServlet {

    @EJB
    BranchManagerRemote bmr;

    @EJB
    InstituteManagerRemote imr;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        String name = request.getParameter("bname");
        String city = request.getParameter("bcity");
        User user = (User) request.getSession().getAttribute("domain-user");
        Branch branch = new Branch();
        Institute instituteById = imr.getInstituteById(user, 1);
        branch.setCity(city);
        branch.setInstitute(instituteById);
        branch.setName(name);
        Branch saveBranch = bmr.saveBranch(user, branch);
        ResponsePayload responsePayload = new ResponsePayload();
        if (saveBranch != null) {
            responsePayload.setCode(200);
            responsePayload.setMassage("Success");
        } else {
            responsePayload.setCode(200);
            responsePayload.setMassage("Error in Data Saving");
        }
        response.getWriter().write(gson.toJson(responsePayload));

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
