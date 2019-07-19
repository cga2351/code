package com.viber.voip.notif;

import java.util.Locale;

public class b
{
  private final String a;
  private final int b;
  private final int c;
  private String d;

  b(String paramString)
  {
    this(paramString, 0, 0);
  }

  b(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
  }

  private String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.c > 0)
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.c);
      localStringBuilder.append(String.format(localLocale, "%03d", arrayOfObject)).append("_");
    }
    localStringBuilder.append(this.a);
    if (this.b > 0)
      localStringBuilder.append("_").append(this.b);
    return localStringBuilder.toString();
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    if (this.d == null)
      this.d = c();
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    b localb;
    int k;
    int m;
    do
    {
      int i;
      int j;
      do
      {
        boolean bool2;
        do
        {
          do
          {
            return bool1;
            bool1 = false;
          }
          while (paramObject == null);
          bool2 = paramObject instanceof b;
          bool1 = false;
        }
        while (!bool2);
        localb = (b)paramObject;
        i = this.b;
        j = localb.b;
        bool1 = false;
      }
      while (i != j);
      k = this.c;
      m = localb.c;
      bool1 = false;
    }
    while (k != m);
    return this.a.equals(localb.a);
  }

  public int hashCode()
  {
    return 31 * (31 * this.a.hashCode() + this.b) + this.c;
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b
 * JD-Core Version:    0.6.2
 */