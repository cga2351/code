package c.a.a.a.a.g;

import android.content.Context;
import c.a.a.a.a.b.g;
import c.a.a.a.a.b.m;
import c.a.a.a.a.e.e;
import c.a.a.a.c;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class q
{
  private final AtomicReference<t> a = new AtomicReference();
  private final CountDownLatch b = new CountDownLatch(1);
  private s c;
  private boolean d = false;

  public static q a()
  {
    return a.a();
  }

  private void a(t paramt)
  {
    this.a.set(paramt);
    this.b.countDown();
  }

  public q a(c.a.a.a.i parami, c.a.a.a.a.b.s params, e parame, String paramString1, String paramString2, String paramString3, c.a.a.a.a.b.l paraml)
  {
    try
    {
      boolean bool = this.d;
      if (bool);
      for (q localq = this; ; localq = this)
      {
        return localq;
        if (this.c == null)
        {
          Context localContext = parami.r();
          String str1 = params.c();
          String str2 = new g().a(localContext);
          String str3 = params.i();
          c.a.a.a.a.b.w localw = new c.a.a.a.a.b.w();
          k localk = new k();
          i locali = new i(parami);
          String str4 = c.a.a.a.a.b.i.k(localContext);
          String str5 = String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[] { str1 });
          l locall = new l(parami, paramString3, str5, parame);
          String str6 = params.g();
          String str7 = params.f();
          String str8 = params.e();
          String str9 = params.b();
          String[] arrayOfString = new String[1];
          arrayOfString[0] = c.a.a.a.a.b.i.m(localContext);
          this.c = new j(parami, new w(str2, str6, str7, str8, str9, c.a.a.a.a.b.i.a(arrayOfString), paramString2, paramString1, m.a(str3).a(), str4), localw, localk, locali, locall, paraml);
        }
        this.d = true;
      }
    }
    finally
    {
    }
  }

  public t b()
  {
    try
    {
      this.b.await();
      t localt = (t)this.a.get();
      return localt;
    }
    catch (InterruptedException localInterruptedException)
    {
      c.g().e("Fabric", "Interrupted while waiting for settings data.");
    }
    return null;
  }

  public boolean c()
  {
    try
    {
      t localt = this.c.a();
      a(localt);
      if (localt != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public boolean d()
  {
    try
    {
      t localt = this.c.a(r.b);
      a(localt);
      if (localt == null)
        c.g().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
      if (localt != null);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  static class a
  {
    private static final q a = new q(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.q
 * JD-Core Version:    0.6.2
 */