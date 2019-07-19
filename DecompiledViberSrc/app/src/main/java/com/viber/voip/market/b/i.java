package com.viber.voip.market.b;

import android.location.Location;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.extras.b.a;
import com.viber.voip.messages.extras.b.d.c;
import com.viber.voip.util.dd;

public class i
{
  private static final Logger b = ViberEnv.getLogger();
  protected a a;
  private Handler c;
  private Runnable d;

  private void d(Location paramLocation, d.c paramc)
  {
    dd.a(new l(this, paramLocation, paramc));
  }

  public void a(a parama)
  {
    a(parama, 2147483647);
  }

  public void a(a parama, int paramInt)
  {
    this.a = parama;
    this.c = av.e.g.a();
    this.d = new j(this);
    this.c.postDelayed(this.d, paramInt);
    ViberApplication.getInstance().getLocationManager().a(1, new k(this));
  }

  public static abstract interface a
  {
    public abstract void a(Location paramLocation, d.c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.i
 * JD-Core Version:    0.6.2
 */