package com.viber.voip.engagement.d;

import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.engagement.d;
import com.viber.voip.model.j;
import com.viber.voip.user.OnlineUserActivityHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class a extends l
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = TimeUnit.DAYS.toMillis(14L);
  private final PhoneController c;
  private final OnlineUserActivityHelper d;
  private final long e;

  public a(PhoneController paramPhoneController, OnlineUserActivityHelper paramOnlineUserActivityHelper)
  {
    this.c = paramPhoneController;
    this.d = paramOnlineUserActivityHelper;
    this.e = TimeUnit.SECONDS.toMillis(10L);
  }

  private void a(Iterator<m> paramIterator, ArrayMap<String, Long> paramArrayMap)
  {
    while ((paramIterator.hasNext()) && (paramArrayMap.size() < 50))
    {
      m localm = (m)paramIterator.next();
      j localj = localm.n();
      if (localj != null)
        paramArrayMap.put(localj.a(), Long.valueOf(localm.getId()));
    }
  }

  public void a(k paramk)
  {
    if (!this.d.isObtainOnlineStatusesAvailable())
      return;
    ArrayMap localArrayMap = new ArrayMap(50);
    Iterator localIterator1 = paramk.iterator();
    ArrayList localArrayList = new ArrayList(50);
    b localb = new b(System.currentTimeMillis() - b);
    int i = 5;
    label56: a(localIterator1, localArrayMap);
    int k;
    if (localArrayMap.isEmpty())
      k = i;
    while ((k != 0) && (localIterator1.hasNext()))
    {
      i = k;
      break label56;
      int j = this.c.generateSequence();
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      d locald = new d(j, localArrayList, localCountDownLatch, localb);
      Set localSet = localArrayMap.keySet();
      this.d.obtainInfo((String[])localSet.toArray(new String[localSet.size()]), j, locald);
      try
      {
        localCountDownLatch.await(this.e, TimeUnit.MILLISECONDS);
        Iterator localIterator2 = locald.a().iterator();
        while (localIterator2.hasNext())
        {
          paramk.a(((Long)localArrayMap.get((String)localIterator2.next())).longValue(), true);
          i--;
        }
        localArrayList.clear();
        localArrayMap.clear();
        this.d.removeListener(locald);
        k = i;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      finally
      {
        this.d.removeListener(locald);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.a
 * JD-Core Version:    0.6.2
 */