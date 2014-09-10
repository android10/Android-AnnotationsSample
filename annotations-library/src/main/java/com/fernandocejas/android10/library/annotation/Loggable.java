/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.RUNTIME)
@Target({ CONSTRUCTOR, METHOD })
public @interface Loggable {
  LoggingLevel value() default LoggingLevel.EVERYTHING;

  public enum LoggingLevel {
    EVERYTHING,
    ARGUMENTS,
    TIME
  }
}
