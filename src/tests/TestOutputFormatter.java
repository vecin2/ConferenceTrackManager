package tests;

import static org.junit.Assert.assertEquals;
import main.core.ConferenceCalendar;
import main.core.LengthConstraint;
import main.core.OutputFormatter;
import main.core.Session;
import main.core.Talk;

import org.junit.Before;
import org.junit.Test;

public class TestOutputFormatter {
	private OutputFormatter formatter;

	@Before
	public void setup() {

		formatter = new OutputFormatter();
	}

	@Test
	public void testWriteTalk() {
		assertEquals(
				"09:00AM Writing Fast Tests Against Enterprise Rails 60min",
				formatter.formatTalk(new Talk(
						"Writing Fast Tests Against Enterprise Rails", 60)
						.setStartTime(ConferenceCalendar.makeTime(9, 0))));
	}

	@Test
	public void testWriteAnEmptySessionReturnsBlank() {
		Session session = new Session(9, LengthConstraint.maxLengthOf(100));

		assertEquals("", formatter.formatSession(session));
	}

	@Test
	public void testWriteASessionWithOneTalk() {
		Session session = new Session(9, LengthConstraint.maxLengthOf(100));
		session.schedule(new Talk("Communicating Over Distance", 60));

		assertEquals("09:00AM Communicating Over Distance 60min",
				formatter.formatSession(session));
	}

	@Test
	public void testFormatSession() {
		Session session = new Session(9, LengthConstraint.maxLengthOf(200));
		session.schedule(new Talk(
				"Writing Fast Tests Against Enterprise Rails", 60));
		session.schedule(new Talk("Overdoing it in Python", 45));
		session.schedule(new Talk("Lua for the Masses", 30));

		String result = "09:00AM Writing Fast Tests Against Enterprise Rails 60min\n"
				+ "10:00AM Overdoing it in Python 45min\n"
				+ "10:45AM Lua for the Masses 30min";
		assertEquals(result, formatter.formatSession(session));
	}

}
