package com.yandex.mobile.ads.impl;

import android.util.Log;
import java.util.Locale;

public final class fq extends fp
{
  private static boolean a;

  public static void a(String paramString, Object[] paramArrayOfObject)
  {
    if (a)
      Log.i("Yandex Mobile Ads", String.format(Locale.US, paramString, paramArrayOfObject));
  }

  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }

  public static void b(String paramString, Object[] paramArrayOfObject)
  {
    if (a)
      Log.w("Yandex Mobile Ads", String.format(Locale.US, paramString, paramArrayOfObject));
  }

  public static void c(String paramString, Object[] paramArrayOfObject)
  {
    if (a)
      Log.e("Yandex Mobile Ads", String.format(Locale.US, paramString, paramArrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fq
 * JD-Core Version:    0.6.2
 */