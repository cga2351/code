package com.viber.voip.storage.overall;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.d.f;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.g;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.e;
import com.viber.voip.storage.repository.r;
import com.viber.voip.storage.repository.u;
import javax.inject.Inject;

public class a extends g<d>
{

  @Inject
  protected dagger.a<com.viber.voip.messages.k> a;

  @Inject
  protected f b;

  @Inject
  protected r c;

  @Inject
  protected u d;

  @Inject
  protected Handler e;

  @Inject
  protected Handler f;

  @Inject
  protected i g;

  @Inject
  protected com.viber.voip.analytics.story.g.a h;
  private MediaStorageInteractor<e> i;
  private int j = 0;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    ManageOverallStoragePresenter localManageOverallStoragePresenter = new ManageOverallStoragePresenter(this.j, this.i, this.g, this.h);
    addMvpView(new d(this, localManageOverallStoragePresenter, paramView), localManageOverallStoragePresenter, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    this.i = new MediaStorageInteractor(new com.viber.voip.storage.repository.k(getContext(), getLoaderManager(), paramBundle, this.a, com.viber.voip.h.a.b(), this.b), this.c, this.d, this.e, this.f);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    this.j = new com.viber.voip.storage.model.a().a(getArguments(), "extra_source");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_manage_overall_storage, paramViewGroup, false);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Toolbar localToolbar = (Toolbar)paramView.findViewById(R.id.toolbar);
    AppCompatActivity localAppCompatActivity = (AppCompatActivity)getActivity();
    if (localAppCompatActivity != null)
    {
      localAppCompatActivity.setSupportActionBar(localToolbar);
      localAppCompatActivity.getSupportActionBar().e(true);
      localAppCompatActivity.setTitle(R.string.pref_category_media);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.overall.a
 * JD-Core Version:    0.6.2
 */