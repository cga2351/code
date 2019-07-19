package com.mixpanel.android.c;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class f
  implements SensorEventListener
{
  private int a = -1;
  private int b = 0;
  private long c = -1L;
  private final float[] d = new float[3];
  private final a e;

  public f(a parama)
  {
    this.e = parama;
  }

  private float[] a(float[] paramArrayOfFloat)
  {
    for (int i = 0; i < 3; i++)
    {
      float f = this.d[i];
      this.d[i] = (f + 0.7F * (paramArrayOfFloat[i] - f));
    }
    return this.d;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = a(paramSensorEvent.values);
    int i = this.b;
    float f = arrayOfFloat[0] * arrayOfFloat[0] + arrayOfFloat[1] * arrayOfFloat[1] + arrayOfFloat[2] * arrayOfFloat[2];
    this.b = 0;
    if ((arrayOfFloat[2] > 7.8F) && (arrayOfFloat[2] < 11.8F))
      this.b = -1;
    if ((arrayOfFloat[2] < -7.8F) && (arrayOfFloat[2] > -11.8F))
      this.b = 1;
    if ((f < 60.840004F) || (f > 139.24001F))
      this.b = 0;
    if (i != this.b)
      this.c = paramSensorEvent.timestamp;
    long l = paramSensorEvent.timestamp - this.c;
    switch (this.b)
    {
    default:
    case 1:
    case -1:
    case 0:
    }
    do
    {
      do
      {
        do
          return;
        while ((l <= 250000000L) || (this.a != 0));
        com.mixpanel.android.b.f.a("MixpanelAPI.FlipGesture", "Flip gesture begun");
        this.a = 1;
        return;
      }
      while ((l <= 250000000L) || (this.a != 1));
      com.mixpanel.android.b.f.a("MixpanelAPI.FlipGesture", "Flip gesture completed");
      this.a = 0;
      this.e.a();
      return;
    }
    while ((l <= 1000000000L) || (this.a == 0));
    com.mixpanel.android.b.f.a("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
    this.a = 0;
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.f
 * JD-Core Version:    0.6.2
 */