package tests;

import static main.core.LengthConstraint.maxLengthOf;
import static main.core.LengthConstraint.minLengthOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestConstraint {

	@Test
	public void testMaxConstraint() {
		assertTrue("60 satisfies a constraint of 180 max length", maxLengthOf(180).isSatisfiedBy(60));
		assertFalse("240 does not satisfy a constraint of 200 max length",maxLengthOf(200).isSatisfiedBy(240));
		assertTrue("180 satisfies a constraint of 180 max length",maxLengthOf(180).isSatisfiedBy(180));
	}
	@Test
	public void testMinConstraint() {
		assertTrue("60 satisfies a constraint of 50 min length",minLengthOf(50).isSatisfiedBy(60));
		assertFalse("80 does not satisfy a constraint of 100 min length",minLengthOf(100).isSatisfiedBy(80));
		assertTrue("120 satisfies a constraint of 120 min length",minLengthOf(120).isSatisfiedBy(120));
	}
	@Test
	public void testInBetweenConstraint() {
		assertEquals(true,minLengthOf(10).and(maxLengthOf(50)).isSatisfiedBy(30));
		assertEquals(true,minLengthOf(20).and(maxLengthOf(60)).isSatisfiedBy(20));
		assertEquals(true,minLengthOf(30).and(maxLengthOf(80)).isSatisfiedBy(80));
		assertEquals(false,minLengthOf(30).and(maxLengthOf(80)).isSatisfiedBy(81));
		assertEquals(false,minLengthOf(30).and(maxLengthOf(80)).isSatisfiedBy(29));
	}



}
