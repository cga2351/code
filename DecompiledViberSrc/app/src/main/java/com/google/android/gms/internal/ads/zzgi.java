package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzgi
  implements zzge
{
  private final Handler zzabq;
  private final zzgk zzabr;
  private final CopyOnWriteArraySet<zzgh> zzabs;
  private final boolean[] zzabt;
  private boolean zzabu;
  private int zzabv;
  private int zzabw;

  @SuppressLint({"HandlerLeak"})
  public zzgi(int paramInt1, int paramInt2, int paramInt3)
  {
    Log.i("ExoPlayerImpl", "Init 1.3.1");
    this.zzabu = false;
    this.zzabv = 1;
    this.zzabs = new CopyOnWriteArraySet();
    this.zzabt = new boolean[2];
    while (i < this.zzabt.length)
    {
      this.zzabt[i] = true;
      i++;
    }
    this.zzabq = new zzgj(this);
    this.zzabr = new zzgk(this.zzabq, this.zzabu, this.zzabt, 2500, 5000);
  }

  public final long getBufferedPosition()
  {
    return this.zzabr.getBufferedPosition();
  }

  public final long getDuration()
  {
    return this.zzabr.getDuration();
  }

  public final int getPlaybackState()
  {
    return this.zzabv;
  }

  public final void release()
  {
    this.zzabr.release();
    this.zzabq.removeCallbacksAndMessages(null);
  }

  public final void seekTo(long paramLong)
  {
    this.zzabr.seekTo(paramLong);
  }

  public final void stop()
  {
    this.zzabr.stop();
  }

  final void zza(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return;
      this.zzabv = paramMessage.arg1;
      Iterator localIterator3 = this.zzabs.iterator();
      while (localIterator3.hasNext())
        ((zzgh)localIterator3.next()).zza(this.zzabu, this.zzabv);
      continue;
      this.zzabw = (-1 + this.zzabw);
      if (this.zzabw == 0)
      {
        Iterator localIterator2 = this.zzabs.iterator();
        while (localIterator2.hasNext())
          ((zzgh)localIterator2.next()).zzdo();
        continue;
        zzgd localzzgd = (zzgd)paramMessage.obj;
        Iterator localIterator1 = this.zzabs.iterator();
        while (localIterator1.hasNext())
          ((zzgh)localIterator1.next()).zza(localzzgd);
      }
    }
  }

  public final void zza(zzgf paramzzgf, int paramInt, Object paramObject)
  {
    this.zzabr.zza(paramzzgf, 1, paramObject);
  }

  public final void zza(zzgh paramzzgh)
  {
    this.zzabs.add(paramzzgh);
  }

  public final void zza(zzhp[] paramArrayOfzzhp)
  {
    this.zzabr.zza(paramArrayOfzzhp);
  }

  public final void zzb(zzgf paramzzgf, int paramInt, Object paramObject)
  {
    this.zzabr.zzb(paramzzgf, 1, paramObject);
  }

  public final void zzc(int paramInt, boolean paramBoolean)
  {
    if (this.zzabt[0] != paramBoolean)
    {
      this.zzabt[0] = paramBoolean;
      this.zzabr.zzc(0, paramBoolean);
    }
  }

  public final void zzd(boolean paramBoolean)
  {
    if (this.zzabu != paramBoolean)
    {
      this.zzabu = paramBoolean;
      this.zzabw = (1 + this.zzabw);
      this.zzabr.zzd(paramBoolean);
      Iterator localIterator = this.zzabs.iterator();
      while (localIterator.hasNext())
        ((zzgh)localIterator.next()).zza(paramBoolean, this.zzabv);
    }
  }

  public final boolean zzdm()
  {
    return this.zzabu;
  }

  public final long zzdn()
  {
    return this.zzabr.zzdn();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzgi
 * JD-Core Version:    0.6.2
 */