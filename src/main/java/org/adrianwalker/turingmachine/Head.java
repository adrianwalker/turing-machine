package org.adrianwalker.turingmachine;

public final class Head {

  private final Tape tape;
  private final String leftSymbol;
  private final String rightSymbol;
  private final String noOpSymbol;
  private int position = 0;

  public Head(
          final Tape tape,
          final String leftSymbol, final String rightSymbol, final String noOpSymbol) {

    this.tape = tape;
    this.leftSymbol = leftSymbol;
    this.rightSymbol = rightSymbol;
    this.noOpSymbol = noOpSymbol;
  }

  public void move(final String symbol) {

    if (noOpSymbol.equals(symbol)) {
      return;
    }

    if (leftSymbol.equals(symbol)) {
      position -= 1;
    } else if (rightSymbol.equals(symbol)) {
      position += 1;
    }
  }

  public String read() {

    return tape.getCell(position);
  }

  public void write(final String symbol) {

    if (noOpSymbol.equals(symbol)) {
      return;
    }

    tape.putCell(position, symbol);
  }
}
