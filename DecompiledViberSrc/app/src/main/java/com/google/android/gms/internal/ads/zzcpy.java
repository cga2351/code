package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpy extends AdMetadataListener
{

  @GuardedBy("this")
  private zzaam zzger;

  public final void onAdMetadataChanged()
  {
    try
    {
      zzaam localzzaam = this.zzger;
      if (localzzaam != null);
      try
      {
        this.zzger.onAdMetadataChanged();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzbae.zze("#007 Could not call remote method.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void zzb(zzaam paramzzaam)
  {
    try
    {
      this.zzger = paramzzaam;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpy
 * JD-Core Version:    0.6.2
 */