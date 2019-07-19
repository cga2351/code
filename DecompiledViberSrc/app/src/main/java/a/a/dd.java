package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class dd
{
  private static final String a = c.a(dd.class);
  private final SharedPreferences b;
  private final Object c = new Object();
  private AtomicBoolean d = new AtomicBoolean(false);
  private by e;

  public dd(Context paramContext, String paramString)
  {
    if (paramString == null)
      c.e(a, "ServerConfigStorageProvider received null api key.");
    for (String str = ""; ; str = "." + paramString)
    {
      this.b = paramContext.getSharedPreferences("com.appboy.storage.serverconfigstorageprovider" + str, 0);
      new a(null).execute(new Void[0]);
      return;
    }
  }

  private Set<String> a(String paramString)
  {
    try
    {
      String str = this.b.getString(paramString, "");
      if (i.c(str))
        return null;
      JSONArray localJSONArray = new JSONArray(str);
      HashSet localHashSet = new HashSet();
      for (int i = 0; i < localJSONArray.length(); i++)
        localHashSet.add(localJSONArray.getString(i));
      return localHashSet;
    }
    catch (Exception localException)
    {
      c.c(a, "Experienced exception retrieving blacklisted strings from local storage. Returning null.", localException);
    }
    return null;
  }

  public void a(by paramby)
  {
    synchronized (this.c)
    {
      this.e = paramby;
    }
    try
    {
      SharedPreferences.Editor localEditor = this.b.edit();
      if (paramby.b() != null)
        localEditor.putString("blacklisted_events", new JSONArray(paramby.b()).toString());
      if (paramby.c() != null)
        localEditor.putString("blacklisted_attributes", new JSONArray(paramby.c()).toString());
      if (paramby.d() != null)
        localEditor.putString("blacklisted_purchases", new JSONArray(paramby.d()).toString());
      localEditor.putLong("config_time", paramby.a());
      localEditor.putInt("geofences_min_time_since_last_request", paramby.f());
      localEditor.putInt("geofences_min_time_since_last_report", paramby.g());
      localEditor.putInt("geofences_max_num_to_register", paramby.h());
      localEditor.putBoolean("geofences_enabled", paramby.i());
      localEditor.putBoolean("geofences_enabled_set", paramby.j());
      localEditor.putLong("messaging_session_timeout", paramby.e());
      localEditor.putBoolean("test_user_device_logging_enabled", paramby.k());
      localEditor.apply();
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (Exception localException)
    {
      c.c(a, "Could not persist server config to shared preferences.", localException);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.d.set(paramBoolean);
  }

  public boolean a()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        boolean bool2 = this.e.j();
        return bool2;
      }
      boolean bool1 = this.b.getBoolean("geofences_enabled_set", false);
      return bool1;
    }
  }

  public boolean b()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        boolean bool2 = this.e.i();
        return bool2;
      }
      boolean bool1 = this.b.getBoolean("geofences_enabled", false);
      return bool1;
    }
  }

  public int c()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        int j = this.e.f();
        return j;
      }
      int i = this.b.getInt("geofences_min_time_since_last_request", -1);
      return i;
    }
  }

  public int d()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        int j = this.e.g();
        return j;
      }
      int i = this.b.getInt("geofences_min_time_since_last_report", -1);
      return i;
    }
  }

  public int e()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        int j = this.e.h();
        return j;
      }
      int i = this.b.getInt("geofences_max_num_to_register", -1);
      return i;
    }
  }

  public long f()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        long l2 = this.e.e();
        return l2;
      }
      long l1 = this.b.getLong("messaging_session_timeout", -1L);
      return l1;
    }
  }

  public long g()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        long l2 = this.e.a();
        return l2;
      }
      long l1 = this.b.getLong("config_time", 0L);
      return l1;
    }
  }

  public Set<String> h()
  {
    synchronized (this.c)
    {
      if (this.e != null);
      for (Set localSet = this.e.b(); localSet != null; localSet = a("blacklisted_events"))
        return localSet;
      HashSet localHashSet = new HashSet();
      return localHashSet;
    }
  }

  public Set<String> i()
  {
    synchronized (this.c)
    {
      if (this.e != null);
      for (Set localSet = this.e.c(); localSet != null; localSet = a("blacklisted_attributes"))
        return localSet;
      HashSet localHashSet = new HashSet();
      return localHashSet;
    }
  }

  public Set<String> j()
  {
    synchronized (this.c)
    {
      if (this.e != null);
      for (Set localSet = this.e.d(); localSet != null; localSet = a("blacklisted_purchases"))
        return localSet;
      HashSet localHashSet = new HashSet();
      return localHashSet;
    }
  }

  public boolean k()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        boolean bool2 = this.e.k();
        return bool2;
      }
      boolean bool1 = this.b.getBoolean("test_user_device_logging_enabled", false);
      return bool1;
    }
  }

  public boolean l()
  {
    return this.d.get();
  }

  class a extends AsyncTask<Void, Void, Void>
  {
    private a()
    {
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      by localby = new by();
      localby.b(dd.this.i());
      localby.a(dd.this.h());
      localby.c(dd.this.j());
      localby.a(dd.this.g());
      localby.b(dd.this.f());
      localby.a(dd.this.c());
      localby.b(dd.this.d());
      localby.c(dd.this.e());
      localby.a(dd.this.b());
      localby.b(dd.this.a());
      localby.c(dd.this.k());
      synchronized (dd.a(dd.this))
      {
        dd.a(dd.this, localby);
        return null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dd
 * JD-Core Version:    0.6.2
 */