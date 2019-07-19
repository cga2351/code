package com.viber.voip.ads.c;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.e;
import com.viber.voip.ads.f;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.CustomAdsNativesConfig;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.CustomAppNexusConfig;
import com.viber.voip.settings.d.f;

public class b
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.ads.d.i b;
  private com.viber.voip.ads.d.i c;
  private com.viber.voip.ads.d.i d;
  private f e;
  private boolean f;

  public b(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, Handler paramHandler1, Handler paramHandler2, boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.b = new c(paramContext);
    this.c = new e(paramContext, paramPhoneController, paramICdrController, paramHandler1, paramHandler2);
    this.d = new com.viber.voip.ads.i(paramContext, paramPhoneController, paramICdrController, paramHandler1, paramHandler2);
    this.e = new f(paramContext, paramPhoneController, paramICdrController, paramHandler1, paramHandler2, new com.viber.voip.ads.b.a.a.a(d.f.d, paramHandler2));
  }

  public com.viber.voip.ads.d.i a(AdsCallMetaInfo paramAdsCallMetaInfo)
  {
    if ((paramAdsCallMetaInfo == null) || (this.f));
    do
    {
      return null;
      if (paramAdsCallMetaInfo.getAltAdsConfig() == null)
        return this.b;
      boolean bool1 = paramAdsCallMetaInfo.getAltAdsConfig() instanceof AdsCallMetaInfo.CustomAppNexusConfig;
      boolean bool2 = paramAdsCallMetaInfo.getAltAdsConfig() instanceof AdsCallMetaInfo.CustomAdsNativesConfig;
      if (bool1)
        return this.d;
      if (bool2)
        return this.e;
    }
    while (!paramAdsCallMetaInfo.getAltAdsConfig().showAlternateAds());
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.c.b
 * JD-Core Version:    0.6.2
 */