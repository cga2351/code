package com.viber.voip.ads.b.a.b.a;

import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAppInstallAd;

public class a extends com.viber.voip.ads.b.b.b.a<NativeAppInstallAd>
{
  private boolean a = false;
  private int b = 0;
  private int c = 2;
  private final long d = System.currentTimeMillis() + A();
  private String e = "";
  private String f = "Google";

  public a(NativeAppInstallAd paramNativeAppInstallAd, String paramString)
  {
    super(paramNativeAppInstallAd, paramString);
    if (paramNativeAppInstallAd.getHeadline() != null)
      this.e = paramNativeAppInstallAd.getHeadline().toString();
  }

  public a(NativeAppInstallAd paramNativeAppInstallAd, String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    this(paramNativeAppInstallAd, paramString1);
    this.c = paramInt;
    this.f = paramString2;
    this.a = paramBoolean;
    if (paramBoolean)
      this.b = 1;
  }

  public int a()
  {
    return this.c;
  }

  public boolean b()
  {
    return System.currentTimeMillis() > this.d;
  }

  public String[] c()
  {
    return new String[0];
  }

  public String[] d()
  {
    return new String[0];
  }

  public String[] e()
  {
    return new String[0];
  }

  public String f()
  {
    return this.e;
  }

  public String g()
  {
    return "Story";
  }

  public String h()
  {
    return this.f;
  }

  public String i()
  {
    return this.f;
  }

  public String j()
  {
    return "";
  }

  public String k()
  {
    return "";
  }

  public String l()
  {
    return "";
  }

  public String m()
  {
    return "";
  }

  public boolean n()
  {
    Bundle localBundle = ((NativeAppInstallAd)x()).getExtras();
    if (localBundle == null)
      return false;
    String str = localBundle.getString("providerName");
    if ((str != null) && (str.equalsIgnoreCase("polymorph")));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.a.b.a.a
 * JD-Core Version:    0.6.2
 */