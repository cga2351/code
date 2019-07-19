package com.yandex.metrica.impl.ob;

import com.yandex.metrica.CounterConfiguration;

public class av
{
  private final String a;
  private final String b;
  private final Integer c;
  private final String d;
  private final ay e;

  public av(String paramString1, String paramString2, Integer paramInteger, String paramString3, ay paramay)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInteger;
    this.d = paramString3;
    this.e = paramay;
  }

  public static av a(t paramt)
  {
    String str1 = paramt.a().h();
    String str2 = paramt.b().f();
    int i = paramt.a().e().intValue();
    String str3 = paramt.a().f();
    Object localObject;
    if (paramt.b().r())
      localObject = new be();
    while (true)
    {
      return new av(str2, str1, Integer.valueOf(i), str3, (ay)localObject);
      if (paramt.b().q())
        localObject = new bc();
      else if ("20799a27-fa80-4b36-b2db-0f8141f24180".equals(str2))
        localObject = new bh();
      else
        localObject = new bg();
    }
  }

  public ay a()
  {
    return this.e;
  }

  public String b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b;
  }

  public Integer d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    av localav;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localav = (av)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localav.a));
      }
      else
        while (localav.a != null)
          return false;
      if (!this.b.equals(localav.b))
        return false;
      if (this.c != null)
      {
        if (this.c.equals(localav.c));
      }
      else
        while (localav.c != null)
          return false;
      if (this.d != null)
        return this.d.equals(localav.d);
    }
    while (localav.d == null);
    return false;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.a != null)
    {
      i = this.a.hashCode();
      j = 31 * (i * 31 + this.b.hashCode());
      if (this.c == null)
        break label88;
    }
    label88: for (int k = this.c.hashCode(); ; k = 0)
    {
      int m = 31 * (k + j);
      String str = this.d;
      int n = 0;
      if (str != null)
        n = this.d.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }

  public String toString()
  {
    return "ClientDescription{mApiKey='" + this.a + '\'' + ", mPackageName='" + this.b + '\'' + ", mProcessID=" + this.c + ", mProcessSessionID='" + this.d + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.av
 * JD-Core Version:    0.6.2
 */