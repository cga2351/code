package c.a.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import c.a.a.a.a.b.v;
import c.a.a.a.a.e.e;
import c.a.a.a.k;
import c.a.a.a.l;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

abstract class a extends c.a.a.a.a.b.a
{
  public a(c.a.a.a.i parami, String paramString1, String paramString2, e parame, c.a.a.a.a.e.c paramc)
  {
    super(parami, paramString1, paramString2, parame, paramc);
  }

  private c.a.a.a.a.e.d a(c.a.a.a.a.e.d paramd, d paramd1)
  {
    return paramd.a("X-CRASHLYTICS-API-KEY", paramd1.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
  }

  private c.a.a.a.a.e.d b(c.a.a.a.a.e.d paramd, d paramd1)
  {
    c.a.a.a.a.e.d locald = paramd.e("app[identifier]", paramd1.b).e("app[name]", paramd1.f).e("app[display_version]", paramd1.c).e("app[build_version]", paramd1.d).a("app[source]", Integer.valueOf(paramd1.g)).e("app[minimum_sdk_version]", paramd1.h).e("app[built_sdk_version]", paramd1.i);
    if (!c.a.a.a.a.b.i.d(paramd1.e))
      locald.e("app[instance_identifier]", paramd1.e);
    InputStream localInputStream;
    if (paramd1.j != null)
      localInputStream = null;
    try
    {
      localInputStream = this.a.r().getResources().openRawResource(paramd1.j.b);
      locald.e("app[icon][hash]", paramd1.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", localInputStream).a("app[icon][width]", Integer.valueOf(paramd1.j.c)).a("app[icon][height]", Integer.valueOf(paramd1.j.d));
      c.a.a.a.a.b.i.a(localInputStream, "Failed to close app icon InputStream.");
      if (paramd1.k != null)
      {
        Iterator localIterator = paramd1.k.iterator();
        while (localIterator.hasNext())
        {
          k localk = (k)localIterator.next();
          locald.e(a(localk), localk.b());
          locald.e(b(localk), localk.c());
        }
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      while (true)
      {
        c.a.a.a.c.g().e("Fabric", "Failed to find app icon with resource ID: " + paramd1.j.b, localNotFoundException);
        c.a.a.a.a.b.i.a(localInputStream, "Failed to close app icon InputStream.");
      }
    }
    finally
    {
      c.a.a.a.a.b.i.a(localInputStream, "Failed to close app icon InputStream.");
    }
    return locald;
  }

  String a(k paramk)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramk.a();
    return String.format(localLocale, "app[build][libraries][%s][version]", arrayOfObject);
  }

  public boolean a(d paramd)
  {
    c.a.a.a.a.e.d locald = b(a(b(), paramd), paramd);
    c.a.a.a.c.g().a("Fabric", "Sending app info to " + a());
    if (paramd.j != null)
    {
      c.a.a.a.c.g().a("Fabric", "App icon hash is " + paramd.j.a);
      c.a.a.a.c.g().a("Fabric", "App icon size is " + paramd.j.c + "x" + paramd.j.d);
    }
    int i = locald.b();
    if ("POST".equals(locald.o()));
    for (String str = "Create"; ; str = "Update")
    {
      c.a.a.a.c.g().a("Fabric", str + " app request ID: " + locald.b("X-REQUEST-ID"));
      c.a.a.a.c.g().a("Fabric", "Result was " + i);
      if (v.a(i) != 0)
        break;
      return true;
    }
    return false;
  }

  String b(k paramk)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramk.a();
    return String.format(localLocale, "app[build][libraries][%s][type]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.a
 * JD-Core Version:    0.6.2
 */