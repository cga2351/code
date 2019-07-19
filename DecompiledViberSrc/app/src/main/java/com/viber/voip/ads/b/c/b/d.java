package com.viber.voip.ads.b.c.b;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.viber.common.a.e;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.a.a.a;
import com.viber.voip.ads.b.a.a.a.e.a;
import com.viber.voip.ads.b.c.b.a.a;
import com.viber.voip.ads.h;
import com.viber.voip.ads.s;
import com.viber.voip.util.cj;
import java.lang.ref.WeakReference;
import java.util.Map;

public class d extends f
{
  private static final e i = ViberEnv.getLogger();
  private com.viber.voip.i.f j;
  private WeakReference<Activity> k = new WeakReference(null);

  public d(Context paramContext, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.b.b.c.a parama, com.viber.voip.i.f paramf1, com.viber.voip.ads.b.b.d.a<com.viber.voip.ads.b.a.a.a.b> parama1, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc1, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.ads.b.c.c.a.a<com.viber.voip.ads.b.c.c.c> parama2, String paramString, com.viber.voip.messages.extras.b.a parama3, com.viber.voip.util.i.c paramc2, com.viber.voip.analytics.story.g.a parama4, cj paramcj, com.viber.voip.i.f paramf2, com.viber.voip.i.f paramf3, s params, h paramh)
  {
    super(paramContext, paramc, parama, paramf1, parama1, paramHandler1, paramHandler2, paramPhoneController, paramICdrController, parama2, paramString, paramcj, paramc1, parama3, paramc2, parama4, paramf3, params, paramh);
    this.j = paramf2;
  }

  protected com.viber.voip.ads.b.a.a.a.b a(com.viber.voip.ads.b.c.b.a parama)
  {
    this.k = new WeakReference(parama.a());
    Map localMap1 = com.viber.voip.util.k.a.b(parama.a());
    Map localMap2 = com.viber.voip.util.k.a.c(parama.a());
    Location localLocation = h();
    com.viber.voip.ads.b.a.a.a.b.a locala = new com.viber.voip.ads.b.a.a.a.b.a().a(new a.a(parama.a(), 0, "mh6G_jXoBaQrwXBLFjda99o112kJThMZ1yi5bOoR", "/65656263/SDK_HB/Chat_Screen_Placement_Production").a(localMap1).b(localMap2).a(localLocation).a()).a(new com.viber.voip.ads.b.a.a.a.c.a(parama.a(), 0, "/65656263/Google_Direct/Chat_Screen_Placement_Prod_Direct", null).a(localMap1).a(localLocation).a()).a(new e.a(com.viber.voip.ads.b.b.b.c.i, parama.d(), parama.e(), parama.f()).a());
    Integer localInteger = parama.c();
    if (localInteger != null)
      locala.a(localInteger.intValue());
    return locala.a();
  }

  protected boolean a(com.viber.voip.ads.b.b.b.b paramb, com.viber.voip.ads.b.b.a.c paramc)
  {
    boolean bool = super.a(paramb, paramc);
    Activity localActivity = (Activity)this.k.get();
    if ((localActivity != null) && (paramc != null))
    {
      a(new b.a.a(localActivity).a(2147483647).a(paramb.b()).b(paramb.d()).b(paramb.e()).a(), paramc);
      return true;
    }
    return bool;
  }

  protected boolean b(com.viber.voip.ads.b.b.b.a parama)
  {
    if (!(parama instanceof com.viber.voip.ads.b.a.b.b.a))
      i();
    return super.b(parama);
  }

  protected boolean b(com.viber.voip.ads.b.c.b.a parama, com.viber.voip.ads.b.c.a<com.viber.voip.ads.b.c.c.c> parama1)
  {
    if (!this.h.b())
    {
      a(new b.a.a(parama).a(2147483647).a(), a(parama1));
      return false;
    }
    return true;
  }

  public boolean e()
  {
    return ((this.j.e()) || (this.c == null) || (this.c.e())) && (this.b.a(this.a) != 0);
  }

  protected int g()
  {
    return 24;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.d
 * JD-Core Version:    0.6.2
 */