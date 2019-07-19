package com.yandex.mobile.ads.impl;

import android.view.View;

public class io<V extends View, T>
  implements in<T>
{
  private final je<V, T> a;

  public io(je<V, T> paramje)
  {
    this.a = paramje;
  }

  public final void a()
  {
    View localView = this.a.a();
    if (localView != null)
      this.a.a(localView);
  }

  public final void a(le paramle, ji paramji)
  {
    this.a.a(paramle, paramji);
  }

  public final void a(T paramT)
  {
    View localView = this.a.a();
    if (localView != null)
    {
      this.a.b(localView, paramT);
      localView.setVisibility(0);
    }
  }

  public final boolean b()
  {
    return this.a.b();
  }

  public final boolean b(T paramT)
  {
    View localView = this.a.a();
    return (localView != null) && (this.a.a(localView, paramT));
  }

  public final boolean c()
  {
    return this.a.c();
  }

  public final boolean d()
  {
    return this.a.d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.io
 * JD-Core Version:    0.6.2
 */