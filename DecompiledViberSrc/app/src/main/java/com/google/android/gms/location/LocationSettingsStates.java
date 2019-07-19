package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

@SafeParcelable.Class(creator="LocationSettingsStatesCreator")
@SafeParcelable.Reserved({1000})
public final class LocationSettingsStates extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzai();

  @SafeParcelable.Field(getter="isGpsUsable", id=1)
  private final boolean zzbn;

  @SafeParcelable.Field(getter="isNetworkLocationUsable", id=2)
  private final boolean zzbo;

  @SafeParcelable.Field(getter="isBleUsable", id=3)
  private final boolean zzbp;

  @SafeParcelable.Field(getter="isGpsPresent", id=4)
  private final boolean zzbq;

  @SafeParcelable.Field(getter="isNetworkLocationPresent", id=5)
  private final boolean zzbr;

  @SafeParcelable.Field(getter="isBlePresent", id=6)
  private final boolean zzbs;

  @SafeParcelable.Constructor
  public LocationSettingsStates(@SafeParcelable.Param(id=1) boolean paramBoolean1, @SafeParcelable.Param(id=2) boolean paramBoolean2, @SafeParcelable.Param(id=3) boolean paramBoolean3, @SafeParcelable.Param(id=4) boolean paramBoolean4, @SafeParcelable.Param(id=5) boolean paramBoolean5, @SafeParcelable.Param(id=6) boolean paramBoolean6)
  {
    this.zzbn = paramBoolean1;
    this.zzbo = paramBoolean2;
    this.zzbp = paramBoolean3;
    this.zzbq = paramBoolean4;
    this.zzbr = paramBoolean5;
    this.zzbs = paramBoolean6;
  }

  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }

  public final boolean isBlePresent()
  {
    return this.zzbs;
  }

  public final boolean isBleUsable()
  {
    return this.zzbp;
  }

  public final boolean isGpsPresent()
  {
    return this.zzbq;
  }

  public final boolean isGpsUsable()
  {
    return this.zzbn;
  }

  public final boolean isLocationPresent()
  {
    return (this.zzbq) || (this.zzbr);
  }

  public final boolean isLocationUsable()
  {
    return (this.zzbn) || (this.zzbo);
  }

  public final boolean isNetworkLocationPresent()
  {
    return this.zzbr;
  }

  public final boolean isNetworkLocationUsable()
  {
    return this.zzbo;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, isGpsUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 2, isNetworkLocationUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 3, isBleUsable());
    SafeParcelWriter.writeBoolean(paramParcel, 4, isGpsPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNetworkLocationPresent());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isBlePresent());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.LocationSettingsStates
 * JD-Core Version:    0.6.2
 */