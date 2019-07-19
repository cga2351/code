package com.viber.voip.viberout.ui.products.credits;

import com.viber.voip.mvp.core.j;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.Collection;

abstract interface f extends j
{
  public abstract void a();

  public abstract void a(Collection<RateModel> paramCollection);

  public abstract void a(Collection<CreditModel> paramCollection, int paramInt);

  public abstract void a(boolean paramBoolean);

  public abstract void b(int paramInt);

  public abstract void b(CreditModel paramCreditModel);

  public abstract void c(CreditModel paramCreditModel);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.f
 * JD-Core Version:    0.6.2
 */