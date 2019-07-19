package com.viber.voip.viberout.ui;

import android.os.Bundle;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.ViberWebApiActivity.b;
import com.viber.voip.market.WebTokenBasedWebActivity;
import com.viber.voip.n.a;
import com.viber.voip.util.dl;

public class FreeOfferWebActivity extends WebTokenBasedWebActivity
{
  public static void x()
  {
    a(a(FreeOfferWebActivity.class));
  }

  protected String a(String paramString)
  {
    return dl.h(dl.l(dl.j(dl.b(paramString))));
  }

  protected String d()
  {
    return getString(R.string.free_offer_title);
  }

  public void g()
  {
    finish();
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.j;
  }

  protected String l()
  {
    return ap.c().V + "offers";
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ViberApplication.getInstance();
    if (!ViberApplication.isTablet(getApplicationContext()))
      a.d(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.FreeOfferWebActivity
 * JD-Core Version:    0.6.2
 */