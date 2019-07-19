package com.c.a.a.c;

import com.c.a.a.b.d;
import com.c.a.a.d.a;
import com.c.a.a.e.e;
import com.c.a.a.f;
import com.c.a.a.g.a;
import com.c.a.a.j;
import com.c.a.a.k;
import java.io.IOException;
import java.io.InputStream;

public final class g extends com.c.a.a.a.b
{
  private static final int[] S = com.c.a.a.b.b.b();
  private static final int[] T = com.c.a.a.b.b.a();
  protected k L;
  protected final a M;
  protected int[] N = new int[16];
  protected boolean O = false;
  protected InputStream P;
  protected byte[] Q;
  protected boolean R;
  private int U;

  public g(d paramd, int paramInt1, InputStream paramInputStream, k paramk, a parama, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramd, paramInt1);
    this.P = paramInputStream;
    this.L = paramk;
    this.M = parama;
    this.Q = paramArrayOfByte;
    this.d = paramInt2;
    this.e = paramInt3;
    this.R = paramBoolean;
  }

  private j L()
  {
    this.p = false;
    j localj = this.m;
    this.m = null;
    if (localj == j.d)
      this.l = this.l.a(this.j, this.k);
    while (true)
    {
      this.K = localj;
      return localj;
      if (localj == j.b)
        this.l = this.l.b(this.j, this.k);
    }
  }

  private int M()
    throws IOException, f
  {
    if ((this.d >= this.e) && (!p()));
    int i;
    do
    {
      i = 48;
      while ((this.d >= this.e) && (!p()))
        do
        {
          return i;
          i = 0xFF & this.Q[this.d];
          if ((i < 48) || (i > 57))
            return 48;
          if (!a(g.a.g))
            b("Leading zeroes not allowed");
          this.d = (1 + this.d);
        }
        while (i != 48);
      i = 0xFF & this.Q[this.d];
      if ((i < 48) || (i > 57))
        return 48;
      this.d = (1 + this.d);
    }
    while (i == 48);
    return i;
  }

  private int N()
    throws IOException, f
  {
    while ((this.d < this.e) || (p()))
    {
      byte[] arrayOfByte = this.Q;
      int i = this.d;
      this.d = (i + 1);
      int j = 0xFF & arrayOfByte[i];
      if (j > 32)
      {
        if (j != 47)
          return j;
        P();
      }
      else if (j != 32)
      {
        if (j == 10)
          K();
        else if (j == 13)
          J();
        else if (j != 9)
          b(j);
      }
    }
    throw a("Unexpected end-of-input within/between " + this.l.d() + " entries");
  }

  private int O()
    throws IOException, f
  {
    while ((this.d < this.e) || (p()))
    {
      byte[] arrayOfByte = this.Q;
      int i = this.d;
      this.d = (i + 1);
      int j = 0xFF & arrayOfByte[i];
      if (j > 32)
      {
        if (j != 47)
          return j;
        P();
      }
      else if (j != 32)
      {
        if (j == 10)
          K();
        else if (j == 13)
          J();
        else if (j != 9)
          b(j);
      }
    }
    t();
    return -1;
  }

  private void P()
    throws IOException, f
  {
    if (!a(g.a.b))
      b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    if ((this.d >= this.e) && (!p()))
      c(" in a comment");
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = 0xFF & arrayOfByte[i];
    if (j == 47)
    {
      R();
      return;
    }
    if (j == 42)
    {
      Q();
      return;
    }
    b(j, "was expecting either '*' or '/' for a comment");
  }

  private void Q()
    throws IOException, f
  {
    int[] arrayOfInt = com.c.a.a.b.b.e();
    while (true)
    {
      int j;
      int k;
      if ((this.d < this.e) || (p()))
      {
        byte[] arrayOfByte = this.Q;
        int i = this.d;
        this.d = (i + 1);
        j = 0xFF & arrayOfByte[i];
        k = arrayOfInt[j];
        if (k == 0);
      }
      else
      {
        switch (k)
        {
        default:
          j(j);
          break;
        case 42:
          if ((this.d >= this.e) && (!p()))
          {
            c(" in a comment");
            return;
          }
          if (this.Q[this.d] == 47)
          {
            this.d = (1 + this.d);
            return;
          }
          break;
        case 10:
          K();
          break;
        case 13:
          J();
          break;
        case 2:
          r(j);
          break;
        case 3:
          s(j);
          break;
        case 4:
          t(j);
        }
      }
    }
  }

  private void R()
    throws IOException, f
  {
    int[] arrayOfInt = com.c.a.a.b.b.e();
    while (true)
    {
      int j;
      int k;
      if ((this.d < this.e) || (p()))
      {
        byte[] arrayOfByte = this.Q;
        int i = this.d;
        this.d = (i + 1);
        j = 0xFF & arrayOfByte[i];
        k = arrayOfInt[j];
        if (k == 0);
      }
      else
      {
        switch (k)
        {
        case 42:
        default:
          j(j);
          break;
        case 10:
          K();
          return;
        case 13:
          J();
          return;
        case 2:
          r(j);
          break;
        case 3:
          s(j);
          break;
        case 4:
          t(j);
        }
      }
    }
  }

  private int S()
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    return 0xFF & arrayOfByte[i];
  }

  private com.c.a.a.d.c a(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, f
  {
    return a(this.N, 0, paramInt1, paramInt2, paramInt3);
  }

  private com.c.a.a.d.c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, f
  {
    this.N[0] = paramInt1;
    return a(this.N, 1, paramInt2, paramInt3, paramInt4);
  }

  private com.c.a.a.d.c a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws f
  {
    int i = paramInt2 + (-4 + (paramInt1 << 2));
    int j;
    Object localObject1;
    int k;
    int m;
    label50: int n;
    int i1;
    int i5;
    int i6;
    label113: int i3;
    int i4;
    Object localObject2;
    int i2;
    if (paramInt2 < 4)
    {
      j = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (j << (4 - paramInt2 << 3));
      localObject1 = this.n.k();
      k = 0;
      m = 0;
      if (m >= i)
        break label489;
      n = 0xFF & paramArrayOfInt[(m >> 2)] >> (3 - (m & 0x3) << 3);
      i1 = m + 1;
      if (n <= 127)
        break label527;
      if ((n & 0xE0) != 192)
        break label423;
      i5 = n & 0x1F;
      i6 = 1;
      if (i1 + i6 > i)
        c(" in field name");
      int i7 = paramArrayOfInt[(i1 >> 2)] >> (3 - (i1 & 0x3) << 3);
      i1++;
      if ((i7 & 0xC0) != 128)
        l(i7);
      n = i5 << 6 | i7 & 0x3F;
      if (i6 > 1)
      {
        int i11 = paramArrayOfInt[(i1 >> 2)] >> (3 - (i1 & 0x3) << 3);
        i1++;
        if ((i11 & 0xC0) != 128)
          l(i11);
        n = n << 6 | i11 & 0x3F;
        if (i6 > 2)
        {
          int i12 = paramArrayOfInt[(i1 >> 2)] >> (3 - (i1 & 0x3) << 3);
          i1++;
          if ((i12 & 0xC0) != 128)
            l(i12 & 0xFF);
          n = n << 6 | i12 & 0x3F;
        }
      }
      if (i6 <= 2)
        break label527;
      int i8 = n - 65536;
      if (k >= localObject1.length)
        localObject1 = this.n.n();
      int i9 = k + 1;
      localObject1[k] = ((char)(55296 + (i8 >> 10)));
      int i10 = 0xDC00 | i8 & 0x3FF;
      i3 = i1;
      i4 = i9;
      localObject2 = localObject1;
      i2 = i10;
    }
    while (true)
    {
      if (i4 >= localObject2.length)
        localObject2 = this.n.n();
      k = i4 + 1;
      localObject2[i4] = ((char)i2);
      m = i3;
      localObject1 = localObject2;
      break label50;
      j = 0;
      break;
      label423: if ((n & 0xF0) == 224)
      {
        i5 = n & 0xF;
        i6 = 2;
        break label113;
      }
      if ((n & 0xF8) == 240)
      {
        i5 = n & 0x7;
        i6 = 3;
        break label113;
      }
      k(n);
      i5 = 1;
      i6 = i5;
      break label113;
      label489: String str = new String((char[])localObject1, 0, k);
      if (paramInt2 < 4)
        paramArrayOfInt[(paramInt1 - 1)] = j;
      return this.M.a(str, paramArrayOfInt, paramInt1);
      label527: localObject2 = localObject1;
      i2 = n;
      i3 = i1;
      i4 = k;
    }
  }

  private com.c.a.a.d.c a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
    throws f
  {
    if (paramInt1 >= paramArrayOfInt.length)
    {
      paramArrayOfInt = a(paramArrayOfInt, paramArrayOfInt.length);
      this.N = paramArrayOfInt;
    }
    int i = paramInt1 + 1;
    paramArrayOfInt[paramInt1] = paramInt2;
    com.c.a.a.d.c localc = this.M.a(paramArrayOfInt, i);
    if (localc == null)
      localc = a(paramArrayOfInt, i, paramInt3);
    return localc;
  }

  private j a(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException, f
  {
    int i = 0;
    int i14;
    int k;
    label40: int m;
    int j;
    char[] arrayOfChar;
    if (paramInt2 == 46)
    {
      i14 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = ((char)paramInt2);
      if ((this.d >= this.e) && (!p()))
      {
        k = 1;
        if (i == 0)
          a(paramInt2, "Decimal point not followed by a digit");
        m = i;
        j = i14;
        arrayOfChar = paramArrayOfChar;
      }
    }
    while (true)
    {
      int n;
      int i2;
      int i3;
      label188: int i6;
      int i7;
      label255: int i12;
      int i11;
      int i8;
      int i10;
      if ((paramInt2 == 101) || (paramInt2 == 69))
      {
        if (j >= arrayOfChar.length)
        {
          arrayOfChar = this.n.m();
          j = 0;
        }
        n = j + 1;
        arrayOfChar[j] = ((char)paramInt2);
        if (this.d >= this.e)
          o();
        byte[] arrayOfByte1 = this.Q;
        int i1 = this.d;
        this.d = (i1 + 1);
        i2 = 0xFF & arrayOfByte1[i1];
        if ((i2 == 45) || (i2 == 43))
          if (n >= arrayOfChar.length)
          {
            arrayOfChar = this.n.m();
            i3 = 0;
            int i4 = i3 + 1;
            arrayOfChar[i3] = ((char)i2);
            if (this.d >= this.e)
              o();
            byte[] arrayOfByte2 = this.Q;
            int i5 = this.d;
            this.d = (i5 + 1);
            i2 = 0xFF & arrayOfByte2[i5];
            i6 = i4;
            i7 = 0;
            if ((i2 <= 57) && (i2 >= 48))
            {
              i7++;
              if (i6 >= arrayOfChar.length)
              {
                arrayOfChar = this.n.m();
                i6 = 0;
              }
              i12 = i6 + 1;
              arrayOfChar[i6] = ((char)i2);
              if ((this.d >= this.e) && (!p()))
              {
                i11 = i7;
                i8 = 1;
                i10 = i12;
                label335: if (i11 == 0)
                  a(i2, "Exponent indicator not followed by a digit");
                label348: if (i8 == 0)
                  this.d = (-1 + this.d);
                this.n.a(i10);
                return b(paramBoolean, paramInt3, m, i11);
                byte[] arrayOfByte4 = this.Q;
                int i15 = this.d;
                this.d = (i15 + 1);
                paramInt2 = 0xFF & arrayOfByte4[i15];
                k = 0;
                if (paramInt2 < 48)
                  break label40;
                k = 0;
                if (paramInt2 > 57)
                  break label40;
                i++;
                if (i14 < paramArrayOfChar.length)
                  break label557;
                paramArrayOfChar = this.n.m();
              }
            }
          }
      }
      label557: for (int i16 = 0; ; i16 = i14)
      {
        i14 = i16 + 1;
        paramArrayOfChar[i16] = ((char)paramInt2);
        break;
        byte[] arrayOfByte3 = this.Q;
        int i13 = this.d;
        this.d = (i13 + 1);
        i2 = 0xFF & arrayOfByte3[i13];
        i6 = i12;
        break label255;
        i8 = k;
        int i9 = i7;
        i10 = i6;
        i11 = i9;
        break label335;
        i3 = n;
        break label188;
        i6 = n;
        i7 = 0;
        break label255;
        i8 = k;
        i10 = j;
        i11 = 0;
        break label348;
      }
      arrayOfChar = paramArrayOfChar;
      j = paramInt1;
      k = 0;
      m = 0;
    }
  }

  private j a(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException, f
  {
    int i = paramInt2;
    int j = paramInt1;
    char[] arrayOfChar = paramArrayOfChar;
    if ((this.d >= this.e) && (!p()))
    {
      this.n.a(j);
      return a(paramBoolean, i);
    }
    byte[] arrayOfByte = this.Q;
    int k = this.d;
    this.d = (k + 1);
    int m = 0xFF & arrayOfByte[k];
    if ((m > 57) || (m < 48))
    {
      if ((m == 46) || (m == 101) || (m == 69))
        return a(arrayOfChar, j, m, paramBoolean, i);
    }
    else
    {
      if (j < arrayOfChar.length)
        break label192;
      arrayOfChar = this.n.m();
    }
    label192: for (int n = 0; ; n = j)
    {
      j = n + 1;
      arrayOfChar[n] = ((char)m);
      i++;
      break;
      this.d = (-1 + this.d);
      this.n.a(j);
      return a(paramBoolean, i);
    }
  }

  private void a(char[] paramArrayOfChar, int paramInt)
    throws IOException, f
  {
    int[] arrayOfInt = S;
    byte[] arrayOfByte = this.Q;
    int m;
    while (true)
    {
      int i = this.d;
      if (i >= this.e)
      {
        o();
        i = this.d;
      }
      if (paramInt >= paramArrayOfChar.length)
      {
        paramArrayOfChar = this.n.m();
        paramInt = 0;
      }
      int j = Math.min(this.e, i + (paramArrayOfChar.length - paramInt));
      while (i < j)
      {
        int k = i + 1;
        m = 0xFF & arrayOfByte[i];
        if (arrayOfInt[m] != 0)
        {
          this.d = k;
          if (m != 34)
            break label150;
          this.n.a(paramInt);
          return;
        }
        int n = paramInt + 1;
        paramArrayOfChar[paramInt] = ((char)m);
        i = k;
        paramInt = n;
      }
      this.d = i;
    }
    label150: switch (arrayOfInt[m])
    {
    default:
      if (m < 32)
      {
        c(m, "string value");
        label200: if (paramInt < paramArrayOfChar.length)
          break label360;
        paramArrayOfChar = this.n.m();
      }
      break;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    label360: for (int i4 = 0; ; i4 = paramInt)
    {
      paramInt = i4 + 1;
      paramArrayOfChar[i4] = ((char)m);
      break;
      m = B();
      break label200;
      m = n(m);
      break label200;
      if (this.e - this.d >= 2)
      {
        m = p(m);
        break label200;
      }
      m = o(m);
      break label200;
      int i1 = q(m);
      int i2 = paramInt + 1;
      paramArrayOfChar[paramInt] = ((char)(0xD800 | i1 >> 10));
      if (i2 >= paramArrayOfChar.length)
      {
        paramArrayOfChar = this.n.m();
        i2 = 0;
      }
      int i3 = 0xDC00 | i1 & 0x3FF;
      paramInt = i2;
      m = i3;
      break label200;
      j(m);
      break label200;
    }
  }

  public static int[] a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null)
      return new int[paramInt];
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    return arrayOfInt;
  }

  private com.c.a.a.d.c b(int paramInt1, int paramInt2)
    throws f
  {
    com.c.a.a.d.c localc = this.M.b(paramInt1);
    if (localc != null)
      return localc;
    this.N[0] = paramInt1;
    return a(this.N, 1, paramInt2);
  }

  private com.c.a.a.d.c b(int paramInt1, int paramInt2, int paramInt3)
    throws f
  {
    com.c.a.a.d.c localc = this.M.a(paramInt1, paramInt2);
    if (localc != null)
      return localc;
    this.N[0] = paramInt1;
    this.N[1] = paramInt2;
    return a(this.N, 2, paramInt3);
  }

  private j m(int paramInt)
    throws IOException, f
  {
    if (paramInt == 34)
    {
      this.O = true;
      j localj8 = j.h;
      this.K = localj8;
      return localj8;
    }
    switch (paramInt)
    {
    default:
      j localj7 = h(paramInt);
      this.K = localj7;
      return localj7;
    case 91:
      this.l = this.l.a(this.j, this.k);
      j localj6 = j.d;
      this.K = localj6;
      return localj6;
    case 123:
      this.l = this.l.b(this.j, this.k);
      j localj5 = j.b;
      this.K = localj5;
      return localj5;
    case 93:
    case 125:
      b(paramInt, "expected a value");
    case 116:
      a("true", 1);
      j localj4 = j.k;
      this.K = localj4;
      return localj4;
    case 102:
      a("false", 1);
      j localj3 = j.l;
      this.K = localj3;
      return localj3;
    case 110:
      a("null", 1);
      j localj2 = j.m;
      this.K = localj2;
      return localj2;
    case 45:
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 57:
    }
    j localj1 = d(paramInt);
    this.K = localj1;
    return localj1;
  }

  private int n(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte[i];
    if ((j & 0xC0) != 128)
      a(j & 0xFF, this.d);
    return (paramInt & 0x1F) << 6 | j & 0x3F;
  }

  private int o(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    int i = paramInt & 0xF;
    byte[] arrayOfByte1 = this.Q;
    int j = this.d;
    this.d = (j + 1);
    int k = arrayOfByte1[j];
    if ((k & 0xC0) != 128)
      a(k & 0xFF, this.d);
    int m = i << 6 | k & 0x3F;
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte2 = this.Q;
    int n = this.d;
    this.d = (n + 1);
    int i1 = arrayOfByte2[n];
    if ((i1 & 0xC0) != 128)
      a(i1 & 0xFF, this.d);
    return m << 6 | i1 & 0x3F;
  }

  private int p(int paramInt)
    throws IOException, f
  {
    int i = paramInt & 0xF;
    byte[] arrayOfByte1 = this.Q;
    int j = this.d;
    this.d = (j + 1);
    int k = arrayOfByte1[j];
    if ((k & 0xC0) != 128)
      a(k & 0xFF, this.d);
    int m = i << 6 | k & 0x3F;
    byte[] arrayOfByte2 = this.Q;
    int n = this.d;
    this.d = (n + 1);
    int i1 = arrayOfByte2[n];
    if ((i1 & 0xC0) != 128)
      a(i1 & 0xFF, this.d);
    return m << 6 | i1 & 0x3F;
  }

  private int q(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte1 = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte1[i];
    if ((j & 0xC0) != 128)
      a(j & 0xFF, this.d);
    int k = (paramInt & 0x7) << 6 | j & 0x3F;
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte2 = this.Q;
    int m = this.d;
    this.d = (m + 1);
    int n = arrayOfByte2[m];
    if ((n & 0xC0) != 128)
      a(n & 0xFF, this.d);
    int i1 = k << 6 | n & 0x3F;
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte3 = this.Q;
    int i2 = this.d;
    this.d = (i2 + 1);
    int i3 = arrayOfByte3[i2];
    if ((i3 & 0xC0) != 128)
      a(i3 & 0xFF, this.d);
    return (i1 << 6 | i3 & 0x3F) - 65536;
  }

  private void r(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte[i];
    if ((j & 0xC0) != 128)
      a(j & 0xFF, this.d);
  }

  private void s(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte1 = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte1[i];
    if ((j & 0xC0) != 128)
      a(j & 0xFF, this.d);
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte2 = this.Q;
    int k = this.d;
    this.d = (k + 1);
    int m = arrayOfByte2[k];
    if ((m & 0xC0) != 128)
      a(m & 0xFF, this.d);
  }

  private void t(int paramInt)
    throws IOException, f
  {
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte1 = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfByte1[i];
    if ((j & 0xC0) != 128)
      a(j & 0xFF, this.d);
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte2 = this.Q;
    int k = this.d;
    this.d = (k + 1);
    int m = arrayOfByte2[k];
    if ((m & 0xC0) != 128)
      a(m & 0xFF, this.d);
    if (this.d >= this.e)
      o();
    byte[] arrayOfByte3 = this.Q;
    int n = this.d;
    this.d = (n + 1);
    int i1 = arrayOfByte3[n];
    if ((i1 & 0xC0) != 128)
      a(i1 & 0xFF, this.d);
  }

  protected char B()
    throws IOException, f
  {
    int i = 0;
    if ((this.d >= this.e) && (!p()))
      c(" in character escape sequence");
    byte[] arrayOfByte1 = this.Q;
    int j = this.d;
    this.d = (j + 1);
    int k = arrayOfByte1[j];
    switch (k)
    {
    default:
      return a((char)i(k));
    case 98:
      return '\b';
    case 116:
      return '\t';
    case 110:
      return '\n';
    case 102:
      return '\f';
    case 114:
      return '\r';
    case 34:
    case 47:
    case 92:
      return (char)k;
    case 117:
    }
    int m = 0;
    while (i < 4)
    {
      if ((this.d >= this.e) && (!p()))
        c(" in character escape sequence");
      byte[] arrayOfByte2 = this.Q;
      int n = this.d;
      this.d = (n + 1);
      int i1 = arrayOfByte2[n];
      int i2 = com.c.a.a.b.b.a(i1);
      if (i2 < 0)
        b(i1, "expected a hex-digit for character escape sequence");
      m = i2 | m << 4;
      i++;
    }
    return (char)m;
  }

  protected com.c.a.a.d.c F()
    throws IOException, f
  {
    if ((this.d >= this.e) && (!p()))
      c(": was expecting closing '\"' for name");
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = 0xFF & arrayOfByte[i];
    if (j == 34)
      return a.d();
    return a(this.N, 0, 0, j, 0);
  }

  protected com.c.a.a.d.c G()
    throws IOException, f
  {
    if ((this.d >= this.e) && (!p()))
      c(": was expecting closing ''' for name");
    byte[] arrayOfByte1 = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = 0xFF & arrayOfByte1[i];
    if (j == 39)
      return a.d();
    Object localObject1 = this.N;
    int[] arrayOfInt = T;
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject5;
    int i28;
    com.c.a.a.d.c localc;
    label192: int i14;
    int i2;
    int i13;
    label251: int i20;
    Object localObject4;
    int i21;
    label292: int i23;
    int i1;
    int i3;
    if (j == 39)
    {
      if (k <= 0)
        break label614;
      if (n >= localObject1.length)
      {
        localObject1 = a((int[])localObject1, localObject1.length);
        this.N = ((int[])localObject1);
      }
      int i29 = n + 1;
      localObject1[n] = m;
      localObject5 = localObject1;
      i28 = i29;
      localc = this.M.a(localObject5, i28);
      if (localc == null)
        return a(localObject5, i28, k);
    }
    else
    {
      if ((j == 34) || (arrayOfInt[j] == 0))
        break label663;
      if (j != 92)
      {
        c(j, "name");
        if (j <= 127)
          break label663;
        if (k < 4)
          break label644;
        if (n >= localObject1.length)
        {
          localObject1 = a((int[])localObject1, localObject1.length);
          this.N = ((int[])localObject1);
        }
        int i27 = n + 1;
        localObject1[n] = m;
        i14 = 0;
        i2 = i27;
        i13 = 0;
        if (j >= 2048)
          break label437;
        int i25 = i13 << 8 | (0xC0 | j >> 6);
        int i26 = i14 + 1;
        i20 = i25;
        localObject4 = localObject1;
        i21 = i26;
        i23 = 0x80 | j & 0x3F;
        i1 = i20;
        i3 = i21;
        localObject1 = localObject4;
      }
    }
    for (int i4 = i23; ; i4 = j)
    {
      int i7;
      int i8;
      Object localObject2;
      int i6;
      label352: int i15;
      label437: int i16;
      int i18;
      Object localObject3;
      int i19;
      int i17;
      if (i3 < 4)
      {
        int i11 = i3 + 1;
        i7 = i4 | i1 << 8;
        i8 = i2;
        localObject2 = localObject1;
        i6 = i11;
        if ((this.d >= this.e) && (!p()))
          c(" in field name");
        byte[] arrayOfByte2 = this.Q;
        int i9 = this.d;
        this.d = (i9 + 1);
        j = 0xFF & arrayOfByte2[i9];
        int i10 = i6;
        localObject1 = localObject2;
        m = i7;
        n = i8;
        k = i10;
        break;
        j = B();
        break label192;
        i15 = i13 << 8 | (0xE0 | j >> 12);
        i16 = i14 + 1;
        if (i16 < 4)
          break label625;
        if (i2 >= localObject1.length)
        {
          localObject1 = a((int[])localObject1, localObject1.length);
          this.N = ((int[])localObject1);
        }
        int i24 = i2 + 1;
        localObject1[i2] = i15;
        i18 = i24;
        localObject3 = localObject1;
        i19 = 0;
        i17 = 0;
      }
      while (true)
      {
        i20 = i17 << 8 | (0x80 | 0x3F & j >> 6);
        i21 = i19 + 1;
        int i22 = i18;
        localObject4 = localObject3;
        i2 = i22;
        break label292;
        if (i2 >= localObject1.length)
        {
          localObject1 = a((int[])localObject1, localObject1.length);
          this.N = ((int[])localObject1);
        }
        int i5 = i2 + 1;
        localObject1[i2] = i1;
        localObject2 = localObject1;
        i6 = 1;
        i7 = i4;
        i8 = i5;
        break label352;
        return localc;
        label614: localObject5 = localObject1;
        i28 = n;
        break;
        label625: i17 = i15;
        i18 = i2;
        localObject3 = localObject1;
        i19 = i16;
      }
      label644: int i12 = k;
      i13 = m;
      i2 = n;
      i14 = i12;
      break label251;
      label663: i1 = m;
      i2 = n;
      i3 = k;
    }
  }

  protected void H()
    throws IOException, f
  {
    this.O = false;
    int[] arrayOfInt = S;
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    int j = this.e;
    if (i >= j)
    {
      o();
      i = this.d;
      j = this.e;
    }
    while (true)
    {
      int k;
      int m;
      if (i < j)
      {
        k = i + 1;
        m = 0xFF & arrayOfByte[i];
        if (arrayOfInt[m] == 0)
          break label191;
        this.d = k;
        if (m != 34);
      }
      else
      {
        this.d = i;
        break;
      }
      switch (arrayOfInt[m])
      {
      default:
        if (m < 32)
          c(m, "string value");
        break;
      case 1:
        B();
        break;
      case 2:
        r(m);
        break;
      case 3:
        s(m);
        break;
      case 4:
        t(m);
        break;
        j(m);
        break;
      }
      label191: i = k;
    }
  }

  protected j I()
    throws IOException, f
  {
    char[] arrayOfChar = this.n.k();
    int[] arrayOfInt = S;
    byte[] arrayOfByte = this.Q;
    int i = 0;
    label388: label400: 
    while (true)
    {
      if (this.d >= this.e)
        o();
      if (i >= arrayOfChar.length)
      {
        arrayOfChar = this.n.m();
        i = 0;
      }
      int j = this.e;
      int k = this.d + (arrayOfChar.length - i);
      if (k < j);
      while (true)
      {
        if (this.d >= k)
          break label400;
        int m = this.d;
        this.d = (m + 1);
        int n = 0xFF & arrayOfByte[m];
        if ((n == 39) || (arrayOfInt[n] != 0))
        {
          if (n == 39)
          {
            this.n.a(i);
            return j.h;
          }
        }
        else
        {
          int i5 = i + 1;
          arrayOfChar[i] = ((char)n);
          i = i5;
          continue;
        }
        label222: int i3;
        switch (arrayOfInt[n])
        {
        default:
          if (n < 32)
            c(n, "string value");
          j(n);
          i3 = n;
        case 1:
        case 2:
        case 3:
        case 4:
        }
        int i4;
        label244: int i1;
        int i2;
        while (true)
          if (i >= arrayOfChar.length)
          {
            arrayOfChar = this.n.m();
            i4 = 0;
            i = i4 + 1;
            arrayOfChar[i4] = ((char)i3);
            break;
            if (n == 34)
              break label222;
            i3 = B();
            continue;
            i3 = n(n);
            continue;
            if (this.e - this.d >= 2)
            {
              i3 = p(n);
            }
            else
            {
              i3 = o(n);
              continue;
              i1 = q(n);
              i2 = i + 1;
              arrayOfChar[i] = ((char)(0xD800 | i1 >> 10));
              if (i2 < arrayOfChar.length)
                break label388;
              arrayOfChar = this.n.m();
            }
          }
        for (i = 0; ; i = i2)
        {
          i3 = 0xDC00 | i1 & 0x3FF;
          break;
          i4 = i;
          break label244;
        }
        k = j;
      }
    }
  }

  protected void J()
    throws IOException
  {
    if (((this.d < this.e) || (p())) && (this.Q[this.d] == 10))
      this.d = (1 + this.d);
    this.g = (1 + this.g);
    this.h = this.d;
  }

  protected void K()
    throws IOException
  {
    this.g = (1 + this.g);
    this.h = this.d;
  }

  protected com.c.a.a.d.c a(int paramInt, int[] paramArrayOfInt)
    throws IOException, f
  {
    byte[] arrayOfByte1 = this.Q;
    int i = this.d;
    this.d = (i + 1);
    int j = 0xFF & arrayOfByte1[i];
    if (paramArrayOfInt[j] != 0)
    {
      if (j == 34)
        return b(this.U, paramInt, 1);
      return a(this.U, paramInt, j, 1);
    }
    int k = j | paramInt << 8;
    byte[] arrayOfByte2 = this.Q;
    int m = this.d;
    this.d = (m + 1);
    int n = 0xFF & arrayOfByte2[m];
    if (paramArrayOfInt[n] != 0)
    {
      if (n == 34)
        return b(this.U, k, 2);
      return a(this.U, k, n, 2);
    }
    int i1 = n | k << 8;
    byte[] arrayOfByte3 = this.Q;
    int i2 = this.d;
    this.d = (i2 + 1);
    int i3 = 0xFF & arrayOfByte3[i2];
    if (paramArrayOfInt[i3] != 0)
    {
      if (i3 == 34)
        return b(this.U, i1, 3);
      return a(this.U, i1, i3, 3);
    }
    int i4 = i3 | i1 << 8;
    byte[] arrayOfByte4 = this.Q;
    int i5 = this.d;
    this.d = (i5 + 1);
    int i6 = 0xFF & arrayOfByte4[i5];
    if (paramArrayOfInt[i6] != 0)
    {
      if (i6 == 34)
        return b(this.U, i4, 4);
      return a(this.U, i4, i6, 4);
    }
    this.N[0] = this.U;
    this.N[1] = i4;
    return f(i6);
  }

  protected com.c.a.a.d.c a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, f
  {
    int[] arrayOfInt1 = T;
    label100: int m;
    int[] arrayOfInt2;
    label148: int i5;
    Object localObject2;
    int i6;
    Object localObject1;
    int i;
    if (arrayOfInt1[paramInt3] != 0)
    {
      if (paramInt3 == 34)
      {
        if (paramInt4 > 0)
        {
          if (paramInt1 >= paramArrayOfInt.length)
          {
            paramArrayOfInt = a(paramArrayOfInt, paramArrayOfInt.length);
            this.N = paramArrayOfInt;
          }
          int i11 = paramInt1 + 1;
          paramArrayOfInt[paramInt1] = paramInt2;
          paramInt1 = i11;
        }
        com.c.a.a.d.c localc = this.M.a(paramArrayOfInt, paramInt1);
        if (localc == null)
          localc = a(paramArrayOfInt, paramInt1, paramInt4);
        return localc;
      }
      if (paramInt3 != 92)
      {
        c(paramInt3, "name");
        if (paramInt3 <= 127)
          break label496;
        if (paramInt4 < 4)
          break label487;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          paramArrayOfInt = a(paramArrayOfInt, paramArrayOfInt.length);
          this.N = paramArrayOfInt;
        }
        m = paramInt1 + 1;
        paramArrayOfInt[paramInt1] = paramInt2;
        paramInt4 = 0;
        paramInt2 = 0;
        arrayOfInt2 = paramArrayOfInt;
        if (paramInt3 >= 2048)
          break label302;
        int i9 = paramInt2 << 8 | (0xC0 | paramInt3 >> 6);
        int i10 = paramInt4 + 1;
        i5 = i9;
        localObject2 = arrayOfInt2;
        i6 = i10;
        paramInt2 = 0x80 | paramInt3 & 0x3F;
        paramInt4 = i6;
        paramInt1 = m;
        localObject1 = localObject2;
        i = i5;
      }
    }
    while (true)
    {
      label235: int n;
      label302: int i1;
      int i3;
      int[] arrayOfInt3;
      int i4;
      int i2;
      if (paramInt4 < 4)
      {
        paramInt4++;
        paramInt2 |= i << 8;
        paramArrayOfInt = (int[])localObject1;
        if ((this.d >= this.e) && (!p()))
          c(" in field name");
        byte[] arrayOfByte = this.Q;
        int k = this.d;
        this.d = (k + 1);
        paramInt3 = 0xFF & arrayOfByte[k];
        break;
        paramInt3 = B();
        break label100;
        n = paramInt2 << 8 | (0xE0 | paramInt3 >> 12);
        i1 = paramInt4 + 1;
        if (i1 < 4)
          break label468;
        if (m >= arrayOfInt2.length)
        {
          arrayOfInt2 = a(arrayOfInt2, arrayOfInt2.length);
          this.N = arrayOfInt2;
        }
        int i8 = m + 1;
        arrayOfInt2[m] = n;
        i3 = i8;
        arrayOfInt3 = arrayOfInt2;
        i4 = 0;
        i2 = 0;
      }
      while (true)
      {
        i5 = i2 << 8 | (0x80 | 0x3F & paramInt3 >> 6);
        i6 = i4 + 1;
        int i7 = i3;
        localObject2 = arrayOfInt3;
        m = i7;
        break;
        if (paramInt1 >= localObject1.length)
        {
          localObject1 = a((int[])localObject1, localObject1.length);
          this.N = ((int[])localObject1);
        }
        int j = paramInt1 + 1;
        localObject1[paramInt1] = i;
        paramInt4 = 1;
        paramInt1 = j;
        paramArrayOfInt = (int[])localObject1;
        break label235;
        label468: i2 = n;
        i3 = m;
        arrayOfInt3 = arrayOfInt2;
        i4 = i1;
      }
      label487: m = paramInt1;
      arrayOfInt2 = paramArrayOfInt;
      break label148;
      label496: i = paramInt2;
      localObject1 = paramArrayOfInt;
      paramInt2 = paramInt3;
    }
  }

  public j a()
    throws IOException, f
  {
    this.A = 0;
    if (this.K == j.f)
      return L();
    if (this.O)
      H();
    int i = O();
    if (i < 0)
    {
      close();
      this.K = null;
      return null;
    }
    this.i = (this.f + this.d - 1L);
    this.j = this.g;
    this.k = (-1 + (this.d - this.h));
    this.r = null;
    if (i == 93)
    {
      if (!this.l.a())
        a(i, '}');
      this.l = this.l.i();
      j localj3 = j.e;
      this.K = localj3;
      return localj3;
    }
    if (i == 125)
    {
      if (!this.l.c())
        a(i, ']');
      this.l = this.l.i();
      j localj2 = j.c;
      this.K = localj2;
      return localj2;
    }
    if (this.l.j())
    {
      if (i != 44)
        b(i, "was expecting comma to separate " + this.l.d() + " entries");
      i = N();
    }
    if (!this.l.c())
      return m(i);
    com.c.a.a.d.c localc = e(i);
    this.l.a(localc.a());
    this.K = j.f;
    int j = N();
    if (j != 58)
      b(j, "was expecting a colon to separate field name and value");
    int k = N();
    if (k == 34)
    {
      this.O = true;
      this.m = j.h;
      return this.K;
    }
    j localj1;
    switch (k)
    {
    default:
      localj1 = h(k);
    case 91:
    case 123:
    case 93:
    case 125:
    case 116:
    case 102:
    case 110:
    case 45:
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
    case 57:
    }
    while (true)
    {
      this.m = localj1;
      return this.K;
      localj1 = j.d;
      continue;
      localj1 = j.b;
      continue;
      b(k, "expected a value");
      a("true", 1);
      localj1 = j.k;
      continue;
      a("false", 1);
      localj1 = j.l;
      continue;
      a("null", 1);
      localj1 = j.m;
      continue;
      localj1 = d(k);
    }
  }

  protected j a(int paramInt, boolean paramBoolean)
    throws IOException, f
  {
    double d = (-1.0D / 0.0D);
    if (paramInt == 73)
    {
      if ((this.d >= this.e) && (!p()))
        D();
      byte[] arrayOfByte = this.Q;
      int i = this.d;
      this.d = (i + 1);
      paramInt = arrayOfByte[i];
      if (paramInt != 78)
        break label158;
      String str2;
      if (paramBoolean)
      {
        str2 = "-INF";
        a(str2, 3);
        if (!a(g.a.h))
          break label117;
        if (!paramBoolean)
          break label110;
      }
      while (true)
      {
        return a(str2, d);
        str2 = "+INF";
        break;
        label110: d = (1.0D / 0.0D);
      }
      label117: d("Non-standard token '" + str2 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
    }
    while (true)
    {
      a(paramInt, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
      label158: if (paramInt == 110)
      {
        String str1;
        if (paramBoolean)
        {
          str1 = "-Infinity";
          a(str1, 3);
          if (!a(g.a.h))
            break label217;
          if (!paramBoolean)
            break label210;
        }
        while (true)
        {
          return a(str1, d);
          str1 = "+Infinity";
          break;
          label210: d = (1.0D / 0.0D);
        }
        label217: d("Non-standard token '" + str1 + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }
    }
  }

  protected String a(j paramj)
  {
    if (paramj == null)
      return null;
    switch (1.a[paramj.ordinal()])
    {
    default:
      return paramj.a();
    case 1:
      return this.l.h();
    case 2:
    case 3:
    case 4:
    }
    return this.n.f();
  }

  protected void a(int paramInt1, int paramInt2)
    throws f
  {
    this.d = paramInt2;
    l(paramInt1);
  }

  protected void a(String paramString, int paramInt)
    throws IOException, f
  {
    int i = paramString.length();
    do
    {
      if ((this.d >= this.e) && (!p()))
        c(" in a value");
      if (this.Q[this.d] != paramString.charAt(paramInt))
        a(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      this.d = (1 + this.d);
      paramInt++;
    }
    while (paramInt < i);
    if ((this.d >= this.e) && (!p()));
    int j;
    do
    {
      return;
      j = 0xFF & this.Q[this.d];
    }
    while ((j < 48) || (j == 93) || (j == 125) || (!Character.isJavaIdentifierPart((char)i(j))));
    this.d = (1 + this.d);
    a(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
  }

  protected void a(String paramString1, String paramString2)
    throws IOException, f
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    while (true)
    {
      if ((this.d >= this.e) && (!p()));
      char c;
      do
      {
        d("Unrecognized token '" + localStringBuilder.toString() + "': was expecting " + paramString2);
        return;
        byte[] arrayOfByte = this.Q;
        int i = this.d;
        this.d = (i + 1);
        c = (char)i(arrayOfByte[i]);
      }
      while (!Character.isJavaIdentifierPart(c));
      localStringBuilder.append(c);
    }
  }

  public void close()
    throws IOException
  {
    super.close();
    this.M.b();
  }

  protected j d(int paramInt)
    throws IOException, f
  {
    int i = 1;
    char[] arrayOfChar = this.n.k();
    if (paramInt == 45);
    int k;
    boolean bool;
    for (int j = i; ; bool = false)
    {
      if (j == 0)
        break label305;
      arrayOfChar[0] = '-';
      if (this.d >= this.e)
        o();
      byte[] arrayOfByte2 = this.Q;
      int i6 = this.d;
      this.d = (i6 + 1);
      k = 0xFF & arrayOfByte2[i6];
      if ((k >= 48) && (k <= 57))
        break;
      return a(k, i);
    }
    label305: int n;
    for (int m = i; ; n = 0)
    {
      if (k == 48)
        k = M();
      int i1 = m + 1;
      arrayOfChar[m] = ((char)k);
      int i2 = this.d + arrayOfChar.length;
      if (i2 > this.e)
        i2 = this.e;
      while (true)
      {
        if (this.d >= i2)
          return a(arrayOfChar, i1, bool, i);
        byte[] arrayOfByte1 = this.Q;
        int i3 = this.d;
        this.d = (i3 + 1);
        int i4 = 0xFF & arrayOfByte1[i3];
        if ((i4 < 48) || (i4 > 57))
        {
          if ((i4 != 46) && (i4 != 101) && (i4 != 69))
            break;
          return a(arrayOfChar, i1, i4, bool, i);
        }
        i++;
        int i5 = i1 + 1;
        arrayOfChar[i1] = ((char)i4);
        i1 = i5;
      }
      this.d = (-1 + this.d);
      this.n.a(i1);
      return a(bool, i);
      k = paramInt;
    }
  }

  protected com.c.a.a.d.c e(int paramInt)
    throws IOException, f
  {
    if (paramInt != 34)
      return g(paramInt);
    if (9 + this.d > this.e)
      return F();
    byte[] arrayOfByte = this.Q;
    int[] arrayOfInt = T;
    int i = this.d;
    this.d = (i + 1);
    int j = 0xFF & arrayOfByte[i];
    if (arrayOfInt[j] == 0)
    {
      int k = this.d;
      this.d = (k + 1);
      int m = 0xFF & arrayOfByte[k];
      if (arrayOfInt[m] == 0)
      {
        int n = m | j << 8;
        int i1 = this.d;
        this.d = (i1 + 1);
        int i2 = 0xFF & arrayOfByte[i1];
        if (arrayOfInt[i2] == 0)
        {
          int i3 = i2 | n << 8;
          int i4 = this.d;
          this.d = (i4 + 1);
          int i5 = 0xFF & arrayOfByte[i4];
          if (arrayOfInt[i5] == 0)
          {
            int i6 = i5 | i3 << 8;
            int i7 = this.d;
            this.d = (i7 + 1);
            int i8 = 0xFF & arrayOfByte[i7];
            if (arrayOfInt[i8] == 0)
            {
              this.U = i6;
              return a(i8, arrayOfInt);
            }
            if (i8 == 34)
              return b(i6, 4);
            return a(i6, i8, 4);
          }
          if (i5 == 34)
            return b(i3, 3);
          return a(i3, i5, 3);
        }
        if (i2 == 34)
          return b(n, 2);
        return a(n, i2, 2);
      }
      if (m == 34)
        return b(j, 1);
      return a(j, m, 1);
    }
    if (j == 34)
      return a.d();
    return a(0, j, 0);
  }

  protected com.c.a.a.d.c f(int paramInt)
    throws IOException, f
  {
    int[] arrayOfInt1 = T;
    int i = 2;
    int j = paramInt;
    while (true)
    {
      if (this.e - this.d < 4)
        return a(this.N, i, 0, j, 0);
      byte[] arrayOfByte1 = this.Q;
      int k = this.d;
      this.d = (k + 1);
      int m = 0xFF & arrayOfByte1[k];
      if (arrayOfInt1[m] != 0)
      {
        if (m == 34)
          return a(this.N, i, j, 1);
        return a(this.N, i, j, m, 1);
      }
      int n = m | j << 8;
      byte[] arrayOfByte2 = this.Q;
      int i1 = this.d;
      this.d = (i1 + 1);
      int i2 = 0xFF & arrayOfByte2[i1];
      if (arrayOfInt1[i2] != 0)
      {
        if (i2 == 34)
          return a(this.N, i, n, 2);
        return a(this.N, i, n, i2, 2);
      }
      int i3 = i2 | n << 8;
      byte[] arrayOfByte3 = this.Q;
      int i4 = this.d;
      this.d = (i4 + 1);
      int i5 = 0xFF & arrayOfByte3[i4];
      if (arrayOfInt1[i5] != 0)
      {
        if (i5 == 34)
          return a(this.N, i, i3, 3);
        return a(this.N, i, i3, i5, 3);
      }
      int i6 = i5 | i3 << 8;
      byte[] arrayOfByte4 = this.Q;
      int i7 = this.d;
      this.d = (i7 + 1);
      j = 0xFF & arrayOfByte4[i7];
      if (arrayOfInt1[j] != 0)
      {
        if (j == 34)
          return a(this.N, i, i6, 4);
        return a(this.N, i, i6, j, 4);
      }
      if (i >= this.N.length)
        this.N = a(this.N, i);
      int[] arrayOfInt2 = this.N;
      int i8 = i + 1;
      arrayOfInt2[i] = i6;
      i = i8;
    }
  }

  public String f()
    throws IOException, f
  {
    if (this.K == j.h)
    {
      if (this.O)
      {
        this.O = false;
        q();
      }
      return this.n.f();
    }
    return a(this.K);
  }

  protected com.c.a.a.d.c g(int paramInt)
    throws IOException, f
  {
    if ((paramInt == 39) && (a(g.a.d)))
      return G();
    if (!a(g.a.c))
      b(paramInt, "was expecting double-quote to start field name");
    int[] arrayOfInt1 = com.c.a.a.b.b.d();
    if (arrayOfInt1[paramInt] != 0)
      b(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    int[] arrayOfInt2 = this.N;
    int i = 0;
    int j = 0;
    int k = paramInt;
    int m = 0;
    Object localObject1 = arrayOfInt2;
    com.c.a.a.d.c localc;
    while (true)
    {
      int i2;
      int i3;
      Object localObject2;
      int i1;
      if (i < 4)
      {
        int i6 = i + 1;
        i2 = k | j << 8;
        i3 = m;
        localObject2 = localObject1;
        i1 = i6;
      }
      int i4;
      while (true)
      {
        if ((this.d >= this.e) && (!p()))
          c(" in field name");
        i4 = 0xFF & this.Q[this.d];
        if (arrayOfInt1[i4] == 0)
          break;
        if (i1 > 0)
        {
          if (i3 >= localObject2.length)
          {
            localObject2 = a((int[])localObject2, localObject2.length);
            this.N = ((int[])localObject2);
          }
          int i5 = i3 + 1;
          localObject2[i3] = i2;
          i3 = i5;
        }
        localc = this.M.a((int[])localObject2, i3);
        if (localc != null)
          break label320;
        return a((int[])localObject2, i3, i1);
        if (m >= localObject1.length)
        {
          localObject1 = a((int[])localObject1, localObject1.length);
          this.N = ((int[])localObject1);
        }
        int n = m + 1;
        localObject1[m] = j;
        localObject2 = localObject1;
        i1 = 1;
        i2 = k;
        i3 = n;
      }
      this.d = (1 + this.d);
      j = i2;
      i = i1;
      localObject1 = localObject2;
      m = i3;
      k = i4;
    }
    label320: return localc;
  }

  protected j h(int paramInt)
    throws IOException, f
  {
    switch (paramInt)
    {
    default:
    case 39:
    case 78:
      while (true)
      {
        b(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
        if (a(g.a.d))
        {
          return I();
          a("NaN", 1);
          if (a(g.a.h))
            return a("NaN", (0.0D / 0.0D));
          d("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
    case 43:
    }
    if ((this.d >= this.e) && (!p()))
      D();
    byte[] arrayOfByte = this.Q;
    int i = this.d;
    this.d = (i + 1);
    return a(0xFF & arrayOfByte[i], false);
  }

  protected int i(int paramInt)
    throws IOException, f
  {
    int i;
    if (paramInt < 0)
    {
      if ((paramInt & 0xE0) != 192)
        break label147;
      paramInt &= 31;
      i = 1;
    }
    while (true)
    {
      int j = S();
      if ((j & 0xC0) != 128)
        l(j & 0xFF);
      paramInt = paramInt << 6 | j & 0x3F;
      if (i > 1)
      {
        int k = S();
        if ((k & 0xC0) != 128)
          l(k & 0xFF);
        paramInt = paramInt << 6 | k & 0x3F;
        if (i > 2)
        {
          int m = S();
          if ((m & 0xC0) != 128)
            l(m & 0xFF);
          paramInt = paramInt << 6 | m & 0x3F;
        }
      }
      return paramInt;
      label147: if ((paramInt & 0xF0) == 224)
      {
        paramInt &= 15;
        i = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        paramInt &= 7;
        i = 3;
      }
      else
      {
        k(paramInt & 0xFF);
        i = 1;
      }
    }
  }

  protected void j(int paramInt)
    throws f
  {
    if (paramInt < 32)
      b(paramInt);
    k(paramInt);
  }

  protected void k(int paramInt)
    throws f
  {
    d("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }

  protected void l(int paramInt)
    throws f
  {
    d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }

  protected boolean p()
    throws IOException
  {
    this.f += this.e;
    this.h -= this.e;
    InputStream localInputStream = this.P;
    boolean bool = false;
    int i;
    if (localInputStream != null)
    {
      i = this.P.read(this.Q, 0, this.Q.length);
      if (i <= 0)
        break label74;
      this.d = 0;
      this.e = i;
      bool = true;
    }
    label74: 
    do
    {
      return bool;
      r();
      bool = false;
    }
    while (i != 0);
    throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.Q.length + " bytes");
  }

  protected void q()
    throws IOException, f
  {
    int i = this.d;
    if (i >= this.e)
    {
      o();
      i = this.d;
    }
    char[] arrayOfChar = this.n.k();
    int[] arrayOfInt = S;
    int j = Math.min(this.e, i + arrayOfChar.length);
    byte[] arrayOfByte = this.Q;
    int k = i;
    int m = 0;
    while (k < j)
    {
      int n = 0xFF & arrayOfByte[k];
      if (arrayOfInt[n] != 0)
      {
        if (n != 34)
          break;
        this.d = (k + 1);
        this.n.a(m);
        return;
      }
      int i1 = k + 1;
      int i2 = m + 1;
      arrayOfChar[m] = ((char)n);
      m = i2;
      k = i1;
    }
    this.d = k;
    a(arrayOfChar, m);
  }

  protected void r()
    throws IOException
  {
    if (this.P != null)
    {
      if ((this.b.c()) || (a(g.a.a)))
        this.P.close();
      this.P = null;
    }
  }

  protected void s()
    throws IOException
  {
    super.s();
    if (this.R)
    {
      byte[] arrayOfByte = this.Q;
      if (arrayOfByte != null)
      {
        this.Q = null;
        this.b.a(arrayOfByte);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.g
 * JD-Core Version:    0.6.2
 */