package com.facebook.jni;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class CpuCapabilitiesJni
{
  static
  {
    SoLoader.loadLibrary("fb");
  }

  @DoNotStrip
  public static native boolean nativeDeviceSupportsNeon();

  @DoNotStrip
  public static native boolean nativeDeviceSupportsVFPFP16();

  @DoNotStrip
  public static native boolean nativeDeviceSupportsX86();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.jni.CpuCapabilitiesJni
 * JD-Core Version:    0.6.2
 */