package com.fernandocejas.android10.sample.annotations;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

  private final DataPresenter dataPresenter = new DataPresenter();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    dataPresenter.doSomethingOne();
  }
}
