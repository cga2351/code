package com.facebook.react.uimanager;

public class FloatUtil
{
  private static final float EPSILON = 1.0E-005F;

  public static boolean floatsEqual(float paramFloat1, float paramFloat2)
  {
    if ((Float.isNaN(paramFloat1)) || (Float.isNaN(paramFloat2)))
      if ((!Float.isNaN(paramFloat1)) || (!Float.isNaN(paramFloat2)));
    while (Math.abs(paramFloat2 - paramFloat1) < 1.0E-005F)
    {
      return true;
      return false;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.FloatUtil
 * JD-Core Version:    0.6.2
 */