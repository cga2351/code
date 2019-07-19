package android.arch.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service
  implements h
{
  private final r a = new r(this);

  public e getLifecycle()
  {
    return this.a.e();
  }

  public IBinder onBind(Intent paramIntent)
  {
    this.a.b();
    return null;
  }

  public void onCreate()
  {
    this.a.a();
    super.onCreate();
  }

  public void onDestroy()
  {
    this.a.d();
    super.onDestroy();
  }

  public void onStart(Intent paramIntent, int paramInt)
  {
    this.a.c();
    super.onStart(paramIntent, paramInt);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.LifecycleService
 * JD-Core Version:    0.6.2
 */