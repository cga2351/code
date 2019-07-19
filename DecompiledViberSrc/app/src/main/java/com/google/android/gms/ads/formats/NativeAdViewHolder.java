package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzyr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder
{
  public static WeakHashMap<View, NativeAdViewHolder> zzbql = new WeakHashMap();
  private zzaeq zzbqk;
  private WeakReference<View> zzbqm;

  public NativeAdViewHolder(View paramView, Map<String, View> paramMap1, Map<String, View> paramMap2)
  {
    Preconditions.checkNotNull(paramView, "ContainerView must not be null");
    if (((paramView instanceof NativeAdView)) || ((paramView instanceof UnifiedNativeAdView)))
    {
      zzbae.zzen("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
      return;
    }
    if (zzbql.get(paramView) != null)
    {
      zzbae.zzen("The provided containerView is already in use with another NativeAdViewHolder.");
      return;
    }
    zzbql.put(paramView, this);
    this.zzbqm = new WeakReference(paramView);
    HashMap localHashMap1 = zzb(paramMap1);
    HashMap localHashMap2 = zzb(paramMap2);
    this.zzbqk = zzyr.zzpb().zza(paramView, localHashMap1, localHashMap2);
  }

  private static HashMap<String, View> zzb(Map<String, View> paramMap)
  {
    if (paramMap == null)
      return new HashMap();
    return new HashMap(paramMap);
  }

  private final void zze(IObjectWrapper paramIObjectWrapper)
  {
    View localView;
    if (this.zzbqm != null)
    {
      localView = (View)this.zzbqm.get();
      if (localView != null)
        break label33;
      zzbae.zzep("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
    }
    label33: 
    do
    {
      return;
      localView = null;
      break;
      if (!zzbql.containsKey(localView))
        zzbql.put(localView, this);
    }
    while (this.zzbqk == null);
    try
    {
      this.zzbqk.zze(paramIObjectWrapper);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setNativeAd on delegate", localRemoteException);
    }
  }

  public final void setClickConfirmingView(View paramView)
  {
    try
    {
      this.zzbqk.zzi(ObjectWrapper.wrap(paramView));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setClickConfirmingView on delegate", localRemoteException);
    }
  }

  public final void setNativeAd(NativeAd paramNativeAd)
  {
    zze((IObjectWrapper)paramNativeAd.zzkq());
  }

  public final void setNativeAd(UnifiedNativeAd paramUnifiedNativeAd)
  {
    zze((IObjectWrapper)paramUnifiedNativeAd.zzkq());
  }

  public final void unregisterNativeAd()
  {
    if (this.zzbqk != null);
    try
    {
      this.zzbqk.unregisterNativeAd();
      if (this.zzbqm != null)
      {
        localView = (View)this.zzbqm.get();
        if (localView != null)
          zzbql.remove(localView);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
      {
        zzbae.zzc("Unable to call unregisterNativeAd on delegate", localRemoteException);
        continue;
        View localView = null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdViewHolder
 * JD-Core Version:    0.6.2
 */