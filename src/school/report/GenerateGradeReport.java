package school.report;
import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;
public class GenerateGradeReport {
	// 필드
	School school = School.getInstance(); // school 싱글톤 객체 생성
	public static final String TITLE = "수강생 학점 \t\t\n";
	public static final String HEADER = "이름   	| 학번 	  | 필수과목  	|점수     	\n";
	public static final String LINE = "--------------------------------------------\n";
	/*
	 * StringBuffer:StringBuffer的特点：1、线程安全：不安全，存在同步操作同一数据的行为，效率高。安全的时候，没有同步操作，效率低。
	 * 								 2、StringBuffer是一个可变序列。
	 * 								 3、StringBuffer又被称为字符缓冲区，把它当成一个字符串去操作，只不过它与string相比是可以修改内容的。
	 * 								 4、在任何时间点，它包含着一些特定的字符序列，但是可以通过某些字符序列的长度和内容。
	 * StringBuffer与String的区别：1、StringBuffer的内容和长度都是可以改变的，String却不可以。
	 * 							2、String创建每一个字符串都会在常量池开辟一个新的空间。而StringBuffer会提前给出容量，可以重新进行字符串拼接，而不会重新开辟空间。
	 * 
	 */
	private StringBuffer buffer = new StringBuffer();
	
	
	// 성적 산출 결과의 헤더, 몸통, 푸터를 만들어준다.
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		for(Subject subject: subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
		}
		return buffer.toString(); //buffer의 데이터를 STRING타입으로 바꾼다.	
		}
	
	
	// 헤더를 만들어 준다.
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.LINE);
		buffer.append("\t" + subject.getSubjectName());
		buffer.append(GenerateGradeReport.TITLE);
		buffer.append(GenerateGradeReport.HEADER);
		buffer.append(GenerateGradeReport.LINE);
		
	}
	
	
	// 몸통을 만든다
	public void makeBody(Subject subject) {
		//학생 리스트를 가져온다.
		ArrayList<Student> studentList = subject.getStudentList();
		//想知道arraylist的长度的话，用SIZE
		for(int i = 0; i<studentList.size(); i++) {
			//获取INDEX号码位置相应得值
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append("\t| ");
			buffer.append(student.getStudentId());
			buffer.append("  |\t");
			buffer.append(student.getMajorSubject().getSubjectName());
			buffer.append("\t|  ");
			
			
			 //학생별 수강과목 학점 계산
			getScoreGrade(student, subject.getSubjectId()); 
			
			buffer.append("\n");
			buffer.append(LINE);
		}
	}
	
	//학생의 수강과목 점수와 학점을 얻어
	public void getScoreGrade(Student student, int subjectId) {
		//해당 학생이 수강한 과목의 점수 리스트(국어,수학)
		ArrayList<Score> scoreList = student.getScoreList();
		
		//해당학생의 필수과목의 과목코드
		int majorId = student.getMajorSubject().getSubjectId();
		 
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()}; 
		
		for(int i=0; i<scoreList.size(); i++) {
			Score score = scoreList.get(i);  //해당 과목의 점수를 받아온다.
			
			//과목코드가 같은지 확인
			if(score.getSubject().getSubjectId() == subjectId) {
				String grade; //학점
				
				if(score.getSubject().getSubjectId() == majorId) {
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());  //[Define.SAB_TYPE]:用这个的原因是GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), new MajorEvaluation()}; 这个数组的原因。
				}else {//일반과목일때 학점 산출
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint()); //gradeEvaluation[Define.AB_TYPE]  == new BasicEvaluation()
					
				}
				buffer.append(score.getPoint());
				buffer.append(":");
				buffer.append(grade);
				buffer.append(" | ");
				
			}
		}
		
		
	}
	
	// 푸터를 만든다.
	public void makeFooter() {
		buffer.append("\n"); // buffer += "\n";
	}
}