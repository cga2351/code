package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpw extends AdMetadataListener
{

  @GuardedBy("this")
  private zzzn zzgep;

  public final void onAdMetadataChanged()
  {
    try
    {
      zzzn localzzzn = this.zzgep;
      if (localzzzn != null);
      try
      {
        this.zzgep.onAdMetadataChanged();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdMetadataChanged.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void zzb(zzzn paramzzzn)
  {
    try
    {
      this.zzgep = paramzzzn;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpw
 * JD-Core Version:    0.6.2
 */