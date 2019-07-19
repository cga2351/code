package com.viber.voip.gdpr.ui.iabconsent;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.g;
import javax.inject.Inject;

public class a extends g<c>
{

  @Inject
  com.viber.voip.gdpr.a.a a;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    AllConsentPresenter localAllConsentPresenter = new AllConsentPresenter(this.a, new f(getActivity()));
    addMvpView(new c(localAllConsentPresenter, paramView), localAllConsentPresenter, paramBundle);
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
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().setTitle(R.string.gdpr_consent_screen_header);
    return paramLayoutInflater.inflate(R.layout.gdrp_iab_consent_all, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.a
 * JD-Core Version:    0.6.2
 */