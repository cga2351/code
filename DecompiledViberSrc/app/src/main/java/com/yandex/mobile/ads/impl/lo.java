package com.yandex.mobile.ads.impl;

public abstract class lo
{
  private final String a;

  protected lo(String paramString)
  {
    this.a = paramString;
  }

  public final String a()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    lo locallo = (lo)paramObject;
    return this.a.equals(locallo.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.lo
 * JD-Core Version:    0.6.2
 */