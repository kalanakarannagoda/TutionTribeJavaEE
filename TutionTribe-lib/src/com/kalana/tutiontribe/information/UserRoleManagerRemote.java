/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.kalana.tutiontribe.information;

import com.kalana.tutiontribe.entity.User;
import com.kalana.tutiontribe.entity.UserRole;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author kalana
 */
@Remote
public interface UserRoleManagerRemote {

    List<UserRole> getAllUserRoles(User u) throws RuntimeException;
    
    UserRole getRoleByName(User u,String name) throws RuntimeException;
    
}
