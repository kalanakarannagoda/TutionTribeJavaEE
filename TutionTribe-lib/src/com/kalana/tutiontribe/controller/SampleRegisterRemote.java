/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.kalana.tutiontribe.controller;

import javax.ejb.Remote;

/**
 *
 * @author kalana
 */
@Remote
public interface SampleRegisterRemote {

    void registerClient();
    
}
