package com.yandex.mobile.ads.impl;

public final class lr extends lo
{
  private final String a;
  private final String b;
  private final String c;

  public lr(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1);
    this.a = paramString2;
    this.b = paramString3;
    this.c = paramString4;
  }

  public final String b()
  {
    return this.a;
  }

  public final String c()
  {
    return this.b;
  }

  public final String d()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    lr locallr;
    boolean bool4;
    do
    {
      boolean bool3;
      do
      {
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
          bool2 = super.equals(paramObject);
          bool1 = false;
        }
        while (!bool2);
        locallr = (lr)paramObject;
        bool3 = this.a.equals(locallr.a);
        bool1 = false;
      }
      while (!bool3);
      bool4 = this.b.equals(locallr.b);
      bool1 = false;
    }
    while (!bool4);
    return this.c.equals(locallr.c);
  }

  public final int hashCode()
  {
    return 31 * (31 * (31 * super.hashCode() + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lr
 * JD-Core Version:    0.6.2
 */