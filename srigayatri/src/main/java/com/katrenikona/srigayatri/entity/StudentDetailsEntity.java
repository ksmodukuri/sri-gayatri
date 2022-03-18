package com.katrenikona.srigayatri.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_DETAILS")
public class StudentDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private long id;
	
	@Column(name="ADMISSION_NUMBER")
	private String admissionNumber;
	
	@Column(name="STUDENT_FIRST_NAME")
	private String studentFirstName;
	
	@Column(name="DATE_OF_JOINING")
	private String dateOfJoining;
	
	@Column(name="STUDENT_LAST_NAME")
	private String studentLastName;
	
	@Column(name="STUDENT_AADHAR")
	private String aadhar;
	
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	@Column(name="MOTHER_NAME")
	private String motherName;
	
	@Column(name="FATHER_AADHAR")
	private String fatherAadhar;
	
	@Column(name="MOTHER_AADHAR")
	private String motherAadhar;
	
	@Column(name="RATION_CARD_NUMBER")
	private String rationCardNumber;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="PREVIOUS_SCHOOL_NAME")
	private String previousSchoolName;
	
	@Column(name="CLASS_ADMISSION")
	private String std;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="ADDRESS3")
	private String address3;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="RELIGION")
	private String religion;
	
	@Column(name="CASTE")
	private String caste;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="MOLE1")
	private String mole1;
	
	@Column(name="MOLE2")
	private String mole2;
	
	@OneToOne(mappedBy="student")
	private FeesEntity feesEntity;
	
	@OneToMany(mappedBy="student")
	private Set<MarksEntity> marksEntity;
	
	public Set<MarksEntity> getMarksEntity() {
		return marksEntity;
	}

	public void setMarksEntity(Set<MarksEntity> marksEntity) {
		this.marksEntity = marksEntity;
	}

	public FeesEntity getFeesEntity() {
		return feesEntity;
	}

	public void setFeesEntity(FeesEntity feesEntity) {
		this.feesEntity = feesEntity;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(String admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public String getMole1() {
		return mole1;
	}

	public void setMole1(String mole1) {
		this.mole1 = mole1;
	}

	public String getMole2() {
		return mole2;
	}

	public void setMole2(String mole2) {
		this.mole2 = mole2;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="GENDER")
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherAadhar() {
		return fatherAadhar;
	}

	public void setFatherAadhar(String fatherAadhar) {
		this.fatherAadhar = fatherAadhar;
	}

	public String getMotherAadhar() {
		return motherAadhar;
	}

	public void setMotherAadhar(String motherAadhar) {
		this.motherAadhar = motherAadhar;
	}

	public String getRationCardNumber() {
		return rationCardNumber;
	}

	public void setRationCardNumber(String rationCardNumber) {
		this.rationCardNumber = rationCardNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPreviousSchoolName() {
		return previousSchoolName;
	}

	public void setPreviousSchoolName(String previousSchoolName) {
		this.previousSchoolName = previousSchoolName;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
