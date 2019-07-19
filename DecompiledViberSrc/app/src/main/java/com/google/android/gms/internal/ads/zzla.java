package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzla
  implements zzkv
{
  private int repeatMode;
  private final Handler zzabq;
  private final CopyOnWriteArraySet<zzkw> zzabs;
  private boolean zzabu;
  private int zzabv;
  private final zzlo[] zzaro;
  private final zzrp zzarp;
  private final zzro zzarq;
  private final zzlc zzarr;
  private final zzlu zzars;
  private final zzlt zzart;
  private boolean zzaru;
  private int zzarv;
  private int zzarw;
  private boolean zzarx;
  private zzlr zzary;
  private Object zzarz;
  private zzrb zzasa;
  private zzro zzasb;
  private zzln zzasc;
  private zzle zzasd;
  private int zzase;
  private int zzasf;
  private long zzasg;

  @SuppressLint({"HandlerLeak"})
  public zzla(zzlo[] paramArrayOfzzlo, zzrp paramzzrp, zzll paramzzll)
  {
    String str = zzsy.zzbnq;
    Log.i("ExoPlayerImpl", 1 + String.valueOf("Init ExoPlayerLib/2.4.2 [").length() + String.valueOf(str).length() + "Init ExoPlayerLib/2.4.2 [" + str + "]");
    boolean bool;
    if (paramArrayOfzzlo.length > 0)
    {
      bool = true;
      zzsk.checkState(bool);
      this.zzaro = ((zzlo[])zzsk.checkNotNull(paramArrayOfzzlo));
      this.zzarp = ((zzrp)zzsk.checkNotNull(paramzzrp));
      this.zzabu = false;
      this.repeatMode = 0;
      this.zzabv = 1;
      this.zzabs = new CopyOnWriteArraySet();
      this.zzarq = new zzro(new zzrm[paramArrayOfzzlo.length]);
      this.zzary = zzlr.zzaum;
      this.zzars = new zzlu();
      this.zzart = new zzlt();
      this.zzasa = zzrb.zzbkw;
      this.zzasb = this.zzarq;
      this.zzasc = zzln.zzaug;
      if (Looper.myLooper() == null)
        break label260;
    }
    label260: for (Looper localLooper = Looper.myLooper(); ; localLooper = Looper.getMainLooper())
    {
      this.zzabq = new zzlb(this, localLooper);
      this.zzasd = new zzle(0, 0L);
      this.zzarr = new zzlc(paramArrayOfzzlo, paramzzrp, paramzzll, this.zzabu, 0, this.zzabq, this.zzasd, this);
      return;
      bool = false;
      break;
    }
  }

  private final int zzgu()
  {
    if ((this.zzary.isEmpty()) || (this.zzarv > 0))
      return this.zzase;
    this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
    return 0;
  }

  public final long getBufferedPosition()
  {
    if ((this.zzary.isEmpty()) || (this.zzarv > 0))
      return this.zzasg;
    this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
    return this.zzart.zzhh() + zzkt.zzdz(this.zzasd.zzacm);
  }

  public final long getDuration()
  {
    if (this.zzary.isEmpty())
      return -9223372036854775807L;
    return zzkt.zzdz(this.zzary.zza(zzgu(), this.zzars, false).zzack);
  }

  public final int getPlaybackState()
  {
    return this.zzabv;
  }

  public final void release()
  {
    this.zzarr.release();
    this.zzabq.removeCallbacksAndMessages(null);
  }

  public final void seekTo(long paramLong)
  {
    int i = zzgu();
    if ((i < 0) || ((!this.zzary.isEmpty()) && (i >= this.zzary.zzhf())))
      throw new zzlk(this.zzary, i, paramLong);
    this.zzarv = (1 + this.zzarv);
    this.zzase = i;
    if (this.zzary.isEmpty())
    {
      this.zzasf = 0;
      if (paramLong != -9223372036854775807L)
        break label152;
      this.zzasg = 0L;
      this.zzarr.zza(this.zzary, i, -9223372036854775807L);
    }
    while (true)
    {
      return;
      this.zzary.zza(i, this.zzars, false);
      if (paramLong != -9223372036854775807L)
        zzkt.zzea(paramLong);
      this.zzary.zza(0, this.zzart, false);
      this.zzasf = 0;
      break;
      label152: this.zzasg = paramLong;
      this.zzarr.zza(this.zzary, i, zzkt.zzea(paramLong));
      Iterator localIterator = this.zzabs.iterator();
      while (localIterator.hasNext())
        ((zzkw)localIterator.next()).zzgt();
    }
  }

  public final void stop()
  {
    this.zzarr.stop();
  }

  final void zza(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      throw new IllegalStateException();
    case 0:
      this.zzarw = (-1 + this.zzarw);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return;
      this.zzabv = paramMessage.arg1;
      Iterator localIterator8 = this.zzabs.iterator();
      while (localIterator8.hasNext())
        ((zzkw)localIterator8.next()).zza(this.zzabu, this.zzabv);
      continue;
      if (paramMessage.arg1 != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.zzarx = bool;
        Iterator localIterator7 = this.zzabs.iterator();
        while (localIterator7.hasNext())
          ((zzkw)localIterator7.next()).zzh(this.zzarx);
        break;
      }
      if (this.zzarw == 0)
      {
        zzrr localzzrr = (zzrr)paramMessage.obj;
        this.zzaru = true;
        this.zzasa = localzzrr.zzbly;
        this.zzasb = localzzrr.zzblz;
        this.zzarp.zzd(localzzrr.zzbma);
        Iterator localIterator6 = this.zzabs.iterator();
        while (localIterator6.hasNext())
          ((zzkw)localIterator6.next()).zza(this.zzasa, this.zzasb);
        continue;
        int i = -1 + this.zzarv;
        this.zzarv = i;
        if (i == 0)
        {
          this.zzasd = ((zzle)paramMessage.obj);
          if (paramMessage.arg1 != 0)
          {
            Iterator localIterator5 = this.zzabs.iterator();
            while (localIterator5.hasNext())
              ((zzkw)localIterator5.next()).zzgt();
            continue;
            if (this.zzarv == 0)
            {
              this.zzasd = ((zzle)paramMessage.obj);
              Iterator localIterator4 = this.zzabs.iterator();
              while (localIterator4.hasNext())
                ((zzkw)localIterator4.next()).zzgt();
              continue;
              zzlg localzzlg = (zzlg)paramMessage.obj;
              this.zzarv -= localzzlg.zzatk;
              if (this.zzarw == 0)
              {
                this.zzary = localzzlg.zzary;
                this.zzarz = localzzlg.zzarz;
                this.zzasd = localzzlg.zzasd;
                Iterator localIterator3 = this.zzabs.iterator();
                while (localIterator3.hasNext())
                  ((zzkw)localIterator3.next()).zza(this.zzary, this.zzarz);
                continue;
                zzln localzzln = (zzln)paramMessage.obj;
                if (!this.zzasc.equals(localzzln))
                {
                  this.zzasc = localzzln;
                  Iterator localIterator2 = this.zzabs.iterator();
                  while (localIterator2.hasNext())
                    ((zzkw)localIterator2.next()).zza(localzzln);
                  continue;
                  zzku localzzku = (zzku)paramMessage.obj;
                  Iterator localIterator1 = this.zzabs.iterator();
                  while (localIterator1.hasNext())
                    ((zzkw)localIterator1.next()).zza(localzzku);
                }
              }
            }
          }
        }
      }
    }
  }

  public final void zza(zzkw paramzzkw)
  {
    this.zzabs.add(paramzzkw);
  }

  public final void zza(zzql paramzzql)
  {
    if ((!this.zzary.isEmpty()) || (this.zzarz != null))
    {
      this.zzary = zzlr.zzaum;
      this.zzarz = null;
      Iterator localIterator1 = this.zzabs.iterator();
      while (localIterator1.hasNext())
        ((zzkw)localIterator1.next()).zza(this.zzary, this.zzarz);
    }
    if (this.zzaru)
    {
      this.zzaru = false;
      this.zzasa = zzrb.zzbkw;
      this.zzasb = this.zzarq;
      this.zzarp.zzd(null);
      Iterator localIterator2 = this.zzabs.iterator();
      while (localIterator2.hasNext())
        ((zzkw)localIterator2.next()).zza(this.zzasa, this.zzasb);
    }
    this.zzarw = (1 + this.zzarw);
    this.zzarr.zza(paramzzql, true);
  }

  public final void zza(zzky[] paramArrayOfzzky)
  {
    this.zzarr.zza(paramArrayOfzzky);
  }

  public final void zzb(zzkw paramzzkw)
  {
    this.zzabs.remove(paramzzkw);
  }

  public final void zzb(zzky[] paramArrayOfzzky)
  {
    this.zzarr.zzb(paramArrayOfzzky);
  }

  public final void zzd(boolean paramBoolean)
  {
    if (this.zzabu != paramBoolean)
    {
      this.zzabu = paramBoolean;
      this.zzarr.zzd(paramBoolean);
      Iterator localIterator = this.zzabs.iterator();
      while (localIterator.hasNext())
        ((zzkw)localIterator.next()).zza(paramBoolean, this.zzabv);
    }
  }

  public final boolean zzdm()
  {
    return this.zzabu;
  }

  public final long zzdn()
  {
    if ((this.zzary.isEmpty()) || (this.zzarv > 0))
      return this.zzasg;
    this.zzary.zza(this.zzasd.zzatb, this.zzart, false);
    return this.zzart.zzhh() + zzkt.zzdz(this.zzasd.zzacl);
  }

  public final int zzgs()
  {
    return this.zzaro.length;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzla
 * JD-Core Version:    0.6.2
 */