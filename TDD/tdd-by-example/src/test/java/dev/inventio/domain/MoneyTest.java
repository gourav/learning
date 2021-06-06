package dev.inventio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import dev.inventio.domain.domain.Dollar;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void given_dollarIs5_whenMultiplied_shouldReturn10() {

    Dollar five = new Dollar(5);
    Dollar ten = five.times(2);

    assertEquals(10, ten.getAmount());

    Dollar fifteen = five.times(3);
    assertEquals(15, fifteen.getAmount());

  }

  @Test
  void given_dollarIs5_whenComparedAgainstAnother5Dollar_shouldReturnTrue() {
    assertEquals(new Dollar(5), new Dollar(5));

  }

  @Test
  void given_dollarIs5_whenComparedAgainstDollar10_shouldReturnFalse() {
    assertNotEquals(new Dollar(5), new Dollar(10));
  }

}
