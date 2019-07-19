package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class Countable
{

  @DoNotStrip
  private long mInstance = 0L;

  static
  {
    SoLoader.loadLibrary("fb");
  }

  public native void dispose();

  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.Countable
 * JD-Core Version:    0.6.2
 */