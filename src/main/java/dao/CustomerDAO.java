/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.interfaces.IDao;
import com.sm.storemanagerfx.util.InputValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */
public class CustomerDAO implements IDao {

    private final List<Customer> customerList;

    public CustomerDAO() {
        customerList = new ArrayList();
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Customer> findCustomersByName(String firstName, String lastName) {
        if (InputValidator.isValid(firstName, lastName)) {
            List<Customer> matchingCustomers = findMatchingCustomersByName(firstName, lastName);
            return matchingCustomers;
        }
        return null;
    }

    private List<Customer> findMatchingCustomersByName(String firstName, String lastName) {
        List<Customer> matchingCustomers = new ArrayList();
        for (Customer c : customerList) {
            if (c.getFirstName().equals(firstName) && c.getLastName().equals(lastName)) {
                matchingCustomers.add(c);
            }
        }
        return matchingCustomers;
    }

    public Customer findCustomerById(int id) throws CustomerNotFoundException {
        if (InputValidator.isValid(id)) {
            for (Customer c : customerList) {
                if (c.getId().equals(id)) {
                    return c;
                }
            }
        }
        throw new CustomerNotFoundException();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    
    public class CustomerNotFoundException extends RuntimeException{}
}
