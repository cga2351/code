package com.viber.voip.viberout.ui.products.countryplans;

import android.support.v4.app.Fragment;
import com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter;
import dagger.android.c;

public final class b
  implements dagger.b<ViberOutCountryPlansActivity>
{
  public static void a(ViberOutCountryPlansActivity paramViberOutCountryPlansActivity, ViberOutCountrySearchPresenter paramViberOutCountrySearchPresenter)
  {
    paramViberOutCountryPlansActivity.b = paramViberOutCountrySearchPresenter;
  }

  public static void a(ViberOutCountryPlansActivity paramViberOutCountryPlansActivity, c<Fragment> paramc)
  {
    paramViberOutCountryPlansActivity.a = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.b
 * JD-Core Version:    0.6.2
 */