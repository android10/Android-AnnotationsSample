/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.handler;

import com.fernandocejas.android10.library.annotation.Traceable;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

public class TraceableAnnotationHandler extends AnnotationHandler {

  public TraceableAnnotationHandler() {}

  @Override public void process(ProcessingEnvironment processingEnvironment, Element element) {
    if (element.getKind() == ElementKind.CLASS) {
      TypeElement classElement = (TypeElement) element;
      PackageElement packageElement = (PackageElement) classElement.getEnclosingElement();

      String fullClassName = classElement.getQualifiedName().toString();
      String simpleClassName = classElement.getSimpleName().toString();
      String packageName = packageElement.getQualifiedName().toString();

      printMessage(processingEnvironment,
          this.buildClassDataMessage(simpleClassName, fullClassName, packageName));

    } else if (element.getKind() == ElementKind.FIELD) {
      VariableElement varElement = (VariableElement) element;
      String fieldName = varElement.getSimpleName().toString();

      printMessage(processingEnvironment, buildFieldDataMessage(fieldName));

    } else if (element.getKind() == ElementKind.METHOD) {
      ExecutableElement exeElement = (ExecutableElement) element;
      String methodName = exeElement.getSimpleName().toString();

      printMessage(processingEnvironment, buildMethodDataMessage(methodName));
    }
  }

  private String buildClassDataMessage(String simpleClassName, String fullClassName,
      String packageName) {
    StringBuilder messageBuilder = new StringBuilder();

    messageBuilder.append(Traceable.class.getSimpleName());
    messageBuilder.append(" Annotation found in ");
    messageBuilder.append(simpleClassName);
    messageBuilder.append(" in package ");
    messageBuilder.append(packageName);
    messageBuilder.append(" with full name ");
    messageBuilder.append(fullClassName);

    return messageBuilder.toString();
  }

  private String buildFieldDataMessage(String fieldName) {
    StringBuilder messageBuilder = new StringBuilder();

    messageBuilder.append(Traceable.class.getSimpleName());
    messageBuilder.append(" Annotation found in field ");
    messageBuilder.append(fieldName);

    return messageBuilder.toString();
  }

  private String buildMethodDataMessage(String methodName) {
    StringBuilder messageBuilder = new StringBuilder();

    messageBuilder.append(Traceable.class.getSimpleName());
    messageBuilder.append(" Annotation found in method ");
    messageBuilder.append(methodName);

    return messageBuilder.toString();
  }
}
