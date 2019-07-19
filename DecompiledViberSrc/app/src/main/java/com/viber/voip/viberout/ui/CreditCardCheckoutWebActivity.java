package com.viber.voip.viberout.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.viber.voip.R.string;
import com.viber.voip.analytics.story.StoryConstants.y.a;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.ViberWebApiActivity.b;
import com.viber.voip.market.WebTokenBasedWebActivity;
import com.viber.voip.util.da;
import com.viber.voip.util.dl;
import dagger.android.a;
import javax.inject.Inject;

public class CreditCardCheckoutWebActivity extends WebTokenBasedWebActivity
{

  @Inject
  e a;

  private String a(String paramString1, String paramString2)
  {
    return Uri.parse(paramString1).buildUpon().appendQueryParameter("product_id", paramString2).build().toString();
  }

  public static void a(String paramString, boolean paramBoolean)
  {
    a(b(paramString, paramBoolean));
  }

  public static Intent b(String paramString, boolean paramBoolean)
  {
    Intent localIntent = a(CreditCardCheckoutWebActivity.class);
    localIntent.putExtra("product_id", paramString);
    localIntent.putExtra("show_vo_screen_on_complete", paramBoolean);
    return localIntent;
  }

  protected String a(String paramString)
  {
    String str = getIntent().getStringExtra("product_id");
    if (str != null)
      paramString = a(paramString, str);
    return dl.j(dl.b(paramString));
  }

  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (paramInt == 1)
    {
      this.a.c();
      String str = StoryConstants.y.a.a(paramString, paramBoolean);
      if (!da.a(str))
        this.a.d(str);
    }
    super.a(paramInt, paramBoolean, paramString);
  }

  protected String d()
  {
    return getString(R.string.credit_card_checkout_title);
  }

  protected ViberWebApiActivity.b j()
  {
    return ViberWebApiActivity.b.e;
  }

  protected String l()
  {
    return ap.c().W + "credit-card";
  }

  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
  }

  protected boolean v()
  {
    return getIntent().getBooleanExtra("show_vo_screen_on_complete", false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.CreditCardCheckoutWebActivity
 * JD-Core Version:    0.6.2
 */