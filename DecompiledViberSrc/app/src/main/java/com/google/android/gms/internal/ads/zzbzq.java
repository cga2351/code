package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

final class zzbzq
  implements zzahn<Object>
{
  zzbzq(zzbzp paramzzbzp, zzagc paramzzagc)
  {
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    try
    {
      this.zzfqg.zzfqd = Long.valueOf(Long.parseLong((String)paramMap.get("timestamp")));
      this.zzfqg.zzfqc = ((String)paramMap.get("id"));
      str = (String)paramMap.get("asset_id");
      if (this.zzfqf == null)
      {
        zzaxa.zzdp("Received unconfirmed click but UnconfirmedClickListener is null.");
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      String str;
      while (true)
        zzaxa.zzen("Failed to call parse unconfirmedClickTimestamp.");
      try
      {
        this.zzfqf.onUnconfirmedClickReceived(str);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbzq
 * JD-Core Version:    0.6.2
 */