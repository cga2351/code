package com.viber.voip.viberout.ui.products.plans;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.da;
import com.viber.voip.viberout.ui.products.account.b;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import java.util.Collection;
import java.util.List;

public class l extends d<ViberOutPlansPresenter>
  implements b.a, k
{
  private final Activity a;
  private final g b;
  private final a c;

  protected l(ViberOutPlansPresenter paramViberOutPlansPresenter, View paramView, Activity paramActivity, g paramg, a parama, b paramb)
  {
    super(paramViberOutPlansPresenter, paramView);
    this.a = paramActivity;
    this.b = paramg;
    this.c = parama;
    this.b.a(this);
    this.b.a(paramb);
    TextView localTextView = (TextView)this.c.a().findViewById(R.id.disclaimer);
    localTextView.setText(Html.fromHtml(this.mRootView.getContext().getString(R.string.vo_unlimited_plan_disclaimer)));
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public void a()
  {
    this.b.b();
  }

  public void a(PlanModel paramPlanModel)
  {
    if (!da.a(paramPlanModel.getInfoAction()))
      ViberActionRunner.be.a(this.a, paramPlanModel.getInfoAction());
  }

  public void a(PlanModel paramPlanModel, int paramInt1, int paramInt2)
  {
    ((ViberOutPlansPresenter)this.mPresenter).b(paramPlanModel);
  }

  public void a(Collection<List<PlanModel>> paramCollection, boolean paramBoolean)
  {
    this.b.a(paramCollection);
    this.b.a(false);
    this.b.b(paramBoolean);
    this.c.a(paramBoolean);
  }

  public void b(PlanModel paramPlanModel)
  {
    if (!da.a(paramPlanModel.getBuyAction()))
      ViberActionRunner.be.a(this.a, paramPlanModel.getBuyAction());
  }

  public void c(PlanModel paramPlanModel)
  {
    ((ViberOutPlansPresenter)this.mPresenter).a(paramPlanModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.l
 * JD-Core Version:    0.6.2
 */