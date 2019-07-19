package com.google.android.gms.internal.ads;

import android.os.Trace;

public final class zzsx
{
  public static void beginSection(String paramString)
  {
    if (zzsy.SDK_INT >= 18)
      Trace.beginSection(paramString);
  }

  public static void endSection()
  {
    if (zzsy.SDK_INT >= 18)
      Trace.endSection();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsx
 * JD-Core Version:    0.6.2
 */