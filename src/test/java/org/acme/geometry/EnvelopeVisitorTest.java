package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class EnvelopeVisitorTest {

    @Test
    public void testEnvelopeVisitorPoints() {
        Point a = new Point(new Coordinate(1.0, 2.0));
        assertEquals("1.0,2.0,1.0,2.0", a.getEnvelope().toString());
    }

    @Test
    public void testEnvelopeVisitorLineString() {
        Point a = new Point(new Coordinate(1.0, 2.0));
        Point b = new Point(new Coordinate(3.0, 4.0));
        
		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
        LineString lineString = new LineString(points);
        
        assertEquals("1.0,2.0,3.0,4.0", lineString.getEnvelope().toString());
       
    }
    
    @Test
    public void testEnvelopeVisitorOtherGeometry() {
    	Geometry geometry = new OtherGeometry();
        assertEquals("NaN,NaN,NaN,NaN", geometry.getEnvelope().toString());
    }

}
