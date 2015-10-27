/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

import com.sm.storemanagerfx.interfaces.impl.AddedEntityRequestModel;

/**
 *
 * @author Sven
 */
public interface IRequestVisitor {
    public void visit(AddedEntityRequestModel request);
}
