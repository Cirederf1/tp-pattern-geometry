package org.acme.geometry;

public class WktWriter {

	public WktWriter() {

	}

	public String write(Geometry geometry) {
		if (geometry instanceof Point) {
			Point point = (Point) geometry;
			if (point.isEmpty()) {
				return point.getType().toUpperCase() + " EMPTY";
			} else {
				return point.getType().toUpperCase() + "(" + point.getCoordinate().getX() + " "
						+ point.getCoordinate().getY() + ")";
			}
		} else if (geometry instanceof LineString) {
			LineString lineString = (LineString) geometry;
			if (lineString.isEmpty()) {
				return lineString.getType().toUpperCase() + " EMPTY";
			} else {
				String result = lineString.getType().toUpperCase() + "(" + lineString.getPointN(0).getCoordinate().getX() + " "
						+ lineString.getPointN(0).getCoordinate().getY();
				for (int index = 1; index < lineString.getNumPoints(); index++) {
					result += " " + lineString.getPointN(index).getCoordinate().getX() + " "
							+ lineString.getPointN(index).getCoordinate().getY();
				}
				result += ")";
				return result;
			}
		} else {
			throw new RuntimeException("geometry type not supported");
		}
	}

}
