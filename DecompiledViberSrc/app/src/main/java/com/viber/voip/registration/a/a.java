package com.viber.voip.registration.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.bu;
import com.viber.voip.util.da;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final c c;
  private final byte d;
  private final List<a> e;
  private final int f;
  private final List<String> g;

  public a(int paramInt1, c paramc, byte paramByte, List<a> paramList, int paramInt2, List<String> paramList1)
  {
    this.b = paramInt1;
    this.c = paramc;
    this.d = paramByte;
    this.e = paramList;
    this.f = paramInt2;
    this.g = paramList1;
  }

  public String a()
  {
    while (true)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("reg_reason", Integer.toString(this.b));
        localJSONObject1.put("sign", this.c.a());
        localJSONObject1.put("key_src", Byte.toString(this.d));
        localJSONObject1.put("error", Integer.toString(this.f));
        i = localJSONObject1.toString().length();
        JSONArray localJSONArray1 = new JSONArray();
        Iterator localIterator1 = this.e.iterator();
        if (localIterator1.hasNext())
        {
          JSONObject localJSONObject2 = ((a)localIterator1.next()).a();
          j = i + localJSONObject2.toString().length();
          JSONArray localJSONArray2;
          String str;
          int m;
          if (j >= 2900)
          {
            localJSONObject1.put("additional", localJSONArray1);
            localJSONArray2 = new JSONArray();
            Iterator localIterator2 = this.g.iterator();
            k = j;
            if (localIterator2.hasNext())
            {
              str = bu.a((String)localIterator2.next());
              if (da.a(str))
                continue;
              m = k + str.length();
              if (m < 2900)
                continue;
            }
            localJSONObject1.put("gacc", localJSONArray2);
            return localJSONObject1.toString();
          }
          else
          {
            localJSONArray1.put(localJSONObject2);
            i = j;
            continue;
          }
          localJSONArray2.put(str);
          int k = m;
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        return "";
      }
      int j = i;
    }
  }

  public static final class a extends a.b
  {
    private final String a;

    public a(String paramString1, String paramString2, String paramString3)
    {
      super(paramString3);
      this.a = paramString1;
    }

    protected void a(JSONObject paramJSONObject)
      throws JSONException
    {
      super.a(paramJSONObject);
      paramJSONObject.put("key", this.a);
    }
  }

  private static abstract class b
  {
    private final String a;
    private final String b;

    public b(String paramString1, String paramString2)
    {
      if (paramString1 == null)
        paramString1 = "";
      this.a = paramString1;
      this.b = paramString2;
    }

    public final JSONObject a()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        a(localJSONObject);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
      }
      return localJSONObject;
    }

    protected void a(JSONObject paramJSONObject)
      throws JSONException
    {
      if (da.a(this.a));
      for (String str = ""; ; str = this.a.substring(0, Math.min(this.a.length(), 8)))
      {
        paramJSONObject.put("dkey", str);
        paramJSONObject.put("udid", this.b);
        return;
      }
    }
  }

  public static final class c extends a.b
  {
    private final String a = "Android";
    private final long b;

    public c(String paramString1, String paramString2, long paramLong)
    {
      super(paramString2);
      this.b = paramLong;
    }

    protected void a(JSONObject paramJSONObject)
      throws JSONException
    {
      super.a(paramJSONObject);
      paramJSONObject.put("system", "Android");
      paramJSONObject.put("ts", Long.toString(this.b));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.a.a
 * JD-Core Version:    0.6.2
 */