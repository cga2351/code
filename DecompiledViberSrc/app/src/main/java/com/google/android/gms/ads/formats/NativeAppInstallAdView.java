package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.internal.ads.zzbae;

@Deprecated
public final class NativeAppInstallAdView extends NativeAdView
{
  public NativeAppInstallAdView(Context paramContext)
  {
    super(paramContext);
  }

  public NativeAppInstallAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NativeAppInstallAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public NativeAppInstallAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public final View getBodyView()
  {
    return super.zzbj("2004");
  }

  public final View getCallToActionView()
  {
    return super.zzbj("2002");
  }

  public final View getHeadlineView()
  {
    return super.zzbj("2001");
  }

  public final View getIconView()
  {
    return super.zzbj("2003");
  }

  public final View getImageView()
  {
    return super.zzbj("2007");
  }

  public final MediaView getMediaView()
  {
    View localView = super.zzbj("2011");
    if ((localView instanceof MediaView))
      return (MediaView)localView;
    if (localView != null)
      zzbae.zzdp("View is not an instance of MediaView");
    return null;
  }

  public final View getPriceView()
  {
    return super.zzbj("2006");
  }

  public final View getStarRatingView()
  {
    return super.zzbj("2008");
  }

  public final View getStoreView()
  {
    return super.zzbj("2005");
  }

  public final void setBodyView(View paramView)
  {
    super.zza("2004", paramView);
  }

  public final void setCallToActionView(View paramView)
  {
    super.zza("2002", paramView);
  }

  public final void setHeadlineView(View paramView)
  {
    super.zza("2001", paramView);
  }

  public final void setIconView(View paramView)
  {
    super.zza("2003", paramView);
  }

  public final void setImageView(View paramView)
  {
    super.zza("2007", paramView);
  }

  public final void setMediaView(MediaView paramMediaView)
  {
    super.zza("2011", paramMediaView);
  }

  public final void setPriceView(View paramView)
  {
    super.zza("2006", paramView);
  }

  public final void setStarRatingView(View paramView)
  {
    super.zza("2008", paramView);
  }

  public final void setStoreView(View paramView)
  {
    super.zza("2005", paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeAppInstallAdView
 * JD-Core Version:    0.6.2
 */