/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

import java.util.Map;

/**
 *
 * @author Sven
 */
public interface ICustomerRequestBoundary {
//    public boolean receiveRequest(IRequestModel request);
    public void addCustomer(Map<String, Object> dataMap);
    public void editCustomer();
    public void removeCustomer();
}
