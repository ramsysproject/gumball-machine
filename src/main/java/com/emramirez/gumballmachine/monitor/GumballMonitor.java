package com.emramirez.gumballmachine.monitor;

import com.emramirez.gumballmachine.remote.GumballMachineRemote;

import java.rmi.RemoteException;

public class GumballMonitor {
    private GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + gumballMachine.getLocation());
            System.out.println("Current Inventory: " + gumballMachine.getCount() + " gumballs");
            System.out.println("Current State: " + gumballMachine.getState());
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
