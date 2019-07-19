package com.viber.voip.gdpr.ui.iabconsent;

import com.viber.voip.ViberEnv;
import com.viber.voip.gdpr.a.a;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.mvp.core.j;

public class AllConsentPresenter extends BaseMvpPresenter<j, State>
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger("AllConsentPresenter");
  private final a b;
  private final e c;

  AllConsentPresenter(a parama, e parame)
  {
    this.b = parama;
    this.c = parame;
  }

  public void a()
  {
    this.b.b(0);
    this.c.a();
  }

  public void b()
  {
    this.c.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.AllConsentPresenter
 * JD-Core Version:    0.6.2
 */