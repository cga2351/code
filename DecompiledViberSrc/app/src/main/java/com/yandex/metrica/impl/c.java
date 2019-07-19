package com.yandex.metrica.impl;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.a.a;
import com.yandex.metrica.a.b;
import com.yandex.metrica.impl.ob.ki;
import com.yandex.metrica.impl.ob.kj;
import com.yandex.metrica.impl.ob.ko.a;
import com.yandex.metrica.impl.ob.ms;
import com.yandex.metrica.impl.ob.of;
import com.yandex.metrica.impl.ob.og;
import com.yandex.metrica.impl.ob.pk;
import com.yandex.metrica.impl.ob.pl;
import com.yandex.metrica.impl.ob.pv;
import com.yandex.metrica.impl.ob.px;
import com.yandex.metrica.impl.ob.qb;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class c
  implements com.yandex.metrica.c
{
  private static final Collection<Integer> e = new HashSet(Arrays.asList(arrayOfInteger));
  private static final px<ko.a> f = new px()
  {
    public pv a(ko.a paramAnonymousa)
    {
      if (bw.a(paramAnonymousa.b))
        return pv.a(this, "attributes list is empty");
      return pv.a(this);
    }
  };
  private static final px<Revenue> g = new qb();
  protected final Context a;
  protected final bg b;
  protected of c;
  protected final bj d;
  private aa h;

  static
  {
    Integer[] arrayOfInteger = new Integer[2];
    arrayOfInteger[0] = Integer.valueOf(14);
    arrayOfInteger[1] = Integer.valueOf(15);
  }

  c(Context paramContext, bj parambj, bg parambg)
  {
    this.a = paramContext.getApplicationContext();
    this.d = parambj;
    this.b = parambg;
    this.c = og.a(this.b.b().f());
    this.b.a(new pl(new pk(30, 50, 100, "Crash Environment", this.c)));
    this.c = new of(this.b.b().f());
    if (Boolean.TRUE.equals(this.b.b().k()))
      this.c.a();
  }

  private void a(i parami)
  {
    this.d.a(parami, this.b);
  }

  private void d(String paramString1, String paramString2)
  {
    if (this.c.c())
    {
      StringBuilder localStringBuilder = new StringBuilder("Event received: ");
      localStringBuilder.append(d(paramString1));
      localStringBuilder.append(". With value: ");
      localStringBuilder.append(d(paramString2));
      this.c.a(localStringBuilder.toString());
    }
  }

  protected void a()
  {
    this.d.a(this.b);
  }

  public void a(int paramInt, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    int i;
    if ((!e.contains(Integer.valueOf(paramInt))) && (paramInt > 0) && (paramInt <= 99))
    {
      i = 1;
      if (i == 0)
        if (paramMap != null)
          break label64;
    }
    label64: for (Object localObject = null; ; localObject = new HashMap(paramMap))
    {
      a(s.a(paramInt, paramString1, paramString2, (Map)localObject, this.c));
      return;
      i = 0;
      break;
    }
  }

  void a(aa paramaa)
  {
    this.h = paramaa;
  }

  void a(ms paramms)
  {
    this.b.b(paramms);
  }

  void a(String paramString)
  {
    this.d.f();
    this.h.b();
    this.d.a(s.b(paramString, this.c), this.b);
    if (this.b.e())
      this.d.a(s.a(s.a.m, this.c), this.b);
  }

  public void a(String paramString1, String paramString2)
  {
    a(s.b(paramString1, paramString2, this.c));
    StringBuilder localStringBuilder;
    String str;
    if (this.c.c())
    {
      localStringBuilder = new StringBuilder("Statbox event received ");
      localStringBuilder.append(" with name: ");
      localStringBuilder.append(d(paramString1));
      localStringBuilder.append(" with value: ");
      str = d(paramString2);
      if (str.length() <= 100)
        break label106;
      localStringBuilder.append(str.substring(0, 100));
      localStringBuilder.append("...");
    }
    while (true)
    {
      this.c.a(localStringBuilder.toString());
      return;
      label106: localStringBuilder.append(str);
    }
  }

  public void a(Map<String, String> paramMap)
  {
    if (!bw.a(paramMap))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        b((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }

  public void b()
  {
    this.d.b(this.b);
  }

  void b(String paramString)
  {
    if (!this.b.a())
    {
      this.d.g();
      this.h.a();
      this.d.a(s.c(paramString, this.c), this.b);
      this.b.d();
    }
  }

  public void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (this.c.c())
        this.c.b("Invalid Error Environment (key,value) pair: (%s,%s).", new Object[] { paramString1, paramString2 });
      return;
    }
    this.b.a(paramString1, paramString2);
  }

  public void b(Map<String, String> paramMap)
  {
    if (!bw.a(paramMap))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        c((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }

  public void c(String paramString)
  {
    this.d.a(w.b(paramString), this.b);
    if (this.c.c())
      this.c.a("Error received: native");
  }

  public void c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (this.c.c())
        this.c.b("Invalid App Environment (key,value) pair: (%s,%s).", new Object[] { paramString1, paramString2 });
      return;
    }
    this.d.a(paramString1, paramString2, this.b);
  }

  boolean c()
  {
    if (!e());
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        i locali = s.c("", this.c);
        this.d.a(locali, this.b);
      }
      return bool;
    }
  }

  bg d()
  {
    return this.b;
  }

  protected String d(String paramString)
  {
    if (paramString == null)
      paramString = "<null>";
    while (!paramString.isEmpty())
      return paramString;
    return "<empty>";
  }

  public boolean e()
  {
    return this.b.a();
  }

  public void pauseSession()
  {
    if (this.c.c())
      this.c.a("Pause session");
    b(null);
  }

  public void reportError(String paramString, Throwable paramThrowable)
  {
    a(s.c(paramString, bw.a(null, paramThrowable), this.c));
    if (this.c.c())
    {
      of localof = this.c;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = d(paramString);
      localof.a("Error received: %s", arrayOfObject);
    }
  }

  public void reportEvent(String paramString)
  {
    if ((this.c.c()) && (this.c.c()))
    {
      StringBuilder localStringBuilder = new StringBuilder("Event received: ");
      localStringBuilder.append(d(paramString));
      this.c.a(localStringBuilder.toString());
    }
    a(s.a(paramString, this.c));
  }

  public void reportEvent(String paramString1, String paramString2)
  {
    if (this.c.c())
      d(paramString1, paramString2);
    a(s.a(paramString1, paramString2, this.c));
  }

  public void reportEvent(String paramString, Map<String, Object> paramMap)
  {
    Object localObject;
    String str;
    if (bw.a(paramMap))
    {
      localObject = null;
      this.d.a(s.a(paramString, this.c), d(), (Map)localObject);
      if (this.c.c())
      {
        str = null;
        if (paramMap != null)
          break label67;
      }
    }
    while (true)
    {
      d(paramString, str);
      return;
      localObject = new HashMap(paramMap);
      break;
      label67: str = localObject.toString();
    }
  }

  public void reportRevenue(Revenue paramRevenue)
  {
    pv localpv = g.a(paramRevenue);
    if (localpv.a())
    {
      this.d.a(new bl(paramRevenue, this.c), this.b);
      if (this.c.c())
      {
        localStringBuilder = new StringBuilder("Revenue received ");
        localStringBuilder.append("for productID: ");
        localStringBuilder.append(d(paramRevenue.productID));
        localStringBuilder.append(" of quantity: ");
        if (paramRevenue.quantity == null)
          break label152;
        localStringBuilder.append(paramRevenue.quantity);
        localStringBuilder.append(" with price: ");
        localStringBuilder.append(paramRevenue.price);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramRevenue.currency);
        this.c.a(localStringBuilder.toString());
      }
    }
    label152: 
    while (!this.c.c())
      while (true)
      {
        StringBuilder localStringBuilder;
        return;
        localStringBuilder.append("<null>");
      }
    this.c.b("Passed revenue is not valid. Reason: " + localpv.b());
  }

  public void reportUnhandledException(Throwable paramThrowable)
  {
    this.d.a(paramThrowable, this.b);
    if (this.c.c())
    {
      StringBuilder localStringBuilder = new StringBuilder("Unhandled exception received: ");
      localStringBuilder.append(paramThrowable.toString());
      this.c.a(localStringBuilder.toString());
    }
  }

  public void reportUserProfile(a parama)
  {
    ki localki = new ki();
    Iterator localIterator = parama.a().iterator();
    while (localIterator.hasNext())
    {
      kj localkj = ((b)localIterator.next()).a();
      localkj.a(this.c);
      localkj.a(localki);
    }
    ko.a locala = localki.c();
    pv localpv = f.a(locala);
    if (localpv.a())
    {
      this.d.a(locala, this.b);
      if (this.c.c())
      {
        localStringBuilder = new StringBuilder("User profile received");
        this.c.a(localStringBuilder.toString());
      }
    }
    while (!this.c.c())
    {
      StringBuilder localStringBuilder;
      return;
    }
    this.c.b("UserInfo wasn't sent because " + localpv.b());
  }

  public void resumeSession()
  {
    a(null);
    if (this.c.c())
      this.c.a("Resume session");
  }

  public void sendEventsBuffer()
  {
    this.d.a(s.a(s.a.m, this.c), this.b);
  }

  public void setStatisticsSending(boolean paramBoolean)
  {
    this.b.b().g(paramBoolean);
  }

  public void setUserProfileID(String paramString)
  {
    this.d.b(paramString, this.b);
    if (this.c.c())
    {
      StringBuilder localStringBuilder = new StringBuilder("Set user profile ID: ");
      localStringBuilder.append(d(paramString));
      this.c.a(localStringBuilder.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.c
 * JD-Core Version:    0.6.2
 */