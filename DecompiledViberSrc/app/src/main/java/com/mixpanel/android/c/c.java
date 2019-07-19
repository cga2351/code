package com.mixpanel.android.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.mixpanel.android.b.d;
import com.mixpanel.android.b.d.a;
import com.mixpanel.android.b.e;
import com.mixpanel.android.b.f;
import com.mixpanel.android.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c
{
  private static final Class<?>[] e = new Class[0];
  private static final List<h.c> f = Collections.emptyList();
  private final Context a;
  private final com.mixpanel.android.mpmetrics.o b;
  private final d c;
  private final o.i d;

  public c(Context paramContext, com.mixpanel.android.mpmetrics.o paramo, d paramd, o.i parami)
  {
    this.a = paramContext;
    this.b = paramo;
    this.c = paramd;
    this.d = parami;
  }

  private Drawable a(JSONObject paramJSONObject, List<String> paramList)
    throws c.a, c.b
  {
    int i = 0;
    try
    {
      if (paramJSONObject.isNull("url"))
        throw new a("Can't construct a BitmapDrawable with a null url");
    }
    catch (JSONException localJSONException)
    {
      throw new a("Couldn't read drawable description", localJSONException);
    }
    String str = paramJSONObject.getString("url");
    boolean bool = paramJSONObject.isNull("dimensions");
    int m;
    int k;
    int j;
    int n;
    if (bool)
    {
      m = 0;
      k = 0;
      j = 0;
      n = 0;
    }
    BitmapDrawable localBitmapDrawable;
    try
    {
      while (true)
      {
        Bitmap localBitmap = this.c.b(str);
        paramList.add(str);
        localBitmapDrawable = new BitmapDrawable(Resources.getSystem(), localBitmap);
        if (n == 0)
          break;
        localBitmapDrawable.setBounds(j, m, k, i);
        return localBitmapDrawable;
        JSONObject localJSONObject = paramJSONObject.getJSONObject("dimensions");
        j = localJSONObject.getInt("left");
        k = localJSONObject.getInt("right");
        m = localJSONObject.getInt("top");
        i = localJSONObject.getInt("bottom");
        n = 1;
      }
    }
    catch (d.a locala)
    {
      throw new b(locala.getMessage(), locala.getCause());
    }
    return localBitmapDrawable;
  }

  private i a(Class<?> paramClass, JSONObject paramJSONObject)
    throws c.a
  {
    while (true)
    {
      try
      {
        String str1 = paramJSONObject.getString("name");
        if (paramJSONObject.has("get"))
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("get");
          String str3 = localJSONObject.getString("selector");
          Class localClass = Class.forName(localJSONObject.getJSONObject("result").getString("type"));
          locala = new a(paramClass, str3, e, localClass);
          boolean bool = paramJSONObject.has("set");
          String str2 = null;
          if (bool)
            str2 = paramJSONObject.getJSONObject("set").getString("selector");
          i locali = new i(str1, paramClass, locala, str2);
          return locali;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new a("Can't create property reader", localNoSuchMethodException);
      }
      catch (JSONException localJSONException)
      {
        throw new a("Can't read property JSON", localJSONException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new a("Can't read property JSON, relevant arg/return class not found", localClassNotFoundException);
      }
      a locala = null;
    }
  }

  private Integer a(int paramInt, String paramString, com.mixpanel.android.mpmetrics.o paramo)
  {
    if (paramString != null)
      if (!paramo.a(paramString));
    for (int i = paramo.b(paramString); (-1 != i) && (-1 != paramInt) && (i != paramInt); i = -1)
    {
      f.e("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
      return null;
      f.d("MixpanelAPI.EProtocol", "Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"" + paramString + "\"");
      return null;
    }
    if (-1 != i)
      return Integer.valueOf(i);
    return Integer.valueOf(paramInt);
  }

  private Object a(Object paramObject, String paramString, List<String> paramList)
    throws c.a, c.b
  {
    try
    {
      if ("java.lang.CharSequence".equals(paramString))
        return paramObject;
      if ((!"boolean".equals(paramString)) && (!"java.lang.Boolean".equals(paramString)))
      {
        if (("int".equals(paramString)) || ("java.lang.Integer".equals(paramString)))
          return Integer.valueOf(((Number)paramObject).intValue());
        if (("float".equals(paramString)) || ("java.lang.Float".equals(paramString)))
          return Float.valueOf(((Number)paramObject).floatValue());
        if ("android.graphics.drawable.Drawable".equals(paramString))
          return a((JSONObject)paramObject, paramList);
        if ("android.graphics.drawable.BitmapDrawable".equals(paramString))
          return a((JSONObject)paramObject, paramList);
        if ("android.graphics.drawable.ColorDrawable".equals(paramString))
          return new ColorDrawable(((Number)paramObject).intValue());
        throw new a("Don't know how to interpret type " + paramString + " (arg was " + paramObject + ")");
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new a("Couldn't interpret <" + paramObject + "> as " + paramString);
    }
    return paramObject;
  }

  public c a(JSONObject paramJSONObject)
    throws c.a, c.b
  {
    int i = 0;
    ArrayList localArrayList1 = new ArrayList();
    List localList;
    String str3;
    try
    {
      localList = a(paramJSONObject.getJSONArray("path"), this.b);
      if (localList.size() == 0)
        throw new d("Edit will not be bound to any element in the UI.");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new a("Can't create property mutator", localNoSuchMethodException);
      if (!paramJSONObject.getString("change_type").equals("property"))
        break label325;
      str3 = paramJSONObject.getJSONObject("property").getString("classname");
      if (str3 == null)
        throw new a("Can't bind an edit property without a target class");
    }
    catch (JSONException localJSONException)
    {
      throw new a("Can't interpret instructions due to JSONException", localJSONException);
    }
    i locali;
    Object[] arrayOfObject;
    try
    {
      Class localClass = Class.forName(str3);
      locali = a(localClass, paramJSONObject.getJSONObject("property"));
      JSONArray localJSONArray2 = paramJSONObject.getJSONArray("args");
      arrayOfObject = new Object[localJSONArray2.length()];
      while (i < localJSONArray2.length())
      {
        JSONArray localJSONArray3 = localJSONArray2.getJSONArray(i);
        arrayOfObject[i] = a(localJSONArray3.get(0), localJSONArray3.getString(1), localArrayList1);
        i++;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new a("Can't find class for visit path: " + str3, localClassNotFoundException);
    }
    a locala = locali.a(arrayOfObject);
    if (locala == null)
      throw new a("Can't update a read-only property " + locali.a + " (add a mutator to make this work)");
    Object localObject = new o.j(localList, locala, locali.c);
    return new c((o)localObject, localArrayList1, null);
    label325: JSONArray localJSONArray1;
    ArrayList localArrayList2;
    int j;
    if (paramJSONObject.getString("change_type").equals("layout"))
    {
      localJSONArray1 = paramJSONObject.getJSONArray("args");
      localArrayList2 = new ArrayList();
      j = localJSONArray1.length();
    }
    label438: label591: label604: for (int k = 0; ; k++)
    {
      JSONObject localJSONObject;
      String str1;
      String str2;
      Integer localInteger1;
      Integer localInteger2;
      if (k < j)
      {
        localJSONObject = localJSONArray1.optJSONObject(k);
        str1 = localJSONObject.getString("view_id_name");
        str2 = localJSONObject.getString("anchor_id_name");
        localInteger1 = a(-1, str1, this.b);
        if (str2.equals("0"))
        {
          localInteger2 = Integer.valueOf(0);
          break label591;
        }
      }
      while (true)
      {
        f.d("MixpanelAPI.EProtocol", "View (" + str1 + ") or anchor (" + str2 + ") not found.");
        break label604;
        if (str2.equals("-1"))
          localInteger2 = Integer.valueOf(-1);
        else
          localInteger2 = a(-1, str2, this.b);
        do
        {
          localArrayList2.add(new o.f(localInteger1.intValue(), localJSONObject.getInt("verb"), localInteger2.intValue()));
          break label604;
          localObject = new o.g(localList, localArrayList2, paramJSONObject.getString("name"), this.d);
          break;
          throw new a("Can't figure out the edit type");
          if (localInteger1 == null)
            break label438;
        }
        while (localInteger2 != null);
      }
    }
  }

  public o a(JSONObject paramJSONObject, o.h paramh)
    throws c.a
  {
    String str1;
    String str2;
    List localList;
    try
    {
      str1 = paramJSONObject.getString("event_name");
      str2 = paramJSONObject.getString("event_type");
      localList = a(paramJSONObject.getJSONArray("path"), this.b);
      if (localList.size() == 0)
        throw new d("event '" + str1 + "' will not be bound to any element in the UI.");
    }
    catch (JSONException localJSONException)
    {
      throw new a("Can't interpret instructions due to JSONException", localJSONException);
    }
    if ("click".equals(str2))
      return new o.a(localList, 1, str1, paramh);
    if ("selected".equals(str2))
      return new o.a(localList, 4, str1, paramh);
    if ("text_changed".equals(str2))
      return new o.b(localList, str1, paramh);
    if ("detected".equals(str2))
      return new o.k(localList, str1, paramh);
    throw new a("Mixpanel can't track event type \"" + str2 + "\"");
  }

  List<h.c> a(JSONArray paramJSONArray, com.mixpanel.android.mpmetrics.o paramo)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      String str1 = e.a(localJSONObject, "prefix");
      String str2 = e.a(localJSONObject, "view_class");
      int j = localJSONObject.optInt("index", -1);
      String str3 = e.a(localJSONObject, "contentDescription");
      int k = localJSONObject.optInt("id", -1);
      String str4 = e.a(localJSONObject, "mp_id_name");
      String str5 = e.a(localJSONObject, "tag");
      if ("shortest".equals(str1));
      Integer localInteger;
      for (int m = 1; ; m = 0)
      {
        localInteger = a(k, str4, paramo);
        if (localInteger != null)
          break label181;
        return f;
        if (str1 != null)
          break;
      }
      f.d("MixpanelAPI.EProtocol", "Unrecognized prefix type \"" + str1 + "\". No views will be matched");
      return f;
      label181: localArrayList.add(new h.c(m, str2, j, localInteger.intValue(), str3, str5));
    }
    return localArrayList;
  }

  public n b(JSONObject paramJSONObject)
    throws c.a
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      int i;
      try
      {
        JSONArray localJSONArray1 = paramJSONObject.getJSONObject("config").getJSONArray("classes");
        i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = localJSONArray1.getJSONObject(i);
          Class localClass = Class.forName(localJSONObject.getString("name"));
          JSONArray localJSONArray2 = localJSONObject.getJSONArray("properties");
          int j = 0;
          if (j < localJSONArray2.length())
          {
            localArrayList.add(a(localClass, localJSONArray2.getJSONObject(j)));
            j++;
            continue;
          }
        }
        else
        {
          n localn = new n(this.a, localArrayList, this.b);
          return localn;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new a("Can't read snapshot configuration", localJSONException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new a("Can't resolve types for snapshot configuration", localClassNotFoundException);
      }
      i++;
    }
  }

  public g<String, Object> c(JSONObject paramJSONObject)
    throws c.a
  {
    String str2;
    while (true)
    {
      Object localObject;
      try
      {
        String str1 = paramJSONObject.getString("name");
        str2 = paramJSONObject.getString("type");
        if ("number".equals(str2))
        {
          String str3 = paramJSONObject.getString("encoding");
          if ("d".equals(str3))
          {
            localObject = Double.valueOf(paramJSONObject.getDouble("value"));
            return new g(str1, localObject);
          }
          if ("l".equals(str3))
          {
            localObject = Long.valueOf(paramJSONObject.getLong("value"));
            continue;
          }
          throw new a("number must have encoding of type \"l\" for long or \"d\" for double in: " + paramJSONObject);
        }
      }
      catch (JSONException localJSONException)
      {
        throw new a("Can't read tweak update", localJSONException);
      }
      if ("boolean".equals(str2))
      {
        localObject = Boolean.valueOf(paramJSONObject.getBoolean("value"));
      }
      else
      {
        if (!"string".equals(str2))
          break;
        localObject = paramJSONObject.getString("value");
      }
    }
    throw new a("Unrecognized tweak type " + str2 + " in: " + paramJSONObject);
  }

  public static class a extends Exception
  {
    public a(String paramString)
    {
      super();
    }

    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  public static class b extends Exception
  {
    public b(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }

  public static class c
  {
    public final o a;
    public final List<String> b;

    private c(o paramo, List<String> paramList)
    {
      this.a = paramo;
      this.b = paramList;
    }
  }

  public static class d extends c.a
  {
    public d(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.c
 * JD-Core Version:    0.6.2
 */