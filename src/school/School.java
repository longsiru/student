package school;

import java.util.ArrayList;

public class School {
	//내부에 school 객체를 생성해 준다.
	private static School instance = new School();
	
	private static String SCHOOL_NAME = "Good School";   //학교이름
	private ArrayList<Student> studentList = new ArrayList<>();//학교에 등록한 학생
	private ArrayList<Subject> subjectList = new ArrayList<>();//학교에서 개설한 과목
	
	
	
	//singletone constructor is private  -> 외부에서 객체를 여러개 생성하면 안돼.
	private School() {};
	
	
	//singletone method 구현: school객체를 리턴해준다.
	public static School getInstance() {
		if(instance == null ) {
			instance = new School();
		}
		return instance;
	}
	
	
	//학생 입학
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	//학생 리스트 출력
	public ArrayList<Student> gteStudentList(){
		return studentList;
	}

	
	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}


	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
