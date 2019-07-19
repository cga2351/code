package com.iab.omid.library.appnexus;

import android.content.Context;

public final class Omid
{
  private static a a = new a();

  public static boolean activateWithOmidApiVersion(String paramString, Context paramContext)
  {
    return a.a(paramString, paramContext.getApplicationContext());
  }

  public static String getVersion()
  {
    return a.a();
  }

  public static boolean isActive()
  {
    return a.b();
  }

  public static boolean isCompatibleWithOmidApiVersion(String paramString)
  {
    return a.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.Omid
 * JD-Core Version:    0.6.2
 */