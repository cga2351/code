package com.viber.voip.viberout.ui.products.credits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout.a;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.ck;
import com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter;
import com.viber.voip.viberout.ui.products.account.f;
import com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter;
import com.viber.voip.viberout.ui.products.coupon.b;
import com.viber.voip.viberout.ui.products.e;
import javax.inject.Inject;

public class d extends com.viber.voip.mvp.core.g<com.viber.voip.mvp.core.d>
{

  @Inject
  ViberOutCreditsPresenter a;

  @Inject
  ViberOutAccountPresenter b;

  @Inject
  com.viber.voip.analytics.g c;

  @Inject
  ViberOutCouponPresenter d;
  private com.viber.voip.viberout.ui.products.account.a e;
  private a f;
  private e g;
  private RecyclerView h;
  private ck<RecyclerView.Adapter<RecyclerView.ViewHolder>> i;
  private View j;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    f localf = new f(this.b, paramView, getActivity(), this.e);
    this.b.a("plans");
    this.b.b("world credits");
    addMvpView(localf, this.b, paramBundle);
    g localg = new g(this.a, paramView, getActivity(), this.i, localf, this.f);
    this.a.a(getActivity().getIntent().getStringExtra("referral"));
    addMvpView(localg, this.a, paramBundle);
    addMvpView(new b(this.d, this.j), this.d, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    this.g = new e(getContext(), this.c);
    this.e = new com.viber.voip.viberout.ui.products.account.a(getLayoutInflater(), this.g);
    this.f = new a(getLayoutInflater(), this.g);
    this.i = new ck();
    this.i.a(this.e);
    this.i.a(this.f);
    this.j = View.inflate(getContext(), R.layout.vo_have_coupon, null);
    this.j.setLayoutParams(new ConstraintLayout.a(-1, -2));
    this.i.a(this.j);
    this.h.setAdapter(this.i);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_viber_out_credits, paramViewGroup, false);
    this.h = ((RecyclerView)localView.findViewById(R.id.list_view));
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.d
 * JD-Core Version:    0.6.2
 */