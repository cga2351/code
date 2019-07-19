package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

public final class zzcob
  implements zzcjy<zzaow, zzckz>
{
  private final zzclb zzfvd;

  public zzcob(zzclb paramzzclb)
  {
    this.zzfvd = paramzzclb;
  }

  public final zzcjx<zzaow, zzckz> zzd(String paramString, JSONObject paramJSONObject)
    throws RemoteException
  {
    zzaow localzzaow = this.zzfvd.zzcy(paramString);
    if (localzzaow == null)
      return null;
    return new zzcjx(localzzaow, new zzckz(), paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcob
 * JD-Core Version:    0.6.2
 */