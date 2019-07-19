package com.google.android.gms.internal.location;

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

@SafeParcelable.Class(creator="FusedLocationProviderResultCreator")
@SafeParcelable.Reserved({1000})
public final class zzad extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<zzad> CREATOR = new zzae();
  private static final zzad zzcr = new zzad(Status.RESULT_SUCCESS);

  @SafeParcelable.Field(getter="getStatus", id=1)
  private final Status zzbl;

  @SafeParcelable.Constructor
  public zzad(@SafeParcelable.Param(id=1) Status paramStatus)
  {
    this.zzbl = paramStatus;
  }

  public final Status getStatus()
  {
    return this.zzbl;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getStatus(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzad
 * JD-Core Version:    0.6.2
 */