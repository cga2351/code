package com.crashlytics.android.a;

import android.content.Context;
import c.a.a.a.a.b.i;
import c.a.a.a.a.b.s;
import c.a.a.a.a.b.s.a;
import java.util.Map;
import java.util.UUID;

class ag
{
  private final Context a;
  private final s b;
  private final String c;
  private final String d;

  public ag(Context paramContext, s params, String paramString1, String paramString2)
  {
    this.a = paramContext;
    this.b = params;
    this.c = paramString1;
    this.d = paramString2;
  }

  public ae a()
  {
    Map localMap = this.b.h();
    String str1 = this.b.c();
    String str2 = this.b.b();
    Boolean localBoolean = this.b.j();
    String str3 = (String)localMap.get(s.a.c);
    String str4 = i.m(this.a);
    String str5 = this.b.d();
    String str6 = this.b.g();
    return new ae(str1, UUID.randomUUID().toString(), str2, localBoolean, str3, str4, str5, str6, this.c, this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.ag
 * JD-Core Version:    0.6.2
 */