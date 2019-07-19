package com.google.android.exoplayer2.video.a;

import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.util.ArrayList;
import java.util.zip.Inflater;

public final class e
{
  private static final int a = ag.g("ytmp");
  private static final int b = ag.g("mshp");
  private static final int c = ag.g("raw ");
  private static final int d = ag.g("dfl8");
  private static final int e = ag.g("mesh");
  private static final int f = ag.g("proj");

  private static int a(int paramInt)
  {
    return paramInt >> 1 ^ -(paramInt & 0x1);
  }

  public static d a(byte[] paramArrayOfByte, int paramInt)
  {
    r localr = new r(paramArrayOfByte);
    Object localObject2;
    Object localObject1;
    try
    {
      if (a(localr))
      {
        localObject2 = b(localr);
      }
      else
      {
        ArrayList localArrayList = c(localr);
        localObject2 = localArrayList;
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      localObject1 = null;
    }
    do
    {
      switch (localObject1.size())
      {
      default:
        return null;
      case 1:
        return new d((d.a)localObject1.get(0), paramInt);
      case 2:
      }
      return new d((d.a)localObject1.get(0), (d.a)localObject1.get(1), paramInt);
      localObject1 = localObject2;
    }
    while (localObject1 != null);
    return null;
  }

  private static boolean a(r paramr)
  {
    paramr.d(4);
    int i = paramr.p();
    paramr.c(0);
    int j = f;
    boolean bool = false;
    if (i == j)
      bool = true;
    return bool;
  }

  private static ArrayList<d.a> b(r paramr)
  {
    paramr.d(8);
    int i = paramr.d();
    int j = paramr.c();
    while (true)
    {
      int k;
      if (i < j)
      {
        k = i + paramr.p();
        if ((k > i) && (k <= j));
      }
      else
      {
        return null;
      }
      int m = paramr.p();
      if ((m == a) || (m == b))
      {
        paramr.b(k);
        return c(paramr);
      }
      paramr.c(k);
      i = k;
    }
  }

  private static ArrayList<d.a> c(r paramr)
  {
    if (paramr.h() != 0)
      return null;
    paramr.d(7);
    int i = paramr.p();
    if (i == d)
    {
      localr = new r();
      localInflater = new Inflater(true);
    }
    while (i == c)
      try
      {
        r localr;
        boolean bool = ag.a(paramr, localr, localInflater);
        if (!bool)
          return null;
        localInflater.end();
        paramr = localr;
        return d(paramr);
      }
      finally
      {
        Inflater localInflater;
        localInflater.end();
      }
    return null;
  }

  private static ArrayList<d.a> d(r paramr)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramr.d();
    int j = paramr.c();
    while (i < j)
    {
      int k = i + paramr.p();
      if ((k <= i) || (k > j));
      d.a locala;
      do
      {
        return null;
        if (paramr.p() != e)
          break;
        locala = e(paramr);
      }
      while (locala == null);
      localArrayList.add(locala);
      paramr.c(k);
      i = k;
    }
    return localArrayList;
  }

  private static d.a e(r paramr)
  {
    int i = paramr.p();
    if (i > 10000)
      return null;
    float[] arrayOfFloat1 = new float[i];
    for (int j = 0; j < i; j++)
      arrayOfFloat1[j] = paramr.y();
    int k = paramr.p();
    if (k > 32000)
      return null;
    double d1 = Math.log(2.0D);
    int m = (int)Math.ceil(Math.log(2.0D * i) / d1);
    q localq = new q(paramr.a);
    localq.a(8 * paramr.d());
    float[] arrayOfFloat2 = new float[k * 5];
    int[] arrayOfInt = new int[5];
    int n = 0;
    for (int i1 = 0; i1 < k; i1++)
    {
      int i10 = 0;
      while (i10 < 5)
      {
        int i11 = arrayOfInt[i10] + a(localq.c(m));
        if ((i11 >= i) || (i11 < 0))
          return null;
        int i12 = n + 1;
        arrayOfFloat2[n] = arrayOfFloat1[i11];
        arrayOfInt[i10] = i11;
        i10++;
        n = i12;
      }
    }
    localq.a(0xFFFFFFF8 & 7 + localq.b());
    int i2 = localq.c(32);
    d.b[] arrayOfb = new d.b[i2];
    for (int i3 = 0; i3 < i2; i3++)
    {
      int i4 = localq.c(8);
      int i5 = localq.c(8);
      int i6 = localq.c(32);
      if (i6 > 128000)
        return null;
      int i7 = (int)Math.ceil(Math.log(2.0D * k) / d1);
      int i8 = 0;
      float[] arrayOfFloat3 = new float[i6 * 3];
      float[] arrayOfFloat4 = new float[i6 * 2];
      for (int i9 = 0; i9 < i6; i9++)
      {
        i8 += a(localq.c(i7));
        if ((i8 < 0) || (i8 >= k))
          return null;
        arrayOfFloat3[(i9 * 3)] = arrayOfFloat2[(i8 * 5)];
        arrayOfFloat3[(1 + i9 * 3)] = arrayOfFloat2[(1 + i8 * 5)];
        arrayOfFloat3[(2 + i9 * 3)] = arrayOfFloat2[(2 + i8 * 5)];
        arrayOfFloat4[(i9 * 2)] = arrayOfFloat2[(3 + i8 * 5)];
        arrayOfFloat4[(1 + i9 * 2)] = arrayOfFloat2[(4 + i8 * 5)];
      }
      arrayOfb[i3] = new d.b(i4, arrayOfFloat3, arrayOfFloat4, i5);
    }
    return new d.a(arrayOfb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.video.a.e
 * JD-Core Version:    0.6.2
 */