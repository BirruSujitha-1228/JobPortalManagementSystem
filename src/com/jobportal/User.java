package com.jobportal;

public class User {
	private String name;
	private String email;
	private String password;
	private int age;
	private String qualification;
	private double percentage;
	private long mobileNumber;

	public User(String name, String email, String password, int age, String qualification, double percentage,
			long mobileNumber) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.qualification = qualification;
		this.percentage = percentage;
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
