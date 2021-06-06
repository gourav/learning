package dev.inventio.domain.domain;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  private Map<Pair, Integer> conversionRates = new HashMap<>();

  public Money reduce(Expression expression, Currency currency) {
    return expression.reduce(this, currency);
  }

  public void addRate(Currency from, Currency to, int conversionRate) {
    this.conversionRates.put(new Pair(from, to), conversionRate);
  }

  public int rate(Currency from, Currency to) {
    if (from.equals(to)) {
      return 1;
    }

    return conversionRates.get(new Pair(from, to));
  }

}
