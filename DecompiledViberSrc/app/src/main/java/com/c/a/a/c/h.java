package com.c.a.a.c;

import com.c.a.a.d.a;
import com.c.a.a.k;
import com.c.a.a.l;
import com.c.a.a.m;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class h extends b
{
  protected static final char[] m = com.c.a.a.b.b.g();
  protected final Writer n;
  protected char[] o;
  protected int p = 0;
  protected int q = 0;
  protected int r;
  protected char[] s;
  protected m t;

  public h(com.c.a.a.b.d paramd, int paramInt, k paramk, Writer paramWriter)
  {
    super(paramd, paramInt, paramk);
    this.n = paramWriter;
    this.o = paramd.h();
    this.r = this.o.length;
  }

  private int a(char[] paramArrayOfChar, int paramInt1, int paramInt2, char paramChar, int paramInt3)
    throws IOException, com.c.a.a.c
  {
    if (paramInt3 >= 0)
    {
      if ((paramInt1 > 1) && (paramInt1 < paramInt2))
      {
        int i10 = paramInt1 - 2;
        paramArrayOfChar[i10] = '\\';
        paramArrayOfChar[(i10 + 1)] = ((char)paramInt3);
        return i10;
      }
      char[] arrayOfChar2 = this.s;
      if (arrayOfChar2 == null)
        arrayOfChar2 = m();
      arrayOfChar2[1] = ((char)paramInt3);
      this.n.write(arrayOfChar2, 0, 2);
      return paramInt1;
    }
    if (paramInt3 != -2)
    {
      if ((paramInt1 > 5) && (paramInt1 < paramInt2))
      {
        int i2 = paramInt1 - 6;
        int i3 = i2 + 1;
        paramArrayOfChar[i2] = '\\';
        int i4 = i3 + 1;
        paramArrayOfChar[i3] = 'u';
        int i6;
        if (paramChar > 'ÿ')
        {
          int i8 = 0xFF & paramChar >> '\b';
          int i9 = i4 + 1;
          paramArrayOfChar[i4] = m[(i8 >> 4)];
          i6 = i9 + 1;
          paramArrayOfChar[i9] = m[(i8 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        while (true)
        {
          int i7 = i6 + 1;
          paramArrayOfChar[i6] = m[(paramChar >> '\004')];
          paramArrayOfChar[i7] = m[(paramChar & 0xF)];
          return i7 - 5;
          int i5 = i4 + 1;
          paramArrayOfChar[i4] = '0';
          i6 = i5 + 1;
          paramArrayOfChar[i5] = '0';
        }
      }
      char[] arrayOfChar1 = this.s;
      if (arrayOfChar1 == null)
        arrayOfChar1 = m();
      this.p = this.q;
      if (paramChar > 'ÿ')
      {
        int k = 0xFF & paramChar >> '\b';
        int i1 = paramChar & 0xFF;
        arrayOfChar1[10] = m[(k >> 4)];
        arrayOfChar1[11] = m[(k & 0xF)];
        arrayOfChar1[12] = m[(i1 >> 4)];
        arrayOfChar1[13] = m[(i1 & 0xF)];
        this.n.write(arrayOfChar1, 8, 6);
        return paramInt1;
      }
      arrayOfChar1[6] = m[(paramChar >> '\004')];
      arrayOfChar1[7] = m[(paramChar & 0xF)];
      this.n.write(arrayOfChar1, 2, 6);
      return paramInt1;
    }
    String str;
    if (this.t == null)
      str = this.k.a(paramChar).a();
    while (true)
    {
      int i = str.length();
      if ((paramInt1 < i) || (paramInt1 >= paramInt2))
        break;
      int j = paramInt1 - i;
      str.getChars(0, i, paramArrayOfChar, j);
      return j;
      str = this.t.a();
      this.t = null;
    }
    this.n.write(str);
    return paramInt1;
  }

  private void a(char paramChar, int paramInt)
    throws IOException, com.c.a.a.c
  {
    if (paramInt >= 0)
    {
      if (this.q >= 2)
      {
        int i9 = -2 + this.q;
        this.p = i9;
        char[] arrayOfChar4 = this.o;
        int i10 = i9 + 1;
        arrayOfChar4[i9] = '\\';
        this.o[i10] = ((char)paramInt);
        return;
      }
      char[] arrayOfChar3 = this.s;
      if (arrayOfChar3 == null)
        arrayOfChar3 = m();
      this.p = this.q;
      arrayOfChar3[1] = ((char)paramInt);
      this.n.write(arrayOfChar3, 0, 2);
      return;
    }
    if (paramInt != -2)
    {
      if (this.q >= 6)
      {
        char[] arrayOfChar2 = this.o;
        int i2 = -6 + this.q;
        this.p = i2;
        arrayOfChar2[i2] = '\\';
        int i3 = i2 + 1;
        arrayOfChar2[i3] = 'u';
        int i5;
        if (paramChar > 'ÿ')
        {
          int i7 = 0xFF & paramChar >> '\b';
          int i8 = i3 + 1;
          arrayOfChar2[i8] = m[(i7 >> 4)];
          i5 = i8 + 1;
          arrayOfChar2[i5] = m[(i7 & 0xF)];
          paramChar = (char)(paramChar & 0xFF);
        }
        while (true)
        {
          int i6 = i5 + 1;
          arrayOfChar2[i6] = m[(paramChar >> '\004')];
          arrayOfChar2[(i6 + 1)] = m[(paramChar & 0xF)];
          return;
          int i4 = i3 + 1;
          arrayOfChar2[i4] = '0';
          i5 = i4 + 1;
          arrayOfChar2[i5] = '0';
        }
      }
      char[] arrayOfChar1 = this.s;
      if (arrayOfChar1 == null)
        arrayOfChar1 = m();
      this.p = this.q;
      if (paramChar > 'ÿ')
      {
        int k = 0xFF & paramChar >> '\b';
        int i1 = paramChar & 0xFF;
        arrayOfChar1[10] = m[(k >> 4)];
        arrayOfChar1[11] = m[(k & 0xF)];
        arrayOfChar1[12] = m[(i1 >> 4)];
        arrayOfChar1[13] = m[(i1 & 0xF)];
        this.n.write(arrayOfChar1, 8, 6);
        return;
      }
      arrayOfChar1[6] = m[(paramChar >> '\004')];
      arrayOfChar1[7] = m[(paramChar & 0xF)];
      this.n.write(arrayOfChar1, 2, 6);
      return;
    }
    String str;
    if (this.t == null)
      str = this.k.a(paramChar).a();
    while (true)
    {
      int i = str.length();
      if (this.q < i)
        break;
      int j = this.q - i;
      this.p = j;
      str.getChars(0, i, this.o, j);
      return;
      str = this.t.a();
      this.t = null;
    }
    this.p = this.q;
    this.n.write(str);
  }

  private void a(int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    int i = paramInt1 + this.q;
    int[] arrayOfInt = this.i;
    int j = Math.min(arrayOfInt.length, paramInt2 + 1);
    if (this.q < i)
    {
      label128: int i1;
      do
      {
        int k = this.o[this.q];
        int i2;
        if (k < j)
        {
          i2 = arrayOfInt[k];
          if (i2 == 0);
        }
        else
        {
          while (true)
          {
            int i3 = this.q - this.p;
            if (i3 > 0)
              this.n.write(this.o, this.p, i3);
            this.q = (1 + this.q);
            a(k, i2);
            break;
            if (k <= paramInt2)
              break label128;
            i2 = -1;
          }
        }
        i1 = 1 + this.q;
        this.q = i1;
      }
      while (i1 < i);
    }
  }

  private void a(Object paramObject)
    throws IOException
  {
    if (this.q >= this.r)
      k();
    char[] arrayOfChar1 = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar1[i] = '"';
    c(paramObject.toString());
    if (this.q >= this.r)
      k();
    char[] arrayOfChar2 = this.o;
    int j = this.q;
    this.q = (j + 1);
    arrayOfChar2[j] = '"';
  }

  private void b(int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    int i = 0;
    int[] arrayOfInt = this.i;
    int j = Math.min(arrayOfInt.length, paramInt2 + 1);
    int k = 0;
    int i1 = 0;
    while (true)
    {
      int i2;
      int i3;
      if (i1 < paramInt1)
      {
        i2 = this.o[i1];
        if (i2 >= j)
          break label93;
        i3 = arrayOfInt[i2];
        if (i3 == 0)
          break label105;
      }
      while (true)
      {
        int i4 = i1 - k;
        if (i4 <= 0)
          break label123;
        this.n.write(this.o, k, i4);
        if (i1 < paramInt1)
          break label123;
        return;
        label93: if (i2 > paramInt2)
        {
          i3 = -1;
          continue;
          label105: i = i3;
        }
        else
        {
          i1++;
          if (i1 < paramInt1)
            break;
          i3 = i;
        }
      }
      label123: int i5 = i1 + 1;
      int i6 = a(this.o, i5, paramInt1, i2, i3);
      i1 = i5;
      k = i6;
      i = i3;
    }
  }

  private void b(long paramLong)
    throws IOException
  {
    if (23 + this.q >= this.r)
      k();
    char[] arrayOfChar1 = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar1[i] = '"';
    this.q = com.c.a.a.b.i.a(paramLong, this.o, this.q);
    char[] arrayOfChar2 = this.o;
    int j = this.q;
    this.q = (j + 1);
    arrayOfChar2[j] = '"';
  }

  private void c(int paramInt)
    throws IOException
  {
    if (13 + this.q >= this.r)
      k();
    char[] arrayOfChar1 = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar1[i] = '"';
    this.q = com.c.a.a.b.i.a(paramInt, this.o, this.q);
    char[] arrayOfChar2 = this.o;
    int j = this.q;
    this.q = (j + 1);
    arrayOfChar2[j] = '"';
  }

  private void d(int paramInt)
    throws IOException, com.c.a.a.c
  {
    int i = paramInt + this.q;
    int[] arrayOfInt = this.i;
    int j = arrayOfInt.length;
    if (this.q < i)
    {
      int i1;
      do
      {
        int k = this.o[this.q];
        if ((k < j) && (arrayOfInt[k] != 0))
        {
          int i2 = this.q - this.p;
          if (i2 > 0)
            this.n.write(this.o, this.p, i2);
          char[] arrayOfChar = this.o;
          int i3 = this.q;
          this.q = (i3 + 1);
          char c = arrayOfChar[i3];
          a(c, arrayOfInt[c]);
          break;
        }
        i1 = 1 + this.q;
        this.q = i1;
      }
      while (i1 < i);
    }
  }

  private void e(int paramInt)
    throws IOException, com.c.a.a.c
  {
    int[] arrayOfInt = this.i;
    int i = arrayOfInt.length;
    int j = 0;
    int k = 0;
    while (true)
    {
      int i1;
      if (j < paramInt)
      {
        i1 = this.o[j];
        if ((i1 >= i) || (arrayOfInt[i1] == 0))
          break label76;
      }
      while (true)
      {
        int i2 = j - k;
        if (i2 <= 0)
          break label88;
        this.n.write(this.o, k, i2);
        if (j < paramInt)
          break label88;
        return;
        label76: j++;
        if (j < paramInt)
          break;
      }
      label88: int i3 = j + 1;
      k = a(this.o, i3, paramInt, i1, arrayOfInt[i1]);
      j = i3;
    }
  }

  private void f(int paramInt)
    throws IOException, com.c.a.a.c
  {
    int i = paramInt + this.q;
    int[] arrayOfInt = this.i;
    int j;
    int k;
    com.c.a.a.b.c localc;
    if (this.j < 1)
    {
      j = 65535;
      k = Math.min(arrayOfInt.length, j + 1);
      localc = this.k;
      label41: if (this.q >= i);
    }
    else
    {
      label181: int i2;
      do
      {
        int i1 = this.o[this.q];
        int i3;
        if (i1 < k)
        {
          i3 = arrayOfInt[i1];
          if (i3 == 0);
        }
        else
        {
          while (true)
          {
            int i4 = this.q - this.p;
            if (i4 > 0)
              this.n.write(this.o, this.p, i4);
            this.q = (1 + this.q);
            a(i1, i3);
            break label41;
            j = this.j;
            break;
            if (i1 > j)
            {
              i3 = -1;
            }
            else
            {
              m localm = localc.a(i1);
              this.t = localm;
              if (localm == null)
                break label181;
              i3 = -2;
            }
          }
        }
        i2 = 1 + this.q;
        this.q = i2;
      }
      while (i2 < i);
    }
  }

  private void f(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = this.r - this.q;
    paramString.getChars(0, i, this.o, this.q);
    this.q = (i + this.q);
    k();
    int j = paramString.length() - i;
    while (j > this.r)
    {
      int k = this.r;
      paramString.getChars(i, i + k, this.o, 0);
      this.p = 0;
      this.q = k;
      k();
      i += k;
      j -= k;
    }
    paramString.getChars(i, i + j, this.o, 0);
    this.p = 0;
    this.q = j;
  }

  private void g(int paramInt)
    throws IOException, com.c.a.a.c
  {
    int i = 0;
    int[] arrayOfInt = this.i;
    int j;
    int k;
    com.c.a.a.b.c localc;
    int i1;
    if (this.j < 1)
    {
      j = 65535;
      k = Math.min(arrayOfInt.length, j + 1);
      localc = this.k;
      i1 = 0;
    }
    label47: int i4;
    for (int i2 = 0; ; i2 = i4)
    {
      int i3;
      if (i < paramInt)
      {
        i3 = this.o[i];
        if (i3 >= k)
          break label114;
        i4 = arrayOfInt[i3];
        if (i4 == 0)
          break label154;
      }
      label154: 
      while (true)
      {
        int i5 = i - i1;
        if (i5 <= 0)
          break label173;
        this.n.write(this.o, i1, i5);
        if (i < paramInt)
          break label173;
        return;
        j = this.j;
        break;
        label114: if (i3 > j)
        {
          i4 = -1;
        }
        else
        {
          m localm = localc.a(i3);
          this.t = localm;
          if (localm != null)
          {
            i4 = -2;
            continue;
            i2 = i4;
          }
          else
          {
            i++;
            if (i < paramInt)
              break label47;
            i4 = i2;
          }
        }
      }
      label173: int i6 = i + 1;
      int i7 = a(this.o, i6, paramInt, i3, i4);
      i = i6;
      i1 = i7;
    }
  }

  private void g(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = paramString.length();
    if (i > this.r)
    {
      h(paramString);
      return;
    }
    if (i + this.q > this.r)
      k();
    paramString.getChars(0, i, this.o, this.q);
    if (this.k != null)
    {
      f(i);
      return;
    }
    if (this.j != 0)
    {
      a(i, this.j);
      return;
    }
    d(i);
  }

  private void h(String paramString)
    throws IOException, com.c.a.a.c
  {
    k();
    int i = paramString.length();
    int j = 0;
    int k = this.r;
    if (j + k > i)
      k = i - j;
    paramString.getChars(j, j + k, this.o, 0);
    if (this.k != null)
      g(k);
    while (true)
    {
      j += k;
      if (j < i)
        break;
      return;
      if (this.j != 0)
        b(k, this.j);
      else
        e(k);
    }
  }

  private void l()
    throws IOException
  {
    if (4 + this.q >= this.r)
      k();
    int i = this.q;
    char[] arrayOfChar = this.o;
    arrayOfChar[i] = 'n';
    int j = i + 1;
    arrayOfChar[j] = 'u';
    int k = j + 1;
    arrayOfChar[k] = 'l';
    int i1 = k + 1;
    arrayOfChar[i1] = 'l';
    this.q = (i1 + 1);
  }

  private char[] m()
  {
    char[] arrayOfChar = new char[14];
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '\\';
    arrayOfChar[3] = 'u';
    arrayOfChar[4] = '0';
    arrayOfChar[5] = '0';
    arrayOfChar[8] = '\\';
    arrayOfChar[9] = 'u';
    this.s = arrayOfChar;
    return arrayOfChar;
  }

  public void a(char paramChar)
    throws IOException, com.c.a.a.c
  {
    if (this.q >= this.r)
      k();
    char[] arrayOfChar = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar[i] = paramChar;
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

  public void a(long paramLong)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (this.d)
    {
      b(paramLong);
      return;
    }
    if (21 + this.q >= this.r)
      k();
    this.q = com.c.a.a.b.i.a(paramLong, this.o, this.q);
  }

  public void a(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = 1;
    int j = this.e.a(paramString);
    if (j == 4)
      e("Can not write a field name, expecting a value");
    if (j == i);
    while (true)
    {
      a(paramString, i);
      return;
      i = 0;
    }
  }

  protected void a(String paramString, int paramInt)
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

  protected void a(String paramString, boolean paramBoolean)
    throws IOException, com.c.a.a.c
  {
    if (this.a != null)
    {
      b(paramString, paramBoolean);
      return;
    }
    if (1 + this.q >= this.r)
      k();
    if (paramBoolean)
    {
      char[] arrayOfChar3 = this.o;
      int k = this.q;
      this.q = (k + 1);
      arrayOfChar3[k] = ',';
    }
    if (!a(d.a.c))
    {
      g(paramString);
      return;
    }
    char[] arrayOfChar1 = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar1[i] = '"';
    g(paramString);
    if (this.q >= this.r)
      k();
    char[] arrayOfChar2 = this.o;
    int j = this.q;
    this.q = (j + 1);
    arrayOfChar2[j] = '"';
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
    if (5 + this.q >= this.r)
      k();
    int i = this.q;
    char[] arrayOfChar = this.o;
    int i2;
    if (paramBoolean)
    {
      arrayOfChar[i] = 't';
      int i3 = i + 1;
      arrayOfChar[i3] = 'r';
      int i4 = i3 + 1;
      arrayOfChar[i4] = 'u';
      i2 = i4 + 1;
      arrayOfChar[i2] = 'e';
    }
    while (true)
    {
      this.q = (i2 + 1);
      return;
      arrayOfChar[i] = 'f';
      int j = i + 1;
      arrayOfChar[j] = 'a';
      int k = j + 1;
      arrayOfChar[k] = 'l';
      int i1 = k + 1;
      arrayOfChar[i1] = 's';
      i2 = i1 + 1;
      arrayOfChar[i2] = 'e';
    }
  }

  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException, com.c.a.a.c
  {
    if (paramInt2 < 32)
    {
      if (paramInt2 > this.r - this.q)
        k();
      System.arraycopy(paramArrayOfChar, paramInt1, this.o, this.q, paramInt2);
      this.q = (paramInt2 + this.q);
      return;
    }
    k();
    this.n.write(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void b(int paramInt)
    throws IOException, com.c.a.a.c
  {
    d("write number");
    if (this.d)
    {
      c(paramInt);
      return;
    }
    if (11 + this.q >= this.r)
      k();
    this.q = com.c.a.a.b.i.a(paramInt, this.o, this.q);
  }

  public void b(m paramm)
    throws IOException, com.c.a.a.c
  {
    c(paramm.a());
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
    if (this.q >= this.r)
      k();
    char[] arrayOfChar1 = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar1[i] = '"';
    g(paramString);
    if (this.q >= this.r)
      k();
    char[] arrayOfChar2 = this.o;
    int j = this.q;
    this.q = (j + 1);
    arrayOfChar2[j] = '"';
  }

  protected void b(String paramString, boolean paramBoolean)
    throws IOException, com.c.a.a.c
  {
    if (paramBoolean)
      this.a.c(this);
    while (a(d.a.c))
    {
      if (this.q >= this.r)
        k();
      char[] arrayOfChar1 = this.o;
      int i = this.q;
      this.q = (i + 1);
      arrayOfChar1[i] = '"';
      g(paramString);
      if (this.q >= this.r)
        k();
      char[] arrayOfChar2 = this.o;
      int j = this.q;
      this.q = (j + 1);
      arrayOfChar2[j] = '"';
      return;
      this.a.h(this);
    }
    g(paramString);
  }

  public void c()
    throws IOException, com.c.a.a.c
  {
    d("start an array");
    this.e = this.e.h();
    if (this.a != null)
    {
      this.a.e(this);
      return;
    }
    if (this.q >= this.r)
      k();
    char[] arrayOfChar = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar[i] = '[';
  }

  public void c(String paramString)
    throws IOException, com.c.a.a.c
  {
    int i = paramString.length();
    int j = this.r - this.q;
    if (j == 0)
    {
      k();
      j = this.r - this.q;
    }
    if (j >= i)
    {
      paramString.getChars(0, i, this.o, this.q);
      this.q = (i + this.q);
      return;
    }
    f(paramString);
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

  public void d()
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
      if (this.q >= this.r)
        k();
      char[] arrayOfChar = this.o;
      int i = this.q;
      this.q = (i + 1);
      arrayOfChar[i] = ']';
    }
  }

  protected void d(String paramString)
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
      do
      {
        return;
        for (int j = 44; ; j = 58)
        {
          if (this.q >= this.r)
            k();
          this.o[this.q] = j;
          this.q = (1 + this.q);
          return;
        }
      }
      while (this.l == null);
      c(this.l.a());
      return;
    }
    a(paramString, i);
  }

  public void e()
    throws IOException, com.c.a.a.c
  {
    d("start an object");
    this.e = this.e.i();
    if (this.a != null)
    {
      this.a.b(this);
      return;
    }
    if (this.q >= this.r)
      k();
    char[] arrayOfChar = this.o;
    int i = this.q;
    this.q = (i + 1);
    arrayOfChar[i] = '{';
  }

  public void f()
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
      if (this.q >= this.r)
        k();
      char[] arrayOfChar = this.o;
      int i = this.q;
      this.q = (i + 1);
      arrayOfChar[i] = '}';
    }
  }

  public void flush()
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
    char[] arrayOfChar = this.o;
    if (arrayOfChar != null)
    {
      this.o = null;
      this.h.b(arrayOfChar);
    }
  }

  protected void k()
    throws IOException
  {
    int i = this.q - this.p;
    if (i > 0)
    {
      int j = this.p;
      this.p = 0;
      this.q = 0;
      this.n.write(this.o, j, i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.h
 * JD-Core Version:    0.6.2
 */