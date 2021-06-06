package dev.inventio.domain.domain;

import java.util.Objects;

public class Pair {

  private final Currency from;
  private final Currency to;

  public Pair(Currency from, Currency to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object presented) {
    if (this == presented) {
      return true;
    }
    if (presented == null || getClass() != presented.getClass()) {
      return false;
    }
    Pair pair = (Pair) presented;
    return from == pair.from && to == pair.to;
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, to);
  }
}
