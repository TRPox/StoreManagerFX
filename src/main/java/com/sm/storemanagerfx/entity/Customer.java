/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.entity;

/**
 *
 * @author Sven
 */
public class Customer extends Person{
    
    private Appointment lastAppointment;
    private Appointment nextAppointment;

    public Appointment getLastAppointment() {
        return lastAppointment;
    }

    public void setLastAppointment(Appointment lastAppointment) {
        this.lastAppointment = lastAppointment;
    }

    public Appointment getNextAppointment() {
        return nextAppointment;
    }

    public void setNextAppointment(Appointment nextAppointment) {
        this.nextAppointment = nextAppointment;
    }
}
