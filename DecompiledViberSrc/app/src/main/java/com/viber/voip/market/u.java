package com.viber.voip.market;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u
{
  private static final a a = new a(53, 0, 0, 0);
  private static final a b = new a(54, 0, 2840, 68);
  private static final a c = new a(54, 0, 2840, 85);
  private static final a d = new a(55, 0, 2883, 54);
  private static final Pattern e = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
  private static final String[] f = { "com.google.android.webview", "com.android.chrome", "com.chrome.beta", "com.chrome.canary", "com.chrome.dev" };

  public static boolean a()
  {
    a locala = c();
    if (locala == null);
    while (true)
    {
      return false;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      try
      {
        Date localDate1 = localSimpleDateFormat.parse("2016-12-27");
        Date localDate2 = localSimpleDateFormat.parse("2017-01-07");
        Date localDate3 = new Date();
        if (locala.a(a) >= 0)
        {
          if (locala.a(b) < 0)
            return true;
          if (locala.a(c) < 0)
            return localDate3.after(localDate1);
          if (locala.a(d) < 0)
            return localDate3.after(localDate2);
        }
      }
      catch (ParseException localParseException)
      {
      }
    }
    return false;
  }

  private static PackageInfo b()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 21)
        return null;
      CookieManager.getInstance();
      Field localField = Class.forName("android.webkit.WebViewFactory").getDeclaredField("sPackageInfo");
      localField.setAccessible(true);
      PackageInfo localPackageInfo = (PackageInfo)localField.get(null);
      return localPackageInfo;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private static a c()
  {
    PackageInfo localPackageInfo = b();
    if (localPackageInfo == null);
    Matcher localMatcher;
    do
    {
      return null;
      String str = localPackageInfo.versionName;
      localMatcher = e.matcher(str);
    }
    while (!localMatcher.matches());
    return new a(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)), Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)));
  }

  private static class a
    implements Comparable<a>
  {
    private int[] a;

    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    }

    private a(int[] paramArrayOfInt)
    {
      this.a = paramArrayOfInt;
    }

    public int a(a parama)
    {
      for (int i = 0; i < 4; i++)
      {
        int j = this.a[i] - parama.a[i];
        if (j != 0)
          return j;
      }
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a))
        return false;
      a locala = (a)paramObject;
      return Arrays.equals(this.a, locala.a);
    }

    public int hashCode()
    {
      return Arrays.hashCode(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.u
 * JD-Core Version:    0.6.2
 */