package c.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private final Application a;
  private a b;

  public a(Context paramContext)
  {
    this.a = ((Application)paramContext.getApplicationContext());
    if (Build.VERSION.SDK_INT >= 14)
      this.b = new a(this.a);
  }

  public void a()
  {
    if (this.b != null)
      a.a(this.b);
  }

  public boolean a(b paramb)
  {
    return (this.b != null) && (a.a(this.b, paramb));
  }

  private static class a
  {
    private final Set<Application.ActivityLifecycleCallbacks> a = new HashSet();
    private final Application b;

    a(Application paramApplication)
    {
      this.b = paramApplication;
    }

    @TargetApi(14)
    private void a()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)localIterator.next();
        this.b.unregisterActivityLifecycleCallbacks(localActivityLifecycleCallbacks);
      }
    }

    @TargetApi(14)
    private boolean a(final a.b paramb)
    {
      if (this.b != null)
      {
        Application.ActivityLifecycleCallbacks local1 = new Application.ActivityLifecycleCallbacks()
        {
          public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
          {
            paramb.a(paramAnonymousActivity, paramAnonymousBundle);
          }

          public void onActivityDestroyed(Activity paramAnonymousActivity)
          {
            paramb.e(paramAnonymousActivity);
          }

          public void onActivityPaused(Activity paramAnonymousActivity)
          {
            paramb.c(paramAnonymousActivity);
          }

          public void onActivityResumed(Activity paramAnonymousActivity)
          {
            paramb.b(paramAnonymousActivity);
          }

          public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
          {
            paramb.b(paramAnonymousActivity, paramAnonymousBundle);
          }

          public void onActivityStarted(Activity paramAnonymousActivity)
          {
            paramb.a(paramAnonymousActivity);
          }

          public void onActivityStopped(Activity paramAnonymousActivity)
          {
            paramb.d(paramAnonymousActivity);
          }
        };
        this.b.registerActivityLifecycleCallbacks(local1);
        this.a.add(local1);
        return true;
      }
      return false;
    }
  }

  public static abstract class b
  {
    public void a(Activity paramActivity)
    {
    }

    public void a(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void b(Activity paramActivity)
    {
    }

    public void b(Activity paramActivity, Bundle paramBundle)
    {
    }

    public void c(Activity paramActivity)
    {
    }

    public void d(Activity paramActivity)
    {
    }

    public void e(Activity paramActivity)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a
 * JD-Core Version:    0.6.2
 */