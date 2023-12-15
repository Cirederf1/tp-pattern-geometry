package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testConstructorVoid() {
		Point a = new Point();
        assertTrue(a.getCoordinate().isEmpty());
        assertEquals("Point", a.getType());

	}
}
