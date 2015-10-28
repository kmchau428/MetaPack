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
		int sum = accmulator.accumulate(1,2,3);
		
	    assertEquals(sum, 6);
	}
	
	@Test
	public void testAccumulateComplex() {
		int firstSum = accmulator.accumulate(1,2,3);
		int secondSum = accmulator.accumulate(4);
		
	    assertEquals(firstSum, 6);
	    assertEquals(secondSum, 4);
	    assertEquals(accmulator.getTotal(), firstSum+secondSum);
	}
	
	@Test
	public void testAccumulateWithNegativeNum() {
		int sum = accmulator.accumulate(1,2,3,-10);
		
	    assertEquals(sum, -4);
	}
	
	@Test
	public void testAccumulateWithEmptyInput() {
		int sum = accmulator.accumulate();
		
	    assertEquals(sum, 0);
	}
	
	@Test
	public void testAccumulateWithLargeInput() {
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		
		int sum = accmulator.accumulate(array);
		
	    assertEquals(sum, Arrays.stream(array).sum());
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
