package com.crashlytics.android.c;

import java.util.HashMap;
import java.util.Map;

class ao
  implements av
{
  private final int a;

  public ao()
  {
    this(1);
  }

  public ao(int paramInt)
  {
    this.a = paramInt;
  }

  private static boolean a(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (paramInt2 + i > paramArrayOfStackTraceElement.length)
      return false;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label47;
      if (!paramArrayOfStackTraceElement[(paramInt1 + j)].equals(paramArrayOfStackTraceElement[(paramInt2 + j)]))
        break;
    }
    label47: return true;
  }

  private static StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StackTraceElement[] arrayOfStackTraceElement1 = new StackTraceElement[paramArrayOfStackTraceElement.length];
    int i = 0;
    int j = 1;
    int k = 0;
    if (i < paramArrayOfStackTraceElement.length)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      Integer localInteger = (Integer)localHashMap.get(localStackTraceElement);
      int m;
      if ((localInteger == null) || (!a(paramArrayOfStackTraceElement, localInteger.intValue(), i)))
      {
        arrayOfStackTraceElement1[k] = paramArrayOfStackTraceElement[i];
        k++;
        m = i;
        j = 1;
      }
      while (true)
      {
        localHashMap.put(localStackTraceElement, Integer.valueOf(i));
        i = m + 1;
        break;
        int n = i - localInteger.intValue();
        if (j < paramInt)
        {
          System.arraycopy(paramArrayOfStackTraceElement, i, arrayOfStackTraceElement1, k, n);
          k += n;
          j++;
        }
        m = i + (n - 1);
      }
    }
    StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[k];
    System.arraycopy(arrayOfStackTraceElement1, 0, arrayOfStackTraceElement2, 0, arrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement2;
  }

  public StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StackTraceElement[] arrayOfStackTraceElement = a(paramArrayOfStackTraceElement, this.a);
    if (arrayOfStackTraceElement.length < paramArrayOfStackTraceElement.length)
      paramArrayOfStackTraceElement = arrayOfStackTraceElement;
    return paramArrayOfStackTraceElement;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.ao
 * JD-Core Version:    0.6.2
 */