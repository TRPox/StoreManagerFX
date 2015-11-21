/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.storemanagerfx.commands;

/**
 *
 * @author Sven
 */
public abstract class RemoveEntityCommand implements BaseCommand {

    protected int id;

    public RemoveEntityCommand(int id) {
        this.id = id;
    }
}
