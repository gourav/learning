package dev.inventio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import dev.inventio.domain.domain.Bank;
import dev.inventio.domain.domain.Currency;
import dev.inventio.domain.domain.Expression;
import dev.inventio.domain.domain.Money;
import dev.inventio.domain.domain.Sum;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void givenDollarIs5_whenMultiplied_shouldReturn10() {

    Money five = Money.dollar(5);

    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));

  }

  @Test
  void givenDollarIs5_whenComparedAgainstAnother5Dollar_shouldReturnTrue() {
    assertEquals(Money.dollar(5), Money.dollar(5));

  }

  @Test
  void givenDollarIs5_whenComparedAgainstDollar10_shouldReturnFalse() {
    assertNotEquals(Money.dollar(5), Money.dollar(10));
  }

  @Test
  void givenFrancIs5_whenMultiplied_shouldReturn10() {

    Money five = Money.franc(5);

    assertEquals(Money.franc(10), five.times(2));
    assertEquals(Money.franc(15), five.times(3));

  }

  @Test
  void givenFrancIs5_whenComparedAgainstAnother5Franc_shouldReturnTrue() {
    assertEquals(Money.franc(5), Money.franc(5));

  }

  @Test
  void givenFrancIs5_whenComparedAgainstFranc10_shouldReturnFalse() {
    assertNotEquals(Money.franc(5), Money.franc(10));
  }

  @Test
  void givenFrancIs5AndDollarIs5_whenComparedAgainstEachOther_shouldReturnFalse() {
    assertNotEquals(Money.franc(5), Money.dollar(5));
  }

  @Test
  void givenDollar5_currency_shouldBeUsd() {
    assertEquals(Money.dollar(5).currency(), Currency.DOLLAR);
  }

  @Test
  void givenFrac5_currency_shouldBeFrc() {
    assertEquals(Money.franc(5).currency(), Currency.FRENC);
  }

  @Test
  void givenDollar5AndAnotherDollarFive_whenAdded_shouldBe10Dollars() {

    Money fiveDollars = Money.dollar(5);
    Expression expression = fiveDollars.plus(fiveDollars);

    Bank bank = new Bank();
    Money sum = bank.reduce(expression, Currency.DOLLAR);

    assertEquals(Money.dollar(10), sum);

  }

  @Test
  void givenDollar5AndAnotherDollarFive_whenAdded_shouldSetAddedmendAndAugmendProperly() {
    Money five = Money.dollar(5);
    Expression result = five.plus(five);

    Sum sum = (Sum) result;
    assertEquals(five, sum.getAddmend());
    assertEquals(five, sum.getAugmend());
  }

  @Test
  void givenDollarThreeAndDollarFour_whenAdded_shouldProduceDollarSeven() {

    Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
    Bank bank = new Bank();

    Money result = bank.reduce(sum, Currency.DOLLAR);
    assertEquals(Money.dollar(7), result);

  }

  @Test
  void givenDollarOne_whenInvokedReduce_shouldHaveSameValue() {

    Bank bank = new Bank();
    Money money = bank.reduce(Money.dollar(1), Currency.DOLLAR);
    assertEquals(Money.dollar(1), money);

  }


}
