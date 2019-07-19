package com.crashlytics.android.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import c.a.a.a.a.b.s;

class a
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;

  a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
  }

  public static a a(Context paramContext, s params, String paramString1, String paramString2)
    throws PackageManager.NameNotFoundException
  {
    String str1 = paramContext.getPackageName();
    String str2 = params.i();
    PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str1, 0);
    String str3 = Integer.toString(localPackageInfo.versionCode);
    if (localPackageInfo.versionName == null);
    for (String str4 = "0.0"; ; str4 = localPackageInfo.versionName)
      return new a(paramString1, paramString2, str2, str1, str3, str4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.a
 * JD-Core Version:    0.6.2
 */