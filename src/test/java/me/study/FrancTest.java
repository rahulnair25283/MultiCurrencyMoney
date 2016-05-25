package me.study;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import org.junit.Test;

public class FrancTest {

	@Test
	public void testMultiplication() {
		Money fiveFrancs = Money.franc(5);
		assertThat(fiveFrancs.times(2), is(Money.franc(10)));
		assertThat(fiveFrancs.times(3), is(Money.franc(15)));
	}

	@Test
	public void testEquality() throws Exception {
		assertThat(Money.franc(5), is(Money.franc(5)));
		assertThat(Money.franc(5), is(not(Money.franc(6))));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	@Test
	public void testCurrency() throws Exception {
		assertThat(Money.franc(1).currency(), is(Money.Currency.CHF));
	}
	
	@Test
	public void testSimpleAddition() throws Exception {
		Money fiveFrancs = Money.franc(5);
		Expression sum = fiveFrancs.plus(fiveFrancs);
		
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, Money.Currency.CHF);
		
		assertThat(reduced, is(Money.franc(10)));
	}
}