package com.adjust.sdk;

import android.content.Context;
import android.provider.Settings.Secure;

public class AndroidIdUtil
{
  public static String getAndroidId(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AndroidIdUtil
 * JD-Core Version:    0.6.2
 */