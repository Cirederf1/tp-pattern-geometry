package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry{

	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}
	
	public LineString(List<Point> points) {
		if (points.size() >= 2 ) {
			this.points = points;
		}
		else {
			this.points = new ArrayList<Point>();
		}
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}
	
	public String getType() {
		return "LineString";
	}
}
