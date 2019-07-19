package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="TileCreator")
@SafeParcelable.Reserved({1})
public final class Tile extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Tile> CREATOR = new zzr();

  @SafeParcelable.Field(id=4)
  public final byte[] data;

  @SafeParcelable.Field(id=3)
  public final int height;

  @SafeParcelable.Field(id=2)
  public final int width;

  @SafeParcelable.Constructor
  public Tile(@SafeParcelable.Param(id=2) int paramInt1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) byte[] paramArrayOfByte)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.data = paramArrayOfByte;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.width);
    SafeParcelWriter.writeInt(paramParcel, 3, this.height);
    SafeParcelWriter.writeByteArray(paramParcel, 4, this.data, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.Tile
 * JD-Core Version:    0.6.2
 */