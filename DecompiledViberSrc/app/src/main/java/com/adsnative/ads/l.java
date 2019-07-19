package com.adsnative.ads;

import android.content.Context;
import android.text.TextUtils;
import com.adsnative.a.a;
import com.adsnative.a.a.a;
import com.adsnative.a.a.b;
import com.adsnative.b.c;
import com.adsnative.c.e.b;
import com.adsnative.c.h;
import com.adsnative.c.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends a
{
  protected void a(Context paramContext, a.a parama, c paramc)
  {
    JSONObject localJSONObject = paramc.b();
    if (!(localJSONObject instanceof JSONObject))
    {
      parama.a(e.b);
      return;
    }
    a locala = new a(paramContext.getApplicationContext(), (JSONObject)localJSONObject, parama);
    try
    {
      locala.a();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      parama.a(e.b);
      return;
    }
    catch (IOException localIOException)
    {
      parama.a(e.g);
    }
  }

  static class a extends d
  {
    private final Context a;
    private final a.a b;
    private final JSONObject c;

    a(Context paramContext, JSONObject paramJSONObject, a.a parama)
    {
      this.c = paramJSONObject;
      this.a = paramContext;
      this.b = parama;
    }

    private void a(n.b paramb, Object paramObject)
      throws ClassCastException
    {
      try
      {
        switch (l.1.a[paramb.ordinal()])
        {
        default:
          i.b("Unable to add JSON key to internal mapping: " + paramb.q);
          return;
        case 1:
          a((String)paramObject);
          return;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        }
      }
      catch (ClassCastException localClassCastException)
      {
        if (!paramb.r)
        {
          i.b("Ignoring class cast exception for optional key: " + paramb.q);
          return;
          b((String)paramObject);
          return;
          c((String)paramObject);
          return;
          d((String)paramObject);
          return;
          a(h.a(paramObject));
          return;
          e((String)paramObject);
          return;
          c((JSONObject)paramObject);
          return;
          JSONObject localJSONObject2 = (JSONObject)paramObject;
          if (localJSONObject2 != null)
          {
            a(localJSONObject2.opt("impressions"));
            b(localJSONObject2.opt("viewables"));
            c(localJSONObject2.opt("clicks"));
            if (localJSONObject2.opt("noticeUrls") != null)
            {
              JSONObject localJSONObject3 = (JSONObject)localJSONObject2.opt("noticeUrls");
              d(localJSONObject3.opt("win"));
              e(localJSONObject3.opt("loss"));
            }
          }
          else
          {
            i.e("trackingUrls is null");
            return;
            u((String)paramObject);
            return;
            v((String)paramObject);
            return;
            l((String)paramObject);
            return;
            j((String)paramObject);
            return;
            JSONObject localJSONObject1 = (JSONObject)paramObject;
            m(localJSONObject1.optString("iconUrl"));
            n(localJSONObject1.optString("policyUrl"));
            return;
            k((String)paramObject);
            return;
            i(this.c.optString("vastUrl"));
          }
        }
        else
        {
          throw localClassCastException;
        }
      }
    }

    private void a(List<String> paramList)
    {
      try
      {
        a(this.a, paramList, new a.b()
        {
          public void a(e paramAnonymouse)
          {
            l.a.a(l.a.this).a(paramAnonymouse);
          }

          public void a(e.b paramAnonymousb)
          {
            l.a.a(l.a.this).a(l.a.this);
          }
        });
        return;
      }
      catch (Exception localException)
      {
        i.e(localException.getMessage());
        this.b.a(e.c);
      }
    }

    private boolean b(JSONObject paramJSONObject)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
        localHashSet.add(localIterator.next());
      return localHashSet.containsAll(n.b.s);
    }

    private void c(JSONObject paramJSONObject)
    {
      g((String)paramJSONObject.opt("embedType"));
      h((String)paramJSONObject.opt("experience"));
      a((JSONArray)paramJSONObject.opt("sources"));
      a((JSONObject)paramJSONObject.opt("trackingUrls"));
    }

    private boolean w(String paramString)
    {
      return (paramString != null) && (paramString.toLowerCase(Locale.US).endsWith("image"));
    }

    List<String> L()
    {
      ArrayList localArrayList = new ArrayList(E().size());
      Iterator localIterator = E().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((w((String)localEntry.getKey())) && ((localEntry.getValue() instanceof String)))
        {
          String str = (String)localEntry.getValue();
          if ((str != null) && (!TextUtils.isEmpty(str)))
            localArrayList.add(str);
        }
      }
      return localArrayList;
    }

    void a()
      throws IllegalArgumentException, IOException
    {
      if (!b(this.c))
        throw new IllegalArgumentException("JSONObject did not contain required keys.");
      o("adsnative");
      Iterator localIterator = this.c.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        n.b localb = n.b.a(str);
        if (localb != null)
          try
          {
            a(localb, this.c.opt(str));
          }
          catch (ClassCastException localClassCastException)
          {
            throw new IllegalArgumentException("JSONObject key (" + str + ") contained unexpected value.");
          }
        else
          a(str, this.c.opt(str));
      }
      ArrayList localArrayList = new ArrayList();
      if ((d() != null) && (!d().equals("")))
        localArrayList.add(d());
      if ((f() != null) && (!f().equals("")))
        localArrayList.add(f());
      if ((L() != null) && (L().size() > 0))
        localArrayList.addAll(L());
      a(localArrayList);
      if (((d() == null) || (d().equals(""))) && ((f() == null) || (f().equals(""))) && ((L() == null) || (L().size() == 0)))
        this.b.a(this);
    }

    public void a(Object paramObject)
      throws ClassCastException
    {
      if (!(paramObject instanceof JSONArray))
        throw new ClassCastException("Expected impression trackers of type JSONArray.");
      JSONArray localJSONArray = (JSONArray)paramObject;
      int i = 0;
      while (true)
        if (i < localJSONArray.length())
          try
          {
            p(localJSONArray.getString(i));
            i++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i.b("Unable to parse impression trackers.");
          }
    }

    public void b(Object paramObject)
      throws ClassCastException
    {
      if (!(paramObject instanceof JSONArray))
        throw new ClassCastException("Expected viewability trackers of type JSONArray.");
      JSONArray localJSONArray = (JSONArray)paramObject;
      int i = 0;
      while (true)
        if (i < localJSONArray.length())
          try
          {
            q(localJSONArray.getString(i));
            i++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i.b("Unable to parse viewability trackers.");
          }
    }

    public void c(Object paramObject)
      throws ClassCastException
    {
      if (!(paramObject instanceof JSONArray))
        throw new ClassCastException("Expected click trackers of type JSONArray.");
      JSONArray localJSONArray = (JSONArray)paramObject;
      int i = 0;
      while (true)
        if (i < localJSONArray.length())
          try
          {
            r(localJSONArray.getString(i));
            i++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i.b("Unable to parse click trackers.");
          }
    }

    public void d(Object paramObject)
    {
      if (!(paramObject instanceof JSONArray))
        throw new ClassCastException("Expected win notices of type JSONArray.");
      JSONArray localJSONArray = (JSONArray)paramObject;
      int i = 0;
      while (true)
        if (i < localJSONArray.length())
          try
          {
            s(localJSONArray.getString(i));
            i++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i.b("Unable to parse win notices");
          }
    }

    public void e(Object paramObject)
    {
      if (!(paramObject instanceof JSONArray))
        throw new ClassCastException("Expected loss notices of type JSONArray.");
      JSONArray localJSONArray = (JSONArray)paramObject;
      int i = 0;
      while (true)
        if (i < localJSONArray.length())
          try
          {
            t(localJSONArray.getString(i));
            i++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              i.b("Unable to parse loss notices");
          }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.l
 * JD-Core Version:    0.6.2
 */