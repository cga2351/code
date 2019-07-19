package com.c.a.a.c;

import com.c.a.a.b.d;
import com.c.a.a.f;
import com.c.a.a.g.a;
import com.c.a.a.j;
import com.c.a.a.k;
import java.io.IOException;
import java.io.Reader;

public final class e extends com.c.a.a.a.b
{
  protected Reader L;
  protected char[] M;
  protected k N;
  protected final com.c.a.a.d.b O;
  protected final int P;
  protected boolean Q = false;

  public e(d paramd, int paramInt, Reader paramReader, k paramk, com.c.a.a.d.b paramb)
  {
    super(paramd, paramInt);
    this.L = paramReader;
    this.M = paramd.g();
    this.N = paramk;
    this.O = paramb;
    this.P = paramb.e();
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

  private char M()
    throws IOException, f
  {
    if ((this.d >= this.e) && (!p()));
    char c;
    do
    {
      c = '0';
      while ((this.d >= this.e) && (!p()))
        do
        {
          return c;
          c = this.M[this.d];
          if ((c < '0') || (c > '9'))
            return '0';
          if (!a(g.a.g))
            b("Leading zeroes not allowed");
          this.d = (1 + this.d);
        }
        while (c != '0');
      c = this.M[this.d];
      if ((c < '0') || (c > '9'))
        return '0';
      this.d = (1 + this.d);
    }
    while (c == '0');
    return c;
  }

  private int N()
    throws IOException, f
  {
    while ((this.d < this.e) || (p()))
    {
      char[] arrayOfChar = this.M;
      int i = this.d;
      this.d = (i + 1);
      int j = arrayOfChar[i];
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
      char[] arrayOfChar = this.M;
      int i = this.d;
      this.d = (i + 1);
      j = arrayOfChar[i];
      if (j > 32)
      {
        if (j != 47)
          break label110;
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
    int j = -1;
    label110: return j;
  }

  private void P()
    throws IOException, f
  {
    if (!a(g.a.b))
      b(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    if ((this.d >= this.e) && (!p()))
      c(" in a comment");
    char[] arrayOfChar = this.M;
    int i = this.d;
    this.d = (i + 1);
    int j = arrayOfChar[i];
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
    while (true)
    {
      int j;
      if ((this.d < this.e) || (p()))
      {
        char[] arrayOfChar = this.M;
        int i = this.d;
        this.d = (i + 1);
        j = arrayOfChar[i];
        if (j <= 42)
          if (j == 42)
            if ((this.d < this.e) || (p()));
      }
      else
      {
        c(" in a comment");
        return;
        if (this.M[this.d] == '/')
        {
          this.d = (1 + this.d);
          return;
          if (j < 32)
            if (j == 10)
              K();
            else if (j == 13)
              J();
            else if (j != 9)
              b(j);
        }
      }
    }
  }

  private void R()
    throws IOException, f
  {
    while (true)
    {
      int j;
      if ((this.d < this.e) || (p()))
      {
        char[] arrayOfChar = this.M;
        int i = this.d;
        this.d = (i + 1);
        j = arrayOfChar[i];
        if (j < 32)
          if (j == 10)
            K();
      }
      else
      {
        return;
        if (j == 13)
        {
          J();
          return;
        }
        if (j != 9)
          b(j);
      }
    }
  }

  private j a(boolean paramBoolean)
    throws IOException, f
  {
    char[] arrayOfChar1 = this.n.k();
    if (paramBoolean)
      arrayOfChar1[0] = '-';
    for (int i = 1; ; i = 0)
    {
      int j;
      int k;
      char[] arrayOfChar2;
      int n;
      label84: int i32;
      int i4;
      int i3;
      int i1;
      char[] arrayOfChar3;
      int i2;
      if (this.d < this.e)
      {
        char[] arrayOfChar11 = this.M;
        int i34 = this.d;
        this.d = (i34 + 1);
        j = arrayOfChar11[i34];
        if (j == 48)
          j = M();
        k = 0;
        int m = j;
        arrayOfChar2 = arrayOfChar1;
        n = m;
        if ((n < 48) || (n > 57))
          break label886;
        k++;
        if (i >= arrayOfChar2.length)
        {
          arrayOfChar2 = this.n.m();
          i = 0;
        }
        i32 = i + 1;
        arrayOfChar2[i] = n;
        if ((this.d < this.e) || (p()))
          break label616;
        i4 = 1;
        i3 = 0;
        i1 = k;
        arrayOfChar3 = arrayOfChar2;
        i2 = i32;
      }
      while (true)
      {
        if (i1 == 0)
          b("Missing integer part (next char " + c(i3) + ")");
        char[] arrayOfChar8;
        int i25;
        int i26;
        int i27;
        int i5;
        int i29;
        label263: int i8;
        int i6;
        char[] arrayOfChar4;
        int i7;
        if (i3 == 46)
        {
          int i24 = i2 + 1;
          arrayOfChar3[i2] = i3;
          arrayOfChar8 = arrayOfChar3;
          i25 = i24;
          i26 = i3;
          i27 = 0;
          if ((this.d >= this.e) && (!p()))
          {
            i5 = i26;
            i29 = 1;
            if (i27 == 0)
              a(i5, "Decimal point not followed by a digit");
            i8 = i27;
            i6 = i25;
            int i30 = i29;
            arrayOfChar4 = arrayOfChar8;
            i7 = i30;
          }
        }
        while (true)
        {
          int i9;
          int i10;
          label381: int i11;
          label415: int i13;
          label466: int i14;
          int i15;
          int i16;
          label477: int i20;
          int i17;
          int i19;
          int i18;
          if ((i5 == 101) || (i5 == 69))
          {
            if (i6 >= arrayOfChar4.length)
            {
              arrayOfChar4 = this.n.m();
              i6 = 0;
            }
            i9 = i6 + 1;
            arrayOfChar4[i6] = i5;
            if (this.d < this.e)
            {
              char[] arrayOfChar7 = this.M;
              int i23 = this.d;
              this.d = (i23 + 1);
              i10 = arrayOfChar7[i23];
              if ((i10 != 45) && (i10 != 43))
                break label818;
              if (i9 < arrayOfChar4.length)
                break label811;
              arrayOfChar4 = this.n.m();
              i11 = 0;
              int i12 = i11 + 1;
              arrayOfChar4[i11] = i10;
              if (this.d >= this.e)
                break label751;
              char[] arrayOfChar6 = this.M;
              int i22 = this.d;
              this.d = (i22 + 1);
              i13 = arrayOfChar6[i22];
              i14 = i13;
              i15 = i12;
              i16 = 0;
              if ((i14 > 57) || (i14 < 48))
                break label796;
              i16++;
              if (i15 >= arrayOfChar4.length)
              {
                arrayOfChar4 = this.n.m();
                i15 = 0;
              }
              i20 = i15 + 1;
              arrayOfChar4[i15] = i14;
              if ((this.d < this.e) || (p()))
                break label762;
              i17 = i16;
              i19 = 1;
              i18 = i20;
              label556: if (i17 == 0)
                a(i14, "Exponent indicator not followed by a digit");
              label569: if (i19 == 0)
                this.d = (-1 + this.d);
              this.n.a(i18);
              return a(paramBoolean, i1, i8, i17);
              j = e("No digit following minus sign");
              break;
              label616: char[] arrayOfChar10 = this.M;
              int i33 = this.d;
              this.d = (i33 + 1);
              n = arrayOfChar10[i33];
              i = i32;
              break label84;
              char[] arrayOfChar9 = this.M;
              int i28 = this.d;
              this.d = (i28 + 1);
              i26 = arrayOfChar9[i28];
              if (i26 < 48)
                break label853;
              if (i26 > 57)
              {
                i5 = i26;
                i29 = i4;
                break label263;
              }
              i27++;
              if (i25 < arrayOfChar8.length)
                break label846;
              arrayOfChar8 = this.n.m();
            }
          }
          label796: label811: label818: label846: for (int i31 = 0; ; i31 = i25)
          {
            i25 = i31 + 1;
            arrayOfChar8[i31] = i26;
            break;
            i10 = e("expected a digit for number exponent");
            break label381;
            label751: i13 = e("expected a digit for number exponent");
            break label466;
            label762: char[] arrayOfChar5 = this.M;
            int i21 = this.d;
            this.d = (i21 + 1);
            i14 = arrayOfChar5[i21];
            i15 = i20;
            break label477;
            i17 = i16;
            i18 = i15;
            i19 = i7;
            break label556;
            i11 = i9;
            break label415;
            i14 = i10;
            i15 = i9;
            i16 = 0;
            break label477;
            i18 = i6;
            i19 = i7;
            i17 = 0;
            break label569;
          }
          label853: i5 = i26;
          i29 = i4;
          break label263;
          i5 = i3;
          arrayOfChar4 = arrayOfChar3;
          i6 = i2;
          i7 = i4;
          i8 = 0;
        }
        label886: i1 = k;
        i2 = i;
        i3 = n;
        arrayOfChar3 = arrayOfChar2;
        i4 = 0;
      }
    }
  }

  private String a(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, f
  {
    this.n.a(this.M, paramInt1, this.d - paramInt1);
    char[] arrayOfChar1 = this.n.j();
    int i = this.n.l();
    while (true)
    {
      if ((this.d >= this.e) && (!p()))
        c(": was expecting closing '" + (char)paramInt3 + "' for name");
      char[] arrayOfChar2 = this.M;
      int j = this.d;
      this.d = (j + 1);
      int k = arrayOfChar2[j];
      if (k <= 92)
        if (k != 92);
      int n;
      for (int m = B(); ; m = k)
      {
        paramInt2 = k + paramInt2 * 33;
        n = i + 1;
        arrayOfChar1[i] = m;
        if (n < arrayOfChar1.length)
          break label259;
        arrayOfChar1 = this.n.m();
        i = 0;
        break;
        if (k <= paramInt3)
        {
          if (k == paramInt3)
          {
            this.n.a(i);
            com.c.a.a.e.e locale = this.n;
            char[] arrayOfChar3 = locale.e();
            int i1 = locale.d();
            int i2 = locale.c();
            return this.O.a(arrayOfChar3, i1, i2, paramInt2);
          }
          if (k < 32)
            c(k, "name");
        }
      }
      label259: i = n;
    }
  }

  private String a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    throws IOException, f
  {
    this.n.a(this.M, paramInt1, this.d - paramInt1);
    char[] arrayOfChar1 = this.n.j();
    int i = this.n.l();
    int j = paramArrayOfInt.length;
    while (true)
    {
      if ((this.d >= this.e) && (!p()));
      int i1;
      while (true)
      {
        this.n.a(i);
        com.c.a.a.e.e locale = this.n;
        char[] arrayOfChar2 = locale.e();
        int m = locale.d();
        int n = locale.c();
        return this.O.a(arrayOfChar2, m, n, paramInt2);
        int k = this.M[this.d];
        if (k <= j)
        {
          if (paramArrayOfInt[k] != 0);
        }
        else
          while (Character.isJavaIdentifierPart(k))
          {
            this.d = (1 + this.d);
            paramInt2 = k + paramInt2 * 33;
            i1 = i + 1;
            arrayOfChar1[i] = k;
            if (i1 < arrayOfChar1.length)
              break label199;
            arrayOfChar1 = this.n.m();
            i = 0;
            break;
          }
      }
      label199: i = i1;
    }
  }

  protected char B()
    throws IOException, f
  {
    int i = 0;
    if ((this.d >= this.e) && (!p()))
      c(" in character escape sequence");
    char[] arrayOfChar1 = this.M;
    int j = this.d;
    this.d = (j + 1);
    char c = arrayOfChar1[j];
    switch (c)
    {
    default:
      c = a(c);
    case '"':
    case '/':
    case '\\':
      return c;
    case 'b':
      return '\b';
    case 't':
      return '\t';
    case 'n':
      return '\n';
    case 'f':
      return '\f';
    case 'r':
      return '\r';
    case 'u':
    }
    for (int k = 0; k < 4; k++)
    {
      if ((this.d >= this.e) && (!p()))
        c(" in character escape sequence");
      char[] arrayOfChar2 = this.M;
      int m = this.d;
      this.d = (m + 1);
      int n = arrayOfChar2[m];
      int i1 = com.c.a.a.b.b.a(n);
      if (i1 < 0)
        b(n, "expected a hex-digit for character escape sequence");
      i = i1 | i << 4;
    }
    return (char)i;
  }

  protected String F()
    throws IOException, f
  {
    int i = this.d;
    int j = this.P;
    int k = this.e;
    int i1;
    if (i < k)
    {
      int[] arrayOfInt = com.c.a.a.b.b.a();
      int n = arrayOfInt.length;
      i1 = this.M[i];
      if (i1 == 39)
      {
        int i2 = this.d;
        this.d = (i + 1);
        return this.O.a(this.M, i2, i - i2, j);
      }
      if ((i1 >= n) || (arrayOfInt[i1] == 0))
        break label113;
    }
    while (true)
    {
      int m = this.d;
      this.d = i;
      return a(m, j, 39);
      label113: j = i1 + j * 33;
      i++;
      if (i < k)
        break;
    }
  }

  protected j G()
    throws IOException, f
  {
    char[] arrayOfChar1 = this.n.k();
    int i = this.n.l();
    if ((this.d >= this.e) && (!p()))
      c(": was expecting closing quote for a string value");
    char[] arrayOfChar2 = this.M;
    int j = this.d;
    this.d = (j + 1);
    int k = arrayOfChar2[j];
    if (k <= 92)
    {
      if (k == 92)
        k = B();
    }
    else
    {
      label86: if (i < arrayOfChar1.length)
        break label162;
      arrayOfChar1 = this.n.m();
    }
    label162: for (int m = 0; ; m = i)
    {
      i = m + 1;
      arrayOfChar1[m] = k;
      break;
      if (k > 39)
        break label86;
      if (k == 39)
      {
        this.n.a(i);
        return j.h;
      }
      if (k >= 32)
        break label86;
      c(k, "string value");
      break label86;
    }
  }

  protected void H()
    throws IOException, f
  {
    char[] arrayOfChar1 = this.n.j();
    int i = this.n.l();
    if ((this.d >= this.e) && (!p()))
      c(": was expecting closing quote for a string value");
    char[] arrayOfChar2 = this.M;
    int j = this.d;
    this.d = (j + 1);
    int k = arrayOfChar2[j];
    if (k <= 92)
    {
      if (k == 92)
        k = B();
    }
    else
    {
      label86: if (i < arrayOfChar1.length)
        break label159;
      arrayOfChar1 = this.n.m();
    }
    label159: for (int m = 0; ; m = i)
    {
      i = m + 1;
      arrayOfChar1[m] = k;
      break;
      if (k > 34)
        break label86;
      if (k == 34)
      {
        this.n.a(i);
        return;
      }
      if (k >= 32)
        break label86;
      c(k, "string value");
      break label86;
    }
  }

  protected void I()
    throws IOException, f
  {
    this.Q = false;
    int i = this.d;
    int j = this.e;
    char[] arrayOfChar = this.M;
    while (true)
    {
      if (i >= j)
      {
        this.d = i;
        if (!p())
          c(": was expecting closing quote for a string value");
        i = this.d;
        j = this.e;
      }
      int k = i + 1;
      int m = arrayOfChar[i];
      if (m <= 92)
      {
        if (m == 92)
        {
          this.d = k;
          B();
          i = this.d;
          j = this.e;
        }
        else if (m <= 34)
        {
          if (m == 34)
          {
            this.d = k;
            return;
          }
          if (m < 32)
          {
            this.d = k;
            c(m, "string value");
          }
        }
      }
      else
        i = k;
    }
  }

  protected void J()
    throws IOException
  {
    if (((this.d < this.e) || (p())) && (this.M[this.d] == '\n'))
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

  public j a()
    throws IOException, f
  {
    this.A = 0;
    if (this.K == j.f)
      return L();
    if (this.Q)
      I();
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
    boolean bool = this.l.c();
    if (bool)
    {
      String str = e(i);
      this.l.a(str);
      this.K = j.f;
      int j = N();
      if (j != 58)
        b(j, "was expecting a colon to separate field name and value");
      i = N();
    }
    j localj1;
    switch (i)
    {
    default:
      localj1 = g(i);
    case 34:
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
    while (bool)
    {
      this.m = localj1;
      return this.K;
      this.Q = true;
      localj1 = j.h;
      continue;
      if (!bool)
        this.l = this.l.a(this.j, this.k);
      localj1 = j.d;
      continue;
      if (!bool)
        this.l = this.l.b(this.j, this.k);
      localj1 = j.b;
      continue;
      b(i, "expected a value");
      a("true", 1);
      localj1 = j.k;
      continue;
      a("false", 1);
      localj1 = j.l;
      continue;
      a("null", 1);
      localj1 = j.m;
      continue;
      localj1 = d(i);
    }
    this.K = localj1;
    return localj1;
  }

  protected j a(int paramInt, boolean paramBoolean)
    throws IOException, f
  {
    double d = (-1.0D / 0.0D);
    if (paramInt == 73)
    {
      if ((this.d >= this.e) && (!p()))
        D();
      char[] arrayOfChar = this.M;
      int i = this.d;
      this.d = (i + 1);
      paramInt = arrayOfChar[i];
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

  protected void a(String paramString, int paramInt)
    throws IOException, f
  {
    int i = paramString.length();
    do
    {
      if ((this.d >= this.e) && (!p()))
        D();
      if (this.M[this.d] != paramString.charAt(paramInt))
        a(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      this.d = (1 + this.d);
      paramInt++;
    }
    while (paramInt < i);
    if ((this.d >= this.e) && (!p()));
    char c;
    do
    {
      return;
      c = this.M[this.d];
    }
    while ((c < '0') || (c == ']') || (c == '}') || (!Character.isJavaIdentifierPart(c)));
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
        d("Unrecognized token '" + localStringBuilder.toString() + "': was expecting ");
        return;
        c = this.M[this.d];
      }
      while (!Character.isJavaIdentifierPart(c));
      this.d = (1 + this.d);
      localStringBuilder.append(c);
    }
  }

  public void close()
    throws IOException
  {
    super.close();
    this.O.b();
  }

  protected j d(int paramInt)
    throws IOException, f
  {
    int i = 1;
    int j = 0;
    int k;
    int m;
    int n;
    int i1;
    if (paramInt == 45)
    {
      k = i;
      m = this.d;
      n = m - 1;
      i1 = this.e;
      if (k == 0)
        break label118;
      if (m < this.e)
        break label75;
    }
    int i14;
    label56: boolean bool;
    label75: int i2;
    label118: int i3;
    label128: int i4;
    int i15;
    int i16;
    label184: int i17;
    int i19;
    int i6;
    int i5;
    while (true)
      if (k != 0)
      {
        i14 = n + 1;
        this.d = i14;
        return a(k);
        bool = false;
        break;
        char[] arrayOfChar6 = this.M;
        i2 = m + 1;
        paramInt = arrayOfChar6[m];
        if ((paramInt > 57) || (paramInt < 48))
        {
          this.d = i2;
          return a(paramInt, i);
          i2 = m;
        }
        if (paramInt != 48)
          if (i2 < this.e)
          {
            char[] arrayOfChar1 = this.M;
            i3 = i2 + 1;
            i4 = arrayOfChar1[i2];
            if ((i4 < 48) || (i4 > 57))
            {
              if (i4 != 46)
                break label482;
              i15 = 0;
              i16 = i3;
              if (i16 >= i1)
                break label403;
              char[] arrayOfChar5 = this.M;
              i17 = i16 + 1;
              int i18 = arrayOfChar5[i16];
              if ((i18 >= 48) && (i18 <= 57))
                break label395;
              if (i15 == 0)
                a(i18, "Decimal point not followed by a digit");
              i19 = i15;
              i6 = i17;
              i5 = i18;
            }
          }
      }
    for (int i7 = i19; ; i7 = 0)
    {
      int i10;
      int i11;
      int i12;
      if (i5 != 101)
      {
        j = 0;
        if (i5 != 69);
      }
      else
      {
        if (i6 >= i1)
          break;
        char[] arrayOfChar2 = this.M;
        i10 = i6 + 1;
        i11 = arrayOfChar2[i6];
        if ((i11 != 45) && (i11 != 43))
          break label469;
        if (i10 >= i1)
          break;
        char[] arrayOfChar3 = this.M;
        i6 = i10 + 1;
        i12 = arrayOfChar3[i10];
      }
      while (true)
      {
        if ((i12 <= 57) && (i12 >= 48))
        {
          j++;
          if (i6 >= i1)
            break;
          char[] arrayOfChar4 = this.M;
          int i13 = i6 + 1;
          i12 = arrayOfChar4[i6];
          i6 = i13;
          continue;
          i++;
          i2 = i3;
          break label128;
          break;
          label395: i15++;
          i16 = i17;
          break label184;
          label403: break;
        }
        if (j == 0)
          a(i12, "Exponent indicator not followed by a digit");
        int i8 = i6 - 1;
        this.d = i8;
        int i9 = i8 - n;
        this.n.a(this.M, n, i9);
        return a(bool, i, i7, j);
        i14 = n;
        break label56;
        label469: i12 = i11;
        i6 = i10;
        j = 0;
      }
      label482: i5 = i4;
      i6 = i3;
    }
  }

  protected char e(String paramString)
    throws IOException, f
  {
    if ((this.d >= this.e) && (!p()))
      c(paramString);
    char[] arrayOfChar = this.M;
    int i = this.d;
    this.d = (i + 1);
    return arrayOfChar[i];
  }

  protected String e(int paramInt)
    throws IOException, f
  {
    if (paramInt != 34)
      return f(paramInt);
    int i = this.d;
    int j = this.P;
    int k = this.e;
    if (i < k)
    {
      int[] arrayOfInt = com.c.a.a.b.b.a();
      int n = arrayOfInt.length;
      do
      {
        int i1 = this.M[i];
        if ((i1 < n) && (arrayOfInt[i1] != 0))
        {
          if (i1 != 34)
            break;
          int i2 = this.d;
          this.d = (i + 1);
          return this.O.a(this.M, i2, i - i2, j);
        }
        j = i1 + j * 33;
        i++;
      }
      while (i < k);
    }
    int m = this.d;
    this.d = i;
    return a(m, j, 34);
  }

  public String f()
    throws IOException, f
  {
    j localj = this.K;
    if (localj == j.h)
    {
      if (this.Q)
      {
        this.Q = false;
        q();
      }
      return this.n.f();
    }
    return a(localj);
  }

  protected String f(int paramInt)
    throws IOException, f
  {
    if ((paramInt == 39) && (a(g.a.d)))
      return F();
    if (!a(g.a.c))
      b(paramInt, "was expecting double-quote to start field name");
    int[] arrayOfInt = com.c.a.a.b.b.c();
    int i = arrayOfInt.length;
    boolean bool;
    int j;
    int k;
    int m;
    if (paramInt < i)
      if ((arrayOfInt[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57)))
      {
        bool = true;
        if (!bool)
          b(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        j = this.d;
        k = this.P;
        m = this.e;
        if (j >= m)
          break label246;
      }
    label226: 
    do
    {
      int i1 = this.M[j];
      if (i1 < i)
      {
        if (arrayOfInt[i1] == 0)
          break label226;
        int i3 = -1 + this.d;
        this.d = j;
        return this.O.a(this.M, i3, j - i3, k);
        bool = false;
        break;
        bool = Character.isJavaIdentifierPart((char)paramInt);
        break;
      }
      if (!Character.isJavaIdentifierPart(i1))
      {
        int i2 = -1 + this.d;
        this.d = j;
        return this.O.a(this.M, i2, j - i2, k);
      }
      k = i1 + k * 33;
      j++;
    }
    while (j < m);
    label246: int n = -1 + this.d;
    this.d = j;
    return a(n, k, arrayOfInt);
  }

  protected j g(int paramInt)
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
          return G();
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
    char[] arrayOfChar = this.M;
    int i = this.d;
    this.d = (i + 1);
    return a(arrayOfChar[i], false);
  }

  protected boolean p()
    throws IOException
  {
    this.f += this.e;
    this.h -= this.e;
    Reader localReader = this.L;
    boolean bool = false;
    int i;
    if (localReader != null)
    {
      i = this.L.read(this.M, 0, this.M.length);
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
    throw new IOException("Reader returned 0 characters when trying to read " + this.e);
  }

  protected void q()
    throws IOException, f
  {
    int i = this.d;
    int j = this.e;
    if (i < j)
    {
      int[] arrayOfInt = com.c.a.a.b.b.a();
      int k = arrayOfInt.length;
      do
      {
        int m = this.M[i];
        if ((m < k) && (arrayOfInt[m] != 0))
        {
          if (m != 34)
            break;
          this.n.a(this.M, this.d, i - this.d);
          this.d = (i + 1);
          return;
        }
        i++;
      }
      while (i < j);
    }
    this.n.b(this.M, this.d, i - this.d);
    this.d = i;
    H();
  }

  protected void r()
    throws IOException
  {
    if (this.L != null)
    {
      if ((this.b.c()) || (a(g.a.a)))
        this.L.close();
      this.L = null;
    }
  }

  protected void s()
    throws IOException
  {
    super.s();
    char[] arrayOfChar = this.M;
    if (arrayOfChar != null)
    {
      this.M = null;
      this.b.a(arrayOfChar);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.c.e
 * JD-Core Version:    0.6.2
 */