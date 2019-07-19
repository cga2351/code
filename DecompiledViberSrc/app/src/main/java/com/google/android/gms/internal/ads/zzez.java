package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzez extends zzfk
{
  public zzez(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 73);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    try
    {
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.zzvd.getContext();
      boolean bool = ((Boolean)localMethod.invoke(null, arrayOfObject)).booleanValue();
      zzbp.zza.zza localzza = this.zzzm;
      if (bool);
      for (zzbz localzzbz = zzbz.zzkq; ; localzzbz = zzbz.zzkp)
      {
        localzza.zzh(localzzbz);
        return;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      this.zzzm.zzh(zzbz.zzkr);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzez
 * JD-Core Version:    0.6.2
 */