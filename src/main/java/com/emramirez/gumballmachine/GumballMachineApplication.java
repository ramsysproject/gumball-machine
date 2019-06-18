package com.emramirez.gumballmachine;

import com.emramirez.gumballmachine.domain.GumballMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GumballMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GumballMachineApplication.class, args);

		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.ejectQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.ejectQuarter();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);
	}

}
