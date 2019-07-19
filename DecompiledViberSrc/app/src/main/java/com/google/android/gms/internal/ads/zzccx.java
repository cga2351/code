package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzccx
  implements zzbrw
{
  private final zzamt zzfsy;

  public zzccx(zzamt paramzzamt)
  {
    this.zzfsy = paramzzamt;
  }

  public final void zzbp(Context paramContext)
  {
    try
    {
      this.zzfsy.pause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Nonagon: Can't invoke onPause for rewarded video.", localRemoteException);
    }
  }

  public final void zzbq(Context paramContext)
  {
    try
    {
      this.zzfsy.resume();
      if (paramContext != null)
        this.zzfsy.zzr(ObjectWrapper.wrap(paramContext));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Nonagon: Can't invoke onResume for rewarded video.", localRemoteException);
    }
  }

  public final void zzbr(Context paramContext)
  {
    try
    {
      this.zzfsy.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Nonagon: Can't invoke onDestroy for rewarded video.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccx
 * JD-Core Version:    0.6.2
 */