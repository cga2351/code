package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.InstantApps;
import java.lang.reflect.Method;

public final class zzam extends zzf
{
  private String zzafi;
  private String zzafp;
  private long zzafs;
  private String zzafv;
  private int zzagp;
  private int zzalm;
  private long zzaln;
  private String zztr;
  private String zzts;
  private String zztt;

  zzam(zzbw paramzzbw)
  {
    super(paramzzbw);
  }

  @VisibleForTesting
  private final String zzjc()
  {
    Class localClass;
    try
    {
      localClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
      if (localClass == null)
        return null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return null;
    }
    Object localObject;
    try
    {
      Method localMethod = localClass.getDeclaredMethod("getInstance", new Class[] { Context.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = getContext();
      localObject = localMethod.invoke(null, arrayOfObject);
      if (localObject == null)
        return null;
    }
    catch (Exception localException1)
    {
      zzgt().zzjk().zzby("Failed to obtain Firebase Analytics instance");
      return null;
    }
    try
    {
      String str = (String)localClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(localObject, new Object[0]);
      return str;
    }
    catch (Exception localException2)
    {
      zzgt().zzjl().zzby("Failed to retrieve Firebase Instance Id");
    }
    return null;
  }

  final String getGmpAppId()
  {
    zzcl();
    return this.zzafi;
  }

  final String zzal()
  {
    zzcl();
    return this.zztt;
  }

  final zzk zzbs(String paramString)
  {
    zzaf();
    zzgg();
    String str1 = zzal();
    String str2 = getGmpAppId();
    zzcl();
    String str3 = this.zzts;
    long l1 = zzjd();
    zzcl();
    String str4 = this.zzafp;
    long l2 = zzgv().zzhh();
    zzcl();
    zzaf();
    if (this.zzaln == 0L)
      this.zzaln = this.zzada.zzgr().zzd(getContext(), getContext().getPackageName());
    long l3 = this.zzaln;
    boolean bool1 = this.zzada.isEnabled();
    boolean bool2;
    String str5;
    label159: long l4;
    long l5;
    int i;
    boolean bool3;
    label220: boolean bool4;
    if (!zzgu().zzans)
    {
      bool2 = true;
      zzaf();
      zzgg();
      if ((!zzgv().zzaz(this.zztt)) || (this.zzada.isEnabled()))
        break label326;
      str5 = null;
      zzcl();
      l4 = this.zzafs;
      l5 = this.zzada.zzkt();
      i = zzje();
      zzq localzzq1 = zzgv();
      localzzq1.zzgg();
      Boolean localBoolean1 = localzzq1.zzar("google_analytics_adid_collection_enabled");
      if ((localBoolean1 != null) && (!localBoolean1.booleanValue()))
        break label335;
      bool3 = true;
      bool4 = Boolean.valueOf(bool3).booleanValue();
      zzq localzzq2 = zzgv();
      localzzq2.zzgg();
      Boolean localBoolean2 = localzzq2.zzar("google_analytics_ssaid_collection_enabled");
      if ((localBoolean2 != null) && (!localBoolean2.booleanValue()))
        break label341;
    }
    label326: label335: label341: for (boolean bool5 = true; ; bool5 = false)
    {
      return new zzk(str1, str2, str3, l1, str4, l2, l3, paramString, bool1, bool2, str5, l4, l5, i, bool4, Boolean.valueOf(bool5).booleanValue(), zzgu().zzkb(), zzhb());
      bool2 = false;
      break;
      str5 = zzjc();
      break label159;
      bool3 = false;
      break label220;
    }
  }

  protected final boolean zzgy()
  {
    return true;
  }

  protected final void zzgz()
  {
    int i = 1;
    Object localObject = "unknown";
    String str1 = "Unknown";
    int j = -2147483648;
    String str2 = "Unknown";
    String str3 = getContext().getPackageName();
    PackageManager localPackageManager = getContext().getPackageManager();
    Status localStatus;
    int k;
    label124: int m;
    label156: label186: Boolean localBoolean;
    if (localPackageManager == null)
    {
      zzgt().zzjg().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzas.zzbw(str3));
      this.zztt = str3;
      this.zzafp = ((String)localObject);
      this.zzts = str1;
      this.zzalm = j;
      this.zztr = str2;
      this.zzaln = 0L;
      zzgw();
      localStatus = GoogleServices.initialize(getContext());
      if ((localStatus == null) || (!localStatus.isSuccess()))
        break label553;
      k = i;
      if ((TextUtils.isEmpty(this.zzada.zzko())) || (!"am".equals(this.zzada.zzkp())))
        break label559;
      m = i;
      int n = k | m;
      if (n == 0)
      {
        if (localStatus != null)
          break label565;
        zzgt().zzjg().zzby("GoogleService failed to initialize (no status)");
      }
      if (n == 0)
        break label728;
      localBoolean = zzgv().zzia();
      if (!zzgv().zzhz())
        break label594;
      if (!this.zzada.zzkn())
        break label728;
      zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_deactivated=1");
    }
    label553: label559: label565: label594: label722: label728: for (int i1 = 0; ; i1 = 0)
      while (true)
      {
        label236: this.zzafi = "";
        this.zzafv = "";
        this.zzafs = 0L;
        zzgw();
        if ((!TextUtils.isEmpty(this.zzada.zzko())) && ("am".equals(this.zzada.zzkp())))
          this.zzafv = this.zzada.zzko();
        try
        {
          String str4 = GoogleServices.getGoogleAppId();
          if (TextUtils.isEmpty(str4));
          for (String str5 = ""; ; str5 = str4)
          {
            while (true)
            {
              this.zzafi = str5;
              if (!TextUtils.isEmpty(str4))
                this.zzafv = new StringResourceValueReader(getContext()).getString("admob_app_id");
              if (i1 != 0)
                zzgt().zzjo().zze("App package, google app id", this.zztt, this.zzafi);
              if (Build.VERSION.SDK_INT < 16)
                break label722;
              if (!InstantApps.isInstantApp(getContext()))
                break label717;
              this.zzagp = i;
              return;
              try
              {
                String str6 = localPackageManager.getInstallerPackageName(str3);
                localObject = str6;
                if (localObject == null)
                  localObject = "manual_install";
              }
              catch (IllegalArgumentException localIllegalArgumentException)
              {
                try
                {
                  while (true)
                  {
                    PackageInfo localPackageInfo = localPackageManager.getPackageInfo(getContext().getPackageName(), 0);
                    if (localPackageInfo == null)
                      break;
                    CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(localCharSequence))
                      str2 = localCharSequence.toString();
                    str1 = localPackageInfo.versionName;
                    j = localPackageInfo.versionCode;
                    break;
                    localIllegalArgumentException = localIllegalArgumentException;
                    zzgt().zzjg().zzg("Error retrieving app installer package name. appId", zzas.zzbw(str3));
                    continue;
                    if ("com.android.vending".equals(localObject))
                      localObject = "";
                  }
                }
                catch (PackageManager.NameNotFoundException localNameNotFoundException)
                {
                  zzgt().zzjg().zze("Error retrieving package info. appId, appName", zzas.zzbw(str3), str2);
                }
              }
            }
            break;
            k = 0;
            break label124;
            m = 0;
            break label156;
            zzgt().zzjg().zze("GoogleService failed to initialize, status", Integer.valueOf(localStatus.getStatusCode()), localStatus.getStatusMessage());
            break label186;
            if ((localBoolean != null) && (!localBoolean.booleanValue()))
            {
              if (!this.zzada.zzkn())
                break label728;
              zzgt().zzjm().zzby("Collection disabled with firebase_analytics_collection_enabled=0");
              i1 = 0;
              break label236;
            }
            if ((localBoolean == null) && (GoogleServices.isMeasurementExplicitlyDisabled()))
            {
              zzgt().zzjm().zzby("Collection disabled with google_app_measurement_enable=0");
              i1 = 0;
              break label236;
            }
            zzgt().zzjo().zzby("Collection enabled");
            i1 = i;
            break label236;
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          while (true)
          {
            zzgt().zzjg().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzas.zzbw(str3), localIllegalStateException);
            continue;
            i = 0;
          }
          this.zzagp = 0;
          return;
        }
      }
  }

  final String zzhb()
  {
    zzcl();
    return this.zzafv;
  }

  final int zzjd()
  {
    zzcl();
    return this.zzalm;
  }

  final int zzje()
  {
    zzcl();
    return this.zzagp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzam
 * JD-Core Version:    0.6.2
 */