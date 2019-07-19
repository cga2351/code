package com.viber.voip.ads.b.c.b;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.viber.common.a.e;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.a.a.a.a.a;
import com.viber.voip.ads.b.a.a.a.b;
import com.viber.voip.ads.b.a.a.a.d.a;
import com.viber.voip.ads.h;
import com.viber.voip.ads.s;
import com.viber.voip.banner.a.a.g;
import com.viber.voip.util.cj;
import java.util.Map;

public class a extends f
{
  private static final e i = ViberEnv.getLogger();
  private final g j;

  public a(Context paramContext, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.b.b.c.a parama, com.viber.voip.i.f paramf1, com.viber.voip.ads.b.b.d.a<b> parama1, g paramg, Handler paramHandler1, Handler paramHandler2, com.viber.common.permission.c paramc1, PhoneController paramPhoneController, ICdrController paramICdrController, com.viber.voip.ads.b.c.c.a.a<com.viber.voip.ads.b.c.c.c> parama2, String paramString, com.viber.voip.messages.extras.b.a parama3, cj paramcj, com.viber.voip.util.i.c paramc2, com.viber.voip.analytics.story.g.a parama4, com.viber.voip.i.f paramf2, s params, h paramh)
  {
    super(paramContext, paramc, parama, paramf1, parama1, paramHandler1, paramHandler2, paramPhoneController, paramICdrController, parama2, paramString, paramcj, paramc1, parama3, paramc2, parama4, paramf2, params, paramh);
    this.j = paramg;
  }

  protected b a(com.viber.voip.ads.b.c.b.a parama)
  {
    Map localMap1 = com.viber.voip.util.k.a.b(parama.a());
    Map localMap2 = com.viber.voip.util.k.a.c(parama.a());
    Location localLocation = h();
    return new com.viber.voip.ads.b.a.a.a.b.a().a(new a.a(parama.a(), 0, "S1PndL8pKvw3ojkBROQmPcxHHJZOrCCTi96aOYGi", "/65656263/SDK_HB/BCI_Placement_Production").a(localMap1).b(localMap2).a(localLocation).a()).a(new com.viber.voip.ads.b.a.a.a.c.a(parama.a(), 0, "/65656263/BCI_Native", null).a(localMap1).a(localLocation).a()).a(new d.a(this.j.b(), 0).a()).a();
  }

  protected boolean b(com.viber.voip.ads.b.b.b.a parama)
  {
    i();
    return super.b(parama);
  }

  protected int g()
  {
    return 22;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.a
 * JD-Core Version:    0.6.2
 */