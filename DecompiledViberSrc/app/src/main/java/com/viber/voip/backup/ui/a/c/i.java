package com.viber.voip.backup.ui.a.c;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract class i
{
  private static final Logger a = ViberEnv.getLogger();
  protected final b b;
  private Map<a, b> c = new HashMap();

  public i(b.a parama)
  {
    this.b = new b(a.a, parama);
  }

  public b a(a parama)
  {
    b localb = (b)this.c.get(parama);
    if (localb == null)
      localb = this.b;
    return localb;
  }

  public abstract void a();

  public void a(b paramb)
  {
    if (paramb != null)
      this.c.put(paramb.a(), paramb);
  }

  public void a(e.a parama)
  {
    h();
    switch (1.a[parama.ordinal()])
    {
    default:
      return;
    case 1:
      a();
      return;
    case 2:
      b();
      return;
    case 3:
      c();
      return;
    case 4:
      d();
      return;
    case 5:
      e();
      return;
    case 6:
      f();
      return;
    case 7:
    }
    g();
  }

  public abstract void b();

  public abstract void c();

  public abstract void d();

  public abstract void e();

  public abstract void f();

  public abstract void g();

  protected void h()
  {
    Iterator localIterator = this.c.values().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).c(false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.i
 * JD-Core Version:    0.6.2
 */