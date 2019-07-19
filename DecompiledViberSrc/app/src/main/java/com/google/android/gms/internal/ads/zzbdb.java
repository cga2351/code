package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;

@zzare
final class zzbdb
  implements SensorEventListener
{
  private final SensorManager zzecx;
  private final Object zzecy;
  private final Display zzecz;
  private final float[] zzeda;
  private final float[] zzedb;

  @GuardedBy("sensorThreadLock")
  private float[] zzedc;
  private Handler zzedd;
  private zzbdd zzede;

  zzbdb(Context paramContext)
  {
    this.zzecx = ((SensorManager)paramContext.getSystemService("sensor"));
    this.zzecz = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.zzeda = new float[9];
    this.zzedb = new float[9];
    this.zzecy = new Object();
  }

  private final void zzl(int paramInt1, int paramInt2)
  {
    float f = this.zzedb[paramInt1];
    this.zzedb[paramInt1] = this.zzedb[paramInt2];
    this.zzedb[paramInt2] = f;
  }

  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = paramSensorEvent.values;
    if ((arrayOfFloat[0] != 0.0F) || (arrayOfFloat[1] != 0.0F) || (arrayOfFloat[2] != 0.0F));
    while (true)
    {
      synchronized (this.zzecy)
      {
        if (this.zzedc == null)
          this.zzedc = new float[9];
        SensorManager.getRotationMatrixFromVector(this.zzeda, arrayOfFloat);
        switch (this.zzecz.getRotation())
        {
        default:
          System.arraycopy(this.zzeda, 0, this.zzedb, 0, 9);
          zzl(1, 3);
          zzl(2, 6);
          zzl(5, 7);
        case 1:
        case 2:
        case 3:
        }
      }
      synchronized (this.zzecy)
      {
        System.arraycopy(this.zzedb, 0, this.zzedc, 0, 9);
        if (this.zzede != null)
          this.zzede.zztk();
        return;
        localObject2 = finally;
        throw localObject2;
        SensorManager.remapCoordinateSystem(this.zzeda, 2, 129, this.zzedb);
        continue;
        SensorManager.remapCoordinateSystem(this.zzeda, 129, 130, this.zzedb);
        continue;
        SensorManager.remapCoordinateSystem(this.zzeda, 130, 1, this.zzedb);
      }
    }
  }

  final void start()
  {
    if (this.zzedd != null);
    Sensor localSensor;
    do
    {
      return;
      localSensor = this.zzecx.getDefaultSensor(11);
      if (localSensor == null)
      {
        zzaxa.zzen("No Sensor of TYPE_ROTATION_VECTOR");
        return;
      }
      HandlerThread localHandlerThread = new HandlerThread("OrientationMonitor");
      localHandlerThread.start();
      this.zzedd = new zzdbg(localHandlerThread.getLooper());
    }
    while (this.zzecx.registerListener(this, localSensor, 0, this.zzedd));
    zzaxa.zzen("SensorManager.registerListener failed.");
    stop();
  }

  final void stop()
  {
    if (this.zzedd == null)
      return;
    this.zzecx.unregisterListener(this);
    this.zzedd.post(new zzbdc(this));
    this.zzedd = null;
  }

  final void zza(zzbdd paramzzbdd)
  {
    this.zzede = paramzzbdd;
  }

  final boolean zza(float[] paramArrayOfFloat)
  {
    synchronized (this.zzecy)
    {
      if (this.zzedc == null)
        return false;
      System.arraycopy(this.zzedc, 0, paramArrayOfFloat, 0, this.zzedc.length);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbdb
 * JD-Core Version:    0.6.2
 */