package com.viber.voip.notif.d;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Extender;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.u;
import com.viber.voip.notif.c.x;
import com.viber.voip.notif.f;

public abstract class c
  implements e
{
  private static final Logger a = ViberEnv.getLogger();
  CircularArray<NotificationCompat.Extender> d;
  CircularArray<com.viber.voip.notif.a.a.a> e;
  CircularArray<com.viber.voip.notif.a.a.a> f;
  b g;

  private void a(Context paramContext, o paramo, a parama)
  {
    if (this.e != null)
      a(paramo.a(this.e, paramContext, parama));
    if (this.f != null)
      a(u.a(this.f, paramContext, parama));
  }

  public String R_()
  {
    return null;
  }

  public final e.b a(Context paramContext, j paramj)
  {
    return a(paramContext, paramj, null);
  }

  public final e.b a(Context paramContext, j paramj, com.viber.voip.notif.c paramc)
  {
    return b(paramContext, paramj, paramc);
  }

  protected void a(Context paramContext, g paramg)
  {
  }

  protected void a(Context paramContext, o paramo)
  {
  }

  protected void a(Context paramContext, o paramo, com.viber.voip.notif.f.e parame)
  {
  }

  protected final void a(com.viber.voip.notif.a.a.a parama)
  {
    if (parama == null)
      return;
    if (this.e == null)
      this.e = new CircularArray();
    this.e.addLast(parama);
  }

  protected final void a(n paramn)
  {
    if (paramn == null)
      return;
    if (this.d == null)
      this.d = new CircularArray();
    a(paramn.a());
    this.d.addLast(paramn);
  }

  protected final void a(x paramx)
  {
    if (paramx == null)
      return;
    if (this.g == null)
      this.g = new b();
    this.g.a(paramx);
  }

  protected final void a(com.viber.voip.notif.a.a.a[] paramArrayOfa)
  {
    int i = paramArrayOfa.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfa[j]);
  }

  protected final void a(n[] paramArrayOfn)
  {
    int i = paramArrayOfn.length;
    for (int j = 0; j < i; j++)
      a(paramArrayOfn[j]);
  }

  public abstract int b();

  e.b b(Context paramContext, j paramj, com.viber.voip.notif.c paramc)
  {
    l locall = g(paramContext);
    locall.c = b_(paramContext);
    locall.d = b(paramContext);
    locall.e = b();
    h localh = paramj.a();
    o localo = paramj.b();
    g localg = paramj.c();
    com.viber.voip.notif.f.e locale = paramj.d();
    a locala = paramj.e();
    a(paramContext, localo, locale);
    a(paramContext, localg);
    a(paramContext, localo);
    a(paramContext, localo, locala);
    locall.f = this.d;
    locall.g = this.g;
    if (paramc != null);
    while (true)
    {
      return new e.b()
      {
        public k a(f paramAnonymousf)
        {
          return a(paramAnonymousf, null, c.this.R_(), c.this.a());
        }

        public k a(f paramAnonymousf, e.a paramAnonymousa)
        {
          return a(paramAnonymousf, paramAnonymousa, c.this.R_(), c.this.a());
        }

        public k a(f paramAnonymousf, e.a paramAnonymousa, String paramAnonymousString, int paramAnonymousInt)
        {
          if (paramAnonymousa != null)
            paramAnonymousa.a(this.a);
          paramAnonymousf.a(paramAnonymousString, paramAnonymousInt, this.a);
          return new k(paramAnonymousString, paramAnonymousInt);
        }
      };
      paramc = d();
    }
  }

  public abstract CharSequence b(Context paramContext);

  protected final void b(com.viber.voip.notif.a.a.a parama)
  {
    if (parama == null)
      return;
    if (this.f == null)
      this.f = new CircularArray();
    this.f.addLast(parama);
  }

  public abstract CharSequence b_(Context paramContext);

  public abstract l g(Context paramContext);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.c
 * JD-Core Version:    0.6.2
 */