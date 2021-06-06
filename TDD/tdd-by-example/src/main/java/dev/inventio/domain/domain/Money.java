package dev.inventio.domain.domain;

public class Money implements Expression {

  protected int amount;
  protected Currency currency;

  public static Money dollar(int amount) {
    return new Money(amount, Currency.DOLLAR);
  }

  public static Money franc(int amount) {
    return new Money(amount, Currency.FRENC);
  }

  public Money(int amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Money times(int times) {
    return new Money(this.amount * times, this.currency);
  }

  public Expression plus(Money toAdd) {
    return new Sum(this, toAdd);
  }

  public Currency currency() {
    return this.currency;
  }

  @Override
  public Money reduce(Bank bank, Currency currency) {
    return new Money(this.amount / bank.rate(this.currency, currency), currency);
  }

  @Override
  public boolean equals(Object presented) {

    if (Money.class.isAssignableFrom(presented.getClass())) {
      Money money = (Money) presented;
      return money.amount == amount && money.currency.equals(currency);
    }

    return false;

  }

}
