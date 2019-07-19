package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

final class zzuq
  implements Runnable
{
  zzuq(zzup paramzzup)
  {
  }

  public final void run()
  {
    synchronized (zzup.zza(this.zzbuz))
    {
      if ((zzup.zzb(this.zzbuz)) && (zzup.zzc(this.zzbuz)))
      {
        zzup.zza(this.zzbuz, false);
        zzaxa.zzdp("App went background");
        Iterator localIterator = zzup.zzd(this.zzbuz).iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            break label113;
          zzur localzzur = (zzur)localIterator.next();
          try
          {
            localzzur.zzp(false);
          }
          catch (Exception localException)
          {
            zzbae.zzc("", localException);
          }
        }
      }
    }
    zzaxa.zzdp("App is still foreground");
    label113:
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzuq
 * JD-Core Version:    0.6.2
 */