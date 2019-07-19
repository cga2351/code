package com.viber.voip.messages.ui.forward.sharelink;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.attr;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.k;
import com.viber.voip.mvp.core.g;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import javax.inject.Inject;

public class b extends g<com.viber.voip.mvp.core.d>
{

  @Inject
  protected e a;

  @Inject
  protected dagger.a<k> b;

  @Inject
  dagger.a<h> c;

  @Inject
  protected dagger.a<ConferenceCallsRepository> d;

  @Inject
  protected com.viber.voip.messages.controller.a e;

  @Inject
  protected com.viber.voip.app.b f;
  private d g;
  private j h;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    if (getArguments() == null)
    {
      getActivity().finish();
      return;
    }
    f localf = f.c(dc.a(getContext(), R.attr.contactDefaultPhotoMedium));
    String str1 = getArguments().getString("share_text");
    String str2 = getArguments().getString("invite_link");
    if ((str2 != null) && (str1 != null))
    {
      ShareLinkPresenter localShareLinkPresenter = new ShareLinkPresenter(this.e, str1, str2, this.g, this.a, localf);
      this.h = new j(localShareLinkPresenter, paramView, getActivity(), this.f.a(getContext()));
      addMvpView(this.h, localShareLinkPresenter, paramBundle);
      return;
    }
    getActivity().finish();
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    String str = "";
    if ((paramBundle != null) && (!da.a(paramBundle.getString("search_query_key"))))
      str = paramBundle.getString("search_query_key");
    this.g = new d(getContext(), this.b, getLoaderManager(), this.c, this.d, paramBundle, str);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    return paramLayoutInflater.inflate(R.layout.share_community_link_layout, paramViewGroup, false);
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.g.a();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.g.a(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.b
 * JD-Core Version:    0.6.2
 */