package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import com.yandex.metrica.impl.bx;

class ie
{
  private final ia a;
  private final ht b;
  private final ii c;
  private final hl d;

  private ie(Context paramContext, Looper paramLooper, mw parammw, LocationManager paramLocationManager, bx parambx, np paramnp, hp paramhp, ii paramii, hl paramhl, iv paramiv)
  {
    this(new ia(paramContext, paramLooper, parammw, paramLocationManager, paramhp, paramii, paramhl, paramiv), new ht(paramContext, parambx, paramnp, paramii, paramhl, paramLooper, paramhp), paramii, paramhl);
  }

  public ie(Context paramContext, mw parammw, Looper paramLooper, hp paramhp, fm paramfm, fl paramfl, iv paramiv)
  {
    this(paramContext, paramLooper, parammw, (LocationManager)paramContext.getSystemService("location"), bx.a(paramContext), np.a(paramContext), paramhp, new ii(paramContext, parammw, paramhp, paramfm, paramfl, paramLooper), new hl(paramhp, paramfm, paramfl), paramiv);
  }

  ie(ia paramia, ht paramht, ii paramii, hl paramhl)
  {
    this.a = paramia;
    this.b = paramht;
    this.c = paramii;
    this.d = paramhl;
  }

  public void a()
  {
    this.a.a();
    this.b.d();
  }

  public void a(mw parammw, hp paramhp)
  {
    this.c.a(parammw, paramhp);
    this.d.a(paramhp);
    this.a.a(parammw, paramhp);
    this.b.a(paramhp);
  }

  public Location b()
  {
    return this.a.b();
  }

  public Location c()
  {
    return this.a.c();
  }

  public void d()
  {
    this.c.a();
  }

  public void e()
  {
    this.a.d();
    this.b.a();
  }

  public void f()
  {
    this.a.e();
    this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ie
 * JD-Core Version:    0.6.2
 */