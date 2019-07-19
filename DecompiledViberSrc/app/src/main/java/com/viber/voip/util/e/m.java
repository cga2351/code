package com.viber.voip.util.e;

import java.lang.reflect.Method;
import pl.droidsonroids.gif.c;

public class m extends c
{
  static
  {
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "pl_droidsonroids_gif";
      arrayOfObject[1] = Boolean.valueOf(false);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("pl_droidsonroids_gif");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.m
 * JD-Core Version:    0.6.2
 */