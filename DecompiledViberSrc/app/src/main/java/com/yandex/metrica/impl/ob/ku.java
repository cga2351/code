package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.yandex.metrica.impl.a;
import com.yandex.metrica.impl.aw.a;
import com.yandex.metrica.impl.br.a.a;
import com.yandex.metrica.impl.bt;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.w;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ku
{
  private static final Map<br.a.a, aw.a> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private final Context b;
  private final ge<a> c;
  private final Handler d;
  private final mg e;
  private final bt f;
  private final ny g;
  private a h;
  private boolean i = false;

  public ku(Context paramContext, ge<a> paramge, bt parambt, mg parammg, Handler paramHandler)
  {
    this(paramContext, paramge, parambt, parammg, paramHandler, new nv());
  }

  public ku(Context paramContext, ge<a> paramge, bt parambt, mg parammg, Handler paramHandler, ny paramny)
  {
    this.b = paramContext;
    this.c = paramge;
    this.f = parambt;
    this.e = parammg;
    this.h = ((a)this.c.a());
    this.d = paramHandler;
    this.g = paramny;
  }

  private static or<String, String> a(List<Pair<String, String>> paramList)
  {
    or localor = new or();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      localor.a(localPair.first, localPair.second);
    }
    return localor;
  }

  private void a(final ku.a.a parama)
  {
    long l = Math.max(parama.e - System.currentTimeMillis(), 0L);
    this.d.postDelayed(new Runnable()
    {
      public void run()
      {
        ku.a.b localb;
        aw.a locala;
        if (!ku.b(ku.this).c())
        {
          ku.c(ku.this).b(parama);
          localb = new ku.a.b(parama);
          locala = ku.e(ku.this).a(ku.d(ku.this));
          localb.a(locala);
          if (locala != aw.a.c)
            break label87;
          localb.a(ku.a.b.a.a);
        }
        while (true)
        {
          ku.a(ku.this, localb);
          return;
          label87: if (!parama.f.contains(locala))
          {
            localb.a(ku.a.b.a.b);
            continue;
          }
          localb.a(ku.a.b.a.d);
          HttpURLConnection localHttpURLConnection;
          try
          {
            localHttpURLConnection = (HttpURLConnection)new URL(parama.b).openConnection();
            Iterator localIterator = parama.d.b().iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), TextUtils.join(",", (Iterable)localEntry.getValue()));
            }
          }
          catch (Exception localException)
          {
            localb.a(localException);
          }
          continue;
          localHttpURLConnection.setInstanceFollowRedirects(true);
          localHttpURLConnection.setRequestMethod(parama.c);
          localHttpURLConnection.setConnectTimeout(io.a.a);
          localHttpURLConnection.setReadTimeout(io.a.a);
          localHttpURLConnection.connect();
          int i = localHttpURLConnection.getResponseCode();
          localb.a(ku.a.b.a.c);
          localb.a(Integer.valueOf(i));
          try
          {
            localb.a(w.a(localHttpURLConnection.getInputStream(), 102400));
            try
            {
              label299: localb.b(w.a(localHttpURLConnection.getErrorStream(), 102400));
              label313: localb.a(localHttpURLConnection.getHeaderFields());
            }
            catch (IOException localIOException2)
            {
              break label313;
            }
          }
          catch (IOException localIOException1)
          {
            break label299;
          }
        }
      }
    }
    , Math.max(a.a, l));
  }

  private void a(ku.a.b paramb)
  {
    try
    {
      this.h.b(ku.a.b.a(paramb));
      b();
      this.e.a(paramb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static List<aw.a> b(List<br.a.a> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      br.a.a locala = (br.a.a)localIterator.next();
      localArrayList.add(a.get(locala));
    }
    return localArrayList;
  }

  private void b()
  {
    this.c.a(this.h);
  }

  public void a()
  {
    try
    {
      this.d.post(new Runnable()
      {
        public void run()
        {
          ku.a(ku.this);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(final mw parammw)
  {
    try
    {
      final List localList = parammw.v;
      this.d.post(new Runnable()
      {
        public void run()
        {
          ku.a(ku.this, localList, parammw.s);
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static class a
  {
    private final List<a> a;
    private final LinkedHashMap<String, Object> b;

    public a(List<a> paramList, List<String> paramList1)
    {
      this.a = paramList;
      this.b = new LinkedHashMap();
      if (!bw.a(paramList1))
      {
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.b.put(str, new Object());
        }
      }
    }

    public Set<String> a()
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.b.keySet().iterator();
      int j;
      for (int i = 0; ; i = j)
        if (localIterator.hasNext())
        {
          localHashSet.add((String)localIterator.next());
          j = i + 1;
          if (j <= 1000);
        }
        else
        {
          return localHashSet;
        }
    }

    public boolean a(a parama)
    {
      if ((this.b.get(parama.a) == null) && (!this.a.contains(parama)))
      {
        this.a.add(parama);
        return true;
      }
      return false;
    }

    public List<a> b()
    {
      return this.a;
    }

    public void b(a parama)
    {
      this.b.put(parama.a, new Object());
      this.a.remove(parama);
    }

    public static class a
    {
      public final String a;
      public final String b;
      public final String c;
      public final or<String, String> d;
      public final long e;
      public final List<aw.a> f;

      public a(String paramString1, String paramString2, String paramString3, or<String, String> paramor, long paramLong, List<aw.a> paramList)
      {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
        this.e = paramLong;
        this.f = paramList;
        this.d = paramor;
      }

      public boolean equals(Object paramObject)
      {
        if (this == paramObject)
          return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        a locala = (a)paramObject;
        return this.a.equals(locala.a);
      }

      public int hashCode()
      {
        return this.a.hashCode();
      }
    }

    public static class b
    {
      byte[] a;
      byte[] b;
      private final ku.a.a c;
      private a d;
      private aw.a e;
      private Integer f;
      private Map<String, List<String>> g;
      private Exception h;

      public b(ku.a.a parama)
      {
        this.c = parama;
      }

      public ku.a.a a()
      {
        return this.c;
      }

      public void a(aw.a parama)
      {
        this.e = parama;
      }

      public void a(a parama)
      {
        this.d = parama;
      }

      public void a(Exception paramException)
      {
        this.h = paramException;
      }

      public void a(Integer paramInteger)
      {
        this.f = paramInteger;
      }

      public void a(Map<String, List<String>> paramMap)
      {
        this.g = paramMap;
      }

      public void a(byte[] paramArrayOfByte)
      {
        this.a = paramArrayOfByte;
      }

      public a b()
      {
        return this.d;
      }

      public void b(byte[] paramArrayOfByte)
      {
        this.b = paramArrayOfByte;
      }

      public aw.a c()
      {
        return this.e;
      }

      public Integer d()
      {
        return this.f;
      }

      public byte[] e()
      {
        return this.a;
      }

      public Map<String, List<String>> f()
      {
        return this.g;
      }

      public Exception g()
      {
        return this.h;
      }

      public byte[] h()
      {
        return this.b;
      }

      public static enum a
      {
        static
        {
          a[] arrayOfa = new a[4];
          arrayOfa[0] = a;
          arrayOfa[1] = b;
          arrayOfa[2] = c;
          arrayOfa[3] = d;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ku
 * JD-Core Version:    0.6.2
 */