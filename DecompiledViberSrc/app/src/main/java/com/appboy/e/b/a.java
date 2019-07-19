package com.appboy.e.b;

import com.appboy.e.e;
import com.appboy.f.c;
import com.appboy.f.i;
import com.appboy.f.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements e<JSONObject>
{
  private static final String a = c.a(a.class);
  private JSONObject b = new JSONObject();

  public a()
  {
  }

  public a(JSONObject paramJSONObject)
  {
    this.b = paramJSONObject;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramJSONObject.keys();
    while (localIterator1.hasNext())
      localArrayList.add(localIterator1.next());
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      if (!a(str))
      {
        this.b.remove(str);
      }
      else
      {
        try
        {
          if (!(paramJSONObject.get(str) instanceof String))
            break label180;
          if (b(paramJSONObject.getString(str)))
            continue;
          this.b.remove(str);
        }
        catch (JSONException localJSONException)
        {
          c.d(a, "Caught json exception validating property with key name: " + str, localJSONException);
        }
        continue;
        label180: if (paramJSONObject.get(str) == JSONObject.NULL)
          this.b.remove(str);
      }
    }
  }

  static boolean a(String paramString)
  {
    if (i.c(paramString))
    {
      c.d(a, "The AppboyProperties key cannot be null or contain only whitespaces. Not adding property.");
      return false;
    }
    if (paramString.startsWith("$"))
    {
      c.d(a, "The leading character in the key string may not be '$'. Not adding property.");
      return false;
    }
    return true;
  }

  static boolean b(String paramString)
  {
    if (paramString == null)
    {
      c.d(a, "The AppboyProperties value cannot be null. Not adding property.");
      return false;
    }
    return true;
  }

  public int a()
  {
    return this.b.length();
  }

  public a a(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2)))
      return this;
    try
    {
      this.b.put(j.c(paramString1), j.c(paramString2));
      return this;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught json exception trying to add property.", localJSONException);
    }
    return this;
  }

  public JSONObject b()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.b.a
 * JD-Core Version:    0.6.2
 */