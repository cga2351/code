package com.facebook.react.common;

import java.util.Arrays;
import java.util.List;

public class ArrayUtils
{
  public static float[] copyArray(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
      return null;
    return Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
  }

  public static int[] copyListToArray(List<Integer> paramList)
  {
    int[] arrayOfInt = new int[paramList.size()];
    for (int i = 0; i < paramList.size(); i++)
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
    return arrayOfInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.ArrayUtils
 * JD-Core Version:    0.6.2
 */