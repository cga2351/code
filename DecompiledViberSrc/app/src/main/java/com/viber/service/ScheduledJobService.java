package com.viber.service;

import android.content.Intent;
import android.os.Bundle;
import com.firebase.jobdispatcher.JobService;
import com.firebase.jobdispatcher.p;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class ScheduledJobService extends JobService
{
  private static final Logger a = ViberEnv.getLogger();
  private ViberApplication b;
  private Engine.InitializedListener c;

  private boolean a()
  {
    if (this.c != null)
    {
      this.b.getEngine(false).removeInitializedListener(this.c);
      this.c = null;
    }
    return true;
  }

  private boolean c(final p paramp)
  {
    this.c = new Engine.InitializedListener()
    {
      public void initialized(Engine paramAnonymousEngine)
      {
        paramAnonymousEngine.removeInitializedListener(this);
        paramAnonymousEngine.getPhoneController().testConnection(3);
        ScheduledJobService.a(ScheduledJobService.this).getLocationManager().b();
        ScheduledJobService.this.a(paramp, false);
      }
    };
    this.b.initApplication();
    this.b.getEngine(false).addInitializedListener(this.c);
    return true;
  }

  public boolean a(p paramp)
  {
    String str = paramp.e();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1642639251:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (str.equals("keep_alive"))
          i = 0;
        break;
      case 0:
      }
    return c(paramp);
  }

  public boolean b(p paramp)
  {
    String str = paramp.e();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1642639251:
    }
    while (true)
      switch (i)
      {
      default:
        return false;
        if (str.equals("keep_alive"))
          i = 0;
        break;
      case 0:
      }
    return a();
  }

  public void onCreate()
  {
    super.onCreate();
    this.b = ViberApplication.getInstance();
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
 * Qualified Name:     com.viber.service.ScheduledJobService
 * JD-Core Version:    0.6.2
 */