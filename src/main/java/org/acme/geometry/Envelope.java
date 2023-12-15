package org.acme.geometry;

public class Envelope {

	private Coordinate bottomLeft;
	private Coordinate topRight;

	public Envelope() {
		this(new Coordinate(), new Coordinate());
	}

	public Envelope(Coordinate bottomLeft, Coordinate topRight) {
		if (bottomLeft != null && topRight!=null) {
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
		}else {
			this.bottomLeft = new Coordinate();
			this.topRight = new Coordinate();
		}
	}
	
	public boolean isEmpty() {
		return this.bottomLeft.isEmpty() || this.topRight.isEmpty();
	}
	
	public double getXmin() {
		return this.bottomLeft.getX();
	}
	
	public double getYmin() {
		return this.bottomLeft.getY();

	}
	
	public double getXmax() {
		return this.topRight.getX();

	}
	
	public double getYmax() {
		return this.topRight.getY();
	}
	
	@Override
	public String toString() {
		return this.bottomLeft.getX()+","+this.bottomLeft.getY()+","+this.topRight.getX()+","+this.topRight.getY();
	}
}
