package com.viber.voip;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.analytics.a.j;
import com.viber.voip.banner.a.a.d;
import com.viber.voip.banner.a.a.f;
import com.viber.voip.messages.k;
import com.viber.voip.o.a;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.AuthSecondaryActivity;

public class ax
  implements Application.ActivityLifecycleCallbacks
{
  protected static final Logger a = ViberEnv.getLogger("ViberActivityLifecycleListener");
  private ActivationController b;
  private Application.ActivityLifecycleCallbacks c;

  ax(ActivationController paramActivationController, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.b = paramActivationController;
    this.c = paramActivityLifecycleCallbacks;
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
  }

  public void onActivityPaused(Activity paramActivity)
  {
    j.a();
    if (this.c != null)
      this.c.onActivityPaused(paramActivity);
    if ((paramActivity instanceof PhoneFragmentActivity))
    {
      d[] arrayOfd = ViberApplication.getInstance().getMessagesManager().i().a();
      int i = arrayOfd.length;
      for (int j = 0; j < i; j++)
        arrayOfd[j].b(paramActivity);
    }
  }

  public void onActivityResumed(Activity paramActivity)
  {
    if (((!y.e()) || (paramActivity == null) || (paramActivity.getClass() != y.d())) && (a.a() == a.a))
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      if (!localViberApplication.isInitApplicationCalled())
        localViberApplication.initApplication();
      if ((paramActivity != null) && (!(paramActivity instanceof AuthSecondaryActivity)) && (this.b.isSecureActivation()))
        paramActivity.startActivity(new Intent(paramActivity, AuthSecondaryActivity.class));
      if ((paramActivity instanceof PhoneFragmentActivity))
      {
        d[] arrayOfd = localViberApplication.getMessagesManager().i().a();
        int i = arrayOfd.length;
        for (int j = 0; j < i; j++)
          arrayOfd[j].a(paramActivity);
      }
    }
    j.b();
    if (this.c != null)
      this.c.onActivityResumed(paramActivity);
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityStarted(Activity paramActivity)
  {
  }

  public void onActivityStopped(Activity paramActivity)
  {
    if (this.c != null)
      this.c.onActivityStopped(paramActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ax
 * JD-Core Version:    0.6.2
 */