package com.yandex.mobile.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.yandex.mobile.ads.impl.a;
import com.yandex.mobile.ads.impl.c;

public final class AdView extends c
{
  public AdView(Context paramContext)
  {
    super(paramContext);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public AdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected final a a(Context paramContext)
  {
    return new a(paramContext, this);
  }

  public final void destroy()
  {
    super.destroy();
  }

  public final AdEventListener getAdEventListener()
  {
    return super.getAdEventListener();
  }

  public final AdSize getAdSize()
  {
    return super.getAdSize();
  }

  public final String getBlockId()
  {
    return super.getBlockId();
  }

  public final VideoController getVideoController()
  {
    return super.getVideoController();
  }

  public final void loadAd(AdRequest paramAdRequest)
  {
    super.loadAd(paramAdRequest);
  }

  public final void pause()
  {
    super.pause();
  }

  public final void resume()
  {
    super.resume();
  }

  public final void setAdEventListener(AdEventListener paramAdEventListener)
  {
    super.setAdEventListener(paramAdEventListener);
  }

  public final void setAdSize(AdSize paramAdSize)
  {
    super.setAdSize(paramAdSize);
  }

  public final void setAutoRefreshEnabled(boolean paramBoolean)
  {
    super.setAutoRefreshEnabled(paramBoolean);
  }

  public final void setBlockId(String paramString)
  {
    super.setBlockId(paramString);
  }

  public final void shouldOpenLinksInApp(boolean paramBoolean)
  {
    super.shouldOpenLinksInApp(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.AdView
 * JD-Core Version:    0.6.2
 */