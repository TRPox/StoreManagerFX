/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.dao;

import com.sm.storemanagerfx.entity.Employee;
import com.sm.storemanagerfx.interfaces.IDao;
import com.sm.storemanagerfx.util.InputValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */

public class EmployeeDAO implements IDao<Employee>{

    private final List<Employee> employeeList;

    public EmployeeDAO() {
        employeeList = new ArrayList();
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
    public void add(Employee e) {
        employeeList.add(e);
    }

    @Override
    public void remove(int id) {
//        employeeList.remove(e);
    }
    
    public List<Employee> findEmployeesByName(String firstName, String lastName) {
        if (InputValidator.isValid(firstName, lastName)) {
            return findMatchingEmployeesByName(firstName, lastName);
        }
        return null;
    }

    private List<Employee> findMatchingEmployeesByName(String firstName, String lastName) {
        List<Employee> matchingEmployees = new ArrayList();
        for (Employee e : employeeList) {
            if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                matchingEmployees.add(e);
            }
        }
        return matchingEmployees;
    }

    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        if (InputValidator.isValid(id)) {
            for (Employee e : employeeList) {
                if (e.getId().equals(id)) {
                    return e;
                }
            }
        }
        throw new EmployeeNotFoundException();
    }

    public class EmployeeNotFoundException extends RuntimeException {}
    }