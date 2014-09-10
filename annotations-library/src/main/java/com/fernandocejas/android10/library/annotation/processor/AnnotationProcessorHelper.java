/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.processor;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.lang.model.SourceVersion;
import com.fernandocejas.android10.library.annotation.DebugTrace;

public class AnnotationProcessorHelper {

  @SuppressWarnings("unchecked")
  private static final List<? extends Class<? extends Annotation>> SUPPORTED_ANNOTATIONS =
      Arrays.asList(DebugTrace.class);

  protected SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  protected Set<String> getSupportedAnnotations() {
    Set<String> supportedTypes = new LinkedHashSet<String>();
    for (Class<? extends Annotation> annotationType : SUPPORTED_ANNOTATIONS) {
      supportedTypes.add(annotationType.getCanonicalName());
    }

    return supportedTypes;
  }
}
