package model;
import java.util.Arrays;


public final class AccumulatorImpl implements Accumulator{
	private int total;
	
	//for Singleton
	/*
	private static AccumulatorImpl instance = new AccumulatorImpl();
	
	private AccumulatorImpl() {};
	
	public static AccumulatorImpl getInstance() {
		return instance;
	}
	*/

	@Override
	public int accumulate(int... values) {
		if (values.length < 1)
			throw new IllegalArgumentException("There should be at least one item!");
		
		int sum = Arrays.stream(values).sum();
		total += sum;
		
		return sum;			
	}

	@Override
	public int getTotal() {
		
		return total;
	}

	@Override
	public void reset() {
		total = 0;
		
	}

}
