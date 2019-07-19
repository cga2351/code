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

@Deprecated
public class NativeAdView extends FrameLayout
{
  private final FrameLayout zzbqi = zzd(paramContext);
  private final zzael zzbqj = zzks();

  public NativeAdView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  @TargetApi(21)
  public NativeAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
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
    Preconditions.checkNotNull(this.zzbqi, "createDelegate must be called after mOverlayFrame has been created");
    if (isInEditMode())
      return null;
    return zzyr.zzpb().zza(this.zzbqi.getContext(), this, this.zzbqi);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(this.zzbqi);
  }

  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (this.zzbqi != paramView)
      super.bringChildToFront(this.zzbqi);
  }

  public void destroy()
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

  public AdChoicesView getAdChoicesView()
  {
    View localView = zzbj("1098");
    if ((localView instanceof AdChoicesView))
      return (AdChoicesView)localView;
    return null;
  }

  public void onVisibilityChanged(View paramView, int paramInt)
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

  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(this.zzbqi);
  }

  public void removeView(View paramView)
  {
    if (this.zzbqi == paramView)
      return;
    super.removeView(paramView);
  }

  public void setAdChoicesView(AdChoicesView paramAdChoicesView)
  {
    zza("1098", paramAdChoicesView);
  }

  public void setNativeAd(NativeAd paramNativeAd)
  {
    try
    {
      this.zzbqj.zze((IObjectWrapper)paramNativeAd.zzkq());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzbae.zzc("Unable to call setNativeAd on delegate", localRemoteException);
    }
  }

  protected final void zza(String paramString, View paramView)
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

  protected final View zzbj(String paramString)
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAdView
 * JD-Core Version:    0.6.2
 */