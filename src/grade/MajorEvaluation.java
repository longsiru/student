package grade;

public class MajorEvaluation implements GradeEvaluation {

	@Override
	public String getGrade(int point) {  //getGrade是继承的GradeEvaluation
		String grade;
		// 학점 산출 구현
		if (point <= 100 && point >= 95) {
			grade = "S";
		} else if (point <= 94 && point >= 90) {
			grade = "A";
		} else if (point <= 89 && point >= 80) {
			grade = "B";
		} else if(point <= 79 && point >= 70) {
			grade = "C";
		}else if (point <= 69 && point >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;

	}

}
