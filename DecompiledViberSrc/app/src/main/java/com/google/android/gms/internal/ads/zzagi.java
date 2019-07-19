package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.UnconfirmedClickListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzagi extends UnifiedNativeAd
{
  private final VideoController zzcjf = new VideoController();
  private final List<NativeAd.Image> zzcyt = new ArrayList();
  private final zzaek zzcyu;
  private final NativeAd.AdChoicesInfo zzcyv;
  private final zzagf zzczb;
  private final List<MuteThisAdReason> zzczc = new ArrayList();
  private final UnifiedNativeAd.zza zzczd;

  public zzagi(zzagf paramzzagf)
  {
    this.zzczb = paramzzagf;
    while (true)
    {
      IBinder localIBinder;
      Object localObject4;
      try
      {
        List localList2 = this.zzczb.getImages();
        if (localList2 != null)
        {
          Iterator localIterator2 = localList2.iterator();
          if (localIterator2.hasNext())
          {
            Object localObject3 = localIterator2.next();
            if (!(localObject3 instanceof IBinder))
              break label397;
            localIBinder = (IBinder)localObject3;
            if (localIBinder == null)
              break label397;
            IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (!(localIInterface instanceof zzaeh))
              break label379;
            localObject4 = (zzaeh)localIInterface;
            if (localObject4 == null)
              continue;
            this.zzcyt.add(new zzaek((zzaeh)localObject4));
            continue;
          }
        }
      }
      catch (RemoteException localRemoteException1)
      {
        zzbae.zzc("", localRemoteException1);
      }
      zzaai localzzaai;
      try
      {
        List localList1 = this.zzczb.getMuteThisAdReasons();
        if (localList1 != null)
        {
          Iterator localIterator1 = localList1.iterator();
          while (localIterator1.hasNext())
          {
            Object localObject2 = localIterator1.next();
            if (!(localObject2 instanceof IBinder))
              break label403;
            localzzaai = zzaaj.zzf((IBinder)localObject2);
            label228: if (localzzaai != null)
              this.zzczc.add(new zzaal(localzzaai));
          }
        }
      }
      catch (RemoteException localRemoteException2)
      {
        zzbae.zzc("", localRemoteException2);
      }
      try
      {
        zzaeh localzzaeh = this.zzczb.zzri();
        if (localzzaeh != null)
        {
          localzzaek = new zzaek(localzzaeh);
          this.zzcyu = localzzaek;
        }
      }
      catch (RemoteException localRemoteException4)
      {
        try
        {
          if (this.zzczb.zzrj() != null)
          {
            localzzaec = new zzaec(this.zzczb.zzrj());
            this.zzcyv = localzzaec;
          }
        }
        catch (RemoteException localRemoteException4)
        {
          try
          {
            while (true)
            {
              zzaed localzzaed = this.zzczb.zzrp();
              localObject1 = null;
              if (localzzaed != null)
              {
                zzaeg localzzaeg = new zzaeg(this.zzczb.zzrp());
                localObject1 = localzzaeg;
              }
              this.zzczd = localObject1;
              return;
              label379: zzaej localzzaej = new zzaej(localIBinder);
              localObject4 = localzzaej;
              break;
              label397: localObject4 = null;
              break;
              label403: localzzaai = null;
              break label228;
              zzaek localzzaek = null;
              continue;
              localRemoteException3 = localRemoteException3;
              zzbae.zzc("", localRemoteException3);
              localzzaek = null;
            }
            localRemoteException4 = localRemoteException4;
            zzbae.zzc("", localRemoteException4);
            zzaec localzzaec = null;
          }
          catch (RemoteException localRemoteException5)
          {
            while (true)
            {
              zzbae.zzc("", localRemoteException5);
              Object localObject1 = null;
            }
          }
        }
      }
    }
  }

  private final IObjectWrapper zzrh()
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzczb.zzrh();
      return localIObjectWrapper;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final void cancelUnconfirmedClick()
  {
    try
    {
      this.zzczb.cancelUnconfirmedClick();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Failed to cancelUnconfirmedClick", localRemoteException);
    }
  }

  public final void destroy()
  {
    try
    {
      this.zzczb.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void enableCustomClickGesture()
  {
    try
    {
      this.zzczb.zzro();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final NativeAd.AdChoicesInfo getAdChoicesInfo()
  {
    return this.zzcyv;
  }

  public final String getAdvertiser()
  {
    try
    {
      String str = this.zzczb.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final String getBody()
  {
    try
    {
      String str = this.zzczb.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final String getCallToAction()
  {
    try
    {
      String str = this.zzczb.getCallToAction();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final Bundle getExtras()
  {
    try
    {
      Bundle localBundle = this.zzczb.getExtras();
      if (localBundle != null)
        return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return new Bundle();
  }

  public final String getHeadline()
  {
    try
    {
      String str = this.zzczb.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final NativeAd.Image getIcon()
  {
    return this.zzcyu;
  }

  public final List<NativeAd.Image> getImages()
  {
    return this.zzcyt;
  }

  public final String getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzczb.getMediationAdapterClassName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final List<MuteThisAdReason> getMuteThisAdReasons()
  {
    return this.zzczc;
  }

  public final String getPrice()
  {
    try
    {
      String str = this.zzczb.getPrice();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final Double getStarRating()
  {
    try
    {
      double d = this.zzczb.getStarRating();
      if (d == -1.0D)
        return null;
      Double localDouble = Double.valueOf(d);
      return localDouble;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final String getStore()
  {
    try
    {
      String str = this.zzczb.getStore();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final VideoController getVideoController()
  {
    try
    {
      if (this.zzczb.getVideoController() != null)
        this.zzcjf.zza(this.zzczb.getVideoController());
      return this.zzcjf;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Exception occurred while getting video controller", localRemoteException);
    }
  }

  public final boolean isCustomMuteThisAdEnabled()
  {
    try
    {
      boolean bool = this.zzczb.isCustomMuteThisAdEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return false;
  }

  public final void muteThisAd(MuteThisAdReason paramMuteThisAdReason)
  {
    try
    {
      if (!isCustomMuteThisAdEnabled())
      {
        zzbae.zzen("Ad is not custom mute enabled");
        return;
      }
      if (paramMuteThisAdReason == null)
      {
        this.zzczb.zza(null);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
      return;
    }
    if ((paramMuteThisAdReason instanceof zzaal))
    {
      this.zzczb.zza(((zzaal)paramMuteThisAdReason).zzpu());
      return;
    }
    zzbae.zzen("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
  }

  public final void performClick(Bundle paramBundle)
  {
    try
    {
      this.zzczb.performClick(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void recordCustomClickGesture()
  {
    try
    {
      this.zzczb.recordCustomClickGesture();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final boolean recordImpression(Bundle paramBundle)
  {
    try
    {
      boolean bool = this.zzczb.recordImpression(paramBundle);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return false;
  }

  public final void reportTouchEvent(Bundle paramBundle)
  {
    try
    {
      this.zzczb.reportTouchEvent(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void setMuteThisAdListener(MuteThisAdListener paramMuteThisAdListener)
  {
    try
    {
      this.zzczb.zza(new zzaah(paramMuteThisAdListener));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }

  public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener paramUnconfirmedClickListener)
  {
    try
    {
      this.zzczb.zza(new zzags(paramUnconfirmedClickListener));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Failed to setUnconfirmedClickListener", localRemoteException);
    }
  }

  public final Object zzkv()
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzczb.zzrk();
      if (localIObjectWrapper != null)
      {
        Object localObject = ObjectWrapper.unwrap(localIObjectWrapper);
        return localObject;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagi
 * JD-Core Version:    0.6.2
 */