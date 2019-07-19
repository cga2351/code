package com.facebook.react.views.view;

public class ColorUtil
{
  public static int getOpacityFromColor(int paramInt)
  {
    int i = paramInt >>> 24;
    if (i == 255)
      return -1;
    if (i == 0)
      return -2;
    return -3;
  }

  public static int multiplyColorAlpha(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 255)
      return paramInt1;
    if (paramInt2 == 0)
      return paramInt1 & 0xFFFFFF;
    return (paramInt2 + (paramInt2 >> 7)) * (paramInt1 >>> 24) >> 8 << 24 | paramInt1 & 0xFFFFFF;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.view.ColorUtil
 * JD-Core Version:    0.6.2
 */