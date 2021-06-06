package dev.inventio.domain.domain;

public class Dollar {

  private int amount;

  public Dollar(int amount) {
    this.amount = amount;
  }

  public Dollar times(int times) {
    return new Dollar(this.amount * times);
  }

  public int getAmount() {
    return amount;
  }
}
