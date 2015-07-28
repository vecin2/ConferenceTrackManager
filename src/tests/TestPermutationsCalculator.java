package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import main.core.PermutationsCalculator;

import org.junit.Before;
import org.junit.Test;


public class TestPermutationsCalculator {
	private PermutationsCalculator calculator;
	private ArrayList<ArrayList<Integer>> expected;

	@Before
	public void setup(){
		calculator = new PermutationsCalculator();
		expected = new ArrayList<ArrayList<Integer>>();
		
	}

	@Test
	public void testAllPermutationsOfZeroElements(){
		assertEquals(true, calculator.calculate(new ArrayList<Integer>()).isEmpty());
		
		
	}
	
	@Test
	public void testPermutationsOfTwoElements(){
		expected.add(createList(1,2));
		expected.add(createList(2,1));
		
		assertEquals(expected, calculator.calculate(createList(1,2)));
	}
	@Test
	public void testAllPermutationsOfThreeElements(){
		expected.add(createList(1,2,3));
		expected.add(createList(1,3,2));
		expected.add(createList(2,1,3));
		expected.add(createList(2,3,1));
		expected.add(createList(3,1,2));
		expected.add(createList(3,2,1));
		
		assertEquals(expected, calculator.calculate(createList(1,2,3)));
	}

	private ArrayList<Integer> createList(Integer... params) {
		assertEquals(true, params[0] instanceof Integer);
		return new ArrayList<>(Arrays.asList(params));
	}
	
}
