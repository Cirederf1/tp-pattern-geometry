package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testWktWritorPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0, 4.0));
		geometry.accept(visitor);
		assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}

	@Test
	public void testWktWritorPointVoid() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate());
		geometry.accept(visitor);
		assertEquals("POINT EMPTY", visitor.getResult());
	}

	@Test
	public void testWktWritorLineString() {
		WktVisitor visitor = new WktVisitor();
		
		Coordinate x = new Coordinate(5.0, 2.0);
		Coordinate y = new Coordinate(1.0, 2.0);

		Point a = new Point(x);
		Point b = new Point(y);

		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);

		Geometry geometry = new LineString(points);
		geometry.accept(visitor);
		assertEquals("LINESTRING(5.0 2.0 1.0 2.0)", visitor.getResult());

	}
	
	@Test
	public void testWktWritorLineStringVoid() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString();
		geometry.accept(visitor);
		assertEquals("LINESTRING EMPTY", visitor.getResult());

	}



}
