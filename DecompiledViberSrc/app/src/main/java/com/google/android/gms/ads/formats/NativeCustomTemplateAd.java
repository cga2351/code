package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import java.util.List;

public abstract interface NativeCustomTemplateAd
{
  public static final String ASSET_NAME_VIDEO = "_videoMediaView";

  public abstract void destroy();

  public abstract List<String> getAvailableAssetNames();

  public abstract String getCustomTemplateId();

  public abstract NativeAd.Image getImage(String paramString);

  public abstract CharSequence getText(String paramString);

  public abstract VideoController getVideoController();

  public abstract MediaView getVideoMediaView();

  public abstract void performClick(String paramString);

  public abstract void recordImpression();

  public static abstract interface OnCustomClickListener
  {
    public abstract void onCustomClick(NativeCustomTemplateAd paramNativeCustomTemplateAd, String paramString);
  }

  public static abstract interface OnCustomTemplateAdLoadedListener
  {
    public abstract void onCustomTemplateAdLoaded(NativeCustomTemplateAd paramNativeCustomTemplateAd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.NativeCustomTemplateAd
 * JD-Core Version:    0.6.2
 */