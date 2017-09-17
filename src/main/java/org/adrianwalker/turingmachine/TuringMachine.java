package org.adrianwalker.turingmachine;

import org.adrianwalker.turingmachine.Table.Entry;

public final class TuringMachine {

  private final Head head;
  private final StateRegister stateRegister;
  private final Table table;

  public TuringMachine(final Head head, final StateRegister stateRegister, final Table table) {

    this.head = head;
    this.stateRegister = stateRegister;
    this.table = table;
  }

  public long execute() {

    long steps = 0;

    while (!stateRegister.isHaltState()) {

      steps++;

      String state = stateRegister.getState();
      String symbol = head.read();

      Entry entry = table.get(state, symbol);
      head.write(entry.getWriteSymbol());
      head.move(entry.getMoveTape());
      stateRegister.setState(entry.getNextState());
    }

    return steps;
  }
}
