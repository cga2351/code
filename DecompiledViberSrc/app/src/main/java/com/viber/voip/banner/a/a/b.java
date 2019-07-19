package com.viber.voip.banner.a.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.e;
import com.viber.voip.ads.q;
import com.viber.voip.ads.s;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.i.c.b;
import com.viber.voip.i.f;

public class b extends c
{
  public b(Context paramContext, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, PhoneController paramPhoneController, ICdrController paramICdrController, q paramq, s params, g paramg, c.a parama, boolean paramBoolean)
  {
    super(paramContext, paramHandler1, paramHandler2, paramHandler3, paramPhoneController, paramICdrController, paramq, params, paramg, parama, paramBoolean);
  }

  public int a()
  {
    return 17;
  }

  protected AdsCallMetaInfo.AltAdsConfig b()
  {
    return new AdsCallMetaInfo.AltAdsConfig(true, "Sponsored", Long.valueOf(e.a), "/65656263/Google_Direct/Post_Call_Placement_Prod_Direct");
  }

  protected f c()
  {
    return c.b.a;
  }

  public int e()
  {
    return 1;
  }

  public int f()
  {
    return 17;
  }

  public com.viber.voip.ads.b.b.b.c g()
  {
    return com.viber.voip.ads.b.b.b.c.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.b
 * JD-Core Version:    0.6.2
 */