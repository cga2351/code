package a.a;

import com.appboy.a;
import com.appboy.a.b;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public final class go
  implements gq
{
  private static final String c = c.a(go.class);
  final ConcurrentHashMap<String, be> a;
  final ConcurrentHashMap<String, be> b;
  private final av d;
  private final dh e;
  private final LinkedBlockingQueue<ch> f;
  private final b g;

  public go(dh paramdh, av paramav, b paramb)
  {
    this.e = paramdh;
    this.d = paramav;
    this.f = new LinkedBlockingQueue(1000);
    this.g = paramb;
    this.a = new ConcurrentHashMap();
    this.b = new ConcurrentHashMap();
  }

  private void d(ch paramch)
  {
    if (this.d.c() != null)
      paramch.a(this.d.c());
    if (this.g.b() != null)
      paramch.b(this.g.b().toString());
    paramch.c("3.2.1");
    paramch.a(di.a());
  }

  public void a(be parambe)
  {
    if (parambe == null)
    {
      c.d(c, "Tried to add null AppboyEvent to dispatch.");
      return;
    }
    this.a.putIfAbsent(parambe.d(), parambe);
  }

  public void a(bi parambi)
  {
    while (true)
    {
      try
      {
        boolean bool = this.b.isEmpty();
        if (bool)
          return;
        c.b(c, "Flushing pending events to dispatcher map");
        Iterator localIterator = this.b.values().iterator();
        if (localIterator.hasNext())
        {
          ((be)localIterator.next()).a(parambi);
          continue;
        }
      }
      finally
      {
      }
      this.a.putAll(this.b);
      this.b.clear();
    }
  }

  public void a(ch paramch)
  {
    if (paramch == null)
      throw new NullPointerException();
    if (e())
    {
      c.c(c, "Network requests are offline, not adding request to queue.");
      return;
    }
    c.b(c, "Adding request to dispatcher with parameters: \n" + dr.a(paramch.g()), false);
    this.f.add(paramch);
  }

  public boolean a()
  {
    return !this.f.isEmpty();
  }

  public ch b()
  {
    return b((ch)this.f.take());
  }

  ch b(ch paramch)
  {
    if (paramch == null)
      paramch = null;
    while (true)
    {
      return paramch;
      try
      {
        d(paramch);
        if (((paramch instanceof cn)) || ((paramch instanceof cf)) || ((paramch instanceof cg)) || ((paramch instanceof cb)))
          continue;
        c(paramch);
      }
      finally
      {
      }
    }
  }

  public void b(be parambe)
  {
    if (parambe == null);
    try
    {
      c.d(c, "Tried to add null AppboyEvent to pending dispatch.");
      while (true)
      {
        return;
        this.b.putIfAbsent(parambe.d(), parambe);
      }
    }
    finally
    {
    }
  }

  public ch c()
  {
    ch localch = (ch)this.f.poll();
    if (localch != null)
      b(localch);
    return localch;
  }

  void c(ch paramch)
  {
    paramch.d(this.d.e());
    paramch.a(this.g.q());
    bl localbl = this.d.b();
    paramch.a(localbl);
    if ((localbl != null) && (localbl.c()))
      this.e.d();
    paramch.a((bo)this.e.b());
    paramch.a(d());
  }

  bb d()
  {
    try
    {
      Collection localCollection = this.a.values();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        be localbe = (be)localIterator.next();
        localArrayList.add(localbe);
        localCollection.remove(localbe);
        c.b(c, "Event dispatched: " + localbe.h() + " with uid: " + localbe.d());
        if (localArrayList.size() >= 32)
          c.c(c, "Max number of events per dispatch reached: 32 . No more events will be included in this dispatch");
      }
      bb localbb = new bb(new HashSet(localArrayList));
      return localbb;
    }
    finally
    {
    }
  }

  boolean e()
  {
    return a.j();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.go
 * JD-Core Version:    0.6.2
 */