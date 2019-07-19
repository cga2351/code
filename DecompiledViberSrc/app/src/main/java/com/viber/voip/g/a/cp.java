package com.viber.voip.g.a;

import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.news.ViberNewsProviderSpec;
import com.viber.voip.news.q;
import com.viber.voip.ui.f.c;

public abstract class cp
{
  static c a(ViberApplication paramViberApplication, q paramq)
  {
    c localc = new c(paramViberApplication);
    if (paramq.a().canBeDisplayedAsHomeTab());
    for (int i = R.menu.bottom_navigation_menu_home_with_news; ; i = R.menu.bottom_navigation_menu_home)
    {
      localc.a(i);
      return localc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cp
 * JD-Core Version:    0.6.2
 */