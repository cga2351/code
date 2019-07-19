package com.google.a.a.f.a;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class a
{
  private static final b a = new c("-_.*", true);
  private static final b b = new c("-_.!~*'()@:$&,;=", false);
  private static final b c = new c("-_.!~*'()@:$&,;=+/?", false);
  private static final b d = new c("-_.!~*'():$&,;=", false);
  private static final b e = new c("-_.!~*'()@:$,;/?:", false);

  public static String a(String paramString)
  {
    return a.a(paramString);
  }

  public static String b(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }

  public static String c(String paramString)
  {
    return b.a(paramString);
  }

  public static String d(String paramString)
  {
    return c.a(paramString);
  }

  public static String e(String paramString)
  {
    return d.a(paramString);
  }

  public static String f(String paramString)
  {
    return e.a(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.a.a
 * JD-Core Version:    0.6.2
 */