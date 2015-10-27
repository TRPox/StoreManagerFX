/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

/**
 *
 * @author Sven
 * @param <T>
 */
public interface IDao<T extends IEntity> {
    
    public void save();
    public void load();
    public void add(T e);
    public void remove(T e);
}
