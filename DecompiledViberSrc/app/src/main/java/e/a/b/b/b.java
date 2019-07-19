package e.a.b.b;

import e.a.b.d.f;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

abstract class b
{
  protected static boolean[] c = new boolean[126];
  protected static boolean[] d = new boolean[126];
  protected static boolean[] e = new boolean[126];
  protected static boolean[] f = new boolean[126];
  protected static boolean[] g = new boolean[126];
  protected char a;
  e.a.b.d.e b;
  protected final a h = new a(15);
  protected Object i;
  protected String j;
  protected int k;
  protected final boolean l;
  protected final boolean m;
  protected final boolean n;
  protected final boolean o;
  protected final boolean p;
  protected final boolean q;
  protected final boolean r;
  protected final boolean s;
  protected final boolean t;
  protected final boolean u;
  protected final boolean v;
  private String w;

  static
  {
    boolean[] arrayOfBoolean1 = e;
    e[26] = true;
    arrayOfBoolean1[58] = true;
    boolean[] arrayOfBoolean2 = f;
    boolean[] arrayOfBoolean3 = f;
    f[26] = true;
    arrayOfBoolean3[125] = true;
    arrayOfBoolean2[44] = true;
    boolean[] arrayOfBoolean4 = d;
    boolean[] arrayOfBoolean5 = d;
    d[26] = true;
    arrayOfBoolean5[93] = true;
    arrayOfBoolean4[44] = true;
    g[26] = true;
    boolean[] arrayOfBoolean6 = c;
    c[58] = true;
    arrayOfBoolean6[44] = true;
    boolean[] arrayOfBoolean7 = c;
    boolean[] arrayOfBoolean8 = c;
    c[26] = true;
    arrayOfBoolean8[125] = true;
    arrayOfBoolean7[93] = true;
  }

  public b(int paramInt)
  {
    boolean bool2;
    boolean bool3;
    label41: boolean bool4;
    label56: boolean bool5;
    label72: boolean bool6;
    label88: boolean bool7;
    label104: boolean bool8;
    label120: boolean bool9;
    label137: boolean bool10;
    label157: boolean bool11;
    if ((paramInt & 0x4) > 0)
    {
      bool2 = bool1;
      this.m = bool2;
      if ((paramInt & 0x2) <= 0)
        break label199;
      bool3 = bool1;
      this.n = bool3;
      if ((paramInt & 0x1) <= 0)
        break label205;
      bool4 = bool1;
      this.o = bool4;
      if ((paramInt & 0x8) <= 0)
        break label211;
      bool5 = bool1;
      this.s = bool5;
      if ((paramInt & 0x10) <= 0)
        break label217;
      bool6 = bool1;
      this.u = bool6;
      if ((paramInt & 0x20) <= 0)
        break label223;
      bool7 = bool1;
      this.l = bool7;
      if ((paramInt & 0x40) <= 0)
        break label229;
      bool8 = bool1;
      this.p = bool8;
      if ((paramInt & 0x80) <= 0)
        break label235;
      bool9 = bool1;
      this.t = bool9;
      if ((paramInt & 0x300) == 768)
        break label241;
      bool10 = bool1;
      this.q = bool10;
      if ((paramInt & 0x200) != 0)
        break label247;
      bool11 = bool1;
      label174: this.r = bool11;
      if ((paramInt & 0x400) <= 0)
        break label253;
    }
    while (true)
    {
      this.v = bool1;
      return;
      bool2 = false;
      break;
      label199: bool3 = false;
      break label41;
      label205: bool4 = false;
      break label56;
      label211: bool5 = false;
      break label72;
      label217: bool6 = false;
      break label88;
      label223: bool7 = false;
      break label104;
      label229: bool8 = false;
      break label120;
      label235: bool9 = false;
      break label137;
      label241: bool10 = false;
      break label157;
      label247: bool11 = false;
      break label174;
      label253: bool1 = false;
    }
  }

  protected char a(int paramInt)
    throws e, IOException
  {
    int i1 = 0;
    int i2 = 0;
    if (i2 >= paramInt)
      return (char)i1;
    int i3 = i1 * 16;
    d();
    if ((this.a <= '9') && (this.a >= '0'))
      i1 = i3 + ('￐' + this.a);
    while (true)
    {
      i2++;
      break;
      if ((this.a <= 'F') && (this.a >= 'A'))
      {
        i1 = i3 + (10 + ('﾿' + this.a));
      }
      else
      {
        if ((this.a < 'a') || (this.a > 'f'))
          break label127;
        i1 = i3 + (10 + ('ﾟ' + this.a));
      }
    }
    label127: if (this.a == '\032')
      throw new e(this.k, 3, "EOF");
    throw new e(this.k, 4, Character.valueOf(this.a));
  }

  protected Number a(String paramString)
    throws e
  {
    int i1 = 1;
    int i2 = paramString.length();
    int i3 = 19;
    int i4;
    if (paramString.charAt(0) == '-')
    {
      i3 = 20;
      if ((!this.l) && (i2 >= 3) && (paramString.charAt(i1) == '0'))
        throw new e(this.k, 6, paramString);
    }
    else
    {
      if ((!this.l) && (i2 >= 2) && (paramString.charAt(0) == '0'))
        throw new e(this.k, 6, paramString);
      i4 = 0;
    }
    for (int i5 = 0; ; i5 = i1)
    {
      int i6;
      int i7;
      long l1;
      if (i2 < i3)
      {
        i6 = i2;
        i7 = 0;
        l1 = 0L;
        label120: if (i5 < i6)
          break label186;
        if (i7 == 0)
          break label355;
        if (l1 <= -922337203685477580L)
          break label222;
        i1 = 0;
      }
      while (true)
      {
        if (i1 == 0)
          break label268;
        return new BigInteger(paramString, 10);
        if (i2 > i3)
          return new BigInteger(paramString, 10);
        i6 = i2 - 1;
        i7 = i1;
        break;
        label186: long l2 = l1 * 10L;
        int i8 = i5 + 1;
        l1 = l2 + ('0' - paramString.charAt(i5));
        i5 = i8;
        break label120;
        label222: if (l1 >= -922337203685477580L)
          if (i4 != 0)
          {
            if (paramString.charAt(i5) <= '8')
              i1 = 0;
          }
          else if (paramString.charAt(i5) <= '7')
            i1 = 0;
      }
      label268: label355: for (long l3 = 10L * l1 + ('0' - paramString.charAt(i5)); ; l3 = l1)
      {
        if (i4 != 0)
        {
          if ((this.u) && (l3 >= -2147483648L))
            return Integer.valueOf((int)l3);
          return Long.valueOf(l3);
        }
        long l4 = -l3;
        if ((this.u) && (l4 <= 2147483647L))
          return Integer.valueOf((int)l4);
        return Long.valueOf(l4);
      }
      i4 = i1;
    }
  }

  protected <T> T a(f<T> paramf)
    throws e
  {
    this.k = -1;
    Object localObject;
    try
    {
      d();
      localObject = c(paramf);
      if (this.q)
      {
        if (!this.r)
          j();
        if (this.a != '\032')
          throw new e(-1 + this.k, 1, Character.valueOf(this.a));
      }
    }
    catch (IOException localIOException)
    {
      throw new e(this.k, localIOException);
    }
    this.j = null;
    this.i = null;
    return localObject;
  }

  protected Object a(f<?> paramf, boolean[] paramArrayOfBoolean)
    throws e, IOException
  {
    while (true)
      switch (this.a)
      {
      default:
        a(paramArrayOfBoolean);
        if (this.n)
          break;
        throw new e(this.k, 1, this.j);
      case '\t':
      case '\n':
      case '\r':
      case ' ':
        d();
      case ':':
      case ']':
      case '}':
      case '{':
      case '[':
      case '"':
      case '\'':
      case 'n':
      case 'f':
      case 't':
      case 'N':
      case '-':
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      }
    throw new e(this.k, 0, Character.valueOf(this.a));
    return d(paramf.a(this.w));
    return b(paramf.b(this.w));
    g();
    return this.j;
    a(paramArrayOfBoolean);
    if ("null".equals(this.j))
      return null;
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return this.j;
    a(paramArrayOfBoolean);
    if ("false".equals(this.j))
      return Boolean.FALSE;
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return this.j;
    a(paramArrayOfBoolean);
    if ("true".equals(this.j))
      return Boolean.TRUE;
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return this.j;
    a(paramArrayOfBoolean);
    if (!this.m)
      throw new e(this.k, 1, this.j);
    if ("NaN".equals(this.j))
      return Float.valueOf((0.0F / 0.0F));
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return this.j;
    return b(paramArrayOfBoolean);
    return this.j;
  }

  public void a()
    throws e
  {
    if (this.s)
      return;
    int i1 = this.j.length();
    int i2 = 0;
    label18: char c1;
    if (i2 < i1)
    {
      c1 = this.j.charAt(i2);
      if (c1 >= 0)
        break label42;
    }
    label42: 
    do
    {
      i2++;
      break label18;
      break;
      if (c1 <= '\037')
        throw new e(i2 + this.k, 0, Character.valueOf(c1));
    }
    while ((c1 != '') || (!this.v));
    throw new e(i2 + this.k, 0, Character.valueOf(c1));
  }

  protected abstract void a(boolean[] paramArrayOfBoolean)
    throws IOException;

  protected <T> T b(f<T> paramf)
    throws e, IOException
  {
    Object localObject = paramf.a();
    if (this.a != '[')
      throw new RuntimeException("Internal Error");
    d();
    if ((this.a == ',') && (!this.p))
    {
      throw new e(this.k, 0, Character.valueOf(this.a));
      d();
    }
    while (true)
    {
      int i1;
      switch (this.a)
      {
      case '\t':
      case '\n':
      case '\r':
      case ' ':
      default:
        paramf.a(localObject, a(paramf, d));
        i1 = 0;
        break;
      case ']':
        if ((i1 != 0) && (!this.p))
          throw new e(this.k, 0, Character.valueOf(this.a));
        d();
        return paramf.a(localObject);
      case ':':
      case '}':
        throw new e(this.k, 0, Character.valueOf(this.a));
      case ',':
        if ((i1 != 0) && (!this.p))
          throw new e(this.k, 0, Character.valueOf(this.a));
        d();
        i1 = 1;
        break;
      case '\032':
        throw new e(-1 + this.k, 3, "EOF");
        i1 = 0;
      }
    }
  }

  protected abstract Object b(boolean[] paramArrayOfBoolean)
    throws e, IOException;

  public void b()
    throws e
  {
    int i1 = this.j.length();
    if (i1 == 1);
    int i2;
    int i3;
    do
    {
      int i4;
      do
      {
        do
        {
          return;
          if (i1 != 2)
            break;
        }
        while (!this.j.equals("00"));
        throw new e(this.k, 6, this.j);
        i2 = this.j.charAt(0);
        i3 = this.j.charAt(1);
        if (i2 != 45)
          break;
        i4 = this.j.charAt(2);
      }
      while ((i3 != 48) || (i4 < 48) || (i4 > 57));
      throw new e(this.k, 6, this.j);
    }
    while ((i2 != 48) || (i3 < 48) || (i3 > 57));
    throw new e(this.k, 6, this.j);
  }

  protected Number c()
    throws e
  {
    if (!this.l)
      b();
    if (!this.t)
      return Float.valueOf(Float.parseFloat(this.j));
    if (this.j.length() > 18)
      return new BigDecimal(this.j);
    return Double.valueOf(Double.parseDouble(this.j));
  }

  protected <T> T c(f<T> paramf)
    throws e, IOException
  {
    while (true)
      switch (this.a)
      {
      default:
        a(g);
        if (this.n)
          break;
        throw new e(this.k, 1, this.j);
      case '\t':
      case '\n':
      case '\r':
      case ' ':
        d();
      case ':':
      case ']':
      case '}':
      case '{':
      case '[':
      case '"':
      case '\'':
      case 'n':
      case 'f':
      case 't':
      case 'N':
      case '-':
      case '0':
      case '1':
      case '2':
      case '3':
      case '4':
      case '5':
      case '6':
      case '7':
      case '8':
      case '9':
      }
    throw new e(this.k, 0, Character.valueOf(this.a));
    return d(paramf);
    return b(paramf);
    g();
    return paramf.a(this.j);
    a(g);
    if ("null".equals(this.j))
      return null;
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return paramf.a(this.j);
    a(g);
    if ("false".equals(this.j))
      return paramf.a(Boolean.FALSE);
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return paramf.a(this.j);
    a(g);
    if ("true".equals(this.j))
      return paramf.a(Boolean.TRUE);
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return paramf.a(this.j);
    a(g);
    if (!this.m)
      throw new e(this.k, 1, this.j);
    if ("NaN".equals(this.j))
      return paramf.a(Float.valueOf((0.0F / 0.0F)));
    if (!this.n)
      throw new e(this.k, 1, this.j);
    return paramf.a(this.j);
    this.i = b(g);
    return paramf.a(this.i);
    return paramf.a(this.j);
  }

  protected void c(boolean[] paramArrayOfBoolean)
    throws IOException
  {
    while (true)
    {
      if ((this.a == '\032') || ((this.a >= 0) && (this.a < '~') && (paramArrayOfBoolean[this.a] != 0)))
        return;
      f();
    }
  }

  protected <T> T d(f<T> paramf)
    throws e, IOException
  {
    if (this.a != '{')
      throw new RuntimeException("Internal Error");
    Object localObject = paramf.b();
    int i1 = 0;
    while (true)
    {
      d();
      switch (this.a)
      {
      case '\t':
      case '\n':
      case '\r':
      case ' ':
      default:
        if ((this.a == '"') || (this.a == '\''))
          g();
        break;
      case ':':
      case '[':
      case ']':
      case '{':
      case '}':
      case ',':
      }
      String str;
      do
      {
        str = this.j;
        j();
        if (this.a == ':')
          break label340;
        if (this.a != '\032')
          break label318;
        throw new e(-1 + this.k, 3, null);
        throw new e(this.k, 0, Character.valueOf(this.a));
        if ((i1 != 0) && (!this.p))
          throw new e(this.k, 0, Character.valueOf(this.a));
        d();
        return paramf.a(localObject);
        if ((i1 != 0) && (!this.p))
          throw new e(this.k, 0, Character.valueOf(this.a));
        i1 = 1;
        break;
        a(e);
      }
      while (this.n);
      throw new e(this.k, 1, this.j);
      label318: throw new e(-1 + this.k, 0, Character.valueOf(this.a));
      label340: e();
      this.w = str;
      paramf.a(localObject, str, a(paramf, f));
      this.w = null;
      j();
      if (this.a == '}')
      {
        d();
        return paramf.a(localObject);
      }
      if (this.a == '\032')
        throw new e(-1 + this.k, 3, null);
      if (this.a != ',')
        break;
      i1 = 1;
    }
    throw new e(-1 + this.k, 1, Character.valueOf(this.a));
  }

  protected abstract void d()
    throws IOException;

  protected abstract void e()
    throws e, IOException;

  abstract void f()
    throws IOException;

  protected abstract void g()
    throws e, IOException;

  protected void h()
    throws e, IOException
  {
    int i1 = this.a;
    d();
    switch (this.a)
    {
    default:
    case '\032':
    case '"':
    case '\'':
    case '\\':
    case '\000':
    case '\001':
    case '\002':
    case '\003':
    case '\004':
    case '\005':
    case '\006':
    case '\007':
    case '\b':
    case '\t':
    case '\n':
    case '\013':
    case '\f':
    case '\r':
    case '\016':
    case '\017':
    case '\020':
    case '\021':
    case '\022':
    case '\023':
    case '\024':
    case '\025':
    case '\026':
    case '\027':
    case '\030':
    case '\031':
    case '\033':
    case '\034':
    case '\035':
    case '\036':
    case '\037':
    case '':
    }
    do
    {
      this.h.a(this.a);
      break;
      throw new e(-1 + this.k, 3, null);
      if (i1 == this.a)
      {
        d();
        this.j = this.h.toString();
        return;
      }
      this.h.a(this.a);
      break;
      d();
      switch (this.a)
      {
      default:
        break;
      case '"':
        this.h.a('"');
        break;
      case 't':
        this.h.a('\t');
        break;
      case 'n':
        this.h.a('\n');
        break;
      case 'r':
        this.h.a('\r');
        break;
      case 'f':
        this.h.a('\f');
        break;
      case 'b':
        this.h.a('\b');
        break;
      case '\\':
        this.h.a('\\');
        break;
      case '/':
        this.h.a('/');
        break;
      case '\'':
        this.h.a('\'');
        break;
      case 'u':
        this.h.a(a(4));
        break;
      case 'x':
        this.h.a(a(2));
        break;
        if (this.s)
          break;
        throw new e(this.k, 0, Character.valueOf(this.a));
        if (this.s)
          break;
      }
    }
    while (!this.v);
    throw new e(this.k, 0, Character.valueOf(this.a));
  }

  protected void i()
    throws IOException
  {
    while (true)
    {
      if ((this.a < '0') || (this.a > '9'))
        return;
      f();
    }
  }

  protected void j()
    throws IOException
  {
    while (true)
    {
      if ((this.a > ' ') || (this.a == '\032'))
        return;
      f();
    }
  }

  public static class a
  {
    char[] a;
    int b;

    public a(int paramInt)
    {
      this.a = new char[paramInt];
      this.b = -1;
    }

    public void a()
    {
      this.b = -1;
    }

    public void a(char paramChar)
    {
      this.b = (1 + this.b);
      if (this.a.length <= this.b)
      {
        char[] arrayOfChar = new char[1 + 2 * this.a.length];
        System.arraycopy(this.a, 0, arrayOfChar, 0, this.a.length);
        this.a = arrayOfChar;
      }
      this.a[this.b] = paramChar;
    }

    public String toString()
    {
      return new String(this.a, 0, 1 + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.b.b.b
 * JD-Core Version:    0.6.2
 */