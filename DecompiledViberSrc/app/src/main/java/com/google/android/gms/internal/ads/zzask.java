package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamite.DynamiteModule;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzask extends zzasm
{
  private final Object lock = new Object();
  private SharedPreferences zzdqk;
  private final zzalk<JSONObject, JSONObject> zzdql;
  private final Context zzys;

  public zzask(Context paramContext, zzalk<JSONObject, JSONObject> paramzzalk)
  {
    this.zzys = paramContext.getApplicationContext();
    this.zzdql = paramzzalk;
  }

  public static JSONObject zzu(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("js", zzbaj.zzxc().zzbsy);
      zzaci localzzaci = zzact.zzcry;
      localJSONObject.put("mf", zzyr.zzpe().zzd(localzzaci));
      localJSONObject.put("cl", "237950021");
      localJSONObject.put("rapid_rc", "dev");
      localJSONObject.put("rapid_rollup", "HEAD");
      localJSONObject.put("admob_module_version", 11140);
      localJSONObject.put("dynamite_local_version", 11140);
      localJSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(paramContext, "com.google.android.gms.ads.dynamite"));
      localJSONObject.put("container_version", 12451009);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public final zzbbi<Void> zztz()
  {
    synchronized (this.lock)
    {
      if (this.zzdqk != null)
      {
        long l1 = this.zzdqk.getLong("js_last_update", 0L);
        long l2 = zzk.zzln().currentTimeMillis() - l1;
        zzaci localzzaci = zzact.zzcrx;
        if (l2 < ((Long)zzyr.zzpe().zzd(localzzaci)).longValue())
          return zzbas.zzm(null);
      }
      else
      {
        this.zzdqk = this.zzys.getSharedPreferences("google_ads_flags_meta", 0);
      }
    }
    JSONObject localJSONObject = zzu(this.zzys);
    return zzbas.zza(this.zzdql.zzi(localJSONObject), new zzasl(this), zzbbn.zzeah);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzask
 * JD-Core Version:    0.6.2
 */