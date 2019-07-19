package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzare
public final class zzanu<NETWORK_EXTRAS extends f, SERVER_PARAMETERS extends e> extends zzamu
{
  private final com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdgx;
  private final NETWORK_EXTRAS zzdgy;

  public zzanu(com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> paramb, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.zzdgx = paramb;
    this.zzdgy = paramNETWORK_EXTRAS;
  }

  private static boolean zzc(zzxx paramzzxx)
  {
    if (!paramzzxx.zzcgr)
      zzyr.zzpa();
    return zzazu.zzwx();
  }

  private final SERVER_PARAMETERS zzda(String paramString)
    throws RemoteException
  {
    HashMap localHashMap;
    if (paramString != null)
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localHashMap = new HashMap(localJSONObject.length());
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, localJSONObject.getString(str));
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
    else
      localHashMap = new HashMap(0);
    Class localClass = this.zzdgx.getServerParametersType();
    e locale = null;
    if (localClass != null)
    {
      locale = (e)localClass.newInstance();
      locale.a(localHashMap);
    }
    return locale;
  }

  public final void destroy()
    throws RemoteException
  {
    try
    {
      this.zzdgx.destroy();
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
    return new Bundle();
  }

  public final zzaap getVideoController()
  {
    return null;
  }

  public final boolean isInitialized()
  {
    return true;
  }

  public final void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }

  public final void setImmersiveMode(boolean paramBoolean)
  {
  }

  public final void showInterstitial()
    throws RemoteException
  {
    if (!(this.zzdgx instanceof MediationInterstitialAdapter))
    {
      String str1 = String.valueOf(this.zzdgx.getClass().getCanonicalName());
      if (str1.length() != 0);
      for (String str2 = "Not a MediationInterstitialAdapter: ".concat(str1); ; str2 = new String("Not a MediationInterstitialAdapter: "))
      {
        zzbae.zzep(str2);
        throw new RemoteException();
      }
    }
    zzbae.zzdp("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzdgx).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final void showVideo()
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzaip paramzzaip, List<zzaix> paramList)
    throws RemoteException
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzatl paramzzatl, List<String> paramList)
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    zza(paramIObjectWrapper, paramzzxx, paramString, null, paramzzamw);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, zzatl paramzzatl, String paramString2)
    throws RemoteException
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    if (!(this.zzdgx instanceof MediationInterstitialAdapter))
    {
      String str1 = String.valueOf(this.zzdgx.getClass().getCanonicalName());
      if (str1.length() != 0);
      for (String str2 = "Not a MediationInterstitialAdapter: ".concat(str1); ; str2 = new String("Not a MediationInterstitialAdapter: "))
      {
        zzbae.zzep(str2);
        throw new RemoteException();
      }
    }
    zzbae.zzdp("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.zzdgx).requestInterstitialAd(new zzanv(paramzzamw), (Activity)ObjectWrapper.unwrap(paramIObjectWrapper), zzda(paramString1), zzaoh.zza(paramzzxx, zzc(paramzzxx)), this.zzdgy);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzbae.zzc("", localThrowable);
    }
    throw new RemoteException();
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw, zzadx paramzzadx, List<String> paramList)
  {
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
    zza(paramIObjectWrapper, paramzzyb, paramzzxx, paramString, null, paramzzamw);
  }

  public final void zza(IObjectWrapper paramIObjectWrapper, zzyb paramzzyb, zzxx paramzzxx, String paramString1, String paramString2, zzamw paramzzamw)
    throws RemoteException
  {
    int i = 0;
    if (!(this.zzdgx instanceof MediationBannerAdapter))
    {
      String str1 = String.valueOf(this.zzdgx.getClass().getCanonicalName());
      if (str1.length() != 0);
      for (String str2 = "Not a MediationBannerAdapter: ".concat(str1); ; str2 = new String("Not a MediationBannerAdapter: "))
      {
        zzbae.zzep(str2);
        throw new RemoteException();
      }
    }
    zzbae.zzdp("Requesting banner ad from adapter.");
    while (true)
    {
      try
      {
        MediationBannerAdapter localMediationBannerAdapter = (MediationBannerAdapter)this.zzdgx;
        zzanv localzzanv = new zzanv(paramzzamw);
        Activity localActivity = (Activity)ObjectWrapper.unwrap(paramIObjectWrapper);
        e locale = zzda(paramString1);
        com.google.ads.b[] arrayOfb = new com.google.ads.b[6];
        arrayOfb[0] = com.google.ads.b.a;
        arrayOfb[1] = com.google.ads.b.b;
        arrayOfb[2] = com.google.ads.b.c;
        arrayOfb[3] = com.google.ads.b.d;
        arrayOfb[4] = com.google.ads.b.e;
        arrayOfb[5] = com.google.ads.b.f;
        com.google.ads.b localb;
        if (i < 6)
        {
          if ((arrayOfb[i].a() == paramzzyb.width) && (arrayOfb[i].b() == paramzzyb.height))
          {
            localb = arrayOfb[i];
            localMediationBannerAdapter.requestBannerAd(localzzanv, localActivity, locale, localb, zzaoh.zza(paramzzxx, zzc(paramzzxx)), this.zzdgy);
          }
        }
        else
        {
          localb = new com.google.ads.b(zzb.zza(paramzzyb.width, paramzzyb.height, paramzzyb.zzaap));
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        zzbae.zzc("", localThrowable);
        throw new RemoteException();
      }
      i++;
    }
  }

  public final void zza(zzxx paramzzxx, String paramString)
  {
  }

  public final void zza(zzxx paramzzxx, String paramString1, String paramString2)
  {
  }

  public final void zzb(IObjectWrapper paramIObjectWrapper, zzxx paramzzxx, String paramString, zzamw paramzzamw)
    throws RemoteException
  {
  }

  public final void zzr(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final void zzs(IObjectWrapper paramIObjectWrapper)
    throws RemoteException
  {
  }

  public final IObjectWrapper zzse()
    throws RemoteException
  {
    if (!(this.zzdgx instanceof MediationBannerAdapter))
    {
      String str1 = String.valueOf(this.zzdgx.getClass().getCanonicalName());
      if (str1.length() != 0);
      for (String str2 = "Not a MediationBannerAdapter: ".concat(str1); ; str2 = new String("Not a MediationBannerAdapter: "))
      {
        zzbae.zzep(str2);
        throw new RemoteException();
      }
    }
    try
    {
      IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(((MediationBannerAdapter)this.zzdgx).getBannerView());
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
    return null;
  }

  public final zzane zzsg()
  {
    return null;
  }

  public final Bundle zzsh()
  {
    return new Bundle();
  }

  public final Bundle zzsi()
  {
    return new Bundle();
  }

  public final boolean zzsj()
  {
    return false;
  }

  public final zzafd zzsk()
  {
    return null;
  }

  public final zzanh zzsl()
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzanu
 * JD-Core Version:    0.6.2
 */