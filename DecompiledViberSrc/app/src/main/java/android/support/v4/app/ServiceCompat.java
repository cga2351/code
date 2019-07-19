package android.support.v4.app;

import android.app.Service;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat
{
  public static final int START_STICKY = 1;
  public static final int STOP_FOREGROUND_DETACH = 2;
  public static final int STOP_FOREGROUND_REMOVE = 1;

  public static void stopForeground(Service paramService, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramService.stopForeground(paramInt);
      return;
    }
    if ((paramInt & 0x1) != 0);
    for (boolean bool = true; ; bool = false)
    {
      paramService.stopForeground(bool);
      return;
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface StopForegroundFlags
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.ServiceCompat
 * JD-Core Version:    0.6.2
 */