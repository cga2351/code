package com.viber.voip.util;

import android.graphics.Color;

public class v
{
  public static float a(int paramInt)
  {
    double d1 = Color.red(paramInt) / 255.0D;
    double d2;
    double d3;
    double d4;
    label52: double d5;
    if (d1 < 0.03928D)
    {
      d2 = d1 / 12.92D;
      d3 = Color.green(paramInt) / 255.0D;
      if (d3 >= 0.03928D)
        break label120;
      d4 = d3 / 12.92D;
      d5 = Color.blue(paramInt) / 255.0D;
      if (d5 >= 0.03928D)
        break label141;
    }
    label141: for (double d6 = d5 / 12.92D; ; d6 = Math.pow((d5 + 0.055D) / 1.055D, 2.4D))
    {
      return (float)(d2 * 0.2126D + d4 * 0.7152D + 0.0722D * d6);
      d2 = Math.pow((d1 + 0.055D) / 1.055D, 2.4D);
      break;
      label120: d4 = Math.pow((d3 + 0.055D) / 1.055D, 2.4D);
      break label52;
    }
  }

  public static int a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = (0xFF & paramInt1 >> 24) / 255.0F;
    float f2 = (0xFF & paramInt1 >> 16) / 255.0F;
    float f3 = (0xFF & paramInt1 >> 8) / 255.0F;
    float f4 = (paramInt1 & 0xFF) / 255.0F;
    float f5 = (0xFF & paramInt2 >> 24) / 255.0F;
    float f6 = (0xFF & paramInt2 >> 16) / 255.0F;
    float f7 = (0xFF & paramInt2 >> 8) / 255.0F;
    float f8 = (paramInt2 & 0xFF) / 255.0F;
    float f9 = (float)Math.pow(f2, 2.2D);
    float f10 = (float)Math.pow(f3, 2.2D);
    float f11 = (float)Math.pow(f4, 2.2D);
    float f12 = (float)Math.pow(f6, 2.2D);
    float f13 = (float)Math.pow(f7, 2.2D);
    float f14 = (float)Math.pow(f8, 2.2D);
    float f15 = f1 + paramFloat * (f5 - f1);
    float f16 = f9 + paramFloat * (f12 - f9);
    float f17 = f10 + paramFloat * (f13 - f10);
    float f18 = f11 + paramFloat * (f14 - f11);
    float f19 = f15 * 255.0F;
    float f20 = 255.0F * (float)Math.pow(f16, 0.4545454545454545D);
    float f21 = 255.0F * (float)Math.pow(f17, 0.4545454545454545D);
    float f22 = 255.0F * (float)Math.pow(f18, 0.4545454545454545D);
    return Math.round(f19) << 24 | Math.round(f20) << 16 | Math.round(f21) << 8 | Math.round(f22);
  }

  public static int a(int paramInt1, int paramInt2)
  {
    double d1 = Color.alpha(paramInt1) + Color.alpha(paramInt2);
    double d2 = Color.alpha(paramInt1) / d1;
    double d3 = Color.alpha(paramInt2) / d1;
    double d4 = d2 * Color.red(paramInt1) + d3 * Color.red(paramInt2);
    double d5 = d2 * Color.green(paramInt1) + d3 * Color.green(paramInt2);
    double d6 = d2 * Color.blue(paramInt1) + d3 * Color.blue(paramInt2);
    return Color.argb((int)Math.max(Color.alpha(paramInt1), Color.alpha(paramInt2)), (int)d4, (int)d5, (int)d6);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.v
 * JD-Core Version:    0.6.2
 */