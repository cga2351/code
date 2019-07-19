package dagger.android;

import android.app.Application;
import com.google.errorprone.annotations.ForOverride;

public abstract class DaggerApplication extends Application
  implements e, f
{
  private volatile boolean a = true;

  private void d()
  {
    if (this.a)
      try
      {
        if (this.a)
        {
          a().a(this);
          if (this.a)
            throw new IllegalStateException("The AndroidInjector returned from applicationInjector() did not inject the DaggerApplication");
        }
      }
      finally
      {
      }
  }

  @ForOverride
  protected abstract b<? extends DaggerApplication> a();

  public void onCreate()
  {
    super.onCreate();
    d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.DaggerApplication
 * JD-Core Version:    0.6.2
 */