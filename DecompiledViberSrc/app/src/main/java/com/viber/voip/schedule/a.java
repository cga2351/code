package com.viber.voip.schedule;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.b;
import com.viber.voip.apps.h;
import com.viber.voip.apps.h.a;
import com.viber.voip.messages.controller.ai;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private final h b;
  private final ai c;
  private final long d;

  public a(h paramh, ai paramai)
  {
    this(paramh, paramai, TimeUnit.MINUTES.toMillis(2L));
  }

  a(h paramh, ai paramai, long paramLong)
  {
    this.b = paramh;
    this.c = paramai;
    this.d = paramLong;
  }

  public int a(Bundle paramBundle)
  {
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    this.b.a(new h.a()
    {
      public void onAppInfoFailed()
      {
        localCountDownLatch.countDown();
      }

      public void onAppInfoReady(List<b> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        a.a(a.this).a(paramAnonymousList);
        localAtomicBoolean.set(true);
        localCountDownLatch.countDown();
      }
    });
    try
    {
      localCountDownLatch.await(this.d, TimeUnit.MILLISECONDS);
      label47: if (localAtomicBoolean.get())
        return 0;
      return 1;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label47;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.a
 * JD-Core Version:    0.6.2
 */