package com.google.android.exoplayer2.g;

import android.annotation.TargetApi;
import android.os.Trace;

public final class ae
{
  public static void a()
  {
    if (ag.a >= 18)
      b();
  }

  public static void a(String paramString)
  {
    if (ag.a >= 18)
      b(paramString);
  }

  @TargetApi(18)
  private static void b()
  {
    Trace.endSection();
  }

  @TargetApi(18)
  private static void b(String paramString)
  {
    Trace.beginSection(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ae
 * JD-Core Version:    0.6.2
 */