package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

	private StringBuilder buffer;
	
	public WktVisitor() {
		this.buffer = new StringBuilder();
	}

	public String getResult() {
		return buffer.toString();
	}

	@Override
	public void visit(Point point) {
		buffer.append(point.getType().toUpperCase());
		if (point.isEmpty()) {
			buffer.append(" EMPTY");
		} else {
			buffer.append("(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")");
		}
	}

	@Override
	public void visit(LineString lineString) {
		buffer.append(lineString.getType().toUpperCase());
		if (lineString.isEmpty()) {
			buffer.append(" EMPTY");
		} else {
			buffer.append("(");
			for (int index =0; index <lineString.getNumPoints();index++) {
				if(index!=0) {
					buffer.append(" "+ lineString.getPointN(index).getCoordinate().getX() + " "
							+ lineString.getPointN(index).getCoordinate().getY());
				}else {
					buffer.append(lineString.getPointN(index).getCoordinate().getX() + " "
							+ lineString.getPointN(index).getCoordinate().getY());
				}
			}
		}
	}
}
