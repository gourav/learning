package dev.inventio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import dev.inventio.domain.domain.Bank;
import dev.inventio.domain.domain.Expression;
import dev.inventio.domain.domain.Money;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void given_dollarIs5_whenMultiplied_shouldReturn10() {

    Money five = Money.dollar(5);

    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));

  }

  @Test
  void given_dollarIs5_whenComparedAgainstAnother5Dollar_shouldReturnTrue() {
    assertEquals(Money.dollar(5), Money.dollar(5));

  }

  @Test
  void given_dollarIs5_whenComparedAgainstDollar10_shouldReturnFalse() {
    assertNotEquals(Money.dollar(5), Money.dollar(10));
  }

  @Test
  void given_FrancIs5_whenMultiplied_shouldReturn10() {

    Money five = Money.franc(5);

    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));

  }

  @Test
  void given_FrancIs5_whenComparedAgainstAnother5Franc_shouldReturnTrue() {
    assertEquals(Money.franc(5), Money.franc(5));

  }

  @Test
  void given_FrancIs5_whenComparedAgainstFranc10_shouldReturnFalse() {
    assertNotEquals(Money.franc(5), Money.franc(10));
  }

  @Test
  void given_FrancIs5AndDollarIs5_whenComparedAgainstEachOther_shouldReturnFalse() {
    assertNotEquals(Money.franc(5), Money.dollar(5));
  }

  @Test
  void given_Dollar5_currency_shouldBeUsd() {
    assertEquals(Money.dollar(5).currency(), "USD");
  }

  @Test
  void given_Frac5_currency_shouldBeFrc() {
    assertEquals(Money.franc(5).currency(), "CHF");
  }

  @Test
  void givenDollar5AndAnotherDollarFive_whenAdded_shouldBe10Dollars() {

    Money fiveDollars = Money.dollar(5);
    Expression expression = fiveDollars.plus(fiveDollars);

    Bank bank = new Bank();
    Money sum = bank.reduce(expression, "USD");

    assertEquals(Money.dollar(10), sum);

  }

}
