/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.handler;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;

public abstract class AnnotationHandler {
  public abstract void process(ProcessingEnvironment processingEnvironment, Element element);

  protected void printMessage(ProcessingEnvironment processingEnvironment, String message) {
    processingEnvironment.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
  }
}
