package com.yandex.mobile.ads.impl;

import org.json.JSONObject;

public enum em
  implements ek
{
  private final String d;

  static
  {
    em[] arrayOfem = new em[3];
    arrayOfem[0] = a;
    arrayOfem[1] = b;
    arrayOfem[2] = c;
  }

  private em(String paramString)
  {
    this.d = paramString;
  }

  public final String a()
  {
    return String.format("state: %s", new Object[] { JSONObject.quote(this.d) });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.em
 * JD-Core Version:    0.6.2
 */