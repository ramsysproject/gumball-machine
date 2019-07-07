package com.emramirez.gumballmachine.state;

import com.emramirez.gumballmachine.domain.ImprovedGumballMachine;

public class SoldState implements State {
    private static final long serialVersionUID = 1L;
    private transient ImprovedGumballMachine improvedGumballMachine;

    public SoldState(ImprovedGumballMachine improvedGumballMachine) {
        this.improvedGumballMachine = improvedGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        improvedGumballMachine.releaseBall();
        if (improvedGumballMachine.getCount() > 0) {
            improvedGumballMachine.setState(improvedGumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            improvedGumballMachine.setState(improvedGumballMachine.getSoldOutState());
        }
    }
}
