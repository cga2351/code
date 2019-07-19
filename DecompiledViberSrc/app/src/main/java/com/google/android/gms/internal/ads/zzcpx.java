package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import javax.annotation.concurrent.GuardedBy;

public final class zzcpx
  implements AppEventListener
{

  @GuardedBy("this")
  private zzzq zzgeq;

  public final void onAppEvent(String paramString1, String paramString2)
  {
    try
    {
      zzzq localzzzq = this.zzgeq;
      if (localzzzq != null);
      try
      {
        this.zzgeq.onAppEvent(paramString1, paramString2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          zzaxa.zzd("Remote Exception at onAppEvent.", localRemoteException);
      }
    }
    finally
    {
    }
  }

  public final zzzq zzale()
  {
    try
    {
      zzzq localzzzq = this.zzgeq;
      return localzzzq;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void zzb(zzzq paramzzzq)
  {
    try
    {
      this.zzgeq = paramzzzq;
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpx
 * JD-Core Version:    0.6.2
 */