package com.viber.voip.gdpr.ui.iabconsent;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import javax.inject.Inject;

public class g extends com.viber.voip.mvp.core.g<j>
{

  @Inject
  com.viber.voip.gdpr.a.a a;
  private int b = 1;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    ManageConsentPresenter localManageConsentPresenter = new ManageConsentPresenter(this.a);
    addMvpView(new j(localManageConsentPresenter, paramView, this, this.b), localManageConsentPresenter, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.b = localBundle.getInt("ConsentActivity.ScreenId", 1);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().setTitle(R.string.gdpr_consent_manage_ads_title);
    return paramLayoutInflater.inflate(R.layout.gdpr_iab_consent, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.g
 * JD-Core Version:    0.6.2
 */