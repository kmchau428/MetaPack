package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.*;

import model.AccumulatorImpl;


public class AccumulatorTest {
	static AccumulatorImpl accmulator;
	
	@BeforeClass
	public static void init() {
		accmulator = AccumulatorImpl.getInstance();
	}
	
	@Before
	public void resetTotal() {
		accmulator.reset();
	}
	
	@Test
	public void testAccumulateSimple() {
		accmulator.accumulate(1,2,3);
		
	    assertEquals(accmulator.getTotal(), 6);
	}
	
	@Test
	public void testAccumulateComplex() {
		accmulator.accumulate(1,2,3);
		accmulator.accumulate(4);
		
	    assertEquals(accmulator.getTotal(), 10);
	}
	
	@Test
	public void testAccumulateWithNegativeNum() {
		accmulator.accumulate(1,2,3,-10);
		
	    assertEquals(accmulator.getTotal(), -4);
	}
	
	@Test
	public void testAccumulateWithLargeInput() {
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		
		accmulator.accumulate(array);
		
	    assertEquals(accmulator.getTotal(), Arrays.stream(array).sum());
	}
	
	@Test
	public void testReset() {
		accmulator.accumulate(1,2,3);
		accmulator.reset();
		
	    assertEquals(accmulator.getTotal(), 0);
	}
	
	@Test
	public void testGetTotal(){
	    assertEquals(accmulator.getTotal()+1, 1);
	}
	
	

}
