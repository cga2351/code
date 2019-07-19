package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

final class zzeb extends zzea.zzb
{
  zzeb(zzea paramzzea, Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    super(paramzzea);
  }

  public final void zzgd()
  {
    while (true)
    {
      try
      {
        zzea.zza(this.zzadv, new HashMap());
        zzea.zza(this.zzadv, this.zzadv.zzg(this.val$context));
        if (zzea.zzb(this.zzadv) == null)
        {
          Log.w(zzea.zzc(this.zzadv), "Failed to connect to measurement client.");
          return;
        }
        if (!zzea.zza(this.zzadv, this.zzads, this.zzadt))
          break label205;
        str3 = this.zzadt;
        str2 = this.zzads;
        str1 = zzea.zzc(this.zzadv);
        int i = zzea.zzj(this.val$context);
        int j = zzea.zzk(this.val$context);
        long l = Math.max(i, j);
        if (j < i)
        {
          bool = true;
          zzdy localzzdy = new zzdy(13001L, l, bool, str1, str2, str3, this.zzadu);
          zzea.zzb(this.zzadv).initialize(ObjectWrapper.wrap(this.val$context), localzzdy, this.timestamp);
          return;
        }
      }
      catch (RemoteException localRemoteException)
      {
        zzea.zza(this.zzadv, localRemoteException, true, false);
        return;
      }
      boolean bool = false;
      continue;
      label205: String str1 = null;
      String str2 = null;
      String str3 = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzeb
 * JD-Core Version:    0.6.2
 */