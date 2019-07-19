package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable
{
  public static final int API_UNAVAILABLE = 16;
  public static final int CANCELED = 13;
  public static final Parcelable.Creator<ConnectionResult> CREATOR = new zza();
  public static final int DEVELOPER_ERROR = 10;

  @Deprecated
  public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
  public static final int INTERNAL_ERROR = 8;
  public static final int INTERRUPTED = 15;
  public static final int INVALID_ACCOUNT = 5;
  public static final int LICENSE_CHECK_FAILED = 11;
  public static final int NETWORK_ERROR = 7;
  public static final int RESOLUTION_REQUIRED = 6;
  public static final int RESTRICTED_PROFILE = 20;

  @KeepForSdk
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
  public static final int SERVICE_DISABLED = 3;
  public static final int SERVICE_INVALID = 9;
  public static final int SERVICE_MISSING = 1;
  public static final int SERVICE_MISSING_PERMISSION = 19;
  public static final int SERVICE_UPDATING = 18;
  public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
  public static final int SIGN_IN_FAILED = 17;
  public static final int SIGN_IN_REQUIRED = 4;
  public static final int SUCCESS = 0;
  public static final int TIMEOUT = 14;

  @KeepForSdk
  public static final int UNKNOWN = -1;

  @SafeParcelable.VersionField(id=1)
  private final int zzg;

  @SafeParcelable.Field(getter="getErrorCode", id=2)
  private final int zzh;

  @SafeParcelable.Field(getter="getResolution", id=3)
  private final PendingIntent zzi;

  @SafeParcelable.Field(getter="getErrorMessage", id=4)
  private final String zzj;

  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, null);
  }

  @SafeParcelable.Constructor
  ConnectionResult(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) PendingIntent paramPendingIntent, @SafeParcelable.Param(id=4) String paramString)
  {
    this.zzg = paramInt1;
    this.zzh = paramInt2;
    this.zzi = paramPendingIntent;
    this.zzj = paramString;
  }

  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, null);
  }

  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent, String paramString)
  {
    this(1, paramInt, paramPendingIntent, paramString);
  }

  static String zza(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return 31 + "UNKNOWN_ERROR_CODE(" + paramInt + ")";
    case 0:
      return "SUCCESS";
    case 1:
      return "SERVICE_MISSING";
    case 2:
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3:
      return "SERVICE_DISABLED";
    case 4:
      return "SIGN_IN_REQUIRED";
    case 5:
      return "INVALID_ACCOUNT";
    case 6:
      return "RESOLUTION_REQUIRED";
    case 7:
      return "NETWORK_ERROR";
    case 8:
      return "INTERNAL_ERROR";
    case 9:
      return "SERVICE_INVALID";
    case 10:
      return "DEVELOPER_ERROR";
    case 11:
      return "LICENSE_CHECK_FAILED";
    case 13:
      return "CANCELED";
    case 14:
      return "TIMEOUT";
    case 15:
      return "INTERRUPTED";
    case 16:
      return "API_UNAVAILABLE";
    case 17:
      return "SIGN_IN_FAILED";
    case 18:
      return "SERVICE_UPDATING";
    case 19:
      return "SERVICE_MISSING_PERMISSION";
    case 20:
      return "RESTRICTED_PROFILE";
    case 21:
      return "API_VERSION_UPDATE_REQUIRED";
    case 1500:
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    case 99:
      return "UNFINISHED";
    case -1:
    }
    return "UNKNOWN";
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    ConnectionResult localConnectionResult;
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionResult))
        return false;
      localConnectionResult = (ConnectionResult)paramObject;
    }
    while ((this.zzh == localConnectionResult.zzh) && (Objects.equal(this.zzi, localConnectionResult.zzi)) && (Objects.equal(this.zzj, localConnectionResult.zzj)));
    return false;
  }

  public final int getErrorCode()
  {
    return this.zzh;
  }

  public final String getErrorMessage()
  {
    return this.zzj;
  }

  public final PendingIntent getResolution()
  {
    return this.zzi;
  }

  public final boolean hasResolution()
  {
    return (this.zzh != 0) && (this.zzi != null);
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.zzh);
    arrayOfObject[1] = this.zzi;
    arrayOfObject[2] = this.zzj;
    return Objects.hashCode(arrayOfObject);
  }

  public final boolean isSuccess()
  {
    return this.zzh == 0;
  }

  public final void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution())
      return;
    paramActivity.startIntentSenderForResult(this.zzi.getIntentSender(), paramInt, null, 0, 0, 0);
  }

  public final String toString()
  {
    return Objects.toStringHelper(this).add("statusCode", zza(this.zzh)).add("resolution", this.zzi).add("message", this.zzj).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 2, getErrorCode());
    SafeParcelWriter.writeParcelable(paramParcel, 3, getResolution(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, getErrorMessage(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.6.2
 */