package cn.edu.imnu.ITOffer.Bean;

import java.util.Date;

public class Applicant {
	private int applicantID;
	private String applicantEmail;
	private String apliacantPwd;
	private Date applicantRegistDate;
	public Applicant(int applicantID, String applicantEmail, String apliacantPwd) {
		super();
		this.applicantID = applicantID;
		this.applicantEmail = applicantEmail;
		this.apliacantPwd = apliacantPwd;
	}
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getApplicantEmail() {
		return applicantEmail;
	}
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
	public String getApliacantPwd() {
		return apliacantPwd;
	}
	public void setApliacantPwd(String apliacantPwd) {
		this.apliacantPwd = apliacantPwd;
	}
	public Date getApplicantRegistDate() {
		return applicantRegistDate;
	}
	public void setApplicantRegistDate(Date applicantRegistDate) {
		this.applicantRegistDate = applicantRegistDate;
	}
	private static void test () {
		Applicant applicant = new Applicant(233,"酥妃@qq.com","Pwd");
		System.out.println(applicant.getApplicantID());
		System.out.println(applicant.getApplicantEmail());
		System.out.println(applicant.getApliacantPwd());
		applicant.setApplicantEmail("20171102171@QAQ.com");
		applicant.setApliacantPwd("2333_PWD");
		applicant.setApplicantID(2333);
		applicant.setApplicantRegistDate(new Date());
		System.out.println(applicant.getApplicantID());
		System.out.println(applicant.getApplicantEmail());
		System.out.println(applicant.getApliacantPwd());
		System.out.println(applicant.getApplicantRegistDate());
	}
	public static void main(String[] args) {
		test();
	}
}

