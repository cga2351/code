package com.viber.voip.shareviber.invitescreen.b;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.calls.d;
import com.viber.voip.calls.d.b;
import com.viber.voip.model.Call;
import com.viber.voip.model.f;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class m
  implements j
{
  private static final Logger a = ViberEnv.getLogger();
  private final d b;

  m(d paramd)
  {
    this.b = paramd;
  }

  public void a(h paramh)
  {
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    final HashSet localHashSet = new HashSet();
    this.b.a(new d.b()
    {
      public void a(long paramAnonymousLong, Collection<Call> paramAnonymousCollection)
      {
        Iterator localIterator = paramAnonymousCollection.iterator();
        while (localIterator.hasNext())
        {
          Call localCall = (Call)localIterator.next();
          localHashSet.add(localCall.getNumber());
        }
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
      Iterator localIterator = paramh.iterator();
      while (localIterator.hasNext())
      {
        i locali = (i)localIterator.next();
        if (localHashSet.contains(locali.w().a()))
          paramh.a(locali.c(), 3);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.m
 * JD-Core Version:    0.6.2
 */