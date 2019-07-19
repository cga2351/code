package com.google.e.f.a.a.a;

import com.google.e.c.a;
import com.google.e.g;
import com.google.e.j;

final class s
{
  private final a a;
  private final m b = new m();
  private final StringBuilder c = new StringBuilder();

  s(a parama)
  {
    this.a = parama;
  }

  static int a(a parama, int paramInt1, int paramInt2)
  {
    int i = 0;
    for (int j = 0; j < paramInt2; j++)
      if (parama.a(paramInt1 + j))
        i |= 1 << -1 + (paramInt2 - j);
    return i;
  }

  private o a()
    throws g
  {
    int i = this.b.a();
    l locall;
    boolean bool;
    label28: int j;
    if (this.b.b())
    {
      locall = d();
      bool = locall.b();
      if (i == this.b.a())
        break label92;
      j = 1;
      label42: if ((j != 0) || (bool))
        break label98;
    }
    while (true)
    {
      return locall.a();
      if (this.b.c())
      {
        locall = c();
        bool = locall.b();
        break label28;
      }
      locall = b();
      bool = locall.b();
      break label28;
      label92: j = 0;
      break label42;
      label98: if (!bool)
        break;
    }
  }

  private boolean a(int paramInt)
  {
    if (paramInt + 7 > this.a.a())
      return paramInt + 4 <= this.a.a();
    for (int i = paramInt; ; i++)
    {
      if (i >= paramInt + 3)
        break label57;
      if (this.a.a(i))
        break;
    }
    label57: return this.a.a(paramInt + 3);
  }

  private l b()
    throws g
  {
    while (a(this.b.a()))
    {
      p localp = b(this.b.a());
      this.b.a(localp.e());
      if (localp.c())
      {
        if (localp.d());
        for (o localo = new o(this.b.a(), this.c.toString()); ; localo = new o(this.b.a(), this.c.toString(), localp.b()))
          return new l(localo, true);
      }
      this.c.append(localp.a());
      if (localp.d())
        return new l(new o(this.b.a(), this.c.toString()), true);
      this.c.append(localp.b());
    }
    if (i(this.b.a()))
    {
      this.b.e();
      this.b.b(4);
    }
    return new l(false);
  }

  private p b(int paramInt)
    throws g
  {
    if (paramInt + 7 > this.a.a())
    {
      int m = a(paramInt, 4);
      if (m == 0)
        return new p(this.a.a(), 10, 10);
      return new p(this.a.a(), m - 1, 10);
    }
    int i = a(paramInt, 7);
    int j = (i - 8) / 11;
    int k = (i - 8) % 11;
    return new p(paramInt + 7, j, k);
  }

  private l c()
    throws g
  {
    while (c(this.b.a()))
    {
      n localn = d(this.b.a());
      this.b.a(localn.e());
      if (localn.b())
        return new l(new o(this.b.a(), this.c.toString()), true);
      this.c.append(localn.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a()))
      return new l(false);
    if (5 + this.b.a() < this.a.a())
      this.b.b(5);
    while (true)
    {
      this.b.e();
      break;
      this.b.a(this.a.a());
    }
  }

  private boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt + 5 > this.a.a());
    do
    {
      do
      {
        return false;
        int i = a(paramInt, 5);
        if ((i >= 5) && (i < 16))
          return bool;
      }
      while (paramInt + 7 > this.a.a());
      int j = a(paramInt, 7);
      if ((j >= 64) && (j < 116))
        return bool;
    }
    while (paramInt + 8 > this.a.a());
    int k = a(paramInt, 8);
    if ((k >= 232) && (k < 253));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private l d()
  {
    while (e(this.b.a()))
    {
      n localn = f(this.b.a());
      this.b.a(localn.e());
      if (localn.b())
        return new l(new o(this.b.a(), this.c.toString()), true);
      this.c.append(localn.a());
    }
    if (h(this.b.a()))
    {
      this.b.b(3);
      this.b.d();
    }
    while (!g(this.b.a()))
      return new l(false);
    if (5 + this.b.a() < this.a.a())
      this.b.b(5);
    while (true)
    {
      this.b.f();
      break;
      this.b.a(this.a.a());
    }
  }

  private n d(int paramInt)
    throws g
  {
    int i = a(paramInt, 5);
    if (i == 15)
      return new n(paramInt + 5, '$');
    if ((i >= 5) && (i < 15))
      return new n(paramInt + 5, (char)(-5 + (i + 48)));
    int j = a(paramInt, 7);
    if ((j >= 64) && (j < 90))
      return new n(paramInt + 7, (char)(j + 1));
    if ((j >= 90) && (j < 116))
      return new n(paramInt + 7, (char)(j + 7));
    char c1;
    switch (a(paramInt, 8))
    {
    default:
      throw g.a();
    case 232:
      c1 = '!';
    case 233:
    case 234:
    case 235:
    case 236:
    case 237:
    case 238:
    case 239:
    case 240:
    case 241:
    case 242:
    case 243:
    case 244:
    case 245:
    case 246:
    case 247:
    case 248:
    case 249:
    case 250:
    case 251:
    case 252:
    }
    while (true)
    {
      return new n(paramInt + 8, c1);
      c1 = '"';
      continue;
      c1 = '%';
      continue;
      c1 = '&';
      continue;
      c1 = '\'';
      continue;
      c1 = '(';
      continue;
      c1 = ')';
      continue;
      c1 = '*';
      continue;
      c1 = '+';
      continue;
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
      continue;
      c1 = ':';
      continue;
      c1 = ';';
      continue;
      c1 = '<';
      continue;
      c1 = '=';
      continue;
      c1 = '>';
      continue;
      c1 = '?';
      continue;
      c1 = '_';
      continue;
      c1 = ' ';
    }
  }

  private boolean e(int paramInt)
  {
    boolean bool = true;
    if (paramInt + 5 > this.a.a());
    do
    {
      return false;
      int i = a(paramInt, 5);
      if ((i >= 5) && (i < 16))
        return bool;
    }
    while (paramInt + 6 > this.a.a());
    int j = a(paramInt, 6);
    if ((j >= 16) && (j < 63));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private n f(int paramInt)
  {
    int i = a(paramInt, 5);
    if (i == 15)
      return new n(paramInt + 5, '$');
    if ((i >= 5) && (i < 15))
      return new n(paramInt + 5, (char)(-5 + (i + 48)));
    int j = a(paramInt, 6);
    if ((j >= 32) && (j < 58))
      return new n(paramInt + 6, (char)(j + 33));
    char c1;
    switch (j)
    {
    default:
      throw new IllegalStateException("Decoding invalid alphanumeric value: " + j);
    case 58:
      c1 = '*';
    case 59:
    case 60:
    case 61:
    case 62:
    }
    while (true)
    {
      return new n(paramInt + 6, c1);
      c1 = ',';
      continue;
      c1 = '-';
      continue;
      c1 = '.';
      continue;
      c1 = '/';
    }
  }

  private boolean g(int paramInt)
  {
    if (paramInt + 1 > this.a.a());
    int i;
    do
    {
      return false;
      i = 0;
      if ((i >= 5) || (i + paramInt >= this.a.a()))
        break label74;
      if (i != 2)
        break;
    }
    while (!this.a.a(paramInt + 2));
    while (!this.a.a(paramInt + i))
    {
      i++;
      break;
    }
    return false;
    label74: return true;
  }

  private boolean h(int paramInt)
  {
    if (paramInt + 3 > this.a.a())
      return false;
    for (int i = paramInt; ; i++)
    {
      if (i >= paramInt + 3)
        break label41;
      if (this.a.a(i))
        break;
    }
    label41: return true;
  }

  private boolean i(int paramInt)
  {
    if (paramInt + 1 > this.a.a())
      return false;
    for (int i = 0; ; i++)
    {
      if ((i >= 4) || (i + paramInt >= this.a.a()))
        break label54;
      if (this.a.a(paramInt + i))
        break;
    }
    label54: return true;
  }

  int a(int paramInt1, int paramInt2)
  {
    return a(this.a, paramInt1, paramInt2);
  }

  o a(int paramInt, String paramString)
    throws g
  {
    this.c.setLength(0);
    if (paramString != null)
      this.c.append(paramString);
    this.b.a(paramInt);
    o localo = a();
    if ((localo != null) && (localo.b()))
      return new o(this.b.a(), this.c.toString(), localo.c());
    return new o(this.b.a(), this.c.toString());
  }

  String a(StringBuilder paramStringBuilder, int paramInt)
    throws j, g
  {
    String str1 = null;
    while (true)
    {
      o localo = a(paramInt, str1);
      String str2 = r.a(localo.a());
      if (str2 != null)
        paramStringBuilder.append(str2);
      if (localo.b());
      for (str1 = String.valueOf(localo.c()); paramInt == localo.e(); str1 = null)
        return paramStringBuilder.toString();
      paramInt = localo.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.e.f.a.a.a.s
 * JD-Core Version:    0.6.2
 */