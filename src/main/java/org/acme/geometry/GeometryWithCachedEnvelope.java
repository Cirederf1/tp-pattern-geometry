package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

	private Geometry original;

	private Envelope cachedEnvelope;

	public GeometryWithCachedEnvelope(Geometry original) {
		this.original = original;
		this.cachedEnvelope = null;
	}

	@Override
	public Envelope getEnvelope() {
		if (cachedEnvelope == null) {
			cachedEnvelope = original.getEnvelope();
		}
		return cachedEnvelope;
	}

	@Override
	public String getType() {
		if (original != null) {
			return original.getType();
		}
		return "Unknown";
	}

	@Override
	public boolean isEmpty() {
		if (original != null) {
			return original.isEmpty();
		}
		return true;
	}

	@Override
	public void translate(double dx, double dy) {
		if (original != null) {
			original.translate(dx, dy);
		}
	}

	@Override
	public Geometry clone() {
		if (original != null) {
			return original.clone();
		}
		return null;
	}

	@Override
	public void accept(GeometryVisitor visitor) {
		if (original != null) {
			original.accept(visitor);
		}
	}

}