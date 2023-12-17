package org.acme.geometry;

public class Point extends AbstractGeometry {

	private Coordinate coordinate;

	public Point() {
		this.coordinate = new Coordinate();
	}

	public Point(Coordinate coordinate) {
		if (coordinate != null) {
			this.coordinate = coordinate;
		} else {
			this.coordinate = new Coordinate();
		}
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
		if (!this.isEmpty()) {
			this.coordinate = new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
		}
	}

	@Override
	public Point clone() {
		Coordinate clone_coord = new Coordinate(this.coordinate.getX(), this.coordinate.getY());
		Point clone = new Point(clone_coord);
		return clone;
	}

//	@Override
//	public Envelope getEnvelope() {
//		if (this.isEmpty()) {
//			return new Envelope();
//		} else {
//			EnvelopeBuilder builder = new EnvelopeBuilder();
//			builder.insert(this.coordinate);
//			Envelope result = builder.build();
//			return result;
//		}
//	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
