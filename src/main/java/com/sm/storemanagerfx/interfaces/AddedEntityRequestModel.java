/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

import com.sm.storemanagerfx.requests.IRequestModel;

public interface AddedEntityRequestModel<T extends IOutputEntity> extends IRequestModel {

    public void add(T entity);
    public void remove(T entity);
}
