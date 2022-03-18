package com.katrenikona.srigayatri.object;

import java.util.List;

public class Marks extends Response{
	
	private List<String> examTypeList;
	
	private List<String> subjectList;
	
	private long studentId;
	
	private long marksId;
	
	private String admissionNumber;
	
	private String std;
	
	private String studentName;

	private String subject;

	private double fA1;

	private String fA1Grade;

	private double fA2;

	private String fA2Grade;

	private double fA3;

	private String fA3Grade;

	private double fA4;

	private String fA4Grade;

	private double sA1;

	private String sA1Grade;

	private double sA2;

	private String sA2Grade;

	private double aggregate;

	private String grade;

	public long getMarksId() {
		return marksId;
	}

	public void setMarksId(long marksId) {
		this.marksId = marksId;
	}

	public List<String> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<String> subjectList) {
		this.subjectList = subjectList;
	}

	public List<String> getExamTypeList() {
		return examTypeList;
	}

	public void setExamTypeList(List<String> examTypeList) {
		this.examTypeList = examTypeList;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getfA1Grade() {
		return fA1Grade;
	}

	public void setfA1Grade(String fA1Grade) {
		this.fA1Grade = fA1Grade;
	}

	public void setfA2Grade(String fA2Grade) {
		this.fA2Grade = fA2Grade;
	}

	public void setfA3Grade(String fA3Grade) {
		this.fA3Grade = fA3Grade;
	}

	public void setfA4Grade(String fA4Grade) {
		this.fA4Grade = fA4Grade;
	}

	public void setsA1Grade(String sA1Grade) {
		this.sA1Grade = sA1Grade;
	}

	public void setsA2Grade(String sA2Grade) {
		this.sA2Grade = sA2Grade;
	}

	public String getfA2Grade() {
		return fA2Grade;
	}

	public String getfA3Grade() {
		return fA3Grade;
	}

	public String getfA4Grade() {
		return fA4Grade;
	}

	public String getsA1Grade() {
		return sA1Grade;
	}

	public String getsA2Grade() {
		return sA2Grade;
	}

	public double getAggregate() {
		return aggregate;
	}

	public void setAggregate(double aggregate) {
		this.aggregate = aggregate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getfA1() {
		return fA1;
	}

	public void setfA1(double fA1) {
		this.fA1 = fA1;
	}

	public double getfA2() {
		return fA2;
	}

	public void setfA2(double fA2) {
		this.fA2 = fA2;
	}

	public double getfA3() {
		return fA3;
	}

	public void setfA3(double fA3) {
		this.fA3 = fA3;
	}

	public double getfA4() {
		return fA4;
	}

	public void setfA4(double fA4) {
		this.fA4 = fA4;
	}

	public double getsA1() {
		return sA1;
	}

	public void setsA1(double sA1) {
		this.sA1 = sA1;
	}

	public double getsA2() {
		return sA2;
	}

	public void setsA2(double sA2) {
		this.sA2 = sA2;
	}
	

}
