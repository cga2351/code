package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzadg
{
  private final Map<String, zzadf> zzcxo;
  private final zzadh zzcxp;

  public zzadg(zzadh paramzzadh)
  {
    this.zzcxp = paramzzadh;
    this.zzcxo = new HashMap();
  }

  public final void zza(String paramString, zzadf paramzzadf)
  {
    this.zzcxo.put(paramString, paramzzadf);
  }

  public final void zza(String paramString1, String paramString2, long paramLong)
  {
    zzadh localzzadh1 = this.zzcxp;
    zzadf localzzadf = (zzadf)this.zzcxo.get(paramString2);
    String[] arrayOfString = { paramString1 };
    Map localMap;
    zzadh localzzadh2;
    if ((localzzadh1 == null) || (localzzadf == null))
    {
      localMap = this.zzcxo;
      localzzadh2 = this.zzcxp;
      if (localzzadh2 != null)
        break label87;
    }
    label87: for (Object localObject = null; ; localObject = localzzadh2.zzfa(paramLong))
    {
      localMap.put(paramString1, localObject);
      return;
      localzzadh1.zza(localzzadf, paramLong, arrayOfString);
      break;
    }
  }

  public final zzadh zzqw()
  {
    return this.zzcxp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadg
 * JD-Core Version:    0.6.2
 */