package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzagp extends zzafu
{
  private final OnPublisherAdViewLoadedListener zzczi;

  public zzagp(OnPublisherAdViewLoadedListener paramOnPublisherAdViewLoadedListener)
  {
    this.zzczi = paramOnPublisherAdViewLoadedListener;
  }

  public final void zza(zzzi paramzzzi, IObjectWrapper paramIObjectWrapper)
  {
    if ((paramzzzi == null) || (paramIObjectWrapper == null))
      return;
    PublisherAdView localPublisherAdView = new PublisherAdView((Context)ObjectWrapper.unwrap(paramIObjectWrapper));
    try
    {
      if ((paramzzzi.zzpp() instanceof zzxt))
      {
        zzxt localzzxt = (zzxt)paramzzzi.zzpp();
        if (localzzxt == null)
          break label124;
        localAdListener = localzzxt.getAdListener();
        localPublisherAdView.setAdListener(localAdListener);
      }
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        AdListener localAdListener;
        label65: zzyd localzzyd;
        if ((paramzzzi.zzpo() instanceof zzyd))
        {
          localzzyd = (zzyd)paramzzzi.zzpo();
          if (localzzyd == null)
            break label142;
        }
        label142: for (AppEventListener localAppEventListener = localzzyd.getAppEventListener(); ; localAppEventListener = null)
        {
          localPublisherAdView.setAppEventListener(localAppEventListener);
          zzazu.zzyr.post(new zzagq(this, localPublisherAdView, paramzzzi));
          return;
          label124: localAdListener = null;
          break;
          localRemoteException1 = localRemoteException1;
          zzbae.zzc("", localRemoteException1);
          break label65;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        while (true)
          zzbae.zzc("", localRemoteException2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagp
 * JD-Core Version:    0.6.2
 */