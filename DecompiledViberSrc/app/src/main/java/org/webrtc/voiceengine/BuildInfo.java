package org.webrtc.voiceengine;

import android.os.Build;
import android.os.Build.VERSION;

public final class BuildInfo
{
  public static String getAndroidBuildId()
  {
    return Build.ID;
  }

  public static String getBrand()
  {
    return Build.BRAND;
  }

  public static String getBuildRelease()
  {
    return Build.VERSION.RELEASE;
  }

  public static String getBuildType()
  {
    return Build.TYPE;
  }

  public static String getDevice()
  {
    return Build.DEVICE;
  }

  public static String getDeviceManufacturer()
  {
    return Build.MANUFACTURER;
  }

  public static String getDeviceModel()
  {
    return Build.MODEL;
  }

  public static String getProduct()
  {
    return Build.PRODUCT;
  }

  public static int getSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.BuildInfo
 * JD-Core Version:    0.6.2
 */