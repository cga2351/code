package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzew extends zzfk
{
  private long zzzo = -1L;

  public zzew(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 12);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    this.zzzm.zzap(-1L);
    zzbp.zza.zza localzza = this.zzzm;
    Method localMethod = this.zzzw;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.zzvd.getContext();
    localzza.zzap(((Long)localMethod.invoke(null, arrayOfObject)).longValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzew
 * JD-Core Version:    0.6.2
 */