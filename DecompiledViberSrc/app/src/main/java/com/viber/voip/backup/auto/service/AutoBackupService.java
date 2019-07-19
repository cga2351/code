package com.viber.voip.backup.auto.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.service.ViberIntentService;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.o;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.j;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cj;

public class AutoBackupService extends ViberIntentService
{
  private static final Logger a = ViberEnv.getLogger();
  private b b;
  private a c;

  public AutoBackupService()
  {
    super("AutoBackupService");
  }

  public static Intent a(Context paramContext, com.viber.voip.backup.a parama)
  {
    Intent localIntent = new Intent(paramContext, AutoBackupService.class);
    localIntent.putExtra("auto_backup_period", parama.a());
    return localIntent;
  }

  private static com.viber.voip.backup.a a(Intent paramIntent)
  {
    if (paramIntent == null)
      return com.viber.voip.backup.a.a;
    return com.viber.voip.backup.a.a(paramIntent.getLongExtra("auto_backup_period", com.viber.voip.backup.a.b.a()));
  }

  private void a(com.viber.voip.backup.a parama)
  {
    this.b = new a(this, com.viber.voip.notif.g.a(this).f(), null);
    this.b.a();
    PowerManager.WakeLock localWakeLock = ((PowerManager)getSystemService("power")).newWakeLock(1, getClass().getCanonicalName());
    af localaf = UserManager.from(this).getRegistrationValues();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    Engine localEngine = localViberApplication.getEngine(true);
    com.viber.voip.backup.c localc = localViberApplication.getBackupBackgroundListener();
    com.viber.voip.backup.g.a locala = new com.viber.voip.backup.g.b().a(this, 1);
    com.viber.voip.backup.f.g localg = new com.viber.voip.backup.f.g(localaf.l(), localaf.g(), new com.viber.voip.backup.b.b(this).b(), com.viber.voip.backup.f.b(), new com.viber.voip.backup.b.f(cj.a(this)));
    com.viber.voip.backup.d.a.b localb = new com.viber.voip.backup.d.a.d().a();
    com.viber.voip.analytics.g localg1 = com.viber.voip.analytics.g.a();
    c localc1 = new c(localaf.g(), localaf.l(), localEngine, locala, localg, parama, localb, localg1, localg1.c().c());
    com.viber.voip.backup.g localg2 = com.viber.voip.backup.g.a();
    com.viber.voip.backup.auto.b localb1 = new com.viber.voip.backup.auto.b(d.j.k);
    com.viber.voip.backup.auto.d locald = new com.viber.voip.backup.auto.d(d.j.j);
    this.c = new a(localWakeLock, localg2, localc1, localc, localb1, locald, new com.viber.voip.backup.auto.c(localg2, localb1, locald), this.b);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null)
      this.b.b();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    a(a(paramIntent));
    this.c.a(System.currentTimeMillis());
  }

  private static class a
    implements b
  {
    private final Service a;
    private final com.viber.voip.notif.e.a b;

    private a(Service paramService, com.viber.voip.notif.e.a parama)
    {
      this.a = paramService;
      this.b = parama;
    }

    public void a()
    {
      this.b.a(this.a);
    }

    public void a(int paramInt)
    {
      this.b.a(paramInt);
    }

    public void b()
    {
      this.b.b(this.a);
    }

    public void c()
    {
      this.b.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.auto.service.AutoBackupService
 * JD-Core Version:    0.6.2
 */