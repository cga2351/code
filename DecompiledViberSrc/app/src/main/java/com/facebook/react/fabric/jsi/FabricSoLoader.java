package com.facebook.react.fabric.jsi;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;

public class FabricSoLoader
{
  private static boolean sDidInit = false;

  public static void staticInit()
  {
    if (sDidInit)
      return;
    sDidInit = true;
    Systrace.beginSection(0L, "FabricSoLoader.staticInit::load:fabricjni");
    ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
    SoLoader.loadLibrary("fabricjni");
    ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
    Systrace.endSection(0L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.jsi.FabricSoLoader
 * JD-Core Version:    0.6.2
 */