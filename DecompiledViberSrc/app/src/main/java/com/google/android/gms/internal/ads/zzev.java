package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzev extends zzfk
{
  public zzev(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 11);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    zzbp.zza.zza localzza = this.zzzm;
    Method localMethod = this.zzzw;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.zzvd.getContext();
    localzza.zzao(((Long)localMethod.invoke(null, arrayOfObject)).longValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzev
 * JD-Core Version:    0.6.2
 */