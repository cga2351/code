package com.adsnative.c;

public class k
{
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      paramString = "";
    char c;
    do
    {
      return paramString;
      c = paramString.charAt(0);
    }
    while (Character.isUpperCase(c));
    return Character.toUpperCase(c) + paramString.substring(1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.k
 * JD-Core Version:    0.6.2
 */