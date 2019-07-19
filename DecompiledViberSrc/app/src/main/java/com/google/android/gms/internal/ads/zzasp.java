package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzare
public final class zzasp
  implements zzasc
{
  private zzalk<JSONObject, JSONObject> zzdql;
  private zzalk<JSONObject, JSONObject> zzdqn;

  public zzasp(Context paramContext)
  {
    this.zzdqn = zzk.zzlt().zza(paramContext, zzbaj.zzxc()).zza("google.afma.request.getAdDictionary", zzalp.zzddk, zzalp.zzddk);
    this.zzdql = zzk.zzlt().zza(paramContext, zzbaj.zzxc()).zza("google.afma.sdkConstants.getSdkConstants", zzalp.zzddk, zzalp.zzddk);
  }

  public final zzalk<JSONObject, JSONObject> zztt()
  {
    return this.zzdql;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzasp
 * JD-Core Version:    0.6.2
 */