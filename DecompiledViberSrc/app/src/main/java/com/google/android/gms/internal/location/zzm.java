package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator="DeviceOrientationRequestInternalCreator")
public final class zzm extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzm> CREATOR = new zzn();

  @VisibleForTesting
  static final List<ClientIdentity> zzcd = Collections.emptyList();
  static final zzj zzce = new zzj();

  @SafeParcelable.Field(defaultValueUnchecked="null", id=3)
  private String tag;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequestInternal.DEFAULT_DEVICE_ORIENTATION_REQUEST", id=1)
  private zzj zzcf;

  @SafeParcelable.Field(defaultValueUnchecked="DeviceOrientationRequestInternal.DEFAULT_CLIENTS", id=2)
  private List<ClientIdentity> zzm;

  @SafeParcelable.Constructor
  zzm(@SafeParcelable.Param(id=1) zzj paramzzj, @SafeParcelable.Param(id=2) List<ClientIdentity> paramList, @SafeParcelable.Param(id=3) String paramString)
  {
    this.zzcf = paramzzj;
    this.zzm = paramList;
    this.tag = paramString;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzm));
    zzm localzzm;
    do
    {
      return false;
      localzzm = (zzm)paramObject;
    }
    while ((!Objects.equal(this.zzcf, localzzm.zzcf)) || (!Objects.equal(this.zzm, localzzm.zzm)) || (!Objects.equal(this.tag, localzzm.tag)));
    return true;
  }

  public final int hashCode()
  {
    return this.zzcf.hashCode();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, this.zzcf, paramInt, false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzm, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.tag, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzm
 * JD-Core Version:    0.6.2
 */