package com.viber.voip.contacts.c.d;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.f.b.c.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.memberid.a.a;
import com.viber.voip.memberid.d;
import com.viber.voip.memberid.d.a;
import com.viber.voip.model.entity.x;
import com.viber.voip.settings.d.ad;
import com.viber.voip.util.cv;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class i
  implements Engine.InitializedListener, g, g.e, c.a
{
  private static final Logger k = ViberEnv.getLogger();
  protected Handler a;
  protected com.viber.voip.contacts.c.a.a b;
  protected Context c;
  protected ViberApplication d;
  protected com.viber.service.contacts.a.a e;
  protected j f;
  protected com.viber.voip.contacts.c.f.b g;
  protected com.viber.voip.contacts.adapters.b h;
  protected final Set<g.b> i = Collections.synchronizedSet(new HashSet());
  protected final Set<g.c> j = Collections.synchronizedSet(new HashSet());
  private final Logger l = ViberEnv.getLogger(getClass());
  private final com.viber.voip.contacts.c.b.a m;
  private final com.viber.voip.contacts.c.b.c n;
  private final Set<g.i> o = new HashSet();
  private final Set<g.f> p = new HashSet();
  private final Set<g.d> q = new HashSet();
  private n.a r;
  private d.a s = new d.a(av.a(av.e.c), false)
  {
    public void a()
    {
      i.a(i.this);
    }
  };
  private a.a t = new a.a(av.a(av.e.c), false)
  {
    public void a()
    {
      i.a(i.this);
    }
  };

  protected i(Context paramContext, ViberApplication paramViberApplication)
  {
    this.c = paramContext;
    this.d = paramViberApplication;
    this.a = av.a(av.e.c);
    this.b = new com.viber.voip.contacts.c.a.b(this.a, new com.viber.voip.contacts.c.a.c(this.c, new com.viber.voip.contacts.c.c.a.a()));
    this.m = new com.viber.voip.contacts.c.b.a(this.c);
    Handler localHandler = this.a;
    com.viber.voip.contacts.c.b.b[] arrayOfb = new com.viber.voip.contacts.c.b.b[1];
    arrayOfb[0] = this.m;
    this.n = new com.viber.voip.contacts.c.b.c(localHandler, arrayOfb);
    this.e = new com.viber.service.contacts.a.a();
    this.f = new j(this.c);
    this.g = com.viber.voip.contacts.c.f.b.a(this.c);
    this.g.a(this);
    this.h = new com.viber.voip.contacts.adapters.b();
    j();
    Engine localEngine = this.d.getEngine(false);
    localEngine.registerDelegate(this.n);
    ConnectionListener localConnectionListener = localEngine.getDelegatesManager().getConnectionListener();
    ConnectionDelegate[] arrayOfConnectionDelegate = new ConnectionDelegate[1];
    arrayOfConnectionDelegate[0] = this.n;
    localConnectionListener.registerDelegate(arrayOfConnectionDelegate);
    this.n.a(localEngine);
    this.r = new n.a()
    {
      boolean a;

      public void onSyncStateChanged(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousInt != 4)
          this.a = true;
        while (!this.a)
          return;
        i.this.l();
      }
    };
    e().a(this.r);
    d.a(this.s);
    d.a(this.t);
  }

  private void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3)
  {
    synchronized (this.o)
    {
      Iterator localIterator = this.o.iterator();
      if (localIterator.hasNext())
        ((g.i)localIterator.next()).a(paramSet1, paramSet2, paramSet3);
    }
  }

  private void b(Map<Member, com.viber.voip.contacts.c.f.b.g.a> paramMap)
  {
    synchronized (this.o)
    {
      Iterator localIterator = this.o.iterator();
      if (localIterator.hasNext())
        ((g.i)localIterator.next()).a(paramMap);
    }
  }

  private void c(Map<String, Long> paramMap)
  {
    synchronized (this.p)
    {
      HashSet localHashSet = new HashSet(this.p);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((g.f)localIterator.next()).a(paramMap);
    }
  }

  private void d(Map<Member, com.viber.voip.contacts.c.f.b.g.a> paramMap)
  {
    if (paramMap.size() > 0)
      b(paramMap);
  }

  private void e(Set<Member> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Member localMember = (Member)localIterator.next();
      com.viber.voip.model.entity.g localg = this.f.c(localMember);
      if (localg != null)
        cv.a().a(localg.getId());
    }
  }

  private boolean s()
  {
    return !d.ad.m.d().equals(Resources.getSystem().getConfiguration().locale.getLanguage());
  }

  private void t()
  {
    d(this.i);
  }

  public void a()
  {
    this.g.b(this);
    e().b(this.r);
    Engine localEngine = this.d.getEngine(false);
    localEngine.removeDelegate(this.n);
    localEngine.getDelegatesManager().getConnectionListener().removeDelegate(this.n);
    localEngine.removeInitializedListener(this);
    this.n.a();
    d().g();
    d.b(this.s);
    d.b(this.t);
    synchronized (this.o)
    {
      this.o.clear();
      synchronized (this.p)
      {
        this.p.clear();
        synchronized (this.q)
        {
          this.q.clear();
          synchronized (this.i)
          {
            this.i.clear();
          }
        }
      }
    }
    synchronized (this.j)
    {
      this.j.clear();
      return;
      localObject1 = finally;
      throw localObject1;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
    }
  }

  public void a(int paramInt)
  {
    c(paramInt, this.j);
  }

  public void a(int paramInt, Set<com.viber.voip.model.i> paramSet)
  {
    cv.a().a(paramSet);
  }

  public void a(final long paramLong)
  {
    this.f.a(paramLong, new j.a()
    {
      public void a()
      {
        com.viber.voip.notif.g.a(i.this.c).a().a(paramLong);
        i.this.g.a();
        i.this.d(i.this.i);
      }
    });
  }

  public void a(long paramLong, String paramString)
  {
    this.f.a(paramLong, paramString);
  }

  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.f.a(paramLong, paramString, paramBoolean, new j.a()
    {
      public void a()
      {
        i.this.d(i.this.i);
      }
    });
  }

  public void a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, g.h paramh)
  {
    h.a(this, paramAccount, paramString1, paramString2, paramString3, paramBitmap, paramh);
  }

  public void a(g.a parama)
  {
    k().a(parama);
  }

  public void a(g.b paramb)
  {
    synchronized (this.i)
    {
      this.i.add(paramb);
      return;
    }
  }

  public void a(g.c paramc)
  {
    synchronized (this.j)
    {
      this.j.add(paramc);
      return;
    }
  }

  public void a(g.d paramd)
  {
    synchronized (this.q)
    {
      this.q.add(paramd);
      return;
    }
  }

  public void a(g.f paramf)
  {
    synchronized (this.p)
    {
      this.p.add(paramf);
      return;
    }
  }

  public void a(g.i parami)
  {
    synchronized (this.o)
    {
      this.o.add(parami);
      return;
    }
  }

  public void a(s params, g.a parama)
  {
    k().a(params, parama);
  }

  protected final void a(HashMap<Long, Long> paramHashMap, Set<Long> paramSet)
  {
    synchronized (this.q)
    {
      HashSet localHashSet = new HashSet(this.q);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((g.d)localIterator.next()).a(paramHashMap, paramSet);
    }
  }

  public void a(Map<String, Long> paramMap)
  {
    c(paramMap);
  }

  public void a(Set<x> paramSet)
  {
    if (paramSet.size() == 0)
      return;
    d().a(paramSet);
    HashSet localHashSet = new HashSet(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
      localHashSet.add(Member.from((x)localIterator.next()));
    a(Collections.emptySet(), localHashSet, Collections.emptySet());
    t();
  }

  public void a(Set<Member> paramSet1, Set<Member> paramSet2, Set<Member> paramSet3, Map<Member, com.viber.voip.contacts.c.f.b.g.a> paramMap)
  {
    d(paramMap);
    k().a(paramSet1, paramSet2, paramSet3);
    a(paramSet1, paramSet2, paramSet3);
    d(this.i);
    e(paramSet3);
  }

  public void b(int paramInt)
  {
    b(paramInt, this.j);
  }

  protected void b(int paramInt, Set<g.c> paramSet)
  {
    try
    {
      HashSet localHashSet = new HashSet(paramSet);
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
        ((g.c)localIterator.next()).b(paramInt);
    }
    finally
    {
    }
  }

  public void b(g.b paramb)
  {
    synchronized (this.i)
    {
      this.i.remove(paramb);
      return;
    }
  }

  public void b(g.c paramc)
  {
    synchronized (this.j)
    {
      this.j.remove(paramc);
      return;
    }
  }

  public void b(g.f paramf)
  {
    synchronized (this.p)
    {
      this.p.remove(paramf);
      return;
    }
  }

  protected final void b(Set<Long> paramSet)
  {
    synchronized (this.q)
    {
      HashSet localHashSet = new HashSet(this.q);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((g.d)localIterator.next()).a(paramSet);
    }
  }

  public m c()
  {
    return this.f;
  }

  protected void c(int paramInt, Set<g.c> paramSet)
  {
    try
    {
      HashSet localHashSet = new HashSet(paramSet);
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
        ((g.c)localIterator.next()).c_(paramInt);
    }
    finally
    {
    }
  }

  protected void c(Set<g.c> paramSet)
  {
    try
    {
      HashSet localHashSet = new HashSet(paramSet);
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
        ((g.c)localIterator.next()).d();
    }
    finally
    {
    }
  }

  protected void d(Set<g.b> paramSet)
  {
    try
    {
      HashSet localHashSet = new HashSet(paramSet);
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
        ((g.b)localIterator.next()).a();
    }
    finally
    {
    }
  }

  public n e()
  {
    return com.viber.voip.contacts.c.f.a.a(this.c);
  }

  public com.viber.voip.contacts.c.a.a f()
  {
    return this.b;
  }

  public void g()
  {
    this.f.f();
    com.viber.voip.contacts.c.f.a.a(this.c).e();
    d().e();
  }

  public com.viber.voip.contacts.adapters.b h()
  {
    return this.h;
  }

  public void i()
  {
    if (s())
    {
      d.ad.m.a(Resources.getSystem().getConfiguration().locale.getLanguage());
      this.a.post(new Runnable()
      {
        public void run()
        {
          i.this.c.getContentResolver().query(com.viber.provider.contacts.a.a, null, null, null, null);
          i.this.m();
          i.a(i.this);
          i.this.j();
        }
      });
    }
  }

  public void initialized(Engine paramEngine)
  {
    d().f();
  }

  public void j()
  {
    this.f.a(new j.b()
    {
      public void a(Set<Character> paramAnonymousSet)
      {
        Locale localLocale = i.this.c.getResources().getConfiguration().locale;
        i.this.h.a(paramAnonymousSet, localLocale);
        i.a(i.this);
      }
    });
  }

  protected abstract f k();

  protected void l()
  {
  }

  protected void m()
  {
  }

  public boolean n()
  {
    return false;
  }

  public void o()
  {
    t();
  }

  public void p()
  {
    k().a();
    t();
  }

  public void q()
  {
    c(this.j);
  }

  public void r()
  {
    g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.i
 * JD-Core Version:    0.6.2
 */