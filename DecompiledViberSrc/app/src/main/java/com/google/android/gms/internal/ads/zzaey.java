package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzaey extends NativeAppInstallAd
{
  private final VideoController zzcjf = new VideoController();
  private final zzaev zzcys;
  private final List<NativeAd.Image> zzcyt = new ArrayList();
  private final zzaek zzcyu;
  private final NativeAd.AdChoicesInfo zzcyv;

  public zzaey(zzaev paramzzaev)
  {
    this.zzcys = paramzzaev;
    while (true)
    {
      IBinder localIBinder;
      Object localObject3;
      try
      {
        List localList = this.zzcys.getImages();
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            Object localObject2 = localIterator.next();
            if (!(localObject2 instanceof IBinder))
              break label254;
            localIBinder = (IBinder)localObject2;
            if (localIBinder == null)
              break label254;
            IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (!(localIInterface instanceof zzaeh))
              break label236;
            localObject3 = (zzaeh)localIInterface;
            if (localObject3 == null)
              continue;
            this.zzcyt.add(new zzaek((zzaeh)localObject3));
            continue;
          }
        }
      }
      catch (RemoteException localRemoteException1)
      {
        zzbae.zzc("", localRemoteException1);
      }
      try
      {
        zzaeh localzzaeh = this.zzcys.zzri();
        if (localzzaeh != null)
        {
          localzzaek = new zzaek(localzzaeh);
          this.zzcyu = localzzaek;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        try
        {
          while (true)
          {
            zzadz localzzadz = this.zzcys.zzrj();
            localObject1 = null;
            if (localzzadz != null)
            {
              zzaec localzzaec = new zzaec(this.zzcys.zzrj());
              localObject1 = localzzaec;
            }
            this.zzcyv = localObject1;
            return;
            label236: zzaej localzzaej = new zzaej(localIBinder);
            localObject3 = localzzaej;
            break;
            label254: localObject3 = null;
            break;
            localzzaek = null;
          }
          localRemoteException2 = localRemoteException2;
          zzbae.zzc("", localRemoteException2);
          zzaek localzzaek = null;
        }
        catch (RemoteException localRemoteException3)
        {
          while (true)
          {
            zzbae.zzc("", localRemoteException3);
            Object localObject1 = null;
          }
        }
      }
    }
  }

  private final IObjectWrapper zzrh()
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzcys.zzrh();
      return localIObjectWrapper;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final void destroy()
  {
    try
    {
      this.zzcys.destroy();
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

  public final CharSequence getBody()
  {
    try
    {
      String str = this.zzcys.getBody();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final CharSequence getCallToAction()
  {
    try
    {
      String str = this.zzcys.getCallToAction();
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
      Bundle localBundle = this.zzcys.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final CharSequence getHeadline()
  {
    try
    {
      String str = this.zzcys.getHeadline();
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

  public final CharSequence getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzcys.getMediationAdapterClassName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final CharSequence getPrice()
  {
    try
    {
      String str = this.zzcys.getPrice();
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
      double d = this.zzcys.getStarRating();
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

  public final CharSequence getStore()
  {
    try
    {
      String str = this.zzcys.getStore();
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
      if (this.zzcys.getVideoController() != null)
        this.zzcjf.zza(this.zzcys.getVideoController());
      return this.zzcjf;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzc("Exception occurred while getting video controller", localRemoteException);
    }
  }

  public final void performClick(Bundle paramBundle)
  {
    try
    {
      this.zzcys.performClick(paramBundle);
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
      boolean bool = this.zzcys.recordImpression(paramBundle);
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
      this.zzcys.reportTouchEvent(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaey
 * JD-Core Version:    0.6.2
 */