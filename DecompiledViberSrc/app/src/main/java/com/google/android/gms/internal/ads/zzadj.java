package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzare
public final class zzadj
  implements CustomRenderedAd
{
  private final zzadk zzcxx;

  public zzadj(zzadk paramzzadk)
  {
    this.zzcxx = paramzzadk;
  }

  public final String getBaseUrl()
  {
    try
    {
      String str = this.zzcxx.zzqz();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }

  public final String getContent()
  {
    try
    {
      String str = this.zzcxx.getContent();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
    return null;
  }

  public final void onAdRendered(View paramView)
  {
    try
    {
      zzadk localzzadk = this.zzcxx;
      if (paramView != null);
      for (IObjectWrapper localIObjectWrapper = ObjectWrapper.wrap(paramView); ; localIObjectWrapper = null)
      {
        localzzadk.zzo(localIObjectWrapper);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void recordClick()
  {
    try
    {
      this.zzcxx.recordClick();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }

  public final void recordImpression()
  {
    try
    {
      this.zzcxx.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zze("#007 Could not call remote method.", localRemoteException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadj
 * JD-Core Version:    0.6.2
 */