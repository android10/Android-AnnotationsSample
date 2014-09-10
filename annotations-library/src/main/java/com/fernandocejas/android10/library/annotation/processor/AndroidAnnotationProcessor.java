/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.processor;

import com.fernandocejas.android10.library.annotation.DebugTrace;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class AndroidAnnotationProcessor extends AbstractProcessor {

  private final AnnotationProcessorHelper annotationProcessorHelper;

  public AndroidAnnotationProcessor() {
    super();
    this.annotationProcessorHelper = new AnnotationProcessorHelper();
  }

  @Override public SourceVersion getSupportedSourceVersion() {
    return this.annotationProcessorHelper.getSupportedSourceVersion();
  }

  @Override public Set<String> getSupportedAnnotationTypes() {
    return this.annotationProcessorHelper.getSupportedAnnotations();
  }

  @Override public boolean process(Set<? extends TypeElement> typeElements,
      RoundEnvironment roundEnvironment) {

    for (Element element : roundEnvironment.getElementsAnnotatedWith(DebugTrace.class)) {
      if (isValidElement(element)) {
        String methodName = element.getSimpleName().toString();
        String message =
            "Debug trace annotation found!!!" + "in " + methodName + " " + element.getKind().name();
        this.printMessage(message);
      } else {
        throw new RuntimeException("Unsupported modifier for element of type: "
            + element.getKind().name()
            + " in "
            + element.getSimpleName().toString());
      }
    }
    return true;
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

  private void printMessage(String message) {
    processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, message);
  }
}
