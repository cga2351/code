package com.yandex.mobile.ads.impl;

import java.util.HashMap;
import java.util.Map;

public final class ko
{
  private final Map<ak.a, String> a = new HashMap()
  {
  };

  public final String a(ak paramak)
  {
    String str1 = paramak.a();
    ak.a locala = paramak.b();
    String str2 = (String)this.a.get(locala);
    if (str2 != null)
      return String.format(str2, new Object[] { str1 });
    return "Visibility error";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ko
 * JD-Core Version:    0.6.2
 */