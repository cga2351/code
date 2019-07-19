package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="LocationSettingsConfigurationCreator")
@SafeParcelable.Reserved({3, 4, 1000})
public final class zzae extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzae> CREATOR = new zzaf();

  @SafeParcelable.Field(defaultValue="", getter="getJustificationText", id=1)
  private final String zzbd;

  @SafeParcelable.Field(defaultValue="", getter="getExperimentId", id=2)
  private final String zzbe;

  @SafeParcelable.Field(defaultValue="", getter="getTitleText", id=5)
  private final String zzbf;

  @SafeParcelable.Constructor
  zzae(@SafeParcelable.Param(id=5) String paramString1, @SafeParcelable.Param(id=1) String paramString2, @SafeParcelable.Param(id=2) String paramString3)
  {
    this.zzbf = paramString1;
    this.zzbd = paramString2;
    this.zzbe = paramString3;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzbd, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzbe, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzbf, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.zzae
 * JD-Core Version:    0.6.2
 */