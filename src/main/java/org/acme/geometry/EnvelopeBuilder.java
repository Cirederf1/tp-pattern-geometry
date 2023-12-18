package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor {

	private List<Coordinate> coordinates;

	public EnvelopeBuilder() {
		this.coordinates = new ArrayList<Coordinate>();
	}

	public void insert(Coordinate coordinate) {
		this.coordinates.add(coordinate);
	}

	public Envelope build() {

		if (coordinates.isEmpty()) {
			return new Envelope();
		} else {
			double xMin, yMin, xMax, yMax;

			xMin = coordinates.get(0).getX();
			yMin = coordinates.get(0).getY();
			xMax = coordinates.get(0).getX();
			yMax = coordinates.get(0).getY();

			for (Coordinate coordinate : coordinates) {
				if (coordinate.getX() < xMin) {
					xMin = coordinate.getX();
				} else if (coordinate.getX() > xMax) {
					xMax = coordinate.getX();
				}

				if (coordinate.getY() < yMin) {
					yMin = coordinate.getY();
				} else if (coordinate.getY() > yMax) {
					yMax = coordinate.getY();
				}
			}

			Coordinate bottomLeft = new Coordinate(xMin, yMin);
			Coordinate topRight = new Coordinate(xMax, yMax);

			return new Envelope(bottomLeft, topRight);
		}
	}

	@Override
	public void visit(Point point) {
		if (!point.isEmpty()) {
			insert(point.getCoordinate());
		}
	}

	@Override
	public void visit(LineString lineString) {
		if (!lineString.isEmpty()) {
			for (int index = 0; index < lineString.getNumPoints(); index++) {
				insert(lineString.getPointN(index).getCoordinate());
			}
		}
	}

	@Override
	public void visit(OtherGeometry otherGeometry) {

	}
}
