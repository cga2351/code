package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzare
public final class zzahp
  implements zzahn<Object>
{
  private final Context zzlj;

  public zzahp(Context paramContext)
  {
    this.zzlj = paramContext;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    if (!zzk.zzme().zzx(this.zzlj))
      return;
    String str1 = (String)paramMap.get("eventName");
    String str2 = (String)paramMap.get("eventId");
    label76: int i;
    switch (str1.hashCode())
    {
    default:
      i = -1;
    case 94401:
    case 94407:
    case 94399:
    }
    while (true)
      switch (i)
      {
      default:
        zzaxa.zzen("logScionEvent gmsg contained unsupported eventName");
        return;
        if (!str1.equals("_ac"))
          break label76;
        i = 0;
        continue;
        if (!str1.equals("_ai"))
          break label76;
        i = 1;
        continue;
        if (!str1.equals("_aa"))
          break label76;
        i = 2;
      case 0:
      case 1:
      case 2:
      }
    zzk.zzme().zzg(this.zzlj, str2);
    return;
    zzk.zzme().zzh(this.zzlj, str2);
    return;
    zzk.zzme().zzj(this.zzlj, str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahp
 * JD-Core Version:    0.6.2
 */