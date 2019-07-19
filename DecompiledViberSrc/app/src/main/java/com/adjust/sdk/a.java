package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class a
{
  String A;
  private boolean B = false;
  String a;
  Boolean b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  String n;
  String o;
  String p;
  String q;
  String r;
  String s;
  String t;
  String u;
  String v;
  String w;
  String x;
  String y;
  String z;

  a(Context paramContext, String paramString)
  {
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    Configuration localConfiguration = localResources.getConfiguration();
    Locale localLocale = Util.getLocale(localConfiguration);
    int i1 = localConfiguration.screenLayout;
    paramContext.getContentResolver();
    a(paramContext);
    this.h = b(paramContext);
    this.i = c(paramContext);
    this.j = a(i1);
    this.k = a();
    this.l = b();
    this.m = c();
    this.n = d();
    this.o = e();
    this.p = a(localLocale);
    this.q = b(localLocale);
    this.r = b(i1);
    this.s = c(i1);
    this.t = a(localDisplayMetrics);
    this.u = b(localDisplayMetrics);
    this.v = c(localDisplayMetrics);
    this.g = a(paramString);
    this.f = d(paramContext);
    this.w = g();
    this.x = h();
    this.y = f();
    this.z = e(paramContext);
    this.A = f(paramContext);
  }

  private String a()
  {
    return Build.MODEL;
  }

  private String a(int paramInt)
  {
    switch (paramInt & 0xF)
    {
    default:
      return null;
    case 1:
    case 2:
      return "phone";
    case 3:
    case 4:
    }
    return "tablet";
  }

  private String a(DisplayMetrics paramDisplayMetrics)
  {
    int i1 = paramDisplayMetrics.densityDpi;
    if (i1 == 0)
      return null;
    if (i1 < 140)
      return "low";
    if (i1 > 200)
      return "high";
    return "medium";
  }

  private String a(String paramString)
  {
    if (paramString == null)
      return "android4.15.1";
    return Util.formatString("%s@%s", new Object[] { paramString, "android4.15.1" });
  }

  private String a(Locale paramLocale)
  {
    return paramLocale.getLanguage();
  }

  private String b()
  {
    return Build.MANUFACTURER;
  }

  private String b(int paramInt)
  {
    switch (paramInt & 0xF)
    {
    default:
      return null;
    case 1:
      return "small";
    case 2:
      return "normal";
    case 3:
      return "large";
    case 4:
    }
    return "xlarge";
  }

  private String b(Context paramContext)
  {
    return paramContext.getPackageName();
  }

  private String b(DisplayMetrics paramDisplayMetrics)
  {
    return String.valueOf(paramDisplayMetrics.widthPixels);
  }

  private String b(String paramString)
  {
    if (paramString == null)
      return null;
    return Util.sha1(paramString);
  }

  private String b(Locale paramLocale)
  {
    return paramLocale.getCountry();
  }

  private String c()
  {
    return "android";
  }

  private String c(int paramInt)
  {
    switch (paramInt & 0x30)
    {
    default:
      return null;
    case 32:
      return "long";
    case 16:
    }
    return "normal";
  }

  private String c(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String c(DisplayMetrics paramDisplayMetrics)
  {
    return String.valueOf(paramDisplayMetrics.heightPixels);
  }

  private String c(String paramString)
  {
    if (paramString == null)
      return null;
    return Util.md5(paramString.replaceAll(":", ""));
  }

  private String d()
  {
    return Build.VERSION.RELEASE;
  }

  private String d(Context paramContext)
  {
    try
    {
      Cursor localCursor = paramContext.getContentResolver().query(Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider"), new String[] { "aid" }, null, null, null);
      if (localCursor == null)
        return null;
      if (!localCursor.moveToFirst())
      {
        localCursor.close();
        return null;
      }
      String str = localCursor.getString(localCursor.getColumnIndex("aid"));
      localCursor.close();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String e()
  {
    return "" + Build.VERSION.SDK_INT;
  }

  private String e(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
      String str = Util.dateFormatter.format(new Date(localPackageInfo.firstInstallTime));
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String f()
  {
    return Build.ID;
  }

  private String f(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
      String str = Util.dateFormatter.format(new Date(localPackageInfo.lastUpdateTime));
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String g()
  {
    return Build.DISPLAY;
  }

  private String h()
  {
    String[] arrayOfString = Util.getSupportedAbis();
    if ((arrayOfString == null) || (arrayOfString.length == 0))
      return Util.getCpuAbi();
    return arrayOfString[0];
  }

  // ERROR //
  void a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iload_2
    //   3: iconst_3
    //   4: if_icmpge +25 -> 29
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 361	com/adjust/sdk/GooglePlayServicesClient:getGooglePlayServicesInfo	(Landroid/content/Context;)Lcom/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo;
    //   12: invokevirtual 366	com/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo:getGpsAdid	()Ljava/lang/String;
    //   15: putfield 368	com/adjust/sdk/a:a	Ljava/lang/String;
    //   18: aload_0
    //   19: getfield 368	com/adjust/sdk/a:a	Ljava/lang/String;
    //   22: astore 8
    //   24: aload 8
    //   26: ifnull +113 -> 139
    //   29: iconst_0
    //   30: istore_3
    //   31: iload_3
    //   32: iconst_3
    //   33: if_icmpge +25 -> 58
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 361	com/adjust/sdk/GooglePlayServicesClient:getGooglePlayServicesInfo	(Landroid/content/Context;)Lcom/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo;
    //   41: invokevirtual 372	com/adjust/sdk/GooglePlayServicesClient$GooglePlayServicesInfo:isTrackingEnabled	()Ljava/lang/Boolean;
    //   44: putfield 374	com/adjust/sdk/a:b	Ljava/lang/Boolean;
    //   47: aload_0
    //   48: getfield 374	com/adjust/sdk/a:b	Ljava/lang/Boolean;
    //   51: astore 6
    //   53: aload 6
    //   55: ifnull +107 -> 162
    //   58: aload_0
    //   59: getfield 368	com/adjust/sdk/a:a	Ljava/lang/String;
    //   62: ifnonnull +74 -> 136
    //   65: aload_0
    //   66: getfield 42	com/adjust/sdk/a:B	Z
    //   69: ifne +67 -> 136
    //   72: aload_1
    //   73: ldc_w 376
    //   76: invokestatic 380	com/adjust/sdk/Util:checkPermission	(Landroid/content/Context;Ljava/lang/String;)Z
    //   79: ifne +18 -> 97
    //   82: invokestatic 386	com/adjust/sdk/AdjustFactory:getLogger	()Lcom/adjust/sdk/ILogger;
    //   85: ldc_w 388
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokeinterface 394 3 0
    //   97: aload_1
    //   98: invokestatic 397	com/adjust/sdk/Util:getMacAddress	(Landroid/content/Context;)Ljava/lang/String;
    //   101: astore 4
    //   103: aload_0
    //   104: aload_0
    //   105: aload 4
    //   107: invokespecial 399	com/adjust/sdk/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 401	com/adjust/sdk/a:c	Ljava/lang/String;
    //   113: aload_0
    //   114: aload_0
    //   115: aload 4
    //   117: invokespecial 403	com/adjust/sdk/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 405	com/adjust/sdk/a:d	Ljava/lang/String;
    //   123: aload_0
    //   124: aload_1
    //   125: invokestatic 408	com/adjust/sdk/Util:getAndroidId	(Landroid/content/Context;)Ljava/lang/String;
    //   128: putfield 410	com/adjust/sdk/a:e	Ljava/lang/String;
    //   131: aload_0
    //   132: iconst_1
    //   133: putfield 42	com/adjust/sdk/a:B	Z
    //   136: return
    //   137: astore 7
    //   139: aload_0
    //   140: aload_1
    //   141: invokestatic 413	com/adjust/sdk/Util:getPlayAdId	(Landroid/content/Context;)Ljava/lang/String;
    //   144: putfield 368	com/adjust/sdk/a:a	Ljava/lang/String;
    //   147: aload_0
    //   148: getfield 368	com/adjust/sdk/a:a	Ljava/lang/String;
    //   151: ifnonnull -122 -> 29
    //   154: iinc 2 1
    //   157: goto -155 -> 2
    //   160: astore 5
    //   162: aload_0
    //   163: aload_1
    //   164: invokestatic 417	com/adjust/sdk/Util:isPlayTrackingEnabled	(Landroid/content/Context;)Ljava/lang/Boolean;
    //   167: putfield 374	com/adjust/sdk/a:b	Ljava/lang/Boolean;
    //   170: aload_0
    //   171: getfield 374	com/adjust/sdk/a:b	Ljava/lang/Boolean;
    //   174: ifnonnull -116 -> 58
    //   177: iinc 3 1
    //   180: goto -149 -> 31
    //
    // Exception table:
    //   from	to	target	type
    //   7	24	137	java/lang/Exception
    //   36	53	160	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.a
 * JD-Core Version:    0.6.2
 */