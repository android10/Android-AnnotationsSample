/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.annotations;

import com.fernandocejas.android10.library.annotation.Loggable;
import com.fernandocejas.android10.library.annotation.Traceable;

@Traceable
public class DataPresenter {

  @Traceable
  private String name = "android10.org";

  public DataPresenter() {

  }

  @Traceable
  public void doSomethingOne() {
    sleep(5);
  }

  @Loggable
  public void doSomethingTwo() {
    this.name = "fernandocejas.com";
  }

  @Loggable
  public void doSomethingThree() {
    sleep(5);
  }

  @Loggable
  public String getName() {
    return name;
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
