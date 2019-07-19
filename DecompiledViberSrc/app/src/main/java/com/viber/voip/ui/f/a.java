package com.viber.voip.ui.f;

import android.content.res.Resources;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.bottomnavigation.BottomNavigationView;
import com.viber.voip.ui.bottomnavigation.BottomNavigationView.a;
import com.viber.voip.widget.m.c;

public class a
  implements BottomNavigationView.a, d, m.c
{
  private static final Logger a = ViberEnv.getLogger();
  private c b;
  private e c;
  private BottomNavigationView d;
  private com.viber.voip.widget.m e;

  public a(Resources paramResources, View paramView, c paramc)
  {
    this.b = paramc;
    this.d = ((BottomNavigationView)paramView.findViewById(R.id.bottom_nav_bar));
    this.d.a(this.b.b());
    this.d.setBottomNavigationListener(this);
    this.d.a(2, paramResources.getDimensionPixelOffset(R.dimen.bottom_navigation_more_badge_text_size));
    this.d.a(3, paramResources.getDimensionPixelOffset(R.dimen.bottom_navigation_more_badge_text_size));
  }

  public void a()
  {
    this.c = null;
    this.d.setBottomNavigationListener(null);
    if (this.e != null)
      this.e.b(this);
  }

  public void a(int paramInt)
  {
    if (this.c != null)
    {
      int i = this.b.b(paramInt);
      if (i != -1)
        this.c.b(i);
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramInt2 > 0)
      switch (paramInt1)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
    while (true)
    {
      int i = this.b.c(paramInt1);
      if (i != -1)
        this.d.a(i, str);
      return;
      str = com.viber.voip.messages.m.h(paramInt2);
      continue;
      str = String.valueOf(paramInt2);
      continue;
      str = "•";
    }
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    int i = this.b.c(paramInt);
    this.d.a(i, paramBoolean);
  }

  public void a(e parame)
  {
    this.c = parame;
  }

  public void a(com.viber.voip.widget.m paramm)
  {
    if (paramm == null)
      return;
    paramm.a(this);
    this.e = paramm;
  }

  public void b(int paramInt)
  {
    if (this.c != null)
    {
      int i = this.b.b(paramInt);
      if (i != -1)
        this.c.e(i);
    }
  }

  public boolean b()
  {
    return true;
  }

  public void f(int paramInt)
  {
    a(this.b.b(paramInt), false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.f.a
 * JD-Core Version:    0.6.2
 */