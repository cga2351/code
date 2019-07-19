package com.viber.voip.messages.controller.manager;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.viber.common.a.e;
import com.viber.jni.slashkey.SlashKeyAdapterErrorCode;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.a;
import com.viber.voip.messages.controller.bv.b;
import com.viber.voip.messages.controller.bv.c;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.f;
import com.viber.voip.messages.controller.bv.g;
import com.viber.voip.messages.controller.bv.h;
import com.viber.voip.messages.controller.bv.i;
import com.viber.voip.messages.controller.bv.j;
import com.viber.voip.messages.controller.bv.k;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.bv.o;
import com.viber.voip.messages.controller.bv.p;
import com.viber.voip.messages.controller.bv.r;
import com.viber.voip.messages.controller.bv.s;
import com.viber.voip.messages.controller.bv.u;
import com.viber.voip.messages.controller.bv.v;
import com.viber.voip.messages.controller.cf;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.a.a;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.m;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class o
  implements bv
{
  private static final e a = ViberEnv.getLogger();
  private static o b;
  private Map<bv.e, Handler> c = new HashMap();
  private Map<bv.l, Handler> d = new HashMap();
  private Map<bv.m, Handler> e = new HashMap();
  private Set<bv.n> f = new HashSet();
  private Map<bv.h, Handler> g = new HashMap();
  private Set<bv.c> h = new HashSet();
  private Set<bv.i> i = new HashSet();
  private Set<bv.o> j = new HashSet();
  private Set<bv.j> k = new HashSet();
  private Map<bv.r, Handler> l = new HashMap();
  private Set<bv.v> m = new HashSet();
  private Set<bv.k> n = new HashSet();
  private Set<bv.a> o = new HashSet();
  private Set<bv.s> p = new HashSet();
  private Set<bv.f> q = new HashSet();
  private Set<bv.b> r = new HashSet();
  private final Object s = new Object();
  private final Set<Long> t = new HashSet();

  @SuppressLint({"UseSparseArrays"})
  private Map<Integer, cf> u = new HashMap();
  private Handler v = av.a(av.e.d);

  @Deprecated
  public static o a()
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new o();
      return b;
    }
    finally
    {
    }
  }

  private void a(final a parama)
  {
    Iterator localIterator = m().iterator();
    while (localIterator.hasNext())
    {
      final bv.c localc = (bv.c)localIterator.next();
      if ((localc instanceof bv.g))
        parama.a(localc);
      else
        this.v.post(new Runnable()
        {
          public void run()
          {
            parama.a(localc);
          }
        });
    }
  }

  private void a(b paramb)
  {
    Iterator localIterator = i().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bv.e locale = (bv.e)localEntry.getKey();
      ((Handler)localEntry.getValue()).post(new v(paramb, locale));
    }
  }

  private void a(final c paramc)
  {
    Iterator localIterator = p().iterator();
    while (localIterator.hasNext())
    {
      final bv.f localf = (bv.f)localIterator.next();
      this.v.post(new Runnable()
      {
        public void run()
        {
          paramc.a(localf);
        }
      });
    }
  }

  private void a(d paramd)
  {
    Iterator localIterator = l().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bv.h localh = (bv.h)localEntry.getKey();
      ((Handler)localEntry.getValue()).post(new u(paramd, localh));
    }
  }

  private void a(e parame)
  {
    Iterator localIterator = b().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bv.m localm = (bv.m)localEntry.getKey();
      ((Handler)localEntry.getValue()).post(new t(parame, localm));
    }
  }

  private void a(f paramf)
  {
    Iterator localIterator = j().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bv.l locall = (bv.l)localEntry.getKey();
      ((Handler)localEntry.getValue()).post(new s(paramf, locall));
    }
  }

  private void a(final g paramg)
  {
    Iterator localIterator = k().iterator();
    while (localIterator.hasNext())
    {
      final bv.n localn = (bv.n)localIterator.next();
      this.v.post(new Runnable()
      {
        public void run()
        {
          paramg.a(localn);
        }
      });
    }
  }

  private void a(final h paramh)
  {
    Iterator localIterator = o().iterator();
    while (localIterator.hasNext())
    {
      final bv.o localo = (bv.o)localIterator.next();
      if ((localo instanceof bv.p))
        paramh.a(localo);
      else
        this.v.post(new Runnable()
        {
          public void run()
          {
            paramh.a(localo);
          }
        });
    }
  }

  private void a(i parami)
  {
    Iterator localIterator = r().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bv.r localr = (bv.r)localEntry.getKey();
      ((Handler)localEntry.getValue()).post(new w(parami, localr));
    }
  }

  private void a(final j paramj)
  {
    Iterator localIterator = u().iterator();
    while (localIterator.hasNext())
    {
      final bv.v localv = (bv.v)localIterator.next();
      this.v.post(new Runnable()
      {
        public void run()
        {
          paramj.a(localv);
        }
      });
    }
  }

  private Map<bv.e, Handler> i()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.c);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Map<bv.l, Handler> j()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.d);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.n> k()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.f);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Map<bv.h, Handler> l()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.g);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.c> m()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.h);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.i> n()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.i);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.o> o()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.j);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.f> p()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.q);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.j> q()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.k);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Map<bv.r, Handler> r()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.l);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.k> s()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.n);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.b> t()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.r);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.v> u()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.m);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.a> v()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.o);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private Set<bv.s> w()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.p);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(final int paramInt)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupInfoUpdateStarted(paramInt);
      }
    });
  }

  public void a(final int paramInt1, final int paramInt2)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onPublicGroupInfoUpdateError(paramInt1, paramInt2);
      }
    });
  }

  public void a(final int paramInt1, final int paramInt2, final long paramLong, List<com.viber.voip.messages.conversation.w> paramList, final Set<String> paramSet)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.a(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.i)localIterator.next()).a(paramInt1, paramInt2, paramLong, paramSet, this.e);
      }
    });
  }

  public void a(final int paramInt1, final int paramInt2, final Map<String, Integer> paramMap)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupCreateError(paramInt1, paramInt2, paramMap);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, int paramInt2)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupRenamed(paramInt1, paramLong, this.c);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, int paramInt2, final int paramInt3)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onPublicGroupInfoChanged(paramInt1, paramLong, paramInt3, this.d);
      }
    });
  }

  public void a(final int paramInt1, final long paramLong, int paramInt2, final Map<String, Integer> paramMap)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onMembersAddedToGroup(paramInt1, paramLong, paramMap, this.d);
      }
    });
  }

  public void a(final int paramInt, final long paramLong1, long paramLong2, final String paramString1, Map<String, Integer> paramMap, final String paramString2, final String paramString3)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onPublicGroupCreated(paramInt, paramLong1, paramString1, paramString2, paramString3, this.f, this.g);
      }
    });
  }

  public void a(final int paramInt, final long paramLong1, long paramLong2, final Map<String, Integer> paramMap, boolean paramBoolean)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupCreated(paramInt, paramLong1, paramMap, this.d, this.e);
      }
    });
  }

  public void a(final int paramInt1, final String[] paramArrayOfString, final int paramInt2, final Map<String, Integer> paramMap)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onAssignRole(paramInt1, paramArrayOfString, paramInt2, paramMap);
      }
    });
  }

  public void a(final long paramLong, int paramInt)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onValidateGroupUriReply(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong, int paramInt, final boolean paramBoolean)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onReadOutgoing(paramLong, paramBoolean, this.c);
      }
    });
  }

  public void a(final long paramLong, int paramInt, final String[] paramArrayOfString, final Map<String, Integer> paramMap)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onMembersRemovedFromGroup(paramLong, paramArrayOfString, paramMap, this.d);
      }
    });
  }

  public void a(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.a(paramLong1, paramBoolean, this.c);
      }
    });
  }

  public void a(final long paramLong, Set<Long> paramSet)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.a(paramLong, this.b);
      }
    });
  }

  public void a(final long paramLong1, boolean paramBoolean, final long paramLong2)
  {
    a(new a()
    {
      public void a(bv.c paramAnonymousc)
      {
        paramAnonymousc.a(paramLong1, paramLong2, this.c);
      }
    });
  }

  public void a(bv.a parama)
  {
    this.o.add(parama);
  }

  public void a(bv.b paramb)
  {
    this.r.add(paramb);
  }

  public void a(bv.c paramc)
  {
    try
    {
      this.h.add(paramc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.e parame)
  {
    try
    {
      this.c.put(parame, this.v);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.e parame, Handler paramHandler)
  {
    this.c.put(parame, paramHandler);
  }

  public void a(bv.f paramf)
  {
    try
    {
      this.q.add(paramf);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.h paramh)
  {
    try
    {
      this.g.put(paramh, this.v);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.h paramh, Handler paramHandler)
  {
    try
    {
      this.g.put(paramh, paramHandler);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.i parami)
  {
    this.i.add(parami);
  }

  public void a(bv.j paramj)
  {
    this.k.add(paramj);
  }

  public void a(bv.k paramk)
  {
    this.n.add(paramk);
  }

  public void a(bv.l paraml)
  {
    try
    {
      this.d.put(paraml, this.v);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.l paraml, Handler paramHandler)
  {
    try
    {
      this.d.put(paraml, paramHandler);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.m paramm)
  {
    this.e.put(paramm, this.v);
  }

  public void a(bv.m paramm, Handler paramHandler)
  {
    this.e.put(paramm, paramHandler);
  }

  public void a(bv.n paramn)
  {
    try
    {
      this.f.add(paramn);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(bv.o paramo)
  {
    this.j.add(paramo);
  }

  public void a(bv.r paramr)
  {
    this.l.put(paramr, this.v);
  }

  public void a(bv.r paramr, Handler paramHandler)
  {
    this.l.put(paramr, paramHandler);
  }

  public void a(bv.s params)
  {
    this.p.add(params);
  }

  public void a(final ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onOpenConversation(paramConversationItemLoaderEntity);
      }
    });
  }

  public void a(final MessageEntity paramMessageEntity, final int paramInt)
  {
    a(new e()
    {
      public void a(bv.m paramAnonymousm)
      {
        paramAnonymousm.a(paramMessageEntity, paramInt);
      }
    });
  }

  public void a(final MessageEntity paramMessageEntity, final boolean paramBoolean)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.a(paramMessageEntity, paramBoolean);
      }
    });
  }

  public void a(final m paramm)
  {
    a(new g()
    {
      public void a(bv.n paramAnonymousn)
      {
        paramAnonymousn.onParticipantDeleted(paramm);
      }
    });
  }

  public void a(final String paramString)
  {
    a(new h()
    {
      public void a(bv.o paramAnonymouso)
      {
        paramAnonymouso.a(paramString);
      }
    });
  }

  public void a(final String paramString, final int paramInt)
  {
    a(new i()
    {
      public void a(bv.r paramAnonymousr)
      {
        paramAnonymousr.a(paramString, paramInt);
      }
    });
  }

  public void a(final String paramString, final BotReplyConfig paramBotReplyConfig)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.d(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.a)localIterator.next()).a(paramString, paramBotReplyConfig);
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final boolean paramBoolean)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.d(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.a)localIterator.next()).a(paramString1, paramString2, paramBoolean);
      }
    });
  }

  public void a(final String paramString1, final String paramString2, final d[] paramArrayOfd, @SlashKeyAdapterErrorCode final String paramString3)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.c(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.k)localIterator.next()).a(paramString1, paramString2, paramArrayOfd, paramString3);
      }
    });
  }

  public void a(final List<m> paramList, final boolean paramBoolean)
  {
    a(new g()
    {
      public void a(bv.n paramAnonymousn)
      {
        paramAnonymousn.onNewInfo(paramList, paramBoolean);
      }
    });
  }

  public void a(final Map<Long, bv.n.a> paramMap)
  {
    a(new g()
    {
      public void a(bv.n paramAnonymousn)
      {
        paramAnonymousn.onContactStatusChanged(paramMap);
      }
    });
  }

  public void a(final Set<String> paramSet)
  {
    a(new c()
    {
      public void a(bv.f paramAnonymousf)
      {
        paramAnonymousf.a(paramSet);
      }
    });
  }

  public void a(final Set<Long> paramSet, final int paramInt, final boolean paramBoolean)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onRead(paramSet, paramInt, paramBoolean);
      }
    });
  }

  public void a(Set<Long> paramSet, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    if (paramSet != null);
    for (Object localObject = paramSet; ; localObject = Collections.emptySet())
    {
      a(new b()
      {
        public void a(bv.e paramAnonymouse)
        {
          paramAnonymouse.onChange(this.a, paramInt, paramBoolean1, paramBoolean2);
        }
      });
      return;
    }
  }

  public void a(final Set<Long> paramSet, final Set<String> paramSet1, final boolean paramBoolean)
  {
    a(new g()
    {
      public void a(bv.n paramAnonymousn)
      {
        paramAnonymousn.onChange(paramSet, paramSet1, paramBoolean);
      }
    });
  }

  public void a(final Set<Long> paramSet, final boolean paramBoolean)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.a(paramSet, paramBoolean);
      }
    });
  }

  public void a(final Set<Long> paramSet, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.a(paramSet, paramBoolean1, paramBoolean2);
      }
    });
  }

  public void a(final boolean paramBoolean)
  {
    a(new j()
    {
      public void a(bv.v paramAnonymousv)
      {
        paramAnonymousv.a(paramBoolean);
      }
    });
  }

  public void a(final boolean paramBoolean, final long paramLong)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onConversationClosed(paramBoolean, paramLong);
      }
    });
  }

  public boolean a(long paramLong)
  {
    synchronized (this.s)
    {
      boolean bool = this.t.contains(Long.valueOf(paramLong));
      return bool;
    }
  }

  public boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    synchronized (this.s)
    {
      Iterator localIterator = this.u.values().iterator();
      while (localIterator.hasNext())
      {
        cf localcf = (cf)localIterator.next();
        if ((localcf.a == paramLong) && (a.b(paramInt1, paramInt2, localcf.b)))
          return true;
      }
      return false;
    }
  }

  public Map<bv.m, Handler> b()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.e);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(final int paramInt)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onPublicGroupSyncRequestCanceled(paramInt);
      }
    });
  }

  public void b(final int paramInt1, final int paramInt2)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        if ((paramAnonymoush instanceof bv.u))
          ((bv.u)paramAnonymoush).onPublicGroupCreateError(paramInt1, paramInt2);
      }
    });
  }

  public void b(final int paramInt1, final long paramLong, int paramInt2)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupIconChanged(paramInt1, paramLong, this.c);
      }
    });
  }

  public void b(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    a(new q(paramInt1, paramLong, paramInt2, paramInt3));
  }

  public void b(long paramLong)
  {
    a(new r(paramLong));
  }

  public void b(final long paramLong, int paramInt)
  {
    a(new d()
    {
      public void a(bv.h paramAnonymoush)
      {
        paramAnonymoush.onGroupUnknownChanged(paramLong, this.b);
      }
    });
  }

  public void b(final long paramLong1, long paramLong2, final boolean paramBoolean)
  {
    a(new f()
    {
      public void a(bv.l paramAnonymousl)
      {
        paramAnonymousl.b(paramLong1, paramBoolean, this.c);
      }
    });
  }

  public void b(final long paramLong, Set<Long> paramSet)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onOpenPublicGroup(paramLong, this.b);
      }
    });
  }

  public void b(bv.a parama)
  {
    this.o.remove(parama);
  }

  public void b(bv.b paramb)
  {
    this.r.remove(paramb);
  }

  public void b(bv.c paramc)
  {
    try
    {
      this.h.remove(paramc);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(bv.e parame)
  {
    try
    {
      this.c.remove(parame);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(bv.h paramh)
  {
    try
    {
      this.g.remove(paramh);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(bv.i parami)
  {
    this.i.remove(parami);
  }

  public void b(bv.j paramj)
  {
    this.k.remove(paramj);
  }

  public void b(bv.k paramk)
  {
    this.n.remove(paramk);
  }

  public void b(bv.l paraml)
  {
    try
    {
      this.d.remove(paraml);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(bv.m paramm)
  {
    this.e.remove(paramm);
  }

  public void b(bv.n paramn)
  {
    try
    {
      this.f.remove(paramn);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(bv.r paramr)
  {
    this.l.remove(paramr);
  }

  public void b(bv.s params)
  {
    this.p.remove(params);
  }

  public void b(final String paramString)
  {
    a(new i()
    {
      public void a(bv.r paramAnonymousr)
      {
        paramAnonymousr.a(paramString);
      }
    });
  }

  public void b(final Set<Long> paramSet, final int paramInt, final boolean paramBoolean)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onDelete(paramSet, paramInt, paramBoolean);
      }
    });
  }

  public void b(final Set<Long> paramSet, final boolean paramBoolean)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onOpen1to1(paramSet, paramBoolean);
      }
    });
  }

  public void c()
  {
    a(new g()
    {
      public void a(bv.n paramAnonymousn)
      {
        paramAnonymousn.onInitCache();
      }
    });
  }

  public void c(final int paramInt1, final long paramLong, int paramInt2)
  {
    synchronized (this.s)
    {
      this.u.put(Integer.valueOf(paramInt1), new cf(paramLong, paramInt2));
      this.t.add(Long.valueOf(paramLong));
      a(new d()
      {
        public void a(bv.h paramAnonymoush)
        {
          if ((paramAnonymoush instanceof bv.u))
            ((bv.u)paramAnonymoush).onPublicGroupSyncStarted(paramInt1, paramLong);
        }
      });
      return;
    }
  }

  public void c(final long paramLong)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.b(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.j)localIterator.next()).a(paramLong);
      }
    });
  }

  public void c(final String paramString)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.d(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.a)localIterator.next()).a(paramString);
      }
    });
  }

  public void c(Set<Long> paramSet, boolean paramBoolean)
  {
    a(paramSet, new HashSet(0), paramBoolean);
  }

  public boolean c(long paramLong, int paramInt)
  {
    synchronized (this.s)
    {
      Iterator localIterator = this.u.values().iterator();
      while (localIterator.hasNext())
      {
        cf localcf = (cf)localIterator.next();
        if ((localcf.a == paramLong) && (a.d(paramInt, localcf.b)))
          return true;
      }
      return false;
    }
  }

  public void d()
  {
    a(new h()
    {
      public void a(bv.o paramAnonymouso)
      {
        paramAnonymouso.a();
      }
    });
  }

  public void d(int paramInt1, long paramLong, int paramInt2)
  {
    synchronized (this.s)
    {
      this.u.put(Integer.valueOf(paramInt1), new cf(paramLong, paramInt2));
      a(new p(paramInt1, paramLong));
      return;
    }
  }

  public void d(final long paramLong, int paramInt)
  {
    a(new b()
    {
      public void a(bv.e paramAnonymouse)
      {
        paramAnonymouse.onWatchersCountChange(paramLong, this.b);
      }
    });
  }

  public void e()
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.b(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.j)localIterator.next()).a();
      }
    });
  }

  public void e(final int paramInt1, final long paramLong, int paramInt2)
  {
    synchronized (this.s)
    {
      this.u.remove(Integer.valueOf(paramInt1));
      this.t.remove(Long.valueOf(paramLong));
      a(new d()
      {
        public void a(bv.h paramAnonymoush)
        {
          if ((paramAnonymoush instanceof bv.u))
            ((bv.u)paramAnonymoush).onPublicGroupSyncFinished(paramInt1, paramLong, this.c);
        }
      });
      return;
    }
  }

  public void f()
  {
    av.a(av.e.a).post(new x(this));
  }

  public void g()
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = o.e(o.this).iterator();
        while (localIterator.hasNext())
          ((bv.s)localIterator.next()).T_();
      }
    });
  }

  private static abstract interface a
  {
    public abstract void a(bv.c paramc);
  }

  private static abstract interface b
  {
    public abstract void a(bv.e parame);
  }

  private static abstract interface c
  {
    public abstract void a(bv.f paramf);
  }

  private static abstract interface d
  {
    public abstract void a(bv.h paramh);
  }

  private static abstract interface e
  {
    public abstract void a(bv.m paramm);
  }

  private static abstract interface f
  {
    public abstract void a(bv.l paraml);
  }

  private static abstract interface g
  {
    public abstract void a(bv.n paramn);
  }

  private static abstract interface h
  {
    public abstract void a(bv.o paramo);
  }

  private static abstract interface i
  {
    public abstract void a(bv.r paramr);
  }

  private static abstract interface j
  {
    public abstract void a(bv.v paramv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.o
 * JD-Core Version:    0.6.2
 */