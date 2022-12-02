package school;

public class Score {
	private int studentId;//학번
	private Subject subject;//과목
	private int point; //점수
	
	
	public Score(int studentId, Subject subject, int point) {
		this.studentId = studentId;
		this.subject = subject;
		this.point = point;
	}


	//Score객체가 가자고 있는 학번, 과목, 점수 정보를 리턴해준다
	/*
	 * Override(覆写)：发生在继承关系中，若子类中的方法和父类中的某一方法具有相同的方法名，返回类型和参数表，则新方法将覆盖原有的方法。
	 * 				 通过子类创建的实例对象调用这个方法时，将调用子类中的定义方法，这相当于把父类中定义的那个完全相同的方法给覆盖了。这也是面向对象编程的多态性的表现。
	 * 
	 * 这里涉及到为什么toString()需要重写：首先toString()可以把实体类，或者其他类，以字符串或规定的方式输出。但是默认的Object的toString方法打印出来的是一串看不懂的16进制
	 * 							   这时候我们就需要用override来重写toString，使其成为我们想要看懂的字符串等。
	 */
	@Override
	public String toString() {
		return "학번" + this.studentId + ", " + subject.getSubjectName() + ": " + point;
	}


	//get,set method
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public Subject getSubject() {
		return subject;
	}


	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
