package org.acme.geometry;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LogGeometryVisitorTest {

	@Test
	public void testVisitorPoint() throws UnsupportedEncodingException {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		
		String result = os.toString("UTF8");
		assertEquals("Je suis un point avec x=3.0 et y=4.0.", result);	
		
		ByteArrayOutputStream os2 = new ByteArrayOutputStream();
		PrintStream out2 = new PrintStream(os2);
		LogGeometryVisitor visitor2 = new LogGeometryVisitor(out2);
		
		Geometry geometryVoid = new Point(new Coordinate());
		geometryVoid.accept(visitor2);
		String result2 = os2.toString("UTF8");
		assertEquals("Je suis un point vide.", result2);	
	}
	
	@Test
	public void testVisitorLineString() throws UnsupportedEncodingException {
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Coordinate x = new Coordinate(5.0, 2.0);
		Coordinate y = new Coordinate(1.0, 2.0);
		
		Point a = new Point(x);
		Point b = new Point(y);
		
		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);
		
		Geometry geometry = new LineString(points);
		geometry.accept(visitor);
		
		String result = os.toString("UTF8");
		assertEquals("Je suis une polyligne définie par 2 point(s).", result);	
		
		ByteArrayOutputStream os2 = new ByteArrayOutputStream();
		PrintStream out2 = new PrintStream(os2);
		LogGeometryVisitor visitor2 = new LogGeometryVisitor(out2);
		
		Geometry geometryVoid = new LineString();
		geometryVoid.accept(visitor2);
		
		String result2 = os2.toString("UTF8");
		assertEquals("Je suis une polyligne vide.", result2);	
	}

}
