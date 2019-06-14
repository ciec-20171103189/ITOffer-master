package cn.edu.imnu.ITOffer.Bean;

import java.util.Date;

public class ResumeBasicinfo {
	private String realName;
	private String gender;
	private Date birthday;
	private String telephone ;
	private String email;
	private String jobIntension;
	private String jobExperience;
	private String currentLoc;
	private String residentLoc;

	public String getcurrentLoc() {
		return this.currentLoc;
	}
	
	public String getresidentLoc() {
		return this.residentLoc;
	}
	
	public String  getRealName() {
		return this.realName;
	}
	
	public String  getGender() {
		return this.gender;
	}
	
	public Date  getBirthday() {
		return this.birthday;
	}
	
	public String  getTelephone() {
		return this.telephone;
	}
	
	public String  getEmail() {
		return this.email;
	}
	
	public String  getJobIntension() {
		return this.jobIntension;
	}
	
	public String  getJobExperience() {
		return this.jobExperience;
	}
	
	public ResumeBasicinfo(String realName,String gender,Date birthdayDate,String currentLoc,String residentLoc,String telephone,String email,String jobIntension,String jobExperience) {
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthdayDate;
		this.telephone = telephone;
		this.email = email;
		this.jobIntension = jobIntension;
		this.jobExperience = jobExperience;
		this.currentLoc = currentLoc;
		this.residentLoc = residentLoc;
	}
	
	private static void  Test() {
		ResumeBasicinfo info =  new ResumeBasicinfo("Sunny", "男", null,"和林1","和林2", "10086", "20171102171@qq.com", "JOB _ INT ", "JOB _ EXP ");
		System.out.println(info.getEmail());
		System.out.println(info.getGender());
		System.out.println(info.getTelephone());
		System.out.println(info.getEmail());
		System.out.println(info.getJobExperience());
		System.out.println(info.getJobIntension());
		System.out.println(info.getcurrentLoc());
		System.out.println(info.getresidentLoc());
	}
	public static void main(String[] args) {
		Test();
	}
}
