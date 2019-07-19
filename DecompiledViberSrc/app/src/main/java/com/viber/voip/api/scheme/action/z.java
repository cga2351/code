package com.viber.voip.api.scheme.action;

import android.content.Context;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.j;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.aq.a;

public class z extends f
{
  public void a(Context paramContext, c.a parama)
  {
    ViberActionRunner.aq.a(new a(paramContext, parama));
  }

  private static class a extends ViberActionRunner.aq.a
  {
    private final c.a c;

    public a(Context paramContext, c.a parama)
    {
      super();
      this.c = parama;
    }

    public void a()
    {
      r.h().a(new ViberDialogHandlers.j()).d();
      this.c.b();
    }

    public void b()
    {
      y.a(this.a, ViberActionRunner.aq.a());
      this.c.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.scheme.action.z
 * JD-Core Version:    0.6.2
 */