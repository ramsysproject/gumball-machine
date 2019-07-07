package com.emramirez.gumballmachine;

import com.emramirez.gumballmachine.domain.ImprovedGumballMachine;
import com.emramirez.gumballmachine.monitor.GumballMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

@SpringBootApplication
public class ImprovedGumballMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImprovedGumballMachineApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		Integer count = scanner.nextInt();

        ImprovedGumballMachine gumballMachine = null;
        try {
            gumballMachine = new ImprovedGumballMachine(count, name);
            Naming.rebind("//" + name + "/gumballmachine", gumballMachine);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
		gumballMonitor.report();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrack();

		System.out.println(gumballMachine);

		gumballMonitor.report();
	}

}
