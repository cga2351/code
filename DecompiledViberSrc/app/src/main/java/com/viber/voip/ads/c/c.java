package com.viber.voip.ads.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.d.i;
import com.viber.voip.ads.d.j;
import com.viber.voip.ads.d.q;
import com.viber.voip.ads.o;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AdsAfterCallMetaInfoItem;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.util.bg;
import com.viber.voip.util.da;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.h.a;

public class c
  implements i
{
  private static final Logger a = ViberEnv.getLogger();
  private h.a b;
  private h.a c;
  private final e d;
  private final com.viber.voip.util.e.f e;
  private final Context f;
  private j g;

  public c(Context paramContext)
  {
    this.d = e.a(paramContext);
    this.e = com.viber.voip.util.e.f.a();
    this.f = paramContext;
  }

  private void a(AdsCallMetaInfo.AdsAfterCallMetaInfoItem paramAdsAfterCallMetaInfoItem)
  {
    paramAdsAfterCallMetaInfoItem.setLandingUrl(bg.b(paramAdsAfterCallMetaInfoItem.getLandingUrl()));
    paramAdsAfterCallMetaInfoItem.removeTtl();
    b(paramAdsAfterCallMetaInfoItem);
  }

  private void b(AdsCallMetaInfo.AdsAfterCallMetaInfoItem paramAdsAfterCallMetaInfoItem)
  {
    Uri localUri1 = Uri.parse(paramAdsAfterCallMetaInfoItem.getImageUrl());
    this.b = new h.a()
    {
      public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        if (c.a(c.this) == null);
        do
        {
          return;
          c.a(c.this).a(true);
          c.a(c.this, null);
        }
        while (paramAnonymousBitmap == null);
        c.a(c.this).a(true);
      }
    };
    this.d.a(localUri1, this.e, this.b);
    if (paramAdsAfterCallMetaInfoItem.shouldShowProviderIcon())
    {
      Uri localUri2 = Uri.parse(paramAdsAfterCallMetaInfoItem.getProviderIconUrl());
      this.c = new h.a()
      {
        public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
        {
          c.b(c.this, null);
          if ((paramAnonymousBitmap != null) && (c.a(c.this) == null));
        }
      };
      this.d.a(localUri2, this.e, this.c);
    }
  }

  public void a(Activity paramActivity, AdsCallMetaInfo paramAdsCallMetaInfo, CallInfo paramCallInfo, int paramInt, com.viber.voip.ads.b.b.b.c paramc)
  {
    AdsCallMetaInfo.AdsAfterCallMetaInfoItem localAdsAfterCallMetaInfoItem = paramAdsCallMetaInfo.getItem(0);
    if (localAdsAfterCallMetaInfoItem == null);
    while (da.a(localAdsAfterCallMetaInfoItem.getImageUrl()))
      return;
    this.g = new q(localAdsAfterCallMetaInfoItem);
    a(localAdsAfterCallMetaInfoItem);
  }

  public void a(Context paramContext, com.viber.voip.banner.view.f paramf, com.viber.voip.ads.c paramc)
  {
    if (paramc != null)
      paramc.onAdLoaded(paramf);
  }

  public void a(o paramo)
  {
  }

  public void b()
  {
    this.g = null;
  }

  public boolean c()
  {
    return this.g != null;
  }

  public void d()
  {
  }

  public j e()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.c.c
 * JD-Core Version:    0.6.2
 */