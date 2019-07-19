package com.yandex.mobile.ads.impl;

import android.view.View.MeasureSpec;

public final class dw
  implements dv
{
  private final dv.a a = new dv.a();
  private final x b;

  public dw(float paramFloat)
  {
    this.b = new x(paramFloat);
  }

  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.MeasureSpec.makeMeasureSpec(b(paramInt1, paramInt2, paramInt3), 1073741824);
  }

  private static boolean a(int paramInt)
  {
    return (paramInt == -2147483648) || (paramInt == 0);
  }

  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == -2147483648)
      paramInt1 = Math.min(paramInt2, paramInt1);
    return paramInt1;
  }

  public final dv.a a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((i == 1073741824) && (a(j)))
      paramInt2 = a(this.b.b(k), m, j);
    while (true)
    {
      this.a.a = paramInt1;
      this.a.b = paramInt2;
      return this.a;
      if ((j == 1073741824) && (a(i)))
        paramInt1 = a(this.b.a(m), k, i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dw
 * JD-Core Version:    0.6.2
 */