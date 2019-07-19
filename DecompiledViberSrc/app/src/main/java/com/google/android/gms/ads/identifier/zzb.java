package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

public final class zzb
{
  private SharedPreferences zzs;

  public zzb(Context paramContext)
  {
    try
    {
      Context localContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (localContext == null);
      SharedPreferences localSharedPreferences;
      for (Object localObject = null; ; localObject = localSharedPreferences)
      {
        this.zzs = localObject;
        return;
        localSharedPreferences = localContext.getSharedPreferences("google_ads_flags", 0);
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("GmscoreFlag", "Error while getting SharedPreferences ", localThrowable);
      this.zzs = null;
    }
  }

  public final boolean getBoolean(String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.zzs == null)
        return false;
      boolean bool = this.zzs.getBoolean(paramString, false);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", localThrowable);
    }
    return false;
  }

  final float getFloat(String paramString, float paramFloat)
  {
    try
    {
      if (this.zzs == null)
        return 0.0F;
      float f = this.zzs.getFloat(paramString, 0.0F);
      return f;
    }
    catch (Throwable localThrowable)
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", localThrowable);
    }
    return 0.0F;
  }

  final String getString(String paramString1, String paramString2)
  {
    try
    {
      if (this.zzs == null)
        return paramString2;
      String str = this.zzs.getString(paramString1, paramString2);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", localThrowable);
    }
    return paramString2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zzb
 * JD-Core Version:    0.6.2
 */