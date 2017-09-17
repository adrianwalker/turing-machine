package org.adrianwalker.turingmachine;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

import java.util.List;
import java.util.TreeMap;

public final class Tape {

  private final TreeMap<Integer, String> cells;
  private final String blank;

  public Tape(final String blank) {

    this.cells = new TreeMap<>();
    this.blank = blank;
  }

  public List<String> getCells() {

    return rangeClosed(cells.firstKey(), cells.lastKey())
            .boxed()
            .map(i -> getCell(i))
            .collect(toList());
  }

  public void putCells(final List<String> symbols) {

    range(0, symbols.size())
            .boxed()
            .forEach(i -> putCell(i, symbols.get(i)));
  }

  public String getCell(final int position) {

    return cells.getOrDefault(position, blank);
  }

  public void putCell(final int position, final String symbol) {

    cells.put(position, symbol);
  }
}
