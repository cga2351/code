package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class VastVideoCtaButtonWidget extends ImageView
{
  private CtaButtonDrawable a;
  private final RelativeLayout.LayoutParams b;
  private final RelativeLayout.LayoutParams c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;

  public VastVideoCtaButtonWidget(Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = false;
    setId((int)Utils.generateUniqueId());
    int i = Dips.dipsToIntPixels(150.0F, paramContext);
    int j = Dips.dipsToIntPixels(38.0F, paramContext);
    int k = Dips.dipsToIntPixels(16.0F, paramContext);
    this.a = new CtaButtonDrawable(paramContext);
    setImageDrawable(this.a);
    this.b = new RelativeLayout.LayoutParams(i, j);
    this.b.setMargins(k, k, k, k);
    this.b.addRule(8, paramInt);
    this.b.addRule(7, paramInt);
    this.c = new RelativeLayout.LayoutParams(i, j);
    this.c.setMargins(k, k, k, k);
    this.c.addRule(12);
    this.c.addRule(11);
    c();
  }

  private void c()
  {
    if (!this.g)
    {
      setVisibility(8);
      return;
    }
    if (!this.d)
    {
      setVisibility(4);
      return;
    }
    if ((this.e) && (this.f) && (!this.h))
    {
      setVisibility(8);
      return;
    }
    switch (getResources().getConfiguration().orientation)
    {
    default:
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unrecognized screen orientation: CTA button widget defaulting to portrait layout" });
      setLayoutParams(this.c);
    case 2:
    case 1:
    case 0:
    case 3:
    }
    while (true)
    {
      setVisibility(0);
      return;
      setLayoutParams(this.b);
      continue;
      setLayoutParams(this.c);
      continue;
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Screen orientation undefined: CTA button widget defaulting to portrait layout" });
      setLayoutParams(this.c);
      continue;
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout" });
      setLayoutParams(this.c);
    }
  }

  void a()
  {
    this.d = true;
    c();
  }

  void a(String paramString)
  {
    this.a.setCtaText(paramString);
  }

  void b()
  {
    this.d = true;
    this.e = true;
    c();
  }

  @Deprecated
  @VisibleForTesting
  String getCtaText()
  {
    return this.a.getCtaText();
  }

  boolean getHasSocialActions()
  {
    return this.h;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    c();
  }

  void setHasSocialActions(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastVideoCtaButtonWidget
 * JD-Core Version:    0.6.2
 */