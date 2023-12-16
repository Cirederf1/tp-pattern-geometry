package org.acme.geometry;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AbstractGeometryTest {

	@Test
	public void testLineString() {
		Point a = new Point(new Coordinate(5.0, 2.0));
		Point b = new Point(new Coordinate(1.0, 2.0));

		List<Point> points = new ArrayList<Point>();
		points.add(a);
		points.add(b);

		LineString c = new LineString(points);
		assertEquals("LINESTRING(5.0 2.0 1.0 2.0)", c.asText());

	}

	@Test
	public void testPoint() {
		Point a = new Point(new Coordinate(5.0, 2.0));
		assertEquals("POINT(5.0 2.0)", a.asText());

	}

	@Test
	public void testOtherGeometry() {
		OtherGeometry geometry = new OtherGeometry();
		assertEquals("", geometry.asText());
	}

}
