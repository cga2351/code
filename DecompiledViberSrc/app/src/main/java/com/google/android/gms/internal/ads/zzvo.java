package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;

final class zzvo
  implements BaseGmsClient.BaseConnectionCallbacks
{
  zzvo(zzvl paramzzvl)
  {
  }

  public final void onConnected(Bundle paramBundle)
  {
    synchronized (zzvl.zzc(this.zzbwr))
    {
      try
      {
        if (zzvl.zzd(this.zzbwr) != null)
          zzvl.zza(this.zzbwr, zzvl.zzd(this.zzbwr).zznk());
        zzvl.zzc(this.zzbwr).notifyAll();
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        while (true)
        {
          zzaxa.zzc("Unable to obtain a cache service instance.", localDeadObjectException);
          zzvl.zza(this.zzbwr);
        }
      }
    }
  }

  public final void onConnectionSuspended(int paramInt)
  {
    synchronized (zzvl.zzc(this.zzbwr))
    {
      zzvl.zza(this.zzbwr, null);
      zzvl.zzc(this.zzbwr).notifyAll();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvo
 * JD-Core Version:    0.6.2
 */