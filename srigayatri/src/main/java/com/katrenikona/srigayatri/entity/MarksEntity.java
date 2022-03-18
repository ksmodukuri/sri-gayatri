package com.katrenikona.srigayatri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MARKS_ENTITY")
public class MarksEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MARKS_ID")
	private long id;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "FA1")
	private double FA1;
	
	@Column(name = "FA1_GRADE")
	private String fA1Grade;
	
	@Column(name = "FA2")
	private double FA2;
	
	@Column(name = "FA2_GRADE")
	private String fA2Grade;
	
	@Column(name = "FA3")
	private double FA3;
	
	@Column(name = "FA3_GRADE")
	private String fA3Grade;
	
	@Column(name = "FA4")
	private double FA4;
	
	@Column(name = "FA4_GRADE")
	private String fA4Grade;
	
	@Column(name = "SA1")
	private double SA1;
	
	@Column(name = "SA1_GRADE")
	private String sA1Grade;
	
	@Column(name = "SA2")
	private double SA2;
	
	@Column(name = "SA2_GRADE")
	private String sA2Grade;
	
	@Column(name = "AGGREGATE")
	private double aggregate;
	
	@Column(name = "GRADE")
	private String grade;

	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private StudentDetailsEntity student;
	
	public StudentDetailsEntity getStudent() {
		return student;
	}

	public void setStudent(StudentDetailsEntity student) {
		this.student = student;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getFA1() {
		return FA1;
	}

	public void setFA1(double fA1) {
		FA1 = fA1;
	}

	public String getfA1Grade() {
		return fA1Grade;
	}

	public void setfA1Grade(double fA1) {
		String grade = getGradeFromMarks(fA1,"FA1");
		this.fA1Grade = grade;
	}

	public double getFA2() {
		return FA2;
	}

	public void setFA2(double fA2) {
		FA2 = fA2;
	}

	public String getfA2Grade() {
		return fA2Grade;
	}

	public void setfA2Grade(double fA2) {
		String grade = getGradeFromMarks(fA2,"FA2");
		this.fA2Grade = grade;
	}

	public double getFA3() {
		return FA3;
	}

	public void setFA3(double fA3) {
		FA3 = fA3;
	}

	public String getfA3Grade() {
		return fA3Grade;
	}

	public void setfA3Grade(double fA3) {
		String grade = getGradeFromMarks(fA3,"FA3");
		this.fA3Grade = grade;
	}

	public double getFA4() {
		return FA4;
	}

	public void setFA4(double fA4) {
		FA4 = fA4;
	}

	public String getfA4Grade() {
		return fA4Grade;
	}

	public void setfA4Grade(double fA4) {
		String grade = getGradeFromMarks(fA4,"FA4");
		this.fA4Grade = grade;
	}

	public double getSA1() {
		return SA1;
	}

	public void setSA1(double sA1) {
		SA1 = sA1;
	}

	public String getsA1Grade() {
		return sA1Grade;
	}

	public void setsA1Grade(double sA1) {
		String grade = getGradeFromMarks(sA1,"SA1");
		this.sA1Grade = grade;
	}

	public double getSA2() {
		return SA2;
	}

	public void setSA2(double sA2) {
		SA2 = sA2;
	}

	public String getsA2Grade() {
		return sA2Grade;
	}

	public void setsA2Grade(double sA2) {
		String grade = getGradeFromMarks(sA2,"SA2");
		this.sA2Grade = grade;
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

}
