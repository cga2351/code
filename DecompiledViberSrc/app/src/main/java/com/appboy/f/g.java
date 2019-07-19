package com.appboy.f;

import android.content.Context;

public class g
{
  private static final String a = c.a(g.class);
  private static String b;

  public static String a(Context paramContext)
  {
    if (b != null)
      return b;
    b = paramContext.getPackageName();
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.f.g
 * JD-Core Version:    0.6.2
 */