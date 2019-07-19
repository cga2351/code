package com.adsnative.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Locale;
import java.util.TimeZone;

public class b
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;

  public b(Context paramContext)
  {
    try
    {
      this.a = ("Android " + Build.VERSION.RELEASE);
      if (!TextUtils.isEmpty(com.adsnative.a.a()));
    }
    catch (Exception localException4)
    {
      try
      {
        if (Looper.getMainLooper() == Looper.myLooper())
          com.adsnative.a.a(new WebView(paramContext).getSettings().getUserAgentString());
        if (com.adsnative.a.a() == null)
          com.adsnative.a.a("");
        str1 = Build.MANUFACTURER;
        str2 = Build.MODEL;
      }
      catch (Exception localException4)
      {
        try
        {
          if (str2.startsWith(str1))
          {
            this.b = new k().a(str2);
            if (this.b == null)
              this.b = "";
          }
        }
        catch (Exception localException4)
        {
          try
          {
            this.c = Locale.getDefault().toString();
            if (this.c == null)
              this.c = "";
          }
          catch (Exception localException4)
          {
            try
            {
              this.d = TimeZone.getDefault().getDisplayName();
              if (this.d == null)
                this.d = "";
            }
            catch (Exception localException4)
            {
              try
              {
                while (true)
                {
                  String str1;
                  String str2;
                  this.e = paramContext.getApplicationContext().getPackageName();
                  if (this.e == null)
                    this.e = "";
                  if (!a.b(paramContext))
                    this.f = "None";
                  if (a.d(paramContext))
                    this.f = "WWAN";
                  if (a.c(paramContext))
                    this.f = "Wifi";
                  if (this.f == null)
                    this.f = "";
                  return;
                  localException1 = localException1;
                  this.a = "";
                  continue;
                  localException6 = localException6;
                  com.adsnative.a.a("");
                  continue;
                  this.b = (new k().a(str1) + " " + str2);
                  continue;
                  localException2 = localException2;
                  this.b = "";
                  continue;
                  localException3 = localException3;
                  this.c = "";
                }
                localException4 = localException4;
                this.d = "";
              }
              catch (Exception localException5)
              {
                while (true)
                  this.e = "";
              }
            }
          }
        }
      }
    }
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return com.adsnative.a.a();
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public String f()
  {
    return this.e;
  }

  public String g()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.c.b
 * JD-Core Version:    0.6.2
 */