package com.c.a.a.c;

import com.c.a.a.d.a;
import com.c.a.a.k;
import com.c.a.a.l;
import com.c.a.a.m;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class f extends b
{
  static final byte[] m = com.c.a.a.b.b.h();
  private static final byte[] v = { 110, 117, 108, 108 };
  private static final byte[] w = { 116, 114, 117, 101 };
  private static final byte[] x = { 102, 97, 108, 115, 101 };
  protected final OutputStream n;
  protected byte[] o;
  protected int p = 0;
  protected final int q;
  protected final int r;
  protected char[] s;
  protected final int t;
  protected boolean u;

  public f(com.c.a.a.b.d paramd, int paramInt, k paramk, OutputStream paramOutputStream)
  {
    super(paramd, paramInt, paramk);
    this.n = paramOutputStream;
    this.u = true;
    this.o = paramd.f();
    this.q = this.o.length;
    this.r = (this.q >> 3);
    this.s = paramd.h();
    this.t = this.s.length;
    if (a(d.a.g))
      a(127);
  }

  private int a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException
  {
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      if (paramInt2 >= paramInt3)
        e("Split surrogate on writeRaw() input (last character)");
      a(paramInt1, paramArrayOfChar[paramInt2]);
      return paramInt2 + 1;
    }
    byte[] arrayOfByte = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte[i] = ((byte)(0xE0 | paramInt1 >> 12));
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte[j] = ((byte)(0x80 | 0x3F & paramInt1 >> 6));
    int k = this.p;
    this.p = (k + 1);
    arrayOfByte[k] = ((byte)(0x80 | paramInt1 & 0x3F));
    return paramInt2;
  }

  private int a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IOException, com.c.a.a.c
  {
    int i = paramArrayOfByte2.length;
    int j;
    if (paramInt1 + i > paramInt2)
    {
      this.p = paramInt1;
      k();
      j = this.p;
      if (i > paramArrayOfByte1.length)
        this.n.write(paramArrayOfByte2, 0, i);
    }
    while (true)
    {
      return j;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, j, i);
      j += i;
      while (j + paramInt3 * 6 > paramInt2)
      {
        k();
        return this.p;
        j = paramInt1;
      }
    }
  }

  private int a(byte[] paramArrayOfByte, int paramInt1, m paramm, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    byte[] arrayOfByte = paramm.b();
    int i = arrayOfByte.length;
    if (i > 6)
      return a(paramArrayOfByte, paramInt1, this.q, arrayOfByte, paramInt2);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt1, i);
    return i + paramInt1;
  }

  private void a(Object paramObject)
    throws IOException
  {
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    c(paramObject.toString());
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte2 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte2[j] = 34;
  }

  private final void a(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (i + this.p > this.q)
    {
      k();
      if (i > 512)
      {
        this.n.write(paramArrayOfByte, 0, i);
        return;
      }
    }
    System.arraycopy(paramArrayOfByte, 0, this.o, this.p, i);
    this.p = (i + this.p);
  }

  private void b(long paramLong)
    throws IOException
  {
    if (23 + this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    this.p = com.c.a.a.b.i.a(paramLong, this.o, this.p);
    byte[] arrayOfByte2 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte2[j] = 34;
  }

  private void b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    d(this.s, 0, paramInt2);
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte2 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte2[j] = 34;
  }

  private int c(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = this.o;
    if ((paramInt1 >= 55296) && (paramInt1 <= 57343))
    {
      int i1 = paramInt2 + 1;
      arrayOfByte[paramInt2] = 92;
      int i2 = i1 + 1;
      arrayOfByte[i1] = 117;
      int i3 = i2 + 1;
      arrayOfByte[i2] = m[(0xF & paramInt1 >> 12)];
      int i4 = i3 + 1;
      arrayOfByte[i3] = m[(0xF & paramInt1 >> 8)];
      int i5 = i4 + 1;
      arrayOfByte[i4] = m[(0xF & paramInt1 >> 4)];
      int i6 = i5 + 1;
      arrayOfByte[i5] = m[(paramInt1 & 0xF)];
      return i6;
    }
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = ((byte)(0xE0 | paramInt1 >> 12));
    int j = i + 1;
    arrayOfByte[i] = ((byte)(0x80 | 0x3F & paramInt1 >> 6));
    int k = j + 1;
    arrayOfByte[j] = ((byte)(0x80 | paramInt1 & 0x3F));
    return k;
  }

  private void c(int paramInt)
    throws IOException
  {
    if (13 + this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    this.p = com.c.a.a.b.i.a(paramInt, this.o, this.p);
    byte[] arrayOfByte2 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte2[j] = 34;
  }

  private final void c(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    int i = this.q;
    byte[] arrayOfByte = this.o;
    int j = paramInt1;
    label21: int k;
    int i2;
    int i3;
    if (j < paramInt2)
    {
      k = paramArrayOfChar[j];
      if (k >= 128)
      {
        if (3 + this.p >= this.q)
          k();
        i2 = j + 1;
        i3 = paramArrayOfChar[j];
        if (i3 >= 2048)
          break label182;
        int i4 = this.p;
        this.p = (i4 + 1);
        arrayOfByte[i4] = ((byte)(0xC0 | i3 >> 6));
        int i5 = this.p;
        this.p = (i5 + 1);
        arrayOfByte[i5] = ((byte)(0x80 | i3 & 0x3F));
      }
    }
    while (true)
    {
      j = i2;
      break;
      if (this.p >= i)
        k();
      int i1 = this.p;
      this.p = (i1 + 1);
      arrayOfByte[i1] = ((byte)k);
      j++;
      if (j < paramInt2)
        break label21;
      return;
      label182: a(i3, paramArrayOfChar, i2, paramInt2);
    }
  }

  private int d(int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte = this.o;
    int i = paramInt2 + 1;
    arrayOfByte[paramInt2] = 92;
    int j = i + 1;
    arrayOfByte[i] = 117;
    int i1;
    if (paramInt1 > 255)
    {
      int i4 = 0xFF & paramInt1 >> 8;
      int i5 = j + 1;
      arrayOfByte[j] = m[(i4 >> 4)];
      i1 = i5 + 1;
      arrayOfByte[i5] = m[(i4 & 0xF)];
      paramInt1 &= 255;
    }
    while (true)
    {
      int i2 = i1 + 1;
      arrayOfByte[i1] = m[(paramInt1 >> 4)];
      int i3 = i2 + 1;
      arrayOfByte[i2] = m[(paramInt1 & 0xF)];
      return i3;
      int k = j + 1;
      arrayOfByte[j] = 48;
      i1 = k + 1;
      arrayOfByte[k] = 48;
    }
  }

  private final void d(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    do
    {
      int i = Math.min(this.r, paramInt2);
      if (i + this.p > this.q)
        k();
      e(paramArrayOfChar, paramInt1, i);
      paramInt1 += i;
      paramInt2 -= i;
    }
    while (paramInt2 > 0);
  }

  private final void e(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    int i = paramInt2 + paramInt1;
    int j = this.p;
    byte[] arrayOfByte = this.o;
    int[] arrayOfInt = this.i;
    while (true)
    {
      int k;
      if (paramInt1 < i)
      {
        k = paramArrayOfChar[paramInt1];
        if ((k <= 127) && (arrayOfInt[k] == 0));
      }
      else
      {
        this.p = j;
        if (paramInt1 < i)
        {
          if (this.k == null)
            break;
          h(paramArrayOfChar, paramInt1, i);
        }
        return;
      }
      int i1 = j + 1;
      arrayOfByte[j] = ((byte)k);
      paramInt1++;
      j = i1;
    }
    if (this.j == 0)
    {
      f(paramArrayOfChar, paramInt1, i);
      return;
    }
    g(paramArrayOfChar, paramInt1, i);
  }

  private final void f(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    if (this.p + 6 * (paramInt2 - paramInt1) > this.q)
      k();
    int i = this.p;
    byte[] arrayOfByte = this.o;
    int[] arrayOfInt = this.i;
    while (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      int k = paramArrayOfChar[paramInt1];
      if (k <= 127)
      {
        if (arrayOfInt[k] == 0)
        {
          int i4 = i + 1;
          arrayOfByte[i] = ((byte)k);
          i = i4;
          paramInt1 = j;
        }
        else
        {
          int i2 = arrayOfInt[k];
          if (i2 > 0)
          {
            int i3 = i + 1;
            arrayOfByte[i] = 92;
            i = i3 + 1;
            arrayOfByte[i3] = ((byte)i2);
            paramInt1 = j;
          }
          else
          {
            i = d(k, i);
            paramInt1 = j;
          }
        }
      }
      else
      {
        if (k <= 2047)
        {
          int i1 = i + 1;
          arrayOfByte[i] = ((byte)(0xC0 | k >> 6));
          i = i1 + 1;
          arrayOfByte[i1] = ((byte)(0x80 | k & 0x3F));
        }
        while (true)
        {
          paramInt1 = j;
          break;
          i = c(k, i);
        }
      }
    }
    this.p = i;
  }

  private void g(String paramString)
    throws IOException, com.c.a.a.c
  {
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    h(paramString);
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte2 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte2[j] = 34;
  }

  private final void g(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    if (this.p + 6 * (paramInt2 - paramInt1) > this.q)
      k();
    int i = this.p;
    byte[] arrayOfByte = this.o;
    int[] arrayOfInt = this.i;
    int j = this.j;
    while (paramInt1 < paramInt2)
    {
      int k = paramInt1 + 1;
      int i1 = paramArrayOfChar[paramInt1];
      if (i1 <= 127)
      {
        if (arrayOfInt[i1] == 0)
        {
          int i5 = i + 1;
          arrayOfByte[i] = ((byte)i1);
          i = i5;
          paramInt1 = k;
        }
        else
        {
          int i3 = arrayOfInt[i1];
          if (i3 > 0)
          {
            int i4 = i + 1;
            arrayOfByte[i] = 92;
            i = i4 + 1;
            arrayOfByte[i4] = ((byte)i3);
            paramInt1 = k;
          }
          else
          {
            i = d(i1, i);
            paramInt1 = k;
          }
        }
      }
      else if (i1 > j)
      {
        i = d(i1, i);
        paramInt1 = k;
      }
      else
      {
        if (i1 <= 2047)
        {
          int i2 = i + 1;
          arrayOfByte[i] = ((byte)(0xC0 | i1 >> 6));
          i = i2 + 1;
          arrayOfByte[i2] = ((byte)(0x80 | i1 & 0x3F));
        }
        while (true)
        {
          paramInt1 = k;
          break;
          i = c(i1, i);
        }
      }
    }
    this.p = i;
  }

  private final void h(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = paramString.length();
    char[] arrayOfChar = this.s;
    int j = i;
    int k = 0;
    while (j > 0)
    {
      int i1 = Math.min(this.r, j);
      paramString.getChars(k, k + i1, arrayOfChar, 0);
      if (i1 + this.p > this.q)
        k();
      e(arrayOfChar, 0, i1);
      k += i1;
      j -= i1;
    }
  }

  private void h(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    if (this.p + 6 * (paramInt2 - paramInt1) > this.q)
      k();
    int i = this.p;
    byte[] arrayOfByte = this.o;
    int[] arrayOfInt = this.i;
    int j;
    com.c.a.a.b.c localc;
    if (this.j <= 0)
    {
      j = 65535;
      localc = this.k;
    }
    while (true)
      if (paramInt1 < paramInt2)
      {
        int k = paramInt1 + 1;
        int i1 = paramArrayOfChar[paramInt1];
        if (i1 <= 127)
        {
          if (arrayOfInt[i1] == 0)
          {
            int i5 = i + 1;
            arrayOfByte[i] = ((byte)i1);
            i = i5;
            paramInt1 = k;
            continue;
            j = this.j;
            break;
          }
          int i3 = arrayOfInt[i1];
          if (i3 > 0)
          {
            int i4 = i + 1;
            arrayOfByte[i] = 92;
            i = i4 + 1;
            arrayOfByte[i4] = ((byte)i3);
            paramInt1 = k;
            continue;
          }
          if (i3 == -2)
          {
            m localm2 = localc.a(i1);
            if (localm2 == null)
              e("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(i1) + ", although was supposed to have one");
            i = a(arrayOfByte, i, localm2, paramInt2 - k);
            paramInt1 = k;
            continue;
          }
          i = d(i1, i);
          paramInt1 = k;
          continue;
        }
        if (i1 > j)
        {
          i = d(i1, i);
          paramInt1 = k;
        }
        else
        {
          m localm1 = localc.a(i1);
          if (localm1 != null)
          {
            i = a(arrayOfByte, i, localm1, paramInt2 - k);
            paramInt1 = k;
          }
          else
          {
            if (i1 <= 2047)
            {
              int i2 = i + 1;
              arrayOfByte[i] = ((byte)(0xC0 | i1 >> 6));
              i = i2 + 1;
              arrayOfByte[i2] = ((byte)(0x80 | i1 & 0x3F));
            }
            while (true)
            {
              paramInt1 = k;
              break;
              i = c(i1, i);
            }
          }
        }
      }
    this.p = i;
  }

  private void l()
    throws IOException
  {
    if (4 + this.p >= this.q)
      k();
    System.arraycopy(v, 0, this.o, this.p, 4);
    this.p = (4 + this.p);
  }

  public void a(char paramChar)
    throws IOException, com.c.a.a.c
  {
    if (3 + this.p >= this.q)
      k();
    byte[] arrayOfByte = this.o;
    if (paramChar <= '')
    {
      int k = this.p;
      this.p = (k + 1);
      arrayOfByte[k] = ((byte)paramChar);
      return;
    }
    if (paramChar < 'ࠀ')
    {
      int i = this.p;
      this.p = (i + 1);
      arrayOfByte[i] = ((byte)(0xC0 | paramChar >> '\006'));
      int j = this.p;
      this.p = (j + 1);
      arrayOfByte[j] = ((byte)(0x80 | paramChar & 0x3F));
      return;
    }
    a(paramChar, null, 0, 0);
  }

  public void a(double paramDouble)
    throws IOException, com.c.a.a.c
  {
    if ((this.d) || (((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))) && (a(d.a.d))))
    {
      b(String.valueOf(paramDouble));
      return;
    }
    d("write number");
    c(String.valueOf(paramDouble));
  }

  public void a(float paramFloat)
    throws IOException, com.c.a.a.c
  {
    if ((this.d) || (((Float.isNaN(paramFloat)) || (Float.isInfinite(paramFloat))) && (a(d.a.d))))
    {
      b(String.valueOf(paramFloat));
      return;
    }
    d("write number");
    c(String.valueOf(paramFloat));
  }

  protected final void a(int paramInt1, int paramInt2)
    throws IOException
  {
    int i = b(paramInt1, paramInt2);
    if (4 + this.p > this.q)
      k();
    byte[] arrayOfByte = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte[j] = ((byte)(0xF0 | i >> 18));
    int k = this.p;
    this.p = (k + 1);
    arrayOfByte[k] = ((byte)(0x80 | 0x3F & i >> 12));
    int i1 = this.p;
    this.p = (i1 + 1);
    arrayOfByte[i1] = ((byte)(0x80 | 0x3F & i >> 6));
    int i2 = this.p;
    this.p = (i2 + 1);
    arrayOfByte[i2] = ((byte)(0x80 | i & 0x3F));
  }

  public void a(long paramLong)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (this.d)
    {
      b(paramLong);
      return;
    }
    if (21 + this.p >= this.q)
      k();
    this.p = com.c.a.a.b.i.a(paramLong, this.o, this.p);
  }

  public final void a(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = 1;
    int j = this.e.a(paramString);
    if (j == 4)
      e("Can not write a field name, expecting a value");
    if (this.a != null)
    {
      if (j == i);
      while (true)
      {
        a(paramString, i);
        return;
        i = 0;
      }
    }
    if (j == i)
    {
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte = this.o;
      int k = this.p;
      this.p = (k + 1);
      arrayOfByte[k] = 44;
    }
    f(paramString);
  }

  protected final void a(String paramString, int paramInt)
    throws IOException, com.c.a.a.c
  {
    switch (paramInt)
    {
    default:
      j();
    case 1:
    case 2:
    case 3:
    case 0:
    }
    do
    {
      return;
      this.a.f(this);
      return;
      this.a.d(this);
      return;
      this.a.a(this);
      return;
      if (this.e.a())
      {
        this.a.g(this);
        return;
      }
    }
    while (!this.e.c());
    this.a.h(this);
  }

  protected final void a(String paramString, boolean paramBoolean)
    throws IOException, com.c.a.a.c
  {
    int j;
    if (paramBoolean)
    {
      this.a.c(this);
      if (!a(d.a.c))
        break label207;
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte1 = this.o;
      int i = this.p;
      this.p = (i + 1);
      arrayOfByte1[i] = 34;
      j = paramString.length();
      if (j > this.t)
        break label199;
      paramString.getChars(0, j, this.s, 0);
      if (j > this.r)
        break label185;
      if (j + this.p > this.q)
        k();
      e(this.s, 0, j);
    }
    while (true)
    {
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte2 = this.o;
      int k = this.p;
      this.p = (k + 1);
      arrayOfByte2[k] = 34;
      return;
      this.a.h(this);
      break;
      label185: d(this.s, 0, j);
      continue;
      label199: h(paramString);
    }
    label207: h(paramString);
  }

  public void a(BigDecimal paramBigDecimal)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (paramBigDecimal == null)
    {
      l();
      return;
    }
    if (this.d)
    {
      a(paramBigDecimal);
      return;
    }
    c(paramBigDecimal.toString());
  }

  public void a(BigInteger paramBigInteger)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (paramBigInteger == null)
    {
      l();
      return;
    }
    if (this.d)
    {
      a(paramBigInteger);
      return;
    }
    c(paramBigInteger.toString());
  }

  public void a(boolean paramBoolean)
    throws IOException, com.c.a.a.c
  {
    d("write boolean value");
    if (5 + this.p >= this.q)
      k();
    if (paramBoolean);
    for (byte[] arrayOfByte = w; ; arrayOfByte = x)
    {
      int i = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, this.o, this.p, i);
      this.p = (i + this.p);
      return;
    }
  }

  public final void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    int i = paramInt2 + (paramInt2 + paramInt2);
    if (i + this.p > this.q)
    {
      if (this.q < i)
      {
        c(paramArrayOfChar, paramInt1, paramInt2);
        return;
      }
      k();
    }
    int j = paramInt2 + paramInt1;
    int k = paramInt1;
    label50: label57: int i1;
    int i3;
    int i4;
    if (k < j)
    {
      i1 = paramArrayOfChar[k];
      if (i1 <= 127)
        break label167;
      i3 = k + 1;
      i4 = paramArrayOfChar[k];
      if (i4 >= 2048)
        break label206;
      byte[] arrayOfByte2 = this.o;
      int i5 = this.p;
      this.p = (i5 + 1);
      arrayOfByte2[i5] = ((byte)(0xC0 | i4 >> 6));
      byte[] arrayOfByte3 = this.o;
      int i6 = this.p;
      this.p = (i6 + 1);
      arrayOfByte3[i6] = ((byte)(0x80 | i4 & 0x3F));
    }
    while (true)
    {
      k = i3;
      break label50;
      break;
      label167: byte[] arrayOfByte1 = this.o;
      int i2 = this.p;
      this.p = (i2 + 1);
      arrayOfByte1[i2] = ((byte)i1);
      k++;
      if (k < j)
        break label57;
      return;
      label206: a(i4, paramArrayOfChar, i3, j);
    }
  }

  protected final int b(int paramInt1, int paramInt2)
    throws IOException
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343))
      e("Incomplete surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2));
    return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
  }

  public void b(int paramInt)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (11 + this.p >= this.q)
      k();
    if (this.d)
    {
      c(paramInt);
      return;
    }
    this.p = com.c.a.a.b.i.a(paramInt, this.o, this.p);
  }

  public void b(m paramm)
    throws IOException, com.c.a.a.c
  {
    byte[] arrayOfByte = paramm.b();
    if (arrayOfByte.length > 0)
      a(arrayOfByte);
  }

  public void b(String paramString)
    throws IOException, com.c.a.a.c
  {
    d("write text value");
    if (paramString == null)
    {
      l();
      return;
    }
    int i = paramString.length();
    if (i > this.t)
    {
      g(paramString);
      return;
    }
    paramString.getChars(0, i, this.s, 0);
    if (i > this.r)
    {
      b(this.s, 0, i);
      return;
    }
    if (i + this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int j = this.p;
    this.p = (j + 1);
    arrayOfByte1[j] = 34;
    e(this.s, 0, i);
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte2 = this.o;
    int k = this.p;
    this.p = (k + 1);
    arrayOfByte2[k] = 34;
  }

  public final void c()
    throws IOException, com.c.a.a.c
  {
    d("start an array");
    this.e = this.e.h();
    if (this.a != null)
    {
      this.a.e(this);
      return;
    }
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte[i] = 91;
  }

  public void c(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = paramString.length();
    int j = 0;
    while (i > 0)
    {
      char[] arrayOfChar = this.s;
      int k = arrayOfChar.length;
      if (i < k)
        k = i;
      paramString.getChars(j, j + k, arrayOfChar, 0);
      a(arrayOfChar, 0, k);
      j += k;
      i -= k;
    }
  }

  public void close()
    throws IOException
  {
    super.close();
    if ((this.o != null) && (a(d.a.b)))
      while (true)
      {
        d locald = h();
        if (locald.a())
        {
          d();
        }
        else
        {
          if (!locald.c())
            break;
          f();
        }
      }
    k();
    if (this.n != null)
    {
      if ((!this.h.c()) && (!a(d.a.a)))
        break label97;
      this.n.close();
    }
    while (true)
    {
      i();
      return;
      label97: if (a(d.a.f))
        this.n.flush();
    }
  }

  public final void d()
    throws IOException, com.c.a.a.c
  {
    if (!this.e.a())
      e("Current context not an ARRAY but " + this.e.d());
    if (this.a != null)
      this.a.b(this, this.e.e());
    while (true)
    {
      this.e = this.e.j();
      return;
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte = this.o;
      int i = this.p;
      this.p = (i + 1);
      arrayOfByte[i] = 93;
    }
  }

  protected final void d(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = this.e.k();
    if (i == 5)
      e("Can not " + paramString + ", expecting field name");
    if (this.a == null)
    {
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
      byte[] arrayOfByte;
      do
      {
        do
        {
          return;
          for (int j = 44; ; j = 58)
          {
            if (this.p >= this.q)
              k();
            this.o[this.p] = j;
            this.p = (1 + this.p);
            return;
          }
        }
        while (this.l == null);
        arrayOfByte = this.l.b();
      }
      while (arrayOfByte.length <= 0);
      a(arrayOfByte);
      return;
    }
    a(paramString, i);
  }

  public final void e()
    throws IOException, com.c.a.a.c
  {
    d("start an object");
    this.e = this.e.i();
    if (this.a != null)
    {
      this.a.b(this);
      return;
    }
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte[i] = 123;
  }

  public final void f()
    throws IOException, com.c.a.a.c
  {
    if (!this.e.c())
      e("Current context not an object but " + this.e.d());
    if (this.a != null)
      this.a.a(this, this.e.e());
    while (true)
    {
      this.e = this.e.j();
      return;
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte = this.o;
      int i = this.p;
      this.p = (i + 1);
      arrayOfByte[i] = 125;
    }
  }

  protected final void f(String paramString)
    throws IOException, com.c.a.a.c
  {
    if (!a(d.a.c))
    {
      h(paramString);
      return;
    }
    if (this.p >= this.q)
      k();
    byte[] arrayOfByte1 = this.o;
    int i = this.p;
    this.p = (i + 1);
    arrayOfByte1[i] = 34;
    int j = paramString.length();
    if (j <= this.t)
    {
      paramString.getChars(0, j, this.s, 0);
      if (j <= this.r)
      {
        if (j + this.p > this.q)
          k();
        e(this.s, 0, j);
      }
    }
    while (true)
    {
      if (this.p >= this.q)
        k();
      byte[] arrayOfByte2 = this.o;
      int k = this.p;
      this.p = (k + 1);
      arrayOfByte2[k] = 34;
      return;
      d(this.s, 0, j);
      continue;
      h(paramString);
    }
  }

  public final void flush()
    throws IOException
  {
    k();
    if ((this.n != null) && (a(d.a.f)))
      this.n.flush();
  }

  public void g()
    throws IOException, com.c.a.a.c
  {
    d("write null value");
    l();
  }

  protected void i()
  {
    byte[] arrayOfByte = this.o;
    if ((arrayOfByte != null) && (this.u))
    {
      this.o = null;
      this.h.b(arrayOfByte);
    }
    char[] arrayOfChar = this.s;
    if (arrayOfChar != null)
    {
      this.s = null;
      this.h.b(arrayOfChar);
    }
  }

  protected final void k()
    throws IOException
  {
    int i = this.p;
    if (i > 0)
    {
      this.p = 0;
      this.n.write(this.o, 0, i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.f
 * JD-Core Version:    0.6.2
 */