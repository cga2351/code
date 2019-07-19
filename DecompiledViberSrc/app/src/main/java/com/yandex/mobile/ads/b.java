package com.yandex.mobile.ads;

public enum b
{
  private final String f;

  static
  {
    b[] arrayOfb = new b[5];
    arrayOfb[0] = a;
    arrayOfb[1] = b;
    arrayOfb[2] = c;
    arrayOfb[3] = d;
    arrayOfb[4] = e;
  }

  private b(String paramString)
  {
    this.f = paramString;
  }

  public static b a(String paramString)
  {
    for (b localb : values())
      if (localb.f.equals(paramString))
        return localb;
    return null;
  }

  public final String a()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.b
 * JD-Core Version:    0.6.2
 */