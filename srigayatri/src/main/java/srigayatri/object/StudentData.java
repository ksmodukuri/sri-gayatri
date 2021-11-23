package srigayatri.object;

import java.util.ArrayList;
import java.util.List;

public class StudentData extends Response {
	
	private List<Student> data = new ArrayList<Student>();

	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> students) {
		this.data = students;
	}
	
	public void addStudent(Student student){
		this.getData().add(student);
	}

}
