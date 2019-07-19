package com.yandex.metrica.impl.ob;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.yandex.metrica.ConfigurationService;

public class eq
  implements ep, es
{
  private final Context a;
  private final AlarmManager b;
  private on c;

  public eq(Context paramContext)
  {
    this(paramContext, (AlarmManager)paramContext.getSystemService("alarm"), new om());
  }

  eq(Context paramContext, AlarmManager paramAlarmManager, on paramon)
  {
    this.a = paramContext;
    this.b = paramAlarmManager;
    this.c = paramon;
  }

  private static PendingIntent a(Context paramContext)
  {
    return PendingIntent.getService(paramContext, 7695435, b(paramContext), 134217728);
  }

  private static Intent b(Context paramContext)
  {
    return new Intent(paramContext, ConfigurationService.class).setAction("com.yandex.metrica.configuration.ACTION_SCHEDULED_START");
  }

  public void a()
  {
    PendingIntent localPendingIntent = a(this.a);
    this.b.cancel(localPendingIntent);
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    PendingIntent localPendingIntent = a(this.a);
    this.b.set(3, paramLong + this.c.c(), localPendingIntent);
  }

  public void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent().setComponent(new ComponentName(this.a.getPackageName(), ConfigurationService.class.getName())).setAction("com.yandex.metrica.configuration.ACTION_INIT").putExtras(paramBundle);
    try
    {
      this.a.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.eq
 * JD-Core Version:    0.6.2
 */