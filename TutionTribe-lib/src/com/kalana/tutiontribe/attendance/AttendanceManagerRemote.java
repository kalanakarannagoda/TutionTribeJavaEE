/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.kalana.tutiontribe.attendance;

import com.kalana.tutiontribe.entity.Attendance;
import com.kalana.tutiontribe.entity.Lecture;
import com.kalana.tutiontribe.entity.User;
import javax.ejb.Remote;

/**
 *
 * @author kalana
 */
@Remote
public interface AttendanceManagerRemote {

    Attendance saveAttendance(Attendance attendance) throws RuntimeException;

    
    
}
