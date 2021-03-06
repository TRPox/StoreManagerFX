/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.entity;

import com.sm.storemanagerfx.interfaces.IEntity;
import java.time.LocalDateTime;

/**
 *
 * @author Sven
 */
public class Appointment implements IEntity {

    private Integer id;
    private String title;
    private Customer customer;
    private Employee employee;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean collidesWith(Appointment appointment) {
        return dateTimeCollidesWithAppointment(startTime, appointment)
                || dateTimeCollidesWithAppointment(endTime, appointment)
                || dateTimeCollidesWithAppointment(appointment.getStartTime(), this)
                || dateTimeCollidesWithAppointment(appointment.getEndTime(), this);
    }

    private boolean dateTimeCollidesWithAppointment(LocalDateTime dateTime, Appointment appointment) {
        return (dateTime.isAfter(appointment.getStartTime()) || dateTime.isEqual(appointment.getStartTime()))
                && ((dateTime).isBefore(appointment.getEndTime()) || dateTime.isEqual(appointment.getEndTime()));
    }

}
