/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

import java.util.List;

/**
 *
 * @author Sven
 */
public interface IRequestVisitor<T extends IEntity> {
    public void visit(List<T> addedList);
    
}
