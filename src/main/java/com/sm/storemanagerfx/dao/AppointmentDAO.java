/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.dao;

import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.entity.Customer;
import com.sm.storemanagerfx.entity.Employee;
import com.sm.storemanagerfx.interfaces.IDao;
import com.sm.storemanagerfx.util.InputValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */
public class AppointmentDAO implements IDao<Appointment> {

    private final List<Appointment> appointmentList;

    public AppointmentDAO() {
        appointmentList = new ArrayList();
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
    public void add(Appointment e) {
            appointmentList.add(e);
    }

    @Override
    public void remove(Appointment e) {
            appointmentList.remove(e);
    }

    public List<Appointment> findAppointmentsByDate(LocalDate date) {
        if (InputValidator.isValid(date)) {
            return findMatchingAppointmentsByDate(date);
        }
        return null;
    }

    private List<Appointment> findMatchingAppointmentsByDate(LocalDate date) {
        List<Appointment> matchingAppointments = new ArrayList();
        for (Appointment a : appointmentList) {
            if (a.getStartTime().toLocalDate().equals(date)) {
                matchingAppointments.add(a);
            }
        }
        return matchingAppointments;
    }

    public List<Appointment> findAppointmentsByCustomer(Customer customer) {
         if (InputValidator.isValid(customer)) {
            return findMatchingAppointmentsByCustomer(customer);
        }
        return null;
    }

    private List<Appointment> findMatchingAppointmentsByCustomer(Customer customer) {
        List<Appointment> matchingAppointments = new ArrayList();
        for (Appointment a : appointmentList) {
            if (a.getCustomer().equals(customer)) {
                matchingAppointments.add(a);
            }
        }
        return matchingAppointments;
    }
    
    public List<Appointment> findAppointmentsByEmployee(Employee employee) {
         if (InputValidator.isValid(employee)) {
            return findMatchingAppointmentsByEmployee(employee);
        }
        return null;
    }

    private List<Appointment> findMatchingAppointmentsByEmployee(Employee employee) {
        List<Appointment> matchingAppointments = new ArrayList();
        for (Appointment a : appointmentList) {
            if (a.getEmployee().equals(employee)) {
                matchingAppointments.add(a);
            }
        }
        return matchingAppointments;
    }
}
