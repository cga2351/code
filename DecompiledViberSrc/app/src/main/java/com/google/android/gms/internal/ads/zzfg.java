package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfg extends zzfk
{
  public zzfg(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 48);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    this.zzzm.zze(zzbz.zzkr);
    Method localMethod = this.zzzw;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.zzvd.getContext();
    boolean bool = ((Boolean)localMethod.invoke(null, arrayOfObject)).booleanValue();
    zzbp.zza.zza localzza = this.zzzm;
    if (bool);
    try
    {
      this.zzzm.zze(zzbz.zzkq);
      while (true)
      {
        return;
        this.zzzm.zze(zzbz.zzkp);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfg
 * JD-Core Version:    0.6.2
 */