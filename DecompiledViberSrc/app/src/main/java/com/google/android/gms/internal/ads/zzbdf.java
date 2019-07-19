package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzbdf
{
  public final boolean zzeee;
  public final int zzeef;
  public final int zzeeg;
  public final int zzeeh;
  public final String zzeei;
  public final int zzeej;
  public final int zzeek;
  public final int zzeel;
  public final int zzeem;
  public final boolean zzeen;

  public zzbdf(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      try
      {
        localJSONObject1 = new JSONObject(paramString);
        localJSONObject2 = localJSONObject1;
        this.zzeee = zza(localJSONObject2, "aggressive_media_codec_release", zzact.zzcmj);
        this.zzeef = zzb(localJSONObject2, "byte_buffer_precache_limit", zzact.zzcls);
        this.zzeeg = zzb(localJSONObject2, "exo_cache_buffer_size", zzact.zzclx);
        this.zzeeh = zzb(localJSONObject2, "exo_connect_timeout_millis", zzact.zzclo);
        this.zzeei = zzc(localJSONObject2, "exo_player_version", zzact.zzcln);
        this.zzeej = zzb(localJSONObject2, "exo_read_timeout_millis", zzact.zzclp);
        this.zzeek = zzb(localJSONObject2, "load_check_interval_bytes", zzact.zzclq);
        this.zzeel = zzb(localJSONObject2, "player_precache_limit", zzact.zzclr);
        this.zzeem = zzb(localJSONObject2, "socket_receive_buffer_size", zzact.zzclt);
        this.zzeen = zza(localJSONObject2, "use_cache_data_source", zzact.zzcts);
        return;
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject2 = null;
        continue;
      }
      JSONObject localJSONObject1 = null;
    }
  }

  private static boolean zza(JSONObject paramJSONObject, String paramString, zzaci<Boolean> paramzzaci)
  {
    return zza(paramJSONObject, paramString, ((Boolean)zzyr.zzpe().zzd(paramzzaci)).booleanValue());
  }

  private static boolean zza(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    if (paramJSONObject != null);
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      paramBoolean = bool;
      return paramBoolean;
    }
    catch (JSONException localJSONException)
    {
    }
    return paramBoolean;
  }

  private static int zzb(JSONObject paramJSONObject, String paramString, zzaci<Integer> paramzzaci)
  {
    if (paramJSONObject != null)
      try
      {
        int i = paramJSONObject.getInt(paramString);
        return i;
      }
      catch (JSONException localJSONException)
      {
      }
    return ((Integer)zzyr.zzpe().zzd(paramzzaci)).intValue();
  }

  private static String zzc(JSONObject paramJSONObject, String paramString, zzaci<String> paramzzaci)
  {
    if (paramJSONObject != null)
      try
      {
        String str = paramJSONObject.getString(paramString);
        return str;
      }
      catch (JSONException localJSONException)
      {
      }
    return (String)zzyr.zzpe().zzd(paramzzaci);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdf
 * JD-Core Version:    0.6.2
 */