package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfb extends zzfk
{
  private final boolean zzzr;

  public zzfb(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 61);
    this.zzzr = paramzzdy.zzco();
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    Method localMethod = this.zzzw;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.zzvd.getContext();
    arrayOfObject[1] = Boolean.valueOf(this.zzzr);
    long l = ((Long)localMethod.invoke(null, arrayOfObject)).longValue();
    synchronized (this.zzzm)
    {
      this.zzzm.zzbo(l);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfb
 * JD-Core Version:    0.6.2
 */