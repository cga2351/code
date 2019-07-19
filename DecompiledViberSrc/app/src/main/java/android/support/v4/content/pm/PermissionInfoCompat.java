package android.support.v4.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build.VERSION;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat
{
  @SuppressLint({"WrongConstant"})
  public static int getProtection(PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramPermissionInfo.getProtection();
    return 0xF & paramPermissionInfo.protectionLevel;
  }

  @SuppressLint({"WrongConstant"})
  public static int getProtectionFlags(PermissionInfo paramPermissionInfo)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramPermissionInfo.getProtectionFlags();
    return 0xFFFFFFF0 & paramPermissionInfo.protectionLevel;
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Protection
  {
  }

  @Retention(RetentionPolicy.SOURCE)
  @SuppressLint({"UniqueConstants"})
  public static @interface ProtectionFlags
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.pm.PermissionInfoCompat
 * JD-Core Version:    0.6.2
 */