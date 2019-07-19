package dagger.android;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import dagger.a.h;

public final class a
{
  public static void a(Activity paramActivity)
  {
    h.a(paramActivity, "activity");
    Application localApplication = paramActivity.getApplication();
    if (!(localApplication instanceof e))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localApplication.getClass().getCanonicalName();
      arrayOfObject[1] = e.class.getCanonicalName();
      throw new RuntimeException(String.format("%s does not implement %s", arrayOfObject));
    }
    b localb = ((e)localApplication).b();
    h.a(localb, "%s.activityInjector() returned null", localApplication.getClass());
    localb.a(paramActivity);
  }

  public static void a(Service paramService)
  {
    h.a(paramService, "service");
    Application localApplication = paramService.getApplication();
    if (!(localApplication instanceof f))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localApplication.getClass().getCanonicalName();
      arrayOfObject[1] = f.class.getCanonicalName();
      throw new RuntimeException(String.format("%s does not implement %s", arrayOfObject));
    }
    b localb = ((f)localApplication).c();
    h.a(localb, "%s.serviceInjector() returned null", localApplication.getClass());
    localb.a(paramService);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.a
 * JD-Core Version:    0.6.2
 */