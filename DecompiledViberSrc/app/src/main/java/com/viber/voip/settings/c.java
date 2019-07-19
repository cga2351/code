package com.viber.voip.settings;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import com.viber.common.b.g;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.at;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class c
  implements g
{
  private static final Logger f = ViberEnv.getLogger();
  protected final Map<String, Object> a = new ConcurrentHashMap(213);
  protected final a b;
  protected final Handler c;
  protected AtomicBoolean d = new AtomicBoolean(false);
  protected Set<String> e = Collections.synchronizedSet(new HashSet());

  public c(Context paramContext, Handler paramHandler, String paramString)
  {
    this.b = new a(paramContext, c(paramString));
    this.c = paramHandler;
  }

  private static String b(Context paramContext, String paramString)
  {
    if (!paramString.equals(new File(paramString).getAbsolutePath()))
      paramString = paramContext.getFilesDir().getAbsolutePath() + '/' + paramString;
    return paramString;
  }

  private static String c(String paramString)
  {
    if (paramString == null)
      return "preferences/";
    return "preferences/" + paramString + "/";
  }

  public float a(String paramString, float paramFloat)
  {
    return ((Float)a(paramString, Float.class, Float.valueOf(paramFloat))).floatValue();
  }

  public int a(String paramString, int paramInt)
  {
    return ((Integer)a(paramString, Integer.class, Integer.valueOf(paramInt))).intValue();
  }

  public long a(String paramString, long paramLong)
  {
    return ((Long)a(paramString, Long.class, Long.valueOf(paramLong))).longValue();
  }

  protected Object a(String paramString, Class<?> paramClass, Object paramObject)
  {
    Object localObject1 = this.a.get(paramString);
    if ((localObject1 != null) && ((paramClass == null) || (localObject1.getClass().equals(paramClass))))
      paramObject = localObject1;
    Object localObject2;
    do
    {
      return paramObject;
      localObject2 = this.b.d(paramString);
    }
    while ((localObject2 == null) || ((paramClass != null) && (!localObject2.getClass().equals(paramClass))));
    this.a.put(paramString, localObject2);
    return localObject2;
  }

  public String a(String paramString1, String paramString2)
  {
    return (String)a(paramString1, String.class, paramString2);
  }

  public Set<String> a(String paramString, Set<String> paramSet)
  {
    return (Set)a(paramString, Set.class, paramSet);
  }

  public void a()
  {
    Map localMap = b();
    new HashMap(localMap);
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.b.b((String)localEntry.getKey());
    }
    this.a.clear();
  }

  protected void a(String paramString, Object paramObject)
  {
    this.a.put(paramString, paramObject);
    this.b.a(paramString, paramObject);
  }

  public boolean a(String paramString)
  {
    if (this.a.containsKey(paramString))
      return true;
    synchronized (this.e)
    {
      if (this.e.contains(paramString))
        return true;
    }
    boolean bool = this.b.c(paramString);
    if (bool)
      this.e.add(paramString);
    return bool;
  }

  public boolean a(String paramString, boolean paramBoolean)
  {
    return ((Boolean)a(paramString, Boolean.class, Boolean.valueOf(paramBoolean))).booleanValue();
  }

  public Map<String, ? extends Object> b()
  {
    Map localMap2;
    synchronized (this.a)
    {
      if (this.d.get())
        break label130;
      localMap2 = this.b.a();
      Iterator localIterator = localMap2.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        Object localObject3 = localEntry.getValue();
        if ((str != null) && (localObject3 != null))
          this.a.put(str, localObject3);
      }
    }
    this.d.set(true);
    label130: for (Object localObject2 = localMap2; ; localObject2 = new HashMap(this.a))
      return localObject2;
  }

  public void b(String paramString)
  {
    this.a.remove(paramString);
    this.b.a(paramString);
  }

  public void b(String paramString, float paramFloat)
  {
    a(paramString, Float.valueOf(paramFloat));
  }

  public void b(String paramString, int paramInt)
  {
    a(paramString, Integer.valueOf(paramInt));
  }

  public void b(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
  }

  public void b(String paramString1, String paramString2)
  {
    if (paramString2 == null)
      paramString2 = "";
    a(paramString1, paramString2);
  }

  public void b(String paramString, Set<String> paramSet)
  {
    a(paramString, paramSet);
  }

  public void b(String paramString, boolean paramBoolean)
  {
    a(paramString, Boolean.valueOf(paramBoolean));
  }

  public String toString()
  {
    StringBuffer localStringBuffer;
    synchronized (this.a)
    {
      if (!this.d.get())
        b();
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("{ PreferencesStorage: \n");
      Iterator localIterator = this.a.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuffer.append("   ").append((String)localEntry.getKey()).append(": ").append(localEntry.getValue()).append("\n");
      }
    }
    localStringBuffer.append("}");
    String str = localStringBuffer.toString();
    return str;
  }

  protected class a
  {
    protected final ReentrantLock a = new ReentrantLock();
    protected String b;
    private Map<String, Object> d = Collections.synchronizedMap(new HashMap());

    protected a(Context paramString, String arg3)
    {
      String str;
      this.b = c.a(paramString, str);
      new File(this.b).mkdirs();
    }

    protected Map<String, ? extends Object> a()
      throws Resources.NotFoundException
    {
      while (true)
      {
        int j;
        synchronized (this.d)
        {
          this.d.clear();
          String[] arrayOfString = at.g(this.b);
          int i = arrayOfString.length;
          j = 0;
          if (j < i)
          {
            String str = arrayOfString[j];
            Object localObject2 = f(str);
            if (localObject2 != null)
              this.d.put(str, localObject2);
          }
          else
          {
            HashMap localHashMap = new HashMap(this.d);
            return localHashMap;
          }
        }
        j++;
      }
    }

    protected void a(String paramString)
    {
      c.this.c.post(new a(paramString));
    }

    protected void a(String paramString, Object paramObject)
    {
      c.this.c.post(new b(paramString, paramObject));
    }

    protected void b(String paramString)
    {
      new a(paramString).run();
    }

    protected boolean c(String paramString)
    {
      return e(paramString);
    }

    protected Object d(String paramString)
      throws Resources.NotFoundException
    {
      return f(paramString);
    }

    protected boolean e(String paramString)
    {
      this.a.lock();
      try
      {
        boolean bool = new File(g(paramString)).exists();
        return bool;
      }
      finally
      {
        this.a.unlock();
      }
    }

    protected Object f(String paramString)
    {
      return at.b(g(paramString), this.a);
    }

    protected String g(String paramString)
    {
      return this.b + paramString;
    }

    protected class a
      implements Runnable
    {
      protected final String a;

      protected a(String arg2)
      {
        Object localObject;
        this.a = localObject;
      }

      public void run()
      {
        at.a(c.a.this.g(this.a), c.a.this.a);
      }
    }

    protected class b
      implements Runnable
    {
      protected final String a;
      protected final Object b;

      protected b(String paramObject, Object arg3)
      {
        this.a = paramObject;
        Object localObject;
        this.b = localObject;
      }

      public void run()
      {
        at.a(c.a.this.g(this.a), this.b, c.a.this.a);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c
 * JD-Core Version:    0.6.2
 */