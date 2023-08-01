/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.kalana.tutiontribre.servlet;

import com.google.gson.Gson;
import com.kalana.tutiontribe.attendance.UserAttendanceManagerRemote;
import com.kalana.tutiontribe.entity.Lecture;
import com.kalana.tutiontribe.entity.User;
import com.kalana.tutiontribe.information.LectureManagerRemote;
import com.kalana.tutiontribe.information.UserManagerRemote;
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
 * @author kalana
 */
@WebServlet(name = "ServletAddStudentToLecture", urlPatterns = {"/servlet-add-student-to-lecture"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"Owner","Admin"}))
public class ServletAddStudentToLecture extends HttpServlet {

    @EJB
    LectureManagerRemote lmr;

    @EJB
    UserManagerRemote umr;

    @EJB
    UserAttendanceManagerRemote uamr;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson = new Gson();
        
        String student = request.getParameter("student");
        String lecture = request.getParameter("lecture");

        User duser = (User) request.getSession().getAttribute("domain-user");

        String sid = student.split("-")[0];
        String lid = lecture.split("-")[0];

        System.out.println(sid+" ******* "+lid);
        
        Lecture lectureById = lmr.getLectureById(duser, Long.valueOf(lid));
        User userById = umr.getUserByContact(duser, sid);

        uamr.setUserToLecture(userById, lectureById);
        ResponsePayload responsePayload = new ResponsePayload();

        responsePayload.setCode(200);
        responsePayload.setMassage("Success");

        response.getWriter().write(gson.toJson(responsePayload));

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
