package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzma
{
  private final Handler handler;
  private final zzlz zzavi;

  public zzma(Handler paramHandler, zzlz paramzzlz)
  {
    if (paramzzlz != null);
    for (Handler localHandler = (Handler)zzsk.checkNotNull(paramHandler); ; localHandler = null)
    {
      this.handler = localHandler;
      this.zzavi = paramzzlz;
      return;
    }
  }

  public final void zzah(int paramInt)
  {
    if (this.zzavi != null)
      this.handler.post(new zzmg(this, paramInt));
  }

  public final void zzc(zzlh paramzzlh)
  {
    if (this.zzavi != null)
      this.handler.post(new zzmd(this, paramzzlh));
  }

  public final void zzc(zznc paramzznc)
  {
    if (this.zzavi != null)
      this.handler.post(new zzmb(this, paramzznc));
  }

  public final void zzc(String paramString, long paramLong1, long paramLong2)
  {
    if (this.zzavi != null)
      this.handler.post(new zzmc(this, paramString, paramLong1, paramLong2));
  }

  public final void zzd(int paramInt, long paramLong1, long paramLong2)
  {
    if (this.zzavi != null)
      this.handler.post(new zzme(this, paramInt, paramLong1, paramLong2));
  }

  public final void zzd(zznc paramzznc)
  {
    if (this.zzavi != null)
      this.handler.post(new zzmf(this, paramzznc));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzma
 * JD-Core Version:    0.6.2
 */