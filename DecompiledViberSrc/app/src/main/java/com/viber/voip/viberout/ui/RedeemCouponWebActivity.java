package com.viber.voip.viberout.ui;

import android.content.Intent;
import android.os.Bundle;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.l.h;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.ViberWebApiActivity.b;
import com.viber.voip.market.WebTokenBasedWebActivity;
import com.viber.voip.n.a;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;

public class RedeemCouponWebActivity extends WebTokenBasedWebActivity
{
  private String a;

  public static void d(String paramString)
  {
    a(h(paramString));
  }

  public static Intent h(String paramString)
  {
    Intent localIntent = a(RedeemCouponWebActivity.class);
    if (!da.a(paramString))
      localIntent.putExtra("code", paramString);
    return localIntent;
  }

  private void x()
  {
    g.a().a(h.a());
  }

  protected String a(String paramString)
  {
    return dl.h(dl.l(dl.j(dl.b(dl.e(paramString, this.a)))));
  }

  protected String d()
  {
    return getString(R.string.redeem_coupon_title);
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.i;
  }

  protected String l()
  {
    return ap.c().V + "coupons";
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.a = getIntent().getStringExtra("code");
    super.onCreate(paramBundle);
    ViberApplication.getInstance();
    if (!ViberApplication.isTablet(getApplicationContext()))
      a.d(this);
    if (paramBundle == null)
      x();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.RedeemCouponWebActivity
 * JD-Core Version:    0.6.2
 */