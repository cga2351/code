package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

final class hl
  implements hm
{
  private final hf a;

  hl(hf paramhf)
  {
    this.a = paramhf;
  }

  public final View a(View paramView, v<String> paramv)
  {
    Context localContext = paramView.getContext();
    RelativeLayout.LayoutParams localLayoutParams1 = fx.d.a();
    RelativeLayout localRelativeLayout = fx.c.a(localContext);
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localRelativeLayout.addView(paramView, fx.d.a());
    RelativeLayout.LayoutParams localLayoutParams2 = fx.d.a(localContext, paramView);
    localRelativeLayout.addView(this.a.a(), localLayoutParams2);
    return localRelativeLayout;
  }

  public final void a()
  {
    this.a.b();
  }

  public final void a(Context paramContext, m paramm, aj paramaj)
  {
  }

  public final void a(RelativeLayout paramRelativeLayout)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramRelativeLayout.setBackground(fx.b.b);
      return;
    }
    paramRelativeLayout.setBackgroundDrawable(fx.b.b);
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
 * Qualified Name:     com.yandex.mobile.ads.impl.hl
 * JD-Core Version:    0.6.2
 */