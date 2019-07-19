package com.crashlytics.android.ndk;

import c.a.a.a.a.c.m;
import c.a.a.a.a.f.b;
import c.a.a.a.i;
import com.crashlytics.android.c.n;
import com.crashlytics.android.c.p;
import com.crashlytics.android.c.q;
import java.io.IOException;

public class c extends i<Void>
  implements q
{
  private f a;
  private p b;

  public String a()
  {
    return "2.0.5.27";
  }

  boolean a(f paramf, com.crashlytics.android.c.l paraml, n paramn)
  {
    this.a = paramf;
    boolean bool = paramf.a();
    if (bool)
    {
      paramn.a(paraml, this);
      c.a.a.a.c.g().a("CrashlyticsNdk", "Crashlytics NDK initialization successful");
    }
    return bool;
  }

  public String b()
  {
    return "com.crashlytics.sdk.android.crashlytics-ndk";
  }

  public p c()
  {
    return this.b;
  }

  protected Void e()
  {
    try
    {
      this.b = this.a.b();
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
        c.a.a.a.c.g().e("CrashlyticsNdk", "Could not process ndk data; ", localIOException);
    }
  }

  protected boolean f_()
  {
    com.crashlytics.android.c.l locall = (com.crashlytics.android.c.l)c.a.a.a.c.a(com.crashlytics.android.c.l.class);
    if (locall == null)
      throw new m("CrashlyticsNdk requires Crashlytics");
    return a(new a(r(), new JniNativeApi(), new e(new b(this))), locall, new n());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.ndk.c
 * JD-Core Version:    0.6.2
 */