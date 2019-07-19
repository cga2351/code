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

@SafeParcelable.Class(creator="GetCloudSyncOptInStatusCreator")
@SafeParcelable.Reserved({1})
public final class zzdt extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdt> CREATOR = new zzds();

  @SafeParcelable.Field(id=2)
  private final int statusCode;

  @SafeParcelable.Field(id=3)
  private final boolean zzdt;

  @SafeParcelable.Field(id=4)
  private final boolean zzdu;

  @SafeParcelable.Constructor
  public zzdt(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) boolean paramBoolean1, @SafeParcelable.Param(id=4) boolean paramBoolean2)
  {
    this.statusCode = paramInt;
    this.zzdt = paramBoolean1;
    this.zzdu = paramBoolean2;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.statusCode);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzdt);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzdu);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzdt
 * JD-Core Version:    0.6.2
 */