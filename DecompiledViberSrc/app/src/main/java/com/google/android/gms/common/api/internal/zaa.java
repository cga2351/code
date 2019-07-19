package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zaa extends ActivityLifecycleObserver
{
  private final WeakReference<zaa> zack;

  public zaa(Activity paramActivity)
  {
    this(zaa.zab(paramActivity));
  }

  private zaa(zaa paramzaa)
  {
    this.zack = new WeakReference(paramzaa);
  }

  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    zaa localzaa = (zaa)this.zack.get();
    if (localzaa == null)
      throw new IllegalStateException("The target activity has already been GC'd");
    zaa.zaa(localzaa, paramRunnable);
    return this;
  }

  static class zaa extends LifecycleCallback
  {
    private List<Runnable> zacl = new ArrayList();

    private zaa(LifecycleFragment paramLifecycleFragment)
    {
      super();
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    private static zaa zaa(Activity paramActivity)
    {
      try
      {
        LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
        zaa localzaa = (zaa)localLifecycleFragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
        if (localzaa == null)
          localzaa = new zaa(localLifecycleFragment);
        return localzaa;
      }
      finally
      {
      }
    }

    private final void zaa(Runnable paramRunnable)
    {
      try
      {
        this.zacl.add(paramRunnable);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onStop()
    {
      try
      {
        List localList = this.zacl;
        this.zacl = new ArrayList();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          ((Runnable)localIterator.next()).run();
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaa
 * JD-Core Version:    0.6.2
 */