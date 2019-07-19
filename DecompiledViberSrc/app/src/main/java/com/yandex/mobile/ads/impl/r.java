package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import com.yandex.mobile.ads.AdRequestError;
import java.lang.ref.WeakReference;

public final class r
  implements aa
{
  private static final SparseArray<AdRequestError> c;
  private final af a;
  private final WeakReference<y> b;

  static
  {
    SparseArray localSparseArray = new SparseArray();
    c = localSparseArray;
    localSparseArray.put(6, t.j);
    c.put(2, t.g);
    c.put(5, t.e);
    c.put(8, t.f);
    c.put(10, t.m);
    c.put(4, t.m);
    c.put(9, t.h);
    c.put(7, t.l);
  }

  public r(y paramy)
  {
    this.b = new WeakReference(paramy);
    this.a = af.a();
  }

  public static AdRequestError a(int paramInt)
  {
    return (AdRequestError)c.get(paramInt, t.s);
  }

  public final void a()
  {
    y localy = (y)this.b.get();
    if (localy != null)
      this.a.a(localy.l(), cw.a(localy));
  }

  final void a(bm parambm)
  {
    y localy = (y)this.b.get();
    if (localy != null)
      this.a.a(localy.l(), parambm);
  }

  public final boolean a_()
  {
    return false;
  }

  public final void b()
  {
    a();
    this.b.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.r
 * JD-Core Version:    0.6.2
 */