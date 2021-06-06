package dev.inventio.domain.domain;

public class Franc extends Money {

  public Franc(int amount) {
    this.amount = amount;
  }

  public Franc times(int times) {
    return new Franc(amount * times);
  }

}
