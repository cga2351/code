package com.viber.voip.viberout.ui.products.countryplans;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.da;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import dagger.android.support.a;
import javax.inject.Inject;

public class c extends com.viber.voip.mvp.core.g<d>
{

  @Inject
  com.viber.voip.analytics.g a;

  @Inject
  ViberOutCountryPlansInfoPresenter b;
  private com.viber.voip.viberout.ui.products.e c;

  public static c a(CountryModel paramCountryModel, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("arg_dest_country_model", paramCountryModel);
    localBundle.putString("arg_selected_tab", paramString);
    c localc = new c();
    localc.setArguments(localBundle);
    return localc;
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    this.c = new com.viber.voip.viberout.ui.products.e(getContext(), this.a);
    g localg = new g(this.b, paramView, getActivity(), new e(getLayoutInflater(), this.c));
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      if (localBundle.containsKey("arg_dest_country_model"))
        this.b.a((CountryModel)localBundle.getParcelable("arg_dest_country_model"));
      String str = localBundle.getString("arg_selected_tab");
      if (!da.a(str))
        this.b.a(str);
    }
    addMvpView(localg, this.b, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Context paramContext)
  {
    a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_country_plans, paramViewGroup, false);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.c
 * JD-Core Version:    0.6.2
 */