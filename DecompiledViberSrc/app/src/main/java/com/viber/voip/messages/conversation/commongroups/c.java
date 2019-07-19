package com.viber.voip.messages.conversation.commongroups;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.messages.d.b;
import com.viber.voip.mvp.core.g;
import com.viber.voip.util.e.e;
import javax.inject.Inject;

public class c extends g<h>
{

  @Inject
  i a;

  @Inject
  CommonGroupsPresenter b;

  @Inject
  e c;

  @Inject
  dagger.a<b> d;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    addMvpView(new h(this.b, this.a, this.d, this.c, requireActivity(), paramView), this.b, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_common_groups, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.c
 * JD-Core Version:    0.6.2
 */