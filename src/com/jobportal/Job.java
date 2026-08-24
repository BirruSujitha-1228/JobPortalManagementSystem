package com.jobportal;

public class Job {
	private int jobId;
	private String jobTitle;
	private String company;
	public Job(int jobId,String jobTitle,String company) {
		this.jobId=jobId;
		this.jobTitle = jobTitle;
	    this.company = company;
	}
	public int getJobId() {
	    return jobId;
	}

	public String getJobTitle() {
	    return jobTitle;
	}

	public String getCompany() {
	    return company;
	}

}
