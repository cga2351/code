package com.c.a.a.d;

import com.c.a.a.e.d;
import java.util.Arrays;

public final class b
{
  static final b a = new b();
  protected b b;
  protected final boolean c;
  protected final boolean d;
  protected String[] e;
  protected a[] f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected boolean k;
  private final int l;

  private b()
  {
    this.d = true;
    this.c = true;
    this.k = true;
    this.l = 0;
    this.j = 0;
    d(64);
  }

  private b(b paramb, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, a[] paramArrayOfa, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramb;
    this.d = paramBoolean1;
    this.c = paramBoolean2;
    this.e = paramArrayOfString;
    this.f = paramArrayOfa;
    this.g = paramInt1;
    this.l = paramInt2;
    int m = paramArrayOfString.length;
    this.h = e(m);
    this.i = (m - 1);
    this.j = paramInt3;
    this.k = false;
  }

  public static b a()
  {
    long l1 = System.currentTimeMillis();
    return a(0x1 | (int)l1 + (int)(l1 >>> 32));
  }

  protected static b a(int paramInt)
  {
    return a.f(paramInt);
  }

  private void a(b paramb)
  {
    if ((paramb.c() > 12000) || (paramb.j > 63))
      try
      {
        d(64);
        this.k = false;
        return;
      }
      finally
      {
      }
    if (paramb.c() > c())
      try
      {
        this.e = paramb.e;
        this.f = paramb.f;
        this.g = paramb.g;
        this.h = paramb.h;
        this.i = paramb.i;
        this.j = paramb.j;
        this.k = false;
        return;
      }
      finally
      {
      }
  }

  private void d(int paramInt)
  {
    this.e = new String[paramInt];
    this.f = new a[paramInt >> 1];
    this.i = (paramInt - 1);
    this.g = 0;
    this.j = 0;
    this.h = e(paramInt);
  }

  private static int e(int paramInt)
  {
    return paramInt - (paramInt >> 2);
  }

  private b f(int paramInt)
  {
    return new b(null, true, true, this.e, this.f, this.g, paramInt, this.j);
  }

  private void f()
  {
    String[] arrayOfString = this.e;
    int m = arrayOfString.length;
    this.e = new String[m];
    System.arraycopy(arrayOfString, 0, this.e, 0, m);
    a[] arrayOfa = this.f;
    int n = arrayOfa.length;
    this.f = new a[n];
    System.arraycopy(arrayOfa, 0, this.f, 0, n);
  }

  private void g()
  {
    int m = this.e.length;
    int n = m + m;
    if (n > 65536)
    {
      this.g = 0;
      Arrays.fill(this.e, null);
      Arrays.fill(this.f, null);
      this.k = true;
    }
    label153: int i6;
    do
    {
      return;
      String[] arrayOfString = this.e;
      a[] arrayOfa = this.f;
      this.e = new String[n];
      this.f = new a[n >> 1];
      this.i = (n - 1);
      this.h = e(n);
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      if (i1 < m)
      {
        String str2 = arrayOfString[i1];
        int i11;
        if (str2 != null)
        {
          i3++;
          i11 = b(a(str2));
          if (this.e[i11] != null)
            break label153;
          this.e[i11] = str2;
        }
        while (true)
        {
          i1++;
          break;
          int i12 = i11 >> 1;
          a locala4 = new a(str2, this.f[i12]);
          this.f[i12] = locala4;
          i2 = Math.max(i2, locala4.c());
        }
      }
      int i4 = m >> 1;
      int i5 = 0;
      i6 = i3;
      int i8;
      for (int i7 = i2; i5 < i4; i7 = i8)
      {
        a locala1 = arrayOfa[i5];
        i8 = i7;
        a locala2 = locala1;
        if (locala2 != null)
        {
          i6++;
          String str1 = locala2.a();
          int i9 = b(a(str1));
          if (this.e[i9] == null)
            this.e[i9] = str1;
          while (true)
          {
            locala2 = locala2.b();
            break;
            int i10 = i9 >> 1;
            a locala3 = new a(str1, this.f[i10]);
            this.f[i10] = locala3;
            i8 = Math.max(i8, locala3.c());
          }
        }
        i5++;
      }
      this.j = i7;
    }
    while (i6 == this.g);
    throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + i6 + ".");
  }

  public int a(String paramString)
  {
    int m = paramString.length();
    int n = this.l;
    int i1 = 0;
    while (i1 < m)
    {
      int i2 = n * 33 + paramString.charAt(i1);
      i1++;
      n = i2;
    }
    if (n == 0)
      n = 1;
    return n;
  }

  public int a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int m = this.l;
    int n = 0;
    while (n < paramInt2)
    {
      int i1 = m * 33 + paramArrayOfChar[n];
      n++;
      m = i1;
    }
    if (m == 0)
      m = 1;
    return m;
  }

  public b a(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      String[] arrayOfString = this.e;
      a[] arrayOfa = this.f;
      int m = this.g;
      int n = this.l;
      int i1 = this.j;
      return new b(this, paramBoolean1, paramBoolean2, arrayOfString, arrayOfa, m, n, i1);
    }
    finally
    {
    }
  }

  public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    String str2;
    if (paramInt2 < 1)
    {
      str2 = "";
      return str2;
    }
    if (!this.d)
      return new String(paramArrayOfChar, paramInt1, paramInt2);
    int m = b(paramInt3);
    String str1 = this.e[m];
    if (str1 != null)
    {
      if (str1.length() == paramInt2)
      {
        int i2 = 0;
        if (str1.charAt(i2) != paramArrayOfChar[(paramInt1 + i2)]);
        while (true)
        {
          if (i2 != paramInt2)
            break label101;
          return str1;
          i2++;
          if (i2 < paramInt2)
            break;
        }
      }
      label101: a locala2 = this.f[(m >> 1)];
      if (locala2 != null)
      {
        String str3 = locala2.a(paramArrayOfChar, paramInt1, paramInt2);
        if (str3 != null)
          return str3;
      }
    }
    int n;
    if (!this.k)
    {
      f();
      this.k = true;
      n = m;
    }
    while (true)
    {
      str2 = new String(paramArrayOfChar, paramInt1, paramInt2);
      if (this.c)
        str2 = d.a.a(str2);
      this.g = (1 + this.g);
      if (this.e[n] == null)
      {
        this.e[n] = str2;
        return str2;
        if (this.g >= this.h)
        {
          g();
          n = b(a(paramArrayOfChar, paramInt1, paramInt2));
        }
      }
      else
      {
        int i1 = n >> 1;
        a locala1 = new a(str2, this.f[i1]);
        this.f[i1] = locala1;
        this.j = Math.max(locala1.c(), this.j);
        if (this.j <= 255)
          break;
        c(255);
        return str2;
        n = m;
      }
    }
  }

  public int b(int paramInt)
  {
    return paramInt + (paramInt >>> 15) & this.i;
  }

  public void b()
  {
    if (!d());
    while (this.b == null)
      return;
    this.b.a(this);
    this.k = false;
  }

  public int c()
  {
    return this.g;
  }

  protected void c(int paramInt)
  {
    throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.g + ") now exceeds maximum, " + paramInt + " -- suspect a DoS attack based on hash collisions");
  }

  public boolean d()
  {
    return this.k;
  }

  public int e()
  {
    return this.l;
  }

  static final class a
  {
    private final String a;
    private final a b;
    private final int c;

    public a(String paramString, a parama)
    {
      this.a = paramString;
      this.b = parama;
      if (parama == null);
      for (int i = 1; ; i = 1 + parama.c)
      {
        this.c = i;
        return;
      }
    }

    public String a()
    {
      return this.a;
    }

    public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      String str = this.a;
      for (a locala = this.b; ; locala = locala.b())
      {
        if (str.length() == paramInt2)
        {
          int i = 0;
          if (str.charAt(i) != paramArrayOfChar[(paramInt1 + i)]);
          while (true)
          {
            if (i != paramInt2)
              break label61;
            return str;
            i++;
            if (i < paramInt2)
              break;
          }
        }
        label61: if (locala == null)
          return null;
        str = locala.a();
      }
    }

    public a b()
    {
      return this.b;
    }

    public int c()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.c.a.a.d.b
 * JD-Core Version:    0.6.2
 */