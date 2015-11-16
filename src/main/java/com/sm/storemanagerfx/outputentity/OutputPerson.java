/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.outputentity;

import com.sm.storemanagerfx.interfaces.IOutputEntity;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sven
 */
public class OutputPerson implements IOutputEntity{
    private final StringProperty firstName;
    private final StringProperty lastName;
    private Integer id;

    public OutputPerson() {
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.id = -1; //set this to -1, so it's always an invalid id unless a valid value is set by the user
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
