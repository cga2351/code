package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="ConnectionInfoCreator")
public final class zzb extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzb> CREATOR = new zzc();

  @SafeParcelable.Field(id=1)
  Bundle zzcz;

  @SafeParcelable.Field(id=2)
  Feature[] zzda;

  public zzb()
  {
  }

  @SafeParcelable.Constructor
  zzb(@SafeParcelable.Param(id=1) Bundle paramBundle, @SafeParcelable.Param(id=2) Feature[] paramArrayOfFeature)
  {
    this.zzcz = paramBundle;
    this.zzda = paramArrayOfFeature;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zzcz, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zzda, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzb
 * JD-Core Version:    0.6.2
 */