package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import java.util.Map;

@TargetApi(16)
public abstract interface k<T extends n>
{
  public abstract int e();

  public abstract a f();

  public abstract T g();

  public abstract Map<String, String> h();

  public static class a extends Exception
  {
    public a(Throwable paramThrowable)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.k
 * JD-Core Version:    0.6.2
 */