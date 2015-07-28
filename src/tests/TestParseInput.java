package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;


import main.core.InputParser;
import main.core.Talk;
import static main.core.Talk.*;

import org.junit.Before;
import org.junit.Test;


public class TestParseInput {
	
	private InputParser parser;
	@Before 
	public void setup(){		
		parser = new InputParser();
	}

	@Test
	public void testParseTalkWithMin() {
		String talk ="Fast Tests Against Enterprise Rails 60min";
		assertEquals(toList(new Talk("Fast Tests Against Enterprise Rails", 60)), parser.parseInput(talk));
	}


	@Test
	public void testParseTalkWithLighting() {
		String talk ="Rails for Python Developers lightning";
		assertEquals(toList(new Talk("Rails for Python Developers", 5)), parser.parseInput(talk));
	}
	@Test
	public void testParseListOfTalks() {
		String talk ="Writing Fast Tests Against Enterprise Rails 60min\nOverdoing it in Python 45min";
		ArrayList<Talk>talks = new ArrayList<Talk>();
		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails", 60));
		talks.add(new Talk("Overdoing it in Python", 45));
		assertEquals(talks, parser.parseInput(talk));
	}
	
	
	
}
