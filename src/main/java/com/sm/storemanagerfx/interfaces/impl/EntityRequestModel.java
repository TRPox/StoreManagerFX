/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.interfaces.IRequestModel;
import com.sm.storemanagerfx.interfaces.IRequestVisitor;

/**
 *
 * @author Sven
 */
public abstract class EntityRequestModel implements IRequestModel{

    @Override
    public abstract void acceptVisitor(IRequestVisitor v);

}
