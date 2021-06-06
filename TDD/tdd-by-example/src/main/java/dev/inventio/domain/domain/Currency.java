package dev.inventio.domain.domain;

public enum Currency {

  DOLLAR("USD"),
  FRENC("CHF");

  private String symbol;

  Currency(String symbol) {
    this.symbol = symbol;
  }

}
