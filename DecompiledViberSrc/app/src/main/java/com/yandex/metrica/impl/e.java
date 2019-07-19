package com.yandex.metrica.impl;

import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.pg;
import com.yandex.metrica.impl.ob.pj;
import com.yandex.metrica.impl.ob.pm;
import com.yandex.metrica.impl.ob.pn;
import com.yandex.metrica.impl.ob.pp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class e extends i
{
  private final HashMap<a, Integer> f = new HashMap();
  private pp<String> g;
  private pp<String> h;
  private pp<byte[]> i;
  private pp<String> j;
  private pp<String> k;

  public e(of paramof)
  {
    a(paramof);
  }

  public e(String paramString, int paramInt, of paramof)
  {
    this("", paramString, paramInt, paramof);
  }

  public e(String paramString1, String paramString2, int paramInt1, int paramInt2, of paramof)
  {
    a(paramof);
    this.b = j(paramString1);
    this.a = i(paramString2);
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public e(String paramString1, String paramString2, int paramInt, of paramof)
  {
    this(paramString1, paramString2, paramInt, 0, paramof);
  }

  public static i a()
  {
    return new i().a(s.a.j.a());
  }

  private void a(of paramof)
  {
    this.g = new pn(1000, "event name", paramof);
    this.h = new pm(245760, "event value", paramof);
    this.i = new pg(245760, "event value bytes", paramof);
    this.j = new pn(200, "user profile id", paramof);
    this.k = new pn(10000, "UserInfo", paramof);
  }

  private void a(String paramString1, String paramString2, a parama)
  {
    if (pj.a(paramString1, paramString2))
      this.f.put(parama, Integer.valueOf(bu.c(paramString1).length - bu.c(paramString2).length));
    while (true)
    {
      x();
      return;
      this.f.remove(parama);
    }
  }

  private String i(String paramString)
  {
    String str = (String)this.g.a(paramString);
    a(paramString, str, a.a);
    return str;
  }

  private String j(String paramString)
  {
    String str = (String)this.h.a(paramString);
    a(paramString, str, a.b);
    return str;
  }

  private void x()
  {
    this.e = 0;
    Iterator localIterator = this.f.values().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      this.e += localInteger.intValue();
    }
  }

  public i a(String paramString)
  {
    String str = (String)this.k.a(paramString);
    a(paramString, str, a.c);
    return super.a(str);
  }

  public i a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = (byte[])this.i.a(paramArrayOfByte);
    a locala = a.b;
    if (paramArrayOfByte.length != arrayOfByte.length)
      this.f.put(locala, Integer.valueOf(paramArrayOfByte.length - arrayOfByte.length));
    while (true)
    {
      x();
      return super.a(arrayOfByte);
      this.f.remove(locala);
    }
  }

  public i b(String paramString)
  {
    return super.b(i(paramString));
  }

  public i c(String paramString)
  {
    return super.c(j(paramString));
  }

  public i d(String paramString)
  {
    return super.d((String)this.j.a(paramString));
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.e
 * JD-Core Version:    0.6.2
 */