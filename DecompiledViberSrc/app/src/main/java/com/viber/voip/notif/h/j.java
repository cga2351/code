package com.viber.voip.notif.h;

import android.support.v4.util.CircularArray;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.model.e;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.SparseSet;
import com.viber.voip.util.ci;
import dagger.a;
import java.util.List;

public class j
{
  private static final Logger a = ViberEnv.getLogger();
  private final a<l> b;
  private final a<ab> c;
  private final a<ak> d;
  private final a<al> e;
  private k.a f;
  private SparseSet g;

  public j(a<ab> parama, a<ak> parama1, a<al> parama2, a<l> parama3)
  {
    this.b = parama3;
    this.c = parama;
    this.d = parama1;
    this.e = parama2;
    this.f = new k.a(0);
    this.g = new SparseSet();
  }

  private CircularArray<m> a(ci<m> paramci)
  {
    k localk = a(((l)this.b.get()).b());
    SparseSet localSparseSet = new SparseSet(this.g.size());
    localSparseSet.addAll(this.g);
    this.f = localk.b;
    this.g.clear();
    int i = localk.a.size();
    int j = localSparseSet.size();
    if (i == 0);
    CircularArray localCircularArray;
    for (int k = 1; ; k = i)
    {
      localCircularArray = new CircularArray(k);
      for (int m = 0; m < i; m++)
      {
        m localm = (m)localk.a.get(m);
        int n = localm.hashCode();
        if ((paramci == null) || (paramci.apply(localm)))
          this.g.add(n);
        if ((j == 0) || (!localSparseSet.contains(n)))
          localCircularArray.addLast(localm);
      }
    }
    if (!localCircularArray.isEmpty())
      e.b("notifications", "last_notified_message_token", ((m)localCircularArray.getLast()).c().getMessageToken());
    return localCircularArray;
  }

  private k a(List<i> paramList)
  {
    return ((l)this.b.get()).a(paramList, this.c, this.d, this.e);
  }

  public CircularArray<m> a()
  {
    return a(new ci()
    {
      public boolean a(m paramAnonymousm)
      {
        return (paramAnonymousm != null) && (paramAnonymousm.c().getMessageToken() <= this.a.longValue());
      }
    });
  }

  public CircularArray<m> a(long paramLong)
  {
    List localList = ((ab)this.c.get()).o(paramLong);
    if (localList.size() == 0)
      return new CircularArray(1);
    return a(((l)this.b.get()).a(localList)).a;
  }

  public CircularArray<m> a(LongSparseSet paramLongSparseSet)
  {
    return a(((l)this.b.get()).a(paramLongSparseSet, this.f.a(paramLongSparseSet))).a;
  }

  public boolean a(int paramInt)
  {
    return this.f.c.contains(paramInt);
  }

  public CircularArray<m> b()
  {
    return a(null);
  }

  public SparseSet b(long paramLong)
  {
    return (SparseSet)this.f.b.get(paramLong);
  }

  public boolean b(int paramInt)
  {
    return this.g.contains(paramInt);
  }

  public LongSparseSet c()
  {
    return this.f.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.j
 * JD-Core Version:    0.6.2
 */