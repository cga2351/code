package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.MobileAds;
import java.util.Map;

public final class fd
{
  private final String a;
  private final Map<String, Object> b;

  public fd(b paramb, Map<String, Object> paramMap)
  {
    paramMap.put("sdk_version", MobileAds.getLibraryVersion());
    this.b = paramMap;
    this.a = paramb.a();
  }

  public final Map<String, Object> a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.a;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    fd localfd;
    boolean bool2;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool1 = false;
      }
      while (localClass1 != localClass2);
      localfd = (fd)paramObject;
      bool2 = this.a.equals(localfd.a);
      bool1 = false;
    }
    while (!bool2);
    return this.b.equals(localfd.b);
  }

  public final int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }

  public static abstract interface a
  {
    public abstract Map<String, Object> a();
  }

  public static enum b
  {
    private final String C;

    static
    {
      A = new b("RETURNED_TO_APP", 26, "returned_to_app");
      B = new b("REWARD", 27, "reward");
      b[] arrayOfb = new b[28];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
      arrayOfb[6] = g;
      arrayOfb[7] = h;
      arrayOfb[8] = i;
      arrayOfb[9] = j;
      arrayOfb[10] = k;
      arrayOfb[11] = l;
      arrayOfb[12] = m;
      arrayOfb[13] = n;
      arrayOfb[14] = o;
      arrayOfb[15] = p;
      arrayOfb[16] = q;
      arrayOfb[17] = r;
      arrayOfb[18] = s;
      arrayOfb[19] = t;
      arrayOfb[20] = u;
      arrayOfb[21] = v;
      arrayOfb[22] = w;
      arrayOfb[23] = x;
      arrayOfb[24] = y;
      arrayOfb[25] = z;
      arrayOfb[26] = A;
      arrayOfb[27] = B;
    }

    private b(String paramString)
    {
      this.C = paramString;
    }

    public final String a()
    {
      return this.C;
    }
  }

  public static enum c
  {
    private final String e;

    static
    {
      c[] arrayOfc = new c[4];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
    }

    private c(String paramString)
    {
      this.e = paramString;
    }

    public final String a()
    {
      return this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.fd
 * JD-Core Version:    0.6.2
 */