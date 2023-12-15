package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testConstructorVoid() {
		LineString a = new LineString();
        assertTrue(a.getNumPoints()==0);
        assertTrue(a.isEmpty());
        
        LineString b = new LineString(null);
        assertTrue(a.isEmpty());

	}
	
	@Test
	public void testConstructor() {
		Coordinate x = new Coordinate(5.0, 2.0);
		Coordinate y = new Coordinate(1.0, 2.0);
		
		Point a = new Point(x);
		Point b = new Point(y);
		
		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
		LineString c = new LineString(points);
        assertEquals(2, c.getNumPoints(), EPSILON);
        assertEquals(5.0, c.getPointN(0).getCoordinate().getX(), EPSILON);
        assertEquals(2.0, c.getPointN(0).getCoordinate().getY(), EPSILON);

        assertTrue(c.getNumPoints()==2);
        assertEquals("LineString", c.getType());
        assertFalse(c.isEmpty());


	}
	

	
}
