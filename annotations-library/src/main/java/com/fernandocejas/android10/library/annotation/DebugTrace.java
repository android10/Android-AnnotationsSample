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

/**
 * Indicates that the annotated method is being traced (debug mode only) and
 * will use {@link android.util.Log} to print debug data:
 * - Method name.
 * - Method arguments.
 * - Total execution time.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ CONSTRUCTOR, METHOD })
public @interface DebugTrace {
  LoggingLevel value() default LoggingLevel.EVERYTHING;

  /**
   * Enum for setting up {@link DebugTrace} annotation.
   */
  public enum LoggingLevel {
    /** Will show on log: method name, arguments, total execution time. */
    EVERYTHING,
    /** Will show on log: method arguments. */
    ARGUMENTS,
    /** Will show on log: total execution time. */
    TIME
  }
}
