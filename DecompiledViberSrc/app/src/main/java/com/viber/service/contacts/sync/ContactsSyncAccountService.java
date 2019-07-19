package com.viber.service.contacts.sync;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.p;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.p;
import com.viber.voip.user.UserManager;

public class ContactsSyncAccountService extends JobService
{
  private static final Logger a = ViberEnv.getLogger();
  private Application b = ViberApplication.getApplication();
  private Handler c = av.a(av.e.h);

  private boolean c(final p paramp)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        new com.viber.service.contacts.sync.b.a(ContactsSyncAccountService.a(ContactsSyncAccountService.this)).e();
        ContactsSyncAccountService.this.a(paramp, false);
      }
    });
    return true;
  }

  private boolean d(final p paramp)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        new com.viber.service.contacts.sync.b.a(ContactsSyncAccountService.a(ContactsSyncAccountService.this)).a();
        ContactsSyncAccountService.this.a(paramp, false);
      }
    });
    return true;
  }

  private boolean e(final p paramp)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        String str = UserManager.from(ContactsSyncAccountService.a(ContactsSyncAccountService.this)).getRegistrationValues().h();
        if (ao.f());
        for (Object localObject = new com.viber.service.contacts.sync.a.a.b.b(ContactsSyncAccountService.a(ContactsSyncAccountService.this), str); ; localObject = new com.viber.service.contacts.sync.a.a.a.a.b(ContactsSyncAccountService.a(ContactsSyncAccountService.this), str))
        {
          new com.viber.service.contacts.sync.b.b(ContactsSyncAccountService.this.getApplication(), (com.viber.service.contacts.sync.a.a)localObject).a();
          ContactsSyncAccountService.this.a(paramp, false);
          return;
        }
      }
    });
    return true;
  }

  private boolean f(final p paramp)
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        new com.viber.service.contacts.sync.b.a(ContactsSyncAccountService.a(ContactsSyncAccountService.this)).b();
        ContactsSyncAccountService.this.a(paramp, false);
      }
    });
    return true;
  }

  public boolean a(p paramp)
  {
    int i;
    try
    {
      String str = paramp.e();
      i = -1;
      switch (str.hashCode())
      {
      case -1164084998:
        if (str.equals("sync_account_remove"))
          i = 0;
        break;
      case -882606638:
        if (str.equals("sync_account_check"))
          i = 1;
        break;
      case -1829093231:
        if (str.equals("sync_account_sync"))
          i = 2;
        break;
      case -1164068940:
        if (str.equals("sync_account_rename"))
        {
          i = 3;
          break;
          return c(paramp);
          return d(paramp);
          return e(paramp);
          boolean bool = f(paramp);
          return bool;
        }
        break;
      }
    }
    catch (Exception localException)
    {
      d.p.g.a(false);
      return false;
    }
    switch (i)
    {
    case 0:
    case 1:
    case 2:
    case 3:
    }
    return false;
  }

  public boolean b(p paramp)
  {
    return false;
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new c(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new b(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.service.contacts.sync.ContactsSyncAccountService
 * JD-Core Version:    0.6.2
 */