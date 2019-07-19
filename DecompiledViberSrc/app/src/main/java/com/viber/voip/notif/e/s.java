package com.viber.voip.notif.e;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.support.v4.util.CircularArray;
import android.support.v4.util.Pair;
import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.c.g;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.MessageEntity.a;
import com.viber.voip.notif.i.b;
import com.viber.voip.notif.i.d;
import com.viber.voip.notif.i.h;
import com.viber.voip.notif.i.i;
import com.viber.voip.notif.i.k;
import com.viber.voip.notif.i.l;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import dagger.a;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public class s
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.SECONDS.toMillis(1L);
  private static final long c = TimeUnit.SECONDS.toMillis(2L);
  private final Context d;
  private final com.viber.voip.notif.d.j e;
  private final a<com.viber.voip.notif.f> f;
  private final com.viber.voip.notif.h.j g;
  private final Handler h;
  private final k i;
  private final a<ab> j;
  private final l k;
  private final CircularArray<com.viber.voip.notif.g.f> l;
  private final com.viber.voip.notif.g.e m;
  private Runnable n;
  private final SparseArrayCompat<ArraySet<Pair<String, Integer>>> o = new SparseArrayCompat();
  private final com.viber.voip.notif.i.e p;
  private final com.viber.voip.notif.i.m q;
  private final d r;
  private final b s;
  private final com.viber.voip.notif.i.c t;
  private final g u;
  private final h v = new h()
  {
    public LongSparseSet a()
    {
      return s.a(s.this).c();
    }

    public void a(final LongSparseSet paramAnonymousLongSparseSet)
    {
      s.b(s.this).postDelayed(new Runnable()
      {
        public void run()
        {
          s.a(s.this, s.a(s.this).a(paramAnonymousLongSparseSet), false, true);
        }
      }
      , s.b());
    }
  };

  s(Context paramContext, com.viber.voip.notif.d.j paramj, a<com.viber.voip.notif.f> parama, Handler paramHandler, CircularArray<com.viber.voip.notif.g.f> paramCircularArray, com.viber.voip.notif.g.e parame, com.viber.voip.notif.h.j paramj1, k paramk, a<ab> parama1, l paraml, com.viber.voip.notif.i.e parame1, com.viber.voip.notif.i.m paramm, d paramd, b paramb, com.viber.voip.notif.i.c paramc, g paramg)
  {
    this.d = paramContext;
    this.e = paramj;
    this.f = parama;
    this.h = paramHandler;
    this.i = paramk;
    this.j = parama1;
    this.k = paraml;
    this.p = parame1;
    this.q = paramm;
    this.r = paramd;
    this.s = paramb;
    this.t = paramc;
    this.l = paramCircularArray;
    this.m = parame;
    this.g = paramj1;
    this.u = paramg;
  }

  private com.viber.voip.notif.c a(com.viber.voip.notif.h.m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.viber.voip.notif.c localc;
    if ((paramBoolean1) && (!paramm.c().isUnsent()))
      localc = com.viber.voip.notif.c.c;
    boolean bool;
    do
    {
      return localc;
      if ((paramBoolean2) || (paramm.h()) || (paramm.c().isSilentMessage()) || (!this.k.a()) || (paramm.c().getMessageSoundOptions() != MessageEntity.a.a))
        break;
      bool = this.u.b(paramm.c().getMessageToken());
      localc = null;
    }
    while (!bool);
    return com.viber.voip.notif.c.d;
  }

  private com.viber.voip.notif.d.e a(com.viber.voip.notif.h.m paramm)
  {
    Object localObject1 = null;
    int i1 = this.l.size();
    int i2 = 0;
    if (i2 < i1)
    {
      com.viber.voip.notif.g.f localf = (com.viber.voip.notif.g.f)this.l.get(i2);
      Object localObject2;
      if (!localf.a(paramm))
        localObject2 = localObject1;
      do
      {
        i2++;
        localObject1 = localObject2;
        break;
        localObject2 = paramm.a(localf, this.m);
      }
      while (localObject2 == null);
      return localObject2;
    }
    return localObject1;
  }

  private void a(int paramInt)
  {
    ArraySet localArraySet;
    synchronized (this.o)
    {
      localArraySet = (ArraySet)this.o.get(paramInt);
      if (localArraySet == null)
        return;
      Iterator localIterator = localArraySet.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (!this.g.b(((Integer)localPair.second).intValue()))
        {
          ((com.viber.voip.notif.f)this.f.get()).a((String)localPair.first, paramInt);
          localIterator.remove();
        }
      }
    }
    if (localArraySet.isEmpty())
      this.o.remove(paramInt);
  }

  private void a(CircularArray<com.viber.voip.notif.h.m> paramCircularArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCircularArray.size() == 0);
    while (true)
    {
      return;
      if (paramCircularArray.size() == 1)
      {
        com.viber.voip.notif.h.m localm2 = (com.viber.voip.notif.h.m)paramCircularArray.getFirst();
        com.viber.voip.notif.d.e locale2 = a(localm2);
        if (locale2 != null)
          a(locale2, localm2, a(localm2, paramBoolean1, paramBoolean2), paramBoolean2);
      }
      else
      {
        SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat(paramCircularArray.size());
        LongSparseSet localLongSparseSet = new LongSparseSet(paramCircularArray.size());
        int i1 = paramCircularArray.size();
        for (int i2 = 0; i2 < i1; i2++)
        {
          com.viber.voip.notif.h.m localm1 = (com.viber.voip.notif.h.m)paramCircularArray.get(i2);
          com.viber.voip.notif.d.e locale1 = a(localm1);
          if (locale1 != null)
          {
            com.viber.voip.notif.c localc = a(localm1, paramBoolean1, paramBoolean2);
            int i5 = i.a(locale1);
            a locala2 = (a)localSparseArrayCompat.get(i5);
            if (locala2 != null)
              localLongSparseSet.addAll(locala2.b.g());
            localSparseArrayCompat.put(i5, new a(locale1, localm1, localc));
          }
        }
        if (localLongSparseSet.size() > 0)
          a(localLongSparseSet, false);
        int i3 = localSparseArrayCompat.size();
        for (int i4 = 0; i4 < i3; i4++)
        {
          a locala1 = (a)localSparseArrayCompat.valueAt(i4);
          a(locala1.a, locala1.b, locala1.c, paramBoolean2);
        }
      }
    }
  }

  // ERROR //
  private void a(com.viber.voip.notif.d.e parame, com.viber.voip.notif.h.m paramm, com.viber.voip.notif.c paramc, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 94	com/viber/voip/notif/e/s:d	Landroid/content/Context;
    //   5: aload_0
    //   6: getfield 96	com/viber/voip/notif/e/s:e	Lcom/viber/voip/notif/d/j;
    //   9: aload_3
    //   10: invokeinterface 304 4 0
    //   15: aload_0
    //   16: getfield 98	com/viber/voip/notif/e/s:f	Ldagger/a;
    //   19: invokeinterface 227 1 0
    //   24: checkcast 229	com/viber/voip/notif/f
    //   27: new 306	com/viber/voip/notif/i/g
    //   30: dup
    //   31: iload 4
    //   33: invokespecial 309	com/viber/voip/notif/i/g:<init>	(Z)V
    //   36: invokeinterface 314 3 0
    //   41: astore 6
    //   43: aload_0
    //   44: getfield 85	com/viber/voip/notif/e/s:o	Landroid/support/v4/util/SparseArrayCompat;
    //   47: astore 7
    //   49: aload 7
    //   51: monitorenter
    //   52: aload 6
    //   54: invokevirtual 318	com/viber/voip/notif/d/k:a	()I
    //   57: istore 9
    //   59: iconst_0
    //   60: istore 10
    //   62: iload 10
    //   64: iload 9
    //   66: if_icmpge +100 -> 166
    //   69: aload 6
    //   71: iload 10
    //   73: invokevirtual 321	com/viber/voip/notif/d/k:a	(I)Ljava/lang/String;
    //   76: astore 11
    //   78: aload 6
    //   80: iload 10
    //   82: invokevirtual 324	com/viber/voip/notif/d/k:b	(I)I
    //   85: istore 12
    //   87: aload_0
    //   88: getfield 85	com/viber/voip/notif/e/s:o	Landroid/support/v4/util/SparseArrayCompat;
    //   91: iload 12
    //   93: invokevirtual 192	android/support/v4/util/SparseArrayCompat:get	(I)Ljava/lang/Object;
    //   96: checkcast 194	android/support/v4/util/ArraySet
    //   99: astore 13
    //   101: aload 13
    //   103: ifnonnull +23 -> 126
    //   106: new 194	android/support/v4/util/ArraySet
    //   109: dup
    //   110: invokespecial 325	android/support/v4/util/ArraySet:<init>	()V
    //   113: astore 13
    //   115: aload_0
    //   116: getfield 85	com/viber/voip/notif/e/s:o	Landroid/support/v4/util/SparseArrayCompat;
    //   119: iload 12
    //   121: aload 13
    //   123: invokevirtual 285	android/support/v4/util/SparseArrayCompat:put	(ILjava/lang/Object;)V
    //   126: aload 13
    //   128: aload 11
    //   130: aload_2
    //   131: invokevirtual 328	java/lang/Object:hashCode	()I
    //   134: invokestatic 332	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: invokestatic 336	android/support/v4/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/util/Pair;
    //   140: invokevirtual 340	android/support/v4/util/ArraySet:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iinc 10 1
    //   147: goto -85 -> 62
    //   150: astore 5
    //   152: getstatic 60	com/viber/voip/notif/e/s:a	Lcom/viber/dexshared/Logger;
    //   155: aload 5
    //   157: ldc_w 342
    //   160: invokeinterface 347 3 0
    //   165: return
    //   166: aload 7
    //   168: monitorexit
    //   169: return
    //   170: astore 8
    //   172: aload 7
    //   174: monitorexit
    //   175: aload 8
    //   177: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   0	43	150	java/lang/Exception
    //   52	59	170	finally
    //   69	101	170	finally
    //   106	126	170	finally
    //   126	144	170	finally
    //   166	169	170	finally
    //   172	175	170	finally
  }

  private void a(LongSparseSet paramLongSparseSet, boolean paramBoolean)
  {
    ((ab)this.j.get()).d(paramLongSparseSet);
    if (paramBoolean)
      this.g.b();
  }

  private void a(boolean paramBoolean)
  {
    a(this.g.b(), false, paramBoolean);
  }

  private int b(int paramInt)
  {
    if (3 == paramInt)
      return -100;
    if (4 == paramInt)
      return -140;
    if (2 == paramInt)
      return -150;
    return -2147483648;
  }

  public void a()
  {
    if (this.i.a())
      return;
    if (this.n != null)
      this.h.removeCallbacks(this.n);
    this.n = new Runnable()
    {
      public void run()
      {
        s.a(s.this, false);
      }
    };
    this.h.postDelayed(this.n, b);
  }

  public void a(long paramLong)
  {
    a(this.g.a(paramLong), false, false);
  }

  public void a(bv parambv, EventBus paramEventBus)
  {
    parambv.a(new com.viber.voip.notif.i.j(this.h, b, this.i, this.v));
    this.p.a(parambv, this.v);
    this.q.a(this.v);
    this.r.a(paramEventBus, this.v);
    this.s.a(parambv, this.v);
    this.t.a(paramEventBus, this.v);
    this.h.post(new Runnable()
    {
      public void run()
      {
        if (s.c(s.this).a());
        while (!com.viber.voip.notif.c.c.a((com.viber.voip.notif.f)s.d(s.this).get()))
          return;
        CircularArray localCircularArray = s.a(s.this).a();
        s.a(s.this, localCircularArray, true, true);
      }
    });
  }

  public void a(final LongSparseSet paramLongSparseSet)
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        if (paramLongSparseSet.size() == 0)
          return;
        s.a(s.this, paramLongSparseSet, true);
      }
    });
  }

  public void b(final long paramLong)
  {
    this.h.post(new Runnable()
    {
      public void run()
      {
        if (s.c(s.this).a());
        while (true)
        {
          return;
          LongSparseSet localLongSparseSet = s.a(s.this).c();
          SparseSet localSparseSet = s.a(s.this).b(paramLong);
          if ((localLongSparseSet.contains(paramLong)) && (localSparseSet != null))
          {
            s.a(s.this, true);
            s.a(s.this, (int)paramLong);
            int i = 0;
            int j = localSparseSet.size();
            while (i < j)
            {
              int k = localSparseSet.get(i);
              if (!s.a(s.this).a(k))
                s.a(s.this, s.b(s.this, k));
              i++;
            }
          }
        }
      }
    });
  }

  private static class a
  {
    final com.viber.voip.notif.d.e a;
    final com.viber.voip.notif.h.m b;
    final com.viber.voip.notif.c c;

    a(com.viber.voip.notif.d.e parame, com.viber.voip.notif.h.m paramm, com.viber.voip.notif.c paramc)
    {
      this.a = parame;
      this.b = paramm;
      this.c = paramc;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.s
 * JD-Core Version:    0.6.2
 */