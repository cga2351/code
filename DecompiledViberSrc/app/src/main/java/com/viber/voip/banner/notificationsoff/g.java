package com.viber.voip.banner.notificationsoff;

import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.f;
import com.viber.voip.settings.d.k;
import dagger.a;

public class g
  implements f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final f.a b;
  private final a<f> c;

  public g(f.a parama, a<f> parama1)
  {
    this.b = parama;
    this.c = parama1;
  }

  public boolean a()
  {
    if (f());
    while ((this.b != null) && (!this.b.a()))
      return false;
    return e();
  }

  public boolean b()
  {
    if (f());
    while (((!d.k.b.d()) && (this.b != null) && (!this.b.b())) || (System.currentTimeMillis() < d.k.a.d()))
      return false;
    return true;
  }

  public void c()
  {
    if ((b()) && (!d.k.b.d()))
      d.k.b.a(true);
  }

  public void d()
  {
    d.k.b.e();
  }

  public boolean e()
  {
    return d.k.b.d();
  }

  public boolean f()
  {
    return ((f)this.c.get()).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.notificationsoff.g
 * JD-Core Version:    0.6.2
 */