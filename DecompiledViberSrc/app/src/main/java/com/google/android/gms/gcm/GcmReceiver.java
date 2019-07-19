package com.google.android.gms.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzk;

@Deprecated
public class GcmReceiver extends WakefulBroadcastReceiver
{
  private static boolean zzr = false;
  private static zzk zzs;
  private static zzk zzt;

  private final int zzd(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("GcmReceiver", 3))
      Log.d("GcmReceiver", "Binding to service");
    if (isOrderedBroadcast())
      setResultCode(-1);
    zzd(paramContext, paramIntent.getAction()).zzd(paramIntent, goAsync());
    return -1;
  }

  private final zzk zzd(Context paramContext, String paramString)
  {
    try
    {
      if ("com.google.android.c2dm.intent.RECEIVE".equals(paramString))
        if (zzt == null)
          zzt = new zzk(paramContext, paramString);
      for (zzk localzzk = zzt; ; localzzk = zzs)
      {
        return localzzk;
        if (zzs == null)
          zzs = new zzk(paramContext, paramString);
      }
    }
    finally
    {
    }
  }

  private static int zze(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("GcmReceiver", 3))
      Log.d("GcmReceiver", "Starting service");
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if ((localResolveInfo == null) || (localResolveInfo.serviceInfo == null))
      Log.e("GcmReceiver", "Failed to resolve target intent service, skipping classname enforcement");
    try
    {
      ComponentName localComponentName;
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0)
        localComponentName = startWakefulService(paramContext, paramIntent);
      while (true)
      {
        if (localComponentName != null)
          break label348;
        Log.e("GcmReceiver", "Error while delivering the message: ServiceIntent not found.");
        return 404;
        ServiceInfo localServiceInfo = localResolveInfo.serviceInfo;
        if ((!paramContext.getPackageName().equals(localServiceInfo.packageName)) || (localServiceInfo.name == null))
        {
          String str2 = localServiceInfo.packageName;
          String str3 = localServiceInfo.name;
          Log.e("GcmReceiver", 94 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + str2 + "/" + str3);
          break;
        }
        String str4 = localServiceInfo.name;
        String str7;
        label231: String str5;
        if (str4.startsWith("."))
        {
          str7 = String.valueOf(paramContext.getPackageName());
          String str8 = String.valueOf(str4);
          if (str8.length() != 0)
            str4 = str7.concat(str8);
        }
        else if (Log.isLoggable("GcmReceiver", 3))
        {
          str5 = String.valueOf(str4);
          if (str5.length() == 0)
            break label300;
        }
        label300: for (String str6 = "Restricting intent to a specific service: ".concat(str5); ; str6 = new String("Restricting intent to a specific service: "))
        {
          Log.d("GcmReceiver", str6);
          paramIntent.setClassName(paramContext.getPackageName(), str4);
          break;
          str4 = new String(str7);
          break label231;
        }
        localComponentName = paramContext.startService(paramIntent);
        Log.d("GcmReceiver", "Missing wake lock permission, service start may be delayed");
      }
    }
    catch (SecurityException localSecurityException)
    {
      Log.e("GcmReceiver", "Error while delivering the message to the serviceIntent", localSecurityException);
      return 401;
      return -1;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label348: String str1 = String.valueOf(localIllegalStateException);
      Log.e("GcmReceiver", 45 + String.valueOf(str1).length() + "Failed to start service while in background: " + str1);
    }
    return 402;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 1;
    if (Log.isLoggable("GcmReceiver", 3))
      Log.d("GcmReceiver", "received new intent");
    paramIntent.setComponent(null);
    paramIntent.setPackage(paramContext.getPackageName());
    if (Build.VERSION.SDK_INT <= 18)
      paramIntent.removeCategory(paramContext.getPackageName());
    if ("google.com/iid".equals(paramIntent.getStringExtra("from")))
      paramIntent.setAction("com.google.android.gms.iid.InstanceID");
    String str = paramIntent.getStringExtra("gcm.rawData64");
    if (str != null)
    {
      paramIntent.putExtra("rawData", Base64.decode(str, 0));
      paramIntent.removeExtra("gcm.rawData64");
    }
    if (isOrderedBroadcast())
      setResultCode(500);
    int j;
    label148: int k;
    if ((PlatformVersion.isAtLeastO()) && (paramContext.getApplicationInfo().targetSdkVersion >= 26))
    {
      j = i;
      if ((0x10000000 & paramIntent.getFlags()) == 0)
        break label185;
      if ((j == 0) || (i != 0))
        break label190;
      k = zzd(paramContext, paramIntent);
    }
    label185: label190: label246: 
    while (true)
    {
      if (isOrderedBroadcast())
        setResultCode(k);
      return;
      j = 0;
      break;
      i = 0;
      break label148;
      if ("com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()));
      for (k = zze(paramContext, paramIntent); ; k = zze(paramContext, paramIntent))
      {
        if ((!PlatformVersion.isAtLeastO()) || (k != 402))
          break label246;
        zzd(paramContext, paramIntent);
        k = 403;
        break;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmReceiver
 * JD-Core Version:    0.6.2
 */