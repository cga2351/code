package a.a;

import com.appboy.b.a.f;
import com.appboy.e.b;
import com.appboy.e.g;
import com.appboy.e.h;
import com.appboy.e.j;
import com.appboy.e.l;
import com.appboy.e.m;
import com.appboy.f.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class dq
{
  private static final String a = c.a(dq.class);

  public static b a(JSONObject paramJSONObject, au paramau)
  {
    if (paramJSONObject == null);
    try
    {
      c.b(a, "In-app message Json was null. Not deserializing message.");
      return null;
      if (a(paramJSONObject))
      {
        c.b(a, "Deserializing control in-app message.");
        g localg = new g(paramJSONObject, paramau);
        return localg;
      }
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Encountered JSONException processing in-app message: " + dr.a(paramJSONObject), localJSONException);
      return null;
      f localf = (f)dr.a(paramJSONObject, "type", f.class, null);
      if (localf == null)
      {
        c.c(a, "In-app message type was null. Not deserializing message: " + dr.a(paramJSONObject));
        return null;
      }
      switch (1.a[localf.ordinal()])
      {
      default:
        c.e(a, "Unknown in-app message type. Not deserializing message: " + dr.a(paramJSONObject));
        return null;
      case 1:
        h localh = new h(paramJSONObject, paramau);
        return localh;
      case 2:
      case 3:
      case 4:
      }
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to deserialize the in-app message: " + dr.a(paramJSONObject), localException);
      return null;
    }
    return new l(paramJSONObject, paramau);
    return new m(paramJSONObject, paramau);
    j localj = new j(paramJSONObject, paramau);
    return localj;
  }

  static boolean a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optBoolean("is_control", false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dq
 * JD-Core Version:    0.6.2
 */