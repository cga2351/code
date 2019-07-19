package com.viber.voip.viberout.ui.products;

import android.support.v4.app.Fragment;
import com.viber.voip.analytics.g;
import com.viber.voip.viberout.ui.products.search.country.ViberOutCountrySearchPresenter;
import dagger.android.c;

public final class f
  implements dagger.b<ViberOutProductsActivity>
{
  public static void a(ViberOutProductsActivity paramViberOutProductsActivity, g paramg)
  {
    paramViberOutProductsActivity.d = paramg;
  }

  public static void a(ViberOutProductsActivity paramViberOutProductsActivity, com.viber.voip.app.b paramb)
  {
    paramViberOutProductsActivity.e = paramb;
  }

  public static void a(ViberOutProductsActivity paramViberOutProductsActivity, ViberOutProductsPresenter paramViberOutProductsPresenter)
  {
    paramViberOutProductsActivity.b = paramViberOutProductsPresenter;
  }

  public static void a(ViberOutProductsActivity paramViberOutProductsActivity, ViberOutCountrySearchPresenter paramViberOutCountrySearchPresenter)
  {
    paramViberOutProductsActivity.c = paramViberOutCountrySearchPresenter;
  }

  public static void a(ViberOutProductsActivity paramViberOutProductsActivity, c<Fragment> paramc)
  {
    paramViberOutProductsActivity.a = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.f
 * JD-Core Version:    0.6.2
 */