package com.viber.voip.viberout.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.a.b.a.d;
import com.viber.voip.api.a.b.a.j;
import com.viber.voip.api.a.b.a.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

public class r
{
  private static final Logger a = ViberEnv.getLogger();
  private final t b;
  private final List<a> c = new ArrayList();
  private AtomicBoolean d = new AtomicBoolean(false);

  @Inject
  public r(t paramt)
  {
    this.b = paramt;
  }

  private void b()
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).d();
  }

  public void a()
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).c();
  }

  public void a(a parama)
  {
    this.c.add(parama);
  }

  public void a(String paramString)
  {
    if (this.d.get())
      return;
    this.d.set(true);
    this.b.a(paramString, new t.c()
    {
      public void a()
      {
        r.a(r.this).set(false);
        r.this.a();
      }

      public void a(List<j> paramAnonymousList, List<d> paramAnonymousList1, List<m> paramAnonymousList2)
      {
        r.a(r.this).set(false);
        r.this.a(paramAnonymousList, paramAnonymousList1, paramAnonymousList2);
      }

      public void b()
      {
        r.a(r.this).set(false);
        r.b(r.this);
      }
    });
  }

  public void a(List<j> paramList, List<d> paramList1, List<m> paramList2)
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((a)this.c.get(j)).a(paramList, paramList1, paramList2);
  }

  public void b(a parama)
  {
    this.c.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void a(List<j> paramList, List<d> paramList1, List<m> paramList2);

    public abstract void c();

    public abstract void d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.r
 * JD-Core Version:    0.6.2
 */