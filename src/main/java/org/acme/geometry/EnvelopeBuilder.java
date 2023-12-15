package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnvelopeBuilder {

	private List<Coordinate> coordinates;

	public EnvelopeBuilder() {
		this.coordinates = new ArrayList<Coordinate>();
	}

	public void insert(Coordinate coordinate) {
		this.coordinates.add(coordinate);
	}

	public Envelope build() {

		if (!coordinates.isEmpty()) {
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
		} else {
			return new Envelope();
		}
	}
}