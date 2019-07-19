package com.my.target.c.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private final String a;
  private final float b;
  private final int c;
  private final boolean d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final com.my.target.common.a.b n;
  private final com.my.target.common.a.b o;
  private final ArrayList<b> p = new ArrayList();

  private a(com.my.target.b.c.a.a parama)
  {
    this.a = parama.m();
    this.b = parama.n();
    this.c = parama.t();
    boolean bool1;
    String str1;
    label65: String str2;
    label84: String str3;
    label104: String str4;
    label124: String str5;
    label144: String str6;
    label164: String str7;
    label184: String str8;
    if (parama.F() != null)
    {
      bool1 = true;
      this.d = bool1;
      str1 = parama.p();
      if (TextUtils.isEmpty(str1))
        break label268;
      this.e = str1;
      str2 = parama.f();
      if (TextUtils.isEmpty(str2))
        break label273;
      this.f = str2;
      str3 = parama.d();
      if (TextUtils.isEmpty(str3))
        break label279;
      this.g = str3;
      str4 = parama.g();
      if (TextUtils.isEmpty(str4))
        break label285;
      this.h = str4;
      str5 = parama.a();
      if (TextUtils.isEmpty(str5))
        break label291;
      this.i = str5;
      str6 = parama.c();
      if (TextUtils.isEmpty(str6))
        break label297;
      this.j = str6;
      str7 = parama.o();
      if (TextUtils.isEmpty(str7))
        break label303;
      this.k = str7;
      str8 = parama.h();
      if (TextUtils.isEmpty(str8))
        break label309;
    }
    while (true)
    {
      this.l = str8;
      String str9 = parama.z();
      boolean bool2 = TextUtils.isEmpty(str9);
      String str10 = null;
      if (!bool2)
        str10 = str9;
      this.m = str10;
      this.n = parama.l();
      this.o = parama.j();
      b(parama);
      return;
      bool1 = false;
      break;
      label268: str1 = null;
      break label65;
      label273: str2 = null;
      break label84;
      label279: str3 = null;
      break label104;
      label285: str4 = null;
      break label124;
      label291: str5 = null;
      break label144;
      label297: str6 = null;
      break label164;
      label303: str7 = null;
      break label184;
      label309: str8 = null;
    }
  }

  public static a a(com.my.target.b.c.a.a parama)
  {
    return new a(parama);
  }

  private void b(com.my.target.b.c.a.a parama)
  {
    if (!this.d)
    {
      List localList = parama.G();
      if (!localList.isEmpty())
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          com.my.target.b.c.a.b localb = (com.my.target.b.c.a.b)localIterator.next();
          this.p.add(b.a(localb));
        }
      }
    }
  }

  public com.my.target.common.a.b a()
  {
    return this.o;
  }

  public String b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }

  public String d()
  {
    return this.g;
  }

  public String e()
  {
    return this.i;
  }

  public float f()
  {
    return this.b;
  }

  public int g()
  {
    return this.c;
  }

  public String h()
  {
    return this.j;
  }

  public String i()
  {
    return this.k;
  }

  public String j()
  {
    return this.l;
  }

  public String k()
  {
    return this.a;
  }

  public com.my.target.common.a.b l()
  {
    return this.n;
  }

  public String m()
  {
    return this.m;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c.a.a
 * JD-Core Version:    0.6.2
 */