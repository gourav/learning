package dev.inventio.domain.domain;

public abstract class Money {

  protected int amount;
  protected String currency;

  public static Money dollar(int amount) {
    return new Dollar(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Franc(amount, "CHF");
  }

  public Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public abstract Money times(int times);

  public String currency() {
    return this.currency;
  }

  @Override
  public boolean equals(Object presented) {

    if (this.getClass().equals(presented.getClass())) {
      Money money = (Money) presented;
      return money.amount == amount;
    }

    return false;

  }

}
