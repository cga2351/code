package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import com.yandex.mobile.ads.nativeads.NativeAdType;
import com.yandex.mobile.ads.nativeads.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class mc
{
  public static lm a(String paramString)
    throws JSONException, x
  {
    lm locallm = a(new JSONObject(paramString));
    int i = 0;
    if (locallm != null)
    {
      List localList = locallm.c();
      i = 0;
      if (localList != null)
      {
        boolean bool = localList.isEmpty();
        i = 0;
        if (!bool)
          i = 1;
      }
    }
    if (i != 0)
      return locallm;
    throw new x("Native Ad json has not required attributes");
  }

  private static lm a(JSONObject paramJSONObject)
    throws JSONException, x
  {
    lm locallm = (lm)fn.a(lm.class, new Object[0]);
    if (locallm != null)
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("native");
      if (!md.a(localJSONObject, new String[] { "ads" }))
        throw new x("Native Ad json has not required attributes");
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("ads".equals(str))
        {
          ArrayList localArrayList = new ArrayList();
          JSONArray localJSONArray = localJSONObject.getJSONArray("ads");
          int i = 0;
          if (i < localJSONArray.length())
          {
            ll localll = f(localJSONArray.getJSONObject(i));
            int k;
            label171: int j;
            if (localll != null)
            {
              List localList1 = localll.c();
              li localli = localll.a();
              NativeAdType localNativeAdType = localll.b();
              if (!localList1.isEmpty())
                if (localli != null)
                {
                  k = 1;
                  if ((k == 0) || (localNativeAdType == null))
                    break label211;
                  j = 1;
                }
            }
            while (true)
            {
              if (j == 0)
                break label223;
              localArrayList.add(localll);
              i++;
              break;
              k = 0;
              break label171;
              label211: j = 0;
              continue;
              j = 0;
            }
            label223: throw new x("Native Ad json has not required attributes");
          }
          locallm.b(localArrayList);
        }
        else if ("assets".equals(str))
        {
          List localList2 = g(localJSONObject);
          if (localList2.isEmpty())
            localList2 = null;
          locallm.a(localList2);
        }
        else if ("settings".equals(str))
        {
          locallm.a(b(localJSONObject));
        }
        else if ("showNotices".equals(str))
        {
          locallm.c(c(localJSONObject));
        }
        else if ("ver".equals(str))
        {
          locallm.a(a(localJSONObject, str));
        }
        else if ("renderTrackingUrls".equals(str))
        {
          locallm.d(d(localJSONObject));
        }
      }
    }
    return locallm;
  }

  public static String a(JSONObject paramJSONObject, String paramString)
    throws JSONException, x
  {
    String str = paramJSONObject.getString(paramString);
    if ((TextUtils.isEmpty(str)) || ("null".equals(str)))
      throw new x("Native Ad json has not required attributes");
    return str;
  }

  private static ln b(JSONObject paramJSONObject)
    throws JSONException, x
  {
    ln localln = (ln)fn.a(ln.class, new Object[0]);
    if (localln != null)
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("settings");
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("templateType".equals(str))
          localln.a(a(localJSONObject, str));
        else if ("highlightingEnabled".equals(str))
          localln.a(localJSONObject.getBoolean(str));
      }
    }
    return localln;
  }

  public static String b(JSONObject paramJSONObject, String paramString)
    throws JSONException, x
  {
    String str = df.e(a(paramJSONObject, paramString));
    if (TextUtils.isEmpty(str))
      throw new x("Native Ad json has not required attributes");
    return str;
  }

  public static String c(JSONObject paramJSONObject, String paramString)
    throws JSONException, x
  {
    boolean bool = paramJSONObject.has(paramString);
    String str = null;
    if (bool)
      str = a(paramJSONObject, paramString);
    return df.e(str);
  }

  private static List<bd> c(JSONObject paramJSONObject)
    throws JSONException, x
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("showNotices");
    for (int i = 0; i < localJSONArray.length(); i++)
      localArrayList.add(e(localJSONArray.getJSONObject(i)));
    return localArrayList;
  }

  private static List<String> d(JSONObject paramJSONObject)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("renderTrackingUrls");
    for (int i = 0; i < localJSONArray.length(); i++)
      localArrayList.add(df.e(localJSONArray.getString(i)));
    return localArrayList;
  }

  private static bd e(JSONObject paramJSONObject)
    throws x, JSONException
  {
    bd localbd = (bd)fn.a(bd.class, new Object[0]);
    if (localbd != null)
    {
      if (!md.a(paramJSONObject, new String[] { "delay", "url" }))
        throw new x("Native Ad json has not required attributes");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("delay".equals(str))
          localbd.a(paramJSONObject.getLong(str));
        else if ("url".equals(str))
          localbd.a(b(paramJSONObject, str));
        else if ("visibilityPercent".equals(str))
          localbd.a(Math.max(Math.min(paramJSONObject.optInt(str, 0), 100), 0));
      }
    }
    return localbd;
  }

  private static ll f(JSONObject paramJSONObject)
    throws JSONException, x
  {
    ll localll = (ll)fn.a(ll.class, new Object[0]);
    if (localll != null)
    {
      if (!md.a(paramJSONObject, new String[] { "adType", "assets", "link" }))
        throw new x("Native Ad json has not required attributes");
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("adType".equals(str))
        {
          localll.a(a(paramJSONObject, str));
        }
        else if ("assets".equals(str))
        {
          localll.a(g(paramJSONObject));
        }
        else if ("link".equals(str))
        {
          localll.a(mh.a(paramJSONObject.getJSONObject(str)));
        }
        else if ("showNotice".equals(str))
        {
          localll.a(e(paramJSONObject.getJSONObject(str)));
        }
        else if ("info".equals(str))
        {
          localll.d(paramJSONObject.optString(str, null));
        }
        else if ("hideConditions".equals(str))
        {
          new me();
          localll.a(me.a(paramJSONObject, str));
        }
        else if ("showConditions".equals(str))
        {
          new me();
          localll.b(me.a(paramJSONObject, str));
        }
        else if ("renderTrackingUrl".equals(str))
        {
          localll.c(b(paramJSONObject, str));
        }
      }
    }
    return localll;
  }

  private static List<le> g(JSONObject paramJSONObject)
    throws JSONException, x
  {
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("assets");
    int i = 0;
    JSONObject localJSONObject1;
    boolean bool1;
    if (i < localJSONArray.length())
    {
      localJSONObject1 = localJSONArray.getJSONObject(i);
      bool1 = localJSONObject1.getBoolean("required");
    }
    while (true)
    {
      try
      {
        if (!md.a(localJSONObject1, new String[] { "name", "type", "clickable", "required", "value" }))
          throw new x("Native Ad json has not required attributes");
      }
      catch (JSONException localJSONException)
      {
        if (bool1)
        {
          throw localJSONException;
          String str1 = a(localJSONObject1, "type");
          String str2 = a(localJSONObject1, "name");
          int j = -1;
          boolean bool2;
          switch (str2.hashCode())
          {
          case -1074675180:
            bool2 = "string".equals(str1);
            if (!bool2)
            {
              throw new x("Native Ad json has not required attributes");
              if (!str2.equals("favicon"))
                continue;
              j = 0;
            }
            break;
          case -191501435:
            if (str2.equals("feedback"))
              j = 1;
            break;
          case 3226745:
            if (str2.equals("icon"))
              j = 2;
            break;
          case 103772132:
            if (str2.equals("media"))
              j = 3;
            break;
          case -938102371:
            if (str2.equals("rating"))
              j = 4;
            break;
          case -807286424:
            if (str2.equals("review_count"))
            {
              j = 5;
              continue;
              bool2 = "image".equals(str1);
              continue;
              bool2 = "media".equals(str1);
              continue;
              bool2 = "number".equals(str1);
              continue;
              JSONObject localJSONObject2 = localJSONObject1.optJSONObject("link");
              if (localJSONObject2 == null)
                break label818;
              localli = mh.a(localJSONObject2);
              k = -1;
              Object localObject1;
              switch (str2.hashCode())
              {
              case -1074675180:
                localObject1 = new my();
                Object localObject2 = ((mr)localObject1).a(localJSONObject1);
                boolean bool3 = localJSONObject1.getBoolean("required");
                localArrayList.add(new le(str2, str1, localObject2, localli, localJSONObject1.getBoolean("clickable"), bool3));
                continue;
                if (!str2.equals("favicon"))
                  continue;
                k = 0;
                break;
              case 3226745:
                if (!str2.equals("icon"))
                  continue;
                k = 1;
                break;
              case 103772132:
                if (!str2.equals("media"))
                  continue;
                k = 2;
                break;
              case -938102371:
                if (!str2.equals("rating"))
                  continue;
                k = 3;
                break;
              case -807286424:
                if (!str2.equals("review_count"))
                  continue;
                k = 4;
                break;
              case -1678958759:
                if (!str2.equals("close_button"))
                  continue;
                k = 5;
                break;
              case -191501435:
                if (!str2.equals("feedback"))
                  continue;
                k = 6;
                continue;
                localObject1 = new mu();
                continue;
                localObject1 = new mv();
                continue;
                localObject1 = new mw();
                continue;
                localObject1 = new ms();
                continue;
                localObject1 = new mt(new mu());
                continue;
                if (md.a(localArrayList))
                  throw new x("Native Ad json has not required attributes");
                return localArrayList;
              }
            }
            break;
          }
          switch (j)
          {
          default:
          case 0:
          case 1:
          case 2:
          case 3:
          case 4:
          case 5:
          }
        }
      }
      catch (x localx)
      {
        int k;
        continue;
        switch (k)
        {
        default:
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
        i++;
      }
      break;
      label818: li localli = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.mc
 * JD-Core Version:    0.6.2
 */