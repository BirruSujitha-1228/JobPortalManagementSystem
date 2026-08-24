package com.jobportal;

import java.util.Scanner;

public class JobPortal {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		JobService service = new JobService(sc);
		boolean running = true;

		System.out.println("=================================");
		System.out.println("      WELCOME TO JOB PORTAL      ");
		System.out.println("=================================");

		while (running) {

			System.out.println("\n1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");

			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				service.register();
				break;

			case 2:

				service.login();
				break;

			case 3:

				System.out.println("Thank You For Using Job Portal");
				running = false;
				break;

			default:

				System.out.println("Invalid Choice");

			}

		}

		sc.close();
	}

}