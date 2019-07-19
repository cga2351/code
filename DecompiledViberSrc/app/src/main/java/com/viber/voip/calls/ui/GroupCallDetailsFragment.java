package com.viber.voip.calls.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.Engine;
import com.viber.voip.R.layout;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.calls.d;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;
import com.viber.voip.util.cn;
import javax.inject.Inject;

public class GroupCallDetailsFragment extends com.viber.voip.mvp.core.g<e>
{

  @Inject
  CallHandler a;

  @Inject
  cj b;

  @Inject
  Engine c;

  @Inject
  d d;

  @Inject
  com.viber.voip.util.e.e e;

  @Inject
  Handler f;

  @Inject
  Handler g;

  @Inject
  com.viber.common.permission.c h;

  @Inject
  com.viber.voip.analytics.g i;

  @Inject
  UserManager j;

  @Inject
  bs k;

  @Inject
  cn l;

  @Inject
  com.viber.voip.app.b m;

  @Inject
  com.viber.voip.messages.d.b n;

  @Inject
  dagger.a<h> o;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.c> p;
  private e q;
  private boolean r;
  private Bundle s;

  public void a(Bundle paramBundle)
  {
    if (this.q == null)
    {
      this.r = true;
      this.s = paramBundle;
      return;
    }
    this.q.a(paramBundle);
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    GroupCallDetailsPresenter localGroupCallDetailsPresenter = new GroupCallDetailsPresenter(this.g, this.a, this.b, this.c, this.d, this.j, this.k, this.l, this.n, this.o, this.p);
    this.q = new e(localGroupCallDetailsPresenter, paramView, this, this.f, this.e, this.h, this.m);
    addMvpView(this.q, localGroupCallDetailsPresenter, paramBundle);
    if ((this.r) && (this.s != null))
    {
      this.q.a(this.s);
      this.r = false;
      this.s = null;
    }
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
    return paramLayoutInflater.inflate(R.layout.fragment_group_call_details, paramViewGroup, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.GroupCallDetailsFragment
 * JD-Core Version:    0.6.2
 */