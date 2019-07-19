package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzare;

@zzare
public final class NativeExpressAdView extends BaseAdView
{
  public NativeExpressAdView(Context paramContext)
  {
    super(paramContext, 1);
  }

  public NativeExpressAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 1);
  }

  public NativeExpressAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 1);
  }

  public final VideoController getVideoController()
  {
    return this.zzaaq.getVideoController();
  }

  public final VideoOptions getVideoOptions()
  {
    return this.zzaaq.getVideoOptions();
  }

  public final void setVideoOptions(VideoOptions paramVideoOptions)
  {
    this.zzaaq.setVideoOptions(paramVideoOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.NativeExpressAdView
 * JD-Core Version:    0.6.2
 */