package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;

@TargetApi(18)
@DoNotOptimize
class Api18TraceUtils
{
  public static void beginTraceSection(String paramString)
  {
    Trace.beginSection(paramString);
  }

  public static void endSection()
  {
    Trace.endSection();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.soloader.Api18TraceUtils
 * JD-Core Version:    0.6.2
 */