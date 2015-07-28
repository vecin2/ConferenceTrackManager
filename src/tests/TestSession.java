package tests;

import static org.junit.Assert.assertEquals;
import main.core.ConferenceCalendar;
import main.core.LengthConstraint;
import main.core.Session;
import main.core.Talk;

import org.junit.Before;
import org.junit.Test;

public class TestSession {

	private Session session;
	@Before
	public void setup(){
		session = new Session(9, LengthConstraint.maxLengthOf(100));			
	}
	@Test
	public void testScheduleATalkSetsStartTimeInTalkAndAddIt() {
		Talk talk =new Talk("TDD", 80);
		assertEquals(true,session.schedule(talk));
		assertEquals(true,session.contains(talk));
		assertEquals(ConferenceCalendar.makeTime(9, 0),talk.getStartTime());
	}
	@Test
	public void testScheduleATalkBreakingConstraintReturnsFalseAndItDoesNotAddIt() {
		Talk talk =new Talk("TDD", 120);
		assertEquals(false,session.schedule(talk));
		assertEquals(false,session.contains(talk));
	}
	@Test
	public void testScheduleVariousBreaksConstraintIfSessionFull() {
		assertEquals(true,session.schedule(new Talk("TDD", 100)));
		assertEquals(false, session.schedule(new Talk("Pythong",20)));
	}
	@Test
	public void testScheduleTalksSetStartTimeAfterLastTalkAdded() {
		Talk talk = new Talk("TDD", 30);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(9, 0),talk.getStartTime());
		talk = new Talk("Advanced TDD", 30);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(9,30), talk.getStartTime());
		talk = new Talk("Ruby and Rails", 40);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(10,00), talk.getStartTime());
	}
	@Test
	public void testScheduleTalkInBetweenConstraintReturnsTrueTilItPassesTheMaxThreshold() {
		session = new Session(9, LengthConstraint.lengthBetween(180, 240));	
		Talk talk = new Talk("TDD", 30);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(9, 0),talk.getStartTime());
		talk = new Talk("Advanced TDD", 30);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(9,30), talk.getStartTime());
		talk = new Talk("Ruby and Rails", 40);
		session.schedule(talk);
		assertEquals(ConferenceCalendar.makeTime(10,00), talk.getStartTime());
	}

	

}
