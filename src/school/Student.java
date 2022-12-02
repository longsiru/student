package school;

import java.util.ArrayList;

public class Student {
	private int studentId;  //학생
	private String studentName; //이름
	private Subject majorSubject;  //필수과목
	//addSubjectScore()method 호출되면 이 리스트에 추가된.
	private ArrayList<Score> scoreList = new ArrayList<Score>();//학생이 수강한 과목의 점수 리스트.为什么要用<>：因为Score里面的变数有很多种type，用<>的话，会自动识别里面的类型，自动变形。想知道arraylist的长度的话，用SIZE
	
	public Student(int studentId, String studentName, Subject majorSubject) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.majorSubject = majorSubject;  //必修科目确认
	}  
	
	
	public void addSubjectScore(Score score) {
		scoreList.add(score);
	}

	//get,set method
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Subject getMajorSubject() {
		return majorSubject;
	}


	public void setMajorSubject(Subject majorSubject) {
		this.majorSubject = majorSubject;
	}


	public ArrayList<Score> getScoreList() {
		return scoreList;
	}


	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
