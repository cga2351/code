package com.my.target;

public class p
{
  private final String a;
  private final String b;

  protected p(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public static p a(String paramString1, String paramString2)
  {
    return new p(paramString1, paramString2);
  }

  public String c()
  {
    return this.a;
  }

  public String d()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.p
 * JD-Core Version:    0.6.2
 */