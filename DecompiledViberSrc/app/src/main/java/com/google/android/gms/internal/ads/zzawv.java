package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzare
public final class zzawv
  implements zzur
{
  private final Object lock = new Object();
  private final zzaxc zzdum;
  private final zzawu zzduq;

  @VisibleForTesting
  private final zzaws zzdur;

  @VisibleForTesting
  private final HashSet<zzawk> zzdus = new HashSet();

  @VisibleForTesting
  private final HashSet<Object> zzdut = new HashSet();

  public zzawv(String paramString, zzaxc paramzzaxc)
  {
    this.zzdur = new zzaws(paramString, paramzzaxc);
    this.zzdum = paramzzaxc;
    this.zzduq = new zzawu();
  }

  public final Bundle zza(Context paramContext, zzawt paramzzawt)
  {
    HashSet localHashSet = new HashSet();
    Bundle localBundle1;
    Bundle localBundle2;
    synchronized (this.lock)
    {
      localHashSet.addAll(this.zzdus);
      this.zzdus.clear();
      localBundle1 = new Bundle();
      localBundle1.putBundle("app", this.zzdur.zzn(paramContext, this.zzduq.zzvh()));
      localBundle2 = new Bundle();
      Iterator localIterator1 = this.zzdut.iterator();
      if (localIterator1.hasNext())
      {
        localIterator1.next();
        throw new NoSuchMethodError();
      }
    }
    localBundle1.putBundle("slots", localBundle2);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
      localArrayList.add(((zzawk)localIterator2.next()).toBundle());
    localBundle1.putParcelableArrayList("ads", localArrayList);
    paramzzawt.zza(localHashSet);
    return localBundle1;
  }

  public final zzawk zza(Clock paramClock, String paramString)
  {
    return new zzawk(paramClock, this, this.zzduq.zzvg(), paramString);
  }

  public final void zza(zzxx paramzzxx, long paramLong)
  {
    synchronized (this.lock)
    {
      this.zzdur.zza(paramzzxx, paramLong);
      return;
    }
  }

  public final void zzb(zzawk paramzzawk)
  {
    synchronized (this.lock)
    {
      this.zzdus.add(paramzzawk);
      return;
    }
  }

  public final void zzb(HashSet<zzawk> paramHashSet)
  {
    synchronized (this.lock)
    {
      this.zzdus.addAll(paramHashSet);
      return;
    }
  }

  public final void zzp(boolean paramBoolean)
  {
    long l1 = zzk.zzln().currentTimeMillis();
    if (paramBoolean)
    {
      long l2 = l1 - this.zzdum.zzvs();
      zzaci localzzaci = zzact.zzcoz;
      if (l2 > ((Long)zzyr.zzpe().zzd(localzzaci)).longValue())
      {
        this.zzdur.zzduj = -1;
        return;
      }
      this.zzdur.zzduj = this.zzdum.zzvt();
      return;
    }
    this.zzdum.zzfc(l1);
    this.zzdum.zzcu(this.zzdur.zzduj);
  }

  public final void zzuj()
  {
    synchronized (this.lock)
    {
      this.zzdur.zzuj();
      return;
    }
  }

  public final void zzuk()
  {
    synchronized (this.lock)
    {
      this.zzdur.zzuk();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawv
 * JD-Core Version:    0.6.2
 */