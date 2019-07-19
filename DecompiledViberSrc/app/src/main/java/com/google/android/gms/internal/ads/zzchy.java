package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;

public final class zzchy extends zzchw
{
  public zzchy(Context paramContext)
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
      this.zzfxi.zztr().zzb(this.zzfxh, new zzchx(this));
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
        zzk.zzlk().zza(localThrowable, "RemoteSignalsClientTask.onConnected");
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

  public final zzbbi<InputStream> zzg(zzary paramzzary)
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
      this.zzddx.zza(new zzchz(this), zzbbn.zzeah);
      zzbbs localzzbbs1 = this.zzddx;
      return localzzbbs1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzchy
 * JD-Core Version:    0.6.2
 */