package dev.inventio.domain.domain;

class Dollar extends Money{

  Dollar(int amount) {
    this.amount = amount;
  }

  public Money times(int times) {
    return new Dollar(this.amount * times);
  }

}
