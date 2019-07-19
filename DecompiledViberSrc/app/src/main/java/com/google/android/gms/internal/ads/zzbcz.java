package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import java.util.concurrent.TimeUnit;

@zzare
@TargetApi(14)
public final class zzbcz
{
  private final long zzect;
  private long zzecu;
  private boolean zzecv;

  zzbcz()
  {
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    zzaci localzzaci = zzact.zzcmf;
    this.zzect = localTimeUnit.toNanos(((Long)zzyr.zzpe().zzd(localzzaci)).longValue());
    this.zzecv = true;
  }

  public final void zza(SurfaceTexture paramSurfaceTexture, zzbco paramzzbco)
  {
    if (paramzzbco == null);
    long l;
    do
    {
      return;
      l = paramSurfaceTexture.getTimestamp();
    }
    while ((!this.zzecv) && (Math.abs(l - this.zzecu) < this.zzect));
    this.zzecv = false;
    this.zzecu = l;
    zzaxj.zzdvx.post(new zzbda(this, paramzzbco));
  }

  public final void zzxm()
  {
    this.zzecv = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbcz
 * JD-Core Version:    0.6.2
 */