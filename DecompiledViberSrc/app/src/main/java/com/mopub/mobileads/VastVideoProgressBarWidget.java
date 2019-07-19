package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;

public class VastVideoProgressBarWidget extends ImageView
{
  private ProgressBarDrawable a;
  private final int b;

  public VastVideoProgressBarWidget(Context paramContext)
  {
    super(paramContext);
    setId((int)Utils.generateUniqueId());
    this.a = new ProgressBarDrawable(paramContext);
    setImageDrawable(this.a);
    this.b = Dips.dipsToIntPixels(4.0F, paramContext);
  }

  public void calibrateAndMakeVisible(int paramInt1, int paramInt2)
  {
    this.a.setDurationAndSkipOffset(paramInt1, paramInt2);
    setVisibility(0);
  }

  @Deprecated
  @VisibleForTesting
  ProgressBarDrawable getImageViewDrawable()
  {
    return this.a;
  }

  public void reset()
  {
    this.a.reset();
    this.a.setProgress(0);
  }

  public void setAnchorId(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, this.b);
    localLayoutParams.addRule(8, paramInt);
    setLayoutParams(localLayoutParams);
  }

  @Deprecated
  @VisibleForTesting
  void setImageViewDrawable(ProgressBarDrawable paramProgressBarDrawable)
  {
    this.a = paramProgressBarDrawable;
  }

  public void updateProgress(int paramInt)
  {
    this.a.setProgress(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoProgressBarWidget
 * JD-Core Version:    0.6.2
 */