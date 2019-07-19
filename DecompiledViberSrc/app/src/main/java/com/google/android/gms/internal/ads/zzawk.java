package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzawk
{
  private final Object lock = new Object();
  private final Clock zzbsb;
  private final String zzdmb;

  @GuardedBy("lock")
  private boolean zzdnl = false;

  @GuardedBy("lock")
  private long zzdnp = -1L;
  private final zzawv zzdsy;

  @GuardedBy("lock")
  private final LinkedList<zzawl> zzdsz;
  private final String zzdta;

  @GuardedBy("lock")
  private long zzdtb = -1L;

  @GuardedBy("lock")
  private long zzdtc = -1L;

  @GuardedBy("lock")
  private long zzdtd = 0L;

  @GuardedBy("lock")
  private long zzdte = -1L;

  @GuardedBy("lock")
  private long zzdtf = -1L;

  zzawk(Clock paramClock, zzawv paramzzawv, String paramString1, String paramString2)
  {
    this.zzbsb = paramClock;
    this.zzdsy = paramzzawv;
    this.zzdta = paramString1;
    this.zzdmb = paramString2;
    this.zzdsz = new LinkedList();
  }

  public final Bundle toBundle()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    synchronized (this.lock)
    {
      localBundle = new Bundle();
      localBundle.putString("seq_num", this.zzdta);
      localBundle.putString("slotid", this.zzdmb);
      localBundle.putBoolean("ismediation", false);
      localBundle.putLong("treq", this.zzdte);
      localBundle.putLong("tresponse", this.zzdtf);
      localBundle.putLong("timp", this.zzdtb);
      localBundle.putLong("tload", this.zzdtc);
      localBundle.putLong("pcc", this.zzdtd);
      localBundle.putLong("tfetch", this.zzdnp);
      localArrayList = new ArrayList();
      Iterator localIterator = this.zzdsz.iterator();
      if (localIterator.hasNext())
        localArrayList.add(((zzawl)localIterator.next()).toBundle());
    }
    localBundle.putParcelableArrayList("tclick", localArrayList);
    return localBundle;
  }

  public final void zzah(boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      if (this.zzdtf != -1L)
        this.zzdtc = this.zzbsb.elapsedRealtime();
      return;
    }
  }

  public final void zze(zzxx paramzzxx)
  {
    synchronized (this.lock)
    {
      this.zzdte = this.zzbsb.elapsedRealtime();
      this.zzdsy.zza(paramzzxx, this.zzdte);
      return;
    }
  }

  public final void zzfb(long paramLong)
  {
    synchronized (this.lock)
    {
      this.zzdtf = paramLong;
      if (this.zzdtf != -1L)
        this.zzdsy.zzb(this);
      return;
    }
  }

  public final void zzuj()
  {
    synchronized (this.lock)
    {
      if ((this.zzdtf != -1L) && (this.zzdtb == -1L))
      {
        this.zzdtb = this.zzbsb.elapsedRealtime();
        this.zzdsy.zzb(this);
      }
      this.zzdsy.zzuj();
      return;
    }
  }

  public final void zzuk()
  {
    synchronized (this.lock)
    {
      if (this.zzdtf != -1L)
      {
        zzawl localzzawl = new zzawl(this);
        localzzawl.zzup();
        this.zzdsz.add(localzzawl);
        this.zzdtd = (1L + this.zzdtd);
        this.zzdsy.zzuk();
        this.zzdsy.zzb(this);
      }
      return;
    }
  }

  public final void zzul()
  {
    synchronized (this.lock)
    {
      if ((this.zzdtf != -1L) && (!this.zzdsz.isEmpty()))
      {
        zzawl localzzawl = (zzawl)this.zzdsz.getLast();
        if (localzzawl.zzun() == -1L)
        {
          localzzawl.zzuo();
          this.zzdsy.zzb(this);
        }
      }
      return;
    }
  }

  public final String zzum()
  {
    return this.zzdta;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawk
 * JD-Core Version:    0.6.2
 */