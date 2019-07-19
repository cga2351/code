package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ah
{
  private final Context a;
  private final f b;
  private final z c;
  private String d;

  protected ah(f paramf, z paramz, Context paramContext)
  {
    this.b = paramf;
    this.c = paramz;
    this.a = paramContext;
  }

  public static ah a(f paramf, z paramz, Context paramContext)
  {
    return new ah(paramf, paramz, paramContext);
  }

  private p b(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    int i = paramJSONObject.optInt("viewablePercent", -1);
    if ((i < 0) || (i > 100))
    {
      a("Bad value", "failed to parse viewabilityStat: invalid viewable percent value");
      return null;
    }
    if (paramJSONObject.has("ovv"))
    {
      n localn = n.a(paramString);
      localn.a(i);
      localn.a(paramJSONObject.optBoolean("ovv", false));
      if (paramJSONObject.has("pvalue"))
      {
        float f3 = (float)paramJSONObject.optDouble("pvalue", localn.f());
        if ((f3 >= 0.0F) && (f3 <= 100.0F))
        {
          if (paramFloat > 0.0F)
          {
            localn.c(f3 * paramFloat / 100.0F);
            return localn;
          }
          localn.d(f3);
          return localn;
        }
      }
      if (paramJSONObject.has("value"))
      {
        float f2 = (float)paramJSONObject.optDouble("value", localn.e());
        if (f2 >= 0.0F)
        {
          localn.c(f2);
          return localn;
        }
      }
    }
    else if (paramJSONObject.has("duration"))
    {
      m localm = m.a(paramString);
      localm.a(i);
      float f1 = (float)paramJSONObject.optDouble("duration", localm.a());
      if (f1 >= 0.0F)
      {
        localm.a(f1);
        return localm;
      }
    }
    else
    {
      a("Bad value", "failed to parse viewabilityStat: no ovv or duration");
    }
    return null;
  }

  o a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    o localo = o.a(paramString);
    if (paramJSONObject.has("pvalue"))
    {
      float f2 = (float)paramJSONObject.optDouble("pvalue", localo.b());
      if ((f2 >= 0.0F) && (f2 <= 100.0F))
      {
        if (paramFloat > 0.0F)
        {
          localo.a(f2 * paramFloat / 100.0F);
          return localo;
        }
        localo.b(f2);
        return localo;
      }
    }
    if (paramJSONObject.has("value"))
    {
      float f1 = (float)paramJSONObject.optDouble("value", localo.a());
      if (f1 >= 0.0F)
      {
        localo.a(f1);
        return localo;
      }
    }
    return null;
  }

  protected p a(JSONObject paramJSONObject, float paramFloat)
  {
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("url");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      a("Required field", "failed to parse stat: no type or url");
      return null;
    }
    int i = -1;
    switch (str1.hashCode())
    {
    default:
    case 1788134515:
    case 1669348544:
    }
    while (true)
      switch (i)
      {
      default:
        return p.a(str1, str2);
        if (str1.equals("playheadReachedValue"))
        {
          i = 0;
          continue;
          if (str1.equals("playheadViewabilityValue"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    return a(paramJSONObject, str2, paramFloat);
    return b(paramJSONObject, str2, paramFloat);
  }

  public void a(q paramq, JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    paramq.a(this.b.q(), paramFloat);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("statistics");
    if (localJSONArray == null);
    int i;
    do
    {
      return;
      i = localJSONArray.length();
    }
    while (i <= 0);
    this.d = paramString;
    int j = 0;
    label47: JSONObject localJSONObject;
    if (j < i)
    {
      localJSONObject = localJSONArray.optJSONObject(j);
      if (localJSONObject != null)
        break label74;
    }
    while (true)
    {
      j++;
      break label47;
      break;
      label74: p localp = a(localJSONObject, paramFloat);
      if (localp != null)
        paramq.a(localp);
    }
  }

  protected void a(String paramString1, String paramString2)
  {
    y.a(paramString1).b(paramString2).a(this.c.c()).d(this.d).c(this.b.f()).a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ah
 * JD-Core Version:    0.6.2
 */