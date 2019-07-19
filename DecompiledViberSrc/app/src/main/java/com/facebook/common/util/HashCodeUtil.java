package com.facebook.common.util;

import javax.annotation.Nullable;

public class HashCodeUtil
{
  private static final int X = 31;

  public static int hashCode(int paramInt)
  {
    return paramInt + 31;
  }

  public static int hashCode(int paramInt1, int paramInt2)
  {
    return paramInt2 + 31 * (paramInt1 + 31);
  }

  public static int hashCode(int paramInt1, int paramInt2, int paramInt3)
  {
    return paramInt3 + 31 * (paramInt2 + 31 * (paramInt1 + 31));
  }

  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt4 + 31 * (paramInt3 + 31 * (paramInt2 + 31 * (paramInt1 + 31)));
  }

  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt5 + 31 * (paramInt4 + 31 * (paramInt3 + 31 * (paramInt2 + 31 * (paramInt1 + 31))));
  }

  public static int hashCode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return paramInt6 + 31 * (paramInt5 + 31 * (paramInt4 + 31 * (paramInt3 + 31 * (paramInt2 + 31 * (paramInt1 + 31)))));
  }

  public static int hashCode(@Nullable Object paramObject)
  {
    if (paramObject == null);
    for (int i = 0; ; i = paramObject.hashCode())
      return hashCode(i);
  }

  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    int i;
    int j;
    if (paramObject1 == null)
    {
      i = 0;
      j = 0;
      if (paramObject2 != null)
        break label26;
    }
    while (true)
    {
      return hashCode(i, j);
      i = paramObject1.hashCode();
      break;
      label26: j = paramObject2.hashCode();
    }
  }

  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    int i;
    int j;
    label13: int k;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null)
        break label37;
      j = 0;
      k = 0;
      if (paramObject3 != null)
        break label46;
    }
    while (true)
    {
      return hashCode(i, j, k);
      i = paramObject1.hashCode();
      break;
      label37: j = paramObject2.hashCode();
      break label13;
      label46: k = paramObject3.hashCode();
    }
  }

  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    int i;
    int j;
    label14: int k;
    label21: int m;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null)
        break label49;
      j = 0;
      if (paramObject3 != null)
        break label58;
      k = 0;
      m = 0;
      if (paramObject4 != null)
        break label67;
    }
    while (true)
    {
      return hashCode(i, j, k, m);
      i = paramObject1.hashCode();
      break;
      label49: j = paramObject2.hashCode();
      break label14;
      label58: k = paramObject3.hashCode();
      break label21;
      label67: m = paramObject4.hashCode();
    }
  }

  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5)
  {
    int i;
    int j;
    label14: int k;
    label21: int m;
    label28: int n;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null)
        break label59;
      j = 0;
      if (paramObject3 != null)
        break label68;
      k = 0;
      if (paramObject4 != null)
        break label77;
      m = 0;
      n = 0;
      if (paramObject5 != null)
        break label86;
    }
    while (true)
    {
      return hashCode(i, j, k, m, n);
      i = paramObject1.hashCode();
      break;
      label59: j = paramObject2.hashCode();
      break label14;
      label68: k = paramObject3.hashCode();
      break label21;
      label77: m = paramObject4.hashCode();
      break label28;
      label86: n = paramObject5.hashCode();
    }
  }

  public static int hashCode(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6)
  {
    int i;
    int j;
    label14: int k;
    label21: int m;
    label28: int n;
    label36: int i1;
    if (paramObject1 == null)
    {
      i = 0;
      if (paramObject2 != null)
        break label69;
      j = 0;
      if (paramObject3 != null)
        break label78;
      k = 0;
      if (paramObject4 != null)
        break label87;
      m = 0;
      if (paramObject5 != null)
        break label96;
      n = 0;
      i1 = 0;
      if (paramObject6 != null)
        break label106;
    }
    while (true)
    {
      return hashCode(i, j, k, m, n, i1);
      i = paramObject1.hashCode();
      break;
      label69: j = paramObject2.hashCode();
      break label14;
      label78: k = paramObject3.hashCode();
      break label21;
      label87: m = paramObject4.hashCode();
      break label28;
      label96: n = paramObject5.hashCode();
      break label36;
      label106: i1 = paramObject6.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.util.HashCodeUtil
 * JD-Core Version:    0.6.2
 */