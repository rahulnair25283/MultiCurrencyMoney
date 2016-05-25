package me.study;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BankTest {

	@Test
	public void testReduceMoney() throws Exception {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(10), Money.Currency.USD);
		
		assertThat(result, is(Money.dollar(10)));
	}
}
