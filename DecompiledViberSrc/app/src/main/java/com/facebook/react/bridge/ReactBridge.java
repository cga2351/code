package com.facebook.react.bridge;

import android.os.SystemClock;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;

public class ReactBridge
{
  private static boolean sDidInit = false;
  private static volatile long sLoadEndTime;
  private static volatile long sLoadStartTime = 0L;

  static
  {
    sLoadEndTime = 0L;
  }

  public static long getLoadEndTime()
  {
    return sLoadEndTime;
  }

  public static long getLoadStartTime()
  {
    return sLoadStartTime;
  }

  public static void staticInit()
  {
    try
    {
      boolean bool = sDidInit;
      if (bool);
      while (true)
      {
        return;
        sDidInit = true;
        sLoadStartTime = SystemClock.uptimeMillis();
        Systrace.beginSection(0L, "ReactBridge.staticInit::load:reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
        SoLoader.loadLibrary("reactnativejni");
        ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
        Systrace.endSection(0L);
        sLoadEndTime = SystemClock.uptimeMillis();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactBridge
 * JD-Core Version:    0.6.2
 */