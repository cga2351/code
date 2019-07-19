package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.initialization.AdapterStatus.State;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.zza;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzabc
{
  private static final Object lock = new Object();

  @GuardedBy("lock")
  private static zzabc zzcjp;
  private zzzz zzcjq;
  private RewardedVideoAd zzcjr;
  private InitializationStatus zzcjs;

  public static zzabc zzqf()
  {
    synchronized (lock)
    {
      if (zzcjp == null)
        zzcjp = new zzabc();
      zzabc localzzabc = zzcjp;
      return localzzabc;
    }
  }

  public final InitializationStatus getInitializationStatus()
  {
    if (this.zzcjq != null);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkState(bool, "MobileAds.initialize() must be called prior to getting initialization status.");
      HashMap localHashMap;
      while (true)
      {
        try
        {
          if (this.zzcjs != null)
            return this.zzcjs;
          List localList = this.zzcjq.zzps();
          localHashMap = new HashMap();
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
            break;
          zzain localzzain = (zzain)localIterator.next();
          String str = localzzain.zzdba;
          if (localzzain.zzdbb)
          {
            localState = AdapterStatus.State.READY;
            localHashMap.put(str, new zzaiv(localState, localzzain.description, localzzain.zzdbc));
            continue;
          }
        }
        catch (RemoteException localRemoteException)
        {
          zzbae.zzen("Unable to get Initialization status.");
          return null;
        }
        AdapterStatus.State localState = AdapterStatus.State.NOT_READY;
      }
      zzaiw localzzaiw = new zzaiw(localHashMap);
      return localzzaiw;
    }
  }

  public final RewardedVideoAd getRewardedVideoAdInstance(Context paramContext)
  {
    synchronized (lock)
    {
      if (this.zzcjr != null)
      {
        RewardedVideoAd localRewardedVideoAd2 = this.zzcjr;
        return localRewardedVideoAd2;
      }
      zzamp localzzamp = new zzamp();
      this.zzcjr = new zzatk(paramContext, (zzasx)new zzyo(zzyr.zzpb(), paramContext, localzzamp).zzd(paramContext, false));
      RewardedVideoAd localRewardedVideoAd1 = this.zzcjr;
      return localRewardedVideoAd1;
    }
  }

  public final String getVersionString()
  {
    boolean bool;
    if (this.zzcjq != null)
      bool = true;
    while (true)
    {
      Preconditions.checkState(bool, "MobileAds.initialize() must be called prior to getting version string.");
      try
      {
        String str = this.zzcjq.getVersionString();
        return str;
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzc("Unable to get version string.", localRemoteException);
      }
    }
    return "";
  }

  public final void openDebugMenu(Context paramContext, String paramString)
  {
    boolean bool;
    if (this.zzcjq != null)
      bool = true;
    while (true)
    {
      Preconditions.checkState(bool, "MobileAds.initialize() must be called prior to opening debug menu.");
      try
      {
        this.zzcjq.zzc(ObjectWrapper.wrap(paramContext), paramString);
        return;
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzc("Unable to open debug menu.", localRemoteException);
      }
    }
  }

  public final void registerRtbAdapter(Class<? extends RtbAdapter> paramClass)
  {
    try
    {
      this.zzcjq.zzbv(paramClass.getCanonicalName());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to register RtbAdapter", localRemoteException);
    }
  }

  public final void setAppMuted(boolean paramBoolean)
  {
    boolean bool;
    if (this.zzcjq != null)
      bool = true;
    while (true)
    {
      Preconditions.checkState(bool, "MobileAds.initialize() must be called prior to setting app muted state.");
      try
      {
        this.zzcjq.setAppMuted(paramBoolean);
        return;
        bool = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzc("Unable to set app mute state.", localRemoteException);
      }
    }
  }

  public final void setAppVolume(float paramFloat)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((0.0F <= paramFloat) && (paramFloat <= 1.0F))
      bool2 = bool1;
    while (true)
    {
      Preconditions.checkArgument(bool2, "The app volume must be a value between 0 and 1 inclusive.");
      if (this.zzcjq != null)
        Preconditions.checkState(bool1, "MobileAds.initialize() must be called prior to setting the app volume.");
      try
      {
        this.zzcjq.setAppVolume(paramFloat);
        return;
        bool2 = false;
        continue;
        bool1 = false;
      }
      catch (RemoteException localRemoteException)
      {
        zzbae.zzc("Unable to set app volume.", localRemoteException);
      }
    }
  }

  public final void zza(Context paramContext, String paramString, zzabh paramzzabh, zza paramzza)
  {
    synchronized (lock)
    {
      if (this.zzcjq != null)
        return;
      if (paramContext == null)
        throw new IllegalArgumentException("Context cannot be null.");
    }
    try
    {
      zzamj.initialize(paramContext, paramString);
      this.zzcjq = ((zzzz)new zzyl(zzyr.zzpb(), paramContext).zzd(paramContext, false));
      this.zzcjq.zza(new zzamp());
      this.zzcjq.zza();
      this.zzcjq.zzb(paramString, ObjectWrapper.wrap(new zzabd(this, paramContext)));
      zzact.initialize(paramContext);
      zzaci localzzaci1 = zzact.zzcux;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      {
        zzaci localzzaci2 = zzact.zzcvd;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
        {
          i = 1;
          if (i == 0)
          {
            zzbae.zzen("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
            this.zzcjs = new zzabe(this);
          }
          return;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zzd("MobileAdsSettingManager initialization failed", localRemoteException);
        continue;
        int i = 0;
      }
    }
  }

  public final float zzpq()
  {
    if (this.zzcjq == null)
      return 1.0F;
    try
    {
      float f = this.zzcjq.zzpq();
      return f;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to get app volume.", localRemoteException);
    }
    return 1.0F;
  }

  public final boolean zzpr()
  {
    if (this.zzcjq == null)
      return false;
    try
    {
      boolean bool = this.zzcjq.zzpr();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to get app mute state.", localRemoteException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabc
 * JD-Core Version:    0.6.2
 */