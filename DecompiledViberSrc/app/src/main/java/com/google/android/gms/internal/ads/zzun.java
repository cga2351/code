package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzun
{
  private final Object lock = new Object();

  @VisibleForTesting
  private int zzbup;
  private List<zzum> zzbuq = new LinkedList();

  public final boolean zza(zzum paramzzum)
  {
    synchronized (this.lock)
    {
      return this.zzbuq.contains(paramzzum);
    }
  }

  public final boolean zzb(zzum paramzzum)
  {
    synchronized (this.lock)
    {
      Iterator localIterator = this.zzbuq.iterator();
      while (localIterator.hasNext())
      {
        zzum localzzum = (zzum)localIterator.next();
        if (!zzk.zzlk().zzvc().zzvl())
        {
          if ((paramzzum != localzzum) && (localzzum.zzmm().equals(paramzzum.zzmm())))
          {
            localIterator.remove();
            return true;
          }
        }
        else if ((!zzk.zzlk().zzvc().zzvn()) && (paramzzum != localzzum) && (localzzum.zzmo().equals(paramzzum.zzmo())))
        {
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
  }

  public final void zzc(zzum paramzzum)
  {
    synchronized (this.lock)
    {
      if (this.zzbuq.size() >= 10)
      {
        int j = this.zzbuq.size();
        zzaxa.zzdp(41 + "Queue is full, current size = " + j);
        this.zzbuq.remove(0);
      }
      int i = this.zzbup;
      this.zzbup = (i + 1);
      paramzzum.zzbw(i);
      paramzzum.zzms();
      this.zzbuq.add(paramzzum);
      return;
    }
  }

  public final zzum zzo(boolean paramBoolean)
  {
    Object localObject1 = null;
    int n;
    for (int i = 0; ; i = n)
    {
      int k;
      synchronized (this.lock)
      {
        if (this.zzbuq.size() == 0)
        {
          zzaxa.zzdp("Queue empty");
          return null;
        }
        if (this.zzbuq.size() >= 2)
        {
          j = -2147483648;
          Iterator localIterator = this.zzbuq.iterator();
          k = 0;
          if (localIterator.hasNext())
          {
            zzum localzzum1 = (zzum)localIterator.next();
            int m = localzzum1.getScore();
            if (m <= j)
              break label185;
            i1 = m;
            localObject4 = localzzum1;
            n = k;
            break label198;
          }
          this.zzbuq.remove(i);
          return localObject1;
        }
      }
      zzum localzzum2 = (zzum)this.zzbuq.get(0);
      if (paramBoolean)
        this.zzbuq.remove(0);
      while (true)
      {
        return localzzum2;
        localzzum2.zzmp();
      }
      label185: n = i;
      Object localObject4 = localObject1;
      int i1 = j;
      label198: k++;
      int j = i1;
      localObject1 = localObject4;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzun
 * JD-Core Version:    0.6.2
 */