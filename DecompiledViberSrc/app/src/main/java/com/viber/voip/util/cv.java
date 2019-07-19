package com.viber.voip.util;

import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.viber.common.b.a;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.r;
import com.viber.voip.model.i;
import com.viber.voip.settings.d.ae;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.bb;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cv
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile cv b;
  private final Set<a> c = new HashSet();
  private d.al d;

  private cv()
  {
    a[] arrayOfa = new a[6];
    arrayOfa[0] = d.bb.a;
    arrayOfa[1] = d.bb.b;
    arrayOfa[2] = d.bb.c;
    arrayOfa[3] = d.bb.d;
    arrayOfa[4] = d.ae.b;
    arrayOfa[5] = d.bb.f;
    this.d = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(a paramAnonymousa)
      {
        int i = 1;
        ArraySet localArraySet = new ArraySet();
        synchronized (cv.a(cv.this))
        {
          localArraySet.addAll(cv.a(cv.this));
          if ((d.bb.a == paramAnonymousa) || (d.bb.c == paramAnonymousa) || (d.bb.d == paramAnonymousa))
          {
            Iterator localIterator1 = localArraySet.iterator();
            if (!localIterator1.hasNext())
              return;
            cv.a locala1 = (cv.a)localIterator1.next();
            locala1.onBadgeValueChanged(0, cv.this.d());
            locala1.onBadgeValueChanged(-1, cv.this.e());
          }
        }
        if (d.bb.b == paramAnonymousa)
        {
          Iterator localIterator4 = localArraySet.iterator();
          while (localIterator4.hasNext())
            ((cv.a)localIterator4.next()).onBadgeValueChanged(-1, cv.this.e());
        }
        if (d.ae.b == paramAnonymousa)
        {
          Iterator localIterator3 = localArraySet.iterator();
          while (localIterator3.hasNext())
            ((cv.a)localIterator3.next()).onBadgeValueChanged(2, i);
        }
        if (d.bb.f == paramAnonymousa)
        {
          if (cv.this.b());
          while (true)
          {
            Iterator localIterator2 = localArraySet.iterator();
            while (localIterator2.hasNext())
            {
              cv.a locala2 = (cv.a)localIterator2.next();
              locala2.onBadgeValueChanged(3, i);
              locala2.onBadgeValueChanged(2, i);
            }
            i = 0;
          }
        }
      }
    };
    com.viber.voip.settings.d.a(this.d);
  }

  @Deprecated
  public static cv a()
  {
    if (b == null)
      b = new cv();
    return b;
  }

  public void a(int paramInt)
  {
    d.bb.a.a(paramInt);
  }

  public void a(int paramInt, long paramLong)
  {
    if (d.bb.b.d() != paramInt)
      d.bb.b.a(paramInt);
    if ((0L != paramLong) && (paramLong <= d.bb.e.d()))
      return;
    d.bb.e.a(paramLong);
  }

  public void a(long paramLong)
  {
    av.a(av.e.g).post(new cw(paramLong));
  }

  public void a(a parama)
  {
    synchronized (this.c)
    {
      this.c.add(parama);
      return;
    }
  }

  public void a(Set<i> paramSet)
  {
    b.a(paramSet);
  }

  public void a(boolean paramBoolean)
  {
    d.bb.f.a(paramBoolean);
  }

  public void b(int paramInt)
  {
    d.bb.c.a(paramInt);
  }

  public void b(a parama)
  {
    synchronized (this.c)
    {
      this.c.remove(parama);
      return;
    }
  }

  public boolean b()
  {
    return d.bb.f.d();
  }

  public void c(int paramInt)
  {
    d.bb.d.a(paramInt);
  }

  public boolean c()
  {
    return d.bb.f.a();
  }

  public int d()
  {
    return d.bb.a.d() + d.bb.c.d() + d.bb.d.d();
  }

  public int e()
  {
    return d() + d.bb.b.d();
  }

  public void f()
  {
    d.bb.a.e();
  }

  public void g()
  {
    d.bb.a.e();
    d.bb.b.e();
    d.bb.c.e();
    d.bb.d.e();
    d.bb.f.b();
  }

  void h()
  {
    ab localab = ab.b();
    if (d.bb.a.d() > 0)
    {
      LongSparseSet localLongSparseSet1 = new LongSparseSet();
      Iterator localIterator1 = localab.v().iterator();
      while (localIterator1.hasNext())
        localLongSparseSet1.add(((MessageEntity)localIterator1.next()).getConversationId());
      Iterator localIterator2 = localab.a(localLongSparseSet1).iterator();
      while (localIterator2.hasNext())
        ((com.viber.voip.model.entity.h)localIterator2.next());
    }
    if (d.bb.c.d() > 0)
    {
      List localList = localab.c();
      LongSparseSet localLongSparseSet2 = new LongSparseSet();
      Iterator localIterator4 = localList.iterator();
      while (localIterator4.hasNext())
      {
        r localr = (r)localIterator4.next();
        if (localr.K() < Math.max(localr.v(), localr.n()))
          localLongSparseSet2.add(localr.a());
      }
      Iterator localIterator5 = localab.a(localLongSparseSet2.toArray()).iterator();
      while (localIterator5.hasNext())
        ((com.viber.voip.model.entity.h)localIterator5.next());
    }
    if (d.bb.d.d() > 0)
    {
      Iterator localIterator3 = localab.w().iterator();
      while (localIterator3.hasNext())
        ((com.viber.voip.model.entity.h)localIterator3.next());
    }
  }

  public static abstract interface a
  {
    public abstract void onBadgeValueChanged(int paramInt1, int paramInt2);
  }

  private static class b
  {
    private static String a()
    {
      return d.bb.g.d();
    }

    private static JSONObject a(long paramLong, int paramInt)
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("contactId", paramLong);
      localJSONObject.put("watchedTime", paramInt);
      return localJSONObject;
    }

    static void a(long paramLong, a parama)
    {
      try
      {
        String str1 = a();
        if (!TextUtils.isEmpty(str1))
        {
          JSONArray localJSONArray1 = new JSONArray(str1);
          JSONArray localJSONArray2 = new JSONArray();
          int i = localJSONArray1.length();
          HashSet localHashSet = new HashSet();
          for (int j = 0; ; j++)
            if (j < i)
            {
              JSONObject localJSONObject = (JSONObject)localJSONArray1.get(j);
              long l = localJSONObject.getLong("contactId");
              int k = localJSONObject.getInt("watchedTime");
              if (l == paramLong)
                localHashSet.add(Long.valueOf(l));
              else
                localJSONArray2.put(a(l, k));
            }
            else
            {
              if (parama != null)
                parama.a(localHashSet);
              if (localJSONArray2.length() > 0);
              for (String str2 = localJSONArray2.toString(); ; str2 = "")
              {
                a(str2);
                return;
              }
            }
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }

    private static void a(String paramString)
    {
      d.bb.g.a(paramString);
    }

    static void a(Set<i> paramSet)
    {
      if (paramSet == null)
        return;
      av.a(av.e.g).post(new cy(paramSet));
    }

    public static abstract interface a
    {
      public abstract void a(Set<Long> paramSet);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cv
 * JD-Core Version:    0.6.2
 */