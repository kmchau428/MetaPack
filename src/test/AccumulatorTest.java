package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;

import org.junit.*;
import org.junit.rules.ExpectedException;

import model.Accumulator;
import model.AccumulatorImpl;


public class AccumulatorTest {
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	Accumulator accmulator;
	
	@Before
	public void init() {
		accmulator = new AccumulatorImpl();
	}
	
	@Test
	public void testAccumulateSimple() {
		int array[] = new int[] {1,2,3};
		int sum = accmulator.accumulate(array);
		
	    assertEquals(Arrays.stream(array).sum(), sum);
	}
	
	@Test
	public void testAccumulateComplex() {
		int firstSum = accmulator.accumulate(1,2,3);
		int secondSum = accmulator.accumulate(4);
		
	    assertEquals(firstSum, 6);
	    assertEquals(secondSum, 4);
	    assertEquals(firstSum+secondSum, accmulator.getTotal());
	}
	
	@Test
	public void testAccumulateWithNegativeNum() {
		int array[] = new int[] {1,2,3,-10};
		int sum = accmulator.accumulate(array);
		
	    assertEquals(Arrays.stream(array).sum(), sum);
	}
	
	@Test
	public void testAccumulateWithEmptyInput() {
		 thrown.expect(IllegalArgumentException.class);
		 thrown.expectMessage("There should be at least one item!");
		 accmulator.accumulate();
	}
	
	@Test
	public void testAccumulateWithLargeInput() {
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		
		int sum = accmulator.accumulate(array);
		
	    assertEquals(Arrays.stream(array).sum(), sum);
	}
	
	@Test
	public void testResetTotal() {
		int firstSum = accmulator.accumulate(1,2,3);
		accmulator.reset();
		
		assertFalse(accmulator.getTotal() == firstSum);
	    assertEquals(0, accmulator.getTotal());
	}
	
	@Test
	public void testGetTotal(){
	    assertEquals(1, accmulator.getTotal()+1);
	}
	
	@Test
	public void testInitValue(){
	    assertEquals(0, accmulator.getTotal());
	}
	
	

}
