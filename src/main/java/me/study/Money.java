package me.study;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Money implements Expression {
	
	enum Currency {
		USD,
		CHF;
	}

	protected int amount;
	protected Currency currency;
	
	public Money(int amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount,Money.Currency.USD);
	}

	public static Money franc(int amount) {
		return new Money(amount, Money.Currency.CHF);
	}

	protected Currency currency() {
		return currency;
	}

	protected Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(amount, currency);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Money) {
			Money that = (Money) object;
			return Objects.equal(this.amount, that.amount)
					&& Objects.equal(this.currency, that.currency);
		}
		return false;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("amount", amount)
				.add("currency", currency).toString();
	}

	public Money reduce(Currency to) {
		// TODO Auto-generated method stub
		return null;
	}

}
