/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.library.annotation.runner;

import com.fernandocejas.android10.library.annotation.Loggable;
import com.fernandocejas.android10.library.internal.DebugLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AndroidAnnotationRunner {

 public AndroidAnnotationRunner() {}

 public void processLoggable(Object clazzInstance) {
   Class clazzToProcess = clazzInstance.getClass();
   Method[] methods = clazzToProcess.getMethods();
   for (Method method : methods) {
     Loggable loggable = method.getAnnotation(Loggable.class);
     if (loggable != null) {
       try {
         //we execute the method using reflection.
         method.invoke(clazzInstance);
         DebugLog.log(clazzToProcess.getSimpleName(), "Annotation in " + method.getName());

       } catch (IllegalAccessException e) {
         DebugLog.log(clazzToProcess.getSimpleName(), e.getMessage());
       } catch (InvocationTargetException e) {
         DebugLog.log(clazzToProcess.getSimpleName(), e.getMessage());
       }
     }
   }
 }
}
