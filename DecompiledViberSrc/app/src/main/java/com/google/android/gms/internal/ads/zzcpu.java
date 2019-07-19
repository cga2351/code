package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpu
  implements zzxp
{

  @GuardedBy("this")
  private zzyu zzgen;

  public final void onAdClicked()
  {
    try
    {
      zzyu localzzyu = this.zzgen;
      if (localzzyu != null);
      try
      {
        this.zzgen.onAdClicked();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAdClicked.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final void zzb(zzyu paramzzyu)
  {
    try
    {
      this.zzgen = paramzzyu;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpu
 * JD-Core Version:    0.6.2
 */