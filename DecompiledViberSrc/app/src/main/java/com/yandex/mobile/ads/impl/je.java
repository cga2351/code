package com.yandex.mobile.ads.impl;

import android.view.View;
import java.lang.ref.WeakReference;

public abstract class je<V extends View, T>
{
  private final WeakReference<V> a;

  public je(V paramV)
  {
    this.a = new WeakReference(paramV);
  }

  public final V a()
  {
    return (View)this.a.get();
  }

  public void a(V paramV)
  {
    paramV.setVisibility(8);
    paramV.setOnClickListener(null);
    paramV.setOnTouchListener(null);
    paramV.setSelected(false);
  }

  public void a(le paramle, ji paramji)
  {
    View localView = a();
    if (localView != null)
    {
      paramji.a(paramle, localView);
      paramji.a(paramle, new js(localView));
    }
  }

  public abstract boolean a(V paramV, T paramT);

  public abstract void b(V paramV, T paramT);

  public final boolean b()
  {
    return a() != null;
  }

  public final boolean c()
  {
    View localView = a();
    return (localView != null) && (!dh.d(localView));
  }

  public final boolean d()
  {
    return dh.a(a(), 100);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.je
 * JD-Core Version:    0.6.2
 */