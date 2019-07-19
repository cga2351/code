package com.viber.voip.util.links;

public class d
  implements Comparable<d>
{
  public final String a;
  public final String b;
  public final int c;
  public final int d;

  public d(String paramString, int paramInt1, int paramInt2)
  {
    this(paramString, null, paramInt1, paramInt2);
  }

  public d(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, -1, -1);
  }

  public d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
  }

  public int a(d paramd)
  {
    if (this.c < paramd.c);
    do
    {
      return -1;
      if (this.c > paramd.c)
        return 1;
      if (this.d < paramd.d)
        return 1;
    }
    while (this.d > paramd.d);
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject)
      bool2 = bool1;
    d locald;
    boolean bool3;
    do
    {
      int k;
      int m;
      do
      {
        int i;
        int j;
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
          locald = (d)paramObject;
          i = this.c;
          j = locald.c;
          bool2 = false;
        }
        while (i != j);
        k = this.d;
        m = locald.d;
        bool2 = false;
      }
      while (k != m);
      if (this.a == null)
        break;
      bool3 = this.a.equals(locald.a);
      bool2 = false;
    }
    while (!bool3);
    if (this.b != null)
      bool1 = this.b.equals(locald.b);
    while (true)
    {
      return bool1;
      if (locald.a == null)
        break;
      return false;
      if (locald.b != null)
        bool1 = false;
    }
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.b;
      int k = 0;
      if (str != null)
        k = this.b.hashCode();
      return 31 * (31 * (j + k) + this.c) + this.d;
    }
  }

  public String toString()
  {
    return "LinkSpecExpander{  url='" + this.a + '\'' + ", originalUrl='" + this.b + '\'' + ", start=" + this.c + ", end=" + this.d + "  }";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.d
 * JD-Core Version:    0.6.2
 */