package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

final class hk
  implements hm
{
  private final hf a;
  private final RelativeLayout b;
  private final fx.f c;

  hk(Context paramContext, hf paramhf)
  {
    this.a = paramhf;
    this.b = fx.c.a(paramContext);
    this.c = new fx.f(paramContext);
  }

  public final View a(View paramView, v paramv)
  {
    Context localContext = paramView.getContext();
    RelativeLayout.LayoutParams localLayoutParams1 = fx.d.a(localContext, paramv);
    this.b.addView(paramView, localLayoutParams1);
    RelativeLayout.LayoutParams localLayoutParams2 = fx.d.a(localContext, paramView);
    View localView = this.a.a();
    this.b.addView(localView, localLayoutParams2);
    RelativeLayout.LayoutParams localLayoutParams3 = fx.d.b(localContext, paramv);
    RelativeLayout localRelativeLayout = fx.c.b(localContext);
    this.c.setBackFace(this.b, localLayoutParams3);
    this.c.setFrontFace(localRelativeLayout, localLayoutParams1);
    this.c.setLayoutParams(fx.d.a(localContext, null));
    return this.c;
  }

  public final void a()
  {
    this.a.b();
    Rect localRect = dh.b(this.b);
    fw.a(this.c, localRect);
  }

  public final void a(Context paramContext, m paramm, aj paramaj)
  {
    int i = 1;
    int j = paramContext.getResources().getConfiguration().orientation;
    boolean bool1 = gw.a(paramContext, paramaj);
    boolean bool2 = gw.b(paramContext, paramaj);
    if (bool1 == bool2)
      i = -1;
    while (true)
    {
      if (-1 != i)
        paramm.a(i);
      return;
      if (bool2)
      {
        if (i != j);
      }
      else
        while (i != j)
        {
          i = 0;
          break;
        }
    }
  }

  public final void a(RelativeLayout paramRelativeLayout)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramRelativeLayout.setBackground(fx.b.a);
      return;
    }
    paramRelativeLayout.setBackgroundDrawable(fx.b.a);
  }

  public final void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final void b()
  {
    this.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hk
 * JD-Core Version:    0.6.2
 */