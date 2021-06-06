package dev.inventio.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import dev.inventio.domain.domain.Dollar;
import dev.inventio.domain.domain.Franc;

import org.junit.jupiter.api.Test;

public class MoneyTest {

  @Test
  void given_dollarIs5_whenMultiplied_shouldReturn10() {

    Dollar five = new Dollar(5);
    Dollar ten = five.times(2);

    assertEquals(new Dollar(10), ten);

    Dollar fifteen = five.times(3);
    assertEquals(new Dollar(15), fifteen);

  }

  @Test
  void given_dollarIs5_whenComparedAgainstAnother5Dollar_shouldReturnTrue() {
    assertEquals(new Dollar(5), new Dollar(5));

  }

  @Test
  void given_dollarIs5_whenComparedAgainstDollar10_shouldReturnFalse() {
    assertNotEquals(new Dollar(5), new Dollar(10));
  }

  @Test
  void given_FrancIs5_whenMultiplied_shouldReturn10() {

    Franc five = new Franc(5);
    Franc ten = five.times(2);

    assertEquals(new Franc(10), ten);

    Franc fifteen = five.times(3);
    assertEquals(new Franc(15), fifteen);

  }

  @Test
  void given_FrancIs5_whenComparedAgainstAnother5Franc_shouldReturnTrue() {
    assertEquals(new Franc(5), new Franc(5));

  }

  @Test
  void given_FrancIs5_whenComparedAgainstFranc10_shouldReturnFalse() {
    assertNotEquals(new Franc(5), new Franc(10));
  }

}
