package com.yandex.metrica.impl.ob;

@Deprecated
public class he
{
  public final String a;
  public final String b;

  public he(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    he localhe;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localhe = (he)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localhe.a));
      }
      else
        while (localhe.a != null)
          return false;
      if (this.b != null)
        return this.b.equals(localhe.b);
    }
    while (localhe.b == null);
    return false;
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
      return j + k;
    }
  }

  public String toString()
  {
    return "AppMetricaDeviceIdentifiers{deviceID='" + this.a + '\'' + ", deviceIDHash='" + this.b + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.he
 * JD-Core Version:    0.6.2
 */