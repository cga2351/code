package com.google.android.gms.ads.formats;

import android.os.Bundle;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

public abstract class UnifiedNativeAd
{
  public abstract void cancelUnconfirmedClick();

  public abstract void destroy();

  public abstract void enableCustomClickGesture();

  public abstract NativeAd.AdChoicesInfo getAdChoicesInfo();

  public abstract String getAdvertiser();

  public abstract String getBody();

  public abstract String getCallToAction();

  public abstract Bundle getExtras();

  public abstract String getHeadline();

  public abstract NativeAd.Image getIcon();

  public abstract List<NativeAd.Image> getImages();

  public abstract String getMediationAdapterClassName();

  public abstract List<MuteThisAdReason> getMuteThisAdReasons();

  public abstract String getPrice();

  public abstract Double getStarRating();

  public abstract String getStore();

  public abstract VideoController getVideoController();

  public abstract boolean isCustomMuteThisAdEnabled();

  public abstract void muteThisAd(MuteThisAdReason paramMuteThisAdReason);

  @KeepForSdk
  public abstract void performClick(Bundle paramBundle);

  public abstract void recordCustomClickGesture();

  @KeepForSdk
  public abstract boolean recordImpression(Bundle paramBundle);

  @KeepForSdk
  public abstract void reportTouchEvent(Bundle paramBundle);

  public abstract void setMuteThisAdListener(MuteThisAdListener paramMuteThisAdListener);

  public abstract void setUnconfirmedClickListener(UnconfirmedClickListener paramUnconfirmedClickListener);

  protected abstract Object zzkq();

  public abstract Object zzkv();

  public static abstract interface OnUnifiedNativeAdLoadedListener
  {
    public abstract void onUnifiedNativeAdLoaded(UnifiedNativeAd paramUnifiedNativeAd);
  }

  public static abstract interface UnconfirmedClickListener
  {
    public abstract void onUnconfirmedClickCancelled();

    public abstract void onUnconfirmedClickReceived(String paramString);
  }

  public static class zza
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.UnifiedNativeAd
 * JD-Core Version:    0.6.2
 */