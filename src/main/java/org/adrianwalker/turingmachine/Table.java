package org.adrianwalker.turingmachine;

import java.util.HashMap;
import java.util.Map;

public final class Table {

  public static final class Entry {

    private final String state;
    private final String symbol;
    private final String writeSymbol;
    private final String moveTape;
    private final String nextState;

    public Entry(
            final String state, final String symbol,
            final String writeSymbol, final String moveTape, final String nextState) {

      this.state = state;
      this.symbol = symbol;
      this.writeSymbol = writeSymbol;
      this.moveTape = moveTape;
      this.nextState = nextState;
    }

    public String getState() {
      return state;
    }

    public String getSymbol() {
      return symbol;
    }

    public String getWriteSymbol() {
      return writeSymbol;
    }

    public String getMoveTape() {
      return moveTape;
    }

    public String getNextState() {
      return nextState;
    }
  }

  private static final String SEPARATOR = "_";

  private final Map<String, Entry> table;

  public Table() {

    table = new HashMap<>();
  }

  public void put(
          final String state, final String symbol,
          final String writeSymbol, final String moveTape, final String nextState) {

    table.put(
            state + SEPARATOR + symbol,
            new Entry(state, symbol, writeSymbol, moveTape, nextState));
  }

  public Entry get(final String state, final String symbol) {

    return table.get(state + SEPARATOR + symbol);
  }
}
