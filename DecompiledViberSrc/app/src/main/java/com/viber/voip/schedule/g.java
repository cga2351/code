package com.viber.voip.schedule;

import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a;
import com.viber.voip.backup.auto.b;
import com.viber.voip.settings.d.j;
import java.util.concurrent.TimeUnit;

public class g
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();

  public static void a()
  {
    a locala = a.a(d.j.g.d());
    if (locala.b())
    {
      Application localApplication = ViberApplication.getApplication();
      GcmNetworkManager.getInstance(localApplication).cancelTask(p.a(p.a.a.k), ViberGcmTaskService.class);
      long l1 = d.j.k.d();
      long l2 = locala.a() - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - l1);
      if ((l2 <= 0L) || (l2 > a.e.a()))
        l2 = TimeUnit.MILLISECONDS.toSeconds(b.a);
      Bundle localBundle = p.a(c.a(Math.max(l2, TimeUnit.MINUTES.toSeconds(15L))), true);
      p.a.a.a(localApplication, localBundle, false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.g
 * JD-Core Version:    0.6.2
 */