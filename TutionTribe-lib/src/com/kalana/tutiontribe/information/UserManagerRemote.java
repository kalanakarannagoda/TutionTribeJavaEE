/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.kalana.tutiontribe.information;

import com.kalana.tutiontribe.entity.Branch;
import com.kalana.tutiontribe.entity.User;
import com.kalana.tutiontribe.entity.UserRole;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author kalana
 */
@Remote
public interface UserManagerRemote {

    User saveUser(User user,UserRole role, Branch branch) throws RuntimeException;

    User getUserById(User u,long id) throws RuntimeException;

    User getUserByContact(User u,String contact) throws RuntimeException;

    List<User> getAllUsers(User u) throws RuntimeException;
    
    List<User> getAllUsersByRole(String role) throws RuntimeException;

    User userLogin(String email, String password) throws RuntimeException;

}
