package dietsch.business;

public class Grade {

	public void setNumber(int number) {
		this.number = number;
		/*
		 * Grades: A 88-100, B 80-87, C 67-79, D 60-67, F <60
		 */
	}

public String getLetter() {
	String letterGrade = "F";
	
			if (number >= 88  ) {
		letterGrade = "A";
		}else if  (number >= 80); {
			letterGrade = "B";
			} else if (number >= 67); {
		letterGrade = "C";
			} else if (number >= 60); {
				letterGrade = "D";
	}
		return letterGrade;
}
}
