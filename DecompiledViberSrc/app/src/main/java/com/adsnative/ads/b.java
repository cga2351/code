package com.adsnative.ads;

import android.content.Context;
import com.adsnative.a.d.a;
import com.adsnative.b.c;
import com.adsnative.c.h;
import com.adsnative.c.i;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.adsnative.a.d
{
  public void a(Context paramContext, d.a parama, c paramc)
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

  public static class a extends d
  {
    private final Context a;
    private final d.a b;
    private final JSONObject c;

    a(Context paramContext, JSONObject paramJSONObject, d.a parama)
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
        switch (b.1.a[paramb.ordinal()])
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
          f((String)paramObject);
          return;
          c((JSONObject)paramObject);
          return;
          JSONObject localJSONObject = (JSONObject)paramObject;
          if (localJSONObject != null)
          {
            a(localJSONObject.opt("impressions"));
            a(localJSONObject.opt("viewables"));
            b(localJSONObject.opt("clicks"));
            return;
          }
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
          k((String)paramObject);
          return;
        }
        throw localClassCastException;
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
      if ((h() != null) || (i() != null))
      {
        this.b.a(this);
        return;
      }
      this.b.a(e.i);
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
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.b
 * JD-Core Version:    0.6.2
 */