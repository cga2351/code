package com.viber.voip.banner.d;

import android.content.Context;
import com.viber.voip.banner.view.AdsAfterCallRemoteBannerLayout;
import com.viber.voip.banner.view.a.a;
import com.viber.voip.banner.view.a.b;
import com.viber.voip.banner.view.a.c;

public enum g
{
  private final String e;

  static
  {
    g[] arrayOfg = new g[4];
    arrayOfg[0] = a;
    arrayOfg[1] = b;
    arrayOfg[2] = c;
    arrayOfg[3] = d;
  }

  private g(String paramString)
  {
    this.e = paramString;
  }

  public static g a(String paramString)
  {
    for (g localg : values())
      if (localg.e.equalsIgnoreCase(paramString))
        return localg;
    return a;
  }

  public a a(Context paramContext)
  {
    switch (1.a[ordinal()])
    {
    default:
      return null;
    case 1:
      return c.b(paramContext);
    case 2:
    }
    return b.a(paramContext);
  }

  public boolean a()
  {
    switch (1.a[ordinal()])
    {
    default:
      return false;
    case 1:
    case 2:
    case 3:
    }
    return true;
  }

  public com.viber.voip.banner.view.f b(Context paramContext)
  {
    switch (1.a[ordinal()])
    {
    default:
      return null;
    case 1:
      return new com.viber.voip.banner.view.f(paramContext);
    case 2:
    }
    return new AdsAfterCallRemoteBannerLayout(paramContext);
  }

  public boolean b()
  {
    switch (1.a[ordinal()])
    {
    default:
      return false;
    case 4:
    }
    return true;
  }

  public d c()
  {
    switch (1.a[ordinal()])
    {
    default:
      return null;
    case 1:
      return new f();
    case 2:
      return new e();
    case 4:
      return new h();
    case 3:
    }
    return new i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.g
 * JD-Core Version:    0.6.2
 */