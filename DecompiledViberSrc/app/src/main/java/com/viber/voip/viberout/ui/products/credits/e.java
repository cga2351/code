package com.viber.voip.viberout.ui.products.credits;

import com.viber.voip.analytics.g;
import com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter;
import com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter;
import dagger.b;

public final class e
  implements b<d>
{
  public static void a(d paramd, g paramg)
  {
    paramd.c = paramg;
  }

  public static void a(d paramd, ViberOutAccountPresenter paramViberOutAccountPresenter)
  {
    paramd.b = paramViberOutAccountPresenter;
  }

  public static void a(d paramd, ViberOutCouponPresenter paramViberOutCouponPresenter)
  {
    paramd.d = paramViberOutCouponPresenter;
  }

  public static void a(d paramd, Object paramObject)
  {
    paramd.a = ((ViberOutCreditsPresenter)paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.e
 * JD-Core Version:    0.6.2
 */