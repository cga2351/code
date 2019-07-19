package android.support.v4.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build.VERSION;

public final class PackageInfoCompat
{
  public static long getLongVersionCode(PackageInfo paramPackageInfo)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramPackageInfo.getLongVersionCode();
    return paramPackageInfo.versionCode;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.pm.PackageInfoCompat
 * JD-Core Version:    0.6.2
 */