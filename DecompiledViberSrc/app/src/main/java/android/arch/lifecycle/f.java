package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks;
import android.support.v4.app.FragmentTransaction;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class f
{
  private static AtomicBoolean a = new AtomicBoolean(false);

  static void a(Context paramContext)
  {
    if (a.getAndSet(true))
      return;
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new b());
  }

  private static void a(FragmentManager paramFragmentManager, e.b paramb)
  {
    List localList = paramFragmentManager.getFragments();
    if (localList == null);
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment != null)
        {
          a(localFragment, paramb);
          if (localFragment.isAdded())
            a(localFragment.getChildFragmentManager(), paramb);
        }
      }
    }
  }

  private static void a(Object paramObject, e.b paramb)
  {
    if ((paramObject instanceof j))
      ((j)paramObject).a().a(paramb);
  }

  private static void b(Fragment paramFragment, e.a parama)
  {
    if ((paramFragment instanceof j))
      ((j)paramFragment).a().a(parama);
  }

  private static void b(FragmentActivity paramFragmentActivity, e.b paramb)
  {
    a(paramFragmentActivity, paramb);
    a(paramFragmentActivity.getSupportFragmentManager(), paramb);
  }

  public static class a extends Fragment
  {
    protected void a(e.a parama)
    {
      f.a(getParentFragment(), parama);
    }

    public void onDestroy()
    {
      super.onDestroy();
      a(e.a.ON_DESTROY);
    }

    public void onPause()
    {
      super.onPause();
      a(e.a.ON_PAUSE);
    }

    public void onStop()
    {
      super.onStop();
      a(e.a.ON_STOP);
    }
  }

  static class b extends c
  {
    private final f.c a = new f.c();

    public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity))
        ((FragmentActivity)paramActivity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.a, true);
      q.a(paramActivity);
    }

    public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
    {
      if ((paramActivity instanceof FragmentActivity))
        f.a((FragmentActivity)paramActivity, e.b.c);
    }

    public void onActivityStopped(Activity paramActivity)
    {
      if ((paramActivity instanceof FragmentActivity))
        f.a((FragmentActivity)paramActivity, e.b.c);
    }
  }

  static class c extends FragmentManager.FragmentLifecycleCallbacks
  {
    public void onFragmentCreated(FragmentManager paramFragmentManager, Fragment paramFragment, Bundle paramBundle)
    {
      f.a(paramFragment, e.a.ON_CREATE);
      if (!(paramFragment instanceof j));
      while (paramFragment.getChildFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") != null)
        return;
      paramFragment.getChildFragmentManager().beginTransaction().add(new f.a(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
    }

    public void onFragmentResumed(FragmentManager paramFragmentManager, Fragment paramFragment)
    {
      f.a(paramFragment, e.a.ON_RESUME);
    }

    public void onFragmentStarted(FragmentManager paramFragmentManager, Fragment paramFragment)
    {
      f.a(paramFragment, e.a.ON_START);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.f
 * JD-Core Version:    0.6.2
 */