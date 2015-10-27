/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.interfaces.IEntity;
import com.sm.storemanagerfx.interfaces.IRequestVisitor;
import java.util.ArrayList;
import java.util.List;


public class AddedEntityRequestModel extends EntityRequestModel {

    private final List<IEntity> addedList;

    public AddedEntityRequestModel() {
        this.addedList = new ArrayList<>();
    }
    
    public List<IEntity> getAddedList() {
        return addedList;
    }

    @Override
    public void acceptVisitor(IRequestVisitor v) {
        v.visit(this);
    }

    @Override
    public boolean isEmpty() {
        if(addedList == null || addedList.isEmpty()) {
            throw new EmptyRequestException();
        }
        return false;
    }
  
}
