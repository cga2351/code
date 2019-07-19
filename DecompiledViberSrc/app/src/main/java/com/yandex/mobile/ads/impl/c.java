package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdSize;
import com.yandex.mobile.ads.VideoController;

public abstract class c extends RelativeLayout
{
  private final a a = a(paramContext);
  private final d b;
  private AdSize c;

  public c(Context paramContext)
  {
    this(paramContext, null);
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a locala = this.a;
    if (isInEditMode());
    for (Object localObject = new e.b(); ; localObject = new e.a(locala))
    {
      this.b = ((d)localObject);
      this.b.a(paramContext, this);
      return;
    }
  }

  private void a(int paramInt)
  {
    if (!cw.a(this.a))
      this.b.a(paramInt);
  }

  protected abstract a a(Context paramContext);

  public void destroy()
  {
    if (!cw.a(this.a))
      this.a.f();
  }

  public AdEventListener getAdEventListener()
  {
    return this.a.q();
  }

  public AdSize getAdSize()
  {
    return this.c;
  }

  public String getBlockId()
  {
    return this.a.p();
  }

  public VideoController getVideoController()
  {
    return this.a.g();
  }

  public void loadAd(AdRequest paramAdRequest)
  {
    this.a.a(paramAdRequest);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    new StringBuilder("onAttachedToWindow(), clazz = ").append(getClass());
    this.b.a(getContext());
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!cw.a(this.a))
      if (!this.a.d())
        break label43;
    label43: for (int i = 0; ; i = 8)
    {
      setVisibility(i);
      new Object[1][0] = paramConfiguration.toString();
      return;
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    new StringBuilder("onDetachedFromWindow(), clazz = ").append(getClass());
    this.b.b(getContext());
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    new StringBuilder("onVisibilityChanged(), changedView = ").append(paramView).append(", viewVisibility = ").append(paramInt);
    if (this == paramView)
      a(paramInt);
  }

  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    new StringBuilder("onWindowVisibilityChanged(), windowVisibility = ").append(paramInt).append(", this.getVisibility = ").append(getVisibility());
    if ((paramInt == 0) && (getVisibility() == 0));
    for (int i = 0; ; i = 8)
    {
      a(i);
      return;
    }
  }

  public void pause()
  {
  }

  public void resume()
  {
  }

  public void setAdEventListener(AdEventListener paramAdEventListener)
  {
    this.a.a(paramAdEventListener);
  }

  public void setAdSize(AdSize paramAdSize)
  {
    this.c = paramAdSize;
    this.a.b(com.yandex.mobile.ads.a.a(paramAdSize));
  }

  public void setAutoRefreshEnabled(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public void setBlockId(String paramString)
  {
    this.a.a_(paramString);
  }

  public void shouldOpenLinksInApp(boolean paramBoolean)
  {
    this.a.a_(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.c
 * JD-Core Version:    0.6.2
 */