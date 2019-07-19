package com.yandex.mobile.ads.rewarded;

import android.content.Context;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.impl.cw;
import com.yandex.mobile.ads.impl.fr;

public final class RewardedAd extends fr
{
  private final b a;

  public RewardedAd(Context paramContext)
  {
    super(paramContext);
    this.a = new b(paramContext, new a());
  }

  public final void destroy()
  {
    if (!cw.a(this.a))
      this.a.f();
  }

  public final String getBlockId()
  {
    return this.a.p();
  }

  public final boolean isLoaded()
  {
    return this.a.g();
  }

  public final void loadAd(AdRequest paramAdRequest)
  {
    this.a.a(paramAdRequest);
  }

  public final void setBlockId(String paramString)
  {
    this.a.a_(paramString);
  }

  public final void setRewardedAdEventListener(RewardedAdEventListener paramRewardedAdEventListener)
  {
    this.a.a(paramRewardedAdEventListener);
  }

  public final void setUserId(String paramString)
  {
    this.a.c(paramString);
  }

  public final void shouldOpenLinksInApp(boolean paramBoolean)
  {
    this.a.a_(paramBoolean);
  }

  public final void show()
  {
    if (this.a.g())
      this.a.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.rewarded.RewardedAd
 * JD-Core Version:    0.6.2
 */