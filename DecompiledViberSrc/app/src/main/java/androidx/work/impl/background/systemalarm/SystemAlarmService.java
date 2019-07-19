package androidx.work.impl.background.systemalarm;

import android.arch.lifecycle.LifecycleService;
import android.content.Intent;

public class SystemAlarmService extends LifecycleService
  implements e.b
{
  private static final String a = androidx.work.i.a("SystemAlarmService");
  private e b;

  public void a()
  {
    androidx.work.i.a().b(a, "All commands completed in dispatcher", new Throwable[0]);
    androidx.work.impl.utils.i.a();
    stopSelf();
  }

  public void onCreate()
  {
    super.onCreate();
    this.b = new e(this);
    this.b.a(this);
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.b.a();
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (paramIntent != null)
      this.b.a(paramIntent, paramInt2);
    return 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.SystemAlarmService
 * JD-Core Version:    0.6.2
 */