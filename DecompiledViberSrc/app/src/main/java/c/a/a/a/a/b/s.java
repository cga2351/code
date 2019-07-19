package c.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import c.a.a.a.l;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class s
{
  private static final Pattern e = Pattern.compile("[^\\p{Alnum}]");
  private static final String f = Pattern.quote("/");
  c a;
  b b;
  boolean c;
  r d;
  private final ReentrantLock g = new ReentrantLock();
  private final t h;
  private final boolean i;
  private final boolean j;
  private final Context k;
  private final String l;
  private final String m;
  private final Collection<c.a.a.a.i> n;

  public s(Context paramContext, String paramString1, String paramString2, Collection<c.a.a.a.i> paramCollection)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("appContext must not be null");
    if (paramString1 == null)
      throw new IllegalArgumentException("appIdentifier must not be null");
    if (paramCollection == null)
      throw new IllegalArgumentException("kits must not be null");
    this.k = paramContext;
    this.l = paramString1;
    this.m = paramString2;
    this.n = paramCollection;
    this.h = new t();
    this.a = new c(paramContext);
    this.d = new r();
    this.i = i.a(paramContext, "com.crashlytics.CollectDeviceIdentifiers", true);
    if (!this.i)
      c.a.a.a.c.g().a("Fabric", "Device ID collection disabled for " + paramContext.getPackageName());
    this.j = i.a(paramContext, "com.crashlytics.CollectUserIdentifiers", true);
    if (!this.j)
      c.a.a.a.c.g().a("Fabric", "User information collection disabled for " + paramContext.getPackageName());
  }

  @SuppressLint({"CommitPrefEdits"})
  private String a(SharedPreferences paramSharedPreferences)
  {
    this.g.lock();
    try
    {
      String str = paramSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null)
      {
        str = a(UUID.randomUUID().toString());
        paramSharedPreferences.edit().putString("crashlytics.installation.id", str).commit();
      }
      return str;
    }
    finally
    {
      this.g.unlock();
    }
  }

  private String a(String paramString)
  {
    if (paramString == null)
      return null;
    return e.matcher(paramString).replaceAll("").toLowerCase(Locale.US);
  }

  @SuppressLint({"CommitPrefEdits"})
  private void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.g.lock();
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool)
        return;
      String str = paramSharedPreferences.getString("crashlytics.advertising.id", null);
      if (TextUtils.isEmpty(str))
        paramSharedPreferences.edit().putString("crashlytics.advertising.id", paramString).commit();
      while (true)
      {
        return;
        if (!str.equals(paramString))
          paramSharedPreferences.edit().remove("crashlytics.installation.id").putString("crashlytics.advertising.id", paramString).commit();
      }
    }
    finally
    {
      this.g.unlock();
    }
  }

  private void a(Map<a, String> paramMap, a parama, String paramString)
  {
    if (paramString != null)
      paramMap.put(parama, paramString);
  }

  private String b(String paramString)
  {
    return paramString.replaceAll(f, "");
  }

  private void b(SharedPreferences paramSharedPreferences)
  {
    b localb = l();
    if (localb != null)
      a(paramSharedPreferences, localb.a);
  }

  private Boolean m()
  {
    b localb = l();
    if (localb != null)
      return Boolean.valueOf(localb.b);
    return null;
  }

  public boolean a()
  {
    return this.j;
  }

  public String b()
  {
    String str = this.m;
    if (str == null)
    {
      SharedPreferences localSharedPreferences = i.a(this.k);
      b(localSharedPreferences);
      str = localSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null)
        str = a(localSharedPreferences);
    }
    return str;
  }

  public String c()
  {
    return this.l;
  }

  public String d()
  {
    return e() + "/" + f();
  }

  public String e()
  {
    return b(Build.VERSION.RELEASE);
  }

  public String f()
  {
    return b(Build.VERSION.INCREMENTAL);
  }

  public String g()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = b(Build.MANUFACTURER);
    arrayOfObject[1] = b(Build.MODEL);
    return String.format(localLocale, "%s/%s", arrayOfObject);
  }

  public Map<a, String> h()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.n.iterator();
    while (localIterator1.hasNext())
    {
      c.a.a.a.i locali = (c.a.a.a.i)localIterator1.next();
      if ((locali instanceof n))
      {
        Iterator localIterator2 = ((n)locali).e().entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          a(localHashMap, (a)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    return Collections.unmodifiableMap(localHashMap);
  }

  public String i()
  {
    return this.h.a(this.k);
  }

  public Boolean j()
  {
    boolean bool = k();
    Boolean localBoolean = null;
    if (bool)
      localBoolean = m();
    return localBoolean;
  }

  protected boolean k()
  {
    return (this.i) && (!this.d.b(this.k));
  }

  b l()
  {
    try
    {
      if (!this.c)
      {
        this.b = this.a.a();
        this.c = true;
      }
      b localb = this.b;
      return localb;
    }
    finally
    {
    }
  }

  public static enum a
  {
    public final int h;

    static
    {
      a[] arrayOfa = new a[7];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
    }

    private a(int paramInt)
    {
      this.h = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.s
 * JD-Core Version:    0.6.2
 */