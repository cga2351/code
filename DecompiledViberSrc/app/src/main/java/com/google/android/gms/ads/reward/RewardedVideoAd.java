package com.google.android.gms.ads.reward;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

public abstract interface RewardedVideoAd
{
  @Deprecated
  public abstract void destroy();

  public abstract void destroy(Context paramContext);

  public abstract Bundle getAdMetadata();

  public abstract String getCustomData();

  public abstract String getMediationAdapterClassName();

  public abstract RewardedVideoAdListener getRewardedVideoAdListener();

  public abstract String getUserId();

  public abstract boolean isLoaded();

  public abstract void loadAd(String paramString, AdRequest paramAdRequest);

  public abstract void loadAd(String paramString, PublisherAdRequest paramPublisherAdRequest);

  @Deprecated
  public abstract void pause();

  public abstract void pause(Context paramContext);

  @Deprecated
  public abstract void resume();

  public abstract void resume(Context paramContext);

  public abstract void setAdMetadataListener(AdMetadataListener paramAdMetadataListener);

  public abstract void setCustomData(String paramString);

  public abstract void setImmersiveMode(boolean paramBoolean);

  public abstract void setRewardedVideoAdListener(RewardedVideoAdListener paramRewardedVideoAdListener);

  public abstract void setUserId(String paramString);

  public abstract void show();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.reward.RewardedVideoAd
 * JD-Core Version:    0.6.2
 */