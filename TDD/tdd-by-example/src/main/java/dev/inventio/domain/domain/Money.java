package dev.inventio.domain.domain;

public class Money {

  protected int amount;
  protected String currency;

  public static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public Money times(int times) {
    return new Money(this.amount * times, this.currency);
  }

  public String currency() {
    return this.currency;
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
