package com.viber.voip.messages.ui.media.player.d;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.d;
import com.viber.voip.util.d.b;
import com.viber.voip.util.i;

class c
  implements Application.ActivityLifecycleCallbacks, d.b
{
  private static final e a = ViberEnv.getLogger();
  private final Application b;
  private final e.e c;
  private final d d;
  private boolean e;
  private final Handler f;
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      c.b(c.this).b(c.a(c.this));
    }
  };

  c(Application paramApplication, d paramd, Handler paramHandler, e.e parame)
  {
    this.b = paramApplication;
    this.d = paramd;
    this.f = paramHandler;
    this.c = parame;
  }

  private void a(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      this.f.removeCallbacks(this.g);
      this.f.post(this.g);
    }
  }

  private boolean a(Activity paramActivity)
  {
    PackageManager localPackageManager = paramActivity.getPackageManager();
    ComponentName localComponentName = paramActivity.getComponentName();
    try
    {
      int i = localPackageManager.getActivityInfo(localComponentName, 0).launchMode;
      boolean bool = false;
      if (i == 3)
        bool = true;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public void a()
  {
    this.b.registerActivityLifecycleCallbacks(this);
    this.e = false;
    d.c(this);
  }

  public void b()
  {
    this.b.unregisterActivityLifecycleCallbacks(this);
    d.d(this);
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
  }

  public void onActivityPaused(Activity paramActivity)
  {
    if ((paramActivity.isFinishing()) && (paramActivity.isTaskRoot()) && (!a(paramActivity)))
      this.c.a();
  }

  public void onActivityResumed(Activity paramActivity)
  {
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityStarted(Activity paramActivity)
  {
  }

  public void onActivityStopped(Activity paramActivity)
  {
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    a(true);
  }

  public void onForeground()
  {
    a(false);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.c
 * JD-Core Version:    0.6.2
 */