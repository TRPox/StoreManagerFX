/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.interfaces.IEntity;
import com.sm.storemanagerfx.interfaces.IInteractor;
import com.sm.storemanagerfx.interfaces.IResponseBoundary;

/**
 *
 * @author Sven
 */
public abstract class BaseInteractor<T extends IEntity> implements IInteractor {

    protected IResponseBoundary controller;
//    protected CommandFactory commandFactory;
    
    public IResponseBoundary getController() {
        return controller;
    }

    public void setController(IResponseBoundary controller) {
        this.controller = controller;
    }
    
}
