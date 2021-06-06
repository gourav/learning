package dev.inventio.domain.domain;

public interface Expression {

  Money reduce(Currency currency);

}
