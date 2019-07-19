package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
@ShowFirstParty
public class GooglePlayServicesUtilLight
{

  @KeepForSdk
  static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;

  @KeepForSdk
  static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;

  @KeepForSdk
  public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";

  @Deprecated
  @KeepForSdk
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";

  @Deprecated
  @KeepForSdk
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;

  @KeepForSdk
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

  @KeepForSdk
  @VisibleForTesting
  static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();

  @VisibleForTesting
  private static boolean zzag = false;

  @VisibleForTesting
  private static boolean zzah = false;
  private static boolean zzai = false;

  @VisibleForTesting
  private static boolean zzaj = false;
  private static final AtomicBoolean zzak = new AtomicBoolean();

  @Deprecated
  @KeepForSdk
  public static void cancelAvailabilityErrorNotifications(Context paramContext)
  {
    if (sCanceledAvailabilityNotification.getAndSet(true));
    while (true)
    {
      return;
      try
      {
        NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
        if (localNotificationManager != null)
        {
          localNotificationManager.cancel(10436);
          return;
        }
      }
      catch (SecurityException localSecurityException)
      {
      }
    }
  }

  @KeepForSdk
  @ShowFirstParty
  public static void enableUsingApkIndependentContext()
  {
    zzak.set(true);
  }

  @Deprecated
  @KeepForSdk
  public static void ensurePlayServicesAvailable(Context paramContext, int paramInt)
    throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException
  {
    int i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, paramInt);
    if (i != 0)
    {
      Intent localIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(paramContext, i, "e");
      Log.e("GooglePlayServicesUtil", 57 + "GooglePlayServices not available due to error " + i);
      if (localIntent == null)
        throw new GooglePlayServicesNotAvailableException(i);
      throw new GooglePlayServicesRepairableException(i, "Google Play Services not available", localIntent);
    }
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getApkVersion(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return localPackageInfo.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static int getClientVersion(Context paramContext)
  {
    Preconditions.checkState(true);
    return ClientLibraryUtils.getClientVersion(paramContext, paramContext.getPackageName());
  }

  @Deprecated
  @KeepForSdk
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }

  @Deprecated
  @KeepForSdk
  @VisibleForTesting
  public static String getErrorString(int paramInt)
  {
    return ConnectionResult.zza(paramInt);
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, paramInt, null);
  }

  @KeepForSdk
  public static Context getRemoteContext(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  @KeepForSdk
  public static Resources getRemoteResource(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  @KeepForSdk
  @ShowFirstParty
  public static boolean honorsDebugCertificates(Context paramContext)
  {
    if (!zzaj);
    try
    {
      PackageInfo localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo("com.google.android.gms", 64);
      GoogleSignatureVerifier.getInstance(paramContext);
      if ((localPackageInfo != null) && (!GoogleSignatureVerifier.zza(localPackageInfo, false)) && (GoogleSignatureVerifier.zza(localPackageInfo, true)));
      for (zzai = true; ; zzai = false)
      {
        zzaj = true;
        boolean bool1;
        if (!zzai)
        {
          boolean bool2 = DeviceProperties.isUserBuild();
          bool1 = false;
          if (bool2);
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", localNameNotFoundException);
        zzaj = true;
      }
    }
    finally
    {
      zzaj = true;
    }
  }

  @Deprecated
  @KeepForSdk
  @HideFirstParty
  public static int isGooglePlayServicesAvailable(Context paramContext)
  {
    return isGooglePlayServicesAvailable(paramContext, GOOGLE_PLAY_SERVICES_VERSION_CODE);
  }

  @Deprecated
  @KeepForSdk
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    try
    {
      paramContext.getResources().getString(R.string.common_google_play_services_unknown_issue);
      if ((!"com.google.android.gms".equals(paramContext.getPackageName())) && (!zzak.get()))
      {
        i = zzp.zzd(paramContext);
        if (i == 0)
          throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      while (true)
        Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
      if (i != GOOGLE_PLAY_SERVICES_VERSION_CODE)
      {
        int j = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        throw new IllegalStateException(320 + "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + j + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext))
        break label154;
    }
    if (!DeviceProperties.zzf(paramContext));
    label154: for (boolean bool = true; ; bool = false)
      return zza(paramContext, bool, paramInt);
  }

  @Deprecated
  @KeepForSdk
  public static boolean isGooglePlayServicesUid(Context paramContext, int paramInt)
  {
    return UidVerifier.isGooglePlayServicesUid(paramContext, paramInt);
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayServicesPossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 18)
      return true;
    if (paramInt == 1)
      return isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms");
    return false;
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  public static boolean isPlayStorePossiblyUpdating(Context paramContext, int paramInt)
  {
    if (paramInt == 9)
      return isUninstalledAppPossiblyUpdating(paramContext, "com.android.vending");
    return false;
  }

  @TargetApi(18)
  @KeepForSdk
  public static boolean isRestrictedUserProfile(Context paramContext)
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2())
    {
      Bundle localBundle = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((localBundle != null) && ("true".equals(localBundle.getString("restricted_profile"))))
        return true;
    }
    return false;
  }

  @Deprecated
  @KeepForSdk
  @ShowFirstParty
  @VisibleForTesting
  public static boolean isSidewinderDevice(Context paramContext)
  {
    return DeviceProperties.isSidewinder(paramContext);
  }

  @TargetApi(21)
  static boolean isUninstalledAppPossiblyUpdating(Context paramContext, String paramString)
  {
    boolean bool1 = paramString.equals("com.google.android.gms");
    if (PlatformVersion.isAtLeastLollipop())
      try
      {
        List localList = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          if (paramString.equals(((PackageInstaller.SessionInfo)localIterator.next()).getAppPackageName()))
            return true;
      }
      catch (Exception localException)
      {
        return false;
      }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramString, 8192);
      if (bool1)
        return localApplicationInfo.enabled;
      if (localApplicationInfo.enabled)
      {
        boolean bool2 = isRestrictedUserProfile(paramContext);
        if (!bool2)
          return true;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  @Deprecated
  @KeepForSdk
  public static boolean isUserRecoverableError(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 9:
    }
    return true;
  }

  @Deprecated
  @TargetApi(19)
  @KeepForSdk
  public static boolean uidHasPackageName(Context paramContext, int paramInt, String paramString)
  {
    return UidVerifier.uidHasPackageName(paramContext, paramInt, paramString);
  }

  // ERROR //
  @VisibleForTesting
  private static int zza(Context paramContext, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iload_2
    //   1: iflt +75 -> 76
    //   4: iconst_1
    //   5: istore_3
    //   6: iload_3
    //   7: invokestatic 385	com/google/android/gms/common/internal/Preconditions:checkArgument	(Z)V
    //   10: aload_0
    //   11: invokevirtual 143	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 5
    //   19: iload_1
    //   20: ifeq +19 -> 39
    //   23: aload 4
    //   25: ldc 24
    //   27: sipush 8256
    //   30: invokevirtual 149	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   33: astore 20
    //   35: aload 20
    //   37: astore 5
    //   39: aload 4
    //   41: ldc 18
    //   43: bipush 64
    //   45: invokevirtual 149	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   48: astore 8
    //   50: aload_0
    //   51: invokestatic 216	com/google/android/gms/common/GoogleSignatureVerifier:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/common/GoogleSignatureVerifier;
    //   54: pop
    //   55: aload 8
    //   57: iconst_1
    //   58: invokestatic 219	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   61: ifne +46 -> 107
    //   64: ldc 107
    //   66: ldc_w 387
    //   69: invokestatic 159	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: bipush 9
    //   75: ireturn
    //   76: iconst_0
    //   77: istore_3
    //   78: goto -72 -> 6
    //   81: astore 18
    //   83: ldc 107
    //   85: ldc_w 389
    //   88: invokestatic 159	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   91: pop
    //   92: bipush 9
    //   94: ireturn
    //   95: astore 6
    //   97: ldc 107
    //   99: ldc 156
    //   101: invokestatic 159	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   104: pop
    //   105: iconst_1
    //   106: ireturn
    //   107: iload_1
    //   108: ifeq +44 -> 152
    //   111: aload 5
    //   113: iconst_1
    //   114: invokestatic 219	com/google/android/gms/common/GoogleSignatureVerifier:zza	(Landroid/content/pm/PackageInfo;Z)Z
    //   117: ifeq +23 -> 140
    //   120: aload 5
    //   122: getfield 393	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   125: iconst_0
    //   126: aaload
    //   127: aload 8
    //   129: getfield 393	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   132: iconst_0
    //   133: aaload
    //   134: invokevirtual 396	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   137: ifne +15 -> 152
    //   140: ldc 107
    //   142: ldc_w 398
    //   145: invokestatic 159	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   148: pop
    //   149: bipush 9
    //   151: ireturn
    //   152: aload 8
    //   154: getfield 154	android/content/pm/PackageInfo:versionCode	I
    //   157: invokestatic 404	com/google/android/gms/common/util/zzb:zzc	(I)I
    //   160: iload_2
    //   161: invokestatic 404	com/google/android/gms/common/util/zzb:zzc	(I)I
    //   164: if_icmpge +51 -> 215
    //   167: aload 8
    //   169: getfield 154	android/content/pm/PackageInfo:versionCode	I
    //   172: istore 14
    //   174: ldc 107
    //   176: new 109	java/lang/StringBuilder
    //   179: dup
    //   180: bipush 77
    //   182: invokespecial 111	java/lang/StringBuilder:<init>	(I)V
    //   185: ldc_w 406
    //   188: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_2
    //   192: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 275
    //   198: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload 14
    //   203: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 159	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   212: pop
    //   213: iconst_2
    //   214: ireturn
    //   215: aload 8
    //   217: getfield 410	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   220: astore 10
    //   222: aload 10
    //   224: ifnonnull +17 -> 241
    //   227: aload 4
    //   229: ldc 18
    //   231: iconst_0
    //   232: invokevirtual 368	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   235: astore 13
    //   237: aload 13
    //   239: astore 10
    //   241: aload 10
    //   243: getfield 373	android/content/pm/ApplicationInfo:enabled	Z
    //   246: ifne +20 -> 266
    //   249: iconst_3
    //   250: ireturn
    //   251: astore 11
    //   253: ldc 107
    //   255: ldc_w 412
    //   258: aload 11
    //   260: invokestatic 415	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   263: pop
    //   264: iconst_1
    //   265: ireturn
    //   266: iconst_0
    //   267: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   23	35	81	android/content/pm/PackageManager$NameNotFoundException
    //   39	50	95	android/content/pm/PackageManager$NameNotFoundException
    //   227	237	251	android/content/pm/PackageManager$NameNotFoundException
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesUtilLight
 * JD-Core Version:    0.6.2
 */