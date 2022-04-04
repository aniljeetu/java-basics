package javalang.basics.collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ExchangeIndicatorTest {

	@Test
	void testIsEqualExchangeIndicator() {
		ExchangeIndicator ex = new ExchangeIndicator();

		//PPT On and Admin On Exchange
		assertTrue(ex.isEqualExchangeIndicator("On", "On Exchange"));
		//PPT On and Admin Off Exchange
		assertFalse(ex.isEqualExchangeIndicator("On", "Off Exchange"));
		//PPT Yes and Admin On Exchange
		assertTrue(ex.isEqualExchangeIndicator("Yes", "On Exchange"));
		//PPT Yes and Admin Off Exchange
		assertFalse(ex.isEqualExchangeIndicator("Yes", "Off Exchange"));
		//PPT null and Admin On Exchange
		assertFalse(ex.isEqualExchangeIndicator(null, "On Exchange"));
		//PPT null and Admin Off Exchange
		assertFalse(ex.isEqualExchangeIndicator(null, "Off Exchange"));

		//PPT On and Admin On
		assertTrue(ex.isEqualExchangeIndicator("On", "On"));
		//PPT On and Admin No
		assertFalse(ex.isEqualExchangeIndicator("On", "No"));
		//PPT Yes and Admin On
		assertTrue(ex.isEqualExchangeIndicator("Yes", "On"));
		//PPT Yes and Admin No
		assertFalse(ex.isEqualExchangeIndicator("Yes", "No"));
		//PPT null and Admin On
		assertFalse(ex.isEqualExchangeIndicator(null, "On"));
		//PPT null and Admin No
		assertFalse(ex.isEqualExchangeIndicator(null, "No"));
		
		//PPT On and Admin null
		assertFalse(ex.isEqualExchangeIndicator("On", null));
		//PPT Yes and Admin null
		assertFalse(ex.isEqualExchangeIndicator("Yes", null));
		//PPT null and Admin null
		assertTrue(ex.isEqualExchangeIndicator(null, null));
	}
	
	@Test
	void test() {
		ExchangeIndicator ex = new ExchangeIndicator();

		//PPT On and Admin {"On", "Yes", "On Exchange"}
		assertTrue(ex.containsExchangeIndicator(Arrays.asList("On", "Yes", "On Exchange"), "On"));
		//PPT On and Admin {"Off", "No", "Off Exchange"}
		assertFalse(ex.containsExchangeIndicator(Arrays.asList("Off", "No", "Off Exchange"), "On"));
		//PPT Yes and Admin {"On", "Yes", "On Exchange"}
		assertTrue(ex.containsExchangeIndicator(Arrays.asList("On", "Yes", "On Exchange"), "Yes"));
		//PPT Yes and Admin {"Off", "No", "Off Exchange"}
		assertFalse(ex.containsExchangeIndicator(Arrays.asList("Off", "No", "Off Exchange"), "Yes"));
		//PPT null and Admin {"On", "Yes", "On Exchange"}
		assertFalse(ex.containsExchangeIndicator(Arrays.asList("Off", "No", "Off Exchange"), null));
		//PPT null and Admin {"Off", "No", "Off Exchange"}
		assertFalse(ex.containsExchangeIndicator(Arrays.asList("Off", "No", "Off Exchange"), null));
		//PPT null and Admin {"Off", "No", "Off Exchange", null}
		assertTrue(ex.containsExchangeIndicator(Arrays.asList("Off", "No", "Off Exchange", null), null));
	}

}
