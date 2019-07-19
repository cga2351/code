package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ConnectivityManagerCompat
{
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (localNetworkInfo != null)
      return paramConnectivityManager.getNetworkInfo(localNetworkInfo.getType());
    return null;
  }

  public static int getRestrictBackgroundStatus(ConnectivityManager paramConnectivityManager)
  {
    if (Build.VERSION.SDK_INT >= 24)
      return paramConnectivityManager.getRestrictBackgroundStatus();
    return 3;
  }

  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16)
      bool = paramConnectivityManager.isActiveNetworkMetered();
    NetworkInfo localNetworkInfo;
    do
    {
      return bool;
      localNetworkInfo = paramConnectivityManager.getActiveNetworkInfo();
    }
    while (localNetworkInfo == null);
    switch (localNetworkInfo.getType())
    {
    case 0:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 8:
    default:
      return bool;
    case 1:
    case 7:
    case 9:
    }
    return false;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface RestrictBackgroundStatus
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat
 * JD-Core Version:    0.6.2
 */