package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzare
public final class zzafc extends NativeContentAd
{
  private final VideoController zzcjf = new VideoController();
  private final List<NativeAd.Image> zzcyt = new ArrayList();
  private final NativeAd.AdChoicesInfo zzcyv;
  private final zzaez zzcyw;
  private final zzaek zzcyx;

  public zzafc(zzaez paramzzaez)
  {
    this.zzcyw = paramzzaez;
    while (true)
    {
      IBinder localIBinder;
      Object localObject3;
      try
      {
        List localList = this.zzcyw.getImages();
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
        zzaeh localzzaeh = this.zzcyw.zzrl();
        if (localzzaeh != null)
        {
          localzzaek = new zzaek(localzzaeh);
          this.zzcyx = localzzaek;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        try
        {
          while (true)
          {
            zzadz localzzadz = this.zzcyw.zzrj();
            localObject1 = null;
            if (localzzadz != null)
            {
              zzaec localzzaec = new zzaec(this.zzcyw.zzrj());
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
      IObjectWrapper localIObjectWrapper = this.zzcyw.zzrh();
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
      this.zzcyw.destroy();
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

  public final CharSequence getAdvertiser()
  {
    try
    {
      String str = this.zzcyw.getAdvertiser();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final CharSequence getBody()
  {
    try
    {
      String str = this.zzcyw.getBody();
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
      String str = this.zzcyw.getCallToAction();
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
      Bundle localBundle = this.zzcyw.getExtras();
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
      String str = this.zzcyw.getHeadline();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
    return null;
  }

  public final List<NativeAd.Image> getImages()
  {
    return this.zzcyt;
  }

  public final NativeAd.Image getLogo()
  {
    return this.zzcyx;
  }

  public final CharSequence getMediationAdapterClassName()
  {
    try
    {
      String str = this.zzcyw.getMediationAdapterClassName();
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
      if (this.zzcyw.getVideoController() != null)
        this.zzcjf.zza(this.zzcyw.getVideoController());
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
      this.zzcyw.performClick(paramBundle);
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
      boolean bool = this.zzcyw.recordImpression(paramBundle);
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
      this.zzcyw.reportTouchEvent(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzafc
 * JD-Core Version:    0.6.2
 */