package com.facebook.yoga;

public class YogaConstants
{
  public static final float UNDEFINED = (0.0F / 0.0F);

  public static float getUndefined()
  {
    return (0.0F / 0.0F);
  }

  public static boolean isUndefined(float paramFloat)
  {
    return Float.compare(paramFloat, (0.0F / 0.0F)) == 0;
  }

  public static boolean isUndefined(YogaValue paramYogaValue)
  {
    return paramYogaValue.unit == YogaUnit.UNDEFINED;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaConstants
 * JD-Core Version:    0.6.2
 */