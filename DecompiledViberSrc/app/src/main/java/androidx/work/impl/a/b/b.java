package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.i;

public class b extends c<Boolean>
{
  private static final String b = i.a("BatteryNotLowTracker");

  public b(Context paramContext)
  {
    super(paramContext);
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
    int i = localIntent.getIntExtra("plugged", 0);
    int j = localIntent.getIntExtra("status", -1);
    int k = localIntent.getIntExtra("level", -1);
    int m = localIntent.getIntExtra("scale", -1);
    float f = k / m;
    boolean bool1;
    if ((i == 0) && (j != 1))
    {
      boolean bool2 = f < 0.15F;
      bool1 = false;
      if (!bool2);
    }
    else
    {
      bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }

  public void a(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null)
      return;
    i locali = i.a();
    String str1 = b;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramIntent.getAction();
    locali.b(str1, String.format("Received %s", arrayOfObject), new Throwable[0]);
    String str2 = paramIntent.getAction();
    int i = -1;
    switch (str2.hashCode())
    {
    default:
    case -1980154005:
    case 490310653:
    }
    while (true)
      switch (i)
      {
      default:
        return;
      case 0:
        a(Boolean.valueOf(true));
        return;
        if (str2.equals("android.intent.action.BATTERY_OKAY"))
        {
          i = 0;
          continue;
          if (str2.equals("android.intent.action.BATTERY_LOW"))
            i = 1;
        }
        break;
      case 1:
      }
    a(Boolean.valueOf(false));
  }

  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.BATTERY_OKAY");
    localIntentFilter.addAction("android.intent.action.BATTERY_LOW");
    return localIntentFilter;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.b
 * JD-Core Version:    0.6.2
 */