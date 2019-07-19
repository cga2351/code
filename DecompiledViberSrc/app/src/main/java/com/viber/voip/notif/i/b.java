package com.viber.voip.notif.i;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.util.LongSparseSet;
import dagger.a;
import java.util.Iterator;
import java.util.Set;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final a<ab> b;
  private final Handler c;
  private h d;
  private final bv.e e = new bv.d()
  {
    public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
    {
      b.a(b.this, paramAnonymousSet);
    }
  };

  public b(a<ab> parama, Handler paramHandler)
  {
    this.b = parama;
    this.c = paramHandler;
  }

  private void a(Set<Long> paramSet)
  {
    if (this.d == null);
    LongSparseSet localLongSparseSet3;
    do
    {
      LongSparseSet localLongSparseSet2;
      do
      {
        return;
        LongSparseSet localLongSparseSet1 = this.d.a();
        localLongSparseSet2 = new LongSparseSet(localLongSparseSet1.size());
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          Long localLong = (Long)localIterator.next();
          if ((localLong != null) && (localLongSparseSet1.contains(localLong.longValue())))
            localLongSparseSet2.add(localLong.longValue());
        }
      }
      while (localLongSparseSet2.isEmpty());
      localLongSparseSet3 = ((ab)this.b.get()).e(localLongSparseSet2);
    }
    while (localLongSparseSet3.isEmpty());
    this.d.a(localLongSparseSet3);
  }

  public void a(bv parambv, h paramh)
  {
    this.d = paramh;
    parambv.a(this.e, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.b
 * JD-Core Version:    0.6.2
 */