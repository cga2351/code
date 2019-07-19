package com.viber.voip.viberout.ui.products.countryplans;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.List;

public class g extends com.viber.voip.mvp.core.d<ViberOutCountryPlansInfoPresenter>
  implements e.a, f
{
  private final e a;
  private final RecyclerView b;
  private final View c;
  private final ViewStub d;
  private View e;
  private final Activity f;

  g(ViberOutCountryPlansInfoPresenter paramViberOutCountryPlansInfoPresenter, View paramView, Activity paramActivity, e parame)
  {
    super(paramViberOutCountryPlansInfoPresenter, paramView);
    this.a = parame;
    this.a.a(this);
    this.b = ((RecyclerView)paramView.findViewById(R.id.country_plans_list));
    this.b.setAdapter(this.a);
    TextView localTextView = (TextView)LayoutInflater.from(paramActivity).inflate(R.layout.view_ribbon, this.b, false);
    this.b.addItemDecoration(new com.viber.voip.viberout.ui.products.plans.d(localTextView, paramActivity.getResources(), false));
    this.c = paramView.findViewById(R.id.content_progress);
    this.d = ((ViewStub)paramView.findViewById(R.id.no_connection_stub));
    this.f = paramActivity;
  }

  public void a()
  {
    if (this.e == null)
    {
      this.e = this.d.inflate();
      this.e.findViewById(R.id.try_again_button).setOnClickListener(new h(this));
    }
    dj.b(this.e, true);
    dj.b(this.b, false);
    dj.b(this.c, false);
  }

  public void a(int paramInt)
  {
    ((ViberOutCountryPlansInfoPresenter)this.mPresenter).a(paramInt);
  }

  public void a(CreditModel paramCreditModel)
  {
    ((ViberOutCountryPlansInfoPresenter)this.mPresenter).a(paramCreditModel);
  }

  public void a(PlanModel paramPlanModel)
  {
    if (!da.a(paramPlanModel.getInfoAction()))
      ViberActionRunner.be.a(this.f, paramPlanModel.getInfoAction());
  }

  public void a(PlanModel paramPlanModel, int paramInt1, int paramInt2)
  {
    ((ViberOutCountryPlansInfoPresenter)this.mPresenter).b(paramPlanModel);
  }

  public void a(List<PlanModel> paramList)
  {
    this.a.a(paramList);
  }

  public void a(List<CreditModel> paramList, int paramInt, CreditModel paramCreditModel, RateModel paramRateModel)
  {
    this.a.a(paramList, paramInt, paramCreditModel, paramRateModel);
  }

  public void b()
  {
    dj.b(this.c, true);
    dj.b(this.b, false);
    dj.b(this.e, false);
  }

  public void b(CreditModel paramCreditModel)
  {
    if (!da.a(paramCreditModel.getBuyAction()))
      ViberActionRunner.be.a(this.f, paramCreditModel.getBuyAction());
  }

  public void b(PlanModel paramPlanModel)
  {
    if (!da.a(paramPlanModel.getBuyAction()))
      ViberActionRunner.be.a(this.f, paramPlanModel.getBuyAction());
  }

  public void c()
  {
    dj.b(this.b, true);
    dj.b(this.c, false);
    dj.b(this.e, false);
  }

  public void c(PlanModel paramPlanModel)
  {
    ((ViberOutCountryPlansInfoPresenter)this.mPresenter).a(paramPlanModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.g
 * JD-Core Version:    0.6.2
 */