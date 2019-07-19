package com.viber.voip.notif.e;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.support.v4.util.CircularArray;
import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.c;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.f;
import com.viber.voip.notif.h.d;
import com.viber.voip.notif.i.g;
import com.viber.voip.util.LongSparseSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class h
{
  private static final Logger d = ViberEnv.getLogger();
  private static final long e = TimeUnit.SECONDS.toMillis(1L);
  final bv.e a = new bv.d()
  {
    private LongSparseSet a(Set<Long> paramAnonymousSet)
    {
      LongSparseSet localLongSparseSet = new LongSparseSet(paramAnonymousSet.size());
      Iterator localIterator = paramAnonymousSet.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if (h.a(h.this).c().contains(localLong.longValue()))
          localLongSparseSet.add(localLong.longValue());
      }
      return localLongSparseSet;
    }

    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      if ((m.b(paramAnonymousInt)) && (paramAnonymousBoolean1))
        h.a(h.this, h.a(h.this).a(a(paramAnonymousSet)), false, true);
    }

    public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if ((m.b(paramAnonymousInt)) && (!paramAnonymousBoolean))
        h.a(h.this, h.a(h.this).a(a(paramAnonymousSet)), false, true);
    }
  };
  final bv.l b = new bv.l()
  {
    public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }

    public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
    {
      if (h.a(h.this).c().contains(paramAnonymousLong))
        h.a(h.this, h.a(h.this).a(LongSparseSet.from(new long[] { paramAnonymousLong })), false, true);
    }

    public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousMessageEntity, paramAnonymousBoolean);
    }

    public void a(Set paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      by.a(this, paramAnonymousSet, paramAnonymousBoolean);
    }

    public void a(Set paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      by.a(this, paramAnonymousSet, paramAnonymousBoolean1, paramAnonymousBoolean2);
    }

    public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
    {
      by.b(this, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousBoolean);
    }
  };
  final Runnable c = new Runnable()
  {
    public void run()
    {
      h.a(h.this, h.a(h.this).b(), false, false);
    }
  };
  private final Context f;
  private final dagger.a<ab> g;
  private final com.viber.voip.notif.h.e h;
  private final Handler i;
  private final com.viber.voip.notif.i.k j;
  private final dagger.a<f> k;
  private final com.viber.voip.notif.i.l l;
  private final SparseArrayCompat<ArraySet<String>> m = new SparseArrayCompat();
  private final com.viber.voip.notif.d.j n;
  private final com.viber.voip.notif.g.a o;
  private final com.viber.voip.notif.g.e p;

  h(Context paramContext, com.viber.voip.notif.d.j paramj, com.viber.voip.notif.h.e parame, dagger.a<ab> parama, Handler paramHandler, dagger.a<f> parama1, com.viber.voip.notif.i.k paramk, com.viber.voip.notif.i.l paraml, com.viber.voip.notif.g.a parama2, com.viber.voip.notif.g.e parame1)
  {
    this.f = paramContext;
    this.n = paramj;
    this.g = parama;
    this.h = parame;
    this.i = paramHandler;
    this.j = paramk;
    this.l = paraml;
    this.k = parama1;
    this.o = parama2;
    this.p = parame1;
  }

  private void a(CircularArray<d> paramCircularArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCircularArray.size() == 0)
      return;
    int i1 = paramCircularArray.size();
    int i2 = 0;
    label17: d locald;
    c localc;
    if (i2 < i1)
    {
      locald = (d)paramCircularArray.get(i2);
      if (!paramBoolean1)
        break label70;
      localc = c.c;
    }
    while (true)
    {
      a(this.o.a(locald, this.p), localc, paramBoolean2);
      i2++;
      break label17;
      break;
      label70: if ((!paramBoolean2) && (this.l.a()) && (!locald.t()))
      {
        boolean bool = locald.y();
        localc = null;
        if (!bool);
      }
      else
      {
        localc = c.d;
      }
    }
  }

  private void a(com.viber.voip.notif.d.e parame, c paramc, boolean paramBoolean)
  {
    if (parame == null)
      return;
    try
    {
      parame.a(this.f, this.n, paramc).a((f)this.k.get(), new g(paramBoolean));
      int i1 = parame.a();
      ArraySet localArraySet = (ArraySet)this.m.get(i1);
      if (localArraySet == null)
      {
        localArraySet = new ArraySet();
        this.m.put(i1, localArraySet);
      }
      localArraySet.add(parame.R_());
      return;
    }
    catch (Exception localException)
    {
      d.a(localException, "Can't show notification!");
    }
  }

  public void a()
  {
    if (this.j.a())
      return;
    this.i.removeCallbacks(this.c);
    this.i.postDelayed(this.c, e);
  }

  public void a(long paramLong)
  {
    this.i.post(new l(this, paramLong));
  }

  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.i.post(new k(this, paramLong1, paramLong3));
  }

  public void a(bv parambv)
  {
    parambv.a(this.a, this.i);
    parambv.a(this.b, this.i);
    this.i.post(new i(this));
  }

  public void a(com.viber.voip.model.entity.h paramh, Member paramMember, int paramInt)
  {
    if (this.j.a())
      return;
    this.i.postDelayed(new j(this, paramh, paramMember, paramInt), e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.h
 * JD-Core Version:    0.6.2
 */