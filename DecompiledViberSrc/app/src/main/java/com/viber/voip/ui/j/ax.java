package com.viber.voip.ui.j;

public enum ax
{
  private final String c;
  private final String d;
  private final String e;
  private final String f;

  static
  {
    ax[] arrayOfax = new ax[2];
    arrayOfax[0] = a;
    arrayOfax[1] = b;
  }

  private ax(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }

  public static ax a(String paramString)
  {
    for (ax localax : values())
      if (localax.c.equals(paramString))
        return localax;
    return a;
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.j.ax
 * JD-Core Version:    0.6.2
 */