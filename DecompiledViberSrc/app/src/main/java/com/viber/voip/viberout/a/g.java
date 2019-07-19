package com.viber.voip.viberout.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.a.b.a.b;
import com.viber.voip.api.a.b.a.l;
import com.viber.voip.viberout.ui.products.account.AccountViewModel;
import com.viber.voip.viberout.ui.products.account.c;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class g
{
  private static final Logger a = ViberEnv.getLogger();
  private final t b;
  private final c c;
  private final List<a> d = new ArrayList();
  private AtomicBoolean e = new AtomicBoolean(false);

  @Inject
  public g(t paramt, c paramc)
  {
    this.b = paramt;
    this.c = paramc;
  }

  public void a()
  {
    if (this.e.get())
      return;
    this.e.set(true);
    this.b.a(new t.a()
    {
      public void a()
      {
        g.a(g.this).set(false);
        g.this.b();
      }

      public void a(l paramAnonymousl, List<b> paramAnonymousList)
      {
        g.a(g.this).set(false);
        g.this.a(g.b(g.this).a(paramAnonymousl, paramAnonymousList));
      }

      public void b()
      {
        g.a(g.this).set(false);
        g.this.c();
      }
    });
  }

  public void a(a parama)
  {
    this.d.add(parama);
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).a(paramAccountViewModel);
  }

  public void b()
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).b();
  }

  public void b(a parama)
  {
    this.d.remove(parama);
  }

  public void c()
  {
    int i = this.d.size();
    for (int j = 0; j < i; j++)
      ((a)this.d.get(j)).c();
  }

  public static abstract interface a
  {
    public abstract void a(AccountViewModel paramAccountViewModel);

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.g
 * JD-Core Version:    0.6.2
 */