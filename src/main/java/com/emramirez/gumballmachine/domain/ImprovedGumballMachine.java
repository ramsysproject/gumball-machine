package com.emramirez.gumballmachine.domain;

import com.emramirez.gumballmachine.remote.GumballMachineRemote;
import com.emramirez.gumballmachine.state.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImprovedGumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private static final long serialVersionUID = 1L;
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;

    private State state;
    private String location;
    int count = 0;

    public ImprovedGumballMachine(int numberGumballs, String location) throws RemoteException {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.location = location;
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrack() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot");
        if(count != 0) {
            count--;
        }
    }

    public int getCount() {
        return count;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String getLocation() {
        return location;
    }
}
