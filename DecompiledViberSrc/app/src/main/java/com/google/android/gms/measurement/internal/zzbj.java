package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzu;
import java.util.List;

public final class zzbj
{
  final zzbw zzada;

  zzbj(zzbw paramzzbw)
  {
    this.zzada = paramzzbw;
  }

  @VisibleForTesting
  private final boolean zzke()
  {
    try
    {
      PackageManagerWrapper localPackageManagerWrapper = Wrappers.packageManager(this.zzada.getContext());
      if (localPackageManagerWrapper == null)
      {
        this.zzada.zzgt().zzjm().zzby("Failed to retrieve Package Manager to check Play Store compatibility");
        return false;
      }
      int i = localPackageManagerWrapper.getPackageInfo("com.android.vending", 128).versionCode;
      if (i >= 80837300)
        return true;
    }
    catch (Exception localException)
    {
      this.zzada.zzgt().zzjm().zzg("Failed to retrieve Play Store version", localException);
    }
    return false;
  }

  @VisibleForTesting
  final Bundle zza(String paramString, zzu paramzzu)
  {
    this.zzada.zzgs().zzaf();
    if (paramzzu == null)
    {
      this.zzada.zzgt().zzjj().zzby("Attempting to use Install Referrer Service while it is not initialized");
      return null;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("package_name", paramString);
    Bundle localBundle2;
    try
    {
      localBundle2 = paramzzu.zza(localBundle1);
      if (localBundle2 == null)
      {
        this.zzada.zzgt().zzjg().zzby("Install Referrer Service returned a null response");
        return null;
      }
    }
    catch (Exception localException)
    {
      this.zzada.zzgt().zzjg().zzg("Exception occurred while retrieving the Install Referrer", localException.getMessage());
      return null;
    }
    return localBundle2;
  }

  protected final void zzce(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty()))
      this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter was called with invalid app package name");
    zzbk localzzbk;
    Intent localIntent1;
    ResolveInfo localResolveInfo;
    do
    {
      return;
      this.zzada.zzgs().zzaf();
      if (!zzke())
      {
        this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is not available");
        return;
      }
      this.zzada.zzgt().zzjm().zzby("Install Referrer Reporter is initializing");
      localzzbk = new zzbk(this, paramString);
      this.zzada.zzgs().zzaf();
      localIntent1 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
      localIntent1.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
      PackageManager localPackageManager = this.zzada.getContext().getPackageManager();
      if (localPackageManager == null)
      {
        this.zzada.zzgt().zzjj().zzby("Failed to obtain Package Manager to verify binding conditions");
        return;
      }
      List localList = localPackageManager.queryIntentServices(localIntent1, 0);
      if ((localList == null) || (localList.isEmpty()))
        break;
      localResolveInfo = (ResolveInfo)localList.get(0);
    }
    while (localResolveInfo.serviceInfo == null);
    String str1 = localResolveInfo.serviceInfo.packageName;
    if ((localResolveInfo.serviceInfo.name != null) && ("com.android.vending".equals(str1)) && (zzke()))
    {
      Intent localIntent2 = new Intent(localIntent1);
      while (true)
      {
        try
        {
          boolean bool = ConnectionTracker.getInstance().bindService(this.zzada.getContext(), localIntent2, localzzbk, 1);
          zzau localzzau = this.zzada.zzgt().zzjm();
          if (bool)
          {
            str2 = "available";
            localzzau.zzg("Install Referrer Service is", str2);
            return;
          }
        }
        catch (Exception localException)
        {
          this.zzada.zzgt().zzjg().zzg("Exception occurred while binding to Install Referrer Service", localException.getMessage());
          return;
        }
        String str2 = "not available";
      }
    }
    this.zzada.zzgt().zzjm().zzby("Play Store missing or incompatible. Version 8.3.73 or later required");
    return;
    this.zzada.zzgt().zzjm().zzby("Play Service for fetching Install Referrer is unavailable on device");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzbj
 * JD-Core Version:    0.6.2
 */