package tests;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestDateFormatter {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFormatter() {
		SimpleDateFormat dateFormat = (SimpleDateFormat)DateFormat.getTimeInstance();
		a("HH:mm:ss",dateFormat.toPattern());
		dateFormat.applyPattern("hh:mma");
		Calendar calendar =Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		Date date =calendar.getTime();
		a("09:00AM",dateFormat.format(date));
	}

	private void a(String expected, String actual) {
		assertEquals(expected,actual);
	}


}
