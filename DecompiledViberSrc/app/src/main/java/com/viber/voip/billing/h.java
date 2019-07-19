package com.viber.voip.billing;

import java.util.Locale;

public class h
{
  public static String a(long paramLong, int paramInt)
  {
    long l1 = paramLong / 1000000L;
    long l2 = paramLong % 1000000L;
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(l2);
    for (String str = String.format(localLocale, "%06d", arrayOfObject); (str.length() > paramInt) && (str.endsWith("0")); str = str.substring(0, -1 + str.length()));
    return l1 + "." + str;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.h
 * JD-Core Version:    0.6.2
 */