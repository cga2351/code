package com.viber.voip.schedule;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask.Builder;
import com.google.android.gms.gcm.PeriodicTask.Builder;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.gcm.Task.Builder;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a;
import com.viber.voip.settings.d.bg;
import com.viber.voip.settings.d.g;
import com.viber.voip.settings.d.l;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.t;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import java.util.concurrent.TimeUnit;

public class e
{
  private static final Logger a = ViberEnv.getLogger();

  private static Task.Builder a()
  {
    long l = TimeUnit.HOURS.toSeconds(1L);
    return new OneoffTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(0).setExecutionWindow(TimeUnit.MINUTES.toSeconds(1L), l);
  }

  private static Task.Builder a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return a(paramBundle);
    case 1:
      return b();
    case 2:
      return c();
    case 3:
      return a(d.p.p);
    case 6:
      return d();
    case 4:
      return a(d.t.e);
    case 5:
      return b(d.g.f);
    case 7:
      return a(d.l.c);
    case 8:
      return a();
    case 9:
    }
    return e();
  }

  private static Task.Builder a(long paramLong, String paramString)
  {
    PeriodicTask.Builder localBuilder = new PeriodicTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(0);
    localBuilder.setPeriod(paramLong);
    return localBuilder;
  }

  private static Task.Builder a(Bundle paramBundle)
  {
    long l = c.b(paramBundle.getBundle("operation_params"));
    if (a.b(l))
      return new PeriodicTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(1).setPeriod(l).setFlex(Math.round(0.1F * (float)l));
    return null;
  }

  private static Task.Builder a(com.viber.common.b.e parame)
  {
    long l = parame.f();
    return new PeriodicTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(2).setPeriod(l).setFlex(Math.round(0.1F * (float)l));
  }

  private static Task.Builder a(h paramh)
  {
    return a(com.viber.voip.util.b.c.b, paramh.d());
  }

  private static Task a(int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Task.Builder localBuilder = a(paramInt, paramBundle);
    if (localBuilder != null)
      return localBuilder.setTag(paramString).setUpdateCurrent(paramBoolean).setExtras(ViberGcmTaskService.a(paramInt, paramBundle.getBundle("operation_params"))).build();
    return null;
  }

  public static void a(Context paramContext, int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Task localTask = a(paramInt, paramString, paramBundle, paramBoolean);
    if (localTask != null);
    try
    {
      GcmNetworkManager.getInstance(paramContext).schedule(localTask);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a.a(localIllegalArgumentException, "schedule error");
    }
  }

  public static void a(Context paramContext, String paramString)
  {
    GcmNetworkManager.getInstance(paramContext).cancelTask(paramString, ViberGcmTaskService.class);
  }

  private static Task.Builder b()
  {
    return new PeriodicTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(0).setPeriod(TimeUnit.HOURS.toSeconds(8L)).setFlex(TimeUnit.HOURS.toSeconds(1L));
  }

  private static Task.Builder b(h paramh)
  {
    long l1 = TimeUnit.DAYS.toSeconds(1L);
    long l2 = TimeUnit.HOURS.toSeconds(6L);
    return new PeriodicTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(0).setPeriod(l1).setFlex(l2);
  }

  private static Task.Builder c()
  {
    long l1 = com.viber.voip.util.b.c.a - TimeUnit.MINUTES.toSeconds(1L);
    long l2 = com.viber.voip.util.b.c.a;
    return new OneoffTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(2).setExecutionWindow(l1, l2);
  }

  private static Task.Builder d()
  {
    return a(ViberIdPromoStickerPackHelper.SYNC_VIBER_ID_PROMO_STICKERS_JSON_DELAY_MILLIS, d.bg.h.d());
  }

  private static Task.Builder e()
  {
    return new OneoffTask.Builder().setService(ViberGcmTaskService.class).setPersisted(true).setRequiredNetwork(0).setExecutionWindow(10L, TimeUnit.HOURS.toSeconds(1L));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.e
 * JD-Core Version:    0.6.2
 */