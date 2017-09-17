package org.adrianwalker.turingmachine;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public final class TuringMachineTest {

  private static final String BLANK = "0";
  private static final String MOVE_LEFT = "L";
  private static final String MOVE_RIGHT = "R";
  private static final String NO_OP = "N";
  private static final String HALT_STATE = "H";
  private static final String START_STATE = "A";

  @Test
  public void testBusyBeaver() {

    Tape tape = new Tape(BLANK);
    Head head = new Head(tape, MOVE_LEFT, MOVE_RIGHT, NO_OP);
    StateRegister stateRegister = new StateRegister(HALT_STATE, START_STATE);

    Table table = new Table();
    table.put("A", "0", "1", "R", "B");
    table.put("A", "1", "1", "L", "C");
    table.put("B", "0", "1", "L", "A");
    table.put("B", "1", "1", "R", "B");
    table.put("C", "0", "1", "L", "B");
    table.put("C", "1", "1", "N", "H");

    TuringMachine machine = new TuringMachine(head, stateRegister, table);
    long steps = machine.execute();

    assertEquals(13, steps);
    assertEquals(asList("1", "1", "1", "1", "1", "1"), tape.getCells());
  }

  @Test
  public void testCopySubroutine() {

    Tape tape = new Tape(BLANK);
    tape.putCells(asList("1", "1", "1"));

    Head head = new Head(tape, MOVE_LEFT, MOVE_RIGHT, NO_OP);
    StateRegister stateRegister = new StateRegister(HALT_STATE, START_STATE);

    Table table = new Table();
    table.put("A", "0", "N", "N", "H");
    table.put("A", "1", "0", "R", "B");
    table.put("B", "0", "0", "R", "C");
    table.put("B", "1", "1", "R", "B");
    table.put("C", "0", "1", "L", "D");
    table.put("C", "1", "1", "R", "C");
    table.put("D", "0", "0", "L", "E");
    table.put("D", "1", "1", "L", "D");
    table.put("E", "0", "1", "R", "A");
    table.put("E", "1", "1", "L", "E");

    TuringMachine machine = new TuringMachine(head, stateRegister, table);
    long steps = machine.execute();

    assertEquals(28, steps);
    assertEquals(asList("1", "1", "1", "0", "1", "1", "1"), tape.getCells());
  }
}
