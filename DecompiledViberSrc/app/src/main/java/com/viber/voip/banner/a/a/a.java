package com.viber.voip.banner.a.a;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.e;
import com.viber.voip.ads.q;
import com.viber.voip.ads.s;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.i.c.b;
import com.viber.voip.i.f;
import com.viber.voip.phone.call.CallInfo;

public class a extends c
{
  private static final Logger f = ViberEnv.getLogger();
  private a g;

  public a(Context paramContext, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, PhoneController paramPhoneController, ICdrController paramICdrController, q paramq, s params, g paramg, c.a parama, boolean paramBoolean)
  {
    super(paramContext, paramHandler1, paramHandler2, paramHandler3, paramPhoneController, paramICdrController, paramq, params, paramg, parama, paramBoolean);
  }

  public int a()
  {
    return 15;
  }

  public void a(String paramString, CallInfo paramCallInfo)
  {
    this.g = new a(paramString, paramCallInfo);
    this.c.postDelayed(this.g, 31000L);
  }

  protected AdsCallMetaInfo.AltAdsConfig b()
  {
    return new AdsCallMetaInfo.AltAdsConfig(true, "Sponsored", Long.valueOf(e.a), "/65656263/Google_Direct/TimeOut_Placement_Prod_Direct");
  }

  protected f c()
  {
    return c.b.c;
  }

  public void d()
  {
    super.d();
    if (this.g != null)
    {
      this.c.removeCallbacks(this.g);
      this.g = null;
    }
  }

  public int e()
  {
    return 2;
  }

  public int f()
  {
    return 15;
  }

  public com.viber.voip.ads.b.b.b.c g()
  {
    return com.viber.voip.ads.b.b.b.c.b;
  }

  private class a
    implements Runnable
  {
    final String a;
    final CallInfo b;

    public a(String paramCallInfo, CallInfo arg3)
    {
      this.a = paramCallInfo;
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      a.this.b(this.a, this.b);
      a.a(a.this, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.a
 * JD-Core Version:    0.6.2
 */