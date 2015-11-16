/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces.impl;

import com.sm.storemanagerfx.requests.IRequestModel;

public abstract class AddedEntityRequestModel implements IRequestModel {

    protected int id;
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
