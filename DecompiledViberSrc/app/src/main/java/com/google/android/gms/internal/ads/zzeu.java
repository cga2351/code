package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzeu extends zzfk
{
  private static final Object zzzl = new Object();
  private static volatile Long zzzn = null;

  public zzeu(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 22);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzzn == null)
      synchronized (zzzl)
      {
        if (zzzn == null)
          zzzn = (Long)this.zzzw.invoke(null, new Object[0]);
      }
    synchronized (this.zzzm)
    {
      this.zzzm.zzav(zzzn.longValue());
      return;
      localObject3 = finally;
      throw localObject3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzeu
 * JD-Core Version:    0.6.2
 */