package com.yandex.mobile.ads.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class df
{
  private static final Pattern a = Pattern.compile("maps.yandex");

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        if ((paramBoolean) && (f(paramString)))
          localIntent.setPackage("ru.yandex.yandexmaps");
        if (!(paramContext instanceof Activity))
          localIntent.addFlags(268435456);
        paramContext.startActivity(localIntent);
        return true;
      }
      catch (Exception localException)
      {
      }
    return false;
  }

  public static boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    a[] arrayOfa;
    int i;
    if (!bool1)
    {
      arrayOfa = a.values();
      i = arrayOfa.length;
    }
    for (int j = 0; ; j++)
    {
      bool2 = false;
      if (j < i)
      {
        if (paramString.startsWith(arrayOfa[j].F))
          bool2 = true;
      }
      else
        return bool2;
    }
  }

  public static boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    a[] arrayOfa;
    if (!bool1)
      arrayOfa = a.a();
    for (int i = 0; ; i++)
    {
      bool2 = false;
      if (i < 6)
      {
        if (paramString.startsWith(arrayOfa[i].F))
          bool2 = true;
      }
      else
        return bool2;
    }
  }

  public static boolean c(String paramString)
  {
    return URLUtil.isNetworkUrl(paramString);
  }

  public static boolean d(String paramString)
  {
    return (!a(paramString)) && (URLUtil.isNetworkUrl(paramString));
  }

  public static String e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = Uri.decode(paramString.trim());
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("//")))
        str = "https:".concat(String.valueOf(str));
      paramString = de.a(g(str));
    }
    return paramString;
  }

  private static boolean f(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (!bool1);
    try
    {
      Uri localUri = Uri.parse(paramString);
      boolean bool3 = localUri.isHierarchical();
      bool2 = false;
      if (bool3)
      {
        String str = localUri.getHost();
        boolean bool4 = TextUtils.isEmpty(localUri.getQueryParameter("oid"));
        bool2 = false;
        if (!bool4)
        {
          boolean bool5 = a.matcher(str).find();
          bool2 = false;
          if (bool5)
            bool2 = true;
        }
      }
      return bool2;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static String g(String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(paramString);
      String str = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), localUri.getQuery(), localUri.getFragment()).toASCIIString();
      return str;
    }
    catch (Exception localException)
    {
      new Object[] { paramString };
    }
    return paramString;
  }

  public static enum a
  {
    final String F;

    static
    {
      A = new a("SMS", 26, "sms:");
      B = new a("GTALK", 27, "gtalk:");
      C = new a("SPOTIFY", 28, "spotify:");
      D = new a("LASTFM", 29, "lastfm:");
      E = new a("YSTORE", 30, "yastore:");
      a[] arrayOfa = new a[31];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      arrayOfa[10] = k;
      arrayOfa[11] = l;
      arrayOfa[12] = m;
      arrayOfa[13] = n;
      arrayOfa[14] = o;
      arrayOfa[15] = p;
      arrayOfa[16] = q;
      arrayOfa[17] = r;
      arrayOfa[18] = s;
      arrayOfa[19] = t;
      arrayOfa[20] = u;
      arrayOfa[21] = v;
      arrayOfa[22] = w;
      arrayOfa[23] = x;
      arrayOfa[24] = y;
      arrayOfa[25] = z;
      arrayOfa[26] = A;
      arrayOfa[27] = B;
      arrayOfa[28] = C;
      arrayOfa[29] = D;
      arrayOfa[30] = E;
    }

    private a(String paramString)
    {
      this.F = paramString;
    }

    static a[] a()
    {
      a[] arrayOfa = new a[6];
      arrayOfa[0] = j;
      arrayOfa[1] = k;
      arrayOfa[2] = m;
      arrayOfa[3] = n;
      arrayOfa[4] = o;
      arrayOfa[5] = p;
      return arrayOfa;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.df
 * JD-Core Version:    0.6.2
 */