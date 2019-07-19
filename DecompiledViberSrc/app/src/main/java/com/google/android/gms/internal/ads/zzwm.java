package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzwm
{

  @VisibleForTesting
  zzfx zzbzc;

  @VisibleForTesting
  boolean zzbzd;

  public zzwm()
  {
  }

  public zzwm(Context paramContext)
  {
    zzact.initialize(paramContext);
    zzaci localzzaci = zzact.zzcum;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    try
    {
      this.zzbzc = ((zzfx)zzbaf.zza(paramContext, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzwo.zzbze));
      ObjectWrapper.wrap(paramContext);
      this.zzbzc.zzb(ObjectWrapper.wrap(paramContext), "GMA_SDK");
      this.zzbzd = true;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      zzbae.zzdp("Cannot dynamite load clearcut");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label72;
    }
    catch (zzbah localzzbah)
    {
      label72: break label72;
    }
  }

  public zzwm(Context paramContext, String paramString1, String paramString2)
  {
    zzact.initialize(paramContext);
    try
    {
      this.zzbzc = ((zzfx)zzbaf.zza(paramContext, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzwn.zzbze));
      ObjectWrapper.wrap(paramContext);
      this.zzbzc.zza(ObjectWrapper.wrap(paramContext), paramString1, null);
      this.zzbzd = true;
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      zzbae.zzdp("Cannot dynamite load clearcut");
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label52;
    }
    catch (zzbah localzzbah)
    {
      label52: break label52;
    }
  }

  public final zzwq zzg(byte[] paramArrayOfByte)
  {
    return new zzwq(this, paramArrayOfByte, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwm
 * JD-Core Version:    0.6.2
 */