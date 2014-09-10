/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.handler;

import com.fernandocejas.android10.library.annotation.Loggable;
import com.fernandocejas.android10.library.annotation.Traceable;
import java.lang.annotation.Annotation;

public class AnnotationHandlerFactory {

  public AnnotationHandlerFactory() {}

  public AnnotationHandler create(Class<? extends Annotation> annotationClass) {
    AnnotationHandler annotationHandler = null;

    if (annotationClass.equals(Traceable.class)) {
      annotationHandler = new TraceableAnnotationHandler();
    } else if (annotationClass.equals(Loggable.class)) {
      annotationHandler = new LoggableAnnotationHandler();
    }

    return annotationHandler;
  }
}
