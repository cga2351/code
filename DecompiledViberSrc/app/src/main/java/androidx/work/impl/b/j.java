package androidx.work.impl.b;

import android.os.Build.VERSION;
import androidx.work.c;
import androidx.work.e;
import androidx.work.i;
import androidx.work.o;
import androidx.work.o.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class j
{
  public static final android.arch.a.c.a<List<b>, List<o>> q = new android.arch.a.c.a()
  {
    public List<o> a(List<j.b> paramAnonymousList)
    {
      if (paramAnonymousList == null)
        return null;
      ArrayList localArrayList = new ArrayList(paramAnonymousList.size());
      Iterator localIterator = paramAnonymousList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((j.b)localIterator.next()).a());
      return localArrayList;
    }
  };
  private static final String r = i.a("WorkSpec");
  public String a;
  public o.a b = o.a.a;
  public String c;
  public String d;
  public e e = e.a;
  public e f = e.a;
  public long g;
  public long h;
  public long i;
  public c j = c.a;
  public int k;
  public androidx.work.a l = androidx.work.a.a;
  public long m = 30000L;
  public long n;
  public long o;
  public long p = -1L;

  public j(j paramj)
  {
    this.a = paramj.a;
    this.c = paramj.c;
    this.b = paramj.b;
    this.d = paramj.d;
    this.e = new e(paramj.e);
    this.f = new e(paramj.f);
    this.g = paramj.g;
    this.h = paramj.h;
    this.i = paramj.i;
    this.j = new c(paramj.j);
    this.k = paramj.k;
    this.l = paramj.l;
    this.m = paramj.m;
    this.n = paramj.n;
    this.o = paramj.o;
    this.p = paramj.p;
  }

  public j(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.c = paramString2;
  }

  public void a(long paramLong1, long paramLong2)
  {
    long l1 = 900000L;
    long l2 = 300000L;
    if (paramLong1 < l1)
    {
      i locali3 = i.a();
      String str3 = r;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Long.valueOf(l1);
      locali3.d(str3, String.format("Interval duration lesser than minimum allowed value; Changed to %s", arrayOfObject3), new Throwable[0]);
    }
    while (true)
    {
      if (paramLong2 < l2)
      {
        i locali2 = i.a();
        String str2 = r;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(l2);
        locali2.d(str2, String.format("Flex duration lesser than minimum allowed value; Changed to %s", arrayOfObject2), new Throwable[0]);
      }
      while (true)
      {
        if (l2 > l1)
        {
          i locali1 = i.a();
          String str1 = r;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Long.valueOf(l1);
          locali1.d(str1, String.format("Flex duration greater than interval duration; Changed to %s", arrayOfObject1), new Throwable[0]);
          l2 = l1;
        }
        this.h = l1;
        this.i = l2;
        return;
        l2 = paramLong2;
      }
      l1 = paramLong1;
    }
  }

  public boolean a()
  {
    return this.h != 0L;
  }

  public boolean b()
  {
    return (this.b == o.a.a) && (this.k > 0);
  }

  public long c()
  {
    int i1 = 1;
    if (b())
    {
      if (this.l == androidx.work.a.b)
        if (i1 == 0)
          break label54;
      label54: for (long l3 = this.m * this.k; ; l3 = ()Math.scalb((float)this.m, -1 + this.k))
      {
        return this.n + Math.min(18000000L, l3);
        i1 = 0;
        break;
      }
    }
    if (a())
    {
      if (Build.VERSION.SDK_INT <= 22)
      {
        long l1;
        if (this.i != this.h)
        {
          if (i1 == 0)
            break label166;
          if (this.n != 0L)
            break label152;
          l1 = -1L * this.i;
          label123: if (this.n != 0L)
            break label157;
        }
        label152: label157: for (long l2 = System.currentTimeMillis(); ; l2 = this.n)
        {
          return l1 + (l2 + this.h);
          i1 = 0;
          break;
          l1 = 0L;
          break label123;
        }
        label166: return this.n + this.h;
      }
      return this.n + this.h - this.i;
    }
    return this.n + this.g;
  }

  public boolean d()
  {
    return !c.a.equals(this.j);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    j localj;
    boolean bool14;
    do
    {
      boolean bool13;
      do
      {
        boolean bool12;
        do
        {
          boolean bool15;
          do
          {
            boolean bool11;
            do
            {
              o.a locala1;
              o.a locala2;
              do
              {
                boolean bool10;
                do
                {
                  boolean bool9;
                  do
                  {
                    boolean bool8;
                    do
                    {
                      boolean bool7;
                      do
                      {
                        boolean bool6;
                        do
                        {
                          int i1;
                          int i2;
                          do
                          {
                            boolean bool5;
                            do
                            {
                              boolean bool4;
                              do
                              {
                                boolean bool3;
                                do
                                {
                                  Class localClass1;
                                  Class localClass2;
                                  do
                                  {
                                    do
                                    {
                                      return bool2;
                                      bool2 = false;
                                    }
                                    while (paramObject == null);
                                    localClass1 = getClass();
                                    localClass2 = paramObject.getClass();
                                    bool2 = false;
                                  }
                                  while (localClass1 != localClass2);
                                  localj = (j)paramObject;
                                  bool3 = this.g < localj.g;
                                  bool2 = false;
                                }
                                while (bool3);
                                bool4 = this.h < localj.h;
                                bool2 = false;
                              }
                              while (bool4);
                              bool5 = this.i < localj.i;
                              bool2 = false;
                            }
                            while (bool5);
                            i1 = this.k;
                            i2 = localj.k;
                            bool2 = false;
                          }
                          while (i1 != i2);
                          bool6 = this.m < localj.m;
                          bool2 = false;
                        }
                        while (bool6);
                        bool7 = this.n < localj.n;
                        bool2 = false;
                      }
                      while (bool7);
                      bool8 = this.o < localj.o;
                      bool2 = false;
                    }
                    while (bool8);
                    bool9 = this.p < localj.p;
                    bool2 = false;
                  }
                  while (bool9);
                  bool10 = this.a.equals(localj.a);
                  bool2 = false;
                }
                while (!bool10);
                locala1 = this.b;
                locala2 = localj.b;
                bool2 = false;
              }
              while (locala1 != locala2);
              bool11 = this.c.equals(localj.c);
              bool2 = false;
            }
            while (!bool11);
            if (this.d == null)
              break;
            bool15 = this.d.equals(localj.d);
            bool2 = false;
          }
          while (!bool15);
          bool12 = this.e.equals(localj.e);
          bool2 = false;
        }
        while (!bool12);
        bool13 = this.f.equals(localj.f);
        bool2 = false;
      }
      while (!bool13);
      bool14 = this.j.equals(localj.j);
      bool2 = false;
    }
    while (!bool14);
    if (this.l == localj.l);
    while (true)
    {
      return bool1;
      if (localj.d == null)
        break;
      return false;
      bool1 = false;
    }
  }

  public int hashCode()
  {
    int i1 = 31 * (31 * (31 * this.a.hashCode() + this.b.hashCode()) + this.c.hashCode());
    if (this.d != null);
    for (int i2 = this.d.hashCode(); ; i2 = 0)
      return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (i2 + i1) + this.e.hashCode()) + this.f.hashCode()) + (int)(this.g ^ this.g >>> 32)) + (int)(this.h ^ this.h >>> 32)) + (int)(this.i ^ this.i >>> 32)) + this.j.hashCode()) + this.k) + this.l.hashCode()) + (int)(this.m ^ this.m >>> 32)) + (int)(this.n ^ this.n >>> 32)) + (int)(this.o ^ this.o >>> 32)) + (int)(this.p ^ this.p >>> 32);
  }

  public String toString()
  {
    return "{WorkSpec: " + this.a + "}";
  }

  public static class a
  {
    public String a;
    public o.a b;

    public boolean equals(Object paramObject)
    {
      boolean bool;
      if (this == paramObject)
        bool = true;
      a locala;
      o.a locala1;
      o.a locala2;
      do
      {
        Class localClass1;
        Class localClass2;
        do
        {
          do
          {
            return bool;
            bool = false;
          }
          while (paramObject == null);
          localClass1 = getClass();
          localClass2 = paramObject.getClass();
          bool = false;
        }
        while (localClass1 != localClass2);
        locala = (a)paramObject;
        locala1 = this.b;
        locala2 = locala.b;
        bool = false;
      }
      while (locala1 != locala2);
      return this.a.equals(locala.a);
    }

    public int hashCode()
    {
      return 31 * this.a.hashCode() + this.b.hashCode();
    }
  }

  public static class b
  {
    public String a;
    public o.a b;
    public e c;
    public List<String> d;

    public o a()
    {
      return new o(UUID.fromString(this.a), this.b, this.c, this.d);
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = true;
      boolean bool2;
      if (this == paramObject)
        bool2 = bool1;
      b localb;
      boolean bool3;
      do
      {
        o.a locala1;
        o.a locala2;
        do
        {
          boolean bool4;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool2;
                bool2 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool2 = false;
            }
            while (localClass1 != localClass2);
            localb = (b)paramObject;
            if (this.a == null)
              break;
            bool4 = this.a.equals(localb.a);
            bool2 = false;
          }
          while (!bool4);
          locala1 = this.b;
          locala2 = localb.b;
          bool2 = false;
        }
        while (locala1 != locala2);
        if (this.c == null)
          break label156;
        bool3 = this.c.equals(localb.c);
        bool2 = false;
      }
      while (!bool3);
      label122: if (this.d != null)
        bool1 = this.d.equals(localb.d);
      while (true)
      {
        return bool1;
        if (localb.a == null)
          break;
        return false;
        label156: if (localb.c == null)
          break label122;
        return false;
        if (localb.d != null)
          bool1 = false;
      }
    }

    public int hashCode()
    {
      int i;
      int k;
      label35: int m;
      if (this.a != null)
      {
        i = this.a.hashCode();
        int j = i * 31;
        if (this.b == null)
          break label105;
        k = this.b.hashCode();
        m = 31 * (k + j);
        if (this.c == null)
          break label110;
      }
      label105: label110: for (int n = this.c.hashCode(); ; n = 0)
      {
        int i1 = 31 * (n + m);
        List localList = this.d;
        int i2 = 0;
        if (localList != null)
          i2 = this.d.hashCode();
        return i1 + i2;
        i = 0;
        break;
        k = 0;
        break label35;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.j
 * JD-Core Version:    0.6.2
 */