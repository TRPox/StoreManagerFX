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
public interface IVisitable {
    public void acceptVisitor(IRequestVisitor v);
}
