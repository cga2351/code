package com.yandex.mobile.ads.mediation.rewarded;

import android.content.Context;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.as;
import com.yandex.mobile.ads.impl.v;
import com.yandex.mobile.ads.rewarded.b;
import java.lang.ref.WeakReference;

final class d
  implements MediatedRewardedAdapterListener
{
  private final WeakReference<b> a;
  private final as<MediatedRewardedAdapter, MediatedRewardedAdapterListener> b;

  d(b paramb, as<MediatedRewardedAdapter, MediatedRewardedAdapterListener> paramas)
  {
    this.a = new WeakReference(paramb);
    this.b = paramas;
  }

  public final void onRewarded(MediatedReward paramMediatedReward)
  {
    b localb = (b)this.a.get();
    if (localb != null)
    {
      Context localContext = localb.l();
      v localv = localb.w();
      this.b.a(localContext, localv);
      localb.B();
    }
  }

  public final void onRewardedAdClicked()
  {
    b localb = (b)this.a.get();
    if (localb != null)
    {
      Context localContext = localb.l();
      this.b.b(localContext);
    }
  }

  public final void onRewardedAdDismissed()
  {
    b localb = (b)this.a.get();
    if (localb != null)
      localb.y();
  }

  public final void onRewardedAdFailedToLoad(AdRequestError paramAdRequestError)
  {
    b localb = (b)this.a.get();
    if (localb != null)
    {
      Context localContext = localb.l();
      this.b.a(localContext, paramAdRequestError, this);
    }
  }

  public final void onRewardedAdLeftApplication()
  {
    b localb = (b)this.a.get();
    if (localb != null)
      localb.onAdLeftApplication();
  }

  public final void onRewardedAdLoaded()
  {
    b localb = (b)this.a.get();
    if (localb != null)
    {
      Context localContext = localb.l();
      this.b.e(localContext);
      localb.onAdLoaded();
    }
  }

  public final void onRewardedAdShown()
  {
    b localb = (b)this.a.get();
    if (localb != null)
    {
      Context localContext = localb.l();
      this.b.c(localContext);
      localb.x();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.mediation.rewarded.d
 * JD-Core Version:    0.6.2
 */