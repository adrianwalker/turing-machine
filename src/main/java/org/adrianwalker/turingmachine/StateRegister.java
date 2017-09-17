package org.adrianwalker.turingmachine;

public final class StateRegister {

  private final String haltState;
  private String state;

  public StateRegister(final String haltState, final String startState) {

    this.haltState = haltState;
    this.state = startState;
  }

  public boolean isHaltState() {

    return state.equals(haltState);
  }

  public String getState() {

    return state;
  }

  public void setState(final String state) {

    this.state = state;
  }
}
