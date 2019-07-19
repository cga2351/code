package com.google.android.gms.internal.ads;

import java.util.Map;

@zzare
public final class zzagv
  implements zzahn<Object>
{
  private final zzagw zzczp;

  public zzagv(zzagw paramzzagw)
  {
    this.zzczp = paramzzagw;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str == null)
    {
      zzaxa.zzep("App event with no name parameter.");
      return;
    }
    this.zzczp.onAppEvent(str, (String)paramMap.get("info"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagv
 * JD-Core Version:    0.6.2
 */