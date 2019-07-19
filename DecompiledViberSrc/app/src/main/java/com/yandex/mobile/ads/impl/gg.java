package com.yandex.mobile.ads.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gg
{
  private static final Pattern a = Pattern.compile("(<script)(.*)(src=\"mraid\\.js\")(.*)(<\\/script>)");

  public static boolean a(String paramString)
  {
    return a.matcher(paramString).find();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.gg
 * JD-Core Version:    0.6.2
 */