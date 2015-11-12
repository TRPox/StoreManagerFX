/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.outputentity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Sven
 */
public class OutputCustomer extends OutputPerson{
    private final ObjectProperty<OutputAppointment> lastAppointment;
    private final ObjectProperty<OutputAppointment> nextAppointment;

    public OutputCustomer() {
        this.lastAppointment = new SimpleObjectProperty<>();
        this.nextAppointment = new SimpleObjectProperty<>();
    }

    public OutputAppointment getLastAppointment() {
        return this.lastAppointment.get();
    }
    
    public void setLastAppointment(OutputAppointment appointment) {
        this.lastAppointment.set(appointment);
    }
    
    public OutputAppointment getNextAppointment() {
        return this.nextAppointment.get();
    }
    
    public void setNextAppointment(OutputAppointment appointment) {
        this.nextAppointment.set(appointment);
    }
}
