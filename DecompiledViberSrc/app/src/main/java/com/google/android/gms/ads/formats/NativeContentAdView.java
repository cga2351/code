package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.ads.zzbae;

@Deprecated
public final class NativeContentAdView extends NativeAdView
{
  public NativeContentAdView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeContentAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeContentAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public NativeContentAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public final View getAdvertiserView()
  {
    return super.zzbj("1004");
  }

  public final View getBodyView()
  {
    return super.zzbj("1002");
  }

  public final View getCallToActionView()
  {
    return super.zzbj("1003");
  }

  public final View getHeadlineView()
  {
    return super.zzbj("1001");
  }

  public final View getImageView()
  {
    return super.zzbj("1005");
  }

  public final View getLogoView()
  {
    return super.zzbj("1006");
  }

  public final MediaView getMediaView()
  {
    View localView = super.zzbj("1009");
    if ((localView instanceof MediaView))
      return (MediaView)localView;
    if (localView != null)
      zzbae.zzdp("View is not an instance of MediaView");
    return null;
  }

  public final void setAdvertiserView(View paramView)
  {
    super.zza("1004", paramView);
  }

  public final void setBodyView(View paramView)
  {
    super.zza("1002", paramView);
  }

  public final void setCallToActionView(View paramView)
  {
    super.zza("1003", paramView);
  }

  public final void setHeadlineView(View paramView)
  {
    super.zza("1001", paramView);
  }

  public final void setImageView(View paramView)
  {
    super.zza("1005", paramView);
  }

  public final void setLogoView(View paramView)
  {
    super.zza("1006", paramView);
  }

  public final void setMediaView(MediaView paramMediaView)
  {
    super.zza("1009", paramMediaView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeContentAdView
 * JD-Core Version:    0.6.2
 */