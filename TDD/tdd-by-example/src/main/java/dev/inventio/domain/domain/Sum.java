package dev.inventio.domain.domain;

public class Sum implements Expression {

  private Money augmend;
  private Money addmend;

  public Sum(Money augmend, Money addmend ){
    this.augmend = augmend;
    this.addmend = addmend;
  }

  public Money reduce( Currency currency ) {
    int totalAmount = augmend.amount + addmend.amount;
    return new Money(totalAmount, currency);
  }

  public Money getAugmend() {
    return augmend;
  }

  public Money getAddmend() {
    return addmend;
  }
}
