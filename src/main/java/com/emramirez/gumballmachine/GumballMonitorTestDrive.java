package com.emramirez.gumballmachine;

import com.emramirez.gumballmachine.monitor.GumballMonitor;
import com.emramirez.gumballmachine.remote.GumballMachineRemote;

import java.rmi.Naming;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        String[] location = {
                "rmi://santafe.mightygumball.com/gumballmachine",
                "rmi://boulder.mightygumball.com/gumballmachine",
                "rmi://seattle.mightygumball.com/gumballmachine"
        };

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machineRemote = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machineRemote);
                System.out.println(monitor[i]);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }
}
