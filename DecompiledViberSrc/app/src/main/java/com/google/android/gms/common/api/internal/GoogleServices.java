package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
@KeepForSdk
public final class GoogleServices
{
  private static final Object sLock = new Object();

  @GuardedBy("sLock")
  private static GoogleServices zzax;
  private final String zzay;
  private final Status zzaz;
  private final boolean zzba;
  private final boolean zzbb;

  @KeepForSdk
  @VisibleForTesting
  GoogleServices(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("google_app_measurement_enable", "integer", localResources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool2;
    if (i != 0)
      if (localResources.getInteger(i) != 0)
      {
        bool2 = bool1;
        if (bool2)
          break label124;
        label50: this.zzbb = bool1;
        bool1 = bool2;
      }
    String str;
    while (true)
    {
      this.zzba = bool1;
      str = zzp.zzc(paramContext);
      if (str == null)
        str = new StringResourceValueReader(paramContext).getString("google_app_id");
      if (!TextUtils.isEmpty(str))
        break label137;
      this.zzaz = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzay = null;
      return;
      bool2 = false;
      break;
      label124: bool1 = false;
      break label50;
      this.zzbb = false;
    }
    label137: this.zzay = str;
    this.zzaz = Status.RESULT_SUCCESS;
  }

  @KeepForSdk
  @VisibleForTesting
  GoogleServices(String paramString, boolean paramBoolean)
  {
    this.zzay = paramString;
    this.zzaz = Status.RESULT_SUCCESS;
    this.zzba = paramBoolean;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      this.zzbb = bool;
      return;
    }
  }

  @KeepForSdk
  private static GoogleServices checkInitialized(String paramString)
  {
    synchronized (sLock)
    {
      if (zzax == null)
        throw new IllegalStateException(34 + String.valueOf(paramString).length() + "Initialize must be called before " + paramString + ".");
    }
    GoogleServices localGoogleServices = zzax;
    return localGoogleServices;
  }

  @KeepForSdk
  @VisibleForTesting
  static void clearInstanceForTest()
  {
    synchronized (sLock)
    {
      zzax = null;
      return;
    }
  }

  @KeepForSdk
  public static String getGoogleAppId()
  {
    return checkInitialized("getGoogleAppId").zzay;
  }

  @KeepForSdk
  public static Status initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (sLock)
    {
      if (zzax == null)
        zzax = new GoogleServices(paramContext);
      Status localStatus = zzax.zzaz;
      return localStatus;
    }
  }

  @KeepForSdk
  public static Status initialize(Context paramContext, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (sLock)
    {
      if (zzax != null)
      {
        Status localStatus2 = zzax.checkGoogleAppId(paramString);
        return localStatus2;
      }
      GoogleServices localGoogleServices = new GoogleServices(paramString, paramBoolean);
      zzax = localGoogleServices;
      Status localStatus1 = localGoogleServices.zzaz;
      return localStatus1;
    }
  }

  @KeepForSdk
  public static boolean isMeasurementEnabled()
  {
    GoogleServices localGoogleServices = checkInitialized("isMeasurementEnabled");
    return (localGoogleServices.zzaz.isSuccess()) && (localGoogleServices.zzba);
  }

  @KeepForSdk
  public static boolean isMeasurementExplicitlyDisabled()
  {
    return checkInitialized("isMeasurementExplicitlyDisabled").zzbb;
  }

  @KeepForSdk
  @VisibleForTesting
  final Status checkGoogleAppId(String paramString)
  {
    if ((this.zzay != null) && (!this.zzay.equals(paramString)))
    {
      String str = this.zzay;
      return new Status(10, 97 + String.valueOf(str).length() + "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + str + "'.");
    }
    return Status.RESULT_SUCCESS;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.GoogleServices
 * JD-Core Version:    0.6.2
 */