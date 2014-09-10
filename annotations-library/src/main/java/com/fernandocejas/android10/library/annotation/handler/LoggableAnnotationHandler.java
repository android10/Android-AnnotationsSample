/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.handler;

import com.fernandocejas.android10.library.annotation.Loggable;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;

public class LoggableAnnotationHandler extends AnnotationHandler {

  public LoggableAnnotationHandler() {}

  @Override public void process(ProcessingEnvironment processingEnvironment, Element element) {
    if (isValidElement(element)) {
      //TODO: Do something with the annotation here.
      //TODO: Like generate new files, etc
      this.printMessage(processingEnvironment, this.buildInformationMessage(element));
    } else {
      throw new RuntimeException(this.buildErrorMessage(element));
    }
  }

  private boolean isValidElement(Element element) {
    boolean isValid = false;
    Set<Modifier> modifiers = element.getModifiers();

    if (modifiers != null) {
      isValid = !(modifiers.contains(Modifier.FINAL) || modifiers.contains(Modifier.STATIC) ||
          modifiers.contains(Modifier.ABSTRACT));
    }

    return isValid;
  }

  private String buildInformationMessage(Element element) {
    StringBuilder messageBuilder = new StringBuilder();

    messageBuilder.append(Loggable.class.getSimpleName());
    messageBuilder.append(" Annotation found in ");
    messageBuilder.append(element.getSimpleName().toString());
    messageBuilder.append(" ");
    messageBuilder.append(element.getKind().name());

    return messageBuilder.toString();
  }

  private String buildErrorMessage(Element element) {
    StringBuilder messageBuilder = new StringBuilder();

    messageBuilder.append("Unsupported modifier for element of type: ");
    messageBuilder.append(element.getKind().name());
    messageBuilder.append(" in ");
    messageBuilder.append(element.getSimpleName().toString());

    return messageBuilder.toString();
  }
}
