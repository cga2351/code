package com.viber.voip.viberout.ui.products.countryplans;

import com.viber.voip.mvp.core.j;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.List;

public abstract interface f extends j
{
  public abstract void a();

  public abstract void a(PlanModel paramPlanModel);

  public abstract void a(List<PlanModel> paramList);

  public abstract void a(List<CreditModel> paramList, int paramInt, CreditModel paramCreditModel, RateModel paramRateModel);

  public abstract void b();

  public abstract void b(CreditModel paramCreditModel);

  public abstract void b(PlanModel paramPlanModel);

  public abstract void c();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.f
 * JD-Core Version:    0.6.2
 */