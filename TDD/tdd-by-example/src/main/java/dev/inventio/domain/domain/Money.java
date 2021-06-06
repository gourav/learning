package dev.inventio.domain.domain;

public abstract class Money {

  protected int amount;

  public static Money dollar(int amount) {
    return new Dollar(amount);
  }

  public static Money franc(int amount) {
    return new Franc(amount);
  }

  public abstract Money times(int times);

  @Override
  public boolean equals(Object presented) {

    if (this.getClass().equals(presented.getClass())) {
      Money money = (Money) presented;
      return money.amount == amount;
    }

    return false;

  }

}
