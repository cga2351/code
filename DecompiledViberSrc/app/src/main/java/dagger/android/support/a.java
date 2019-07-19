package dagger.android.support;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import dagger.a.h;

public final class a
{
  public static void a(Fragment paramFragment)
  {
    h.a(paramFragment, "fragment");
    b localb = b(paramFragment);
    if (Log.isLoggable("dagger.android.support", 3))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramFragment.getClass().getCanonicalName();
      arrayOfObject[1] = localb.getClass().getCanonicalName();
      Log.d("dagger.android.support", String.format("An injector for %s was found in %s", arrayOfObject));
    }
    dagger.android.b localb1 = localb.supportFragmentInjector();
    h.a(localb1, "%s.supportFragmentInjector() returned null", localb.getClass());
    localb1.a(paramFragment);
  }

  private static b b(Fragment paramFragment)
  {
    Fragment localFragment = paramFragment;
    do
    {
      localFragment = localFragment.getParentFragment();
      if (localFragment == null)
        break;
    }
    while (!(localFragment instanceof b));
    return (b)localFragment;
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    if ((localFragmentActivity instanceof b))
      return (b)localFragmentActivity;
    if ((localFragmentActivity.getApplication() instanceof b))
      return (b)localFragmentActivity.getApplication();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramFragment.getClass().getCanonicalName();
    throw new IllegalArgumentException(String.format("No injector was found for %s", arrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.support.a
 * JD-Core Version:    0.6.2
 */