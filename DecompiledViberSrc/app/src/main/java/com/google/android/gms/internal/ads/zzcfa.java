package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.Uri.Builder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzcfa
  implements zzbrn, zzbsq, zzbtj
{
  private final String zzcwz;
  private final zzdad zzffd;
  private final zzcfh zzfuo;

  public zzcfa(zzcfh paramzzcfh, zzdad paramzzdad)
  {
    zzaci localzzaci = zzact.zzcmz;
    this.zzcwz = ((String)zzyr.zzpe().zzd(localzzaci));
    this.zzfuo = paramzzcfh;
    this.zzffd = paramzzdad;
  }

  private final void zzm(Map<String, String> paramMap)
  {
    Uri.Builder localBuilder = Uri.parse(this.zzcwz).buildUpon();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    String str = localBuilder.build().toString();
    zzaci localzzaci = zzact.zzcmy;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
      this.zzffd.zzed(str);
    zzaxa.zzds(str);
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    zzm(this.zzfuo.zzqy());
  }

  public final void onAdLoaded()
  {
    zzm(this.zzfuo.zzqy());
  }

  public final void zza(zzcxt paramzzcxt)
  {
    this.zzfuo.zzb(paramzzcxt);
  }

  public final void zzb(zzary paramzzary)
  {
    this.zzfuo.zzi(paramzzary.zzdov);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcfa
 * JD-Core Version:    0.6.2
 */