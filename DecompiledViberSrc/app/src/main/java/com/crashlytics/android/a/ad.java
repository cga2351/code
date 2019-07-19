package com.crashlytics.android.a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class ad
{
  public final ae a;
  public final long b;
  public final b c;
  public final Map<String, String> d;
  public final String e;
  public final Map<String, Object> f;
  public final String g;
  public final Map<String, Object> h;
  private String i;

  private ad(ae paramae, long paramLong, b paramb, Map<String, String> paramMap, String paramString1, Map<String, Object> paramMap1, String paramString2, Map<String, Object> paramMap2)
  {
    this.a = paramae;
    this.b = paramLong;
    this.c = paramb;
    this.d = paramMap;
    this.e = paramString1;
    this.f = paramMap1;
    this.g = paramString2;
    this.h = paramMap2;
  }

  public static a a(long paramLong)
  {
    return new a(b.f).a(Collections.singletonMap("installedAt", String.valueOf(paramLong)));
  }

  public static a a(b paramb, Activity paramActivity)
  {
    Map localMap = Collections.singletonMap("activity", paramActivity.getClass().getName());
    return new a(paramb).a(localMap);
  }

  public static a a(m paramm)
  {
    return new a(b.g).a(paramm.a()).b(paramm.b());
  }

  public static a a(String paramString)
  {
    Map localMap = Collections.singletonMap("sessionId", paramString);
    return new a(b.e).a(localMap);
  }

  public static a a(String paramString1, String paramString2)
  {
    return a(paramString1).b(Collections.singletonMap("exceptionName", paramString2));
  }

  public String toString()
  {
    if (this.i == null)
      this.i = ("[" + getClass().getSimpleName() + ": " + "timestamp=" + this.b + ", type=" + this.c + ", details=" + this.d + ", customType=" + this.e + ", customAttributes=" + this.f + ", predefinedType=" + this.g + ", predefinedAttributes=" + this.h + ", metadata=[" + this.a + "]]");
    return this.i;
  }

  static class a
  {
    final ad.b a;
    final long b;
    Map<String, String> c;
    String d;
    Map<String, Object> e;
    String f;
    Map<String, Object> g;

    public a(ad.b paramb)
    {
      this.a = paramb;
      this.b = System.currentTimeMillis();
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
    }

    public a a(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public a a(Map<String, String> paramMap)
    {
      this.c = paramMap;
      return this;
    }

    public ad a(ae paramae)
    {
      return new ad(paramae, this.b, this.a, this.c, this.d, this.e, this.f, this.g, null);
    }

    public a b(Map<String, Object> paramMap)
    {
      this.e = paramMap;
      return this;
    }
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[8];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.ad
 * JD-Core Version:    0.6.2
 */