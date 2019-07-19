package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfc extends zzfk
{
  private final StackTraceElement[] zzzs;

  public zzfc(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 45);
    this.zzzs = paramArrayOfStackTraceElement;
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.zzzs != null)
    {
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.zzzs;
      zzdw localzzdw = new zzdw((String)localMethod.invoke(null, arrayOfObject));
      synchronized (this.zzzm)
      {
        this.zzzm.zzbi(localzzdw.zzxa.longValue());
        if (localzzdw.zzxb.booleanValue())
        {
          zzbp.zza.zza localzza2 = this.zzzm;
          if (localzzdw.zzxc.booleanValue());
          for (zzbz localzzbz = zzbz.zzkp; ; localzzbz = zzbz.zzkq)
          {
            localzza2.zzg(localzzbz);
            return;
          }
        }
        this.zzzm.zzg(zzbz.zzkr);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfc
 * JD-Core Version:    0.6.2
 */