package android.arch.lifecycle;

import android.arch.a.b.a;
import android.arch.a.b.b.d;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class i extends e
{
  private a<g, a> a = new a();
  private e.b b;
  private final WeakReference<h> c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ArrayList<e.b> g = new ArrayList();

  public i(h paramh)
  {
    this.c = new WeakReference(paramh);
    this.b = e.b.b;
  }

  static e.b a(e.b paramb1, e.b paramb2)
  {
    if ((paramb2 != null) && (paramb2.compareTo(paramb1) < 0))
      return paramb2;
    return paramb1;
  }

  private void a(h paramh)
  {
    b.d locald = this.a.c();
    while ((locald.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)locald.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) < 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        c(locala.a);
        locala.a(paramh, e(locala.a));
        c();
      }
    }
  }

  static e.b b(e.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected event value " + parama);
    case 1:
    case 2:
      return e.b.c;
    case 3:
    case 4:
      return e.b.d;
    case 5:
      return e.b.e;
    case 6:
    }
    return e.b.a;
  }

  private void b(e.b paramb)
  {
    if (this.b == paramb)
      return;
    this.b = paramb;
    if ((this.e) || (this.d != 0))
    {
      this.f = true;
      return;
    }
    this.e = true;
    d();
    this.e = false;
  }

  private void b(h paramh)
  {
    Iterator localIterator = this.a.b();
    while ((localIterator.hasNext()) && (!this.f))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a locala = (a)localEntry.getValue();
      while ((locala.a.compareTo(this.b) > 0) && (!this.f) && (this.a.c(localEntry.getKey())))
      {
        e.a locala1 = d(locala.a);
        c(b(locala1));
        locala.a(paramh, locala1);
        c();
      }
    }
  }

  private boolean b()
  {
    if (this.a.a() == 0)
      return true;
    e.b localb1 = ((a)this.a.d().getValue()).a;
    e.b localb2 = ((a)this.a.e().getValue()).a;
    if ((localb1 == localb2) && (this.b == localb2));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private e.b c(g paramg)
  {
    Map.Entry localEntry = this.a.d(paramg);
    e.b localb1;
    if (localEntry != null)
    {
      localb1 = ((a)localEntry.getValue()).a;
      if (this.g.isEmpty())
        break label76;
    }
    label76: for (e.b localb2 = (e.b)this.g.get(-1 + this.g.size()); ; localb2 = null)
    {
      return a(a(this.b, localb1), localb2);
      localb1 = null;
      break;
    }
  }

  private void c()
  {
    this.g.remove(-1 + this.g.size());
  }

  private void c(e.b paramb)
  {
    this.g.add(paramb);
  }

  private static e.a d(e.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected state value " + paramb);
    case 1:
      throw new IllegalArgumentException();
    case 2:
      return e.a.ON_DESTROY;
    case 3:
      return e.a.ON_STOP;
    case 4:
      return e.a.ON_PAUSE;
    case 5:
    }
    throw new IllegalArgumentException();
  }

  private void d()
  {
    h localh = (h)this.c.get();
    if (localh == null)
    {
      Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
      return;
    }
    while (!b())
    {
      this.f = false;
      if (this.b.compareTo(((a)this.a.d().getValue()).a) < 0)
        b(localh);
      Map.Entry localEntry = this.a.e();
      if ((!this.f) && (localEntry != null) && (this.b.compareTo(((a)localEntry.getValue()).a) > 0))
        a(localh);
    }
    this.f = false;
  }

  private static e.a e(e.b paramb)
  {
    switch (1.b[paramb.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected state value " + paramb);
    case 1:
    case 5:
      return e.a.ON_CREATE;
    case 2:
      return e.a.ON_START;
    case 3:
      return e.a.ON_RESUME;
    case 4:
    }
    throw new IllegalArgumentException();
  }

  public e.b a()
  {
    return this.b;
  }

  public void a(e.a parama)
  {
    b(b(parama));
  }

  public void a(e.b paramb)
  {
    b(paramb);
  }

  public void a(g paramg)
  {
    e.b localb1;
    a locala;
    if (this.b == e.b.a)
    {
      localb1 = e.b.a;
      locala = new a(paramg, localb1);
      if ((a)this.a.a(paramg, locala) == null)
        break label47;
    }
    label47: h localh;
    do
    {
      return;
      localb1 = e.b.b;
      break;
      localh = (h)this.c.get();
    }
    while (localh == null);
    if ((this.d != 0) || (this.e));
    for (int i = 1; ; i = 0)
    {
      e.b localb2 = c(paramg);
      this.d = (1 + this.d);
      while ((locala.a.compareTo(localb2) < 0) && (this.a.c(paramg)))
      {
        c(locala.a);
        locala.a(localh, e(locala.a));
        c();
        localb2 = c(paramg);
      }
    }
    if (i == 0)
      d();
    this.d = (-1 + this.d);
  }

  public void b(g paramg)
  {
    this.a.b(paramg);
  }

  static class a
  {
    e.b a;
    GenericLifecycleObserver b;

    a(g paramg, e.b paramb)
    {
      this.b = k.a(paramg);
      this.a = paramb;
    }

    void a(h paramh, e.a parama)
    {
      e.b localb = i.b(parama);
      this.a = i.a(this.a, localb);
      this.b.a(paramh, parama);
      this.a = localb;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.i
 * JD-Core Version:    0.6.2
 */