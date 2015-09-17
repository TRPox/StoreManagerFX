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
public interface IDao {
    
    public void save();
    public void load();
    public void add(IEntity e);
    public void remove(IEntity e);
    public boolean isCorrectEntity(IEntity e);
    
    public class WrongEntityException extends RuntimeException {}
    
}
