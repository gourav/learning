package dev.inventio.domain.domain;

public class Franc {

  private int amount;

  public Franc(int amount) {
    this.amount = amount;
  }

  public Franc times(int times) {
    return new Franc(amount * times);
  }

  @Override
  public boolean equals(Object presented) {

    Franc franc = (Franc) presented;
    return this.amount == franc.amount;

  }

}
