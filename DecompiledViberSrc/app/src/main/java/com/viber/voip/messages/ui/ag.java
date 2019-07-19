package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.b.b;
import com.viber.common.ui.c;
import com.viber.common.ui.c.a;
import com.viber.common.ui.c.b;
import com.viber.voip.R.dimen;
import com.viber.voip.R.string;
import com.viber.voip.settings.d.r;

public class ag extends e
{
  public ag(Context paramContext, ViewGroup paramViewGroup, View paramView)
  {
    super(paramContext, paramViewGroup, paramView);
  }

  private c.b f()
  {
    return new c.b().a(c.a.a).c(R.string.vote_create_poll).a(5).a(true).a(new ah(this)).a(this.c).e(this.a.getResources().getDimensionPixelOffset(R.dimen.create_poll_tooltip_offset_x));
  }

  protected c a(Resources paramResources)
  {
    return f().a(this.a);
  }

  public void b()
  {
    if (d.r.J.d())
      super.b();
  }

  public void e()
  {
    d.r.J.a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ag
 * JD-Core Version:    0.6.2
 */