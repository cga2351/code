package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import com.yandex.metrica.p;

final class e
{
  static final class a
    implements d
  {
    private final a a;

    a(a parama)
    {
      this.a = parama;
    }

    public final void a(int paramInt)
    {
      this.a.b(paramInt);
    }

    public final void a(Context paramContext)
    {
      if (cz.b());
      try
      {
        p.rolu(paramContext, this);
        label11: if (!cw.a(this.a))
          this.a.t();
        return;
      }
      catch (Throwable localThrowable)
      {
        break label11;
      }
    }

    public final void a(Context paramContext, View paramView)
    {
    }

    public final void b(Context paramContext)
    {
      if (cz.b());
      try
      {
        p.urolu(paramContext, this);
        label11: if (!cw.a(this.a))
          this.a.u();
        return;
      }
      catch (Throwable localThrowable)
      {
        break label11;
      }
    }
  }

  static final class b
    implements d
  {
    public final void a(int paramInt)
    {
    }

    public final void a(Context paramContext)
    {
    }

    public final void a(Context paramContext, View paramView)
    {
      paramView.setVisibility(0);
      paramView.setMinimumHeight(dh.a(paramContext, 50.0F));
    }

    public final void b(Context paramContext)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.e
 * JD-Core Version:    0.6.2
 */