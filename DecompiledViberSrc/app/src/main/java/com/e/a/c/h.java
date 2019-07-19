package com.e.a.c;

import java.text.ParseException;

public enum h
{
  private final String c;

  static
  {
    h[] arrayOfh = new h[2];
    arrayOfh[0] = a;
    arrayOfh[1] = b;
  }

  private h(String arg3)
  {
    Object localObject;
    if (localObject == null)
      throw new IllegalArgumentException("The key use identifier must not be null");
    this.c = localObject;
  }

  public static h a(String paramString)
    throws ParseException
  {
    h localh;
    if (paramString == null)
    {
      localh = null;
      return localh;
    }
    h[] arrayOfh = values();
    int i = arrayOfh.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        throw new ParseException("Invalid JWK use: " + paramString, 0);
      localh = arrayOfh[j];
      if (paramString.equals(localh.c))
        break;
    }
  }

  public String a()
  {
    return this.c;
  }

  public String toString()
  {
    return a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.a.c.h
 * JD-Core Version:    0.6.2
 */