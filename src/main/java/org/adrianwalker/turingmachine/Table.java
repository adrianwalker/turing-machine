package org.adrianwalker.turingmachine;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

public final class Table {

  private static final String SEPARATOR = ":";
  private static final String VALUE_FORMAT = "%s" + SEPARATOR + "%s" + SEPARATOR + "%s";
  private static final String KEY_FORMAT = "%s" + SEPARATOR + "%s";

  private final Map<String, String> table;

  public Table() {

    table = new HashMap<>();
  }

  public void put(
          final String state, final String symbol,
          final String writeSymbol, final String moveTape, final String nextState) {

    table.put(
            format(KEY_FORMAT, state, symbol),
            format(VALUE_FORMAT, writeSymbol, moveTape, nextState));
  }

  public String[] get(final String state, final String symbol) {

    return table.get(format(KEY_FORMAT, state, symbol)).split(SEPARATOR);
  }
}
