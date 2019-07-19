package com.viber.voip.ads.b.c.c;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import java.util.List;

public class d extends b
  implements c
{
  public d(com.viber.voip.ads.b.b.b.a parama)
  {
    super(parama);
  }

  public com.viber.voip.ads.b.b.b.a a()
  {
    return this.a;
  }

  public Uri b()
  {
    NativeAppInstallAd localNativeAppInstallAd;
    Uri localUri3;
    Uri localUri4;
    if ((this.a instanceof com.viber.voip.ads.b.a.b.a.a))
    {
      localNativeAppInstallAd = (NativeAppInstallAd)this.a.x();
      if (localNativeAppInstallAd.getIcon() == null)
      {
        localUri3 = null;
        if (localUri3 != null)
          break label250;
        if ((localNativeAppInstallAd.getImages() != null) && (!localNativeAppInstallAd.getImages().isEmpty()))
          break label80;
        localUri4 = null;
      }
    }
    while (true)
    {
      label62: Uri localUri1 = localUri4;
      label80: Uri localUri2;
      String str;
      boolean bool2;
      do
      {
        boolean bool1;
        do
        {
          return localUri1;
          localUri3 = localNativeAppInstallAd.getIcon().getUri();
          break;
          localUri4 = ((NativeAd.Image)localNativeAppInstallAd.getImages().get(0)).getUri();
          break label62;
          if ((this.a instanceof com.viber.voip.ads.b.a.b.a.b))
          {
            NativeContentAd localNativeContentAd = (NativeContentAd)this.a.x();
            if (localNativeContentAd.getLogo() == null);
            for (localUri2 = null; ; localUri2 = localNativeContentAd.getLogo().getUri())
            {
              if (localUri2 != null)
                break label247;
              List localList = localNativeContentAd.getImages();
              localUri1 = null;
              if (localList == null)
                break;
              boolean bool3 = localNativeContentAd.getImages().isEmpty();
              localUri1 = null;
              if (bool3)
                break;
              return ((NativeAd.Image)localNativeContentAd.getImages().get(0)).getUri();
            }
          }
          bool1 = this.a instanceof com.viber.voip.ads.b.a.b.c.a;
          localUri1 = null;
        }
        while (!bool1);
        str = ((com.viber.voip.ads.b.a.b.c.a)this.a).o();
        bool2 = TextUtils.isEmpty(str);
        localUri1 = null;
      }
      while (bool2);
      return Uri.parse(str);
      label247: return localUri2;
      label250: localUri4 = localUri3;
    }
  }

  public boolean m()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.c.a))
      return ((com.viber.voip.ads.b.a.b.c.a)this.a).u();
    return true;
  }

  public boolean n()
  {
    if ((this.a instanceof com.viber.voip.ads.b.a.b.c.a))
      return ((com.viber.voip.ads.b.a.b.c.a)this.a).v();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.c.d
 * JD-Core Version:    0.6.2
 */