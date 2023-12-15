package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	
	private PrintStream out;
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	public void visit(Point point) {
		if (point.isEmpty()) {
			out.print("Je suis un point vide.");
		} else {
			out.print("Je suis un point avec x=" + point.getCoordinate().getX() + " et y="
					+ point.getCoordinate().getY() + ".");
		}
	}

	public void visit(LineString lineString) {
		if (lineString.isEmpty()) {
			out.print("Je suis une polyligne vide.");
		} else {
			out.print("Je suis une polyligne définie par " + lineString.getNumPoints() + " point(s).");
		}
	}
}
