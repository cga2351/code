package com.viber.voip.viberout.ui;

import com.viber.voip.R.string;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.market.WebTokenBasedWebActivity;
import com.viber.voip.util.dl;

public class ViberOutAccountActivity extends WebTokenBasedWebActivity
{
  public static void x()
  {
    a(a(ViberOutAccountActivity.class));
  }

  protected String a(String paramString)
  {
    return dl.b(paramString);
  }

  protected String d()
  {
    return getString(R.string.viberout_web_title_my_account);
  }

  protected String l()
  {
    return ap.c().Y;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.ViberOutAccountActivity
 * JD-Core Version:    0.6.2
 */