package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

public final class zzto
{
  private final Handler handler;
  private final zztn zzbpt;

  public zzto(Handler paramHandler, zztn paramzztn)
  {
    if (paramzztn != null);
    for (Handler localHandler = (Handler)zzsk.checkNotNull(paramHandler); ; localHandler = null)
    {
      this.handler = localHandler;
      this.zzbpt = paramzztn;
      return;
    }
  }

  public final void zzb(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztt(this, paramInt1, paramInt2, paramInt3, paramFloat));
  }

  public final void zzc(Surface paramSurface)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztu(this, paramSurface));
  }

  public final void zzc(zzlh paramzzlh)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztr(this, paramzzlh));
  }

  public final void zzc(zznc paramzznc)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztp(this, paramzznc));
  }

  public final void zzc(String paramString, long paramLong1, long paramLong2)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztq(this, paramString, paramLong1, paramLong2));
  }

  public final void zzd(zznc paramzznc)
  {
    if (this.zzbpt != null)
      this.handler.post(new zztv(this, paramzznc));
  }

  public final void zzg(int paramInt, long paramLong)
  {
    if (this.zzbpt != null)
      this.handler.post(new zzts(this, paramInt, paramLong));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzto
 * JD-Core Version:    0.6.2
 */