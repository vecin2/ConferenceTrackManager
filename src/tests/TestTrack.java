package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import main.core.ConferenceCalendar;
import main.core.Talk;
import main.core.Track;

import org.junit.Before;
import org.junit.Test;

public class TestTrack {
	private Track actualTrack;
	private ArrayList<Talk> talks;
	private Talk tdd;
	private Talk rugby;
	private ArrayList<Talk> expectedTalks;
	private Talk java;
	@Before
	public void setup(){
		actualTrack = Track.createDayTrack();
		talks = new ArrayList<Talk>();
		tdd = new Talk("TDD", 180);
		rugby = new Talk("Rugby", 60);
		java = new Talk("JAVA", 180);
		expectedTalks = new ArrayList<Talk>();
		
	}
	
	@Test
	public void testScheduleEmptyListScheduleNoTalks() {
		actualTrack.schedule(new ArrayList<Talk>());
		
		assertEquals(true, actualTrack.getTalks().isEmpty());
	}

	@Test
	public void testSchedulesInTheEarliestSpot() {
		talks.add(tdd);
		talks.add(rugby);
		talks.add(java);
		addExpectedTalk(tdd, 9,0);
		addExpectedTalk(rugby, 13,0);
		addExpectedTalk(java, 14,0);
		

		actualTrack.schedule(talks);
		
		assertEquals(expectedTalks, actualTrack.getTalks());
	}
	@Test
	public void testRescheduleTillItFindsPlanWhichFitsConstraints() {
		talks.add(rugby);
		talks.add(tdd);
		talks.add(java);
		addExpectedTalk(tdd, 9,0);
		addExpectedTalk(rugby, 13,0);
		addExpectedTalk(java, 14,0);
		

		actualTrack.schedule(talks);
		
		assertEquals(expectedTalks, actualTrack.getTalks());
	}



	private void addExpectedTalk(Talk talk, int hourOfDay, int minutes) {
		tdd.setStartTime(ConferenceCalendar.makeTime(hourOfDay, minutes));
		expectedTalks.add(talk);
	}
}
