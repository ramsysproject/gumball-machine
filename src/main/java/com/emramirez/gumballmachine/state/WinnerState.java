package com.emramirez.gumballmachine.state;

import com.emramirez.gumballmachine.domain.ImprovedGumballMachine;

public class WinnerState implements State {
    private static final long serialVersionUID = 1L;
    private transient ImprovedGumballMachine improvedGumballMachine;

    public WinnerState(ImprovedGumballMachine improvedGumballMachine) {
        this.improvedGumballMachine = improvedGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Unsupported");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Unsupported");
    }

    @Override
    public void turnCrank() {
        System.out.println("Unsupported");
    }

    @Override
    public void dispense() {
        improvedGumballMachine.releaseBall();
        if (improvedGumballMachine.getCount() == 0) {
            improvedGumballMachine.setState(improvedGumballMachine.getSoldOutState());
        } else {
            improvedGumballMachine.releaseBall();
            System.out.println("YOU ARE A WINNER! You got two gumballs for your quarter");
            if (improvedGumballMachine.getCount() > 0) {
                improvedGumballMachine.setState(improvedGumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops out of gumballs");
                improvedGumballMachine.setState(improvedGumballMachine.getSoldOutState());
            }
        }
    }
}
