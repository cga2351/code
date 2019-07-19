package c.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import c.a.a.a.a.b.g;
import c.a.a.a.a.b.s;
import c.a.a.a.a.e.b;
import c.a.a.a.a.g.d;
import c.a.a.a.a.g.h;
import c.a.a.a.a.g.n;
import c.a.a.a.a.g.q;
import c.a.a.a.a.g.t;
import c.a.a.a.a.g.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

class m extends i<Boolean>
{
  private final c.a.a.a.a.e.e a = new b();
  private PackageManager b;
  private String c;
  private PackageInfo d;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private final Future<Map<String, k>> p;
  private final Collection<i> q;

  public m(Future<Map<String, k>> paramFuture, Collection<i> paramCollection)
  {
    this.p = paramFuture;
    this.q = paramCollection;
  }

  private d a(n paramn, Collection<k> paramCollection)
  {
    Context localContext = r();
    String str1 = new g().a(localContext);
    String str2 = c.a.a.a.a.b.i.a(new String[] { c.a.a.a.a.b.i.m(localContext) });
    int i = c.a.a.a.a.b.m.a(this.m).a();
    return new d(str1, q().c(), this.l, this.k, str2, this.n, i, this.o, "0", paramn, paramCollection);
  }

  private boolean a(c.a.a.a.a.g.e parame, n paramn, Collection<k> paramCollection)
  {
    d locald = a(paramn, paramCollection);
    return new y(this, e(), parame.c, this.a).a(locald);
  }

  private boolean a(String paramString, c.a.a.a.a.g.e parame, Collection<k> paramCollection)
  {
    boolean bool = true;
    if ("new".equals(parame.b))
      if (b(paramString, parame, paramCollection))
        bool = q.a().d();
    do
    {
      return bool;
      c.g().e("Fabric", "Failed to create app with Crashlytics service.", null);
      return false;
      if ("configured".equals(parame.b))
        return q.a().d();
    }
    while (!parame.f);
    c.g().a("Fabric", "Server says an update is required - forcing a full App update.");
    c(paramString, parame, paramCollection);
    return bool;
  }

  private boolean b(String paramString, c.a.a.a.a.g.e parame, Collection<k> paramCollection)
  {
    d locald = a(n.a(r(), paramString), paramCollection);
    return new h(this, e(), parame.c, this.a).a(locald);
  }

  private boolean c(String paramString, c.a.a.a.a.g.e parame, Collection<k> paramCollection)
  {
    return a(parame, n.a(r(), paramString), paramCollection);
  }

  private t g()
  {
    try
    {
      q.a().a(this, this.i, this.a, this.k, this.l, e(), c.a.a.a.a.b.l.a(r())).c();
      t localt = q.a().b();
      return localt;
    }
    catch (Exception localException)
    {
      c.g().e("Fabric", "Error dealing with settings", localException);
    }
    return null;
  }

  public String a()
  {
    return "1.4.8.32";
  }

  Map<String, k> a(Map<String, k> paramMap, Collection<i> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (!paramMap.containsKey(locali.b()))
        paramMap.put(locali.b(), new k(locali.b(), locali.a(), "binary"));
    }
    return paramMap;
  }

  public String b()
  {
    return "io.fabric.sdk.android:fabric";
  }

  protected Boolean c()
  {
    String str = c.a.a.a.a.b.i.k(r());
    t localt = g();
    if (localt != null);
    while (true)
    {
      try
      {
        if (this.p != null)
        {
          localObject = (Map)this.p.get();
          Map localMap = a((Map)localObject, this.q);
          boolean bool2 = a(str, localt.a, localMap.values());
          bool1 = bool2;
          return Boolean.valueOf(bool1);
        }
        Object localObject = new HashMap();
        continue;
      }
      catch (Exception localException)
      {
        c.g().e("Fabric", "Error performing auto configuration.", localException);
      }
      boolean bool1 = false;
    }
  }

  String e()
  {
    return c.a.a.a.a.b.i.b(r(), "com.crashlytics.ApiEndpoint");
  }

  protected boolean f_()
  {
    try
    {
      this.m = q().i();
      this.b = r().getPackageManager();
      this.c = r().getPackageName();
      this.d = this.b.getPackageInfo(this.c, 0);
      this.k = Integer.toString(this.d.versionCode);
      if (this.d.versionName == null);
      for (String str = "0.0"; ; str = this.d.versionName)
      {
        this.l = str;
        this.n = this.b.getApplicationLabel(r().getApplicationInfo()).toString();
        this.o = Integer.toString(r().getApplicationInfo().targetSdkVersion);
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      c.g().e("Fabric", "Failed init", localNameNotFoundException);
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.m
 * JD-Core Version:    0.6.2
 */