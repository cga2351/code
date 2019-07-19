package com.viber.voip.backup.ui.a.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import com.viber.voip.backup.ui.a.b.d;
import com.viber.voip.backup.ui.a.c.e.a;
import com.viber.voip.registration.af;
import com.viber.voip.util.cj;

public class c extends b<com.viber.voip.backup.ui.a.c.c>
{
  private static final Logger n = ViberEnv.getLogger();
  private a o;

  public c(Context paramContext, com.viber.voip.backup.ui.a.c.c paramc, af paramaf, com.viber.voip.backup.ui.a.b.c paramc1, d paramd, cj paramcj, com.viber.voip.backup.ui.a.b.b paramb, com.viber.voip.backup.b paramb1, com.viber.voip.analytics.story.g.a parama)
  {
    super(paramContext, paramc, paramaf, paramd, paramcj, paramb, paramb1, parama, paramc1);
    f();
  }

  protected void a()
  {
    this.o = new a(null);
    super.a();
  }

  public void a(com.viber.voip.backup.ui.a.c.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      super.a(parama);
      return;
    case 1:
    }
    this.o.e();
  }

  private class a extends a
  {
    private a()
    {
    }

    private void f()
    {
      if (c.this.h())
      {
        BackupInfo localBackupInfo = c.this.f.a();
        if (localBackupInfo.isBackupExists())
          ((com.viber.voip.backup.ui.a.c.c)c.this.d).a(localBackupInfo);
      }
    }

    protected void c()
    {
      ((com.viber.voip.backup.ui.a.c.c)c.this.d).a(e.a.d);
    }

    protected void d()
    {
      f();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.a.c
 * JD-Core Version:    0.6.2
 */