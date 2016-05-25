package me.study;

import me.study.Money.Currency;

public interface Expression {

	Money reduce(Currency to);

}
