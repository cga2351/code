package com.viber.voip.schedule;

import android.os.Bundle;
import androidx.work.c.a;
import androidx.work.f;
import androidx.work.j;
import androidx.work.m;
import androidx.work.m.a;
import androidx.work.p;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.a;
import java.util.concurrent.TimeUnit;

public class u
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    b(paramInt, paramString, paramBundle, paramBoolean);
  }

  public static void a(String paramString)
  {
    p.a().a(paramString);
  }

  private static void a(String paramString, boolean paramBoolean, m paramm)
  {
    p localp;
    if (paramm != null)
    {
      localp = p.a();
      if (!paramBoolean)
        break label27;
    }
    label27: for (f localf = f.a; ; localf = f.b)
    {
      localp.a(paramString, localf, paramm);
      return;
    }
  }

  private static void b(int paramInt, String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    long l = c.b(paramBundle.getBundle("operation_params"));
    if (!a.b(l))
      return;
    androidx.work.c localc = new c.a().a(j.c).a();
    a(paramString, paramBoolean, (m)((m.a)((m.a)((m.a)new m.a(ViberWorkManagerTaskService.class, l, TimeUnit.SECONDS, Math.round(0.1F * (float)l), TimeUnit.SECONDS).a(localc)).a(paramString)).a(ViberWorkManagerTaskService.a(paramInt, paramBundle.getBundle("operation_params")))).e());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.u
 * JD-Core Version:    0.6.2
 */