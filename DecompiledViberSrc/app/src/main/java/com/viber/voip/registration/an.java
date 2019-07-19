package com.viber.voip.registration;

import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.b;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class an
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.DAYS.toMillis(1L);

  private static boolean a(int paramInt)
  {
    return paramInt < 2;
  }

  private static boolean a(long paramLong)
  {
    return System.currentTimeMillis() - b >= paramLong;
  }

  static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return false;
      String str = d.b.c.d();
      if (!TextUtils.isEmpty(str));
      try
      {
        JSONObject localJSONObject1 = new JSONObject(str);
        if (localJSONObject1.has(paramString))
        {
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject(paramString);
          int i = localJSONObject2.getInt("attempts");
          long l = localJSONObject2.getLong("timestamp");
          if (!a(i))
          {
            boolean bool = a(l);
            if (!bool);
          }
          else
          {
            return true;
          }
        }
        else
        {
          return true;
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
    return false;
  }

  static a b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return new a(false, 0);
    String str = d.b.c.d();
    JSONObject localJSONObject3;
    JSONObject localJSONObject5;
    long l;
    if (!TextUtils.isEmpty(str))
      try
      {
        localJSONObject3 = new JSONObject(str);
        if (localJSONObject3.has(paramString))
        {
          localJSONObject5 = localJSONObject3.getJSONObject(paramString);
          int i = localJSONObject5.getInt("attempts");
          l = localJSONObject5.getLong("timestamp");
          if (a(i))
          {
            int j = i + 1;
            localJSONObject5.put("attempts", j);
            localJSONObject5.put("timestamp", System.currentTimeMillis());
            d.b.c.a(localJSONObject3.toString());
            a locala3 = new a(true, j);
            return locala3;
          }
        }
      }
      catch (JSONException localJSONException2)
      {
      }
    while (true)
    {
      return new a(false, 0);
      if (a(l))
      {
        localJSONObject5.put("attempts", 1);
        localJSONObject5.put("timestamp", System.currentTimeMillis());
        d.b.c.a(localJSONObject3.toString());
        return new a(true, 1);
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("attempts", 1);
        localJSONObject4.put("timestamp", System.currentTimeMillis());
        localJSONObject3.put(paramString, localJSONObject4);
        d.b.c.a(localJSONObject3.toString());
        a locala2 = new a(true, 1);
        return locala2;
        try
        {
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("attempts", 1);
          localJSONObject1.put("timestamp", System.currentTimeMillis());
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put(paramString, localJSONObject1);
          d.b.c.a(localJSONObject2.toString());
          a locala1 = new a(true, 1);
          return locala1;
        }
        catch (JSONException localJSONException1)
        {
        }
      }
    }
  }

  static class a
  {
    boolean a;
    int b;

    a(boolean paramBoolean, int paramInt)
    {
      this.a = paramBoolean;
      this.b = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.an
 * JD-Core Version:    0.6.2
 */