/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.processor;

import com.fernandocejas.android10.library.annotation.handler.AnnotationHandler;
import com.fernandocejas.android10.library.annotation.handler.AnnotationHandlerFactory;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class AndroidAnnotationProcessor extends AbstractProcessor {

  private final AnnotationProcessorHelper annotationProcessorHelper;
  private final AnnotationHandlerFactory annotationHandlerFactory;

  public AndroidAnnotationProcessor() {
    super();
    this.annotationProcessorHelper = new AnnotationProcessorHelper();
    this.annotationHandlerFactory = new AnnotationHandlerFactory();
  }

  @Override public SourceVersion getSupportedSourceVersion() {
    return this.annotationProcessorHelper.getSupportedSourceVersion();
  }

  @Override public Set<String> getSupportedAnnotationTypes() {
    return this.annotationProcessorHelper.getSupportedAnnotationTypes();
  }

  @Override public boolean process(Set<? extends TypeElement> typeElements,
      RoundEnvironment roundEnvironment) {

    for (Class<? extends Annotation> annotation : this.annotationProcessorHelper.getSupportedAnnotationClasses()) {
      for (Element element : roundEnvironment.getElementsAnnotatedWith(annotation)) {
        AnnotationHandler annotationHandler = this.annotationHandlerFactory.create(annotation);
        if (annotationHandler != null) {
          annotationHandler.process(processingEnv, element);
        }
      }
    }
    return true;
  }
}
