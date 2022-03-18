package com.katrenikona.srigayatri.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.katrenikona.srigayatri.object.Fees;
import com.katrenikona.srigayatri.object.Marks;
import com.katrenikona.srigayatri.object.MarksData;
import com.katrenikona.srigayatri.object.Student;
import com.katrenikona.srigayatri.object.StudentData;
import com.katrenikona.srigayatri.service.FeesService;
import com.katrenikona.srigayatri.service.MarksService;
import com.katrenikona.srigayatri.service.StudentService;
import com.katrenikona.srigayatri.utils.SriGayatriUtils;

@Controller
public class MainController extends BaseController{
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private FeesService feesService;
	
	@Autowired
	private MarksService marksService;

	@GetMapping("/")
	public String getHomePage(ModelMap model) {
		return "dashboard";
	}
	
	@GetMapping("/dashboard")
	public String getDashboard(ModelMap model) {
		return "dashboard";
	}

	@GetMapping("/newAdmission")
	public String getNewAdmission(ModelMap model) {
		model.put("newStudent", new Student());
		return "newAdmission";
	}
	
	@PostMapping("/newAdmission")
	public String postNewAdmission(@Valid Student student, BindingResult bindingResult) {
		
			if (bindingResult.hasErrors()) {
				for (FieldError erro : bindingResult.getFieldErrors()) {
					System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
				}
			  return "error";
			}else {
				if(ukgList.contains(student.getStd())) {
					ukgAdmissionNumber++;
					student.setAdmissionNumber("UKG"+ukgAdmissionNumber);
				}else if(lkgList.contains(student.getStd())) {
					lkgAdmissionNumber++;
					student.setAdmissionNumber("UKG"+lkgAdmissionNumber);
				}
				studentService.createNewStudent(student);
			}
			
		return "success";
	}
	
	@GetMapping("/feesPayment")
	public String getFeesPayment(ModelMap model) {
		return "feesPayment";
	}
	
	@GetMapping("/getFeesDetails")
	public @ResponseBody Fees getFeesDetails(@RequestParam String admnNo) {
		return feesService.getFeesPaymentDetails(admnNo);
	}
	
	@PostMapping("/feesPayment")
	public String postFeesPayment(@Valid Fees feesPayment, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError erro : bindingResult.getFieldErrors()) {
				System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
			}
		  return "error";
		  }else {
			  feesService.updateFees(feesPayment);
			  return "success";
		  }
	}
	
	@GetMapping("/promoteStudentsPage")
	public String getPromoteStudentsPage(ModelMap model) {
		return "promotingStudents";
	}
	
	@GetMapping("/promoteStudents")
	public @ResponseBody String postPromoteStudentsPage(@RequestParam String fromClass,@RequestParam String toClass) {
		return studentService.promoteStudents(fromClass,toClass);
	}
	
	@GetMapping("/marksEnter")
	public String getPromoteStudentsPage() {
		return "marksEnter";
	}
	
	@GetMapping("/viewMarksPage")
	public String getViewMarksPage() {
		return "viewMarksPage";
	}
	
	@GetMapping("/updateMarksPage")
	public String getUpdateMarksPage(@RequestParam long marksId,ModelMap model) {
		model.put("marksObject",marksService.getMarks(marksId));
		return "updateMarksPage";
	}
	
	@PostMapping("/updateMarksPage")
	public String postUpdateMarksPage(@Valid Marks marksObject,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError erro : bindingResult.getFieldErrors()) {
				System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
			}
		  return "error";
		  }else {
			  marksService.updateMarksByMarksId(marksObject);
			  return "viewMarksPage";
		  }
	}
	
	@PostMapping("/marksEnter")
	public String postPromoteStudentsPage(@Valid Marks marksEnterObject,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError erro : bindingResult.getFieldErrors()) {
				System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
			}
		  return "error";
		  }else {
			  marksService.updateMarks(marksEnterObject);
			  return "marksEnter";
		  }
		
	}
	
	@GetMapping("/showStudentsMarks")
	public @ResponseBody MarksData promoteStudents(
		@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
		@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
		@RequestParam(defaultValue = "firstName") String sortBy,
		@RequestParam(defaultValue = DEFAULT_ORDER) String asc, @RequestParam String std) {
	
		return marksService.getStudentsMarks(pageIndex, pageLimit, sortBy, asc, std);
	}
	
	@GetMapping("/viewMarks")
	public @ResponseBody MarksData getViewMarks(
		@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
		@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
		@RequestParam(defaultValue = "firstName") String sortBy,
		@RequestParam(defaultValue = DEFAULT_ORDER) String asc) {
	
		return marksService.getAllStudentsMarks(pageIndex, pageLimit, sortBy, asc);
	}
	@GetMapping("/viewMarks/search")
	public @ResponseBody MarksData getViewMarksByClass(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc,
			@RequestParam String fromClass) {
			SriGayatriUtils column = new SriGayatriUtils();
			sortBy = column.getString(sortBy);
			return marksService.getStudentsMarks(pageIndex, pageLimit, sortBy,asc,fromClass);
		
	}
	
	@GetMapping("/showStudentsMarks/search")
	public @ResponseBody MarksData getSearchStudentsMarksByAdmissionNumber(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc,
			@RequestParam String searchByAdmnNo) {
			SriGayatriUtils column = new SriGayatriUtils();
			sortBy = column.getString(sortBy);
			return marksService.getSearchStudentsMarksByAdmissionNumber(searchByAdmnNo,pageIndex, pageLimit, sortBy,asc);
		
	}
	
	@GetMapping("/studentsInfoTable")
	public String getStudentsDetails(ModelMap model) {
		return "studentsInfoTable";
	}
	
	@GetMapping("/getStudentSubjects")
	public @ResponseBody Marks getStudentsSubjects(@RequestParam String admnNo, ModelMap model) {
		
		
		return marksService.getStudentSubjects(admnNo);
	}
	
	@GetMapping("/studentsFeesInfoTable")
	public String getStudentsFeesDetails(ModelMap model) {
		return "studentsFeesInfoTable";
	}
	
	@GetMapping("/updateFeesDetails")
	public String getUpdateFeesDetails(@RequestParam long studentId,ModelMap model) {
		model.put("updateFees",feesService.getFeesDetails(studentId));
		return "updateFeesDetails";
	}
	
	@GetMapping("/updateStudentDetails")
	public String getUpdateStudentDetails(@RequestParam long studentId,ModelMap model) {
		model.put("updateStudent",studentService.getStudentDetails(studentId));
		return "updateStudentDetails";
	}
	
	@PostMapping("/updateStudentDetails")
	public String postUpdateStudentDetails(@Valid Student student, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError erro : bindingResult.getFieldErrors()) {
				System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
			}
		  return "error";
		}else {
			studentService.updateStudentDetails(student);
		}
		
		return "success";
	}
	
	@PostMapping("/updateFeesDetails")
	public String postUpdateFeesDetails(@Valid Fees fees, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError erro : bindingResult.getFieldErrors()) {
				System.out.println(erro.getObjectName()+" : "+erro.getField()+":"+erro.getDefaultMessage());
			}
		  return "error";
		}else {
			feesService.updateFees(fees);
		}
		
		return "success";
	}
	
	@GetMapping("/fees")
	public @ResponseBody StudentData getStudentsFees(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc) {
		
			return feesService.getStudentsFees(pageIndex, pageLimit, sortBy, asc);
	}
	
	@GetMapping("/fees/search")
	public @ResponseBody StudentData getSearchStudentsFees(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc,
			@RequestParam String searchByAdmnNo,@RequestParam String searchByName,@RequestParam String searchByClass) {
			SriGayatriUtils column = new SriGayatriUtils();
			sortBy = column.getString(sortBy);
			return feesService.getSearchStudentsFees(searchByAdmnNo,searchByName,searchByClass,pageIndex, pageLimit, sortBy,asc);
		
	}
	
	@GetMapping("/students")
	public @ResponseBody StudentData getStudents(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc) {
		
			return studentService.getStudents(pageIndex, pageLimit, sortBy, asc);
	}
	
	@GetMapping("/students/search")
	public @ResponseBody StudentData getSearchStudents(
			@RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageIndex, 
			@RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageLimit,
			@RequestParam(defaultValue = "firstName") String sortBy,
			@RequestParam(defaultValue = DEFAULT_ORDER) String asc,
			@RequestParam String searchByAdmnNo,@RequestParam String searchByName,@RequestParam String searchByClass) {
			SriGayatriUtils column = new SriGayatriUtils();
			sortBy = column.getString(sortBy);
			return studentService.getSearchStudents(searchByAdmnNo,searchByName,searchByClass,pageIndex, pageLimit, sortBy,asc);
		
	}
	
}
