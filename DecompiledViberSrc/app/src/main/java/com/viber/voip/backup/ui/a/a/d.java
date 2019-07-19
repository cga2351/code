package com.viber.voip.backup.ui.a.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.ui.a.b.b;
import com.viber.voip.backup.ui.a.b.b.a;
import com.viber.voip.backup.ui.a.c.e;
import com.viber.voip.backup.ui.a.c.e.a;
import com.viber.voip.registration.af;
import com.viber.voip.util.cj;

public abstract class d<VIEW extends e>
{
  private static final Logger a = ViberEnv.getLogger();
  protected VIEW d;
  protected final Context e;
  protected final com.viber.voip.backup.ui.a.b.d f;
  protected final cj g;
  protected final b h;
  protected final af i;
  protected final com.viber.voip.analytics.story.g.a j;
  protected f k;
  protected com.google.a.a.b.a.a.b.a.a l;
  protected boolean m = true;

  public d(Context paramContext, VIEW paramVIEW, af paramaf, com.viber.voip.backup.ui.a.b.d paramd, cj paramcj, b paramb, com.viber.voip.analytics.story.g.a parama)
  {
    this.e = paramContext;
    this.d = paramVIEW;
    this.i = paramaf;
    this.f = paramd;
    this.g = paramcj;
    this.h = paramb;
    this.j = parama;
    this.d.a(this);
  }

  private b.a d()
  {
    return new b.a()
    {
      private final b.a b = d.this.b();

      private void a()
      {
        d.this.k.e();
      }

      public void a(int paramAnonymousInt)
      {
        d.this.m = false;
        switch (paramAnonymousInt)
        {
        default:
        case 1000:
        case 1001:
        }
        while (true)
        {
          this.b.a(paramAnonymousInt);
          return;
          a();
        }
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        d.this.m = false;
        a();
        this.b.a(paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }

  private f.a l()
  {
    return new f.a()
    {
      private final f.a b = d.this.c();

      public void a()
      {
        this.b.a();
      }

      public void a(com.google.a.a.b.a.a.b.a.a paramAnonymousa, BackupInfo paramAnonymousBackupInfo, boolean paramAnonymousBoolean)
      {
        d.this.l = paramAnonymousa;
        this.b.a(paramAnonymousa, paramAnonymousBackupInfo, paramAnonymousBoolean);
      }
    };
  }

  protected void a()
  {
    this.h.a(d());
    this.k = g();
  }

  public void a(com.viber.voip.backup.ui.a.c.a parama)
  {
    switch (4.a[parama.ordinal()])
    {
    case 1:
    default:
      return;
    case 2:
      this.h.a(1001);
      return;
    case 3:
    }
    this.h.a(1000);
  }

  protected b.a b()
  {
    return new b.a()
    {
      public void a(int paramAnonymousInt)
      {
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
      }
    };
  }

  protected void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3:
    default:
      return;
    case 0:
    case 1:
      if (this.m)
      {
        this.k.e();
        return;
      }
      this.m = true;
      return;
    case 2:
    }
    this.d.a(e.a.a);
  }

  protected abstract f.a c();

  public void e()
  {
    this.f.b();
  }

  protected void f()
  {
    a();
  }

  protected f g()
  {
    return new f(this.d, this.f, this.h, this.i, this.g, this.e.getResources(), l());
  }

  public boolean h()
  {
    if (this.g.a() == -1)
    {
      this.d.o();
      return false;
    }
    return true;
  }

  public void i()
  {
    b(this.h.d());
  }

  public void j()
  {
    this.h.a();
  }

  public void k()
  {
    this.h.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.a.d
 * JD-Core Version:    0.6.2
 */