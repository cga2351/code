package com.appboy.push.a;

import android.os.Build.VERSION;
import android.text.Html;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.f.i;

public class a
{
  private static final String a = c.a(a.class);

  public static CharSequence a(b paramb, String paramString)
  {
    if (i.c(paramString))
      c.b(a, "Cannot create html spanned text on null or empty text. Returning blank string.");
    while (!paramb.B())
      return paramString;
    if (Build.VERSION.SDK_INT >= 24)
      return Html.fromHtml(paramString, 0);
    return Html.fromHtml(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.a.a
 * JD-Core Version:    0.6.2
 */