package dev.inventio.domain.domain;

class Franc extends Money {

  Franc(int amount, String currency) {
    super(amount, currency);
  }

  public Money times(int times) {
    return Money.franc(amount * times);
  }
}
