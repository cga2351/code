package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cu extends cq<bl>
{
  private static final String b = c.a(cu.class);
  final SharedPreferences a;
  private final b c;
  private bl d = null;

  public cu(Context paramContext)
  {
    this(paramContext, null, null);
  }

  public cu(Context paramContext, String paramString1, String paramString2)
  {
    this.a = paramContext.getSharedPreferences("com.appboy.storage.device_cache.v3" + i.a(paramContext, paramString1, paramString2), 0);
    this.c = new b(paramContext);
  }

  public void a(bl parambl)
  {
    this.d = parambl;
  }

  void a(bl parambl, boolean paramBoolean)
  {
    if ((paramBoolean) && (parambl != null));
    try
    {
      JSONObject localJSONObject1 = new JSONObject(this.a.getString("cached_device", "{}"));
      JSONObject localJSONObject2 = parambl.a();
      SharedPreferences.Editor localEditor = this.a.edit();
      localEditor.putString("cached_device", dr.a(localJSONObject1, localJSONObject2).toString());
      localEditor.apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      c.a(b, "Caught exception confirming and unlocking device cache.", localJSONException);
    }
  }

  bl d()
  {
    JSONObject localJSONObject1 = this.d.a();
    Object localObject1 = new JSONObject();
    JSONObject localJSONObject3;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(this.a.getString("cached_device", "{}"));
      localObject1 = localJSONObject2;
      localJSONObject3 = new JSONObject();
      Iterator localIterator = localJSONObject1.keys();
      while (true)
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject2 = localJSONObject1.opt(str);
          localObject3 = ((JSONObject)localObject1).opt(str);
          if (((localObject2 instanceof JSONObject)) || ((localObject2 instanceof JSONArray)))
          {
            if (localObject3 != null);
            try
            {
              if (fw.a(String.valueOf(localObject2), String.valueOf(localObject3), fx.c).b())
                localJSONObject3.put(str, localObject2);
            }
            catch (JSONException localJSONException1)
            {
              c.a(b, "Caught json exception creating dirty outbound device on a jsonObject value. Returning the whole device.", localJSONException1);
              return this.d;
            }
          }
        }
    }
    catch (JSONException localJSONException3)
    {
      while (true)
      {
        String str;
        Object localObject2;
        Object localObject3;
        c.d(b, "Caught exception confirming and unlocking Json objects.", localJSONException3);
        continue;
        if (!localObject2.equals(localObject3))
          try
          {
            localJSONObject3.put(str, localObject2);
          }
          catch (JSONException localJSONException2)
          {
            c.d(b, "Caught json exception creating dirty outbound device. Returning the whole device.", localJSONException2);
            return this.d;
          }
      }
    }
    return bl.a(this.c, localJSONObject3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cu
 * JD-Core Version:    0.6.2
 */