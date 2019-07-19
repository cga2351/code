package com.yandex.mobile.ads.impl;

public final class cn
{
  private final String a;
  private final long b;

  public cn(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }

  public final String a()
  {
    return this.a;
  }

  public final long b()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    cn localcn;
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
      localcn = (cn)paramObject;
      bool2 = this.b < localcn.b;
      bool1 = false;
    }
    while (bool2);
    return this.a.equals(localcn.a);
  }

  public final int hashCode()
  {
    return 31 * this.a.hashCode() + (int)(this.b ^ this.b >>> 32);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.cn
 * JD-Core Version:    0.6.2
 */