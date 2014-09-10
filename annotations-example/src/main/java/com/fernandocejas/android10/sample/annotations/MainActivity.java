package com.fernandocejas.android10.sample.annotations;

import android.app.Activity;
import android.os.Bundle;
import com.fernandocejas.android10.library.annotation.runner.AndroidAnnotationRunner;

public class MainActivity extends Activity {

  private DataPresenter dataPresenter;
  private AndroidAnnotationRunner annotationRunner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.dataPresenter = new DataPresenter(this);
    /** Check {@link DataPresenter} for seeing the annotations example. */
    dataPresenter.doSomethingOne();

    this.annotationRunner = new AndroidAnnotationRunner();
    /** Process annotations at runtime using reflection. Check {@link AndroidAnnotationRunner} */
    annotationRunner.processLoggable(dataPresenter);
  }
}
