package com.viber.voip.ads;

import android.text.TextUtils;
import com.viber.common.a.e;
import com.viber.common.b.h;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.m;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

class d
{
  private static final e a = ViberEnv.getLogger();
  private static final long b = TimeUnit.MINUTES.toMillis(5L);
  private static final long c = TimeUnit.SECONDS.toMillis(10L);
  private a d;
  private Timer e;
  private TimerTask f;
  private String g;
  private long h = 0L;

  d(a parama, String paramString)
  {
    this.d = parama;
    this.g = paramString;
  }

  void a()
  {
    this.f = new TimerTask()
    {
      public void run()
      {
        d.a(d.this).a();
      }
    };
    this.e = new Timer(this.g);
    Timer localTimer = this.e;
    TimerTask localTimerTask = this.f;
    if (this.h >= c);
    for (long l = this.h; ; l = b)
    {
      localTimer.schedule(localTimerTask, l);
      return;
    }
  }

  void a(long paramLong)
  {
    String str = d.m.r.d();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str)));
    this.h = paramLong;
  }

  void b()
  {
    if (this.f != null)
    {
      this.f.cancel();
      this.f = null;
    }
    if (this.e != null)
    {
      this.e.purge();
      this.e.cancel();
      this.e = null;
    }
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.d
 * JD-Core Version:    0.6.2
 */