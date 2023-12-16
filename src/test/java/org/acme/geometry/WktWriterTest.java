package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktWriterTest {

	@Test
	public void testWriterPoint(){
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		assertEquals("POINT(3.0 4.0)", writer.write(g));
		
		Geometry f = new Point(new Coordinate());
		assertEquals("POINT EMPTY", writer.write(f));
	}
	
	@Test
	public void testWriterLineString(){
		Coordinate x = new Coordinate(5.0, 2.0);
		Coordinate y = new Coordinate(1.0, 2.0);
		
		Point a = new Point(x);
		Point b = new Point(y);
		
		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
		LineString c = new LineString(points);
		WktWriter writer = new WktWriter();
		assertEquals("LINESTRING(5.0 2.0 1.0 2.0)", writer.write(c));
		
		LineString d = new LineString();
		assertEquals("LINESTRING EMPTY", writer.write(d));
		
		
	}
	
	@Test
	public void testWriterOtherGeom(){
		Geometry g = new OtherGeometry();
		WktWriter writer = new WktWriter();
        try {
            // Essayez d'écrire une géométrie non prise en charge
            writer.write(g);
            // Si aucune exception n'est levée, le test échoue
            fail("Aucune exception n'a été levée pour la géométrie non prise en charge");
        } catch (RuntimeException e) {
            // Si une exception est levée, vérifiez le message d'erreur
            assertEquals("geometry type not supported", e.getMessage());
        }
	}


}
