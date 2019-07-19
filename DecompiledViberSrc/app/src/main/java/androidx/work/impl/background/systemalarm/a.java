package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.d;
import androidx.work.impl.b.e;
import androidx.work.impl.h;
import androidx.work.impl.utils.c;

class a
{
  private static final String a = i.a("Alarms");

  public static void a(Context paramContext, h paramh, String paramString)
  {
    e locale = paramh.d().p();
    d locald = locale.a(paramString);
    if (locald != null)
    {
      a(paramContext, paramString, locald.b);
      i.a().b(a, String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[] { paramString }), new Throwable[0]);
      locale.b(paramString);
    }
  }

  public static void a(Context paramContext, h paramh, String paramString, long paramLong)
  {
    e locale = paramh.d().p();
    d locald = locale.a(paramString);
    if (locald != null)
    {
      a(paramContext, paramString, locald.b);
      a(paramContext, paramString, locald.b, paramLong);
      return;
    }
    int i = new c(paramContext).a();
    locale.a(new d(paramString, i));
    a(paramContext, paramString, i, paramLong);
  }

  private static void a(Context paramContext, String paramString, int paramInt)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    PendingIntent localPendingIntent = PendingIntent.getService(paramContext, paramInt, b.b(paramContext, paramString), 536870912);
    if ((localPendingIntent != null) && (localAlarmManager != null))
    {
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      locali.b(str, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", arrayOfObject), new Throwable[0]);
      localAlarmManager.cancel(localPendingIntent);
    }
  }

  private static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    PendingIntent localPendingIntent = PendingIntent.getService(paramContext, paramInt, b.b(paramContext, paramString), 1073741824);
    if (localAlarmManager != null)
    {
      if (Build.VERSION.SDK_INT >= 19)
        localAlarmManager.setExact(0, paramLong, localPendingIntent);
    }
    else
      return;
    localAlarmManager.set(0, paramLong, localPendingIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.a
 * JD-Core Version:    0.6.2
 */