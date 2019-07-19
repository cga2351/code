package com.facebook.react.devsupport;

import android.os.Build.VERSION;

class WindowOverlayCompat
{
  private static final int ANDROID_OREO = 26;
  private static final int TYPE_APPLICATION_OVERLAY = 2038;
  static final int TYPE_SYSTEM_ALERT;
  static final int TYPE_SYSTEM_OVERLAY;

  static
  {
    int i = 2038;
    if (Build.VERSION.SDK_INT < 26);
    for (int j = 2003; ; j = i)
    {
      TYPE_SYSTEM_ALERT = j;
      if (Build.VERSION.SDK_INT < 26)
        i = 2006;
      TYPE_SYSTEM_OVERLAY = i;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.WindowOverlayCompat
 * JD-Core Version:    0.6.2
 */