package com.yandex.mobile.ads.impl;

import android.graphics.RectF;

public final class ej
  implements ek
{
  private final RectF a;
  private final int b;

  public ej(int paramInt, RectF paramRectF)
  {
    this.b = paramInt;
    this.a = paramRectF;
  }

  public final String a()
  {
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(this.b);
    RectF localRectF = this.a;
    String str = null;
    if (localRectF != null)
    {
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = Float.valueOf(localRectF.left);
      arrayOfObject2[1] = Float.valueOf(localRectF.top);
      arrayOfObject2[2] = Float.valueOf(localRectF.width());
      arrayOfObject2[3] = Float.valueOf(localRectF.height());
      str = String.format("{x:%s,y:%s,width:%s,height:%s}", arrayOfObject2);
    }
    arrayOfObject1[1] = str;
    return String.format("exposure:{exposedPercentage:%s,visibleRectangle:%s,occlusionRectangles:[]}", arrayOfObject1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ej
 * JD-Core Version:    0.6.2
 */