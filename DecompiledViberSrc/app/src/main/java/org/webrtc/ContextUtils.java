package org.webrtc;

import android.content.Context;

public class ContextUtils
{
  private static final String TAG = "ContextUtils";
  private static Context applicationContext;

  @Deprecated
  public static Context getApplicationContext()
  {
    return applicationContext;
  }

  public static void initialize(Context paramContext)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("Application context cannot be null for ContextUtils.initialize.");
    applicationContext = paramContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.ContextUtils
 * JD-Core Version:    0.6.2
 */