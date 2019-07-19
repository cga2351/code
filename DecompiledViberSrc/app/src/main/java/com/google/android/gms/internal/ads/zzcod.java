package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.Iterator;
import java.util.List;

public final class zzcod<AdT, AdapterT, ListenerT extends zzbsl>
  implements zzcju<AdT>
{
  private final zzcjy<AdapterT, ListenerT> zzfeh;
  private final zzczs zzgbk;
  private final zzcjz<AdT, AdapterT, ListenerT> zzgch;
  private final zzbbm zzgci;

  public zzcod(zzczs paramzzczs, zzbbm paramzzbbm, zzcjy<AdapterT, ListenerT> paramzzcjy, zzcjz<AdT, AdapterT, ListenerT> paramzzcjz)
  {
    this.zzgbk = paramzzczs;
    this.zzgci = paramzzbbm;
    this.zzgch = paramzzcjz;
    this.zzfeh = paramzzcjy;
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return !paramzzcxl.zzgkf.isEmpty();
  }

  public final zzbbi<AdT> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    Iterator localIterator = paramzzcxl.zzgkf.iterator();
    while (true)
    {
      boolean bool = localIterator.hasNext();
      Object localObject = null;
      String str;
      if (bool)
        str = (String)localIterator.next();
      try
      {
        zzcjx localzzcjx = this.zzfeh.zzd(str, paramzzcxl.zzgkh);
        localObject = localzzcjx;
        if (localObject == null)
          return zzbas.zzd(new zzcmj("unable to instantiate mediation adapter class"));
        zzbbs localzzbbs = new zzbbs();
        zzcog localzzcog = new zzcog(this, localzzbbs, localObject);
        localObject.zzfzn.zza(localzzcog);
        if (paramzzcxl.zzdpe)
        {
          Bundle localBundle1 = paramzzcxt.zzgkx.zzfjp.zzghg.zzcgw;
          Bundle localBundle2 = localBundle1.getBundle(AdMobAdapter.class.getName());
          if (localBundle2 == null)
          {
            localBundle2 = new Bundle();
            localBundle1.putBundle(AdMobAdapter.class.getName(), localBundle2);
          }
          localBundle2.putBoolean("render_test_ad_label", true);
        }
        return this.zzgbk.zzv(zzczr.zzgng).zza(new zzcoe(this, paramzzcxt, paramzzcxl, localObject), this.zzgci).zzx(zzczr.zzgnh).zzb(localzzbbs).zzx(zzczr.zzgni).zzb(new zzcof(this, paramzzcxt, paramzzcxl, localObject)).zzane();
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcod
 * JD-Core Version:    0.6.2
 */