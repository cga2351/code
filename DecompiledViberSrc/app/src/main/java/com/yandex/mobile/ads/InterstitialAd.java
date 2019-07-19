package com.yandex.mobile.ads;

import android.content.Context;
import com.yandex.mobile.ads.impl.cw;
import com.yandex.mobile.ads.impl.fr;
import com.yandex.mobile.ads.impl.ha;
import com.yandex.mobile.ads.impl.hb;

public final class InterstitialAd extends fr
{
  private final hb a;

  public InterstitialAd(Context paramContext)
  {
    super(paramContext);
    this.a = new hb(paramContext, new ha());
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

  public final InterstitialEventListener getInterstitialEventListener()
  {
    return this.a.B();
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

  public final void setInterstitialEventListener(InterstitialEventListener paramInterstitialEventListener)
  {
    this.a.a(paramInterstitialEventListener);
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
 * Qualified Name:     com.yandex.mobile.ads.InterstitialAd
 * JD-Core Version:    0.6.2
 */