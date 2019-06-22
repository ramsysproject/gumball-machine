package com.emramirez.gumballmachine.state;

import com.emramirez.gumballmachine.domain.ImprovedGumballMachine;

import java.util.Random;

public class HasQuarterState implements State {
    Random randomWinner = new Random(System.currentTimeMillis());
    private ImprovedGumballMachine improvedGumballMachine;

    public HasQuarterState(ImprovedGumballMachine improvedGumballMachine) {
        this.improvedGumballMachine = improvedGumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        improvedGumballMachine.setState(improvedGumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (improvedGumballMachine.getCount() > 1)) {
            improvedGumballMachine.setState(improvedGumballMachine.getWinnerState());
        } else {
            improvedGumballMachine.setState(improvedGumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
