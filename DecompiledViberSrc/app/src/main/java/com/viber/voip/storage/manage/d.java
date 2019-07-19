package com.viber.voip.storage.manage;

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
import com.viber.voip.ViberApplication;
import com.viber.voip.mvp.core.g;
import com.viber.voip.storage.repository.MediaStorageInteractor;
import com.viber.voip.storage.repository.e;
import com.viber.voip.storage.repository.r;
import com.viber.voip.storage.repository.u;
import javax.inject.Inject;

public class d extends g<k>
{

  @Inject
  protected ViberApplication a;

  @Inject
  protected dagger.a<com.viber.voip.messages.k> b;

  @Inject
  protected f c;

  @Inject
  protected r d;

  @Inject
  protected u e;

  @Inject
  protected Handler f;

  @Inject
  protected Handler g;
  private e h;
  private MediaStorageInteractor<e> i;
  private h j;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    ManageStoragePresenterBase localManageStoragePresenterBase = ManageStoragePresenterBase.a(ViberApplication.isActivated(), this.i, this.f);
    addMvpView(new k(localManageStoragePresenterBase, this.j, this.f, paramView), localManageStoragePresenterBase, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    this.h = new e(getContext(), getLoaderManager(), paramBundle, this.b, com.viber.voip.h.a.b(), this.c);
    this.i = new MediaStorageInteractor(this.h, this.d, this.e, this.f, this.g);
    com.viber.voip.storage.model.a locala = new com.viber.voip.storage.model.a();
    this.j = new h(getContext(), locala.a(getArguments(), "extra_source"));
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_manage_storage, paramViewGroup, false);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.h != null)
      this.h.a(paramBundle);
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
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.manage.d
 * JD-Core Version:    0.6.2
 */