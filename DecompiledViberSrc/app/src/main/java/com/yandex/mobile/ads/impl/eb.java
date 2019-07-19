package com.yandex.mobile.ads.impl;

 enum eb
{
  private final String g;

  static
  {
    eb[] arrayOfeb = new eb[6];
    arrayOfeb[0] = a;
    arrayOfeb[1] = b;
    arrayOfeb[2] = c;
    arrayOfeb[3] = d;
    arrayOfeb[4] = e;
    arrayOfeb[5] = f;
  }

  private eb(String paramString)
  {
    this.g = paramString;
  }

  static eb a(String paramString)
  {
    for (eb localeb : values())
      if (localeb.g.equals(paramString))
        return localeb;
    return f;
  }

  final String a()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.eb
 * JD-Core Version:    0.6.2
 */