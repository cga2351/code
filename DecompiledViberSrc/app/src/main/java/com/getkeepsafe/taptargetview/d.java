package com.getkeepsafe.taptargetview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;

class d
{
  static int a(int paramInt, float paramFloat)
  {
    if (paramFloat > 1.0F)
      paramFloat = 1.0F;
    while (true)
    {
      return (int)(paramFloat * (paramInt >>> 24)) << 24 | 0xFFFFFF & paramInt;
      if (paramFloat <= 0.0F)
        paramFloat = 0.0F;
    }
  }

  static int a(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }

  static int a(Context paramContext, String paramString)
  {
    Resources.Theme localTheme = paramContext.getTheme();
    if (localTheme == null);
    TypedValue localTypedValue;
    int i;
    do
    {
      return -1;
      localTypedValue = new TypedValue();
      i = paramContext.getResources().getIdentifier(paramString, "attr", paramContext.getPackageName());
    }
    while (i == 0);
    localTheme.resolveAttribute(i, localTypedValue, true);
    return localTypedValue.data;
  }

  static int b(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(2, paramInt, paramContext.getResources().getDisplayMetrics());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.d
 * JD-Core Version:    0.6.2
 */