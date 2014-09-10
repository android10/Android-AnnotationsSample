/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.annotations;

import android.content.Context;
import android.widget.Toast;
import com.fernandocejas.android10.library.annotation.Loggable;
import com.fernandocejas.android10.library.annotation.Traceable;

@Traceable
public class DataPresenter {

  private final Context context;

  @Traceable
  private String name = "android10.org";

  public DataPresenter(Context context) {
    this.context = context.getApplicationContext();
  }

  @Traceable
  public void doSomethingOne() {
    sleep(5);
  }

  @Loggable
  public void doSomethingTwo() {
    Toast.makeText(this.context, "Yeah!!! Done using reflection on methods with @Loggable annotion",
        Toast.LENGTH_LONG).show();
  }

  @Loggable
  public void doSomethingThree() {
    Toast.makeText(this.context, "Yeah!!! Done using reflection on methods with @Loggable annotion",
        Toast.LENGTH_LONG).show();
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
