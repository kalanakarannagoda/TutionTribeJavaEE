/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.kalana.tutiontribe.information;

import com.kalana.tutiontribe.entity.Lecture;
import com.kalana.tutiontribe.entity.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author kalana
 */
@Remote
public interface LectureManagerRemote {

    Lecture saveLecture(User u,Lecture lecture) throws RuntimeException;

    Lecture getLectureById(User u,long id) throws RuntimeException;

    List<Lecture> getAllLecture(User u) throws RuntimeException;
}
