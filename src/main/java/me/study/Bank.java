package me.study;

import me.study.Money.Currency;

public class Bank {

	public Money reduce(Expression source, Currency to) {
		Sum sum = (Sum)source;
		return sum.reduce(to);
	}
}
