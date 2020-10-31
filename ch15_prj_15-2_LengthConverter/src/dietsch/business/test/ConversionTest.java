package dietsch.business.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dietsch.business.Conversion;

class ConversionTest {

	@Test
	void testMilestoFeet() {
		Conversion conversion = new Conversion("Miles", 1.0, "Feet", 5280.0);

		assertEquals(5280.0, conversion.getToValue());

	}

}
