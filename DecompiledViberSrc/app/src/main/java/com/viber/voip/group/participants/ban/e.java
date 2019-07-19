package com.viber.voip.group.participants.ban;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.group.participants.settings.d;
import com.viber.voip.mvp.core.g;
import dagger.android.support.a;
import javax.inject.Inject;

public class e extends g<b>
{

  @Inject
  d a;

  @Inject
  BannedParticipantsListPresenter b;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    addMvpView(new b(this, this.b, this.a, paramView), this.b, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
  }

  public void onAttach(Context paramContext)
  {
    a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    setHasOptionsMenu(true);
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.activity_particpants_settings, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.e
 * JD-Core Version:    0.6.2
 */