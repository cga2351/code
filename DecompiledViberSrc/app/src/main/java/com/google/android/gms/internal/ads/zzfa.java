package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public final class zzfa extends zzfk
{
  private List<Long> zzzq = null;

  public zzfa(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 31);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    this.zzzm.zzax(-1L);
    this.zzzm.zzay(-1L);
    if (this.zzzq == null)
    {
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.zzvd.getContext();
      this.zzzq = ((List)localMethod.invoke(null, arrayOfObject));
    }
    if ((this.zzzq != null) && (this.zzzq.size() == 2))
      synchronized (this.zzzm)
      {
        this.zzzm.zzax(((Long)this.zzzq.get(0)).longValue());
        this.zzzm.zzay(((Long)this.zzzq.get(1)).longValue());
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfa
 * JD-Core Version:    0.6.2
 */