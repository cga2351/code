package com.viber.voip.backup.ui.a.a;

import android.content.res.Resources;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.ui.a.b.b;
import com.viber.voip.backup.ui.a.b.d.a;
import com.viber.voip.backup.ui.a.c.e;
import com.viber.voip.backup.ui.a.c.e.a;
import com.viber.voip.registration.af;
import com.viber.voip.util.cj;

public class f extends a
{
  private static final Logger a = ViberEnv.getLogger();
  private final e b;
  private final com.viber.voip.backup.ui.a.b.d c;
  private final b d;
  private final af e;
  private final cj f;
  private final Resources g;
  private final a h;
  private final d.a i = new d.a()
  {
    public void a()
    {
      f.this.c();
    }

    public void a(int paramAnonymousInt)
    {
      f.a(f.this);
    }

    public void a(int paramAnonymousInt1, com.google.a.a.b.a.a.b.a.d paramAnonymousd, int paramAnonymousInt2)
    {
      f.d(f.this).a(paramAnonymousInt2, paramAnonymousd);
    }

    public void b()
    {
      f.e(f.this);
    }

    public void b(int paramAnonymousInt)
    {
      f.this.b();
      f.c(f.this).a(f.b(f.this).getString(R.string.google_play_services_unavailable_message));
    }
  };

  public f(e parame, com.viber.voip.backup.ui.a.b.d paramd, b paramb, af paramaf, cj paramcj, Resources paramResources, a parama)
  {
    this.b = parame;
    this.c = paramd;
    this.d = paramb;
    this.e = paramaf;
    this.f = paramcj;
    this.g = paramResources;
    this.h = parama;
  }

  private void a(BackupInfo paramBackupInfo)
  {
    this.b.b(paramBackupInfo);
    this.b.a(e.a.d);
  }

  private void a(boolean paramBoolean)
  {
    if (f())
    {
      com.google.a.a.b.a.a.b.a.a locala = this.d.e();
      if (locala.b() != null)
      {
        BackupInfo localBackupInfo = this.c.a();
        if (localBackupInfo.isBackupExists())
          a(localBackupInfo);
        while (true)
        {
          this.h.a(locala, localBackupInfo, paramBoolean);
          return;
          h();
        }
      }
      i();
      return;
    }
    i();
  }

  private boolean f()
  {
    return this.d.h();
  }

  private void g()
  {
    this.c.a(this.i);
    if (this.f.a() != -1)
    {
      if (!this.c.a(this.e.g()))
        c();
      return;
    }
    j();
  }

  private void h()
  {
    this.b.a(e.a.c);
  }

  private void i()
  {
    this.b.a(e.a.a);
  }

  private void j()
  {
    if (!this.c.a().isBackupExists())
      this.h.a();
  }

  protected void b()
  {
    h();
  }

  protected void c()
  {
    a(true);
  }

  protected void d()
  {
    if (f())
    {
      a(false);
      g();
      return;
    }
    i();
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(com.google.a.a.b.a.a.b.a.a parama, BackupInfo paramBackupInfo, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.a.f
 * JD-Core Version:    0.6.2
 */