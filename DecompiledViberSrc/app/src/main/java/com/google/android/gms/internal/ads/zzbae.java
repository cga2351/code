package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public class zzbae
{
  public static boolean isLoggable(int paramInt)
  {
    return (paramInt >= 5) || (Log.isLoggable("Ads", paramInt));
  }

  public static void zzb(String paramString, Throwable paramThrowable)
  {
    if (isLoggable(3))
      Log.d("Ads", paramString, paramThrowable);
  }

  public static void zzc(String paramString, Throwable paramThrowable)
  {
    if (isLoggable(6))
      Log.e("Ads", paramString, paramThrowable);
  }

  public static void zzd(String paramString, Throwable paramThrowable)
  {
    if (isLoggable(5))
      Log.w("Ads", paramString, paramThrowable);
  }

  public static void zzdp(String paramString)
  {
    if (isLoggable(3))
      Log.d("Ads", paramString);
  }

  public static void zze(String paramString, Throwable paramThrowable)
  {
    if (isLoggable(5))
    {
      if (paramThrowable != null)
        zzd(zzeq(paramString), paramThrowable);
    }
    else
      return;
    zzep(zzeq(paramString));
  }

  public static void zzen(String paramString)
  {
    if (isLoggable(6))
      Log.e("Ads", paramString);
  }

  public static void zzeo(String paramString)
  {
    if (isLoggable(4))
      Log.i("Ads", paramString);
  }

  public static void zzep(String paramString)
  {
    if (isLoggable(5))
      Log.w("Ads", paramString);
  }

  @VisibleForTesting
  private static String zzeq(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement.length >= 4)
    {
      int i = arrayOfStackTraceElement[3].getLineNumber();
      paramString = 13 + String.valueOf(paramString).length() + paramString + " @" + i;
    }
    return paramString;
  }

  public static void zzer(String paramString)
  {
    zze(paramString, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbae
 * JD-Core Version:    0.6.2
 */