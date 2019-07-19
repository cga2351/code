package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;

@SafeParcelable.Class(creator="ConverterWrapperCreator")
public final class zaa extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zaa> CREATOR = new zab();

  @SafeParcelable.VersionField(id=1)
  private final int zale;

  @SafeParcelable.Field(getter="getStringToIntConverter", id=2)
  private final StringToIntConverter zapk;

  @SafeParcelable.Constructor
  zaa(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) StringToIntConverter paramStringToIntConverter)
  {
    this.zale = paramInt;
    this.zapk = paramStringToIntConverter;
  }

  private zaa(StringToIntConverter paramStringToIntConverter)
  {
    this.zale = 1;
    this.zapk = paramStringToIntConverter;
  }

  public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter)
  {
    if ((paramFieldConverter instanceof StringToIntConverter))
      return new zaa((StringToIntConverter)paramFieldConverter);
    throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zapk, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final FastJsonResponse.FieldConverter<?, ?> zaci()
  {
    if (this.zapk != null)
      return this.zapk;
    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.zaa
 * JD-Core Version:    0.6.2
 */