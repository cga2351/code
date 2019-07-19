package com.viber.voip.qrcode;

import android.os.Handler;
import android.os.Looper;
import com.google.e.a;
import com.google.e.q;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class e extends Thread
{
  private static final Logger a = ViberEnv.getLogger();
  private final ScannerActivity b;
  private final Map<com.google.e.e, Object> c;
  private Handler d;
  private final CountDownLatch e;

  e(ScannerActivity paramScannerActivity, q paramq)
  {
    this.b = paramScannerActivity;
    this.e = new CountDownLatch(1);
    this.c = new EnumMap(com.google.e.e.class);
    this.c.put(com.google.e.e.c, EnumSet.of(a.l));
    this.c.put(com.google.e.e.j, paramq);
  }

  Handler a()
  {
    try
    {
      this.e.await();
      label7: return this.d;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }

  public void run()
  {
    Looper.prepare();
    this.d = new d(this.b, this.c);
    this.e.countDown();
    Looper.loop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.e
 * JD-Core Version:    0.6.2
 */