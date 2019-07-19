package com.viber.voip.util;

public final class ca
{
  public static int a(int[] paramArrayOfInt)
  {
    int i = 1;
    int j = paramArrayOfInt.length;
    for (int k = 0; k < j; k++)
      i = paramArrayOfInt[k] + i * 31;
    return i;
  }

  public static <T> T a(T paramT1, T paramT2)
  {
    if (paramT1 != null)
      return paramT1;
    return paramT2;
  }

  public static String a(String paramString1, String paramString2)
  {
    if (!da.a(paramString1))
      return paramString1;
    return paramString2;
  }

  public static boolean b(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2)
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    return paramObject1.equals(paramObject2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ca
 * JD-Core Version:    0.6.2
 */