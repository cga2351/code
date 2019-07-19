package com.yandex.metrica.impl.ob;

public class ps<T>
  implements px<T>
{
  private final String a;

  public ps(String paramString)
  {
    this.a = paramString;
  }

  public pv a(T paramT)
  {
    if (paramT == null)
      return pv.a(this, this.a + " is null.");
    return pv.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ps
 * JD-Core Version:    0.6.2
 */