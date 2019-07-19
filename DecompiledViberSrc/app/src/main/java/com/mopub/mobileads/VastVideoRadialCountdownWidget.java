package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

public class VastVideoRadialCountdownWidget extends ImageView
{
  private RadialCountdownDrawable a;
  private int b;

  public VastVideoRadialCountdownWidget(Context paramContext)
  {
    super(paramContext);
    setId((int)Utils.generateUniqueId());
    int i = Dips.dipsToIntPixels(45.0F, paramContext);
    int j = Dips.dipsToIntPixels(16.0F, paramContext);
    int k = Dips.dipsToIntPixels(16.0F, paramContext);
    int m = Dips.dipsToIntPixels(5.0F, paramContext);
    this.a = new RadialCountdownDrawable(paramContext);
    setImageDrawable(this.a);
    setPadding(m, m, m, m);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.setMargins(0, j, k, 0);
    localLayoutParams.addRule(11);
    setLayoutParams(localLayoutParams);
  }

  public void calibrateAndMakeVisible(int paramInt)
  {
    this.a.setInitialCountdown(paramInt);
    setVisibility(0);
  }

  @Deprecated
  @VisibleForTesting
  public RadialCountdownDrawable getImageViewDrawable()
  {
    return this.a;
  }

  @Deprecated
  @VisibleForTesting
  public void setImageViewDrawable(RadialCountdownDrawable paramRadialCountdownDrawable)
  {
    this.a = paramRadialCountdownDrawable;
  }

  public void updateCountdownProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.b)
    {
      if (paramInt1 - paramInt2 < 0)
        setVisibility(8);
    }
    else
      return;
    this.a.updateCountdownProgress(paramInt2);
    this.b = paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoRadialCountdownWidget
 * JD-Core Version:    0.6.2
 */