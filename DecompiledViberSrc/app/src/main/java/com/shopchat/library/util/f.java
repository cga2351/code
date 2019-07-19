package com.shopchat.library.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;

public class f
{
  public static int a(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }

  public static int a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 0);
  }

  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt1 });
    try
    {
      int i = localTypedArray.getColor(0, paramInt2);
      return i;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.util.f
 * JD-Core Version:    0.6.2
 */