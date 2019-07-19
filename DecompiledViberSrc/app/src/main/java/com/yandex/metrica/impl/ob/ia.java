package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

public class ia
{
  private ib a;
  private if b;
  private hs c;
  private LocationListener d = new LocationListener()
  {
    public void onLocationChanged(Location paramAnonymousLocation)
    {
      if (paramAnonymousLocation != null)
        ia.a(ia.this).a(paramAnonymousLocation);
    }

    public void onProviderDisabled(String paramAnonymousString)
    {
    }

    public void onProviderEnabled(String paramAnonymousString)
    {
    }

    public void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
    }
  };
  private boolean e = false;

  ia(Context paramContext, Looper paramLooper, LocationManager paramLocationManager, a parama, if paramif, hs paramhs, iv paramiv)
  {
    this.c = paramhs;
    this.a = parama.a(paramContext, paramLooper, paramLocationManager, this.d, paramiv);
    this.b = paramif;
  }

  public ia(Context paramContext, Looper paramLooper, mw parammw, LocationManager paramLocationManager, hp paramhp, ii paramii, hl paramhl, iv paramiv)
  {
    this(paramContext, paramLooper, paramLocationManager, new a(), new if(paramContext, parammw, paramhp, paramii, paramhl), new hs(paramContext, paramLocationManager, paramiv), paramiv);
  }

  public void a()
  {
    Location localLocation = this.c.a();
    if (localLocation != null)
      this.b.a(localLocation);
  }

  public void a(mw parammw, hp paramhp)
  {
    this.b.a(parammw, paramhp);
    if (this.e)
    {
      e();
      d();
      a();
    }
  }

  public Location b()
  {
    return this.b.a();
  }

  public Location c()
  {
    return this.c.a();
  }

  public void d()
  {
    this.e = true;
    this.a.a();
  }

  public void e()
  {
    this.e = false;
    this.a.b();
  }

  static class a
  {
    public ib a(Context paramContext, Looper paramLooper, LocationManager paramLocationManager, LocationListener paramLocationListener, iv paramiv)
    {
      return new ib(paramContext, paramLooper, paramLocationManager, paramLocationListener, paramiv);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ia
 * JD-Core Version:    0.6.2
 */