package com.mopub.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.net.SocketException;

public class DeviceUtils
{
  static int a(int paramInt1, int paramInt2)
  {
    int i = 9;
    if (1 == paramInt2)
    {
      switch (paramInt1)
      {
      default:
        i = 1;
      case 1:
      case 2:
      }
      return i;
    }
    if (2 == paramInt2)
    {
      switch (paramInt1)
      {
      default:
        return 0;
      case 2:
      case 3:
      }
      return 8;
    }
    MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unknown screen orientation. Defaulting to portrait." });
    return i;
  }

  public static long diskCacheSizeBytes(File paramFile)
  {
    return diskCacheSizeBytes(paramFile, 31457280L);
  }

  public static long diskCacheSizeBytes(File paramFile, long paramLong)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramFile.getAbsolutePath());
      paramLong = localStatFs.getBlockCount() * localStatFs.getBlockSize() / 50L;
      return Math.max(Math.min(paramLong, 104857600L), 31457280L);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to calculate 2% of available disk space, defaulting to minimum" });
    }
  }

  // ERROR //
  @android.annotation.TargetApi(17)
  public static android.graphics.Point getDeviceDimensions(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 75
    //   3: invokevirtual 81	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 83	android/view/WindowManager
    //   9: invokeinterface 87 1 0
    //   14: astore_1
    //   15: getstatic 93	android/os/Build$VERSION:SDK_INT	I
    //   18: bipush 17
    //   20: if_icmplt +87 -> 107
    //   23: new 95	android/graphics/Point
    //   26: dup
    //   27: invokespecial 96	android/graphics/Point:<init>	()V
    //   30: astore_2
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 102	android/view/Display:getRealSize	(Landroid/graphics/Point;)V
    //   36: aload_2
    //   37: getfield 105	android/graphics/Point:x	I
    //   40: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: astore_3
    //   44: aload_2
    //   45: getfield 114	android/graphics/Point:y	I
    //   48: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: astore 4
    //   53: aload_3
    //   54: ifnull +8 -> 62
    //   57: aload 4
    //   59: ifnonnull +31 -> 90
    //   62: aload_0
    //   63: invokevirtual 118	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   66: invokevirtual 124	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   69: astore 5
    //   71: aload 5
    //   73: getfield 129	android/util/DisplayMetrics:widthPixels	I
    //   76: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: astore_3
    //   80: aload 5
    //   82: getfield 132	android/util/DisplayMetrics:heightPixels	I
    //   85: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: astore 4
    //   90: new 95	android/graphics/Point
    //   93: dup
    //   94: aload_3
    //   95: invokevirtual 135	java/lang/Integer:intValue	()I
    //   98: aload 4
    //   100: invokevirtual 135	java/lang/Integer:intValue	()I
    //   103: invokespecial 138	android/graphics/Point:<init>	(II)V
    //   106: areturn
    //   107: new 140	com/mopub/common/util/Reflection$MethodBuilder
    //   110: dup
    //   111: aload_1
    //   112: ldc 142
    //   114: invokespecial 145	com/mopub/common/util/Reflection$MethodBuilder:<init>	(Ljava/lang/Object;Ljava/lang/String;)V
    //   117: invokevirtual 149	com/mopub/common/util/Reflection$MethodBuilder:execute	()Ljava/lang/Object;
    //   120: checkcast 107	java/lang/Integer
    //   123: astore 7
    //   125: new 140	com/mopub/common/util/Reflection$MethodBuilder
    //   128: dup
    //   129: aload_1
    //   130: ldc 151
    //   132: invokespecial 145	com/mopub/common/util/Reflection$MethodBuilder:<init>	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: invokevirtual 149	com/mopub/common/util/Reflection$MethodBuilder:execute	()Ljava/lang/Object;
    //   138: checkcast 107	java/lang/Integer
    //   141: astore 9
    //   143: aload 7
    //   145: astore_3
    //   146: aload 9
    //   148: astore 4
    //   150: goto -97 -> 53
    //   153: astore 6
    //   155: aconst_null
    //   156: astore_3
    //   157: getstatic 16	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   160: iconst_2
    //   161: anewarray 4	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: ldc 153
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload 6
    //   173: aastore
    //   174: invokestatic 24	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   177: aconst_null
    //   178: astore 4
    //   180: goto -127 -> 53
    //   183: astore 8
    //   185: aload 7
    //   187: astore_3
    //   188: aload 8
    //   190: astore 6
    //   192: goto -35 -> 157
    //
    // Exception table:
    //   from	to	target	type
    //   107	125	153	java/lang/Exception
    //   125	143	183	java/lang/Exception
  }

  @Deprecated
  public static String getHashedUdid(Context paramContext)
  {
    return null;
  }

  @Deprecated
  public static String getIpAddress(IP paramIP)
    throws SocketException
  {
    return null;
  }

  public static int getScreenOrientation(Activity paramActivity)
  {
    return a(paramActivity.getWindowManager().getDefaultDisplay().getRotation(), paramActivity.getResources().getConfiguration().orientation);
  }

  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (paramContext == null)
      return false;
    if (!isPermissionGranted(paramContext, "android.permission.INTERNET"))
      return false;
    if (!isPermissionGranted(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      return true;
    try
    {
      boolean bool = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return false;
  }

  public static boolean isPermissionGranted(Context paramContext, String paramString)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    try
    {
      int i = ContextCompat.checkSelfPermission(paramContext, paramString);
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public static void lockOrientation(Activity paramActivity, CreativeOrientation paramCreativeOrientation)
  {
    if ((!Preconditions.NoThrow.checkNotNull(paramCreativeOrientation)) || (!Preconditions.NoThrow.checkNotNull(paramActivity)))
      return;
    int i = a(((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRotation(), paramActivity.getResources().getConfiguration().orientation);
    int j;
    if (CreativeOrientation.PORTRAIT == paramCreativeOrientation)
      if (9 == i)
        j = 9;
    while (true)
    {
      paramActivity.setRequestedOrientation(j);
      return;
      j = 1;
      continue;
      if (CreativeOrientation.LANDSCAPE != paramCreativeOrientation)
        break;
      if (8 == i)
        j = 8;
      else
        j = 0;
    }
  }

  public static int memoryCacheSizeBytes(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    long l1 = localActivityManager.getMemoryClass();
    try
    {
      int i = ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null);
      if (Utils.bitMaskContainsFlag(paramContext.getApplicationInfo().flags, i))
      {
        int j = ((Integer)new Reflection.MethodBuilder(localActivityManager, "getLargeMemoryClass").execute()).intValue();
        l2 = j;
        return (int)Math.min(31457280L, 1024L * (1024L * (l2 / 8L)));
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to reflectively determine large heap size." });
        long l2 = l1;
      }
    }
  }

  public static enum ForceOrientation
  {
    private final String a;

    static
    {
      FORCE_LANDSCAPE = new ForceOrientation("FORCE_LANDSCAPE", 1, "landscape");
      DEVICE_ORIENTATION = new ForceOrientation("DEVICE_ORIENTATION", 2, "device");
      UNDEFINED = new ForceOrientation("UNDEFINED", 3, "");
      ForceOrientation[] arrayOfForceOrientation = new ForceOrientation[4];
      arrayOfForceOrientation[0] = FORCE_PORTRAIT;
      arrayOfForceOrientation[1] = FORCE_LANDSCAPE;
      arrayOfForceOrientation[2] = DEVICE_ORIENTATION;
      arrayOfForceOrientation[3] = UNDEFINED;
    }

    private ForceOrientation(String paramString)
    {
      this.a = paramString;
    }

    public static ForceOrientation getForceOrientation(String paramString)
    {
      for (ForceOrientation localForceOrientation : values())
        if (localForceOrientation.a.equalsIgnoreCase(paramString))
          return localForceOrientation;
      return UNDEFINED;
    }
  }

  @Deprecated
  public static enum IP
  {
    static
    {
      IP[] arrayOfIP = new IP[2];
      arrayOfIP[0] = IPv4;
      arrayOfIP[1] = IPv6;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.DeviceUtils
 * JD-Core Version:    0.6.2
 */