package com.crashlytics.android.c;

import c.a.a.a.a.b.h;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class aq
{
  static final Map<String, String> a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", "1");
  private static final short[] b = { 10, 20, 30, 60, 120, 300 };
  private final Object c = new Object();
  private final u d;
  private final String e;
  private final c f;
  private final b g;
  private Thread h;

  public aq(String paramString, u paramu, c paramc, b paramb)
  {
    if (paramu == null)
      throw new IllegalArgumentException("createReportCall must not be null.");
    this.d = paramu;
    this.e = paramString;
    this.f = paramc;
    this.g = paramb;
  }

  List<ap> a()
  {
    c.g().a("CrashlyticsCore", "Checking for crash reports...");
    File[] arrayOfFile2;
    File[] arrayOfFile3;
    LinkedList localLinkedList;
    synchronized (this.c)
    {
      File[] arrayOfFile1 = this.f.a();
      arrayOfFile2 = this.f.b();
      arrayOfFile3 = this.f.c();
      localLinkedList = new LinkedList();
      if (arrayOfFile1 != null)
      {
        int n = arrayOfFile1.length;
        int i1 = 0;
        if (i1 < n)
        {
          File localFile2 = arrayOfFile1[i1];
          c.g().a("CrashlyticsCore", "Found crash report " + localFile2.getPath());
          localLinkedList.add(new at(localFile2));
          i1++;
        }
      }
    }
    HashMap localHashMap = new HashMap();
    if (arrayOfFile2 != null)
    {
      int k = arrayOfFile2.length;
      for (int m = 0; m < k; m++)
      {
        File localFile1 = arrayOfFile2[m];
        String str2 = k.a(localFile1);
        if (!localHashMap.containsKey(str2))
          localHashMap.put(str2, new LinkedList());
        ((List)localHashMap.get(str2)).add(localFile1);
      }
    }
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      c.g().a("CrashlyticsCore", "Found invalid session: " + str1);
      List localList = (List)localHashMap.get(str1);
      localLinkedList.add(new aa(str1, (File[])localList.toArray(new File[localList.size()])));
    }
    if (arrayOfFile3 != null)
    {
      int i = arrayOfFile3.length;
      for (int j = 0; j < i; j++)
        localLinkedList.add(new ai(arrayOfFile3[j]));
    }
    if (localLinkedList.isEmpty())
      c.g().a("CrashlyticsCore", "No reports found.");
    return localLinkedList;
  }

  public void a(float paramFloat, d paramd)
  {
    try
    {
      if (this.h != null)
        c.g().a("CrashlyticsCore", "Report upload has already been started.");
      while (true)
      {
        return;
        this.h = new Thread(new e(paramFloat, paramd), "Crashlytics Report Uploader");
        this.h.start();
      }
    }
    finally
    {
    }
  }

  boolean a(ap paramap)
  {
    synchronized (this.c)
    {
      try
      {
        t localt = new t(this.e, paramap);
        boolean bool2 = this.d.a(localt);
        l locall = c.g();
        StringBuilder localStringBuilder = new StringBuilder().append("Crashlytics report upload ");
        if (bool2);
        for (String str = "complete: "; ; str = "FAILED: ")
        {
          locall.c("CrashlyticsCore", str + paramap.b());
          bool1 = false;
          if (bool2)
          {
            paramap.f();
            bool1 = true;
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          c.g().e("CrashlyticsCore", "Error occurred sending report " + paramap, localException);
          boolean bool1 = false;
        }
      }
    }
  }

  static final class a
    implements aq.d
  {
    public boolean a()
    {
      return true;
    }
  }

  static abstract interface b
  {
    public abstract boolean a();
  }

  static abstract interface c
  {
    public abstract File[] a();

    public abstract File[] b();

    public abstract File[] c();
  }

  static abstract interface d
  {
    public abstract boolean a();
  }

  private class e extends h
  {
    private final float b;
    private final aq.d c;

    e(float paramd, aq.d arg3)
    {
      this.b = paramd;
      Object localObject;
      this.c = localObject;
    }

    private void b()
    {
      c.g().a("CrashlyticsCore", "Starting report processing in " + this.b + " second(s)...");
      if (this.b > 0.0F);
      while (true)
      {
        List localList1;
        try
        {
          Thread.sleep(()(1000.0F * this.b));
          localList1 = aq.this.a();
          if (aq.a(aq.this).a())
            return;
        }
        catch (InterruptedException localInterruptedException2)
        {
          Thread.currentThread().interrupt();
          return;
        }
        if ((!localList1.isEmpty()) && (!this.c.a()))
        {
          c.g().a("CrashlyticsCore", "User declined to send. Removing " + localList1.size() + " Report(s).");
          Iterator localIterator2 = localList1.iterator();
          while (localIterator2.hasNext())
            ((ap)localIterator2.next()).f();
        }
        else
        {
          Object localObject = localList1;
          int i = 0;
          while ((!((List)localObject).isEmpty()) && (!aq.a(aq.this).a()))
          {
            c.g().a("CrashlyticsCore", "Attempting to send " + ((List)localObject).size() + " report(s)");
            Iterator localIterator1 = ((List)localObject).iterator();
            while (localIterator1.hasNext())
            {
              ap localap = (ap)localIterator1.next();
              aq.this.a(localap);
            }
            List localList2 = aq.this.a();
            if (!localList2.isEmpty())
            {
              short[] arrayOfShort = aq.b();
              int j = i + 1;
              long l1 = arrayOfShort[java.lang.Math.min(i, -1 + aq.b().length)];
              c.g().a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + l1 + " seconds");
              long l2 = l1 * 1000L;
              try
              {
                Thread.sleep(l2);
                i = j;
                localObject = localList2;
              }
              catch (InterruptedException localInterruptedException1)
              {
                Thread.currentThread().interrupt();
                return;
              }
            }
            else
            {
              localObject = localList2;
            }
          }
        }
      }
    }

    public void a()
    {
      try
      {
        b();
        aq.a(aq.this, null);
        return;
      }
      catch (Exception localException)
      {
        while (true)
          c.g().e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", localException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.aq
 * JD-Core Version:    0.6.2
 */