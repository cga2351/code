package com.viber.voip.backup.auto.service;

import android.net.Uri;
import android.os.PowerManager.WakeLock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.c.e;
import com.viber.voip.backup.c.f;
import com.viber.voip.backup.c.h;
import com.viber.voip.backup.c.i;
import com.viber.voip.backup.g;
import com.viber.voip.backup.j;
import com.viber.voip.backup.l;
import com.viber.voip.backup.t;
import java.io.IOException;

class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final PowerManager.WakeLock b;
  private final g c;
  private final c d;
  private final com.viber.voip.backup.c e;
  private final com.viber.voip.backup.auto.b f;
  private final com.viber.voip.backup.auto.d g;
  private final com.viber.voip.backup.auto.c h;
  private final b i;
  private final j j = new j()
  {
    private boolean d(Uri paramAnonymousUri)
    {
      return t.c(paramAnonymousUri);
    }

    public void a(Uri paramAnonymousUri, int paramAnonymousInt)
    {
      if (d(paramAnonymousUri))
      {
        int i = l.a(t.h(paramAnonymousUri), paramAnonymousInt);
        a.c(a.this).a(i);
      }
    }

    public void a(Uri paramAnonymousUri, com.viber.voip.backup.c.d paramAnonymousd)
    {
      if (d(paramAnonymousUri))
        a.b(a.this).b(paramAnonymousd);
    }

    public boolean a(Uri paramAnonymousUri)
    {
      return d(paramAnonymousUri);
    }

    public void b(Uri paramAnonymousUri)
    {
      if (d(paramAnonymousUri))
        a.a(a.this).b();
    }

    public void c(Uri paramAnonymousUri)
    {
      if (d(paramAnonymousUri))
        a.a(a.this).c();
    }
  };
  private final e k = new h()
  {
    private void a()
    {
      a.a(a.this).c();
      a.c(a.this).c();
    }

    protected void a(com.google.a.a.b.a.a.b.a.c paramAnonymousc)
    {
      a();
    }

    protected void a(com.google.a.a.b.a.a.b.a.d paramAnonymousd)
    {
      a();
    }

    protected void a(com.viber.voip.backup.c.d paramAnonymousd)
    {
      a();
    }

    protected void a(f paramAnonymousf)
    {
      a.a(a.this).b();
    }

    protected void a(i paramAnonymousi)
    {
      a();
    }

    protected void a(IOException paramAnonymousIOException)
    {
      a();
    }
  };

  a(PowerManager.WakeLock paramWakeLock, g paramg, c paramc, com.viber.voip.backup.c paramc1, com.viber.voip.backup.auto.b paramb, com.viber.voip.backup.auto.d paramd, com.viber.voip.backup.auto.c paramc2, b paramb1)
  {
    this.b = paramWakeLock;
    this.c = paramg;
    this.d = paramc;
    this.e = paramc1;
    this.f = paramb;
    this.g = paramd;
    this.h = paramc2;
    this.i = paramb1;
  }

  private int a(com.viber.voip.backup.a parama)
  {
    switch (3.a[parama.ordinal()])
    {
    case 1:
    default:
      return 2;
    case 2:
      return 3;
    case 3:
    }
    return 4;
  }

  private void a()
  {
    this.i.b();
    this.b.release();
  }

  public void a(long paramLong)
  {
    this.b.acquire();
    if (!this.h.a(this.d.f(), paramLong))
    {
      a();
      return;
    }
    this.f.a(paramLong);
    this.c.b(this.j);
    this.e.a(false);
    this.c.b(this.d.c(), this.d.b(), this.d.a(), this.d.e(), this.d.d(), a(this.d.f()), this.d.g(), this.d.h(), this.d.i());
    this.e.a(true);
    this.c.c(this.j);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.auto.service.a
 * JD-Core Version:    0.6.2
 */