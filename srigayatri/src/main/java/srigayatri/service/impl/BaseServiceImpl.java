package srigayatri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import srigayatri.entity.FeesEntity;
import srigayatri.entity.MarksEntity;
import srigayatri.entity.StudentDetailsEntity;
import srigayatri.object.Fees;
import srigayatri.object.Marks;
import srigayatri.object.Student;
import srigayatri.repository.MarksRepository;

public abstract class BaseServiceImpl {
	
	@Autowired
	private MarksRepository marksRepository;
	
	List<String> subjectList = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{
		add("Telugu");
		add("Hindi");
		add("English");
		add("Mathematics");
		add("Science");
		add("EVS/Social");
	}
	};
	List<String> lkgSubjectList = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("Telugu");
		add("Hindi");
		add("English");
		add("Mathematics");
		add("Science");
		add("EVS/Social");
		add("G.K.");
		add("Computer");
	}
	};
	
	List<String> examTypeList = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("FA1");
		add("FA2");
		add("SA1");
		add("FA3");
		add("FA4");
		add("SA2");
	}
	};
	
	List<String> classList = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
	{
		add("UKG");
		add("Ukg");
		add("uKg");
		add("ukG");
		add("UKg");
		add("UkG");
		add("uKG");
		add("ukg");
		add("1");
		add("2");
		add("3");
		add("4");
		add("5");
		add("6");
		add("7");
		add("8");
		add("9");
		add("10");
	}
	};
	
	public Student getStudentObject(StudentDetailsEntity studentEnt) {
		Student student = new Student();
		student.setId(studentEnt.getId());
		student.setAadhar(studentEnt.getAadhar());
		student.setAddress1(studentEnt.getAddress1());
		student.setAddress2(studentEnt.getAddress2());
		student.setAddress3(studentEnt.getAddress3());
		student.setAdmissionNumber(studentEnt.getAdmissionNumber());
		student.setCaste(studentEnt.getCaste());
		student.setCategory(studentEnt.getCategory());
		student.setDateOfJoining(studentEnt.getDateOfJoining());
		student.setDob(studentEnt.getDob());
		student.setFatherAadhar(studentEnt.getFatherAadhar());
		student.setFatherName(studentEnt.getFatherName());
		student.setGender(studentEnt.getGender());
		student.setMobileNumber(studentEnt.getMobileNumber());
		student.setMole1(studentEnt.getMole1());
		student.setMole2(studentEnt.getMole2());
		student.setMotherAadhar(studentEnt.getMotherAadhar());
		student.setMotherName(studentEnt.getMotherName());
		student.setPreviousSchoolName(studentEnt.getPreviousSchoolName());
		student.setRationCardNumber(studentEnt.getRationCardNumber());
		student.setReligion(studentEnt.getReligion());
		student.setStd(studentEnt.getStd());
		student.setStudentFirstName(studentEnt.getStudentFirstName());
		student.setStudentLastName(studentEnt.getStudentLastName());
		student.setStudentName(studentEnt.getStudentFirstName() + " " + studentEnt.getStudentLastName());
		return student;
	}
	
	public Student getStudentObjectWithFees(StudentDetailsEntity studentEnt) {
		
		Student student = new Student();
		student.setId(studentEnt.getId());
		student.setAadhar(studentEnt.getAadhar());
		student.setAddress1(studentEnt.getAddress1());
		student.setAddress2(studentEnt.getAddress2());
		student.setAddress3(studentEnt.getAddress3());
		student.setAdmissionNumber(studentEnt.getAdmissionNumber());
		student.setCaste(studentEnt.getCaste());
		student.setCategory(studentEnt.getCategory());
		student.setDateOfJoining(studentEnt.getDateOfJoining());
		student.setDob(studentEnt.getDob());
		student.setFatherAadhar(studentEnt.getFatherAadhar());
		student.setFatherName(studentEnt.getFatherName());
		student.setGender(studentEnt.getGender());
		student.setMobileNumber(studentEnt.getMobileNumber());
		student.setMole1(studentEnt.getMole1());
		student.setMole2(studentEnt.getMole2());
		student.setMotherAadhar(studentEnt.getMotherAadhar());
		student.setMotherName(studentEnt.getMotherName());
		student.setPreviousSchoolName(studentEnt.getPreviousSchoolName());
		student.setRationCardNumber(studentEnt.getRationCardNumber());
		student.setReligion(studentEnt.getReligion());
		student.setStd(studentEnt.getStd());
		student.setStudentFirstName(studentEnt.getStudentFirstName());
		student.setStudentLastName(studentEnt.getStudentLastName());
		student.setStudentName(studentEnt.getStudentFirstName() + " " + studentEnt.getStudentLastName());
		
		Fees fees = new Fees();
		FeesEntity feesEnt = studentEnt.getFeesEntity();
		
		fees.setOtherFees(feesEnt.getOtherFees());
		fees.setTermFour(feesEnt.getTermFourFees());
		fees.setTermOne(feesEnt.getTermOneFees());
		fees.setTermThree(feesEnt.getTermThreeFees());
		fees.setTermTwo(feesEnt.getTermTwoFees());
		fees.setTotalFees(feesEnt.getTotalFees());
		fees.setExamFees(feesEnt.getExamFees());
		fees.setAdmissionFees(feesEnt.getAdmissionFees());
		fees.setTransportationFees(feesEnt.getTransportationFees());
		
		fees.setOtherPaid(feesEnt.getOtherPaid());
		fees.setTermFourPaid(feesEnt.getTermFourPaid());
		fees.setTermOnePaid(feesEnt.getTermOnePaid());
		fees.setTermThreePaid(feesEnt.getTermThreePaid());
		fees.setTermTwoPaid(feesEnt.getTermTwoPaid());
		fees.setExamFeesPaid(feesEnt.getExamPaid());
		fees.setTransportationPaid(feesEnt.getTransportationPaid());
		fees.setAdmissionPaid(feesEnt.getAdmissionPaid());
		fees.setTotalFeesPaid(feesEnt.getTotalFeesPaid());
		
		fees.setOtherBal(feesEnt.getOtherBal());
		fees.setTermFourBal(feesEnt.getTermFourBal());
		fees.setTermOneBal(feesEnt.getTermOneBal());
		fees.setTermThreeBal(feesEnt.getTermThreeBal());
		fees.setTermTwoBal(feesEnt.getTermTwoBal());
		fees.setExamFeesBal(feesEnt.getExamBal());
		fees.setAdmissionBal(feesEnt.getAdmissionBal());
		fees.setTransportationBal(feesEnt.getTransportationBal());
		fees.setTotalBalFees(feesEnt.getTotalFeesBal());
		
		student.setFees(fees);
		return student;
	}
	
	
	public StudentDetailsEntity getStudentDetailsEntity(Student student,StudentDetailsEntity studentEnt) {
		studentEnt.setAadhar(student.getAadhar());
		studentEnt.setAddress1(student.getAddress1());
		studentEnt.setAddress2(student.getAddress2());
		studentEnt.setAddress3(student.getAddress3());
		studentEnt.setAdmissionNumber(student.getAdmissionNumber());
		studentEnt.setCaste(student.getCaste());
		studentEnt.setCategory(student.getCategory());
		studentEnt.setDateOfJoining(student.getDateOfJoining());
		studentEnt.setDob(student.getDob());
		studentEnt.setFatherAadhar(student.getFatherAadhar());
		studentEnt.setFatherName(student.getFatherName());
		studentEnt.setGender(student.getGender());
		studentEnt.setMobileNumber(student.getMobileNumber());
		studentEnt.setMole1(student.getMole1());
		studentEnt.setMole2(student.getMole2());
		studentEnt.setMotherAadhar(student.getMotherAadhar());
		studentEnt.setMotherName(student.getMotherName());
		studentEnt.setPreviousSchoolName(student.getPreviousSchoolName());
		studentEnt.setRationCardNumber(student.getRationCardNumber());
		studentEnt.setReligion(student.getReligion());
		studentEnt.setStd(student.getStd());
		studentEnt.setStudentFirstName(student.getStudentFirstName());
		studentEnt.setStudentLastName(student.getStudentLastName());
		return studentEnt;
	}
	
	public FeesEntity getFeesEntity(Student student,FeesEntity feesEnt) {
		
		feesEnt.setOtherFees(student.getOtherFees());
		feesEnt.setTermFourFees(student.getTermFour());
		feesEnt.setTermOneFees(student.getTermOne());
		feesEnt.setTermThreeFees(student.getTermThree());
		feesEnt.setTermTwoFees(student.getTermTwo());
		feesEnt.setTotalFees(student.getTotalFees());
		feesEnt.setExamFees(student.getExamFees());
		feesEnt.setAdmissionFees(student.getAdmissionFees());
		feesEnt.setTransportationFees(student.getTransportationFees());
		
		feesEnt.setOtherBal(student.getOtherFees());
		feesEnt.setTermFourBal(student.getTermFour());
		feesEnt.setTermOneBal(student.getTermOne());
		feesEnt.setTermThreeBal(student.getTermThree());
		feesEnt.setTermTwoBal(student.getTermTwo());
		feesEnt.setExamBal(student.getExamFees());
		feesEnt.setAdmissionBal(student.getAdmissionFees());
		feesEnt.setTransportationBal(student.getTransportationFees());
		feesEnt.setTotalFeesBal(student.getTotalFees());
		return feesEnt;
	}
	
	public FeesEntity getFeesEntityWithPaidFees(Student student,StudentDetailsEntity studentEnt) {
		FeesEntity feesEnt = studentEnt.getFeesEntity();
		feesEnt.setOtherFees(student.getOtherFees());
		feesEnt.setTermFourFees(student.getTermFour());
		feesEnt.setTermOneFees(student.getTermOne());
		feesEnt.setTermThreeFees(student.getTermThree());
		feesEnt.setTermTwoFees(student.getTermTwo());
		feesEnt.setTotalFees(student.getTotalFees());
		feesEnt.setExamFees(student.getExamFees());
		feesEnt.setAdmissionFees(student.getAdmissionFees());
		feesEnt.setTransportationFees(student.getTransportationFees());
		
		feesEnt.setAdmissionPaid(student.getAdmissionPaid());
		feesEnt.setOtherPaid(student.getOtherPaid());
		feesEnt.setTermFourPaid(student.getTermFourPaid());
		feesEnt.setTermOnePaid(student.getTermOnePaid());
		feesEnt.setTermThreePaid(student.getTermThreePaid());
		feesEnt.setTermTwoPaid(student.getTermTwoPaid());
		feesEnt.setTotalFeesPaid(student.getTotalFeesPaid());
		feesEnt.setExamPaid(student.getExamFeesPaid());
		feesEnt.setTransportationPaid(student.getTransportationPaid());
		
		feesEnt.setOtherBal(student.getOtherFees());
		feesEnt.setTermFourBal(student.getTermFour());
		feesEnt.setTermOneBal(student.getTermOne());
		feesEnt.setTermThreeBal(student.getTermThree());
		feesEnt.setTermTwoBal(student.getTermTwo());
		feesEnt.setExamBal(student.getExamFees());
		feesEnt.setAdmissionBal(student.getAdmissionBal());
		feesEnt.setTransportationBal(student.getTransportationFees());
		feesEnt.setTotalFeesBal(student.getTotalFees());
		
		return feesEnt;
	}

	public FeesEntity updateFeesEntity(Fees fees,FeesEntity feesEnt) {
		feesEnt.setAdmissionPaid(fees.getAdmissionPaid());
		feesEnt.setOtherPaid(fees.getOtherPaid());
		feesEnt.setTermFourPaid(fees.getTermFourPaid());
		feesEnt.setTermOnePaid(fees.getTermOnePaid());
		feesEnt.setTermThreePaid(fees.getTermThreePaid());
		feesEnt.setTermTwoPaid(fees.getTermTwoPaid());
		feesEnt.setTotalFeesPaid(fees.getTotalFeesPaid());
		feesEnt.setTransportationPaid(fees.getTransportationPaid());
		
		feesEnt.setTotalFeesBal(0);
		feesEnt.setAdmissionBal(0);
		feesEnt.setOtherBal(0);
		feesEnt.setTermFourBal(0);
		feesEnt.setTermOneBal(0);
		feesEnt.setTermThreeBal(0);
		feesEnt.setTermTwoBal(0);
		feesEnt.setTransportationBal(0);
		
		return feesEnt;
	}
	
	public Marks getMarksObject(MarksEntity marksEnt) {
		Marks marks = new Marks();
		marks.setAdmissionNumber(marksEnt.getStudent().getAdmissionNumber());
		marks.setMarksId(marksEnt.getId());
		marks.setStd(marksEnt.getStudent().getStd());
		marks.setStudentName(marksEnt.getStudent().getStudentFirstName() + " " + marksEnt.getStudent().getStudentLastName());
		marks.setAggregate(marksEnt.getAggregate());
		marks.setfA1(marksEnt.getFA1());
		marks.setfA1Grade(marksEnt.getfA1Grade());
		marks.setfA2(marksEnt.getFA2());
		marks.setfA2Grade(marksEnt.getfA2Grade());
		marks.setsA1(marksEnt.getSA1());
		marks.setsA1Grade(marksEnt.getsA1Grade());
		marks.setfA3(marksEnt.getFA3());
		marks.setfA3Grade(marksEnt.getfA3Grade());
		marks.setfA4(marksEnt.getFA4());
		marks.setfA4Grade(marksEnt.getfA4Grade());
		marks.setsA2(marksEnt.getSA2());
		marks.setsA2Grade(marksEnt.getsA2Grade());
		marks.setSubject(marksEnt.getSubject());
		return marks;
	}
	
	public void saveMarksEntity(StudentDetailsEntity studentEnt) {
		if(classList.contains(studentEnt.getStd())) {
			for(String subject : subjectList) {
				MarksEntity marksEnt = new MarksEntity();
				marksEnt.setSubject(subject);
				marksEnt.setFA1(0);
				marksEnt.setFA2(0);
				marksEnt.setFA3(0);
				marksEnt.setFA4(0);
				marksEnt.setSA1(0);
				marksEnt.setSA2(0);
				marksEnt.setfA1Grade(0);
				marksEnt.setfA2Grade(0);
				marksEnt.setfA3Grade(0);
				marksEnt.setfA4Grade(0);
				marksEnt.setsA1Grade(0);
				marksEnt.setsA2Grade(0);
				marksEnt.setStudent(studentEnt);
				marksRepository.save(marksEnt);
			}
		}else {
			for(String subject : lkgSubjectList) {
				MarksEntity marksEnt = new MarksEntity();
				marksEnt.setSubject(subject);
				marksEnt.setFA1(0);
				marksEnt.setFA2(0);
				marksEnt.setFA3(0);
				marksEnt.setFA4(0);
				marksEnt.setSA1(0);
				marksEnt.setSA2(0);
				marksEnt.setfA1Grade(0);
				marksEnt.setfA2Grade(0);
				marksEnt.setfA3Grade(0);
				marksEnt.setfA4Grade(0);
				marksEnt.setsA1Grade(0);
				marksEnt.setsA2Grade(0);
				marksEnt.setStudent(studentEnt);
				marksRepository.save(marksEnt);
			}
			
		}
	}

}
