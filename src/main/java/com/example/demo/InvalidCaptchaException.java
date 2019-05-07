/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author allen
 */
class InvalidCaptchaException extends AuthenticationException
{
    
    public InvalidCaptchaException(String msg) {
        super(msg);
    }
    
}
