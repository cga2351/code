package com.viber.voip.viberout.a;

import com.viber.voip.api.a.b.a.c;
import com.viber.voip.user.actions.Action;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import com.viber.voip.viberout.ui.products.model.a;
import java.util.List;
import javax.inject.Inject;

public class n
{
  private final t a;
  private final a b;

  @Inject
  n(t paramt, a parama)
  {
    this.a = paramt;
    this.b = parama;
  }

  public void a(final Action<List<CountryModel>> paramAction, final Action<Throwable> paramAction1)
  {
    this.a.a(new t.b()
    {
      public void a()
      {
        paramAction1.execute(new Exception());
      }

      public void a(List<c> paramAnonymousList)
      {
        paramAction.execute(n.a(n.this).a(paramAnonymousList));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.n
 * JD-Core Version:    0.6.2
 */