package com.viber.voip.viberout.ui.products.plans;

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
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.ck;
import com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter;
import com.viber.voip.viberout.ui.products.account.f;
import com.viber.voip.viberout.ui.products.coupon.ViberOutCouponPresenter;
import com.viber.voip.viberout.ui.products.coupon.b;
import com.viber.voip.viberout.ui.products.e;
import javax.inject.Inject;

public class i extends com.viber.voip.mvp.core.g<d>
{

  @Inject
  ViberOutPlansPresenter a;

  @Inject
  ViberOutAccountPresenter b;

  @Inject
  com.viber.voip.analytics.g c;

  @Inject
  ViberOutCouponPresenter d;
  private com.viber.voip.viberout.ui.products.account.a e;
  private e f;
  private RecyclerView g;
  private ck<RecyclerView.Adapter<RecyclerView.ViewHolder>> h;
  private g i;
  private View j;
  private a k;

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    f localf = new f(this.b, paramView, getActivity(), this.e);
    this.b.a("plans");
    this.b.b("plans");
    addMvpView(localf, this.b, paramBundle);
    l locall = new l(this.a, paramView, getActivity(), this.i, this.k, localf);
    this.a.a(getActivity().getIntent().getStringExtra("referral"));
    addMvpView(locall, this.a, paramBundle);
    addMvpView(new b(this.d, this.j), this.d, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    this.f = new e(getContext(), this.c);
    this.e = new com.viber.voip.viberout.ui.products.account.a(getLayoutInflater(), this.f);
    this.i = new g(getLayoutInflater(), this.f);
    this.i.a(true);
    this.h = new ck();
    this.h.a(this.e);
    this.h.a(this.i);
    View localView = View.inflate(getContext(), R.layout.vo_unlimited_plan_disclaimer, null);
    localView.setLayoutParams(new ConstraintLayout.a(-1, -2));
    this.k = new a(getContext(), localView);
    this.h.a(this.k);
    this.j = View.inflate(getContext(), R.layout.vo_have_coupon, null);
    this.j.setLayoutParams(new ConstraintLayout.a(-1, -2));
    this.h.a(this.j);
    this.g.setAdapter(this.h);
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

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_viber_out_plans, paramViewGroup, false);
    this.g = ((RecyclerView)localView.findViewById(R.id.list_view));
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.i
 * JD-Core Version:    0.6.2
 */