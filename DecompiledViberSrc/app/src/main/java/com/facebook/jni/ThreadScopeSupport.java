package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class ThreadScopeSupport
{
  static
  {
    SoLoader.loadLibrary("fb");
  }

  @DoNotStrip
  private static void runStdFunction(long paramLong)
  {
    runStdFunctionImpl(paramLong);
  }

  private static native void runStdFunctionImpl(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.ThreadScopeSupport
 * JD-Core Version:    0.6.2
 */