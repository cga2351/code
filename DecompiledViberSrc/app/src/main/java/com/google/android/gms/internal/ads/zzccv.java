package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;

public final class zzccv extends VideoController.VideoLifecycleCallbacks
{
  private final zzbys zzfmq;

  public zzccv(zzbys paramzzbys)
  {
    this.zzfmq = paramzzbys;
  }

  private static zzaas zza(zzbys paramzzbys)
  {
    zzaap localzzaap = paramzzbys.getVideoController();
    if (localzzaap == null)
      return null;
    try
    {
      zzaas localzzaas = localzzaap.zzpx();
      return localzzaas;
    }
    catch (RemoteException localRemoteException)
    {
    }
    return null;
  }

  public final void onVideoEnd()
  {
    zzaas localzzaas = zza(this.zzfmq);
    if (localzzaas == null)
      return;
    try
    {
      localzzaas.onVideoEnd();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Unable to call onVideoEnd()", localRemoteException);
    }
  }

  public final void onVideoPause()
  {
    zzaas localzzaas = zza(this.zzfmq);
    if (localzzaas == null)
      return;
    try
    {
      localzzaas.onVideoPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Unable to call onVideoEnd()", localRemoteException);
    }
  }

  public final void onVideoStart()
  {
    zzaas localzzaas = zza(this.zzfmq);
    if (localzzaas == null)
      return;
    try
    {
      localzzaas.onVideoStart();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd("Unable to call onVideoEnd()", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzccv
 * JD-Core Version:    0.6.2
 */