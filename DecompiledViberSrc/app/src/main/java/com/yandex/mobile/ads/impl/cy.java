package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public final class cy
{
  public static int a(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cy
 * JD-Core Version:    0.6.2
 */