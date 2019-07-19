package com.google.d.d;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  private static final char[] b = ")]}'\n".toCharArray();
  int a = 0;
  private final Reader c;
  private boolean d = false;
  private final char[] e = new char[1024];
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private long j;
  private int k;
  private String l;
  private int[] m = new int[32];
  private int n = 0;
  private String[] o;
  private int[] p;

  static
  {
    com.google.d.b.e.a = new com.google.d.b.e()
    {
      public void a(a paramAnonymousa)
        throws IOException
      {
        if ((paramAnonymousa instanceof com.google.d.b.a.e))
        {
          ((com.google.d.b.a.e)paramAnonymousa).o();
          return;
        }
        int i = paramAnonymousa.a;
        if (i == 0)
          i = paramAnonymousa.r();
        if (i == 13)
        {
          paramAnonymousa.a = 9;
          return;
        }
        if (i == 12)
        {
          paramAnonymousa.a = 8;
          return;
        }
        if (i == 14)
        {
          paramAnonymousa.a = 10;
          return;
        }
        throw new IllegalStateException("Expected a name but was " + paramAnonymousa.f() + a.a(paramAnonymousa));
      }
    };
  }

  public a(Reader paramReader)
  {
    int[] arrayOfInt = this.m;
    int i1 = this.n;
    this.n = (i1 + 1);
    arrayOfInt[i1] = 6;
    this.o = new String[32];
    this.p = new int[32];
    if (paramReader == null)
      throw new NullPointerException("in == null");
    this.c = paramReader;
  }

  private void a(int paramInt)
  {
    if (this.n == this.m.length)
    {
      int[] arrayOfInt2 = new int[2 * this.n];
      int[] arrayOfInt3 = new int[2 * this.n];
      String[] arrayOfString = new String[2 * this.n];
      System.arraycopy(this.m, 0, arrayOfInt2, 0, this.n);
      System.arraycopy(this.p, 0, arrayOfInt3, 0, this.n);
      System.arraycopy(this.o, 0, arrayOfString, 0, this.n);
      this.m = arrayOfInt2;
      this.p = arrayOfInt3;
      this.o = arrayOfString;
    }
    int[] arrayOfInt1 = this.m;
    int i1 = this.n;
    this.n = (i1 + 1);
    arrayOfInt1[i1] = paramInt;
  }

  private boolean a(char paramChar)
    throws IOException
  {
    switch (paramChar)
    {
    default:
      return true;
    case '#':
    case '/':
    case ';':
    case '=':
    case '\\':
      v();
    case '\t':
    case '\n':
    case '\f':
    case '\r':
    case ' ':
    case ',':
    case ':':
    case '[':
    case ']':
    case '{':
    case '}':
    }
    return false;
  }

  private boolean a(String paramString)
    throws IOException
  {
    while (true)
    {
      if (this.f + paramString.length() > this.g)
      {
        boolean bool2 = b(paramString.length());
        bool1 = false;
        if (!bool2)
          break label117;
      }
      if (this.e[this.f] != '\n')
        break;
      this.h = (1 + this.h);
      this.i = (1 + this.f);
      this.f = (1 + this.f);
    }
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= paramString.length())
        break label115;
      if (this.e[(i1 + this.f)] != paramString.charAt(i1))
        break;
    }
    label115: boolean bool1 = true;
    label117: return bool1;
  }

  private int b(boolean paramBoolean)
    throws IOException
  {
    char[] arrayOfChar = this.e;
    int i1 = this.f;
    int i2 = this.g;
    while (true)
    {
      int i3;
      if (i1 == i2)
      {
        this.f = i1;
        if (!b(1))
        {
          if (paramBoolean)
            throw new EOFException("End of input" + x());
        }
        else
        {
          i1 = this.f;
          i2 = this.g;
        }
      }
      else
      {
        i3 = i1 + 1;
        int i4 = arrayOfChar[i1];
        if (i4 == 10)
        {
          this.h = (1 + this.h);
          this.i = i3;
          i1 = i3;
          continue;
        }
        if ((i4 == 32) || (i4 == 13))
          break label355;
        if (i4 == 9)
        {
          i1 = i3;
          continue;
        }
        if (i4 == 47)
        {
          this.f = i3;
          if (i3 == i2)
          {
            this.f = (-1 + this.f);
            boolean bool = b(2);
            this.f = (1 + this.f);
            if (!bool)
              return i4;
          }
          v();
          switch (arrayOfChar[this.f])
          {
          default:
            return i4;
          case '*':
            this.f = (1 + this.f);
            if (!a("*/"))
              throw b("Unterminated comment");
            i1 = 2 + this.f;
            i2 = this.g;
            break;
          case '/':
            this.f = (1 + this.f);
            w();
            i1 = this.f;
            i2 = this.g;
            break;
          }
        }
        if (i4 == 35)
        {
          this.f = i3;
          v();
          w();
          i1 = this.f;
          i2 = this.g;
          continue;
        }
        this.f = i3;
        return i4;
      }
      return -1;
      label355: i1 = i3;
    }
  }

  private IOException b(String paramString)
    throws IOException
  {
    throw new d(paramString + x());
  }

  private String b(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int i1 = this.f;
      int i2 = this.g;
      int i3 = i1;
      if (i3 < i2)
      {
        int i4 = i3 + 1;
        char c1 = arrayOfChar[i3];
        if (c1 == paramChar)
        {
          this.f = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          return localStringBuilder.toString();
        }
        if (c1 == '\\')
        {
          this.f = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          localStringBuilder.append(y());
          i1 = this.f;
          i2 = this.g;
          i4 = i1;
        }
        while (true)
        {
          i3 = i4;
          break;
          if (c1 == '\n')
          {
            this.h = (1 + this.h);
            this.i = i4;
          }
        }
      }
      localStringBuilder.append(arrayOfChar, i1, i3 - i1);
      this.f = i3;
    }
    while (b(1));
    throw b("Unterminated string");
  }

  private boolean b(int paramInt)
    throws IOException
  {
    char[] arrayOfChar = this.e;
    this.i -= this.f;
    if (this.g != this.f)
    {
      this.g -= this.f;
      System.arraycopy(arrayOfChar, this.f, arrayOfChar, 0, this.g);
    }
    while (true)
    {
      this.f = 0;
      do
      {
        int i1 = this.c.read(arrayOfChar, this.g, arrayOfChar.length - this.g);
        bool = false;
        if (i1 == -1)
          break;
        this.g = (i1 + this.g);
        if ((this.h == 0) && (this.i == 0) && (this.g > 0) && (arrayOfChar[0] == 65279))
        {
          this.f = (1 + this.f);
          this.i = (1 + this.i);
          paramInt++;
        }
      }
      while (this.g < paramInt);
      boolean bool = true;
      return bool;
      this.g = 0;
    }
  }

  private void c(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.e;
    do
    {
      int i1 = this.f;
      int i2 = this.g;
      int i3 = i1;
      if (i3 < i2)
      {
        int i4 = i3 + 1;
        char c1 = arrayOfChar[i3];
        if (c1 == paramChar)
        {
          this.f = i4;
          return;
        }
        if (c1 == '\\')
        {
          this.f = i4;
          y();
          i4 = this.f;
          i2 = this.g;
        }
        while (true)
        {
          i3 = i4;
          break;
          if (c1 == '\n')
          {
            this.h = (1 + this.h);
            this.i = i4;
          }
        }
      }
      this.f = i3;
    }
    while (b(1));
    throw b("Unterminated string");
  }

  private int o()
    throws IOException
  {
    int i1 = this.e[this.f];
    String str1;
    String str2;
    int i2;
    int i3;
    if ((i1 == 116) || (i1 == 84))
    {
      str1 = "true";
      str2 = "TRUE";
      i2 = 5;
      i3 = str1.length();
    }
    for (int i4 = 1; ; i4++)
    {
      if (i4 >= i3)
        break label170;
      if ((i4 + this.f >= this.g) && (!b(i4 + 1)))
      {
        return 0;
        if ((i1 == 102) || (i1 == 70))
        {
          str1 = "false";
          str2 = "FALSE";
          i2 = 6;
          break;
        }
        if ((i1 == 110) || (i1 == 78))
        {
          str1 = "null";
          str2 = "NULL";
          i2 = 7;
          break;
        }
        return 0;
      }
      int i5 = this.e[(i4 + this.f)];
      if ((i5 != str1.charAt(i4)) && (i5 != str2.charAt(i4)))
        return 0;
    }
    label170: if (((i3 + this.f < this.g) || (b(i3 + 1))) && (a(this.e[(i3 + this.f)])))
      return 0;
    this.f = (i3 + this.f);
    this.a = i2;
    return i2;
  }

  private int s()
    throws IOException
  {
    char[] arrayOfChar = this.e;
    int i1 = this.f;
    int i2 = this.g;
    long l1 = 0L;
    int i3 = 0;
    int i4 = 1;
    int i5 = 0;
    int i6 = 0;
    int i7 = i2;
    int i8 = i1;
    if (i8 + i6 == i7)
    {
      if (i6 == arrayOfChar.length)
        return 0;
      if (b(i6 + 1));
    }
    label96: char c1;
    int i9;
    int i11;
    int i10;
    while (true)
      if ((i5 == 2) && (i4 != 0) && ((l1 != -9223372036854775808L) || (i3 != 0)))
        if (i3 != 0)
        {
          this.j = l1;
          this.f = (i6 + this.f);
          this.a = 15;
          return 15;
          i8 = this.f;
          i7 = this.g;
          c1 = arrayOfChar[(i8 + i6)];
          switch (c1)
          {
          default:
            if ((c1 < '0') || (c1 > '9'))
            {
              if (!a(c1))
                continue;
              return 0;
            }
            break;
          case '-':
            if (i5 == 0)
            {
              i9 = 1;
              int i12 = i4;
              i11 = 1;
              i10 = i12;
            }
            break;
          case '+':
          case 'E':
          case 'e':
          case '.':
          }
        }
    while (true)
    {
      i6++;
      i3 = i11;
      i4 = i10;
      i5 = i9;
      break;
      if (i5 == 5)
      {
        i9 = 6;
        i10 = i4;
        i11 = i3;
      }
      else
      {
        return 0;
        if (i5 == 5)
        {
          i9 = 6;
          i10 = i4;
          i11 = i3;
        }
        else
        {
          return 0;
          if ((i5 == 2) || (i5 == 4))
          {
            i9 = 5;
            i10 = i4;
            i11 = i3;
          }
          else
          {
            return 0;
            if (i5 == 2)
            {
              i9 = 3;
              i10 = i4;
              i11 = i3;
            }
            else
            {
              return 0;
              if ((i5 == 1) || (i5 == 0))
              {
                l1 = -(c1 - '0');
                i9 = 2;
                i10 = i4;
                i11 = i3;
              }
              else
              {
                if (i5 == 2)
                {
                  if (l1 == 0L)
                    return 0;
                  long l2 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1)));
                  for (int i13 = 1; ; i13 = 0)
                  {
                    int i14 = i13 & i4;
                    i11 = i3;
                    l1 = l2;
                    int i15 = i5;
                    i10 = i14;
                    i9 = i15;
                    break;
                  }
                }
                if (i5 == 3)
                {
                  i9 = 4;
                  i10 = i4;
                  i11 = i3;
                }
                else
                {
                  if ((i5 == 5) || (i5 == 6))
                  {
                    i9 = 7;
                    i10 = i4;
                    i11 = i3;
                    continue;
                    l1 = -l1;
                    break label96;
                    if ((i5 == 2) || (i5 == 4) || (i5 == 7))
                    {
                      this.k = i6;
                      this.a = 16;
                      return 16;
                    }
                    return 0;
                  }
                  i9 = i5;
                  i10 = i4;
                  i11 = i3;
                }
              }
            }
          }
        }
      }
    }
  }

  private String t()
    throws IOException
  {
    StringBuilder localStringBuilder = null;
    int i1 = 0;
    while (true)
      if (i1 + this.f < this.g)
      {
        switch (this.e[(i1 + this.f)])
        {
        default:
          i1++;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          v();
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          label178: if (localStringBuilder != null);
          break;
        }
      }
      else
      {
        for (String str = new String(this.e, this.f, i1); ; str = localStringBuilder.toString())
        {
          this.f = (i1 + this.f);
          return str;
          if (i1 < this.e.length)
          {
            if (!b(i1 + 1))
              break label178;
            break;
          }
          if (localStringBuilder == null)
            localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.e, this.f, i1);
          this.f = (i1 + this.f);
          if (b(1))
            break label307;
          i1 = 0;
          break label178;
          localStringBuilder.append(this.e, this.f, i1);
        }
        label307: i1 = 0;
      }
  }

  private void u()
    throws IOException
  {
    do
    {
      int i1 = 0;
      while (i1 + this.f < this.g)
        switch (this.e[(i1 + this.f)])
        {
        default:
          i1++;
          break;
        case '#':
        case '/':
        case ';':
        case '=':
        case '\\':
          v();
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
        case ',':
        case ':':
        case '[':
        case ']':
        case '{':
        case '}':
          this.f = (i1 + this.f);
          return;
        }
      this.f = (i1 + this.f);
    }
    while (b(1));
  }

  private void v()
    throws IOException
  {
    if (!this.d)
      throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
  }

  private void w()
    throws IOException
  {
    int i2;
    do
      if ((this.f < this.g) || (b(1)))
      {
        char[] arrayOfChar = this.e;
        int i1 = this.f;
        this.f = (i1 + 1);
        i2 = arrayOfChar[i1];
        if (i2 == 10)
        {
          this.h = (1 + this.h);
          this.i = this.f;
        }
      }
      else
      {
        return;
      }
    while (i2 != 13);
  }

  private String x()
  {
    int i1 = 1 + this.h;
    int i2 = 1 + (this.f - this.i);
    return " at line " + i1 + " column " + i2 + " path " + p();
  }

  private char y()
    throws IOException
  {
    if ((this.f == this.g) && (!b(1)))
      throw b("Unterminated escape sequence");
    char[] arrayOfChar = this.e;
    int i1 = this.f;
    this.f = (i1 + 1);
    char c1 = arrayOfChar[i1];
    switch (c1)
    {
    default:
      throw b("Invalid escape sequence");
    case 'u':
      if ((4 + this.f > this.g) && (!b(4)))
        throw b("Unterminated escape sequence");
      int i2 = this.f;
      int i3 = i2 + 4;
      c1 = '\000';
      int i4 = i2;
      if (i4 < i3)
      {
        int i5 = this.e[i4];
        int i6 = (char)(c1 << '\004');
        if ((i5 >= 48) && (i5 <= 57))
          c1 = (char)(i6 + (i5 - 48));
        while (true)
        {
          i4++;
          break;
          if ((i5 >= 97) && (i5 <= 102))
          {
            c1 = (char)(i6 + (10 + (i5 - 97)));
          }
          else
          {
            if ((i5 < 65) || (i5 > 70))
              break label313;
            c1 = (char)(i6 + (10 + (i5 - 65)));
          }
        }
        throw new NumberFormatException("\\u" + new String(this.e, this.f, 4));
      }
      this.f = (4 + this.f);
    case '"':
    case '\'':
    case '/':
    case '\\':
      return c1;
    case 't':
      return '\t';
    case 'b':
      return '\b';
    case 'n':
      return '\n';
    case 'r':
      return '\r';
    case 'f':
      label313: return '\f';
    case '\n':
    }
    this.h = (1 + this.h);
    this.i = this.f;
    return c1;
  }

  private void z()
    throws IOException
  {
    b(true);
    this.f = (-1 + this.f);
    if ((this.f + b.length > this.g) && (!b(b.length)))
      return;
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= b.length)
        break label79;
      if (this.e[(i1 + this.f)] != b[i1])
        break;
    }
    label79: this.f += b.length;
  }

  public void a()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 3)
    {
      a(1);
      this.p[(-1 + this.n)] = 0;
      this.a = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + x());
  }

  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void b()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 4)
    {
      this.n = (-1 + this.n);
      int[] arrayOfInt = this.p;
      int i2 = -1 + this.n;
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      this.a = 0;
      return;
    }
    throw new IllegalStateException("Expected END_ARRAY but was " + f() + x());
  }

  public void c()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 1)
    {
      a(3);
      this.a = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + x());
  }

  public void close()
    throws IOException
  {
    this.a = 0;
    this.m[0] = 8;
    this.n = 1;
    this.c.close();
  }

  public void d()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 2)
    {
      this.n = (-1 + this.n);
      this.o[this.n] = null;
      int[] arrayOfInt = this.p;
      int i2 = -1 + this.n;
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      this.a = 0;
      return;
    }
    throw new IllegalStateException("Expected END_OBJECT but was " + f() + x());
  }

  public boolean e()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    return (i1 != 2) && (i1 != 4);
  }

  public b f()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    switch (i1)
    {
    default:
      throw new AssertionError();
    case 1:
      return b.c;
    case 2:
      return b.d;
    case 3:
      return b.a;
    case 4:
      return b.b;
    case 12:
    case 13:
    case 14:
      return b.e;
    case 5:
    case 6:
      return b.h;
    case 7:
      return b.i;
    case 8:
    case 9:
    case 10:
    case 11:
      return b.f;
    case 15:
    case 16:
      return b.g;
    case 17:
    }
    return b.j;
  }

  public String g()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    String str;
    if (i1 == 14)
      str = t();
    while (true)
    {
      this.a = 0;
      this.o[(-1 + this.n)] = str;
      return str;
      if (i1 == 12)
      {
        str = b('\'');
      }
      else
      {
        if (i1 != 13)
          break;
        str = b('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + f() + x());
  }

  public String h()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    String str;
    if (i1 == 10)
      str = t();
    while (true)
    {
      this.a = 0;
      int[] arrayOfInt = this.p;
      int i2 = -1 + this.n;
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      return str;
      if (i1 == 8)
      {
        str = b('\'');
      }
      else if (i1 == 9)
      {
        str = b('"');
      }
      else if (i1 == 11)
      {
        str = this.l;
        this.l = null;
      }
      else if (i1 == 15)
      {
        str = Long.toString(this.j);
      }
      else
      {
        if (i1 != 16)
          break;
        str = new String(this.e, this.f, this.k);
        this.f += this.k;
      }
    }
    throw new IllegalStateException("Expected a string but was " + f() + x());
  }

  public boolean i()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 5)
    {
      this.a = 0;
      int[] arrayOfInt2 = this.p;
      int i3 = -1 + this.n;
      arrayOfInt2[i3] = (1 + arrayOfInt2[i3]);
      return true;
    }
    if (i1 == 6)
    {
      this.a = 0;
      int[] arrayOfInt1 = this.p;
      int i2 = -1 + this.n;
      arrayOfInt1[i2] = (1 + arrayOfInt1[i2]);
      return false;
    }
    throw new IllegalStateException("Expected a boolean but was " + f() + x());
  }

  public void j()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 7)
    {
      this.a = 0;
      int[] arrayOfInt = this.p;
      int i2 = -1 + this.n;
      arrayOfInt[i2] = (1 + arrayOfInt[i2]);
      return;
    }
    throw new IllegalStateException("Expected null but was " + f() + x());
  }

  public double k()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 15)
    {
      this.a = 0;
      int[] arrayOfInt2 = this.p;
      int i3 = -1 + this.n;
      arrayOfInt2[i3] = (1 + arrayOfInt2[i3]);
      return this.j;
    }
    if (i1 == 16)
    {
      this.l = new String(this.e, this.f, this.k);
      this.f += this.k;
    }
    double d1;
    do
      while (true)
      {
        this.a = 11;
        d1 = Double.parseDouble(this.l);
        if ((this.d) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1))))
          break label269;
        throw new d("JSON forbids NaN and infinities: " + d1 + x());
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8);
          for (char c1 = '\''; ; c1 = '"')
          {
            this.l = b(c1);
            break;
          }
        }
        if (i1 != 10)
          break;
        this.l = t();
      }
    while (i1 == 11);
    throw new IllegalStateException("Expected a double but was " + f() + x());
    label269: this.l = null;
    this.a = 0;
    int[] arrayOfInt1 = this.p;
    int i2 = -1 + this.n;
    arrayOfInt1[i2] = (1 + arrayOfInt1[i2]);
    return d1;
  }

  public long l()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 15)
    {
      this.a = 0;
      int[] arrayOfInt3 = this.p;
      int i4 = -1 + this.n;
      arrayOfInt3[i4] = (1 + arrayOfInt3[i4]);
      return this.j;
    }
    if (i1 == 16)
    {
      this.l = new String(this.e, this.f, this.k);
      this.f += this.k;
    }
    long l1;
    while (true)
    {
      this.a = 11;
      double d1 = Double.parseDouble(this.l);
      l1 = ()d1;
      if (l1 == d1)
        break label309;
      throw new NumberFormatException("Expected a long but was " + this.l + x());
      if ((i1 != 8) && (i1 != 9) && (i1 != 10))
        break label271;
      if (i1 != 10)
        break;
      this.l = t();
      try
      {
        long l2 = Long.parseLong(this.l);
        this.a = 0;
        int[] arrayOfInt2 = this.p;
        int i3 = -1 + this.n;
        arrayOfInt2[i3] = (1 + arrayOfInt2[i3]);
        return l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
    if (i1 == 8);
    for (char c1 = '\''; ; c1 = '"')
    {
      this.l = b(c1);
      break;
    }
    label271: throw new IllegalStateException("Expected a long but was " + f() + x());
    label309: this.l = null;
    this.a = 0;
    int[] arrayOfInt1 = this.p;
    int i2 = -1 + this.n;
    arrayOfInt1[i2] = (1 + arrayOfInt1[i2]);
    return l1;
  }

  public int m()
    throws IOException
  {
    int i1 = this.a;
    if (i1 == 0)
      i1 = r();
    if (i1 == 15)
    {
      int i6 = (int)this.j;
      if (this.j != i6)
        throw new NumberFormatException("Expected an int but was " + this.j + x());
      this.a = 0;
      int[] arrayOfInt3 = this.p;
      int i7 = -1 + this.n;
      arrayOfInt3[i7] = (1 + arrayOfInt3[i7]);
      return i6;
    }
    if (i1 == 16)
    {
      this.l = new String(this.e, this.f, this.k);
      this.f += this.k;
    }
    int i2;
    while (true)
    {
      this.a = 11;
      double d1 = Double.parseDouble(this.l);
      i2 = (int)d1;
      if (i2 == d1)
        break label363;
      throw new NumberFormatException("Expected an int but was " + this.l + x());
      if ((i1 != 8) && (i1 != 9) && (i1 != 10))
        break label325;
      if (i1 != 10)
        break;
      this.l = t();
      try
      {
        int i4 = Integer.parseInt(this.l);
        this.a = 0;
        int[] arrayOfInt2 = this.p;
        int i5 = -1 + this.n;
        arrayOfInt2[i5] = (1 + arrayOfInt2[i5]);
        return i4;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
    if (i1 == 8);
    for (char c1 = '\''; ; c1 = '"')
    {
      this.l = b(c1);
      break;
    }
    label325: throw new IllegalStateException("Expected an int but was " + f() + x());
    label363: this.l = null;
    this.a = 0;
    int[] arrayOfInt1 = this.p;
    int i3 = -1 + this.n;
    arrayOfInt1[i3] = (1 + arrayOfInt1[i3]);
    return i2;
  }

  public void n()
    throws IOException
  {
    int i1 = 0;
    int i2 = this.a;
    if (i2 == 0)
      i2 = r();
    if (i2 == 3)
    {
      a(1);
      i1++;
    }
    while (true)
    {
      this.a = 0;
      if (i1 != 0)
        break;
      int[] arrayOfInt = this.p;
      int i3 = -1 + this.n;
      arrayOfInt[i3] = (1 + arrayOfInt[i3]);
      this.o[(-1 + this.n)] = "null";
      return;
      if (i2 == 1)
      {
        a(3);
        i1++;
      }
      else if (i2 == 4)
      {
        this.n = (-1 + this.n);
        i1--;
      }
      else if (i2 == 2)
      {
        this.n = (-1 + this.n);
        i1--;
      }
      else if ((i2 == 14) || (i2 == 10))
      {
        u();
      }
      else if ((i2 == 8) || (i2 == 12))
      {
        c('\'');
      }
      else if ((i2 == 9) || (i2 == 13))
      {
        c('"');
      }
      else if (i2 == 16)
      {
        this.f += this.k;
      }
    }
  }

  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder().append('$');
    int i1 = 0;
    int i2 = this.n;
    if (i1 < i2)
    {
      switch (this.m[i1])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        i1++;
        break;
        localStringBuilder.append('[').append(this.p[i1]).append(']');
        continue;
        localStringBuilder.append('.');
        if (this.o[i1] != null)
          localStringBuilder.append(this.o[i1]);
      }
    }
    return localStringBuilder.toString();
  }

  public final boolean q()
  {
    return this.d;
  }

  int r()
    throws IOException
  {
    int i1 = this.m[(-1 + this.n)];
    int i3;
    if (i1 == 1)
    {
      this.m[(-1 + this.n)] = 2;
      switch (b(true))
      {
      default:
        this.f = (-1 + this.f);
        i3 = o();
        if (i3 == 0)
          break;
      case 93:
      case 44:
      case 59:
      case 39:
      case 34:
      case 91:
      case 123:
      }
    }
    do
    {
      return i3;
      if (i1 == 2)
      {
        switch (b(true))
        {
        case 44:
        default:
          throw b("Unterminated array");
        case 93:
          this.a = 4;
          return 4;
        case 59:
        }
        v();
        break;
      }
      if ((i1 == 3) || (i1 == 5))
      {
        this.m[(-1 + this.n)] = 4;
        if (i1 == 5)
          switch (b(true))
          {
          default:
            throw b("Unterminated object");
          case 125:
            this.a = 2;
            return 2;
          case 59:
            v();
          case 44:
          }
        int i2 = b(true);
        switch (i2)
        {
        default:
          v();
          this.f = (-1 + this.f);
          if (a((char)i2))
          {
            this.a = 14;
            return 14;
          }
          break;
        case 34:
          this.a = 13;
          return 13;
        case 39:
          v();
          this.a = 12;
          return 12;
        case 125:
          if (i1 != 5)
          {
            this.a = 2;
            return 2;
          }
          throw b("Expected name");
        }
        throw b("Expected name");
      }
      if (i1 == 4)
      {
        this.m[(-1 + this.n)] = 5;
        switch (b(true))
        {
        case 58:
        case 59:
        case 60:
        default:
          throw b("Expected ':'");
        case 61:
        }
        v();
        if (((this.f >= this.g) && (!b(1))) || (this.e[this.f] != '>'))
          break;
        this.f = (1 + this.f);
        break;
      }
      if (i1 == 6)
      {
        if (this.d)
          z();
        this.m[(-1 + this.n)] = 7;
        break;
      }
      if (i1 == 7)
      {
        if (b(false) == -1)
        {
          this.a = 17;
          return 17;
        }
        v();
        this.f = (-1 + this.f);
        break;
      }
      if (i1 != 8)
        break;
      throw new IllegalStateException("JsonReader is closed");
      if (i1 == 1)
      {
        this.a = 4;
        return 4;
      }
      if ((i1 == 1) || (i1 == 2))
      {
        v();
        this.f = (-1 + this.f);
        this.a = 7;
        return 7;
      }
      throw b("Unexpected value");
      v();
      this.a = 8;
      return 8;
      this.a = 9;
      return 9;
      this.a = 3;
      return 3;
      this.a = 1;
      return 1;
      i3 = s();
    }
    while (i3 != 0);
    if (!a(this.e[this.f]))
      throw b("Expected value");
    v();
    this.a = 10;
    return 10;
  }

  public String toString()
  {
    return getClass().getSimpleName() + x();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.d.a
 * JD-Core Version:    0.6.2
 */