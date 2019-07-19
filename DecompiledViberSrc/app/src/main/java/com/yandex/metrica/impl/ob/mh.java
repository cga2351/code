package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.yandex.metrica.impl.aw.a;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class mh
{
  private static final Map<ku.a.b.a, String> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private static final Map<aw.a, String> b = Collections.unmodifiableMap(new HashMap()
  {
  });

  private static JSONObject a(Map<String, List<String>> paramMap)
    throws JSONException
  {
    boolean bool = bw.a(paramMap);
    Object localObject = null;
    if (!bool)
    {
      JSONObject localJSONObject = new JSONObject();
      Iterator localIterator1 = paramMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        String str1 = (String)localEntry.getKey();
        if (!bw.a((Collection)localEntry.getValue()))
        {
          List localList = bw.a((List)localEntry.getValue(), 10);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            if (!TextUtils.isEmpty(str2))
            {
              if (str2.length() > 100)
                str2 = str2.substring(0, 100);
              localArrayList.add(str2);
            }
          }
          localJSONObject.putOpt(str1, TextUtils.join(",", localArrayList));
        }
      }
      localObject = localJSONObject;
    }
    return localObject;
  }

  public String a(ku.a.a parama)
  {
    try
    {
      String str = new JSONObject().put("id", parama.a).toString();
      return str;
    }
    catch (Exception localException)
    {
      return localException.toString();
    }
  }

  public String a(ku.a.b paramb)
  {
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("id", paramb.a().a);
        localJSONObject.putOpt("url", paramb.a().b);
        localJSONObject.putOpt("status", a.get(paramb.b()));
        localJSONObject.putOpt("code", paramb.d());
        if (!bw.a(paramb.e()))
        {
          localJSONObject.putOpt("body", Base64.encodeToString(paramb.e(), 0));
          localJSONObject.putOpt("headers", a(paramb.f()));
          Exception localException2 = paramb.g();
          if (localException2 != null)
          {
            str = localException2.toString() + "\n" + Log.getStackTraceString(localException2);
            localJSONObject.putOpt("error", str);
            localJSONObject.putOpt("network_type", b.get(paramb.c()));
            return localJSONObject.toString();
          }
        }
        else
        {
          if (bw.a(paramb.h()))
            continue;
          localJSONObject.putOpt("body", Base64.encodeToString(paramb.h(), 0));
          continue;
        }
      }
      catch (Exception localException1)
      {
        return localException1.toString();
      }
      String str = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mh
 * JD-Core Version:    0.6.2
 */