package com.viber.voip.viberout.a;

import com.viber.dexshared.Logger;
import com.viber.jni.CountryNameInfo;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.calls.d;
import com.viber.voip.contacts.c.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final Comparator<a> i = c.a;
  private List<String> b;
  private List<String> c;
  private List<String> d;
  private final d e;
  private final m f;
  private final PhoneController g;
  private final CountDownLatch h = new CountDownLatch(1);

  @Inject
  public a(d paramd, m paramm, PhoneController paramPhoneController)
  {
    this.e = paramd;
    this.f = paramm;
    this.g = paramPhoneController;
  }

  private List<String> a(Collection<a> paramCollection)
  {
    if (paramCollection.isEmpty())
      return Collections.emptyList();
    ArrayList localArrayList1 = new ArrayList(paramCollection);
    Collections.sort(localArrayList1, i);
    int j = Math.min(10, localArrayList1.size());
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    Iterator localIterator = localArrayList1.iterator();
    while (localIterator.hasNext())
      localArrayList2.add(((a)localIterator.next()).a);
    return localArrayList2.subList(0, j);
  }

  private void a(Map<String, a> paramMap, CountryNameInfo paramCountryNameInfo)
  {
    a locala = (a)paramMap.get(paramCountryNameInfo.countryShortName);
    if (locala == null)
    {
      locala = new a(paramCountryNameInfo.countryShortName);
      paramMap.put(paramCountryNameInfo.countryShortName, locala);
    }
    locala.b = (1 + locala.b);
  }

  private void d()
  {
    this.e.b(new b(this));
    try
    {
      synchronized (this.h)
      {
        this.h.await(3000L, TimeUnit.MILLISECONDS);
        label38: return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label38;
    }
  }

  private void e()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.f.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      CountryNameInfo localCountryNameInfo = this.g.getCountryName(str);
      if (localCountryNameInfo != null)
        a(localHashMap, localCountryNameInfo);
    }
    this.b = a(localHashMap.values());
  }

  public List<String> a()
  {
    if (this.b == null)
      e();
    if (this.b != null)
      return this.b;
    return Collections.emptyList();
  }

  public List<String> b()
  {
    if (this.c == null)
      d();
    if (this.c != null)
      return this.c;
    return Collections.emptyList();
  }

  public List<String> c()
  {
    if (this.d == null)
      d();
    if (this.d != null)
      return this.d;
    return Collections.emptyList();
  }

  private static class a
  {
    public final String a;
    public int b;

    public a(String paramString)
    {
      this.a = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.a
 * JD-Core Version:    0.6.2
 */