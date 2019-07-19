package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzare
public final class zzapu
{
  private final zzbha zzdbu;
  private final boolean zzdin;
  private final String zzdio;

  public zzapu(zzbha paramzzbha, Map<String, String> paramMap)
  {
    this.zzdbu = paramzzbha;
    this.zzdio = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      this.zzdin = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    this.zzdin = true;
  }

  public final void execute()
  {
    if (this.zzdbu == null)
    {
      zzaxa.zzep("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(this.zzdio))
    {
      zzk.zzli();
      i = 7;
    }
    while (true)
    {
      this.zzdbu.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(this.zzdio))
      {
        zzk.zzli();
        i = 6;
      }
      else if (this.zzdin)
      {
        i = -1;
      }
      else
      {
        i = zzk.zzli().zzwf();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapu
 * JD-Core Version:    0.6.2
 */