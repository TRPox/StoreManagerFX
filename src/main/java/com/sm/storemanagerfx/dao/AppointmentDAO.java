/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.dao;

import com.sm.storemanagerfx.entity.Appointment;
import com.sm.storemanagerfx.interfaces.IDao;
import com.sm.storemanagerfx.util.InputValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sven
 */
public class AppointmentDAO implements IDao{
    
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
    
    public List<Appointment> findAppointmentsByDate(LocalDate date) {
        List<Appointment> matchingAppointments;
        if(InputValidator.isValid(date)) {
            matchingAppointments = findMatchingAppointmentsByDate(date);
            return matchingAppointments;
        }
        return null;
    }

    private List<Appointment> findMatchingAppointmentsByDate(LocalDate date) {
        List<Appointment> matchingAppointments = new ArrayList();
        for(Appointment a : appointmentList) {
            if(a.getStartTime().toLocalDate().equals(date)) {
                matchingAppointments.add(a);
            }
        }
        return matchingAppointments;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }
    
    
    
    
    
}
