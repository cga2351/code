package com.viber.voip.stickers;

public enum w
{
  private final String d;
  private final String e;

  static
  {
    w[] arrayOfw = new w[3];
    arrayOfw[0] = a;
    arrayOfw[1] = b;
    arrayOfw[2] = c;
  }

  private w(String paramString)
  {
    this.d = paramString;
    this.e = paramString;
  }

  private w(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.e = paramString2;
  }

  public String a()
  {
    return this.d;
  }

  public String a(boolean paramBoolean)
  {
    if (paramBoolean)
      return this.d;
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.w
 * JD-Core Version:    0.6.2
 */