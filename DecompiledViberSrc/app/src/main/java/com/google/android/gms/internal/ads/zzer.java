package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzer extends zzfk
{
  private long startTime;

  public zzer(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, long paramLong, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 25);
    this.startTime = paramLong;
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    long l = ((Long)this.zzzw.invoke(null, new Object[0])).longValue();
    synchronized (this.zzzm)
    {
      this.zzzm.zzbr(l);
      if (this.startTime != 0L)
      {
        this.zzzm.zzat(l - this.startTime);
        this.zzzm.zzaw(this.startTime);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzer
 * JD-Core Version:    0.6.2
 */