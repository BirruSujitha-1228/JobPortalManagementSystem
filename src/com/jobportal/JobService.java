package com.jobportal;

import java.util.ArrayList;
import java.util.Scanner;

public class JobService {
	private Scanner sc;

	private ArrayList<User> users = new ArrayList<>();
	private ArrayList<Job> jobs = new ArrayList<>();
	User currentUser;
	public JobService(Scanner sc) {
		this.sc=sc;
		addJobs();
	}
	
	private void addJobs() {

	    jobs.add(new Job(101, "Java Developer", "TCS"));
	    jobs.add(new Job(102, "QA Tester", "Infosys"));
	    jobs.add(new Job(103, "Full Stack Developer", "Wipro"));
	    jobs.add(new Job(104, "Data Analyst", "Accenture"));
	    jobs.add(new Job(105, "Python Developer", "Cognizant"));

	}
	public void viewJobs() {

	    System.out.println("\n===== AVAILABLE JOBS =====");

	    for (Job job : jobs) {
	        System.out.println("Job ID : " + job.getJobId());
	        System.out.println("Job Title : " + job.getJobTitle());
	        System.out.println("Company : " + job.getCompany());
	        System.out.println("-------------------------");
	    }
	}
	
	public void viewMyApplications() {

	    System.out.println("\n===== MY APPLICATIONS =====");

	    if (currentUser.getAppliedJobs().isEmpty()) {
	        System.out.println("No applications found.");
	        return;
	    }

	    for (Job job : currentUser.getAppliedJobs()) {

	        System.out.println("Job ID : " + job.getJobId());
	        System.out.println("Job Title : " + job.getJobTitle());
	        System.out.println("Company : " + job.getCompany());
	        System.out.println("Status : Applied");
	        System.out.println("-------------------------");
	    }
	}

	

	public void register() {

		System.out.println("\n===== REGISTER MODULE =====");
		sc.nextLine();

		System.out.print("Enter Your Name : ");
		String name = sc.nextLine();

		System.out.print("Enter Your Email : ");
		String email = sc.next();

		System.out.print("Enter Password : ");
		String password = sc.next();

		System.out.print("Enter Your Age : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Qualification : ");
		String qualification = sc.nextLine();

		System.out.print("Enter Percentage : ");
		double percentage = sc.nextDouble();

		System.out.print("Enter Mobile Number : ");
		long mobileNumber = sc.nextLong();
		
		for (User u : users) {

		    if (u.getEmail().equals(email)) {
		        System.out.println("Email already registered. Please use another email.");
		        return;
		    }
		}

		User newUser = new User(name, email, password, age, qualification, percentage, mobileNumber);
		users.add(newUser);

		System.out.println("\nRegistration Successful");
		System.out.println("Name : " + newUser.getName());
		System.out.println("Email : " + newUser.getEmail());
	}

	public void login() {

		System.out.println("\n===== LOGIN MODULE =====");

		if (users.isEmpty()) {
			System.out.println("No users Registerd. Please Register First");
			return;
		}

		System.out.print("Enter Email : ");
		String enteredEmail = sc.next();

		System.out.print("Enter Password : ");
		String enteredPassword = sc.next();

		boolean loginSuccess = false;
		for (User u : users) {

			if (u.getEmail().equals(enteredEmail)) {

				if (u.getPassword().equals(enteredPassword)) {
					currentUser = u;
					loginSuccess = true;
					System.out.println("\nLogin Successful");
					userMenu();
					break;

				} else {

					System.out.println("Invalid Password");
					loginSuccess = true;
					break;
				}

			}

		}
		if (!loginSuccess) {
			System.out.println("No Account Found with this Email. Please Register First.");
		}
	}

	public void userMenu() {
		boolean isOption = true;
		while (isOption) {
			System.out.println("\n===== USER MENU =====");
			System.out.println("1. View Profile");
			System.out.println("2. View Jobs");
			System.out.println("3. Apply for Job");
			System.out.println("4. My Applications");
			System.out.println("5. Change Password");
			System.out.println("6. Logout");

			System.out.print("Enter Option : ");
			int option = sc.nextInt();
			switch (option) {

			case 1:

				viewProfile();
				break;
			
			case 2:

				viewJobs();
				break;

			case 3:

				applyJob();
				break;
				
			case 4:
			    viewMyApplications();
			    break;

			case 5:

				changePassword();
				break;

			case 6:

				System.out.println("You have been Logged out Successfully");
				isOption = false;
				break;

			default:

				System.out.println("Invalid Option");

			}
		}
	}

	public void viewProfile() {
		System.out.println("\n===== PROFILE =====");
		System.out.println("Name : " + currentUser.getName());
		System.out.println("Email : " + currentUser.getEmail());
		System.out.println("Age : " + currentUser.getAge());
		System.out.println("Qualification : " + currentUser.getQualification());
		System.out.println("Percentage : " + currentUser.getPercentage());
		System.out.println("Mobile Number : " + currentUser.getMobileNumber());
		// userMenu();

	}

	public void applyJob() {

	    System.out.println("\n===== APPLY FOR JOB =====");

	    for (Job job : jobs) {
	        System.out.println(job.getJobId() + " - "
	                + job.getJobTitle() + " - "
	                + job.getCompany());
	    }

	    System.out.print("Enter Job ID : ");
	    int jobId = sc.nextInt();

	    Job selectedJob = null;

	    for (Job job : jobs) {

	        if (job.getJobId() == jobId) {
	            selectedJob = job;
	            break;
	        }
	    }

	    if (selectedJob == null) {
	        System.out.println("Invalid Job ID");
	        return;
	    }

	    if (currentUser.getAge() >= 18 && currentUser.getPercentage() >= 60) {
	        currentUser.applyForJob(selectedJob);
	        System.out.println("Application Submitted Successfully");
	        System.out.println("Applied Role : " + selectedJob.getJobTitle());
	        System.out.println("Company : " + selectedJob.getCompany());

	    } else {

	        System.out.println("Age : " + currentUser.getAge());
	        System.out.println("Percentage : " + currentUser.getPercentage());
	        System.out.println("You are not Eligible");
	    }

		

	}

	public void changePassword() {
		System.out.println("Enter your Old Password");
		String oldPassword = sc.next();

		if (currentUser.getPassword().equals(oldPassword)) {
			System.out.println("Enter new Password");
			String newPassword = sc.next();
			currentUser.setPassword(newPassword);
			System.out.println("Password Changed Successfully");
		} else {
			System.out.println("Incorrect Old Password");
		}

	}
	

}
