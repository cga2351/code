package com.viber.voip.notif.i;

import android.os.Handler;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.LongSparseSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class j
  implements bv.n
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b;
  private final Object c;
  private final h d;
  private final k e;
  private final long f;

  public j(Handler paramHandler, long paramLong, k paramk, h paramh)
  {
    this.b = paramHandler;
    this.f = paramLong;
    this.e = paramk;
    this.d = paramh;
    this.c = new Object();
  }

  public void onChange(final Set<Long> paramSet, Set<String> paramSet1, boolean paramBoolean)
  {
    this.b.removeCallbacksAndMessages(this.c);
    this.b.postAtTime(new Runnable()
    {
      public void run()
      {
        if (j.a(j.this).a());
        LongSparseSet localLongSparseSet2;
        do
        {
          LongSparseSet localLongSparseSet1;
          do
          {
            return;
            localLongSparseSet1 = j.b(j.this).a();
          }
          while (localLongSparseSet1.size() == 0);
          localLongSparseSet2 = new LongSparseSet(paramSet.size());
          Iterator localIterator = paramSet.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            if (localLongSparseSet1.contains(localLong.longValue()))
              localLongSparseSet2.add(localLong.longValue());
          }
        }
        while (localLongSparseSet2.size() <= 0);
        j.b(j.this).a(localLongSparseSet2);
      }
    }
    , this.c, SystemClock.uptimeMillis() + this.f);
  }

  public void onContactStatusChanged(Map<Long, bv.n.a> paramMap)
  {
  }

  public void onInitCache()
  {
  }

  public void onNewInfo(List<m> paramList, boolean paramBoolean)
  {
  }

  public void onParticipantDeleted(m paramm)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.j
 * JD-Core Version:    0.6.2
 */