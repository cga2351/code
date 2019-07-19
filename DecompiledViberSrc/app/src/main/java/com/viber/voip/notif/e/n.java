package com.viber.voip.notif.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.support.v4.util.CircularArray;
import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.notif.c;
import com.viber.voip.notif.d.e;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.g.b;
import com.viber.voip.notif.i.h;
import com.viber.voip.notif.i.k;
import com.viber.voip.notif.i.l;
import com.viber.voip.util.LongSparseSet;
import dagger.a;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class n
{
  private static final Logger b = ViberEnv.getLogger();
  private static final long c = TimeUnit.SECONDS.toMillis(1L);
  final com.viber.voip.notif.h.f a;
  private final Context d;
  private final com.viber.voip.notif.d.j e;
  private final a<com.viber.voip.notif.f> f;
  private final Handler g;
  private final k h;
  private final a<ab> i;
  private final l j;
  private final b k;
  private Runnable l;
  private final SparseArrayCompat<ArraySet<String>> m = new SparseArrayCompat();
  private final h n = new h()
  {
    public LongSparseSet a()
    {
      return n.this.a.c();
    }

    public void a(LongSparseSet paramAnonymousLongSparseSet)
    {
      n.a(n.this).postDelayed(new r(this, paramAnonymousLongSparseSet), n.c());
    }
  };

  n(Context paramContext, com.viber.voip.notif.d.j paramj, a<com.viber.voip.notif.f> parama, Handler paramHandler, b paramb, com.viber.voip.notif.h.f paramf, k paramk, a<ab> parama1, l paraml)
  {
    this.d = paramContext;
    this.e = paramj;
    this.f = parama;
    this.g = paramHandler;
    this.h = paramk;
    this.i = parama1;
    this.j = paraml;
    this.k = paramb;
    this.a = paramf;
  }

  @SuppressLint({"SwitchIntDef"})
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return -2147483648;
    case 3:
      return -130;
    case 4:
      return -135;
    case 5:
    }
    return -225;
  }

  private void a(CircularArray<com.viber.voip.notif.h.g> paramCircularArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCircularArray.isEmpty())
      return;
    int i1 = paramCircularArray.size();
    int i2 = 0;
    label17: com.viber.voip.notif.h.g localg;
    c localc;
    if (i2 < i1)
    {
      localg = (com.viber.voip.notif.h.g)paramCircularArray.get(i2);
      if (!paramBoolean1)
        break label66;
      localc = c.c;
    }
    while (true)
    {
      a(this.k.a(localg), localc, paramBoolean2);
      i2++;
      break label17;
      break;
      label66: if ((!paramBoolean2) && (!localg.i()))
      {
        boolean bool = this.j.a();
        localc = null;
        if (bool);
      }
      else
      {
        localc = c.d;
      }
    }
  }

  private void a(e parame, c paramc, boolean paramBoolean)
  {
    if (parame == null)
      return;
    try
    {
      parame.a(this.d, this.e, paramc).a((com.viber.voip.notif.f)this.f.get(), new com.viber.voip.notif.i.g(paramBoolean));
      synchronized (this.m)
      {
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
    }
    catch (Exception localException)
    {
      b.a(localException, "Can't show notification!");
    }
  }

  private void a(boolean paramBoolean)
  {
    a(this.a.b(), false, paramBoolean);
  }

  private void b(int paramInt)
  {
    if (paramInt == -2147483648)
      return;
    ArraySet localArraySet;
    synchronized (this.m)
    {
      localArraySet = (ArraySet)this.m.get(paramInt);
      if (localArraySet == null)
        return;
    }
    Iterator localIterator = localArraySet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((com.viber.voip.notif.f)this.f.get()).a(str, paramInt);
    }
    this.m.remove(paramInt);
  }

  public void a()
  {
    if (this.h.a())
      return;
    if (this.l != null)
      this.g.removeCallbacks(this.l);
    this.l = new q(this);
    this.g.postDelayed(this.l, c);
  }

  public void a(long paramLong)
  {
    this.g.post(new o(this, paramLong));
  }

  public void a(bv parambv)
  {
    parambv.a(new com.viber.voip.notif.i.j(this.g, c, this.h, this.n));
    this.g.post(new Runnable()
    {
      public void run()
      {
        if (n.b(n.this).a());
        while (!c.c.a((com.viber.voip.notif.f)n.c(n.this).get()))
          return;
        n.a(n.this, n.this.a.a(), true, true);
      }
    });
  }

  public void a(LongSparseSet paramLongSparseSet)
  {
    this.g.post(new p(this, paramLongSparseSet));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.n
 * JD-Core Version:    0.6.2
 */