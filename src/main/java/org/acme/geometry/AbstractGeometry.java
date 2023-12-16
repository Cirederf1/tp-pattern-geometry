package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

	public abstract Geometry clone();

	public String asText() {
		WktVisitor wktVisitor = new WktVisitor();
        accept(wktVisitor);
        return wktVisitor.getResult();
	}
}
