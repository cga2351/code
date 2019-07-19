package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzanm extends zzamu
{
  private final Object zzdge;
  private zzanp zzdgf;
  private zzatl zzdgg;
  private IObjectWrapper zzdgh;
  private MediationRewardedAd zzdgi;

  public zzanm(Adapter paramAdapter)
  {
    this.zzdge = paramAdapter;
  }

  public zzanm(MediationAdapter paramMediationAdapter)
  {
    this.zzdge = paramMediationAdapter;
  }

  private final Bundle zza(String paramString1, zzxx paramzzxx, String paramString2)
    throws RemoteException
  {
    String str1 = String.valueOf(paramString1);
    if (str1.length() != 0);
    Bundle localBundle;
    for (String str2 = "Server parameters: ".concat(str1); ; str2 = new String("Server parameters: "))
    {
      zzbae.zzdp(str2);
      try
      {
        localObject = new Bundle();
        if (paramString1 == null)
          break label141;
        JSONObject localJSONObject = new JSONObject(paramString1);
        localBundle = new Bundle();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localBundle.putString(str3, localJSONObject.getString(str3));
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
    }
    Object localObject = localBundle;
    label141: if ((this.zzdge instanceof AdMobAdapter))
    {
      ((Bundle)localObject).putString("adJson", paramString2);
      if (paramzzxx != null)
        ((Bundle)localObject).putInt("tagForChildDirectedTreatment", paramzzxx.zzcgs);
    }
    ((Bundle)localObject).remove("max_ad_content_rating");
    return localObject;
  }

  private static String zza(String paramString, zzxx paramzzxx)
  {
    String str1 = paramzzxx.zzche;
    try
    {
      String str2 = new JSONObject(paramString).getString("max_ad_content_rating");
      return str2;
    }
    catch (JSONException localJSONException)
    {
    }
    return str1;
  }

  private static boolean zzc(zzxx paramzzxx)
  {
    if (!paramzzxx.zzcgr)
      zzyr.zzpa();
    return zzazu.zzwx();
  }

  public final void destroy()
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationAdapter))
      return;
    try
    {
      ((MediationAdapter)this.zzdge).onDestroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final Bundle getInterstitialAdapterInfo()
  {
    if (!(this.zzdge instanceof zzbjm))
    {
      String str1 = zzbjm.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      return new Bundle();
    }
    return ((zzbjm)this.zzdge).getInterstitialAdapterInfo();
  }

  public final zzaap getVideoController()
  {
    if (!(this.zzdge instanceof zza))
      return null;
    try
    {
      zzaap localzzaap = ((zza)this.zzdge).getVideoController();
      return localzzaap;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    return null;
  }

  public final boolean isInitialized()
    throws RemoteException
  {
    if ((this.zzdge instanceof MediationRewardedVideoAdAdapter))
    {
      zzbae.zzdp("Check if adapter is initialized.");
      try
      {
        boolean bool = ((MediationRewardedVideoAdAdapter)this.zzdge).isInitialized();
        return bool;
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
    }
    if (!(this.zzdge instanceof Adapter))
    {
      String str1 = MediationRewardedVideoAdAdapter.class.getCanonicalName();
      String str2 = Adapter.class.getCanonicalName();
      String str3 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(26 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " or " + str2 + " #009 Class mismatch: " + str3);
      throw new RemoteException();
    }
    return this.zzdgg != null;
  }

  public final void pause()
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationAdapter))
      return;
    try
    {
      ((MediationAdapter)this.zzdge).onPause();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final void resume()
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationAdapter))
      return;
    try
    {
      ((MediationAdapter)this.zzdge).onResume();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final void setImmersiveMode(boolean paramBoolean)
    throws RemoteException
  {
    if (!(this.zzdge instanceof OnImmersiveModeUpdatedListener))
    {
      String str1 = OnImmersiveModeUpdatedListener.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      return;
    }
    try
    {
      ((OnImmersiveModeUpdatedListener)this.zzdge).onImmersiveModeUpdated(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
  }

  public final void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationInterstitialAdapter))
    {
      String str1 = MediationInterstitialAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzdge).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final void showVideo()
    throws RemoteException
  {
    if ((this.zzdge instanceof MediationRewardedVideoAdAdapter))
    {
      zzbae.zzdp("Show rewarded video ad from adapter.");
      try
      {
        ((MediationRewardedVideoAdAdapter)this.zzdge).showVideo();
        return;
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
    }
    if (!(this.zzdge instanceof Adapter))
    {
      String str1 = MediationRewardedVideoAdAdapter.class.getCanonicalName();
      String str2 = Adapter.class.getCanonicalName();
      String str3 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(26 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " or " + str2 + " #009 Class mismatch: " + str3);
      throw new RemoteException();
    }
    if (this.zzdgi != null)
    {
      this.zzdgi.showAd((Context)ObjectWrapper.unwrap(this.zzdgh));
      return;
    }
    zzbae.zzen("Can not show null mediated rewarded ad.");
    throw new RemoteException();
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzaip paramzzaip, List<zzaix> paramList)
    throws RemoteException
  {
    if (!(this.zzdge instanceof Adapter))
      throw new RemoteException();
    zzano localzzano = new zzano(this, paramzzaip);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      zzaix localzzaix = (zzaix)localIterator.next();
      String str = localzzaix.zzdbf;
      int i = -1;
      switch (str.hashCode())
      {
      default:
      case -1396342996:
      case 604727084:
      case -239580146:
      case -1052618729:
      }
      while (true)
        switch (i)
        {
        default:
          throw new RemoteException();
          if (str.equals("banner"))
          {
            i = 0;
            continue;
            if (str.equals("interstitial"))
            {
              i = 1;
              continue;
              if (str.equals("rewarded"))
              {
                i = 2;
                continue;
                if (str.equals("native"))
                  i = 3;
              }
            }
          }
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      AdFormat localAdFormat = AdFormat.BANNER;
      while (true)
      {
        localArrayList.add(new MediationConfiguration(localAdFormat, localzzaix.extras));
        break;
        localAdFormat = AdFormat.INTERSTITIAL;
        continue;
        localAdFormat = AdFormat.REWARDED;
        continue;
        localAdFormat = AdFormat.NATIVE;
      }
    }
    ((Adapter)this.zzdge).initialize((Context)ObjectWrapper.unwrap(paramIObjectWrapper), localzzano, localArrayList);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzatl paramzzatl, List<String> paramList)
    throws RemoteException
  {
    if (!(this.zzdge instanceof InitializableMediationRewardedVideoAdAdapter))
    {
      String str1 = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Initialize rewarded video adapter.");
    InitializableMediationRewardedVideoAdAdapter localInitializableMediationRewardedVideoAdAdapter;
    ArrayList localArrayList;
    try
    {
      localInitializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter)this.zzdge;
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(zza((String)localIterator.next(), null, null));
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzd("Could not initialize rewarded video adapter.", localThrowable);
      throw new RemoteException();
    }
    localInitializableMediationRewardedVideoAdAdapter.initialize((Context)ObjectWrapper.unwrap(paramIObjectWrapper), new zzato(paramzzatl), localArrayList);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    zza(paramIObjectWrapper, paramzzxx, paramString, null, paramzzamw);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, zzatl paramzzatl, String paramString2)
    throws RemoteException
  {
    if ((this.zzdge instanceof MediationRewardedVideoAdAdapter))
      zzbae.zzdp("Initialize rewarded video adapter.");
    while (true)
    {
      zzanl localzzanl1;
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzdge;
        Bundle localBundle1 = zza(paramString2, paramzzxx, null);
        if (paramzzxx == null)
          break label355;
        if (paramzzxx.zzcgq == null)
          break label364;
        localHashSet = new HashSet(paramzzxx.zzcgq);
        if (paramzzxx.zzcgo == -1L)
        {
          localDate = null;
          localzzanl1 = new zzanl(localDate, paramzzxx.zzcgp, localHashSet, paramzzxx.zzmw, zzc(paramzzxx), paramzzxx.zzcgs, paramzzxx.zzchb, paramzzxx.zzchd, zza(paramString2, paramzzxx));
          if (paramzzxx.zzcgw == null)
            break label345;
          localBundle2 = paramzzxx.zzcgw.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
          localzzanl2 = localzzanl1;
          localMediationRewardedVideoAdAdapter.initialize((Context)ObjectWrapper.unwrap(paramIObjectWrapper), localzzanl2, paramString1, new zzato(paramzzatl), localBundle1, localBundle2);
          return;
        }
        Date localDate = new Date(paramzzxx.zzcgo);
        continue;
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      if (!(this.zzdge instanceof Adapter))
      {
        String str1 = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String str2 = Adapter.class.getCanonicalName();
        String str3 = this.zzdge.getClass().getCanonicalName();
        zzbae.zzep(26 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " or " + str2 + " #009 Class mismatch: " + str3);
        throw new RemoteException();
      }
      this.zzdgh = paramIObjectWrapper;
      this.zzdgg = paramzzatl;
      paramzzatl.zzae(ObjectWrapper.wrap(this.zzdge));
      return;
      label345: zzanl localzzanl2 = localzzanl1;
      Bundle localBundle2 = null;
      continue;
      label355: localzzanl2 = null;
      localBundle2 = null;
      continue;
      label364: HashSet localHashSet = null;
    }
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationInterstitialAdapter))
    {
      String str1 = MediationInterstitialAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Requesting interstitial ad from adapter.");
    while (true)
    {
      try
      {
        MediationInterstitialAdapter localMediationInterstitialAdapter = (MediationInterstitialAdapter)this.zzdge;
        if (paramzzxx.zzcgq == null)
          break label275;
        localHashSet = new HashSet(paramzzxx.zzcgq);
        Date localDate;
        if (paramzzxx.zzcgo == -1L)
        {
          localDate = null;
          zzanl localzzanl = new zzanl(localDate, paramzzxx.zzcgp, localHashSet, paramzzxx.zzmw, zzc(paramzzxx), paramzzxx.zzcgs, paramzzxx.zzchb, paramzzxx.zzchd, zza(paramString1, paramzzxx));
          if (paramzzxx.zzcgw != null)
          {
            localBundle = paramzzxx.zzcgw.getBundle(localMediationInterstitialAdapter.getClass().getName());
            localMediationInterstitialAdapter.requestInterstitialAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper), new zzanp(paramzzamw), zza(paramString1, paramzzxx, paramString2), localzzanl, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramzzxx.zzcgo);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      Bundle localBundle = null;
      continue;
      label275: HashSet localHashSet = null;
    }
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw, zzadx paramzzadx, List<String> paramList)
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationNativeAdapter))
    {
      String str1 = MediationNativeAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    while (true)
    {
      try
      {
        MediationNativeAdapter localMediationNativeAdapter = (MediationNativeAdapter)this.zzdge;
        if (paramzzxx.zzcgq == null)
          break label282;
        localHashSet = new HashSet(paramzzxx.zzcgq);
        Date localDate;
        if (paramzzxx.zzcgo == -1L)
        {
          localDate = null;
          zzant localzzant = new zzant(localDate, paramzzxx.zzcgp, localHashSet, paramzzxx.zzmw, zzc(paramzzxx), paramzzxx.zzcgs, paramzzadx, paramList, paramzzxx.zzchb, paramzzxx.zzchd, zza(paramString1, paramzzxx));
          if (paramzzxx.zzcgw != null)
          {
            localBundle = paramzzxx.zzcgw.getBundle(localMediationNativeAdapter.getClass().getName());
            this.zzdgf = new zzanp(paramzzamw);
            localMediationNativeAdapter.requestNativeAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper), this.zzdgf, zza(paramString1, paramzzxx, paramString2), localzzant, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramzzxx.zzcgo);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      Bundle localBundle = null;
      continue;
      label282: HashSet localHashSet = null;
    }
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    zza(paramIObjectWrapper, paramzzyb, paramzzxx, paramString, null, paramzzamw);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationBannerAdapter))
    {
      String str1 = MediationBannerAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Requesting banner ad from adapter.");
    while (true)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.zzdge;
        if (paramzzxx.zzcgq == null)
          break label293;
        localHashSet = new HashSet(paramzzxx.zzcgq);
        Date localDate;
        if (paramzzxx.zzcgo == -1L)
        {
          localDate = null;
          zzanl localzzanl = new zzanl(localDate, paramzzxx.zzcgp, localHashSet, paramzzxx.zzmw, zzc(paramzzxx), paramzzxx.zzcgs, paramzzxx.zzchb, paramzzxx.zzchd, zza(paramString1, paramzzxx));
          if (paramzzxx.zzcgw != null)
          {
            localBundle = paramzzxx.zzcgw.getBundle(localMediationBannerAdapter.getClass().getName());
            localMediationBannerAdapter.requestBannerAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper), new zzanp(paramzzamw), zza(paramString1, paramzzxx, paramString2), zzb.zza(paramzzyb.width, paramzzyb.height, paramzzyb.zzaap), localzzanl, localBundle);
          }
        }
        else
        {
          localDate = new Date(paramzzxx.zzcgo);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      Bundle localBundle = null;
      continue;
      label293: HashSet localHashSet = null;
    }
  }

  public final void zza(zzxx paramzzxx, String paramString)
    throws RemoteException
  {
    zza(paramzzxx, paramString, null);
  }

  public final void zza(zzxx paramzzxx, String paramString1, String paramString2)
    throws RemoteException
  {
    if ((this.zzdge instanceof MediationRewardedVideoAdAdapter))
      zzbae.zzdp("Requesting rewarded video ad from adapter.");
    while (true)
    {
      try
      {
        MediationRewardedVideoAdAdapter localMediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter)this.zzdge;
        if (paramzzxx.zzcgq == null)
          break label323;
        localHashSet = new HashSet(paramzzxx.zzcgq);
        Date localDate;
        if (paramzzxx.zzcgo == -1L)
        {
          localDate = null;
          zzanl localzzanl = new zzanl(localDate, paramzzxx.zzcgp, localHashSet, paramzzxx.zzmw, zzc(paramzzxx), paramzzxx.zzcgs, paramzzxx.zzchb, paramzzxx.zzchd, zza(paramString1, paramzzxx));
          if (paramzzxx.zzcgw != null)
          {
            localBundle = paramzzxx.zzcgw.getBundle(localMediationRewardedVideoAdAdapter.getClass().getName());
            localMediationRewardedVideoAdAdapter.loadAd(localzzanl, zza(paramString1, paramzzxx, paramString2), localBundle);
          }
        }
        else
        {
          localDate = new Date(paramzzxx.zzcgo);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      Bundle localBundle = null;
      continue;
      if (!(this.zzdge instanceof Adapter))
      {
        String str1 = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String str2 = Adapter.class.getCanonicalName();
        String str3 = this.zzdge.getClass().getCanonicalName();
        zzbae.zzep(26 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " or " + str2 + " #009 Class mismatch: " + str3);
        throw new RemoteException();
      }
      zzb(this.zzdgh, paramzzxx, paramString1, new zzanq((Adapter)this.zzdge, this.zzdgg));
      return;
      label323: HashSet localHashSet = null;
    }
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    if (!(this.zzdge instanceof Adapter))
    {
      String str1 = Adapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Requesting rewarded ad from adapter.");
    try
    {
      Adapter localAdapter = (Adapter)this.zzdge;
      zzann localzzann = new zzann(this, paramzzamw, localAdapter);
      Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
      Bundle localBundle1 = zza(paramString, paramzzxx, null);
      Bundle localBundle2;
      if (paramzzxx.zzcgw != null)
      {
        localBundle2 = paramzzxx.zzcgw.getBundle(this.zzdge.getClass().getName());
        if (localBundle2 == null);
      }
      while (true)
      {
        localAdapter.loadRewardedAd(new MediationRewardedAdConfiguration(localContext, "", localBundle1, localBundle2, zzc(paramzzxx), paramzzxx.zzmw, paramzzxx.zzcgs, paramzzxx.zzchd, zza(paramString, paramzzxx)), localzzann);
        return;
        localBundle2 = new Bundle();
      }
    }
    catch (Exception localException)
    {
      zzbae.zzc("", localException);
    }
    throw new RemoteException();
  }

  public final void zzr(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    Context localContext = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    if ((this.zzdge instanceof OnContextChangedListener))
      ((OnContextChangedListener)this.zzdge).onContextChanged(localContext);
  }

  public final void zzs(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    if (!(this.zzdge instanceof Adapter))
    {
      String str1 = Adapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    zzbae.zzdp("Show rewarded ad from adapter.");
    if (this.zzdgi != null)
    {
      this.zzdgi.showAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper));
      return;
    }
    zzbae.zzen("Can not show null mediation rewarded ad.");
    throw new RemoteException();
  }

  public final IObjectWrapper zzse()
    throws RemoteException
  {
    if (!(this.zzdge instanceof MediationBannerAdapter))
    {
      String str1 = MediationBannerAdapter.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      throw new RemoteException();
    }
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(((MediationBannerAdapter)this.zzdge).getBannerView());
      return localIObjectWrapper;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final zzanb zzsf()
  {
    NativeAdMapper localNativeAdMapper = this.zzdgf.zzsr();
    if ((localNativeAdMapper instanceof NativeAppInstallAdMapper))
      return new zzanr((NativeAppInstallAdMapper)localNativeAdMapper);
    return null;
  }

  public final zzane zzsg()
  {
    NativeAdMapper localNativeAdMapper = this.zzdgf.zzsr();
    if ((localNativeAdMapper instanceof NativeContentAdMapper))
      return new zzans((NativeContentAdMapper)localNativeAdMapper);
    return null;
  }

  public final Bundle zzsh()
  {
    if (!(this.zzdge instanceof zzbjl))
    {
      String str1 = zzbjl.class.getCanonicalName();
      String str2 = this.zzdge.getClass().getCanonicalName();
      zzbae.zzep(22 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " #009 Class mismatch: " + str2);
      return new Bundle();
    }
    return ((zzbjl)this.zzdge).zzsh();
  }

  public final Bundle zzsi()
  {
    return new Bundle();
  }

  public final boolean zzsj()
  {
    return this.zzdge instanceof InitializableMediationRewardedVideoAdAdapter;
  }

  public final zzafd zzsk()
  {
    NativeCustomTemplateAd localNativeCustomTemplateAd = this.zzdgf.zzst();
    if ((localNativeCustomTemplateAd instanceof zzafg))
      return ((zzafg)localNativeCustomTemplateAd).zzrn();
    return null;
  }

  public final zzanh zzsl()
  {
    UnifiedNativeAdMapper localUnifiedNativeAdMapper = this.zzdgf.zzss();
    if (localUnifiedNativeAdMapper != null)
      return new zzaoj(localUnifiedNativeAdMapper);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanm
 * JD-Core Version:    0.6.2
 */