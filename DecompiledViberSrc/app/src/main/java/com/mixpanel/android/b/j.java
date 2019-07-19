package com.mixpanel.android.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;

public class j
{
  public static float a(float paramFloat, Context paramContext)
  {
    return paramFloat * (paramContext.getResources().getDisplayMetrics().densityDpi / 160.0F);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    float f1 = Color.red(paramInt1) / 2 + Color.red(paramInt2) / 2;
    float f2 = Color.green(paramInt1) / 2 + Color.green(paramInt2) / 2;
    float f3 = Color.blue(paramInt1) / 2 + Color.blue(paramInt2) / 2;
    return Color.rgb((int)f1, (int)f2, (int)f3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.j
 * JD-Core Version:    0.6.2
 */