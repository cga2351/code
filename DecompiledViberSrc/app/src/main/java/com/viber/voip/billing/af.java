package com.viber.voip.billing;

import android.os.Handler;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.dd;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class af
{
  private static final Logger a = b.a(af.class);
  private ac b;

  private ac a()
    throws ae
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    long l = SystemClock.elapsedRealtime();
    ac[] arrayOfac = new ac[1];
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    a(localEngine, arrayOfac, localCountDownLatch);
    localEngine.getPhoneController().handleGetBillingToken();
    try
    {
      localCountDownLatch.await(10000L, TimeUnit.MILLISECONDS);
      label59: a(localEngine);
      (SystemClock.elapsedRealtime() - l);
      if (arrayOfac[0] == null)
        throw new ae("Failed receiving web token");
      return arrayOfac[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      break label59;
    }
  }

  protected abstract void a(Engine paramEngine);

  protected abstract void a(Engine paramEngine, ac[] paramArrayOfac, CountDownLatch paramCountDownLatch);

  public void a(final ad paramad)
  {
    try
    {
      ac localac = this.b;
      if ((localac != null) && (!localac.a()))
      {
        dd.a(new ag(paramad, localac));
        return;
      }
    }
    finally
    {
    }
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        try
        {
          final ac localac = af.a(af.this);
          synchronized (af.this)
          {
            af.a(af.this, localac);
            dd.a(new Runnable()
            {
              public void run()
              {
                af.1.this.a.a(localac);
              }
            });
            return;
          }
        }
        catch (ae localae)
        {
          dd.a(new Runnable()
          {
            public void run()
            {
              af.1.this.a.a(localae);
            }
          });
        }
      }
    });
  }

  // ERROR //
  public ac b()
    throws ae
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/viber/voip/billing/af:b	Lcom/viber/voip/billing/ac;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +10 -> 18
    //   11: aload_2
    //   12: invokevirtual 98	com/viber/voip/billing/ac:a	()Z
    //   15: ifeq +10 -> 25
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 89	com/viber/voip/billing/af:b	Lcom/viber/voip/billing/ac;
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: ifnonnull +8 -> 36
    //   31: aload_0
    //   32: invokespecial 86	com/viber/voip/billing/af:a	()Lcom/viber/voip/billing/ac;
    //   35: astore_2
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: aload_2
    //   40: putfield 89	com/viber/voip/billing/af:b	Lcom/viber/voip/billing/ac;
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   11	18	47	finally
    //   18	23	47	finally
    //   25	27	47	finally
    //   48	50	47	finally
    //   38	45	52	finally
    //   53	55	52	finally
  }

  public void c()
  {
    try
    {
      this.b = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.billing.af
 * JD-Core Version:    0.6.2
 */