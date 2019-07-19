package com.viber.voip.backup.auto;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ViberActionRunner.h;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.i.e;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final cj c;
  private final com.viber.voip.backup.b d;
  private final b e;
  private final d f;
  private final c g;
  private final e h;

  public a(Context paramContext, cj paramcj, com.viber.voip.backup.b paramb, b paramb1, d paramd, c paramc, e parame)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramcj;
    this.d = paramb;
    this.e = paramb1;
    this.f = paramd;
    this.g = paramc;
    this.h = parame;
  }

  private void a(com.viber.voip.backup.a parama)
  {
    if (this.g.a(parama, b()))
      ViberActionRunner.h.a(this.b, parama);
  }

  private long b()
  {
    return this.h.a();
  }

  public void a()
  {
    final com.viber.voip.backup.a locala = this.d.a();
    if (!locala.b());
    do
    {
      do
      {
        return;
        if (!this.f.d())
          break;
      }
      while (this.c.a() != 1);
      a(locala);
      return;
    }
    while (!this.e.a(locala, b()));
    this.c.a(new cj.a()
    {
      public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (paramAnonymousInt1 == 1)
        {
          if (locala == a.a(a.this).a())
            a.a(a.this, locala);
          a.b(a.this).b(this);
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.auto.a
 * JD-Core Version:    0.6.2
 */