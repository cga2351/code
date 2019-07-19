package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzep extends zzfk
{
  public zzep(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 5);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    this.zzzm.zzam(-1L);
    this.zzzm.zzan(-1L);
    Method localMethod = this.zzzw;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.zzvd.getContext();
    int[] arrayOfInt = (int[])localMethod.invoke(null, arrayOfObject);
    synchronized (this.zzzm)
    {
      this.zzzm.zzam(arrayOfInt[0]);
      this.zzzm.zzan(arrayOfInt[1]);
      if (arrayOfInt[2] != -2147483648)
        this.zzzm.zzbm(arrayOfInt[2]);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzep
 * JD-Core Version:    0.6.2
 */