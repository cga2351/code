package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.mobile.ads.AdRequestError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class as<T, L>
{
  private final au<T, L> a;
  private final ay b;
  private final at<T> c;
  private final ax d;
  private ar<T> e;

  public as(au<T, L> paramau, ay paramay, at<T> paramat, ax paramax)
  {
    this.a = paramau;
    this.d = paramax;
    this.c = paramat;
    this.b = paramay;
  }

  private void a(Context paramContext, Throwable paramThrowable, bc parambc)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("exception_in_adapter", paramThrowable.toString());
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("reason", localHashMap1);
    this.b.f(paramContext, parambc, localHashMap2);
  }

  private void b(Context paramContext, L paramL)
  {
    a(paramContext);
    a(paramContext, paramL);
  }

  private void e(Context paramContext, Map<String, Object> paramMap)
  {
    if (this.e != null)
    {
      bc localbc = this.e.b();
      this.b.d(paramContext, localbc, paramMap);
    }
  }

  public final void a(Context paramContext)
  {
    if (this.e != null);
    try
    {
      this.a.a(this.e.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable, this.e.b());
    }
  }

  public final void a(Context paramContext, AdRequestError paramAdRequestError, L paramL)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", "error");
    localHashMap.put("error_code", Integer.valueOf(paramAdRequestError.getCode()));
    localHashMap.put("error_description", paramAdRequestError.getDescription());
    e(paramContext, localHashMap);
    b(paramContext, paramL);
  }

  public final void a(Context paramContext, v<String> paramv)
  {
    if (this.e != null)
    {
      bc localbc = this.e.b();
      this.b.a(paramContext, localbc, paramv);
    }
  }

  public final void a(Context paramContext, L paramL)
  {
    while (true)
    {
      this.e = this.c.a(paramContext);
      if (this.e == null)
        break;
      bc localbc = this.e.b();
      this.b.a(paramContext, localbc);
      try
      {
        this.a.a(paramContext, this.e.a(), paramL, this.e.a(paramContext), this.e.c());
        return;
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable, localbc);
      }
    }
    this.d.a();
  }

  public final void a(Context paramContext, Map<String, Object> paramMap)
  {
    if (this.e != null)
    {
      bc localbc = this.e.b();
      List localList = localbc.d();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          new cj(paramContext).a(str);
        }
      }
      HashMap localHashMap = new HashMap(paramMap);
      localHashMap.put("click_type", "default");
      this.b.a(paramContext, localbc, localHashMap);
    }
  }

  public final void b(Context paramContext)
  {
    a(paramContext, new HashMap());
  }

  public final void b(Context paramContext, AdRequestError paramAdRequestError, L paramL)
  {
    if (this.e != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("status", "error");
      localHashMap.put("error_code", Integer.valueOf(paramAdRequestError.getCode()));
      bc localbc = this.e.b();
      this.b.c(paramContext, localbc, localHashMap);
    }
    b(paramContext, paramL);
  }

  public final void b(Context paramContext, Map<String, Object> paramMap)
  {
    if (this.e != null)
    {
      bc localbc = this.e.b();
      this.b.e(paramContext, localbc, paramMap);
    }
  }

  public final void c(Context paramContext)
  {
    c(paramContext, new HashMap());
  }

  public final void c(Context paramContext, Map<String, Object> paramMap)
  {
    if (this.e != null)
    {
      bc localbc = this.e.b();
      List localList = localbc.c();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          new cj(paramContext).a(str);
        }
      }
      this.b.b(paramContext, localbc, paramMap);
    }
  }

  public final void d(Context paramContext)
  {
    if (this.e != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("status", "success");
      bc localbc = this.e.b();
      this.b.c(paramContext, localbc, localHashMap);
    }
  }

  public final void d(Context paramContext, Map<String, Object> paramMap)
  {
    if (this.e != null)
    {
      List localList = this.e.b().e();
      cj localcj = new cj(paramContext);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          localcj.a((String)localIterator.next());
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    localHashMap.put("status", "success");
    e(paramContext, localHashMap);
  }

  public final void e(Context paramContext)
  {
    d(paramContext, new HashMap());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.as
 * JD-Core Version:    0.6.2
 */