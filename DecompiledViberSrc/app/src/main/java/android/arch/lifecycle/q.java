package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class q extends Fragment
{
  private a a;

  public static void a(Activity paramActivity)
  {
    FragmentManager localFragmentManager = paramActivity.getFragmentManager();
    if (localFragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null)
    {
      localFragmentManager.beginTransaction().add(new q(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
      localFragmentManager.executePendingTransactions();
    }
  }

  private void a(e.a parama)
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof j))
      ((j)localActivity).a().a(parama);
    e locale;
    do
    {
      do
        return;
      while (!(localActivity instanceof h));
      locale = ((h)localActivity).getLifecycle();
    }
    while (!(locale instanceof i));
    ((i)locale).a(parama);
  }

  static q b(Activity paramActivity)
  {
    return (q)paramActivity.getFragmentManager().findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag");
  }

  private void b(a parama)
  {
    if (parama != null)
      parama.a();
  }

  private void c(a parama)
  {
    if (parama != null)
      parama.b();
  }

  private void d(a parama)
  {
    if (parama != null)
      parama.c();
  }

  void a(a parama)
  {
    this.a = parama;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    b(this.a);
    a(e.a.ON_CREATE);
  }

  public void onDestroy()
  {
    super.onDestroy();
    a(e.a.ON_DESTROY);
    this.a = null;
  }

  public void onPause()
  {
    super.onPause();
    a(e.a.ON_PAUSE);
  }

  public void onResume()
  {
    super.onResume();
    d(this.a);
    a(e.a.ON_RESUME);
  }

  public void onStart()
  {
    super.onStart();
    c(this.a);
    a(e.a.ON_START);
  }

  public void onStop()
  {
    super.onStop();
    a(e.a.ON_STOP);
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void b();

    public abstract void c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.q
 * JD-Core Version:    0.6.2
 */