/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.interfaces;

import com.sm.storemanagerfx.entity.Customer;
import java.util.List;

/**
 *
 * @author Sven
 */
public interface ICustomerRequestBoundary {
//    public boolean receiveRequest(IRequestModel request);
    public void addCustomers(List<Customer> addedList);
    public void editCustomers();
    public void removeCustomers();
}
