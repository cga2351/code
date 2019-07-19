package a.a;

import com.appboy.f.c;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class by
{
  private static final String a = c.a(by.class);
  private long b;
  private Set<String> c;
  private Set<String> d;
  private Set<String> e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private boolean i = false;
  private boolean j = false;
  private long k = -1L;
  private boolean l = false;

  public by()
  {
  }

  public by(JSONObject paramJSONObject)
  {
    this.c = a(paramJSONObject, "events_blacklist");
    this.d = a(paramJSONObject, "attributes_blacklist");
    this.e = a(paramJSONObject, "purchases_blacklist");
    this.b = paramJSONObject.optLong("time", 0L);
    this.k = paramJSONObject.optLong("messaging_session_timeout", -1L);
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("geofences");
    if (localJSONObject1 != null);
    try
    {
      this.f = localJSONObject1.getInt("min_time_since_last_request");
      this.g = localJSONObject1.getInt("min_time_since_last_report");
      this.j = localJSONObject1.getBoolean("enabled");
      this.i = true;
      this.h = localJSONObject1.optInt("max_num_to_register", 20);
      localJSONObject2 = paramJSONObject.optJSONObject("test_user");
      if (localJSONObject2 == null);
    }
    catch (JSONException localJSONException2)
    {
      try
      {
        JSONObject localJSONObject2;
        this.l = localJSONObject2.getBoolean("device_logging_enabled");
        return;
        localJSONException2 = localJSONException2;
        c.d(a, "Required geofence fields were null. Using defaults.", localJSONException2);
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.j = false;
        this.i = false;
      }
      catch (JSONException localJSONException1)
      {
        c.d(a, "Required test user fields were null. Using defaults", localJSONException1);
        this.l = false;
      }
    }
  }

  private Set<String> a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.optJSONArray(paramString) != null)
    {
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
      for (int m = 0; m < localJSONArray.length(); m++)
        localHashSet.add(localJSONArray.getString(m));
      return localHashSet;
    }
    return null;
  }

  public long a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public void a(Set<String> paramSet)
  {
    this.c = paramSet;
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public Set<String> b()
  {
    return this.c;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public void b(long paramLong)
  {
    this.k = paramLong;
  }

  public void b(Set<String> paramSet)
  {
    this.d = paramSet;
  }

  public void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public Set<String> c()
  {
    return this.d;
  }

  public void c(int paramInt)
  {
    this.h = paramInt;
  }

  public void c(Set<String> paramSet)
  {
    this.e = paramSet;
  }

  public void c(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public Set<String> d()
  {
    return this.e;
  }

  public long e()
  {
    return this.k;
  }

  public int f()
  {
    return this.f;
  }

  public int g()
  {
    return this.g;
  }

  public int h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.j;
  }

  public boolean j()
  {
    return this.i;
  }

  public boolean k()
  {
    return this.l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.by
 * JD-Core Version:    0.6.2
 */