/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.outputentity;

import com.sm.storemanagerfx.entity.Address;
import com.sm.storemanagerfx.interfaces.IOutputEntity;
import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sven
 */
public class OutputPerson implements IOutputEntity{
    protected final StringProperty firstName;
    protected final StringProperty lastName;
    protected final ObjectProperty<LocalDate> birthday;
    protected final ObjectProperty<Address> address;
    protected Integer id;

    public OutputPerson() {
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.birthday = new SimpleObjectProperty<>();
        this.address = new SimpleObjectProperty<>();
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

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public Address getAddress() {
        return address.get();
    }

    public void setAddress(Address address) {
        this.address.set(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
