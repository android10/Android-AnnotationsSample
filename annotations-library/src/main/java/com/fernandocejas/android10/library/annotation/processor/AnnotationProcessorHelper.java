/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.processor;

import com.fernandocejas.android10.library.annotation.Loggable;
import com.fernandocejas.android10.library.annotation.Traceable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;

public class AnnotationProcessorHelper {

  @SuppressWarnings("unchecked")
  private static final List<? extends Class<? extends Annotation>> SUPPORTED_ANNOTATIONS =
      Arrays.asList(Loggable.class, Traceable.class);

  protected SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  protected Set<String> getSupportedAnnotationTypes() {
    Set<String> supportedTypes = new LinkedHashSet<String>();
    for (Class<? extends Annotation> annotationType : SUPPORTED_ANNOTATIONS) {
      supportedTypes.add(annotationType.getCanonicalName());
    }

    return supportedTypes;
  }

  protected List<? extends Class<? extends Annotation>> getSupportedAnnotationClasses() {
    return SUPPORTED_ANNOTATIONS;
  }
}
