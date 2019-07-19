package android.support.v4.content.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;

public final class ConfigurationHelper
{
  public static int getDensityDpi(Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return paramResources.getConfiguration().densityDpi;
    return paramResources.getDisplayMetrics().densityDpi;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.ConfigurationHelper
 * JD-Core Version:    0.6.2
 */