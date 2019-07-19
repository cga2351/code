package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;

public abstract class CustomEventBanner
{
  private boolean a = true;

  protected abstract void a();

  protected abstract void a(Context paramContext, CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1);

  protected void b()
  {
  }

  boolean c()
  {
    return this.a;
  }

  public static abstract interface CustomEventBannerListener
  {
    public abstract void onBannerClicked();

    public abstract void onBannerCollapsed();

    public abstract void onBannerExpanded();

    public abstract void onBannerFailed(MoPubErrorCode paramMoPubErrorCode);

    public abstract void onBannerImpression();

    public abstract void onBannerLoaded(View paramView);

    public abstract void onLeaveApplication();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.CustomEventBanner
 * JD-Core Version:    0.6.2
 */