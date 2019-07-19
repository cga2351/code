package com.viber.voip.p;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.br;

public class e
  implements c
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private SensorManager c = null;
  private Sensor d = null;
  private boolean e = false;
  private SensorEventListener f = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
    {
    }

    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      if (paramAnonymousSensorEvent.sensor.getType() == 8)
      {
        int i = (int)paramAnonymousSensorEvent.values[0];
        boolean bool1;
        if (i != 0)
        {
          bool1 = false;
          if (i == 3)
          {
            boolean bool2 = br.c.a();
            bool1 = false;
            if (!bool2);
          }
        }
        else
        {
          bool1 = true;
        }
        e.a(e.this).onProximityChanged(bool1);
      }
    }
  };

  public e(Context paramContext, a parama)
  {
    this.b = parama;
    this.c = ((SensorManager)paramContext.getSystemService("sensor"));
    this.d = this.c.getDefaultSensor(8);
  }

  private void d()
  {
    this.c.registerListener(this.f, this.d, 3, av.a(av.e.g));
  }

  private void e()
  {
    this.c.unregisterListener(this.f);
  }

  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.e))
    {
      d();
      this.e = true;
    }
    while ((paramBoolean) || (!this.e))
      return;
    e();
    this.e = false;
  }

  public boolean a()
  {
    return this.d != null;
  }

  public void b()
  {
    if (!this.e)
    {
      d();
      this.e = true;
    }
  }

  public void c()
  {
    if (this.e)
    {
      e();
      this.e = false;
    }
  }

  public static abstract interface a
  {
    public abstract void onProximityChanged(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.p.e
 * JD-Core Version:    0.6.2
 */