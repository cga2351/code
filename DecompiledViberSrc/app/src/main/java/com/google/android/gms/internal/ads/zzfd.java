package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfd extends zzfk
{
  public zzfd(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 51);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    synchronized (this.zzzm)
    {
      zzdx localzzdx = new zzdx((String)this.zzzw.invoke(null, new Object[0]));
      this.zzzm.zzbj(localzzdx.zzxd.longValue());
      this.zzzm.zzbk(localzzdx.zzxe.longValue());
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfd
 * JD-Core Version:    0.6.2
 */