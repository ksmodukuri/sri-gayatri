package srigayatri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FEES_ENTITY")
public class FeesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEES_ID")
	private long id;
	
	@Column(name = "ADMISSION_FEES")
	private int admissionFees;
	
	@Column(name = "TERM_ONE_FEES")
	private int termOneFees;
	
	@Column(name = "TERM_TWO_FEES")
	private int termTwoFees;
	
	@Column(name = "TERM_THREE_FEES")
	private int termThreeFees;
	
	@Column(name = "TERM_FOUR_FEES")
	private int termFourFees;
	
	@Column(name = "TRANSPORTATION_FEES")
	private int transportationFees;
	
	@Column(name = "OTHER_FEES")
	private int otherFees;
	
	@Column(name = "EXAM_FEES")
	private int examFees;
	
	@Column(name = "TOTAL_FEES")
	private int totalFees;
	
	@Column(name = "ADMISSION_PAID")
	private int admissionPaid;
	
	@Column(name = "TERM_ONE_PAID")
	private int termOnePaid; 
	
	@Column(name = "TERM_TWO_PAID")
	private int termTwoPaid;
	
	@Column(name = "TERM_THREE_PAID")
	private int termThreePaid;
	
	@Column(name = "TERM_FOUR_PAID")
	private int termFourPaid;
	
	@Column(name = "TRANSPORTATION_PAID")	
	private int transportationPaid;
	
	@Column(name = "OTHER_PAID")
	private int otherPaid;
	
	@Column(name = "EXAM_PAID")
	private int examPaid;
	
	@Column(name = "TOTAL_FEES_PAID")
	private int totalFeesPaid;
	
	@Column(name = "ADMISSION_BAL")
	private int admissionBal;
	
	@Column(name = "TERM_ONE_BAL")
	private int termOneBal; 
	
	@Column(name = "TERM_TWO_BAL")
	private int termTwoBal;
	
	@Column(name = "TERM_THREE_BAL")
	private int termThreeBal;
	
	@Column(name = "TERM_FOUR_BAL")
	private int termFourBal;
	
	@Column(name = "TRANSPORTATION_BAL")	
	private int transportationBal;
	
	@Column(name = "OTHER_BAL")
	private int otherBal;
	
	@Column(name = "EXAM_BAL")
	private int examBal;
	
	@Column(name="TOTAL_FEES_BAL")
	private int totalFeesBal;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private StudentDetailsEntity student;

	public int getAdmissionPaid() {
		return admissionPaid;
	}

	public void setAdmissionPaid(int admissionPaid) {
		this.admissionPaid = admissionPaid;
	}

	public int getAdmissionBal() {
		return admissionBal;
	}

	public void setAdmissionBal(int admissionBal) {
		this.admissionBal = admissionFees-admissionPaid;
	}

	public int getAdmissionFees() {
		return admissionFees;
	}

	public void setAdmissionFees(int admissionFees) {
		this.admissionFees = admissionFees;
	}

	public int getExamFees() {
		return examFees;
	}

	public void setExamFees(int examFees) {
		this.examFees = examFees;
	}

	public int getExamPaid() {
		return examPaid;
	}

	public void setExamPaid(int examPaid) {
		this.examPaid = examPaid;
	}

	public int getExamBal() {
		return examBal;
	}

	public void setExamBal(int examBal) {
		this.examBal = examBal;
	}

	public int getTotalFeesPaid() {
		return totalFeesPaid;
	}

	public void setTotalFeesPaid(int totalFeesPaid) {
		this.totalFeesPaid = totalFeesPaid;
	}

	public int getTermOnePaid() {
		return termOnePaid;
	}

	public void setTermOnePaid(int termOnePaid) {
		this.termOnePaid = termOnePaid;
	}

	public int getTermTwoPaid() {
		return termTwoPaid;
	}

	public void setTermTwoPaid(int termTwoPaid) {
		this.termTwoPaid = termTwoPaid;
	}

	public int getTermThreePaid() {
		return termThreePaid;
	}

	public void setTermThreePaid(int termThreePaid) {
		this.termThreePaid = termThreePaid;
	}

	public int getTermFourPaid() {
		return termFourPaid;
	}

	public void setTermFourPaid(int termFourPaid) {
		this.termFourPaid = termFourPaid;
	}

	public int getTransportationPaid() {
		return transportationPaid;
	}

	public void setTransportationPaid(int transportationPaid) {
		this.transportationPaid = transportationPaid;
	}

	public int getOtherPaid() {
		return otherPaid;
	}

	public void setOtherPaid(int otherPaid) {
		this.otherPaid = otherPaid;
	}

	public int getTermOneBal() {
		return termOneBal;
	}

	public void setTermOneBal(int termOneBal) {
		this.termOneBal = termOneFees - termOnePaid;
	}

	public int getTermTwoBal() {
		return termTwoBal;
	}

	public void setTermTwoBal(int termTwoBal) {
		this.termTwoBal = termTwoFees - termTwoPaid;
	}

	public int getTermThreeBal() {
		return termThreeBal;
	}

	public void setTermThreeBal(int termThreeBal) {
		this.termThreeBal = termThreeFees - termThreePaid;
	}

	public int getTermFourBal() {
		return termFourBal;
	}

	public void setTermFourBal(int termFourBal) {
		this.termFourBal = termFourFees - termFourPaid;
	}

	public int getTransportationBal() {
		return transportationBal;
	}

	public void setTransportationBal(int transportationBal) {
		this.transportationBal = transportationFees - transportationPaid;
	}

	public int getOtherBal() {
		return otherBal;
	}

	public void setOtherBal(int otherBal) {
		this.otherBal = otherFees - otherPaid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTermOneFees() {
		return termOneFees;
	}

	public void setTermOneFees(int termOneFees) {
		this.termOneFees = termOneFees;
	}

	public int getTermTwoFees() {
		return termTwoFees;
	}

	public void setTermTwoFees(int termTwoFees) {
		this.termTwoFees = termTwoFees;
	}

	public int getTermThreeFees() {
		return termThreeFees;
	}

	public void setTermThreeFees(int termThreeFees) {
		this.termThreeFees = termThreeFees;
	}

	public int getTermFourFees() {
		return termFourFees;
	}

	public void setTermFourFees(int termFourFees) {
		this.termFourFees = termFourFees;
	}

	public int getTransportationFees() {
		return transportationFees;
	}

	public void setTransportationFees(int transportationFees) {
		this.transportationFees = transportationFees;
	}

	public int getOtherFees() {
		return otherFees;
	}

	public void setOtherFees(int otherFees) {
		this.otherFees = otherFees;
	}

	public int getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}

	public int getTotalFeesBal() {
		return totalFeesBal;
	}

	public void setTotalFeesBal(int totalFeesBal) {
		this.totalFeesBal = totalFees - (termOnePaid + termTwoPaid + termThreePaid + termFourPaid + transportationPaid + otherPaid);
	}

	public StudentDetailsEntity getStudent() {
		return student;
	}

	public void setStudent(StudentDetailsEntity student) {
		this.student = student;
	}
	
}
