package dev.inventio.domain.domain;

public interface Expression {

  Money reduce(Bank bank, Currency currency);

}
