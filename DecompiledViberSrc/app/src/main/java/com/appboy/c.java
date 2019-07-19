package com.appboy;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.appboy.push.AppboyNotificationRoutingActivity;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import java.util.Collections;
import java.util.Set;

public class c
  implements Application.ActivityLifecycleCallbacks
{
  private static final String a = com.appboy.f.c.a(c.class);
  private final boolean b;
  private final boolean c;
  private Set<Class> d;
  private Set<Class> e;

  public c()
  {
    this(true, true, Collections.emptySet(), Collections.emptySet());
  }

  public c(boolean paramBoolean1, boolean paramBoolean2, Set<Class> paramSet1, Set<Class> paramSet2)
  {
    this.b = paramBoolean2;
    this.c = paramBoolean1;
    if (paramSet1 != null)
    {
      this.d = paramSet1;
      if (paramSet2 == null)
        break label100;
    }
    while (true)
    {
      this.e = paramSet2;
      com.appboy.f.c.a(a, "AppboyLifecycleCallbackListener using in-app messaging blacklist: " + this.d);
      com.appboy.f.c.a(a, "AppboyLifecycleCallbackListener using session handling blacklist: " + this.e);
      return;
      paramSet1 = Collections.emptySet();
      break;
      label100: paramSet2 = Collections.emptySet();
    }
  }

  private boolean a(Activity paramActivity, boolean paramBoolean)
  {
    boolean bool = true;
    Class localClass = paramActivity.getClass();
    if (localClass.equals(AppboyNotificationRoutingActivity.class))
      bool = false;
    do
    {
      do
      {
        return bool;
        if (!paramBoolean)
          break;
      }
      while (!this.e.contains(localClass));
      return false;
    }
    while (!this.d.contains(localClass));
    return false;
  }

  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((this.b) && (a(paramActivity, false)))
      AppboyInAppMessageManager.getInstance().ensureSubscribedToInAppMessageEvents(paramActivity.getApplicationContext());
  }

  public void onActivityDestroyed(Activity paramActivity)
  {
  }

  public void onActivityPaused(Activity paramActivity)
  {
    if ((this.b) && (a(paramActivity, false)))
      AppboyInAppMessageManager.getInstance().unregisterInAppMessageManager(paramActivity);
  }

  public void onActivityResumed(Activity paramActivity)
  {
    if ((this.b) && (a(paramActivity, false)))
      AppboyInAppMessageManager.getInstance().registerInAppMessageManager(paramActivity);
  }

  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public void onActivityStarted(Activity paramActivity)
  {
    if ((this.c) && (a(paramActivity, true)))
      a.a(paramActivity.getApplicationContext()).a(paramActivity);
  }

  public void onActivityStopped(Activity paramActivity)
  {
    if ((this.c) && (a(paramActivity, true)))
      a.a(paramActivity.getApplicationContext()).b(paramActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.c
 * JD-Core Version:    0.6.2
 */