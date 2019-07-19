package com.viber.voip.banner.a.a;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.d.p;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.b.b.c.a;
import com.viber.voip.ads.c.b;
import com.viber.voip.ads.d.i;
import com.viber.voip.ads.e;
import com.viber.voip.ads.q;
import com.viber.voip.ads.q.a;
import com.viber.voip.ads.s;
import com.viber.voip.banner.datatype.AdsCallMetaInfo;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.AltAdsConfig;
import com.viber.voip.banner.datatype.AdsCallMetaInfo.CustomAppNexusConfig;
import com.viber.voip.i.c.b;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.phone.call.CallInfo;

public abstract class c
  implements d, f.a
{
  private static final Logger f = ViberEnv.getLogger();
  protected final Context a;
  protected final ICdrController b;
  protected final Handler c;
  protected final Handler d;
  protected boolean e;
  private final g g;
  private final q h;
  private final s i;
  private final com.viber.voip.ads.c.a j;
  private final f k;
  private AdsCallMetaInfo l;
  private Activity m;
  private int n;
  private final c.a o;

  c(Context paramContext, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, PhoneController paramPhoneController, ICdrController paramICdrController, q paramq, s params, g paramg, c.a parama, boolean paramBoolean)
  {
    this.a = paramContext;
    this.h = paramq;
    this.i = params;
    this.g = paramg;
    this.b = paramICdrController;
    this.o = parama;
    this.e = paramBoolean;
    this.c = paramHandler1;
    this.d = paramHandler3;
    this.j = new b(paramContext, paramPhoneController, this.b, paramHandler2, paramHandler3, paramBoolean);
    this.k = c.b.h;
    c().a(this);
  }

  private void a(int paramInt)
  {
    long l1 = ViberApplication.getInstance().getEngine(false).getPhoneController().generateSequence();
    this.b.handleReportAdsAfterCallDisplay(l1, 1, 0L, f(), "", "", 1, paramInt, 1, "", "", "");
  }

  private void a(q.a parama, CallInfo paramCallInfo)
  {
    switch (parama.b)
    {
    default:
    case 2:
    case 3:
    case 1:
    case 0:
    }
    while (true)
    {
      return;
      a(4);
      return;
      a(2);
      return;
      try
      {
        this.l = com.viber.voip.banner.e.a.e(parama.a);
        m();
        i locali = this.j.a(this.l);
        if (locali != null)
        {
          if ((locali instanceof e))
          {
            this.l = new AdsCallMetaInfo(b());
            this.n = 2;
          }
          locali.a(this.m, this.l, paramCallInfo, f(), g());
          return;
        }
      }
      catch (p localp)
      {
        a(3);
        return;
      }
      catch (Exception localException)
      {
        a(4);
      }
    }
  }

  private void a(CallInfo paramCallInfo)
  {
    this.n = 2;
    this.l = new AdsCallMetaInfo(b());
    i locali = this.j.a(this.l);
    if (locali != null)
      locali.a(this.m, this.l, paramCallInfo, f(), g());
  }

  private void b(CallInfo paramCallInfo)
  {
    this.n = 1;
    Uri localUri = this.g.a(a());
    a(this.h.a(localUri), paramCallInfo);
  }

  private void c(CallInfo paramCallInfo)
  {
    this.n = 3;
    this.l = new AdsCallMetaInfo(new AdsCallMetaInfo.CustomAppNexusConfig());
    i locali = this.j.a(this.l);
    if (locali != null)
      locali.a(this.m, this.l, paramCallInfo, f(), g());
  }

  private void m()
  {
  }

  public abstract int a();

  public void a(Activity paramActivity)
  {
    this.m = paramActivity;
  }

  public void a(String paramString, CallInfo paramCallInfo)
  {
    this.n = 0;
    b(paramString, paramCallInfo);
  }

  public void a(String[] paramArrayOfString)
  {
    this.i.a(paramArrayOfString);
  }

  protected abstract AdsCallMetaInfo.AltAdsConfig b();

  public void b(Activity paramActivity)
  {
    this.m = null;
  }

  void b(String paramString, CallInfo paramCallInfo)
  {
    if (!h())
      return;
    switch (this.o.a(g()))
    {
    default:
      return;
    case 1:
      b(paramCallInfo);
      return;
    case 3:
      c(paramCallInfo);
      return;
    case 2:
    }
    a(paramCallInfo);
  }

  protected abstract f c();

  public void d()
  {
    this.n = 0;
  }

  public boolean h()
  {
    if (this.e);
    while ((this.o.a(g()) == 0) || (!c().e()))
      return false;
    return true;
  }

  public boolean i()
  {
    i locali = j();
    if (locali == null);
    while ((!h()) || (!locali.c()))
      return false;
    return true;
  }

  public i j()
  {
    return this.j.a(this.l);
  }

  public void k()
  {
    this.n = 0;
    if (j() != null)
      j().b();
  }

  public int l()
  {
    if (i())
      return this.n;
    this.n = 0;
    return 0;
  }

  public void onFeatureStateChanged(f paramf)
  {
    if ((c().c().equals(paramf.c())) && (paramf.e()))
      com.viber.voip.a.a.a(this.a).a(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.c
 * JD-Core Version:    0.6.2
 */