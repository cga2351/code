package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils.ForceOrientation;
import com.mopub.common.util.Dips;
import com.mopub.mobileads.resource.DrawableConstants.GradientStrip;

public class VastVideoGradientStripWidget extends ImageView
{
  DeviceUtils.ForceOrientation a;
  private int b;
  private boolean c;
  private boolean d;

  public VastVideoGradientStripWidget(Context paramContext, GradientDrawable.Orientation paramOrientation, DeviceUtils.ForceOrientation paramForceOrientation, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.a = paramForceOrientation;
    this.b = paramInt1;
    this.c = paramBoolean;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = DrawableConstants.GradientStrip.START_COLOR;
    arrayOfInt[1] = DrawableConstants.GradientStrip.END_COLOR;
    setImageDrawable(new GradientDrawable(paramOrientation, arrayOfInt));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(72.0F, paramContext));
    localLayoutParams.addRule(paramInt2, paramInt3);
    setLayoutParams(localLayoutParams);
    b();
  }

  private void b()
  {
    if (this.d)
    {
      if (this.c)
      {
        setVisibility(this.b);
        return;
      }
      setVisibility(8);
      return;
    }
    if (this.a == DeviceUtils.ForceOrientation.FORCE_PORTRAIT)
    {
      setVisibility(4);
      return;
    }
    if (this.a == DeviceUtils.ForceOrientation.FORCE_LANDSCAPE)
    {
      setVisibility(0);
      return;
    }
    switch (getResources().getConfiguration().orientation)
    {
    default:
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unrecognized screen orientation: do not show gradient strip widget" });
      setVisibility(4);
      return;
    case 2:
      setVisibility(0);
      return;
    case 1:
      setVisibility(4);
      return;
    case 0:
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Screen orientation undefined: do not show gradient strip widget" });
      setVisibility(4);
      return;
    case 3:
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget" });
    setVisibility(4);
  }

  void a()
  {
    this.d = true;
    b();
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoGradientStripWidget
 * JD-Core Version:    0.6.2
 */