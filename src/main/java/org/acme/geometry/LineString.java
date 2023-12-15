package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {

	private List<Point> points;

	public LineString() {
		this.points = new ArrayList<Point>();
	}

	public LineString(List<Point> points) {
		if (points != null) {
			this.points = points;
		} else {
			this.points = new ArrayList<Point>();
		}
	}

	public int getNumPoints() {
		return this.points.size();
	}

	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		if(!this.isEmpty()) {
			for (Point point : points) {
				point.translate(dx, dy);
			}
		}
	}
	
	@Override
	public LineString clone() {
		
		List<Point> points_clone = new ArrayList<Point>();
		for(Point point : this.points) {
			points_clone.add(point.clone());
		}
		
		LineString clone = new LineString(points_clone);
		return clone;
	}
}
