package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.b.g;
import com.appboy.b.h;
import com.appboy.e.b.b;
import com.appboy.f.c;
import com.appboy.f.e;
import com.appboy.f.j;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class dh extends cq<bo>
{
  private static final String c = c.a(dh.class);
  final SharedPreferences a;
  final SharedPreferences b;
  private final ay d;
  private final dd e;
  private final String f;
  private final dc g;

  public dh(Context paramContext, ay paramay, dd paramdd, dc paramdc)
  {
    this(paramContext, null, null, paramay, paramdd, paramdc);
  }

  public dh(Context paramContext, String paramString1, String paramString2, ay paramay, dd paramdd, dc paramdc)
  {
    String str = com.appboy.f.i.a(paramContext, paramString1, paramString2);
    this.a = paramContext.getSharedPreferences("com.appboy.storage.user_cache.v3" + str, 0);
    this.b = paramContext.getSharedPreferences("com.appboy.storage.user_cache.push_token_store" + str, 0);
    this.d = paramay;
    this.e = paramdd;
    this.f = paramString1;
    this.g = paramdc;
  }

  private boolean b(JSONObject paramJSONObject)
  {
    if (this.g.a())
    {
      c.d(c, "SDK is disabled. Not writing to user cache.");
      return false;
    }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("user_cache_attributes_object", paramJSONObject.toString());
    localEditor.apply();
    return true;
  }

  private boolean c(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = f();
    if (paramObject == null);
    try
    {
      localJSONObject.put(paramString, JSONObject.NULL);
      while (true)
      {
        return b(localJSONObject);
        localJSONObject.put(paramString, paramObject);
      }
    }
    catch (JSONException localJSONException)
    {
      c.d(c, "Failed to write to user object json from prefs with key: [" + paramString + "] value: [" + paramObject + "] ");
    }
    return false;
  }

  private JSONObject g()
  {
    JSONObject localJSONObject1 = f();
    if (localJSONObject1.has("custom"));
    while (true)
    {
      try
      {
        JSONObject localJSONObject3 = localJSONObject1.getJSONObject("custom");
        localJSONObject2 = localJSONObject3;
        if (localJSONObject2 == null)
          localJSONObject2 = new JSONObject();
        return localJSONObject2;
      }
      catch (JSONException localJSONException)
      {
        c.d(c, "Could not create custom attributes json object from preferences.", localJSONException);
      }
      JSONObject localJSONObject2 = null;
    }
  }

  void a(bo parambo, boolean paramBoolean)
  {
    if ((parambo == null) || (parambo.a() == null))
      c.b(c, "Tried to confirm with a null outbound user. Doing nothing.");
    JSONObject localJSONObject1;
    do
    {
      return;
      localJSONObject1 = parambo.a();
      if (!paramBoolean)
        break;
    }
    while (!localJSONObject1.has("push_token"));
    SharedPreferences.Editor localEditor2 = this.b.edit();
    localEditor2.putString("push_token", localJSONObject1.optString("push_token"));
    localEditor2.apply();
    return;
    JSONObject localJSONObject2 = f();
    JSONObject localJSONObject3 = dr.a(localJSONObject1, localJSONObject2);
    localJSONObject3.remove("push_token");
    JSONObject localJSONObject4 = localJSONObject2.optJSONObject("custom");
    JSONObject localJSONObject5 = localJSONObject1.optJSONObject("custom");
    if ((localJSONObject4 != null) && (localJSONObject5 != null));
    try
    {
      localJSONObject3.put("custom", dr.a(localJSONObject5, localJSONObject4));
      while (true)
      {
        SharedPreferences.Editor localEditor1 = this.a.edit();
        localEditor1.putString("user_cache_attributes_object", localJSONObject3.toString());
        localEditor1.apply();
        return;
        if (localJSONObject4 == null)
          break;
        localJSONObject3.put("custom", localJSONObject4);
      }
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        c.c(c, "Failed to add merged custom attributes back to user object.", localJSONException);
        continue;
        if (localJSONObject5 != null)
          localJSONObject3.put("custom", localJSONObject5);
      }
    }
  }

  public void a(g paramg)
  {
    if (paramg == null);
    try
    {
      c("gender", null);
      while (true)
      {
        return;
        c("gender", paramg.a());
      }
    }
    finally
    {
    }
  }

  public void a(com.appboy.b.i parami)
  {
    if (parami == null);
    try
    {
      c("email_subscribe", null);
      while (true)
      {
        return;
        c("email_subscribe", parami.a());
      }
    }
    finally
    {
    }
  }

  public void a(b paramb)
  {
    if (paramb != null);
    try
    {
      for (JSONObject localJSONObject = paramb.a(); ; localJSONObject = null)
      {
        a("ab_install_attribution", localJSONObject);
        return;
      }
    }
    finally
    {
    }
  }

  public void a(String paramString)
  {
    try
    {
      c("user_id", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(JSONObject paramJSONObject)
  {
    String str1 = this.d.a();
    if (str1 == null)
      c.b(c, "Cannot add null push token to attributes object.");
    String str2;
    do
    {
      return;
      str2 = this.b.getString("push_token", null);
    }
    while ((str2 != null) && (str1.equals(str2)));
    paramJSONObject.put("push_token", str1);
  }

  public boolean a(int paramInt1, h paramh, int paramInt2)
  {
    if (paramh == null);
    try
    {
      c.d(c, "Month cannot be null.");
      boolean bool1;
      for (boolean bool2 = false; ; bool2 = bool1)
      {
        return bool2;
        bool1 = c("dob", di.a(di.a(paramInt1, paramh.a(), paramInt2), gr.a));
      }
    }
    finally
    {
    }
  }

  public boolean a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = a(paramString, di.a(paramLong));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a(String paramString, Object paramObject)
  {
    boolean bool = false;
    try
    {
      if (!e.a(paramString, this.e.i()))
        c.d(c, "Custom attribute key cannot be null.");
      while (true)
      {
        return bool;
        String str = j.c(paramString);
        if (((paramObject instanceof Boolean)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Double)))
        {
          bool = b(str, paramObject);
        }
        else if ((paramObject instanceof String))
        {
          bool = b(str, j.c((String)paramObject));
        }
        else if ((paramObject instanceof Date))
        {
          bool = b(str, di.a((Date)paramObject, gr.b));
        }
        else if ((paramObject instanceof String[]))
        {
          bool = b(str, dr.a((String[])paramObject));
        }
        else
        {
          c.d(c, "Could not add unsupported custom attribute type with key: " + str + " and value: " + paramObject);
          bool = false;
        }
      }
    }
    finally
    {
    }
  }

  boolean a(String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1 = f();
    if (paramJSONObject == null);
    while (true)
    {
      try
      {
        localJSONObject1.put(paramString, JSONObject.NULL);
        return b(localJSONObject1);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject(paramString);
        if (localJSONObject2 != null)
        {
          localJSONObject1.put(paramString, dr.a(localJSONObject2, paramJSONObject));
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        c.d(c, "Failed to write to user object json from prefs with key: [" + paramString + "] value: [" + paramJSONObject + "] ");
        return false;
      }
      localJSONObject1.put(paramString, paramJSONObject);
    }
  }

  public void b(com.appboy.b.i parami)
  {
    if (parami == null);
    try
    {
      c("push_subscribe", null);
      while (true)
      {
        return;
        c("push_subscribe", parami.a());
      }
    }
    finally
    {
    }
  }

  public void b(String paramString)
  {
    try
    {
      c("first_name", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean b(String paramString, Object paramObject)
  {
    JSONObject localJSONObject = g();
    if (paramObject == null);
    try
    {
      localJSONObject.put(paramString, JSONObject.NULL);
      while (true)
      {
        return c("custom", localJSONObject);
        localJSONObject.put(paramString, paramObject);
      }
    }
    catch (JSONException localJSONException)
    {
      c.c(c, "Could not write to custom attributes json object with key: [" + paramString + "] value: [" + paramObject + "] ", localJSONException);
    }
    return false;
  }

  public void c(String paramString)
  {
    try
    {
      c("last_name", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d()
  {
    try
    {
      c.a(c, "Push token cache cleared.");
      this.b.edit().clear().apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean d(String paramString)
  {
    if (paramString != null);
    try
    {
      paramString = paramString.trim();
      boolean bool1;
      if ((paramString == null) || (j.a(paramString)))
        bool1 = c("email", paramString);
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        return bool2;
        c.d(c, "Email address is not valid: " + paramString);
      }
    }
    finally
    {
    }
  }

  public bo e()
  {
    if (!com.appboy.f.i.b(this.f))
      a(this.f);
    JSONObject localJSONObject = f();
    try
    {
      a(localJSONObject);
      this.a.edit().clear().apply();
      return new bo(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      while (true)
        c.d(c, "Couldn't add push token to outbound json", localJSONException);
    }
  }

  public void e(String paramString)
  {
    try
    {
      c("country", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  JSONObject f()
  {
    String str = this.a.getString("user_cache_attributes_object", null);
    if (str == null)
      return new JSONObject();
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(c, "Failed to load user object json from prefs with json string: " + str, localJSONException);
    }
    return new JSONObject();
  }

  public void f(String paramString)
  {
    try
    {
      c("home_city", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void g(String paramString)
  {
    try
    {
      c("language", paramString);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean h(String paramString)
  {
    if (paramString != null);
    try
    {
      paramString = paramString.trim();
      boolean bool1;
      if ((paramString == null) || (j.b(paramString)))
        bool1 = c("phone", paramString);
      for (boolean bool2 = bool1; ; bool2 = false)
      {
        return bool2;
        c.d(c, "Phone number contains invalid characters (allowed are digits, spaces, or any of the following +.-()): " + paramString);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dh
 * JD-Core Version:    0.6.2
 */