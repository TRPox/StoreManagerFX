/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.interfaces.IEntity;
import com.sm.storemanagerfx.interfaces.IResponseModel;
import com.sm.storemanagerfx.interfaces.IRequestVisitor;
import java.util.List;

/**
 *
 * @author Sven
 */
public class EntityResponseModel implements IResponseModel{
    protected List<IEntity> entityList;

    @Override
    public void acceptVisitor(IRequestVisitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
