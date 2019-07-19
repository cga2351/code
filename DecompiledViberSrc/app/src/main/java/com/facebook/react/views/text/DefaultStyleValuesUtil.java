package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;

public final class DefaultStyleValuesUtil
{
  private DefaultStyleValuesUtil()
  {
    throw new AssertionError("Never invoke this for an Utility class!");
  }

  private static ColorStateList getDefaultTextAttribute(Context paramContext, int paramInt)
  {
    Resources.Theme localTheme = paramContext.getTheme();
    TypedArray localTypedArray = null;
    try
    {
      localTypedArray = localTheme.obtainStyledAttributes(new int[] { paramInt });
      ColorStateList localColorStateList = localTypedArray.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      if (localTypedArray != null)
        localTypedArray.recycle();
    }
  }

  public static ColorStateList getDefaultTextColor(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842904);
  }

  public static int getDefaultTextColorHighlight(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842905).getDefaultColor();
  }

  public static ColorStateList getDefaultTextColorHint(Context paramContext)
  {
    return getDefaultTextAttribute(paramContext, 16842906);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.DefaultStyleValuesUtil
 * JD-Core Version:    0.6.2
 */