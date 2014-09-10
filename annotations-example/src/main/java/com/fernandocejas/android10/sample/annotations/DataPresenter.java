/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.annotations;

import com.fernandocejas.android10.library.annotation.DebugTrace;

public class DataPresenter {

  @DebugTrace
  public void doSomethingOne() {
    sleep(5);
  }

  public void doSomethingTwo() {
    sleep(5);
  }

  public void doSomethingThree() {
    sleep(5);
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
