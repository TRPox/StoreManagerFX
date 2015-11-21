/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.dao;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.IDao;
import static com.sm.storemanagerfx.util.InputValidator.isValid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */
public class CustomerDAO implements IDao<Customer> {

    private final List<Customer> customerList;
    private final List<Integer> unusedIDs;
    private int currentHighestID;

    public CustomerDAO() {
        customerList = new ArrayList();
        unusedIDs = new ArrayList();
        currentHighestID = 0;
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Customer e) {
        int customerID = findUnusedID();
        e.setId(customerID);
        this.customerList.add(e);
    }

    private int findUnusedID() {
        if (this.unusedIDs.isEmpty()) {
            return this.currentHighestID + 1;
        } else {
            return this.unusedIDs.get(0);
        }
    }

    private void incrementCurrentHighestID() {
        this.currentHighestID++;
    }

    @Override
    public void remove(int id) {
        for(Customer c : customerList) {
            if(c.getId() == id) {
                this.customerList.remove(c);
                addToUnusedIDs(id);
                return;
            }
        }
        throw new CustomerNotFoundException();
    }

    private void addToUnusedIDs(int id) {
        this.unusedIDs.add(id);
    }

    public List<Customer> findCustomersByName(String firstName, String lastName) {
        if (isValid(firstName, lastName)) {
            return findMatchingCustomersByName(firstName, lastName);
        }
        return new ArrayList();
    }

    private List<Customer> findMatchingCustomersByName(String firstName, String lastName) {
        List<Customer> matchingCustomers = new ArrayList();
        for (Customer c : this.customerList) {
                if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                    matchingCustomers.add(c);
                }
        }
        return matchingCustomers;
    }

    public Customer findCustomerById(int id) throws CustomerNotFoundException {
        if (isValid(id)) {
            for (Customer c : this.customerList) {
                if (c.getId().equals(id)) {
                    return c;
                }
            }
        }
        throw new CustomerNotFoundException();
    }

    public class CustomerNotFoundException extends RuntimeException {
    }
}
