package com.viber.voip.schedule;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.backup.a;
import com.viber.voip.backup.auto.d;
import com.viber.voip.backup.g;
import com.viber.voip.settings.d.j;
import com.viber.voip.util.ViberActionRunner.h;

public class c
  implements f
{
  private static final com.viber.common.a.e a = ViberEnv.getLogger();

  public static Bundle a(long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("auto_backup_period", paramLong);
    return localBundle;
  }

  private void a(Context paramContext)
  {
    com.viber.voip.backup.auto.b localb = new com.viber.voip.backup.auto.b(d.j.k);
    d locald = new d(d.j.j);
    final com.viber.voip.backup.b localb1 = new com.viber.voip.backup.b(paramContext, d.j.g, localb, locald, p.a.a);
    av.a(av.e.f).postDelayed(new Runnable()
    {
      public void run()
      {
        localb1.a(a.b);
      }
    }
    , 100L);
  }

  private void a(Context paramContext, a parama)
  {
    p.a.a.a(paramContext, p.a(a(parama.a())), true);
  }

  public static long b(Bundle paramBundle)
  {
    if (paramBundle != null)
      return paramBundle.getLong("auto_backup_period", a.a.a());
    return a.a.a();
  }

  private void b(Context paramContext, a parama)
  {
    if (new com.viber.voip.backup.auto.c(g.a(), new com.viber.voip.backup.auto.b(d.j.k), new d(d.j.j)).a(parama, System.currentTimeMillis()))
      ViberActionRunner.h.a(paramContext, parama);
  }

  public int a(Bundle paramBundle)
  {
    Application localApplication = ViberApplication.getApplication();
    a locala = a.a(d.j.g.d());
    if (locala.b())
    {
      b(localApplication, locala);
      if ((paramBundle != null) && (paramBundle.getBoolean("re_schedule", false)));
      for (int i = 1; ; i = 0)
      {
        if (i != 0)
          a(localApplication, locala);
        return 0;
      }
    }
    a(localApplication);
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.c
 * JD-Core Version:    0.6.2
 */