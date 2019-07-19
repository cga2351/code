package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.ConnectionConfiguration;

@SafeParcelable.Class(creator="GetConfigsResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdy extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdy> CREATOR = new zzdz();

  @SafeParcelable.Field(id=2)
  private final int statusCode;

  @SafeParcelable.Field(id=3)
  private final ConnectionConfiguration[] zzdw;

  @SafeParcelable.Constructor
  public zzdy(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) ConnectionConfiguration[] paramArrayOfConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.zzdw = paramArrayOfConnectionConfiguration;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zzdw, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdy
 * JD-Core Version:    0.6.2
 */