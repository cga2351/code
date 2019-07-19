package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

public class zzbpb
{
  protected zzcxt zzffc;
  protected zzcxl zzfif;
  protected zzbrx zzfip;
  protected zzbsn zzfiq;
  protected String zzfir;

  private static String zzb(zzcxl paramzzcxl)
  {
    try
    {
      String str = paramzzcxl.zzgkh.getString("class_name");
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public void destroy()
  {
    this.zzfip.zzbr(null);
  }

  public final String getMediationAdapterClassName()
  {
    return this.zzfir;
  }

  public void zzafl()
  {
    this.zzfiq.onAdLoaded();
  }

  public final zzbrx zzafy()
  {
    return this.zzfip;
  }

  public final String zzpj()
  {
    int i;
    if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(this.zzfir)) || ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(this.zzfir)))
    {
      i = 1;
      if (i == 0)
        break label54;
    }
    label54: for (String str = zzb(this.zzfif); ; str = null)
    {
      if (str == null)
        str = this.zzfir;
      return str;
      i = 0;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbpb
 * JD-Core Version:    0.6.2
 */