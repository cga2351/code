package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.util.Iterator;
import java.util.List;

class f
{
  public static final int NOT_FOUND = -1;
  private final int[] a = new int['È'];
  private final int[] b = new int['È'];
  private int c = 0;
  private final int[] d = new int['È'];
  private final int[] e = new int['È'];
  private final NativeAd[] f = new NativeAd['È'];
  private int g = 0;

  private f(int[] paramArrayOfInt)
  {
    this.c = Math.min(paramArrayOfInt.length, 200);
    System.arraycopy(paramArrayOfInt, 0, this.b, 0, this.c);
    System.arraycopy(paramArrayOfInt, 0, this.a, 0, this.c);
  }

  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = a(paramArrayOfInt, 0, paramInt1, paramInt2);
    if (i < 0)
      return i ^ 0xFFFFFFFF;
    int j = paramArrayOfInt[i];
    while ((i >= 0) && (paramArrayOfInt[i] == j))
      i--;
    return i + 1;
  }

  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - 1;
    int j = paramInt1;
    while (j <= i)
    {
      int k = j + i >>> 1;
      int m = paramArrayOfInt[k];
      if (m < paramInt3)
        j = k + 1;
      else if (m > paramInt3)
        i = k - 1;
      else
        return k;
    }
    return j ^ 0xFFFFFFFF;
  }

  static f a()
  {
    return new f(new int[0]);
  }

  static f a(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    int i = 0;
    List localList = paramMoPubClientPositioning.a();
    int j = paramMoPubClientPositioning.b();
    if (j == 2147483647);
    int[] arrayOfInt;
    int m;
    for (int k = localList.size(); ; k = 200)
    {
      arrayOfInt = new int[k];
      Iterator localIterator = localList.iterator();
      m = 0;
      while (localIterator.hasNext())
      {
        m = ((Integer)localIterator.next()).intValue() - i;
        int i1 = i + 1;
        arrayOfInt[i] = m;
        i = i1;
      }
    }
    while (i < k)
    {
      m = -1 + (m + j);
      int n = i + 1;
      arrayOfInt[i] = m;
      i = n;
    }
    return new f(arrayOfInt);
  }

  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = a(paramArrayOfInt, 0, paramInt1, paramInt2);
    if (i < 0)
      i ^= -1;
    while (true)
    {
      return i;
      int j = paramArrayOfInt[i];
      while ((i < paramInt1) && (paramArrayOfInt[i] == j))
        i++;
    }
  }

  int a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt1 = new int[this.g];
    int[] arrayOfInt2 = new int[this.g];
    int i = 0;
    int j = 0;
    if (i < this.g)
    {
      int i2 = this.d[i];
      int i3 = this.e[i];
      if ((paramInt1 <= i3) && (i3 < paramInt2))
      {
        arrayOfInt1[j] = i2;
        arrayOfInt2[j] = (i3 - j);
        this.f[i].destroy();
        this.f[i] = null;
        j++;
      }
      while (true)
      {
        i++;
        break;
        if (j > 0)
        {
          int i4 = i - j;
          this.d[i4] = i2;
          this.e[i4] = (i3 - j);
          this.f[i4] = this.f[i];
        }
      }
    }
    if (j == 0)
      return 0;
    int k = arrayOfInt2[0];
    int m = a(this.b, this.c, k);
    int i1;
    for (int n = -1 + this.c; ; n--)
    {
      i1 = 0;
      if (n < m)
        break;
      this.a[(n + j)] = this.a[n];
      this.b[(n + j)] = (this.b[n] - j);
    }
    while (i1 < j)
    {
      this.a[(m + i1)] = arrayOfInt1[i1];
      this.b[(m + i1)] = arrayOfInt2[i1];
      i1++;
    }
    this.c = (j + this.c);
    this.g -= j;
    return j;
  }

  void a(int paramInt, NativeAd paramNativeAd)
  {
    int i = a(this.b, this.c, paramInt);
    if ((i == this.c) || (this.b[i] != paramInt))
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Attempted to insert an ad at an invalid position" });
    while (true)
    {
      return;
      int j = this.a[i];
      int k = b(this.d, this.g, j);
      if (k < this.g)
      {
        int i1 = this.g - k;
        System.arraycopy(this.d, k, this.d, k + 1, i1);
        System.arraycopy(this.e, k, this.e, k + 1, i1);
        System.arraycopy(this.f, k, this.f, k + 1, i1);
      }
      this.d[k] = j;
      this.e[k] = paramInt;
      this.f[k] = paramNativeAd;
      this.g = (1 + this.g);
      int m = -1 + (this.c - i);
      System.arraycopy(this.b, i + 1, this.b, i, m);
      System.arraycopy(this.a, i + 1, this.a, i, m);
      this.c = (-1 + this.c);
      while (i < this.c)
      {
        int[] arrayOfInt2 = this.b;
        arrayOfInt2[i] = (1 + arrayOfInt2[i]);
        i++;
      }
      for (int n = k + 1; n < this.g; n++)
      {
        int[] arrayOfInt1 = this.e;
        arrayOfInt1[n] = (1 + arrayOfInt1[n]);
      }
    }
  }

  boolean a(int paramInt)
  {
    int i = a(this.b, 0, this.c, paramInt);
    boolean bool = false;
    if (i >= 0)
      bool = true;
    return bool;
  }

  int b(int paramInt)
  {
    int i = b(this.b, this.c, paramInt);
    if (i == this.c)
      return -1;
    return this.b[i];
  }

  void b(int paramInt1, int paramInt2)
  {
    j(paramInt1);
    i(paramInt2);
  }

  int[] b()
  {
    int[] arrayOfInt = new int[this.g];
    System.arraycopy(this.e, 0, arrayOfInt, 0, this.g);
    return arrayOfInt;
  }

  void c()
  {
    if (this.g == 0)
      return;
    a(0, 1 + this.e[(-1 + this.g)]);
  }

  boolean c(int paramInt)
  {
    int i = a(this.e, 0, this.g, paramInt);
    boolean bool = false;
    if (i >= 0)
      bool = true;
    return bool;
  }

  NativeAd d(int paramInt)
  {
    int i = a(this.e, 0, this.g, paramInt);
    if (i < 0)
      return null;
    return this.f[i];
  }

  int e(int paramInt)
  {
    int i = a(this.e, 0, this.g, paramInt);
    if (i < 0)
      return paramInt - (i ^ 0xFFFFFFFF);
    return -1;
  }

  int f(int paramInt)
  {
    return paramInt + b(this.d, this.g, paramInt);
  }

  int g(int paramInt)
  {
    int i = -1;
    if (paramInt == 0)
      i = 0;
    int j;
    do
    {
      return i;
      j = e(paramInt - 1);
    }
    while (j == i);
    return j + 1;
  }

  int h(int paramInt)
  {
    if (paramInt == 0)
      return 0;
    return 1 + f(paramInt - 1);
  }

  void i(int paramInt)
  {
    for (int i = a(this.a, this.c, paramInt); i < this.c; i++)
    {
      int[] arrayOfInt3 = this.a;
      arrayOfInt3[i] = (1 + arrayOfInt3[i]);
      int[] arrayOfInt4 = this.b;
      arrayOfInt4[i] = (1 + arrayOfInt4[i]);
    }
    for (int j = a(this.d, this.g, paramInt); j < this.g; j++)
    {
      int[] arrayOfInt1 = this.d;
      arrayOfInt1[j] = (1 + arrayOfInt1[j]);
      int[] arrayOfInt2 = this.e;
      arrayOfInt2[j] = (1 + arrayOfInt2[j]);
    }
  }

  void j(int paramInt)
  {
    for (int i = b(this.a, this.c, paramInt); i < this.c; i++)
    {
      int[] arrayOfInt3 = this.a;
      arrayOfInt3[i] = (-1 + arrayOfInt3[i]);
      int[] arrayOfInt4 = this.b;
      arrayOfInt4[i] = (-1 + arrayOfInt4[i]);
    }
    for (int j = b(this.d, this.g, paramInt); j < this.g; j++)
    {
      int[] arrayOfInt1 = this.d;
      arrayOfInt1[j] = (-1 + arrayOfInt1[j]);
      int[] arrayOfInt2 = this.e;
      arrayOfInt2[j] = (-1 + arrayOfInt2[j]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.f
 * JD-Core Version:    0.6.2
 */