package org.adrianwalker.turingmachine;

public final class TurningMachine {

  private final Head head;
  private final StateRegister stateRegister;
  private final Table table;

  public TurningMachine(final Head head, final StateRegister stateRegister, final Table table) {

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

      String[] triple = table.get(state, symbol);
      head.write(triple[0]);
      head.move(triple[1]);
      stateRegister.setState(triple[2]);
    }

    return steps;
  }
}
