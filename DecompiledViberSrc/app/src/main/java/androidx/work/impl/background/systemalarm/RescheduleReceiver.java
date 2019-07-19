package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.work.i;
import androidx.work.impl.h;

public class RescheduleReceiver extends BroadcastReceiver
{
  private static final String a = i.a("RescheduleReceiver");

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    i.a().b(a, String.format("Received intent %s", new Object[] { paramIntent }), new Throwable[0]);
    if (Build.VERSION.SDK_INT >= 23)
    {
      h localh = h.b();
      if (localh == null)
      {
        i.a().e(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[0]);
        return;
      }
      localh.a(goAsync());
      return;
    }
    paramContext.startService(b.b(paramContext));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.RescheduleReceiver
 * JD-Core Version:    0.6.2
 */