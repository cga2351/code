package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;

class ib
{
  static final long a = TimeUnit.SECONDS.toMillis(1L);
  private Context b;
  private Looper c;
  private Handler d;
  private LocationManager e;
  private LocationListener f;
  private iv g;

  static
  {
    TimeUnit.SECONDS.toMillis(10L);
  }

  public ib(Context paramContext, Looper paramLooper, LocationManager paramLocationManager, LocationListener paramLocationListener, iv paramiv)
  {
    this.b = paramContext;
    this.c = paramLooper;
    this.e = paramLocationManager;
    this.f = paramLocationListener;
    this.d = new Handler(this.c);
    this.g = paramiv;
  }

  public void a()
  {
    long l;
    LocationListener localLocationListener;
    Looper localLooper;
    if (this.g.b(this.b))
    {
      l = a;
      localLocationListener = this.f;
      localLooper = this.c;
      if (this.e == null);
    }
    try
    {
      this.e.requestLocationUpdates("passive", l, 0.0F, localLocationListener, localLooper);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    if (this.e != null);
    try
    {
      this.e.removeUpdates(this.f);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ib
 * JD-Core Version:    0.6.2
 */