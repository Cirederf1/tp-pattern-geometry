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
        assertTrue(a.isEmpty());
        
        Point b = new Point(null);
        assertTrue(b.isEmpty());

	}
	
	@Test
	public void testConstructor() {
		Coordinate x = new Coordinate (1.0, 2.0);
		Point a = new Point(x);
		Point clone = a.clone();
		
		assertFalse(a==clone);
		assertFalse(a.getCoordinate()==clone.getCoordinate());
		
		assertEquals("[1.0,2.0]", a.getCoordinate().toString());
        assertEquals("Point", a.getType());
        assertFalse(a.isEmpty());
        
        a.translate(2.0, 2.0);

		assertEquals("[3.0,4.0]", a.getCoordinate().toString());
		assertEquals("[1.0,2.0]", clone.getCoordinate().toString());



	}
}
