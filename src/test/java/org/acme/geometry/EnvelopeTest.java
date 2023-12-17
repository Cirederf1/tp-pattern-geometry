package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EnvelopeTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testEnvelopeVoid() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		Envelope result = builder.build();
		
        assertTrue(result.isEmpty());
        assertEquals("NaN,NaN,NaN,NaN", result.toString());

        assertEquals(Double.NaN, result.getXmin(), EPSILON);
        assertEquals(Double.NaN, result.getYmin(), EPSILON);
        assertEquals(Double.NaN, result.getXmax(), EPSILON);
        assertEquals(Double.NaN, result.getYmax(), EPSILON);
        
        Envelope result2 = new Envelope(null, null);
        
        assertTrue(result2.isEmpty());
        assertEquals("NaN,NaN,NaN,NaN", result2.toString());

        assertEquals(Double.NaN, result2.getXmin(), EPSILON);
        assertEquals(Double.NaN, result2.getYmin(), EPSILON);
        assertEquals(Double.NaN, result2.getXmax(), EPSILON);
        assertEquals(Double.NaN, result2.getYmax(), EPSILON);

	}
	
	@Test
	public void testEnvelope() {
		Coordinate x = new Coordinate(5.0, 2.0);
		Coordinate y = new Coordinate(1.0, 3.0);
		
		Point a = new Point(x);
		Point b = new Point(y);
		
		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
		EnvelopeBuilder builder = new EnvelopeBuilder();
		for (Point point : points) {
			builder.insert(point.getCoordinate());
		}
		
		Envelope result = builder.build();
		
        assertFalse(result.isEmpty());
        assertEquals("1.0,2.0,5.0,3.0", result.toString());

        assertEquals(1.0, result.getXmin(), EPSILON);
        assertEquals(2.0, result.getYmin(), EPSILON);
        assertEquals(5.0, result.getXmax(), EPSILON);
        assertEquals(3.0, result.getYmax(), EPSILON);
        
        Coordinate z = new Coordinate(7.0, 0.5);
        builder.insert(z);
        
        Envelope result2 = builder.build();
        assertEquals("1.0,0.5,7.0,3.0", result2.toString());
	}

}
