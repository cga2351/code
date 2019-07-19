package com.yandex.mobile.ads.impl;

public class bd
{
  private long a;
  private String b;
  private int c;

  public final long a()
  {
    return this.a;
  }

  public final void a(int paramInt)
  {
    this.c = paramInt;
  }

  public final void a(long paramLong)
  {
    this.a = paramLong;
  }

  public final void a(String paramString)
  {
    this.b = paramString;
  }

  public final String b()
  {
    return this.b;
  }

  public final int c()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    bd localbd;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localbd = (bd)paramObject;
      if (this.a != localbd.a)
        return false;
      if (this.c != localbd.c)
        return false;
      if (this.b != null)
        return this.b.equals(localbd.b);
    }
    while (localbd.b == null);
    return false;
  }

  public int hashCode()
  {
    int i = 31 * (int)(this.a ^ this.a >>> 32);
    if (this.b != null);
    for (int j = this.b.hashCode(); ; j = 0)
      return 31 * (j + i) + this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bd
 * JD-Core Version:    0.6.2
 */