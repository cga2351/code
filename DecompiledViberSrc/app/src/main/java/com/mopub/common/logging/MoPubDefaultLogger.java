package com.mopub.common.logging;

import android.util.Log;

public class MoPubDefaultLogger
  implements MoPubLogger
{
  static int a = 3072;

  static String[] a(String paramString)
  {
    String[] arrayOfString;
    if (paramString == null)
      arrayOfString = new String[1];
    while (true)
    {
      return arrayOfString;
      int i = 1 + paramString.length() / a;
      arrayOfString = new String[i];
      for (int j = 0; j < i; j++)
        arrayOfString[j] = paramString.substring(j * a, Math.min((j + 1) * a, paramString.length()));
    }
  }

  public void log(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String[] arrayOfString = a(paramString4);
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      if (paramString3 == null)
        Log.i("MoPub", String.format("[%s][%s] %s", new Object[] { paramString1, paramString2, str }));
      while (true)
      {
        j++;
        break;
        Log.i("MoPub", String.format("[%s][%s][%s] %s", new Object[] { paramString1, paramString2, paramString3, str }));
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.logging.MoPubDefaultLogger
 * JD-Core Version:    0.6.2
 */