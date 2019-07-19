package com.iab.a.a.a.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
{
  private long a;
  private long b;
  private int c;
  private int d;
  private int e;
  private String f;
  private int g;
  private int h;
  private int i;
  private Set<Integer> j = new HashSet(24);
  private Set<Integer> k;
  private List<com.iab.a.a.b.a> l;
  private boolean m;

  public static <T> T a(T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  public b a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public b a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }

  public b a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public b a(List<com.iab.a.a.b.a> paramList)
  {
    this.l = paramList;
    return this;
  }

  public b a(Set<com.iab.a.b> paramSet)
  {
    a(paramSet, "Argument allowedPurposes is null");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localHashSet.add(Integer.valueOf(((com.iab.a.b)localIterator.next()).a()));
    this.j = localHashSet;
    return this;
  }

  public b a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }

  public com.iab.a.a.a a()
  {
    if (this.a == 0L)
      throw new com.iab.a.b.b("consentRecordCreated must be set");
    if (this.b == 0L)
      throw new com.iab.a.b.b("consentRecordLastUpdated must be set");
    a(this.f, "consentLanguage must be set");
    if (this.g <= 0)
      throw new com.iab.a.b.b("Invalid value for vendorListVersion:" + this.g);
    if (this.h <= 0)
      throw new com.iab.a.b.b("Invalid value for maxVendorId:" + this.h);
    if (this.i == 1)
    {
      a(this.l, "Range entries must be set");
      Iterator localIterator3 = this.l.iterator();
      do
        if (!localIterator3.hasNext())
          break;
      while (((com.iab.a.a.b.a)localIterator3.next()).a(this.h));
    }
    for (int i9 = 1; ; i9 = 0)
    {
      if (i9 != 0)
        throw new com.iab.a.b.b("Invalid range entries found");
      int n;
      int i1;
      label272: int i3;
      label285: com.iab.a.a locala;
      int i4;
      if (this.i == 1)
      {
        Iterator localIterator2 = this.l.iterator();
        int i8 = 0;
        while (localIterator2.hasNext())
          i8 += ((com.iab.a.a.b.a)localIterator2.next()).a();
        n = i8 + 186;
        if (n % 8 != 0)
          break label459;
        i1 = 1;
        int i2 = n / 8;
        if (i1 == 0)
          break label464;
        i3 = 0;
        locala = new com.iab.a.a(new byte[i3 + i2]);
        locala.a(0, 6, 1);
        locala.b(6, 36, this.a);
        locala.b(42, 36, this.b);
        locala.a(78, 12, this.c);
        locala.a(90, 12, this.d);
        locala.a(102, 6, this.e);
        locala.a(108, 12, this.f);
        locala.a(120, 12, this.g);
        i4 = 0;
        label404: if (i4 >= 24)
          break label484;
        if (!this.j.contains(Integer.valueOf(i4 + 1)))
          break label470;
        locala.b(i4 + 132);
      }
      while (true)
      {
        i4++;
        break label404;
        n = 173 + this.h;
        break;
        label459: i1 = 0;
        break label272;
        label464: i3 = 1;
        break label285;
        label470: locala.c(i4 + 132);
      }
      label484: locala.a(156, 16, this.h);
      locala.a(172, 1, this.i);
      int i5 = this.i;
      int i6 = 0;
      if (i5 == 1)
      {
        if (this.m)
          locala.b(173);
        while (true)
        {
          locala.a(174, 12, this.l.size());
          Iterator localIterator1 = this.l.iterator();
          for (int i7 = 186; localIterator1.hasNext(); i7 = ((com.iab.a.a.b.a)localIterator1.next()).a(locala, i7));
          locala.c(173);
        }
      }
      if (i6 < this.h)
      {
        if (this.k.contains(Integer.valueOf(i6 + 1)))
          locala.b(i6 + 173);
        while (true)
        {
          i6++;
          break;
          locala.c(i6 + 173);
        }
      }
      return new a(locala);
    }
  }

  public b b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public b b(long paramLong)
  {
    this.b = paramLong;
    return this;
  }

  public b b(Set<Integer> paramSet)
  {
    this.k = paramSet;
    return this;
  }

  public b c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public b d(int paramInt)
  {
    this.g = paramInt;
    return this;
  }

  public b e(int paramInt)
  {
    this.h = paramInt;
    return this;
  }

  public b f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1))
      throw new IllegalArgumentException("Illegal value for argument vendorEncodingType:" + paramInt);
    this.i = paramInt;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.a.a.a.a.b
 * JD-Core Version:    0.6.2
 */