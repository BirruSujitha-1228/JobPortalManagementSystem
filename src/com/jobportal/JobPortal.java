package com.jobportal;

import java.util.Scanner;

public class JobPortal {
	static Scanner sc = new Scanner(System.in);
	static String name = "";
	static String email = "";
	static String password = "";
	static int age = 0;
	static String qualification = "";
	static double percentage = 0.0;
	static long mobileNumber = 0;

	static boolean running = true;
	static boolean isRegistered = false;

	public static void register() {
		System.out.println("\n===== REGISTER MODULE =====");
		sc.nextLine();

		System.out.print("Enter Your Name : ");
		name = sc.nextLine();

		System.out.print("Enter Your Email : ");
		email = sc.next();

		System.out.print("Enter Password : ");
		password = sc.next();

		System.out.print("Enter Your Age : ");
		age = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Qualification : ");
		qualification = sc.nextLine();

		System.out.print("Enter Percentage : ");
		percentage = sc.nextDouble();

		System.out.print("Enter Mobile Number : ");
		mobileNumber = sc.nextLong();
		isRegistered = true;

		System.out.println("\nRegistration Successful");
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);

	}

	public static void login() {
		System.out.println("\n===== LOGIN MODULE =====");

		if (!isRegistered) {

			System.out.println("Please Register First");

		} else {

			System.out.print("Enter Email : ");
			String enteredEmail = sc.next();

			System.out.print("Enter Password : ");
			String enteredPassword = sc.next();

			if (email.equals(enteredEmail)) {

				if (password.equals(enteredPassword)) {

					System.out.println("\nLogin Successful");
					userMenu();
				} else {

					System.out.println("Invalid Password");

				}

			} else {

				System.out.println("Account Not Found");

			}
		}
	}

	public static void userMenu() {
		boolean isOption = true;

		while (isOption) {

			System.out.println("\n===== USER MENU =====");
			System.out.println("1. View Profile");
			System.out.println("2. Apply for Job");
			System.out.println("3. Change Password");
			System.out.println("4. Logout");

			System.out.print("Enter Option : ");
			int option = sc.nextInt();

			switch (option) {

			case 1:

				viewProfile();

				break;

			case 2:
                  applyJob();
			

				break;
			case 3:
				changePassword();
				break;

			case 4:

				System.out.println("Logout Successful");
				isOption = false;

				break;

			default:

				System.out.println("Invalid Option");

			}

		}

	}

	public static void viewProfile() {
		System.out.println("\n===== PROFILE =====");
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		System.out.println("Age : " + age);
		System.out.println("Qualification : " + qualification);
		System.out.println("Percentage : " + percentage);
		System.out.println("Mobile Number : " + mobileNumber);

	}

	public static void applyJob() {
		System.out.println("\n===== Apply Job Module =====");
		System.out.println("----Job Roles----");
		System.out.println("1. Java Developer");
		System.out.println("2. QA Tester");
		System.out.println("3. Full Stack Developer");
		System.out.println("4. Data Analyst");
		System.out.println("5. Python Developer");

		System.out.print("Select Job Role : ");
		int jobChoice = sc.nextInt();

		String job = "";

		switch (jobChoice) {
		case 1:
			job = "Java Developer";
			break;
		case 2:
			job = "QA Tester";
			break;
		case 3:
			job = "Full Stack Developer";
			break;
		case 4:
			job = "Data Analyst";
			break;
		case 5:
			job = "Python Developer";
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		if (!job.equals("")) {
			if (age >= 18 && percentage >= 60) {
				System.out.println("Application Submitted Successfully");
				System.out.println("Applied Role : " + job);
			} else {
				System.out.println("Age : " + age);
				System.out.println("Percentage : " + percentage);
				System.out.println("You are not Eligible");
			}
		}

	

	}

	public static void changePassword() {
		System.out.println("Enter your Old Password");
		String oldPassword = sc.next();

		if (password.equals(oldPassword)) {
			System.out.println("Enter new Password");
			String currentPassword = sc.next();
			password = currentPassword;
			System.out.println("Password Changed Successfully");
		} else {
			System.out.println("Incorrect old Password ");
		}

	}

	public static void main(String[] args) {

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

				register();

				break;

			case 2:

				login();
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