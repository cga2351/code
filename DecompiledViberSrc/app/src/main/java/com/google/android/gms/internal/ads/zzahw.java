package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

@zzare
public final class zzahw
  implements zzahn<Object>
{
  private final zzahx zzdas;

  private zzahw(zzahx paramzzahx)
  {
    this.zzdas = paramzzahx;
  }

  public static void zza(zzbha paramzzbha, zzahx paramzzahx)
  {
    paramzzbha.zza("/reward", new zzahw(paramzzahx));
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if ("grant".equals(str1));
    do
    {
      try
      {
        int i = Integer.parseInt((String)paramMap.get("amount"));
        String str2 = (String)paramMap.get("type");
        if (!TextUtils.isEmpty(str2))
        {
          zzatp localzzatp2 = new zzatp(str2, i);
          localzzatp1 = localzzatp2;
          this.zzdas.zza(localzzatp1);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          zzaxa.zzd("Unable to parse reward amount.", localNumberFormatException);
          zzatp localzzatp1 = null;
        }
      }
      if ("video_start".equals(str1))
      {
        this.zzdas.zzrq();
        return;
      }
    }
    while (!"video_complete".equals(str1));
    this.zzdas.zzrr();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahw
 * JD-Core Version:    0.6.2
 */