package com.viber.jni;

import android.os.Build;
import android.os.Build.VERSION;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class SystemInfo
{
  private static final Logger L = ViberEnv.getLogger();
  private static String applicationDataDir;

  public static String getApplicationDataDir()
  {
    return applicationDataDir;
  }

  public static String getDeviceType()
  {
    return Build.MODEL;
  }

  public static String getOSName()
  {
    return "Android";
  }

  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }

  public static void setApplicationDataDir(String paramString)
  {
    applicationDataDir = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.SystemInfo
 * JD-Core Version:    0.6.2
 */