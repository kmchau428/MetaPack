package model;

public interface Accumulator {
	int accumulate(int... values);
	int getTotal();
    void reset();
}
