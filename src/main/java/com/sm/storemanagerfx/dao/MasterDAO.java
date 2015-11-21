/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.dao;

import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.entity.Employee;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Sven
 */
public class MasterDAO {

    private CustomerDAO customerDAO;
    private AppointmentDAO appointmentDAO;
    private EmployeeDAO employeeDAO;
    
    public void save() {
        customerDAO.save();
        appointmentDAO.save();
        employeeDAO.save();
    }

    public void load() {
        customerDAO.load();
        appointmentDAO.load();
        employeeDAO.load();
    }

    public void add(Customer customer) {
        customerDAO.add(customer);
    }

    public void remove(Customer customer) {
//        customerDAO.remove(customer);
    }

    public void add(Appointment appointment) {
        appointmentDAO.add(appointment);
    }
    
    public void remove(Appointment appointment) {
//        appointmentDAO.remove(appointment);
    }
    
    public void add(Employee employee) {
        employeeDAO.add(employee);
    }
    
    public void remove(Employee employee) {
//        employeeDAO.remove(employee);
    }
    
    public Appointment getAppointment(int id) {
        return appointmentDAO.findAppointmentById(id);
    }
    
    public List<Appointment> getAppointmentsBy(LocalDate date) {
        return appointmentDAO.findAppointmentsByDate(date);
    }
    
    public List<Appointment> getAppointmentsBy(Customer customer) {
        return appointmentDAO.findAppointmentsByCustomer(customer);
    }
    
    public List<Appointment> getAppointmentsBy(Employee employee) {
        return appointmentDAO.findAppointmentsByEmployee(employee);
    }
    
    public Customer getCustomer(int id) {
        return customerDAO.findCustomerById(id);
    }
    
    public List<Customer> getCustomersBy(String firstName, String lastName) {
        return customerDAO.findCustomersByName(firstName, lastName);
    }
    
    public Employee getEmployee(int id)  {
        return employeeDAO.findEmployeeById(id);
    }
    
    public List<Employee> getEmployeesBy(String firstName, String lastName) {
        return employeeDAO.findEmployeesByName(firstName, lastName);
    }
    
    
}
