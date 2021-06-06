package dev.inventio.domain.domain;

class Franc extends Money {

  Franc(int amount) {
    this.amount = amount;
  }

  public Money times(int times) {
    return new Franc(amount * times);
  }

}
