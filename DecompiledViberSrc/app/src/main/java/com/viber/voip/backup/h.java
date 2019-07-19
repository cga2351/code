package com.viber.voip.backup;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.service.ServiceStateDelegate.ServiceState;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.d.a;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.j;
import com.viber.voip.user.UserManager;

public class h
  implements ConnectionDelegate, j
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final g c;
  private final f d;
  private final Handler e;
  private d.a f;
  private boolean g;

  public h(Context paramContext, g paramg, f paramf, Handler paramHandler)
  {
    this.b = paramContext.getApplicationContext();
    this.c = paramg;
    this.d = paramf;
    this.e = paramHandler;
  }

  private boolean b()
  {
    BackupInfo localBackupInfo = this.d.e();
    return (localBackupInfo.isBackupExists()) && ((1 > localBackupInfo.getMetaDataVersion()) || (d.j.l.d()));
  }

  private void c()
  {
    if (b())
    {
      com.viber.voip.backup.b.b localb = new com.viber.voip.backup.b.b(this.b.getApplicationContext(), this.d);
      af localaf = UserManager.from(this.b).getRegistrationValues();
      com.viber.voip.backup.f.h localh = new com.viber.voip.backup.f.h(localaf.l(), localaf.g(), localb.b(), f.b());
      this.c.b(localaf.g(), localh);
    }
  }

  public void a()
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        d.j.l.a(true);
        if (h.a(h.this))
          h.b(h.this);
      }
    });
  }

  public void a(Uri paramUri, int paramInt)
  {
  }

  public void a(Uri paramUri, com.viber.voip.backup.c.d paramd)
  {
    if (t.f(paramUri));
  }

  public void a(Engine paramEngine)
  {
    ServiceStateDelegate.ServiceState localServiceState = paramEngine.getServiceState();
    new k(this, this.e).a(this.c);
    paramEngine.getDelegatesManager().getConnectionListener().registerDelegate(this, this.e);
    if (ServiceStateDelegate.ServiceState.SERVICE_CONNECTED == localServiceState)
    {
      this.g = true;
      a();
    }
    this.f = new d.a(this.e, false)
    {
      public void a()
      {
        if (ViberApplication.isActivated())
          h.this.a();
      }
    };
    com.viber.voip.memberid.d.a(this.f);
  }

  public boolean a(Uri paramUri)
  {
    return t.f(paramUri);
  }

  public void b(Uri paramUri)
  {
    if (t.f(paramUri))
      d.j.l.a(false);
    while (!t.e(paramUri))
      return;
    c();
  }

  public void c(Uri paramUri)
  {
    if (t.f(paramUri));
  }

  public void onConnect()
  {
  }

  public void onConnectionStateChange(int paramInt)
  {
    if (paramInt == 3)
    {
      this.g = true;
      c();
      return;
    }
    this.g = false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.h
 * JD-Core Version:    0.6.2
 */