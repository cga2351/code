package com.my.target;

import android.util.Log;

public final class dp
{
  public static boolean a = false;

  public static void a(String paramString)
  {
    if (a)
      if (paramString == null)
        break label18;
    while (true)
    {
      Log.d("[myTarget]", paramString);
      return;
      label18: paramString = "null";
    }
  }

  public static void b(String paramString)
  {
    if (a)
      if (paramString == null)
        break label18;
    while (true)
    {
      Log.e("[myTarget]", paramString);
      return;
      label18: paramString = "null";
    }
  }

  public static void c(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      Log.i("[myTarget]", paramString);
      return;
      paramString = "null";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dp
 * JD-Core Version:    0.6.2
 */