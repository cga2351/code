package com.viber.voip.ads.b.c.c;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.viber.voip.ads.b.a.a.ab.a;
import com.viber.voip.util.da;
import java.util.List;

public class b
  implements a
{
  protected final com.viber.voip.ads.b.b.b.a a;
  private a.a b;

  public b(com.viber.voip.ads.b.b.b.a parama)
  {
    this.a = parama;
  }

  public com.viber.voip.ads.b.b.b.a a()
  {
    return this.a;
  }

  public String a(Resources paramResources)
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.b.a))
      return paramResources.getString(((ab.a)this.a.x()).a());
    return null;
  }

  public void a(a.a parama)
  {
    this.b = parama;
  }

  public Uri b()
  {
    NativeAppInstallAd localNativeAppInstallAd;
    Uri localUri2;
    Uri localUri1;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localNativeAppInstallAd = (NativeAppInstallAd)this.a.x();
      if ((localNativeAppInstallAd.getImages() == null) || (localNativeAppInstallAd.getImages().isEmpty()))
      {
        localUri2 = null;
        localUri1 = localUri2;
      }
    }
    label146: String str;
    boolean bool2;
    do
    {
      boolean bool1;
      do
      {
        NativeContentAd localNativeContentAd;
        boolean bool3;
        do
        {
          List localList;
          do
          {
            return localUri1;
            localUri2 = ((NativeAd.Image)localNativeAppInstallAd.getImages().get(0)).getUri();
            break;
            if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
              break label146;
            localNativeContentAd = (NativeContentAd)this.a.x();
            localList = localNativeContentAd.getImages();
            localUri1 = null;
          }
          while (localList == null);
          bool3 = localNativeContentAd.getImages().isEmpty();
          localUri1 = null;
        }
        while (bool3);
        return ((NativeAd.Image)localNativeContentAd.getImages().get(0)).getUri();
        bool1 = this.a instanceof com.viber.voip.ads.b.a.b.c.a;
        localUri1 = null;
      }
      while (!bool1);
      str = ((com.viber.voip.ads.b.a.b.c.a)this.a).o();
      bool2 = da.a(str);
      localUri1 = null;
    }
    while (bool2);
    return Uri.parse(str);
  }

  public String b(Resources paramResources)
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.b.a))
      return paramResources.getString(((ab.a)this.a.x()).b());
    return null;
  }

  public int c()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.b.a))
      return ((ab.a)this.a.x()).d();
    return 0;
  }

  public String c(Resources paramResources)
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.b.a))
    {
      int i = ((ab.a)this.a.x()).c();
      if (i == 0)
        return null;
      return paramResources.getString(i);
    }
    return null;
  }

  public String d()
  {
    Bundle localBundle2;
    Object localObject2;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localBundle2 = ((NativeAppInstallAd)this.a.x()).getExtras();
      if (localBundle2 == null)
      {
        localObject2 = null;
        if (!da.a((CharSequence)localObject2))
          break label52;
      }
    }
    label52: label104: 
    do
      while (true)
      {
        return null;
        localObject2 = localBundle2.getString("adProviderIconUrl");
        break;
        return localObject2;
        if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          break label104;
        Bundle localBundle1 = ((NativeContentAd)this.a.x()).getExtras();
        if (localBundle1 == null);
        for (Object localObject1 = null; !da.a((CharSequence)localObject1); localObject1 = localBundle1.getString("adProviderIconUrl"))
          return localObject1;
      }
    while (!(this.a instanceof com.viber.voip.ads.b.a.b.c.a));
    return ((com.viber.voip.ads.b.a.b.c.a)this.a).p();
  }

  public String e()
  {
    NativeAppInstallAd localNativeAppInstallAd;
    String str2;
    String str1;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localNativeAppInstallAd = (NativeAppInstallAd)this.a.x();
      if (localNativeAppInstallAd.getHeadline() == null)
      {
        str2 = null;
        str1 = str2;
      }
    }
    label97: boolean bool;
    do
    {
      NativeContentAd localNativeContentAd;
      CharSequence localCharSequence;
      do
      {
        return str1;
        str2 = localNativeAppInstallAd.getHeadline().toString();
        break;
        if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          break label97;
        localNativeContentAd = (NativeContentAd)this.a.x();
        localCharSequence = localNativeContentAd.getHeadline();
        str1 = null;
      }
      while (localCharSequence == null);
      return localNativeContentAd.getHeadline().toString();
      bool = this.a instanceof com.viber.voip.ads.b.a.b.c.a;
      str1 = null;
    }
    while (!bool);
    return ((com.viber.voip.ads.b.a.b.c.a)this.a).q();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localb = (b)paramObject;
    }
    while (this.a == localb.a);
    return false;
  }

  public String f()
  {
    NativeAppInstallAd localNativeAppInstallAd;
    String str2;
    String str1;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localNativeAppInstallAd = (NativeAppInstallAd)this.a.x();
      if (localNativeAppInstallAd.getBody() == null)
      {
        str2 = null;
        str1 = str2;
      }
    }
    label97: boolean bool;
    do
    {
      NativeContentAd localNativeContentAd;
      CharSequence localCharSequence;
      do
      {
        return str1;
        str2 = localNativeAppInstallAd.getBody().toString();
        break;
        if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          break label97;
        localNativeContentAd = (NativeContentAd)this.a.x();
        localCharSequence = localNativeContentAd.getBody();
        str1 = null;
      }
      while (localCharSequence == null);
      return localNativeContentAd.getBody().toString();
      bool = this.a instanceof com.viber.voip.ads.b.a.b.c.a;
      str1 = null;
    }
    while (!bool);
    return ((com.viber.voip.ads.b.a.b.c.a)this.a).r();
  }

  public String g()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.c.a))
      return ((com.viber.voip.ads.b.a.b.c.a)this.a).s();
    return "Ad";
  }

  public String h()
  {
    Bundle localBundle2;
    Object localObject2;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localBundle2 = ((NativeAppInstallAd)this.a.x()).getExtras();
      if (localBundle2 == null)
      {
        localObject2 = null;
        if (!da.a((CharSequence)localObject2))
          break label52;
      }
    }
    label52: label104: 
    do
      while (true)
      {
        return null;
        localObject2 = localBundle2.getString("adProviderTargetUrl");
        break;
        return localObject2;
        if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          break label104;
        Bundle localBundle1 = ((NativeContentAd)this.a.x()).getExtras();
        if (localBundle1 == null);
        for (Object localObject1 = null; !da.a((CharSequence)localObject1); localObject1 = localBundle1.getString("adProviderTargetUrl"))
          return localObject1;
      }
    while (!(this.a instanceof com.viber.voip.ads.b.a.b.c.a));
    return this.a.l();
  }

  public String i()
  {
    NativeAppInstallAd localNativeAppInstallAd;
    String str2;
    String str1;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localNativeAppInstallAd = (NativeAppInstallAd)this.a.x();
      if (localNativeAppInstallAd.getCallToAction() == null)
      {
        str2 = null;
        str1 = str2;
      }
    }
    label97: boolean bool;
    do
    {
      NativeContentAd localNativeContentAd;
      CharSequence localCharSequence;
      do
      {
        return str1;
        str2 = localNativeAppInstallAd.getCallToAction().toString();
        break;
        if (!(this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          break label97;
        localNativeContentAd = (NativeContentAd)this.a.x();
        localCharSequence = localNativeContentAd.getCallToAction();
        str1 = null;
      }
      while (localCharSequence == null);
      return localNativeContentAd.getCallToAction().toString();
      bool = this.a instanceof com.viber.voip.ads.b.a.b.c.a;
      str1 = null;
    }
    while (!bool);
    return ((com.viber.voip.ads.b.a.b.c.a)this.a).t();
  }

  public boolean j()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a));
    do
    {
      do
        return true;
      while ((this.a instanceof com.viber.voip.ads.b.a.b.a.b));
      if ((this.a instanceof com.viber.voip.ads.b.a.b.c.a))
        return ((com.viber.voip.ads.b.a.b.c.a)this.a).w();
    }
    while ((this.a instanceof com.viber.voip.ads.b.a.b.b.a));
    return false;
  }

  public boolean k()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a));
    do
    {
      do
        return true;
      while ((this.a instanceof com.viber.voip.ads.b.a.b.a.b));
      if ((this.a instanceof com.viber.voip.ads.b.a.b.c.a))
      {
        if (!da.a(((com.viber.voip.ads.b.a.b.c.a)this.a).t()));
        for (boolean bool = true; ; bool = false)
          return bool;
      }
      if (!(this.a instanceof com.viber.voip.ads.b.a.b.b.a))
        break;
    }
    while (((ab.a)this.a.x()).c() != 0);
    return false;
    return false;
  }

  public a.a l()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.c.b
 * JD-Core Version:    0.6.2
 */