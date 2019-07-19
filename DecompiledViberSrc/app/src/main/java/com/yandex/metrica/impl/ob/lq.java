package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bn;

public class lq
{
  public final String a;
  public final String b;

  @Deprecated
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final String k;
  public final String l;
  public final String m;
  public final String n;
  public final String o;

  public lq()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
  }

  public lq(nz.a parama)
  {
    this.a = parama.a("dId");
    this.b = parama.a("uId");
    this.c = parama.a("kitVer");
    this.d = parama.a("analyticsSdkVersionName");
    this.e = parama.a("kitBuildNumber");
    this.f = parama.a("kitBuildType");
    this.g = parama.a("appVer");
    this.h = parama.optString("app_debuggable", "0");
    this.i = parama.a("appBuild");
    this.j = parama.a("osVer");
    this.l = parama.a("lang");
    this.m = parama.a("root");
    this.n = parama.optString("app_framework", bn.b());
    int i1 = parama.optInt("osApiLev", -1);
    if (i1 == -1);
    for (String str1 = null; ; str1 = String.valueOf(i1))
    {
      this.k = str1;
      int i2 = parama.optInt("attribution_id", 0);
      String str2 = null;
      if (i2 > 0)
        str2 = String.valueOf(i2);
      this.o = str2;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.lq
 * JD-Core Version:    0.6.2
 */