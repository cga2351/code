package com.viber.voip.analytics.story;

import android.support.v4.util.ArrayMap;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.k.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  private static final e c = ViberEnv.getLogger();
  protected final ArrayMap<String, Object> a = new ArrayMap();
  protected final ArrayMap<Class, a> b = new ArrayMap();
  private final boolean d;
  private final HashSet<Class> e;
  private a f;

  public f()
  {
    this(true);
  }

  public f(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.e = new HashSet();
  }

  private a c(Class paramClass)
  {
    boolean bool = this.b.containsKey(paramClass);
    a locala = null;
    if (bool)
      locala = (a)this.b.get(paramClass);
    return locala;
  }

  public final ArrayMap<String, Object> a(Class paramClass, String[] paramArrayOfString)
  {
    ArrayMap localArrayMap = b(paramClass);
    if (localArrayMap.size() > 0)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        localArrayMap.remove(paramArrayOfString[j]);
    }
    return localArrayMap;
  }

  String a(Class paramClass, String paramString)
  {
    a locala = c(paramClass);
    String str = null;
    if (locala != null)
      str = (String)locala.a().get(paramString);
    return str;
  }

  public final Map.Entry<String, Object> a(Class paramClass)
  {
    String str = a(paramClass, "key_property_name");
    if (str != null);
    while (true)
    {
      return b(paramClass, str);
      str = "key_property_name";
    }
  }

  public final ArrayMap<String, Object> b(Class paramClass)
  {
    a locala = c(paramClass);
    if (locala != null)
      return locala.a(this.a);
    return new ArrayMap();
  }

  public f b(Class paramClass, a parama)
  {
    this.e.add(paramClass);
    this.b.put(paramClass, parama);
    return this;
  }

  public f b(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    return this;
  }

  public final Map.Entry<String, Object> b(Class paramClass, String paramString)
  {
    Iterator localIterator = b(paramClass).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).equals(paramString))
        return localEntry;
    }
    return null;
  }

  public JSONObject b(Class paramClass, String[] paramArrayOfString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = a(paramClass, paramArrayOfString).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
    }
    return localJSONObject;
  }

  public void b(a parama)
  {
    this.f = parama;
  }

  public boolean b()
  {
    return this.d;
  }

  public final Object c(Class paramClass, String paramString)
  {
    ArrayMap localArrayMap = b(paramClass);
    if (localArrayMap.size() > 0)
      return localArrayMap.get(paramString);
    return null;
  }

  public final HashSet<Class> c()
  {
    return this.e;
  }

  public final a d()
  {
    return this.f;
  }

  public String toString()
  {
    return "StoryProperty{, properties=" + this.a + ", enabled=" + this.d + ", trackers=" + this.e + ", mTrackRule=" + this.f + '}';
  }

  public static abstract class a
  {
    public abstract ArrayMap<String, String> a();

    public ArrayMap<String, Object> a(ArrayMap<String, Object> paramArrayMap)
    {
      ArrayMap localArrayMap1 = new ArrayMap();
      ArrayMap localArrayMap2 = a();
      Iterator localIterator = paramArrayMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localArrayMap2.containsKey(str))
          localArrayMap1.put((String)localArrayMap2.get(str), a(str, paramArrayMap.get(str)));
      }
      return localArrayMap1;
    }

    protected Object a(String paramString, Object paramObject)
    {
      ArrayMap localArrayMap = b();
      a locala;
      if (localArrayMap.containsKey(paramString))
        locala = (a)localArrayMap.get(paramString);
      try
      {
        Object localObject = locala.a(paramObject);
        paramObject = localObject;
        return paramObject;
      }
      catch (Exception localException)
      {
      }
      return paramObject;
    }

    public abstract ArrayMap<String, a> b();

    public static abstract interface a<T1, T2>
    {
      public abstract T2 a(T1 paramT1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.f
 * JD-Core Version:    0.6.2
 */