package com.emramirez.gumballmachine;

import com.emramirez.gumballmachine.domain.ImprovedGumballMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImprovedGumballMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImprovedGumballMachineApplication.class, args);

		ImprovedGumballMachine gumballMachine = new ImprovedGumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);
	}

}
