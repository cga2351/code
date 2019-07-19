package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.c;
import androidx.work.i;
import java.util.Iterator;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver
{
  private static final String a = i.a("ConstraintProxy");

  static void a(Context paramContext, List<androidx.work.impl.b.j> paramList)
  {
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    int i;
    label85: boolean bool5;
    if (localIterator.hasNext())
    {
      c localc = ((androidx.work.impl.b.j)localIterator.next()).j;
      bool4 |= localc.d();
      bool3 |= localc.b();
      bool2 |= localc.e();
      if (localc.a() != androidx.work.j.a)
      {
        i = 1;
        bool5 = i | bool1;
        if ((!bool4) || (!bool3) || (!bool2) || (!bool5))
          break label134;
      }
    }
    while (true)
    {
      paramContext.sendBroadcast(ConstraintProxyUpdateReceiver.a(paramContext, bool4, bool3, bool2, bool5));
      return;
      i = 0;
      break label85;
      label134: bool1 = bool5;
      break;
      bool5 = bool1;
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    i.a().b(a, String.format("onReceive : %s", new Object[] { paramIntent }), new Throwable[0]);
    paramContext.startService(b.a(paramContext));
  }

  public static class BatteryChargingProxy extends ConstraintProxy
  {
  }

  public static class BatteryNotLowProxy extends ConstraintProxy
  {
  }

  public static class NetworkStateProxy extends ConstraintProxy
  {
  }

  public static class StorageNotLowProxy extends ConstraintProxy
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.ConstraintProxy
 * JD-Core Version:    0.6.2
 */