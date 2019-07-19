package com.yandex.metrica.impl.ob;

public class jy
  implements px<String>
{
  public pv a(String paramString)
  {
    if (paramString == null)
      return pv.a(this, "key is null");
    if (paramString.startsWith("appmetrica"))
      return pv.a(this, "key starts with appmetrica");
    if (paramString.length() > 200)
      return pv.a(this, "key length more then 200 characters");
    return pv.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.jy
 * JD-Core Version:    0.6.2
 */