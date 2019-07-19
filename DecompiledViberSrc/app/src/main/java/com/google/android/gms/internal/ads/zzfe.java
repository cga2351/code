package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfe extends zzfk
{
  private final zzeh zzwj;
  private long zzzb;

  public zzfe(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2, zzeh paramzzeh)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 53);
    this.zzwj = paramzzeh;
    if (paramzzeh != null)
      this.zzzb = paramzzeh.zzcv();
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.zzwj != null)
    {
      zzbp.zza.zza localzza = this.zzzm;
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(this.zzzb);
      localzza.zzbl(((Long)localMethod.invoke(null, arrayOfObject)).longValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfe
 * JD-Core Version:    0.6.2
 */