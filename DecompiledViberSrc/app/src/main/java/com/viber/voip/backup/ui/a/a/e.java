package com.viber.voip.backup.ui.a.a;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.t;
import com.viber.voip.backup.ui.a.b.b;
import com.viber.voip.backup.ui.a.c.h;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.af;
import com.viber.voip.util.cj;

public class e extends d<h>
{
  private static final Logger a = ViberEnv.getLogger();
  private final ActivationController b;
  private final com.viber.voip.backup.ui.a.b.e c;
  private a n;
  private com.viber.voip.analytics.story.f.d o;
  private boolean p;

  public e(Context paramContext, h paramh, ActivationController paramActivationController, af paramaf, com.viber.voip.backup.ui.a.b.d paramd, com.viber.voip.backup.ui.a.b.e parame, cj paramcj, b paramb, com.viber.voip.analytics.story.f.d paramd1, com.viber.voip.analytics.story.g.a parama)
  {
    super(paramContext, paramh, paramaf, paramd, paramcj, paramb, parama);
    this.b = paramActivationController;
    this.c = parame;
    this.o = paramd1;
    f();
  }

  private void d()
  {
    this.p = true;
    this.b.setStep(8, true);
  }

  protected void a()
  {
    super.a();
    this.n = new a(this.c);
  }

  public void a(com.viber.voip.backup.ui.a.c.a parama)
  {
    switch (2.a[parama.ordinal()])
    {
    default:
      super.a(parama);
      return;
    case 1:
      this.n.e();
      return;
    case 2:
      d();
      return;
    case 3:
    }
    d();
  }

  protected void b(int paramInt)
  {
    if (!this.p)
      super.b(paramInt);
  }

  protected f.a c()
  {
    return new f.a()
    {
      public void a()
      {
        e.this.l = null;
        e.this.h.c();
        ((h)e.this.d).a(com.viber.voip.backup.ui.a.c.e.a.a);
        ((h)e.this.d).o();
      }

      public void a(com.google.a.a.b.a.a.b.a.a paramAnonymousa, BackupInfo paramAnonymousBackupInfo, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (!paramAnonymousBackupInfo.isBackupExists()))
          ((h)e.this.d).a(paramAnonymousa.c());
      }
    };
  }

  public void e()
  {
    super.e();
    this.n.h();
  }

  public void i()
  {
    super.i();
    this.n.f();
  }

  private class a extends a
  {
    com.viber.voip.backup.ui.a.b.e a;
    private com.viber.voip.backup.ui.a.b.e.a c = new com.viber.voip.backup.ui.a.b.e.a()
    {
      public void a()
      {
        e.b(e.this);
      }

      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
        if (t.h(paramAnonymousUri) == 2)
        {
          ((h)e.this.d).a(paramAnonymousInt);
          return;
        }
        ((h)e.this.d).b(paramAnonymousInt);
      }

      public void b()
      {
        e.a.a(e.a.this, false);
        ((h)e.this.d).i();
      }

      public void c()
      {
        e.a.a(e.a.this, false);
        ((h)e.this.d).j();
      }
    };

    public a(com.viber.voip.backup.ui.a.b.e arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    private void a(boolean paramBoolean)
    {
      h localh = (h)e.this.d;
      if (paramBoolean);
      for (com.viber.voip.backup.ui.a.c.e.a locala = com.viber.voip.backup.ui.a.c.e.a.g; ; locala = com.viber.voip.backup.ui.a.c.e.a.d)
      {
        localh.a(locala);
        return;
      }
    }

    private void i()
    {
      if (e.this.h())
      {
        BackupInfo localBackupInfo = e.this.f.a();
        if (localBackupInfo.isBackupExists())
        {
          this.a.a(e.this.i.g(), e.this.i.l(), localBackupInfo.getDriveFileId(), e.this.l, false);
          a(true);
          e.a(e.this).b();
        }
      }
      else
      {
        return;
      }
      ((h)e.this.d).i();
    }

    protected void c()
    {
      ((h)e.this.d).a(com.viber.voip.backup.ui.a.c.e.a.d);
    }

    protected void d()
    {
      i();
    }

    public void f()
    {
      if (this.a.a(this.c))
        g();
    }

    public void g()
    {
      boolean bool = this.a.b();
      if (bool)
        a(bool);
      while (this.a.a())
        return;
      ((h)e.this.d).i();
    }

    public void h()
    {
      this.a.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.a.e
 * JD-Core Version:    0.6.2
 */