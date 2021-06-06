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

  @Override
  public boolean equals(Object presented) {

    Dollar dollar = (Dollar) presented;
    return this.amount == dollar.amount;

  }
}
