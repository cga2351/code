package com.viber.voip.shareviber.chatstrigger;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.permissions.n;
import com.viber.voip.util.ae;

public class b
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final Handler c;
  private final dagger.a<ab> d;
  private final dagger.a<m> e;
  private final boolean f;
  private final com.viber.common.permission.c g;
  private final com.viber.common.b.b h;
  private final boolean i;
  private boolean j;

  public b(com.viber.common.permission.c paramc, Handler paramHandler1, Handler paramHandler2, dagger.a<ab> parama, dagger.a<m> parama1, com.viber.common.b.b paramb, long paramLong, boolean paramBoolean)
  {
    this.g = paramc;
    this.h = paramb;
    this.i = ae.d(paramLong, 1209600000L);
    this.b = paramHandler1;
    this.c = paramHandler2;
    this.d = parama;
    this.e = parama1;
    this.f = paramBoolean;
  }

  public void a(a.a parama)
  {
    if (!this.i)
      this.c.post(new c(this, parama));
    this.b.post(new d(this, parama));
  }

  public boolean a()
  {
    return ((!this.f) && (this.g.a(n.j)) && (this.i) && (this.j)) || (this.h.d());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.chatstrigger.b
 * JD-Core Version:    0.6.2
 */