package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@KeepForSdk
@VisibleForTesting
public final class ArrayUtils
{
  @KeepForSdk
  public static <T> T[] appendToArray(T[] paramArrayOfT, T paramT)
  {
    if ((paramArrayOfT == null) && (paramT == null))
      throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
    if (paramArrayOfT == null);
    for (Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), 1); ; arrayOfObject = Arrays.copyOf(paramArrayOfT, 1 + paramArrayOfT.length))
    {
      arrayOfObject[(-1 + arrayOfObject.length)] = paramT;
      return arrayOfObject;
    }
  }

  @KeepForSdk
  public static <T> T[] concat(T[][] paramArrayOfT)
  {
    if (paramArrayOfT.length == 0)
      return (Object[])Array.newInstance(paramArrayOfT.getClass(), 0);
    int i = 0;
    int j = 0;
    while (i < paramArrayOfT.length)
    {
      j += paramArrayOfT[i].length;
      i++;
    }
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfT[0], j);
    int k = paramArrayOfT[0].length;
    for (int m = 1; m < paramArrayOfT.length; m++)
    {
      T[] arrayOfT = paramArrayOfT[m];
      System.arraycopy(arrayOfT, 0, arrayOfObject, k, arrayOfT.length);
      k += arrayOfT.length;
    }
    return arrayOfObject;
  }

  @KeepForSdk
  public static byte[] concatByteArrays(byte[][] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0)
      return new byte[0];
    int i = 0;
    int j = 0;
    while (i < paramArrayOfByte.length)
    {
      j += paramArrayOfByte[i].length;
      i++;
    }
    byte[] arrayOfByte1 = Arrays.copyOf(paramArrayOfByte[0], j);
    int k = paramArrayOfByte[0].length;
    for (int m = 1; m < paramArrayOfByte.length; m++)
    {
      byte[] arrayOfByte2 = paramArrayOfByte[m];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, k, arrayOfByte2.length);
      k += arrayOfByte2.length;
    }
    return arrayOfByte1;
  }

  @KeepForSdk
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null);
    while (true)
    {
      return false;
      int i = paramArrayOfInt.length;
      for (int j = 0; j < i; j++)
        if (paramArrayOfInt[j] == paramInt)
          return true;
    }
  }

  @KeepForSdk
  public static <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    int i;
    int j;
    if (paramArrayOfT != null)
    {
      i = paramArrayOfT.length;
      j = 0;
      label9: if (j >= i)
        break label52;
      if (!Objects.equal(paramArrayOfT[j], paramT))
        break label46;
    }
    label46: label52: for (int k = j; ; k = -1)
    {
      boolean bool = false;
      if (k >= 0)
        bool = true;
      return bool;
      i = 0;
      break;
      j++;
      break label9;
    }
  }

  @KeepForSdk
  public static <T> ArrayList<T> newArrayList()
  {
    return new ArrayList();
  }

  @KeepForSdk
  public static <T> T[] removeAll(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int i = 0;
    if (paramArrayOfT1 == null)
    {
      localObject = null;
      return localObject;
    }
    if ((paramArrayOfT2 == null) || (paramArrayOfT2.length == 0))
      return Arrays.copyOf(paramArrayOfT1, paramArrayOfT1.length);
    Object localObject = (Object[])Array.newInstance(paramArrayOfT2.getClass().getComponentType(), paramArrayOfT1.length);
    int i1;
    int k;
    label58: int i2;
    if (paramArrayOfT2.length == 1)
    {
      int n = paramArrayOfT1.length;
      i1 = 0;
      k = 0;
      if (i1 >= n)
        break label153;
      T ? = paramArrayOfT1[i1];
      if (Objects.equal(paramArrayOfT2[0], ?))
        break label180;
      i2 = k + 1;
      localObject[k] = ?;
    }
    while (true)
    {
      i1++;
      k = i2;
      break label58;
      int j = paramArrayOfT1.length;
      k = 0;
      label111: int m;
      if (i < j)
      {
        T ? = paramArrayOfT1[i];
        if (contains(paramArrayOfT2, ?))
          break label173;
        m = k + 1;
        localObject[k] = ?;
      }
      while (true)
      {
        i++;
        k = m;
        break label111;
        label153: if (localObject == null)
          return null;
        if (k == localObject.length)
          break;
        return Arrays.copyOf((Object[])localObject, k);
        label173: m = k;
      }
      label180: i2 = k;
    }
  }

  @KeepForSdk
  public static <T> ArrayList<T> toArrayList(T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++)
      localArrayList.add(paramArrayOfT[j]);
    return localArrayList;
  }

  @KeepForSdk
  public static int[] toPrimitiveArray(Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.size() == 0))
      return new int[0];
    int[] arrayOfInt = new int[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Integer localInteger = (Integer)localIterator.next();
      j = i + 1;
      arrayOfInt[i] = localInteger.intValue();
    }
    return arrayOfInt;
  }

  @KeepForSdk
  public static Integer[] toWrapperArray(int[] paramArrayOfInt)
  {
    Integer[] arrayOfInteger;
    if (paramArrayOfInt == null)
      arrayOfInteger = null;
    while (true)
    {
      return arrayOfInteger;
      int i = paramArrayOfInt.length;
      arrayOfInteger = new Integer[i];
      for (int j = 0; j < i; j++)
        arrayOfInteger[j] = Integer.valueOf(paramArrayOfInt[j]);
    }
  }

  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Double.toString(paramArrayOfDouble[j]));
    }
  }

  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, float[] paramArrayOfFloat)
  {
    int i = paramArrayOfFloat.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Float.toString(paramArrayOfFloat[j]));
    }
  }

  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Integer.toString(paramArrayOfInt[j]));
    }
  }

  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, long[] paramArrayOfLong)
  {
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Long.toString(paramArrayOfLong[j]));
    }
  }

  @KeepForSdk
  public static <T> void writeArray(StringBuilder paramStringBuilder, T[] paramArrayOfT)
  {
    int i = paramArrayOfT.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(paramArrayOfT[j].toString());
    }
  }

  @KeepForSdk
  public static void writeArray(StringBuilder paramStringBuilder, boolean[] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append(Boolean.toString(paramArrayOfBoolean[j]));
    }
  }

  @KeepForSdk
  public static void writeStringArray(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      if (j != 0)
        paramStringBuilder.append(",");
      paramStringBuilder.append("\"").append(paramArrayOfString[j]).append("\"");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.ArrayUtils
 * JD-Core Version:    0.6.2
 */