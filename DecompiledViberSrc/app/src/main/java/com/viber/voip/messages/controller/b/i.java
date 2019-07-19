package com.viber.voip.messages.controller.b;

import android.text.TextUtils;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;

public class i
{
  private static final e a = ViberEnv.getLogger();

  static short a(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    do
    {
      return 0;
      if (a.a(paramString))
        return a.b(paramString);
      if (a.c(paramString))
        return 1;
    }
    while (!a.e(paramString));
    return 2;
  }

  static class a
  {
    private static String a = "Rakuten";
    private static String b = "楽天";

    public static boolean a(String paramString)
    {
      return paramString.startsWith("External:");
    }

    public static short b(String paramString)
    {
      return Short.parseShort(paramString.substring("External:".length()));
    }

    public static boolean c(String paramString)
    {
      return (!d(paramString)) && (paramString.startsWith("Viber"));
    }

    public static boolean d(String paramString)
    {
      return (paramString.length() == 12) && (paramString.charAt(11) == '=');
    }

    public static boolean e(String paramString)
    {
      return ((!d(paramString)) && (paramString.startsWith(a))) || (paramString.startsWith(b));
    }
  }

  static class b
  {
    short a;
    short b;
    int c;

    b(long paramLong)
    {
      this.a = ((short)(int)(paramLong & 0xFFFF));
      this.b = ((short)(int)(0xFFFF & paramLong >> 16));
      this.c = ((int)(0xFFFFFFFF & paramLong >> 32));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.i
 * JD-Core Version:    0.6.2
 */