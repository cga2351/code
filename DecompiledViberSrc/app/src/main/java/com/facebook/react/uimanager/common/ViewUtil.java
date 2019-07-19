package com.facebook.react.uimanager.common;

public class ViewUtil
{
  public static int getUIManagerType(int paramInt)
  {
    if (paramInt % 2 == 0)
      return 2;
    return 1;
  }

  @Deprecated
  public static boolean isRootTag(int paramInt)
  {
    return paramInt % 10 == 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.common.ViewUtil
 * JD-Core Version:    0.6.2
 */