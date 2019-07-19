package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.utils.d;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver
{
  private static final String a = i.a("ConstrntProxyUpdtRecvr");

  public static Intent a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Intent localIntent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
    localIntent.setComponent(new ComponentName(paramContext, ConstraintProxyUpdateReceiver.class));
    localIntent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", paramBoolean1).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", paramBoolean2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", paramBoolean3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", paramBoolean4);
    return localIntent;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null);
    for (String str1 = paramIntent.getAction(); !"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str1); str1 = null)
    {
      i.a().b(a, String.format("Ignoring unknown action %s", new Object[] { str1 }), new Throwable[0]);
      return;
    }
    boolean bool1 = paramIntent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
    boolean bool2 = paramIntent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
    boolean bool3 = paramIntent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
    boolean bool4 = paramIntent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
    i locali = i.a();
    String str2 = a;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Boolean.valueOf(bool1);
    arrayOfObject[1] = Boolean.valueOf(bool2);
    arrayOfObject[2] = Boolean.valueOf(bool3);
    arrayOfObject[3] = Boolean.valueOf(bool4);
    locali.b(str2, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", arrayOfObject), new Throwable[0]);
    d.a(paramContext, ConstraintProxy.BatteryNotLowProxy.class, bool1);
    d.a(paramContext, ConstraintProxy.BatteryChargingProxy.class, bool2);
    d.a(paramContext, ConstraintProxy.StorageNotLowProxy.class, bool3);
    d.a(paramContext, ConstraintProxy.NetworkStateProxy.class, bool4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver
 * JD-Core Version:    0.6.2
 */