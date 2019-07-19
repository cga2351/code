package com.yandex.metrica.impl.ob;

public class y
{
  private final String a;
  private final String b;

  public y(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    y localy;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localy = (y)paramObject;
      if (this.a != null)
      {
        if (this.a.equals(localy.a));
      }
      else
        while (localy.a != null)
          return false;
      if (this.b != null)
        return this.b.equals(localy.b);
    }
    while (localy.b == null);
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
    return this.a + "_" + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.y
 * JD-Core Version:    0.6.2
 */