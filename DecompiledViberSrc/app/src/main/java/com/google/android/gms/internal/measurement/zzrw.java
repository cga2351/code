package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

public class zzrw
{
  private static volatile UserManager zzbrb;
  private static volatile boolean zzbrc;

  static
  {
    if (!zztj());
    for (boolean bool = true; ; bool = false)
    {
      zzbrc = bool;
      return;
    }
  }

  public static boolean isUserUnlocked(Context paramContext)
  {
    return (!zztj()) || (zzab(paramContext));
  }

  @TargetApi(24)
  private static boolean zzab(Context paramContext)
  {
    boolean bool1 = zzbrc;
    int i;
    boolean bool2;
    UserManager localUserManager;
    if (!bool1)
    {
      i = 1;
      bool2 = bool1;
      if (i > 2)
        break label101;
      localUserManager = zzac(paramContext);
      if (localUserManager == null)
      {
        zzbrc = true;
        bool1 = true;
      }
    }
    else
    {
      label34: return bool1;
    }
    while (true)
    {
      try
      {
        if (localUserManager.isUserUnlocked())
          break label106;
        if (!localUserManager.isUserRunning(Process.myUserHandle()))
        {
          break label106;
          zzbrc = bool2;
          bool1 = bool2;
          if (!bool1)
            break label34;
          zzbrb = null;
          return bool1;
        }
        bool2 = false;
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.w("DirectBootUtils", "Failed to check if user is unlocked", localNullPointerException);
        zzbrb = null;
        i++;
      }
      break;
      label101: bool1 = bool2;
      continue;
      label106: bool2 = true;
    }
  }

  @TargetApi(24)
  private static UserManager zzac(Context paramContext)
  {
    UserManager localUserManager1 = zzbrb;
    if (localUserManager1 == null)
      try
      {
        UserManager localUserManager2 = zzbrb;
        if (localUserManager2 == null)
        {
          localUserManager2 = (UserManager)paramContext.getSystemService(UserManager.class);
          zzbrb = localUserManager2;
        }
        return localUserManager2;
      }
      finally
      {
      }
    return localUserManager1;
  }

  public static boolean zztj()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzrw
 * JD-Core Version:    0.6.2
 */