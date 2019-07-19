package com.facebook.react.modules.network;

public class HeaderUtil
{
  public static String stripHeaderName(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = paramString.length();
    int k = 0;
    if (k < j)
    {
      char c = paramString.charAt(k);
      if ((c > ' ') && (c < ''))
        localStringBuilder.append(c);
      while (true)
      {
        k++;
        break;
        i = 1;
      }
    }
    if (i != 0)
      paramString = localStringBuilder.toString();
    return paramString;
  }

  public static String stripHeaderValue(String paramString)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = paramString.length();
    int k = 0;
    if (k < j)
    {
      char c = paramString.charAt(k);
      if (((c > '\037') && (c < '')) || (c == '\t'))
        localStringBuilder.append(c);
      while (true)
      {
        k++;
        break;
        i = 1;
      }
    }
    if (i != 0)
      paramString = localStringBuilder.toString();
    return paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.HeaderUtil
 * JD-Core Version:    0.6.2
 */