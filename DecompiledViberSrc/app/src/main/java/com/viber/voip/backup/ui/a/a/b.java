package com.viber.voip.backup.ui.a.a;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.c.a;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.t;
import com.viber.voip.backup.ui.a.b.c;
import com.viber.voip.backup.ui.a.b.c.a;
import com.viber.voip.backup.ui.a.c.e.a;
import com.viber.voip.registration.af;
import com.viber.voip.util.cj;

public abstract class b<VIEW extends com.viber.voip.backup.ui.a.c.d> extends d<VIEW>
{
  private static final Logger n = ViberEnv.getLogger();
  protected final com.viber.voip.backup.b a;
  protected final c b;
  protected b<VIEW>.a c;

  public b(Context paramContext, VIEW paramVIEW, af paramaf, com.viber.voip.backup.ui.a.b.d paramd, cj paramcj, com.viber.voip.backup.ui.a.b.b paramb, com.viber.voip.backup.b paramb1, com.viber.voip.analytics.story.g.a parama, c paramc)
  {
    super(paramContext, paramVIEW, paramaf, paramd, paramcj, paramb, parama);
    this.a = paramb1;
    this.b = paramc;
  }

  private void a(Uri paramUri, int paramInt)
  {
    ((com.viber.voip.backup.ui.a.c.d)this.d).a(t.i(paramUri), paramInt);
  }

  private void l()
  {
    this.c.f();
    o();
  }

  private void m()
  {
    ((com.viber.voip.backup.ui.a.c.d)this.d).a(n().d(), com.viber.voip.backup.a.e());
  }

  private com.viber.voip.backup.a n()
  {
    com.viber.voip.backup.a locala = this.a.a();
    if (locala.b())
      return locala;
    return com.viber.voip.backup.a.b;
  }

  private void o()
  {
    ((com.viber.voip.backup.ui.a.c.d)this.d).a(n());
  }

  private void p()
  {
    ((com.viber.voip.backup.ui.a.c.d)this.d).a(this.e.getString(R.string.google_play_services_unavailable_message));
  }

  protected void a()
  {
    super.a();
    this.c = new a(null);
    l();
  }

  public void a(int paramInt)
  {
    com.viber.voip.backup.a locala1 = n();
    com.viber.voip.backup.a locala2 = com.viber.voip.backup.a.a(paramInt);
    this.a.a(locala2);
    o();
    if (locala1 != locala2)
      this.j.a(StoryConstants.c.a.a(locala2), "AutoBackup");
  }

  public void a(com.viber.voip.backup.ui.a.c.a parama)
  {
    switch (3.a[parama.ordinal()])
    {
    default:
      super.a(parama);
      return;
    case 1:
      m();
      return;
    case 2:
      this.c.e();
      return;
    case 3:
    }
    d();
  }

  protected com.viber.voip.backup.ui.a.b.b.a b()
  {
    return new com.viber.voip.backup.ui.a.b.b.a()
    {
      public void a(int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        case 1003:
        default:
          return;
        case 1002:
          b.this.c.g();
          return;
        case 1004:
        }
        b.this.c.h();
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if ((paramAnonymousInt1 == 1002) || (paramAnonymousInt1 == 1004))
        {
          if (paramAnonymousInt2 != 0)
            break label36;
          b.a(b.this);
        }
        while (true)
        {
          b.this.c.b();
          return;
          label36: if (paramAnonymousInt2 == 3)
            ((com.viber.voip.backup.ui.a.c.d)b.this.d).n();
        }
      }
    };
  }

  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (paramInt != 2)
      this.c.i();
  }

  protected f.a c()
  {
    return new f.a()
    {
      public void a()
      {
      }

      public void a(com.google.a.a.b.a.a.b.a.a paramAnonymousa, BackupInfo paramAnonymousBackupInfo, boolean paramAnonymousBoolean)
      {
        b.this.c.f();
      }
    };
  }

  public void d()
  {
    a.a(this.c, false);
  }

  public void e()
  {
    super.e();
    this.c.j();
  }

  private class a extends a
  {
    private boolean b;
    private c.a c = new c.a()
    {
      public void a()
      {
        b.a.this.c();
      }

      public void a(int paramAnonymousInt)
      {
        if (b.a.a(b.a.this, paramAnonymousInt))
          b.a.this.b();
      }

      public void a(Uri paramAnonymousUri, int paramAnonymousInt)
      {
        if (!b.a.a(b.a.this))
          b.a.a(b.a.this, true);
        if (t.h(paramAnonymousUri) == 2)
        {
          b.a(b.this, paramAnonymousUri, paramAnonymousInt);
          return;
        }
        ((com.viber.voip.backup.ui.a.c.d)b.this.d).a(paramAnonymousInt);
      }

      public void a(com.google.a.a.b.a.a.b.a.d paramAnonymousd)
      {
        b.a.this.b();
        b.this.h.a(1004, paramAnonymousd);
      }

      public void b()
      {
        b.a.this.b();
      }
    };

    private a()
    {
    }

    private boolean a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return true;
      case 0:
      case 3:
        ((com.viber.voip.backup.ui.a.c.d)b.this.d).n();
        return true;
      case 1:
        b.this.h.a(1002);
        return false;
      case 2:
        b.a(b.this);
        return true;
      case 4:
      }
      ((com.viber.voip.backup.ui.a.c.d)b.this.d).i();
      return true;
    }

    private void b(boolean paramBoolean)
    {
      this.b = paramBoolean;
      boolean bool1;
      com.viber.voip.backup.ui.a.c.d locald;
      if (!paramBoolean)
      {
        bool1 = true;
        a(bool1);
        if (!paramBoolean)
          break label76;
        boolean bool2 = b.this.f.a().isBackupExists();
        locald = (com.viber.voip.backup.ui.a.c.d)b.this.d;
        if (!bool2)
          break label68;
      }
      label68: for (e.a locala = e.a.f; ; locala = e.a.e)
      {
        locald.a(locala);
        return;
        bool1 = false;
        break;
      }
      label76: if (b.this.f.a().isBackupExists())
      {
        ((com.viber.voip.backup.ui.a.c.d)b.this.d).a(e.a.d);
        return;
      }
      ((com.viber.voip.backup.ui.a.c.d)b.this.d).a(e.a.c);
    }

    public void a(boolean paramBoolean)
    {
      if ((b.this.b.a()) && (paramBoolean))
        paramBoolean = false;
      com.viber.voip.backup.ui.a.c.d locald = (com.viber.voip.backup.ui.a.c.d)b.this.d;
      com.viber.voip.backup.ui.a.c.a[] arrayOfa = new com.viber.voip.backup.ui.a.c.a[3];
      arrayOfa[0] = com.viber.voip.backup.ui.a.c.a.c;
      arrayOfa[1] = com.viber.voip.backup.ui.a.c.a.e;
      arrayOfa[2] = com.viber.voip.backup.ui.a.c.a.f;
      locald.b(paramBoolean, arrayOfa);
    }

    protected void b()
    {
      b(false);
    }

    protected void c()
    {
      b.this.k.e();
      ((com.viber.voip.backup.ui.a.c.d)b.this.d).j();
      ((com.viber.voip.backup.ui.a.c.d)b.this.d).a(e.a.d);
    }

    protected void d()
    {
      g();
    }

    public void f()
    {
      if (b.this.b.b())
      {
        b(true);
        return;
      }
      b.this.d();
    }

    public void g()
    {
      if (b.this.h())
      {
        b(true);
        ((com.viber.voip.backup.ui.a.c.d)b.this.d).a(0);
        if (!b.this.b.b())
        {
          if (b.this.l == null)
            break label85;
          b.this.b.a(b.this.i.l(), b.this.i.g(), 1);
        }
      }
      return;
      label85: b(false);
    }

    public void h()
    {
      g();
    }

    public void i()
    {
      if (b.this.b.a(this.c))
        f();
    }

    public void j()
    {
      b.this.b.c();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.a.b
 * JD-Core Version:    0.6.2
 */