package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import java.io.InputStream;

public abstract class zzchw
  implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener
{
  protected final Object mLock = new Object();
  protected final zzbbs<InputStream> zzddx = new zzbbs();
  protected boolean zzfxf = false;
  protected boolean zzfxg = false;
  protected zzary zzfxh;
  protected zzarg zzfxi;

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzaxa.zzdp("Disconnected from remote ad request service.");
    this.zzddx.setException(new zzcid(0));
  }

  public void onConnectionSuspended(int paramInt)
  {
    zzaxa.zzdp("Cannot connect to remote service, fallback to local instance.");
  }

  protected final void zzakh()
  {
    synchronized (this.mLock)
    {
      this.zzfxg = true;
      if ((this.zzfxi.isConnected()) || (this.zzfxi.isConnecting()))
        this.zzfxi.disconnect();
      Binder.flushPendingCommands();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchw
 * JD-Core Version:    0.6.2
 */