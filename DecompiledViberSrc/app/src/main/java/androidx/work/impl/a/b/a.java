package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import androidx.work.i;

public class a extends c<Boolean>
{
  private static final String b = i.a("BatteryChrgTracker");

  public a(Context paramContext)
  {
    super(paramContext);
  }

  private boolean a(Intent paramIntent)
  {
    boolean bool1 = true;
    if (Build.VERSION.SDK_INT >= 23)
    {
      int i = paramIntent.getIntExtra("status", -1);
      boolean bool2;
      if (i != 2)
      {
        bool2 = false;
        if (i != 5);
      }
      else
      {
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramIntent.getIntExtra("plugged", 0) != 0);
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  public Boolean a()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Intent localIntent = this.a.registerReceiver(null, localIntentFilter);
    if (localIntent == null)
    {
      i.a().e(b, "getInitialState - null intent received", new Throwable[0]);
      return null;
    }
    return Boolean.valueOf(a(localIntent));
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null)
      return;
    i.a().b(b, String.format("Received %s", new Object[] { str }), new Throwable[0]);
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 948344062:
    case -54942926:
    case 1019184907:
    case -1886648615:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        a(Boolean.valueOf(true));
        return;
        if (str.equals("android.os.action.CHARGING"))
        {
          i = 0;
          continue;
          if (str.equals("android.os.action.DISCHARGING"))
          {
            i = 1;
            continue;
            if (str.equals("android.intent.action.ACTION_POWER_CONNECTED"))
            {
              i = 2;
              continue;
              if (str.equals("android.intent.action.ACTION_POWER_DISCONNECTED"))
                i = 3;
            }
          }
        }
        break;
      case 1:
      case 2:
      case 3:
      }
    a(Boolean.valueOf(false));
    return;
    a(Boolean.valueOf(true));
    return;
    a(Boolean.valueOf(false));
  }

  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    if (Build.VERSION.SDK_INT >= 23)
    {
      localIntentFilter.addAction("android.os.action.CHARGING");
      localIntentFilter.addAction("android.os.action.DISCHARGING");
      return localIntentFilter;
    }
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
    localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    return localIntentFilter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.a
 * JD-Core Version:    0.6.2
 */