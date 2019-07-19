package com.yandex.metrica.impl.ob;

public class my
{
  public final long a;

  public my(long paramLong)
  {
    this.a = paramLong;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    my localmy;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localmy = (my)paramObject;
    }
    while (this.a == localmy.a);
    return false;
  }

  public int hashCode()
  {
    return (int)(this.a ^ this.a >>> 32);
  }

  public String toString()
  {
    return "StatSending{disabledReportingInterval=" + this.a + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.my
 * JD-Core Version:    0.6.2
 */