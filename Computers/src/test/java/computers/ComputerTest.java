package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {

    private List<Computer> computers;
    private Computer computer;
    private List<Part> parts;
    private Part part;

    @Before
    public void setUp() {
        computers = new ArrayList<>();
        computer = new Computer ("DELL", "Inspron 5010", 600.00);
        parts = new ArrayList<>();
        part = new Part("VC", 50.50);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsReturnsUnmodifiableList() {
        computer.addPart(part);
        computer.getParts().remove(0);
    }

    @Test
    public void testGetPriceReturnsCorrectPrice() {
        computer.addPart(part);
        Part part = new Part("Processor", 55.50);
        computer.addPart(part);
        assertEquals(106, computer.getTotalPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartThrowsWhenNull() {
        computer.addPart(null);
    }

    @Test
    public void testAddPartReturnsCorrectPart() {
        Part expected = part;
        computer.addPart(part);
        assertEquals(expected, computer.getParts().get(0));
    }

    @Test
    public void testRemovePartsWorksCorrectly() {
        computer.addPart(part);
        computer.removePart(part);
        assertTrue(computer.getParts().isEmpty());
    }

    @Test
    public void testGetPartReturnsCorrectPart() {
        computer.addPart(part);
        Part expected = part;
        assertEquals(expected, computer.getPart(part.getName()));
    }

    @Test
    public void testGetPartReturnsNullWhenNotPresent() {
        assertNull(computer.getPart(part.getName()));
    }

    @Test
    public void testSetManufacturerReturnsCorrectly() {
        Computer computer1 = new Computer ("DELL", "Inspron 5010", 600.00);
        assertEquals("DELL", computer1.getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetManufacturerThrowsWhenNull() {
        computer = new Computer (null, "Inspron 5010", 600.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetModelThrowsWhenNull() {
        computer = new Computer ("Dell", null, 600.00);
    }

}