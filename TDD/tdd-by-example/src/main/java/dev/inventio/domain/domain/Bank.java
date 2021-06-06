package dev.inventio.domain.domain;

public class Bank {

  public Money reduce(Expression expression, Currency currency) {
    return expression.reduce(currency);
  }

}
