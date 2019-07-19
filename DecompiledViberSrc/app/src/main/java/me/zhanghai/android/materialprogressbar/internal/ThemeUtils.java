package me.zhanghai.android.materialprogressbar.internal;

import android.content.Context;
import android.content.res.TypedArray;

public class ThemeUtils
{
  public static int getColorFromAttrRes(int paramInt, Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      int i = localTypedArray.getColor(0, 0);
      return i;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static float getFloatFromAttrRes(int paramInt, Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      float f = localTypedArray.getFloat(0, 0.0F);
      return f;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.internal.ThemeUtils
 * JD-Core Version:    0.6.2
 */