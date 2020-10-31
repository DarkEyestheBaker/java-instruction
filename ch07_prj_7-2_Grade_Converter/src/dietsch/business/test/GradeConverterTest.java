package dietsch.business.test;

import org.junit.jupiter.api.Test;

import dietsch.business.Grade;

class GradeConverterTest {

	@Test
	void testLetterGradeA() {
		Grade gradeA = new Grade(88);

		assertEquals("A", gradeA.getLetter());

	}

	@Test
	void testLetterGradeF() {
		Grade gradeF = new Grade(50);
		assertEquals("F", gradeF.getLetter());
	}
}
