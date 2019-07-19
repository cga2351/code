package com.mixpanel.android.mpmetrics;

import com.mixpanel.android.b.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

public class v
{
  private final ConcurrentMap<String, b> a = new ConcurrentHashMap();
  private final ConcurrentMap<String, b> b = new ConcurrentHashMap();
  private final ConcurrentMap<String, b> c = new ConcurrentHashMap();
  private final List<a> d = new ArrayList();

  u<Byte> a(final String paramString, byte paramByte)
  {
    a(paramString, Byte.valueOf(paramByte), null, null, 3);
    return new u()
    {
    };
  }

  u<Double> a(final String paramString, double paramDouble)
  {
    a(paramString, Double.valueOf(paramDouble), null, null, 2);
    return new u()
    {
    };
  }

  u<Double> a(final String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    a(paramString, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Double.valueOf(paramDouble3), 2);
    return new u()
    {
    };
  }

  u<Float> a(final String paramString, float paramFloat)
  {
    a(paramString, Float.valueOf(paramFloat), null, null, 2);
    return new u()
    {
    };
  }

  u<Float> a(final String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), 2);
    return new u()
    {
    };
  }

  u<Integer> a(final String paramString, int paramInt)
  {
    a(paramString, Integer.valueOf(paramInt), null, null, 3);
    return new u()
    {
    };
  }

  u<Integer> a(final String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), 3);
    return new u()
    {
    };
  }

  u<Long> a(final String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong), null, null, 3);
    return new u()
    {
    };
  }

  u<Long> a(final String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    a(paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), 3);
    return new u()
    {
    };
  }

  u<String> a(final String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null, null, 4);
    return new u()
    {
    };
  }

  u<Short> a(final String paramString, short paramShort)
  {
    a(paramString, Short.valueOf(paramShort), null, null, 3);
    return new u()
    {
    };
  }

  u<Boolean> a(final String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.valueOf(paramBoolean), null, null, 1);
    return new u()
    {
    };
  }

  public Map<String, b> a()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.a);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(a parama)
  {
    if (parama == null)
      try
      {
        throw new NullPointerException("listener cannot be null");
      }
      finally
      {
      }
    this.d.add(parama);
  }

  public void a(String paramString, b paramb)
  {
    if ((paramString == null) || (paramb == null))
      return;
    this.c.put(paramString, paramb);
  }

  public void a(String paramString, Object paramObject)
  {
    try
    {
      if (!this.a.containsKey(paramString))
        f.d("MixpanelAPI.Tweaks", "Attempt to set a tweak \"" + paramString + "\" which has never been defined.");
      while (true)
      {
        return;
        b localb = ((b)this.a.get(paramString)).a(paramObject);
        this.a.put(paramString, localb);
      }
    }
    finally
    {
    }
  }

  public void a(String paramString, Object paramObject, Number paramNumber1, Number paramNumber2, int paramInt)
  {
    if (this.a.containsKey(paramString))
    {
      f.d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + paramString + "\" twice with the same name");
      return;
    }
    b localb;
    if (this.c.containsKey(paramString))
    {
      localb = (b)this.c.get(paramString);
      this.c.remove(paramString);
    }
    while (true)
    {
      this.a.put(paramString, localb);
      this.b.put(paramString, localb);
      int i = this.d.size();
      for (int j = 0; j < i; j++)
        ((a)this.d.get(j)).a();
      break;
      localb = new b(paramInt, paramObject, paramNumber1, paramNumber2, paramObject, paramString, null);
    }
  }

  public Map<String, b> b()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.b);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean b(String paramString, Object paramObject)
  {
    try
    {
      boolean bool1 = this.a.containsKey(paramString);
      boolean bool2 = false;
      if (!bool1)
        return bool2;
      boolean bool3 = b.a((b)this.a.get(paramString)).equals(paramObject);
      if (!bool3);
      for (boolean bool4 = true; ; bool4 = false)
      {
        bool2 = bool4;
        break;
      }
    }
    finally
    {
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }

  public static class b
  {
    public final int a;
    private final Object b;
    private final Object c;
    private final Number d;
    private final Number e;
    private final String f;

    private b(int paramInt, Object paramObject1, Number paramNumber1, Number paramNumber2, Object paramObject2, String paramString)
    {
      this.a = paramInt;
      this.f = paramString;
      this.d = paramNumber1;
      this.e = paramNumber2;
      if ((this.d != null) && (this.e != null))
      {
        if (!b(paramObject1))
        {
          paramObject1 = Long.valueOf(Math.min(Math.max(((Number)paramObject1).longValue(), this.d.longValue()), this.e.longValue()));
          f.d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + this.f + "\" with default value " + paramObject1 + " out of its bounds [" + this.d + ", " + this.e + "]Tweak \"" + this.f + "\" new default value: " + paramObject1 + ".");
        }
        if (!b(paramObject2))
        {
          paramObject2 = Long.valueOf(Math.min(Math.max(((Number)paramObject2).longValue(), this.d.longValue()), this.e.longValue()));
          f.d("MixpanelAPI.Tweaks", "Attempt to define a tweak \"" + this.f + "\" with value " + paramObject1 + " out of its bounds [" + this.d + ", " + this.e + "]Tweak \"" + this.f + "\" new value: " + paramObject2 + ".");
        }
      }
      this.c = paramObject1;
      this.b = paramObject2;
    }

    public static b a(JSONObject paramJSONObject)
    {
      while (true)
      {
        int j;
        Object localObject5;
        Object localObject6;
        try
        {
          String str1 = paramJSONObject.getString("name");
          String str2 = paramJSONObject.getString("type");
          if ("number".equals(str2))
          {
            String str4 = paramJSONObject.getString("encoding");
            if ("d".equals(str4))
            {
              j = 2;
              localObject5 = Double.valueOf(paramJSONObject.getDouble("value"));
              localObject6 = Double.valueOf(paramJSONObject.getDouble("default"));
              if (paramJSONObject.isNull("minimum"))
                break label305;
              localObject7 = Double.valueOf(paramJSONObject.getDouble("minimum"));
              if (!paramJSONObject.isNull("maximum"))
              {
                localObject8 = Double.valueOf(paramJSONObject.getDouble("maximum"));
                break label311;
                return new b(i, localObject2, (Number)localObject3, (Number)localObject4, localObject1, str1);
              }
            }
            else
            {
              if (!"l".equals(str4))
                break;
              localObject5 = Long.valueOf(paramJSONObject.getLong("value"));
              j = 3;
              localObject6 = Long.valueOf(paramJSONObject.getLong("default"));
              if (paramJSONObject.isNull("minimum"))
                break label299;
              localObject7 = Long.valueOf(paramJSONObject.getLong("minimum"));
              if (!paramJSONObject.isNull("maximum"))
              {
                localObject8 = Long.valueOf(paramJSONObject.getLong("maximum"));
                break label311;
              }
            }
          }
          else
          {
            if ("boolean".equals(str2))
            {
              i = 1;
              localObject1 = Boolean.valueOf(paramJSONObject.getBoolean("value"));
              localObject2 = Boolean.valueOf(paramJSONObject.getBoolean("default"));
              localObject3 = null;
              localObject4 = null;
              continue;
            }
            if (!"string".equals(str2))
              break;
            i = 4;
            localObject1 = paramJSONObject.getString("value");
            String str3 = paramJSONObject.getString("default");
            localObject2 = str3;
            localObject3 = null;
            localObject4 = null;
            continue;
          }
        }
        catch (JSONException localJSONException)
        {
          return null;
        }
        Object localObject8 = null;
        break label311;
        label299: Object localObject7 = null;
        continue;
        label305: localObject7 = null;
        continue;
        label311: Object localObject1 = localObject5;
        Object localObject4 = localObject8;
        int i = j;
        Object localObject9 = localObject6;
        Object localObject3 = localObject7;
        Object localObject2 = localObject9;
      }
      return null;
    }

    private boolean b(Object paramObject)
    {
      try
      {
        Number localNumber = (Number)paramObject;
        if (Math.min(Math.max(localNumber.longValue(), this.d.longValue()), this.e.longValue()) != this.d.longValue())
        {
          long l1 = Math.min(Math.max(localNumber.longValue(), this.d.longValue()), this.e.longValue());
          long l2 = this.e.longValue();
          if (l1 != l2);
        }
        else
        {
          return false;
        }
      }
      catch (ClassCastException localClassCastException)
      {
      }
      return true;
    }

    public b a(Object paramObject)
    {
      return new b(this.a, this.c, this.d, this.e, paramObject, this.f);
    }

    public String a()
    {
      try
      {
        String str3 = (String)this.c;
        str1 = str3;
        try
        {
          String str2 = (String)this.b;
          return str2;
        }
        catch (ClassCastException localClassCastException2)
        {
          return str1;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        while (true)
          String str1 = null;
      }
    }

    public Number b()
    {
      Object localObject = Integer.valueOf(0);
      if (this.c != null);
      try
      {
        Number localNumber2 = (Number)this.c;
        localObject = localNumber2;
        label24: if (this.b != null);
        try
        {
          Number localNumber1 = (Number)this.b;
          localObject = localNumber1;
          return localObject;
        }
        catch (ClassCastException localClassCastException1)
        {
          return localObject;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        break label24;
      }
    }

    public Boolean c()
    {
      Object localObject = Boolean.valueOf(false);
      if (this.c != null);
      try
      {
        Boolean localBoolean2 = (Boolean)this.c;
        localObject = localBoolean2;
        label24: if (this.b != null);
        try
        {
          Boolean localBoolean1 = (Boolean)this.b;
          localObject = localBoolean1;
          return localObject;
        }
        catch (ClassCastException localClassCastException1)
        {
          return localObject;
        }
      }
      catch (ClassCastException localClassCastException2)
      {
        break label24;
      }
    }

    public Number d()
    {
      return this.d;
    }

    public Number e()
    {
      return this.e;
    }

    public Object f()
    {
      return this.c;
    }

    public Object g()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.v
 * JD-Core Version:    0.6.2
 */