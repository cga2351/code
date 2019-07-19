package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

final class hi
  implements hf
{
  private final View a;
  private final Handler b = new Handler(Looper.getMainLooper());
  private final hj c;

  hi(View paramView, hj paramhj)
  {
    this.a = paramView;
    this.a.setVisibility(8);
    this.c = paramhj;
  }

  private void d()
  {
    this.b.removeCallbacksAndMessages(null);
  }

  public final View a()
  {
    return this.a;
  }

  public final void a(boolean paramBoolean)
  {
    d();
    View localView = this.a;
    if (paramBoolean);
    for (int i = 8; ; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }

  public final void b()
  {
    this.b.postDelayed(new Runnable()
    {
      public final void run()
      {
        hi.a(hi.this).setVisibility(0);
      }
    }
    , 200L);
  }

  public final void c()
  {
    d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.hi
 * JD-Core Version:    0.6.2
 */