package com.viber.voip.viberout.ui.products.account;

import android.app.Activity;
import android.view.View;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.d;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.da;
import com.viber.voip.viberout.ui.ViberOutAccountActivity;

public class f extends d<ViberOutAccountPresenter>
  implements b, e
{
  private final Activity a;
  private final a b;

  public f(ViberOutAccountPresenter paramViberOutAccountPresenter, View paramView, Activity paramActivity, a parama)
  {
    super(paramViberOutAccountPresenter, paramView);
    this.a = paramActivity;
    this.b = parama;
    this.b.a(this);
  }

  public void a()
  {
    ((ViberOutAccountPresenter)this.mPresenter).e();
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
    this.b.a(paramAccountViewModel);
  }

  public void a(PlanViewModel paramPlanViewModel)
  {
    ((ViberOutAccountPresenter)this.mPresenter).a(paramPlanViewModel);
  }

  public void b()
  {
    ((ViberOutAccountPresenter)this.mPresenter).f();
  }

  public void b(PlanViewModel paramPlanViewModel)
  {
    if (!da.a(paramPlanViewModel.getAction()))
      ViberActionRunner.be.a(this.a, paramPlanViewModel.getAction());
  }

  public void c()
  {
    this.b.a();
  }

  public void d()
  {
    this.b.b();
  }

  public void e()
  {
    ViberOutAccountActivity.x();
  }

  public void f()
  {
    GenericWebViewActivity.a(this.a, this.a.getString(R.string.vo_about_link), "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.f
 * JD-Core Version:    0.6.2
 */