/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

/**
 *
 * @author Sven
 */
public interface IRequestModel extends IVisitable{

    boolean isEmpty();
    
    public class EmptyRequestException extends RuntimeException {}
    
}
