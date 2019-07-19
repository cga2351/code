package com.mopub.common;

import android.app.Activity;
import com.mopub.common.privacy.PersonalInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MoPubLifecycleManager
  implements LifecycleListener
{
  private static MoPubLifecycleManager a;
  private final Set<LifecycleListener> b = new HashSet();
  private final WeakReference<Activity> c;

  private MoPubLifecycleManager(Activity paramActivity)
  {
    this.c = new WeakReference(paramActivity);
  }

  public static MoPubLifecycleManager getInstance(Activity paramActivity)
  {
    try
    {
      if (a == null)
        a = new MoPubLifecycleManager(paramActivity);
      MoPubLifecycleManager localMoPubLifecycleManager = a;
      return localMoPubLifecycleManager;
    }
    finally
    {
    }
  }

  public void addLifecycleListener(LifecycleListener paramLifecycleListener)
  {
    if (paramLifecycleListener == null);
    Activity localActivity;
    do
    {
      do
        return;
      while (!this.b.add(paramLifecycleListener));
      localActivity = (Activity)this.c.get();
    }
    while (localActivity == null);
    paramLifecycleListener.onCreate(localActivity);
    paramLifecycleListener.onStart(localActivity);
  }

  public void onBackPressed(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onBackPressed(paramActivity);
  }

  public void onCreate(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onCreate(paramActivity);
  }

  public void onDestroy(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onDestroy(paramActivity);
  }

  public void onPause(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onPause(paramActivity);
  }

  public void onRestart(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onRestart(paramActivity);
  }

  public void onResume(Activity paramActivity)
  {
    PersonalInfoManager localPersonalInfoManager = MoPub.getPersonalInformationManager();
    if (localPersonalInfoManager != null)
      localPersonalInfoManager.requestSync(false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onResume(paramActivity);
  }

  public void onStart(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onStart(paramActivity);
  }

  public void onStop(Activity paramActivity)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((LifecycleListener)localIterator.next()).onStop(paramActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.MoPubLifecycleManager
 * JD-Core Version:    0.6.2
 */