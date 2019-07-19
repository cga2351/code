package com.mopub.nativeads;

import android.view.View;

public abstract interface ImpressionInterface
{
  public abstract int getImpressionMinPercentageViewed();

  public abstract int getImpressionMinTimeViewed();

  public abstract Integer getImpressionMinVisiblePx();

  public abstract boolean isImpressionRecorded();

  public abstract void recordImpression(View paramView);

  public abstract void setImpressionRecorded();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.ImpressionInterface
 * JD-Core Version:    0.6.2
 */