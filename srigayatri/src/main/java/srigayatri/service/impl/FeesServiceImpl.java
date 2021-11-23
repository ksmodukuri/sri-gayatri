package srigayatri.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import srigayatri.entity.FeesEntity;
import srigayatri.entity.StudentDetailsEntity;
import srigayatri.object.Fees;
import srigayatri.object.Pagination;
import srigayatri.object.SortField;
import srigayatri.object.Student;
import srigayatri.object.StudentData;
import srigayatri.repository.FeesRepository;
import srigayatri.repository.StudentRepository;
import srigayatri.service.FeesService;

@Service
public class FeesServiceImpl extends BaseServiceImpl implements FeesService{
	
	@Autowired
	private FeesRepository feesRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void createNewStudentFees(Fees fees) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateFees(Fees fees) {
		FeesEntity feesEnt = feesRepository.getFeesDetailsById(fees.getId());
		feesEnt = updateFeesEntity(fees, feesEnt);
		feesRepository.save(feesEnt);	
	}
	
	@Override
	public StudentData getStudentsFees(Integer pageNumber, Integer pageSize, String sortBy, String asc) {
		List<SortField> sortFields = new ArrayList<SortField>();
		
		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = studentRepository.findAll(paging);

		StudentData students = new StudentData();
		Pagination pag = new Pagination();
		students.setPagination(pag);

		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> studentDetailsEntityList = pagedResult.getContent();

			for (StudentDetailsEntity studentEnt : studentDetailsEntityList) {
				Student student = getStudentObjectWithFees(studentEnt);
				students.addStudent(student);
			}
		}
//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return students;
	}

	@Override
	public StudentData getSearchStudentsFees(String searchByAdmnNo,String searchByName, String searchByClass, Integer pageNumber, Integer pageSize, String sortBy, String asc) {

		List<SortField> sortFields = new ArrayList<SortField>();

//		sortFields.add(new SortField("firstName"));
//		sortFields.add(new SortField("lastName"));
//		sortFields.add(new SortField("emailId"));

		Pageable paging = null;
		if (asc.equals("true")) {
			paging = PageRequest.of(pageNumber, pageSize);
		} else {
			paging = PageRequest.of(pageNumber, pageSize);
		}
		Page<StudentDetailsEntity> pagedResult = null;
		if (searchByAdmnNo != null && searchByName != null && searchByClass != null) {
			pagedResult = studentRepository.findStudentBySearch(searchByAdmnNo,searchByName,searchByClass, paging);
		} else {
			pagedResult = studentRepository.findAll(paging);
		}
		StudentData students = new StudentData();
		Pagination pag = new Pagination();
		students.setPagination(pag);
		System.out.println(pagedResult);
		if (pagedResult.hasContent()) {
			List<StudentDetailsEntity> userEntityList = pagedResult.getContent();

			for (StudentDetailsEntity studentEnt : userEntityList) {
				Student student = getStudentObjectWithFees(studentEnt);
				students.addStudent(student);
			}
		}

//		students.setSortFields(sortFields);
		pag.setIndex(paging.getPageNumber());
		pag.setCount(pagedResult.getTotalPages());
		pag.setTotalRecordCount(pagedResult.getTotalElements());
		pag.setLimit(paging.getPageSize());
		return students;
	}
	
	@Override
	public Fees getFeesDetails(long studentId) {
		StudentDetailsEntity studentEnt = studentRepository.findStudentById(studentId);
		Fees fees = new Fees();
		FeesEntity feesEnt = studentEnt.getFeesEntity();
		
		fees.setId(feesEnt.getId());
		fees.setOtherFees(feesEnt.getOtherFees());
		fees.setTermFour(feesEnt.getOtherFees());
		fees.setTermOne(feesEnt.getTermOneFees());
		fees.setTermThree(feesEnt.getTermThreeFees());
		fees.setTermTwo(feesEnt.getTermTwoFees());
		fees.setTotalFees(feesEnt.getTotalFees());
		fees.setExamFees(feesEnt.getExamFees());
		fees.setTransportationFees(feesEnt.getTransportationFees());
		fees.setAdmissionFees(feesEnt.getAdmissionFees());
		
		fees.setOtherPaid(feesEnt.getOtherPaid());
		fees.setTermFourPaid(feesEnt.getOtherPaid());
		fees.setTermOnePaid(feesEnt.getTermOnePaid());
		fees.setTermThreePaid(feesEnt.getTermThreePaid());
		fees.setTermTwoPaid(feesEnt.getTermTwoPaid());
		fees.setExamFeesPaid(feesEnt.getExamPaid());
		fees.setTransportationPaid(feesEnt.getTransportationPaid());
		fees.setTotalFeesPaid(feesEnt.getTotalFeesPaid());
		fees.setAdmissionPaid(feesEnt.getAdmissionPaid());
		
		fees.setOtherBal(feesEnt.getOtherBal());
		fees.setTermFourBal(feesEnt.getTermFourBal());
		fees.setTermOneBal(feesEnt.getTermOneBal());
		fees.setTermThreeBal(feesEnt.getTermThreeBal());
		fees.setTermTwoBal(feesEnt.getTermTwoBal());
		fees.setExamFeesBal(feesEnt.getExamBal());
		fees.setTransportationBal(feesEnt.getTransportationBal());
		fees.setAdmissionBal(feesEnt.getAdmissionBal());
		fees.setTotalBalFees(feesEnt.getTotalFeesBal());
		fees.setStudentName(studentEnt.getStudentFirstName() + " " + studentEnt.getStudentLastName());
		
		return fees;
	}

	@Override
	public Fees getFeesPaymentDetails(String admnNo) {
		StudentDetailsEntity studentEnt = studentRepository.findStudentByAdmnNo(admnNo);
		Fees fees = new Fees();
		FeesEntity feesEnt = studentEnt.getFeesEntity();
		
		fees.setId(feesEnt.getId());
		fees.setOtherFees(feesEnt.getOtherFees());
		fees.setTermFour(feesEnt.getOtherFees());
		fees.setTermOne(feesEnt.getTermOneFees());
		fees.setTermThree(feesEnt.getTermThreeFees());
		fees.setTermTwo(feesEnt.getTermTwoFees());
		fees.setTotalFees(feesEnt.getTotalFees());
		fees.setExamFees(feesEnt.getExamFees());
		fees.setTransportationFees(feesEnt.getTransportationFees());
		fees.setAdmissionFees(feesEnt.getAdmissionFees());
		
		fees.setOtherPaid(feesEnt.getOtherPaid());
		fees.setTermFourPaid(feesEnt.getOtherPaid());
		fees.setTermOnePaid(feesEnt.getTermOnePaid());
		fees.setTermThreePaid(feesEnt.getTermThreePaid());
		fees.setTermTwoPaid(feesEnt.getTermTwoPaid());
		fees.setExamFeesPaid(feesEnt.getExamPaid());
		fees.setTransportationPaid(feesEnt.getTransportationPaid());
		fees.setTotalFeesPaid(feesEnt.getTotalFeesPaid());
		fees.setAdmissionPaid(feesEnt.getAdmissionPaid());
		
		fees.setOtherBal(feesEnt.getOtherBal());
		fees.setTermFourBal(feesEnt.getTermFourBal());
		fees.setTermOneBal(feesEnt.getTermOneBal());
		fees.setTermThreeBal(feesEnt.getTermThreeBal());
		fees.setTermTwoBal(feesEnt.getTermTwoBal());
		fees.setExamFeesBal(feesEnt.getExamBal());
		fees.setTransportationBal(feesEnt.getTransportationBal());
		fees.setAdmissionBal(feesEnt.getAdmissionBal());
		fees.setTotalBalFees(feesEnt.getTotalFeesBal());
		fees.setStudentName(studentEnt.getStudentFirstName() + " " + studentEnt.getStudentLastName());
		
		return fees;
	}

	

	

	

}
