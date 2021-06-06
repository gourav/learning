package dev.inventio.domain.domain;

public class Money {

  protected int amount;

  @Override
  public boolean equals( Object presented ) {

    Money money = (Money) presented;
    return money.amount == amount;

  }

}
