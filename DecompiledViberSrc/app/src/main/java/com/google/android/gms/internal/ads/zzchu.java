package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;

public final class zzchu extends zzchw
{
  public zzchu(Context paramContext)
  {
    this.zzfxi = new zzarg(paramContext, zzk.zzlu().zzwr(), this, this);
  }

  public final void onConnected(Bundle paramBundle)
  {
    synchronized (this.mLock)
    {
      if (!this.zzfxg)
        this.zzfxg = true;
    }
    try
    {
      this.zzfxi.zztr().zza(this.zzfxh, new zzchx(this));
      while (true)
      {
        return;
        label46: this.zzddx.setException(new zzcid(0));
      }
      localObject2 = finally;
      throw localObject2;
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        zzk.zzlk().zza(localThrowable, "RemoteAdRequestClientTask.onConnected");
        this.zzddx.setException(new zzcid(0));
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label46;
    }
    catch (RemoteException localRemoteException)
    {
      break label46;
    }
  }

  public final void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzaxa.zzdp("Cannot connect to remote service, fallback to local instance.");
    this.zzddx.setException(new zzcid(0));
  }

  public final zzbbi<InputStream> zzf(zzary paramzzary)
  {
    synchronized (this.mLock)
    {
      if (this.zzfxf)
      {
        zzbbs localzzbbs2 = this.zzddx;
        return localzzbbs2;
      }
      this.zzfxf = true;
      this.zzfxh = paramzzary;
      this.zzfxi.checkAvailabilityAndConnect();
      this.zzddx.zza(new zzchv(this), zzbbn.zzeah);
      zzbbs localzzbbs1 = this.zzddx;
      return localzzbbs1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchu
 * JD-Core Version:    0.6.2
 */