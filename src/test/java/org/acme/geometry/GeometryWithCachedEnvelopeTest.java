package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {

	@Test
	public void testCachedEnvelope() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope() ; 
		Envelope b = g.getEnvelope() ; 
		assertSame(a,b);
	}
	
    @Test
    public void testEmptyGeometry() {
        Geometry g = new GeometryWithCachedEnvelope(null);

        assertEquals("Unknown",g.getType());
        assertTrue(g.isEmpty());
        g.translate(1.0, 1.0);
        assertNull(g.clone());
        
        GeometryVisitor visitor = new WktVisitor();
        g.accept(visitor);
    }
    
    @Test
    public void testPointGeometry() {
		Geometry g = new Point(new Coordinate(3.0,3.0));
        g = new GeometryWithCachedEnvelope(g);

        assertEquals("Point",g.getType());
        assertFalse(g.isEmpty());
        g.translate(1.0, 1.0);
        
        
        assertNotNull(g.clone());
        
        WktVisitor visitor = new WktVisitor();
        g.accept(visitor);
        
        assertEquals("POINT(4.0 4.0)",visitor.getResult());
    }

}
