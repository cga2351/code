package com.yandex.metrica.impl.ob;

import java.util.Map;

public class pz
  implements px<String>
{
  private final Map<String, ?> a;

  public pz(Map<String, ?> paramMap)
  {
    this.a = paramMap;
  }

  public pv a(String paramString)
  {
    if (this.a.containsKey(paramString))
      return pv.a(this, String.format("Failed to activate AppMetrica with provided apiKey ApiKey %s has already been used by another reporter.", new Object[] { paramString }));
    return pv.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pz
 * JD-Core Version:    0.6.2
 */