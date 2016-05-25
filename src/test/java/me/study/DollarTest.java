package me.study;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import org.junit.Test;

public class DollarTest {

	@Test
	public void testMultiplication() {
		Money fiveDollars = Money.dollar(5);
		assertThat(fiveDollars.times(2), is(Money.dollar(10)));
		assertThat(fiveDollars.times(3), is(Money.dollar(15)));
	}
	
	@Test
	public void testEquality() throws Exception {
		assertThat(Money.dollar(5), is(Money.dollar(5)));
		assertThat(Money.dollar(5), is(not(Money.dollar(6))));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}
	
	@Test
	public void testCurrency() throws Exception {
		assertThat(Money.dollar(1).currency(), is(Money.Currency.USD));
	}
	
	@Test
	public void testPlusReturnsSum() throws Exception {
		Money fiveDollars = Money.dollar(5);
		Expression result = fiveDollars.plus(fiveDollars);
		Sum sum = (Sum)result;
		
		assertThat(sum.getAugend(), is(fiveDollars));
		assertThat(sum.getAddend(), is(fiveDollars));
	}
	
	@Test
	public void testReduceSum() throws Exception {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(5));
		Bank bank = new Bank();
		Money result = bank.reduce(sum, Money.Currency.USD);
		
		assertThat(result, is(Money.dollar(8)));
	}
}