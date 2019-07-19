package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbm
{
  private final zzbp zzaog;

  public zzbm(zzbp paramzzbp)
  {
    Preconditions.checkNotNull(paramzzbp);
    this.zzaog = paramzzbp;
  }

  public static boolean zza(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null)
        return false;
      ActivityInfo localActivityInfo = localPackageManager.getReceiverInfo(new ComponentName(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
      if (localActivityInfo != null)
      {
        boolean bool = localActivityInfo.enabled;
        if (bool)
          return true;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    zzbw localzzbw = zzbw.zza(paramContext, null);
    zzas localzzas = localzzbw.zzgt();
    if (paramIntent == null)
      localzzas.zzjj().zzby("Receiver called with null intent");
    while (true)
    {
      return;
      localzzbw.zzgw();
      String str1 = paramIntent.getAction();
      localzzas.zzjo().zzg("Local receiver got", str1);
      if ("com.google.android.gms.measurement.UPLOAD".equals(str1))
      {
        Intent localIntent = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
        localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
        localzzas.zzjo().zzby("Starting wakeful intent.");
        this.zzaog.doStartService(paramContext, localIntent);
        return;
      }
      if ("com.android.vending.INSTALL_REFERRER".equals(str1))
        try
        {
          localzzbw.zzgs().zzc(new zzbn(this, localzzbw, localzzas));
          localPendingResult = this.zzaog.doGoAsync();
          str2 = paramIntent.getStringExtra("referrer");
          if (str2 == null)
          {
            localzzas.zzjo().zzby("Install referrer extras are null");
            if (localPendingResult == null)
              continue;
            localPendingResult.finish();
          }
        }
        catch (Exception localException)
        {
          BroadcastReceiver.PendingResult localPendingResult;
          while (true)
            localzzas.zzjj().zzg("Install Referrer Reporter encountered a problem", localException);
          localzzas.zzjm().zzg("Install referrer extras are", str2);
          String str3;
          if (!str2.contains("?"))
          {
            str3 = String.valueOf(str2);
            if (str3.length() == 0)
              break label286;
          }
          Bundle localBundle;
          label286: for (String str2 = "?".concat(str3); ; str2 = new String("?"))
          {
            Uri localUri = Uri.parse(str2);
            localBundle = localzzbw.zzgr().zza(localUri);
            if (localBundle != null)
              break label300;
            localzzas.zzjo().zzby("No campaign defined in install referrer broadcast");
            if (localPendingResult == null)
              break;
            localPendingResult.finish();
            return;
          }
          label300: long l = 1000L * paramIntent.getLongExtra("referrer_timestamp_seconds", 0L);
          if (l == 0L)
            localzzas.zzjj().zzby("Install referrer is missing timestamp");
          localzzbw.zzgs().zzc(new zzbo(this, localzzbw, l, localBundle, paramContext, localzzas, localPendingResult));
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbm
 * JD-Core Version:    0.6.2
 */