package org.acme.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class OtherGeometryTest {

	@Test
    public void testGetType() {
        OtherGeometry geometry = new OtherGeometry();
        assertNull(geometry.getType());
    }

    @Test
    public void testIsEmpty() {
        OtherGeometry geometry = new OtherGeometry();
        assertFalse(geometry.isEmpty());
    }

    @Test
    public void testTranslate() {
        OtherGeometry geometry = new OtherGeometry();
        geometry.translate(2.0, 3.0);
    }

    @Test
    public void testClone() {
        OtherGeometry geometry = new OtherGeometry();
        assertNull(geometry.clone());
       
    }

    @Test
    public void testGetEnvelope() {
        OtherGeometry geometry = new OtherGeometry();
        assertNull(geometry.getEnvelope());
       
    }

    @Test
    public void testAccept() {
    	WktVisitor visitor = new WktVisitor();
        OtherGeometry geometry = new OtherGeometry();
        geometry.accept(visitor);
        assertEquals("",visitor.getResult());
    }

}
