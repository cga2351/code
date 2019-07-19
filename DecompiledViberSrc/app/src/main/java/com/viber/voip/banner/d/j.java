package com.viber.voip.banner.d;

public enum j
{
  private final String j;

  static
  {
    j[] arrayOfj = new j[9];
    arrayOfj[0] = a;
    arrayOfj[1] = b;
    arrayOfj[2] = c;
    arrayOfj[3] = d;
    arrayOfj[4] = e;
    arrayOfj[5] = f;
    arrayOfj[6] = g;
    arrayOfj[7] = h;
    arrayOfj[8] = i;
  }

  private j(String paramString)
  {
    this.j = paramString;
  }

  public static j a(String paramString)
  {
    for (j localj : values())
      if (localj.a().equalsIgnoreCase(paramString))
        return localj;
    return a;
  }

  public String a()
  {
    return this.j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.j
 * JD-Core Version:    0.6.2
 */