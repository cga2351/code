package com.yandex.mobile.ads.impl;

import android.view.View;

final class jf<V extends View, T>
{
  private final je<V, T> a;

  jf(je<V, T> paramje)
  {
    this.a = paramje;
  }

  public final void a()
  {
    View localView = this.a.a();
    if (localView != null)
      this.a.a(localView);
  }

  final void a(le paramle, ji paramji)
  {
    if (this.a.a() != null)
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

  public final boolean b(T paramT)
  {
    View localView = this.a.a();
    return (localView != null) && (this.a.a(localView, paramT));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.jf
 * JD-Core Version:    0.6.2
 */