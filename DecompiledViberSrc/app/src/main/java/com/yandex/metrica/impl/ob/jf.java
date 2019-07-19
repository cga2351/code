package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class jf
{
  public static final Map<String, String> a = Collections.unmodifiableMap(new HashMap()
  {
  });
  private jg b;

  public jf(jg paramjg)
  {
    this.b = paramjg;
  }

  public void a()
  {
    if (f())
    {
      g();
      h();
    }
  }

  void a(String paramString)
  {
    if (paramString != null)
    {
      b(paramString);
      g();
    }
  }

  public void b()
  {
    String str = d();
    if ((!TextUtils.isEmpty(str)) && ("DONE".equals(this.b.g().get(jg.f(str)))));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        a(str);
      return;
    }
  }

  void b(String paramString)
  {
    this.b.d(paramString);
  }

  public void c()
  {
    a(e());
  }

  String d()
  {
    return (String)a.get(this.b.i());
  }

  String e()
  {
    Map localMap = this.b.g();
    Iterator localIterator1 = a.values().iterator();
    while (localIterator1.hasNext())
      localMap.remove(jg.f((String)localIterator1.next()));
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator2 = localMap.keySet().iterator();
    while (localIterator2.hasNext())
    {
      String str = (String)localIterator2.next();
      try
      {
        localLinkedList.add(Integer.valueOf(Integer.parseInt(jg.g(str))));
      }
      catch (Throwable localThrowable)
      {
      }
    }
    if (localLinkedList.size() == 1)
      return ((Integer)localLinkedList.getFirst()).toString();
    return null;
  }

  boolean f()
  {
    return this.b.a(null) != null;
  }

  void g()
  {
    this.b.a();
  }

  void h()
  {
    this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jf
 * JD-Core Version:    0.6.2
 */