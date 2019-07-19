package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="StreetViewSourceCreator")
@SafeParcelable.Reserved({1})
public final class StreetViewSource extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzq();
  public static final StreetViewSource DEFAULT = new StreetViewSource(0);
  public static final StreetViewSource OUTDOOR = new StreetViewSource(1);
  private static final String TAG = StreetViewSource.class.getSimpleName();

  @SafeParcelable.Field(getter="getType", id=2)
  private final int type;

  @SafeParcelable.Constructor
  public StreetViewSource(@SafeParcelable.Param(id=2) int paramInt)
  {
    this.type = paramInt;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    StreetViewSource localStreetViewSource;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewSource))
        return false;
      localStreetViewSource = (StreetViewSource)paramObject;
    }
    while (this.type == localStreetViewSource.type);
    return false;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.type);
    return Objects.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    String str;
    switch (this.type)
    {
    default:
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.type);
      str = String.format("UNKNOWN(%s)", arrayOfObject);
    case 0:
    case 1:
    }
    while (true)
    {
      return String.format("StreetViewSource:%s", new Object[] { str });
      str = "DEFAULT";
      continue;
      str = "OUTDOOR";
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewSource
 * JD-Core Version:    0.6.2
 */