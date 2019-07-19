package com.google.android.exoplayer2.g;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class p
{
  public static final byte[] a = { 0, 0, 0, 1 };
  public static final float[] b = { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
  private static final Object c = new Object();
  private static int[] d = new int[10];

  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = c;
    int i = 0;
    int j = 0;
    if (j < paramInt);
    while (true)
    {
      int i5;
      try
      {
        i5 = c(paramArrayOfByte, j, paramInt);
        if (i5 < paramInt)
        {
          if (d.length <= i)
            d = Arrays.copyOf(d, 2 * d.length);
          int[] arrayOfInt = d;
          int i6 = i + 1;
          arrayOfInt[i] = i5;
          int i7 = i5 + 3;
          i = i6;
          j = i7;
          break;
          if (m < i)
          {
            int i2 = d[m] - i1;
            System.arraycopy(paramArrayOfByte, i1, paramArrayOfByte, n, i2);
            int i3 = n + i2;
            int i4 = i3 + 1;
            paramArrayOfByte[i3] = 0;
            n = i4 + 1;
            paramArrayOfByte[i4] = 0;
            i1 += i2 + 3;
            m++;
            continue;
          }
          System.arraycopy(paramArrayOfByte, i1, paramArrayOfByte, n, k - n);
          return k;
        }
      }
      finally
      {
      }
      j = i5;
      break;
      int k = paramInt - i;
      int m = 0;
      int n = 0;
      int i1 = 0;
    }
  }

  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    int i = 1;
    int j = paramInt2 - paramInt1;
    if (j >= 0)
    {
      int k = i;
      a.b(k);
      if (j != 0)
        break label35;
    }
    label35: 
    do
    {
      return paramInt2;
      int m = 0;
      break;
      if (paramArrayOfBoolean != null)
      {
        if (paramArrayOfBoolean[0] != 0)
        {
          a(paramArrayOfBoolean);
          return paramInt1 - 3;
        }
        if ((j > i) && (paramArrayOfBoolean[i] != 0) && (paramArrayOfByte[paramInt1] == i))
        {
          a(paramArrayOfBoolean);
          return paramInt1 - 2;
        }
        if ((j > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == i))
        {
          a(paramArrayOfBoolean);
          return paramInt1 - 1;
        }
      }
      int n = paramInt2 - 1;
      int i1 = paramInt1 + 2;
      if (i1 < n)
      {
        if ((0xFE & paramArrayOfByte[i1]) != 0);
        while (true)
        {
          i1 += 3;
          break;
          if ((paramArrayOfByte[(i1 - 2)] == 0) && (paramArrayOfByte[(i1 - 1)] == 0) && (paramArrayOfByte[i1] == i))
          {
            if (paramArrayOfBoolean != null)
              a(paramArrayOfBoolean);
            return i1 - 2;
          }
          i1 -= 2;
        }
      }
    }
    while (paramArrayOfBoolean == null);
    int i2;
    int i3;
    if (j > 2)
      if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == i))
      {
        i2 = i;
        paramArrayOfBoolean[0] = i2;
        if (j <= i)
          break label377;
        if ((paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 0))
          break label371;
        i3 = i;
        label271: paramArrayOfBoolean[i] = i3;
        if (paramArrayOfByte[(paramInt2 - 1)] != 0)
          break label404;
      }
    while (true)
    {
      paramArrayOfBoolean[2] = i;
      return paramInt2;
      i2 = 0;
      break;
      if (j == 2)
      {
        if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == i))
        {
          i2 = i;
          break;
        }
        i2 = 0;
        break;
      }
      if ((paramArrayOfBoolean[i] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == i))
      {
        i2 = i;
        break;
      }
      i2 = 0;
      break;
      label371: i3 = 0;
      break label271;
      label377: if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 0))
      {
        i3 = i;
        break label271;
      }
      i3 = 0;
      break label271;
      label404: i = 0;
    }
  }

  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    s locals = new s(paramArrayOfByte, paramInt1, paramInt2);
    locals.a(8);
    int i = locals.c(8);
    int j = locals.c(8);
    int k = locals.c(8);
    int m = locals.d();
    label175: label219: label226: boolean bool2;
    int i1;
    if ((i == 100) || (i == 110) || (i == 122) || (i == 244) || (i == 44) || (i == 83) || (i == 86) || (i == 118) || (i == 128) || (i == 138))
    {
      int n = locals.d();
      boolean bool1 = false;
      if (n == 3)
        bool1 = locals.b();
      locals.d();
      locals.d();
      locals.a();
      if (locals.b())
      {
        int i25;
        int i26;
        if (n != 3)
        {
          i25 = 8;
          i26 = 0;
          if (i26 >= i25)
            break label226;
          if (locals.b())
            if (i26 >= 6)
              break label219;
        }
        for (int i27 = 16; ; i27 = 64)
        {
          a(locals, i27);
          i26++;
          break label175;
          i25 = 12;
          break;
        }
      }
      bool2 = bool1;
      i1 = n;
    }
    while (true)
    {
      int i2 = 4 + locals.d();
      int i3 = locals.d();
      boolean bool3 = false;
      int i4;
      boolean bool5;
      int i8;
      label303: int i10;
      int i11;
      int i20;
      int i24;
      label386: int i23;
      int i12;
      if (i3 == 0)
      {
        i4 = 4 + locals.d();
        locals.d();
        locals.a();
        int i6 = 1 + locals.d();
        int i7 = 1 + locals.d();
        bool5 = locals.b();
        if (!bool5)
          break label589;
        i8 = 1;
        int i9 = i7 * (2 - i8);
        if (!bool5)
          locals.a();
        locals.a();
        i10 = i6 * 16;
        i11 = i9 * 16;
        if (!locals.b())
          break label709;
        int i16 = locals.d();
        int i17 = locals.d();
        int i18 = locals.d();
        int i19 = locals.d();
        if (i1 != 0)
          break label601;
        i20 = 1;
        if (!bool5)
          break label595;
        i24 = 1;
        i23 = 2 - i24;
        i12 = i10 - i20 * (i16 + i17);
        i11 -= i23 * (i18 + i19);
      }
      while (true)
      {
        float f1 = 1.0F;
        int i13;
        float f2;
        if ((locals.b()) && (locals.b()))
        {
          i13 = locals.c(8);
          if (i13 == 255)
          {
            int i14 = locals.c(16);
            int i15 = locals.c(16);
            if ((i14 != 0) && (i15 != 0))
              f1 = i14 / i15;
            f2 = f1;
          }
        }
        while (true)
        {
          return new b(i, j, k, m, i12, i11, f2, bool2, bool5, i2, i3, i4, bool3);
          i4 = 0;
          bool3 = false;
          if (i3 != 1)
            break;
          bool3 = locals.b();
          locals.e();
          locals.e();
          long l = locals.d();
          for (int i5 = 0; ; i5++)
          {
            boolean bool4 = i5 < l;
            i4 = 0;
            if (!bool4)
              break;
            locals.d();
          }
          label589: i8 = 0;
          break label303;
          label595: i24 = 0;
          break label386;
          label601: label610: int i21;
          if (i1 == 3)
          {
            i20 = 1;
            if (i1 != 1)
              break label645;
            i21 = 2;
            label619: if (!bool5)
              break label651;
          }
          label645: label651: for (int i22 = 1; ; i22 = 0)
          {
            i23 = i21 * (2 - i22);
            break;
            i20 = 2;
            break label610;
            i21 = 1;
            break label619;
          }
          if (i13 < b.length)
          {
            f2 = b[i13];
          }
          else
          {
            l.c("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + i13);
            f2 = f1;
          }
        }
        label709: i12 = i10;
      }
      i1 = 1;
      bool2 = false;
    }
  }

  private static void a(s params, int paramInt)
  {
    int i = 8;
    int j = 0;
    int k = i;
    if (j < paramInt)
    {
      if (i != 0)
        i = (256 + (k + params.e())) % 256;
      if (i == 0);
      while (true)
      {
        j++;
        break;
        k = i;
      }
    }
  }

  public static void a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = 0;
    int k = 0;
    while (j + 1 < i)
    {
      int m = 0xFF & paramByteBuffer.get(j);
      if (k == 3)
      {
        if ((m == 1) && ((0x1F & paramByteBuffer.get(j + 1)) == 7))
        {
          ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
          localByteBuffer.position(j - 3);
          localByteBuffer.limit(i);
          paramByteBuffer.position(0);
          paramByteBuffer.put(localByteBuffer);
        }
      }
      else if (m == 0)
        k++;
      if (m != 0)
        k = 0;
      j++;
    }
    paramByteBuffer.clear();
  }

  public static void a(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }

  public static boolean a(String paramString, byte paramByte)
  {
    return (("video/avc".equals(paramString)) && ((paramByte & 0x1F) == 6)) || (("video/hevc".equals(paramString)) && ((paramByte & 0x7E) >> 1 == 39));
  }

  public static int b(byte[] paramArrayOfByte, int paramInt)
  {
    return 0x1F & paramArrayOfByte[(paramInt + 3)];
  }

  public static a b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    s locals = new s(paramArrayOfByte, paramInt1, paramInt2);
    locals.a(8);
    int i = locals.d();
    int j = locals.d();
    locals.a();
    return new a(i, j, locals.b());
  }

  public static int c(byte[] paramArrayOfByte, int paramInt)
  {
    return (0x7E & paramArrayOfByte[(paramInt + 3)]) >> 1;
  }

  private static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; ; i++)
      if (i < paramInt2 - 2)
      {
        if ((paramArrayOfByte[i] == 0) && (paramArrayOfByte[(i + 1)] == 0) && (paramArrayOfByte[(i + 2)] == 3))
          paramInt2 = i;
      }
      else
        return paramInt2;
  }

  public static final class a
  {
    public final int a;
    public final int b;
    public final boolean c;

    public a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramBoolean;
    }
  }

  public static final class b
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final boolean m;

    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramFloat;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
      this.j = paramInt7;
      this.k = paramInt8;
      this.l = paramInt9;
      this.m = paramBoolean3;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.p
 * JD-Core Version:    0.6.2
 */