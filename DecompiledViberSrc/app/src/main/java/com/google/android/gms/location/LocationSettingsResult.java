package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="LocationSettingsResultCreator")
@SafeParcelable.Reserved({1000})
public final class LocationSettingsResult extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzah();

  @SafeParcelable.Field(getter="getStatus", id=1)
  private final Status zzbl;

  @SafeParcelable.Field(getter="getLocationSettingsStates", id=2)
  private final LocationSettingsStates zzbm;

  public LocationSettingsResult(Status paramStatus)
  {
    this(paramStatus, null);
  }

  @SafeParcelable.Constructor
  public LocationSettingsResult(@SafeParcelable.Param(id=1) Status paramStatus, @SafeParcelable.Param(id=2) LocationSettingsStates paramLocationSettingsStates)
  {
    this.zzbl = paramStatus;
    this.zzbm = paramLocationSettingsStates;
  }

  public final LocationSettingsStates getLocationSettingsStates()
  {
    return this.zzbm;
  }

  public final Status getStatus()
  {
    return this.zzbl;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getLocationSettingsStates(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationSettingsResult
 * JD-Core Version:    0.6.2
 */