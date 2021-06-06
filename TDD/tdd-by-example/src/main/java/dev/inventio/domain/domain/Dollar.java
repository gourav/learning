package dev.inventio.domain.domain;

class Dollar extends Money {

  Dollar(int amount, String currency) {
    super(amount, currency);
  }

  public Money times(int times) {
    return Money.dollar(this.amount * times);
  }

  @Override
  public String currency() {
    return currency;
  }
}
