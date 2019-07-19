package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NativeRunnable
  implements Runnable
{
  private final HybridData mHybridData;

  private NativeRunnable(HybridData paramHybridData)
  {
    this.mHybridData = paramHybridData;
  }

  public native void run();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.NativeRunnable
 * JD-Core Version:    0.6.2
 */