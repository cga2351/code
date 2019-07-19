package com.viber.voip.banner.d;

public enum c
{
  private String d;

  static
  {
    c[] arrayOfc = new c[3];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    arrayOfc[2] = c;
  }

  private c(String paramString)
  {
    this.d = paramString;
  }

  public static c a(String paramString)
  {
    for (c localc : values())
      if (localc.d.equalsIgnoreCase(paramString))
        return localc;
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.c
 * JD-Core Version:    0.6.2
 */