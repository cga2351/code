package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzeq extends zzfk
{
  private static volatile Long zzzk = null;
  private static final Object zzzl = new Object();

  public zzeq(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 44);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (zzzk == null)
      synchronized (zzzl)
      {
        if (zzzk == null)
          zzzk = (Long)this.zzzw.invoke(null, new Object[0]);
      }
    synchronized (this.zzzm)
    {
      this.zzzm.zzbh(zzzk.longValue());
      return;
      localObject3 = finally;
      throw localObject3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzeq
 * JD-Core Version:    0.6.2
 */