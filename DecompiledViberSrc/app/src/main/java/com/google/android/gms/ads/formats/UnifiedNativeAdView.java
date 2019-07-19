package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzyr;

public final class UnifiedNativeAdView extends FrameLayout
{
  private final FrameLayout zzbqi = zzd(paramContext);
  private final zzael zzbqj = zzks();

  public UnifiedNativeAdView(Context paramContext)
  {
    super(paramContext);
  }

  public UnifiedNativeAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public UnifiedNativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public UnifiedNativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  private final void zza(String paramString, View paramView)
  {
    try
    {
      this.zzbqj.zzc(paramString, ObjectWrapper.wrap(paramView));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setAssetView on delegate", localRemoteException);
    }
  }

  private final View zzbj(String paramString)
  {
    try
    {
      IObjectWrapper localIObjectWrapper = this.zzbqj.zzcf(paramString);
      if (localIObjectWrapper != null)
      {
        View localView = (View)ObjectWrapper.unwrap(localIObjectWrapper);
        return localView;
      }
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call getAssetView on delegate", localRemoteException);
    }
    return null;
  }

  private final FrameLayout zzd(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(localFrameLayout);
    return localFrameLayout;
  }

  private final zzael zzks()
  {
    Preconditions.checkNotNull(this.zzbqi, "createDelegate must be called after overlayFrame has been created");
    if (isInEditMode())
      return null;
    return zzyr.zzpb().zza(this.zzbqi.getContext(), this, this.zzbqi);
  }

  public final void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(this.zzbqi);
  }

  public final void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (this.zzbqi != paramView)
      super.bringChildToFront(this.zzbqi);
  }

  public final void destroy()
  {
    try
    {
      this.zzbqj.destroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to destroy native ad view", localRemoteException);
    }
  }

  public final AdChoicesView getAdChoicesView()
  {
    View localView = zzbj("3011");
    if ((localView instanceof AdChoicesView))
      return (AdChoicesView)localView;
    return null;
  }

  public final View getAdvertiserView()
  {
    return zzbj("3005");
  }

  public final View getBodyView()
  {
    return zzbj("3004");
  }

  public final View getCallToActionView()
  {
    return zzbj("3002");
  }

  public final View getHeadlineView()
  {
    return zzbj("3001");
  }

  public final View getIconView()
  {
    return zzbj("3003");
  }

  public final View getImageView()
  {
    return zzbj("3008");
  }

  public final MediaView getMediaView()
  {
    View localView = zzbj("3010");
    if ((localView instanceof MediaView))
      return (MediaView)localView;
    if (localView != null)
      zzbae.zzdp("View is not an instance of MediaView");
    return null;
  }

  public final View getPriceView()
  {
    return zzbj("3007");
  }

  public final View getStarRatingView()
  {
    return zzbj("3009");
  }

  public final View getStoreView()
  {
    return zzbj("3006");
  }

  public final void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.zzbqj != null);
    try
    {
      this.zzbqj.zzc(ObjectWrapper.wrap(paramView), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call onVisibilityChanged on delegate", localRemoteException);
    }
  }

  public final void removeAllViews()
  {
    super.removeAllViews();
    super.addView(this.zzbqi);
  }

  public final void removeView(View paramView)
  {
    if (this.zzbqi == paramView)
      return;
    super.removeView(paramView);
  }

  public final void setAdChoicesView(AdChoicesView paramAdChoicesView)
  {
    zza("3011", paramAdChoicesView);
  }

  public final void setAdvertiserView(View paramView)
  {
    zza("3005", paramView);
  }

  public final void setBodyView(View paramView)
  {
    zza("3004", paramView);
  }

  public final void setCallToActionView(View paramView)
  {
    zza("3002", paramView);
  }

  public final void setClickConfirmingView(View paramView)
  {
    try
    {
      this.zzbqj.zzi(ObjectWrapper.wrap(paramView));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setClickConfirmingView on delegate", localRemoteException);
    }
  }

  public final void setHeadlineView(View paramView)
  {
    zza("3001", paramView);
  }

  public final void setIconView(View paramView)
  {
    zza("3003", paramView);
  }

  public final void setImageView(View paramView)
  {
    zza("3008", paramView);
  }

  public final void setMediaView(MediaView paramMediaView)
  {
    zza("3010", paramMediaView);
  }

  public final void setNativeAd(UnifiedNativeAd paramUnifiedNativeAd)
  {
    try
    {
      this.zzbqj.zze((IObjectWrapper)paramUnifiedNativeAd.zzkq());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setNativeAd on delegate", localRemoteException);
    }
  }

  public final void setPriceView(View paramView)
  {
    zza("3007", paramView);
  }

  public final void setStarRatingView(View paramView)
  {
    zza("3009", paramView);
  }

  public final void setStoreView(View paramView)
  {
    zza("3006", paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.UnifiedNativeAdView
 * JD-Core Version:    0.6.2
 */