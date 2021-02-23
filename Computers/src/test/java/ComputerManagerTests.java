package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    private List<Computer> computers;
    private ComputerManager computerManager;
    private Computer computer;
    private Computer computer2;
    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        computer = new Computer("DELL", "Inspron 5010", 600.00);
        computer2 = new Computer("HP", "21100", 700.00);
        this.computers = new ArrayList<>();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testListIsUnmodifiable() {
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerReturnsExWhenNull() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerReturnsExWhenComputerExists() {

        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void testAddComputersReturnCorrectComputer() {
        computerManager.addComputer(computer);
        Computer expected = computer;
        Assert.assertEquals(expected, computerManager.getComputer("DELL", "Inspron 5010"));
    }

    @Test
    public void testRemoveComputerRemoveCorrectComputer(){
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);

        computerManager.removeComputer("DELL", "Inspron 5010");
        List<Computer> expected = computerManager.getComputers();
                Assert.assertEquals(expected.get(0), computerManager.getComputers().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotNullWorksCorrectly() {
        computerManager.getComputer("ASUS", "ROG");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWhenNullThrowsCorrectly() {
        computerManager.getComputer(null, "test");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWhenNullThrowsCorrectly2() {
        computerManager.getComputer("test", null);
    }

    @Test
    public void testGetComputerReturnCorrectComputer() {
        computerManager.addComputer(computer);
        Computer computerExpected = computerManager.getComputer("DELL", "Inspron 5010");
        Assert.assertEquals(computerExpected, computerManager.getComputers().get(0) );
    }

    @Test
    public void testGetCountReturnsCorrectCount() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computerManager.getCount(), computerManager.getComputers().size());
    }

    @Test
    public void testGetComputersByManufacturerReturnComputerList() {
        computerManager.addComputer(computer);

        List<Computer> computerList = computerManager.getComputersByManufacturer("DELL");
        Assert.assertEquals(computerList.size(), computerManager.getComputers().size());
        Assert.assertEquals(computerList.get(0), computerManager.getComputers().get(0));
    }
}