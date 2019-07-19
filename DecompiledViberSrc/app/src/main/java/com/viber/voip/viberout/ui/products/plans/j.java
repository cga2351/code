package com.viber.voip.viberout.ui.products.plans;

import com.viber.voip.analytics.g;
import com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter;
import com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter;
import dagger.b;

public final class j
  implements b<i>
{
  public static void a(i parami, g paramg)
  {
    parami.c = paramg;
  }

  public static void a(i parami, ViberOutAccountPresenter paramViberOutAccountPresenter)
  {
    parami.b = paramViberOutAccountPresenter;
  }

  public static void a(i parami, ViberOutCouponPresenter paramViberOutCouponPresenter)
  {
    parami.d = paramViberOutCouponPresenter;
  }

  public static void a(i parami, Object paramObject)
  {
    parami.a = ((ViberOutPlansPresenter)paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.j
 * JD-Core Version:    0.6.2
 */