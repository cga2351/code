package com.mopub.common.util;

public class Visibility
{
  public static boolean hasScreenVisibilityChanged(int paramInt1, int paramInt2)
  {
    return isScreenVisible(paramInt1) != isScreenVisible(paramInt2);
  }

  public static boolean isScreenVisible(int paramInt)
  {
    return paramInt == 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Visibility
 * JD-Core Version:    0.6.2
 */