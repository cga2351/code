package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzapd extends zzaox
{
  private MediationRewardedAd zzdgi;
  private final RtbAdapter zzdhe;
  private MediationInterstitialAd zzdhf;

  public zzapd(RtbAdapter paramRtbAdapter)
  {
    this.zzdhe = paramRtbAdapter;
  }

  @Nullable
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

  private final Bundle zzd(zzxx paramzzxx)
  {
    if (paramzzxx.zzcgw != null)
    {
      Bundle localBundle = paramzzxx.zzcgw.getBundle(this.zzdhe.getClass().getName());
      if (localBundle != null)
        return localBundle;
    }
    return new Bundle();
  }

  private static Bundle zzde(String paramString)
    throws RemoteException
  {
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    Bundle localBundle;
    for (String str2 = "Server parameters: ".concat(str1); ; str2 = new String("Server parameters: "))
    {
      zzbae.zzep(str2);
      try
      {
        localObject = new Bundle();
        if (paramString == null)
          break label133;
        JSONObject localJSONObject = new JSONObject(paramString);
        localBundle = new Bundle();
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localBundle.putString(str3, localJSONObject.getString(str3));
        }
      }
      catch (JSONException localJSONException)
      {
        zzbae.zzc("", localJSONException);
        throw new RemoteException();
      }
    }
    Object localObject = localBundle;
    label133: return localObject;
  }

  public final zzaap getVideoController()
  {
    if (!(this.zzdhe instanceof zza))
      return null;
    try
    {
      zzaap localzzaap = ((zza)this.zzdhe).getVideoController();
      return localzzaap;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    return null;
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, String paramString, Bundle paramBundle1, Bundle paramBundle2, zzyb paramzzyb, zzaoz paramzzaoz)
    throws RemoteException
  {
    zzapi localzzapi;
    RtbAdapter localRtbAdapter;
    int i;
    try
    {
      localzzapi = new zzapi(this, paramzzaoz);
      localRtbAdapter = this.zzdhe;
      i = -1;
      switch (paramString.hashCode())
      {
      case -1396342996:
        throw new IllegalArgumentException("Internal Error");
      case 604727084:
      case -239580146:
      case -1052618729:
      }
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("Error generating signals for RTB", localThrowable);
      throw new RemoteException();
    }
    if (paramString.equals("banner"))
    {
      i = 0;
      break label240;
      if (paramString.equals("interstitial"))
      {
        i = 1;
        break label240;
        if (paramString.equals("rewarded"))
        {
          i = 2;
          break label240;
          if (paramString.equals("native"))
          {
            i = 3;
            break label240;
            AdFormat localAdFormat = AdFormat.BANNER;
            while (true)
            {
              MediationConfiguration localMediationConfiguration = new MediationConfiguration(localAdFormat, paramBundle2);
              localRtbAdapter.collectSignals(new RtbSignalData((Context)ObjectWrapper.unwrap(paramIObjectWrapper), localMediationConfiguration, paramBundle1, zzb.zza(paramzzyb.width, paramzzyb.height, paramzzyb.zzaap)), localzzapi);
              return;
              localAdFormat = AdFormat.INTERSTITIAL;
              continue;
              localAdFormat = AdFormat.REWARDED;
              continue;
              localAdFormat = AdFormat.NATIVE;
            }
          }
        }
      }
    }
    label240: switch (i)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaok paramzzaok, zzamw paramzzamw, zzyb paramzzyb)
    throws RemoteException
  {
    try
    {
      zzape localzzape = new zzape(this, paramzzaok, paramzzamw);
      this.zzdhe.loadBannerAd(new MediationBannerAdConfiguration((Context)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, zzde(paramString2), zzd(paramzzxx), zzc(paramzzxx), paramzzxx.zzmw, paramzzxx.zzcgs, paramzzxx.zzchd, zza(paramString2, paramzzxx), zzb.zza(paramzzyb.width, paramzzyb.height, paramzzyb.zzaap)), localzzape);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("Adapter failed to render banner ad.", localThrowable);
    }
    throw new RemoteException();
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaon paramzzaon, zzamw paramzzamw)
    throws RemoteException
  {
    try
    {
      zzapf localzzapf = new zzapf(this, paramzzaon, paramzzamw);
      this.zzdhe.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, zzde(paramString2), zzd(paramzzxx), zzc(paramzzxx), paramzzxx.zzmw, paramzzxx.zzcgs, paramzzxx.zzchd, zza(paramString2, paramzzxx)), localzzapf);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("Adapter failed to render interstitial ad.", localThrowable);
    }
    throw new RemoteException();
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaoq paramzzaoq, zzamw paramzzamw)
    throws RemoteException
  {
    try
    {
      zzaph localzzaph = new zzaph(this, paramzzaoq, paramzzamw);
      this.zzdhe.loadNativeAd(new MediationNativeAdConfiguration((Context)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, zzde(paramString2), zzd(paramzzxx), zzc(paramzzxx), paramzzxx.zzmw, paramzzxx.zzcgs, paramzzxx.zzchd, zza(paramString2, paramzzxx)), localzzaph);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("Adapter failed to render rewarded ad.", localThrowable);
    }
    throw new RemoteException();
  }

  public final void zza(String paramString1, String paramString2, zzxx paramzzxx, IObjectWrapper paramIObjectWrapper, zzaot paramzzaot, zzamw paramzzamw)
    throws RemoteException
  {
    try
    {
      zzapg localzzapg = new zzapg(this, paramzzaot, paramzzamw);
      this.zzdhe.loadRewardedAd(new MediationRewardedAdConfiguration((Context)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, zzde(paramString2), zzd(paramzzxx), zzc(paramzzxx), paramzzxx.zzmw, paramzzxx.zzcgs, paramzzxx.zzchd, zza(paramString2, paramzzxx)), localzzapg);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("Adapter failed to render rewarded ad.", localThrowable);
    }
    throw new RemoteException();
  }

  public final void zza(String[] paramArrayOfString, Bundle[] paramArrayOfBundle)
  {
  }

  public final zzapk zzsx()
    throws RemoteException
  {
    return zzapk.zza(this.zzdhe.getVersionInfo());
  }

  public final zzapk zzsy()
    throws RemoteException
  {
    return zzapk.zza(this.zzdhe.getSDKVersionInfo());
  }

  public final void zzx(IObjectWrapper paramIObjectWrapper)
  {
  }

  public final boolean zzy(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    if (this.zzdhf == null)
      return false;
    try
    {
      this.zzdhf.showAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper));
      return true;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        zzbae.zzc("", localThrowable);
    }
  }

  public final boolean zzz(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
    if (this.zzdgi == null)
      return false;
    try
    {
      this.zzdgi.showAd((Context)ObjectWrapper.unwrap(paramIObjectWrapper));
      return true;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        zzbae.zzc("", localThrowable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapd
 * JD-Core Version:    0.6.2
 */