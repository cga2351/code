package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzfk
  implements Callable
{
  private final String TAG = getClass().getSimpleName();
  private final String className;
  private final int zzaaa;
  private final int zzaab;
  protected final zzdy zzvd;
  protected final zzbp.zza.zza zzzm;
  private final String zzzu;
  protected Method zzzw;

  public zzfk(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    this.zzvd = paramzzdy;
    this.className = paramString1;
    this.zzzu = paramString2;
    this.zzzm = paramzza;
    this.zzaaa = paramInt1;
    this.zzaab = paramInt2;
  }

  protected abstract void zzcx()
    throws IllegalAccessException, InvocationTargetException;

  public Void zzcz()
    throws Exception
  {
    try
    {
      long l = System.nanoTime();
      this.zzzw = this.zzvd.zzc(this.className, this.zzzu);
      if (this.zzzw == null)
        return null;
      zzcx();
      zzda localzzda = this.zzvd.zzcm();
      if ((localzzda != null) && (this.zzaaa != -2147483648))
      {
        localzzda.zza(this.zzaab, this.zzaaa, (System.nanoTime() - l) / 1000L);
        return null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfk
 * JD-Core Version:    0.6.2
 */