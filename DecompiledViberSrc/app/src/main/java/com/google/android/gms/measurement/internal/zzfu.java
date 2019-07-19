package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@SafeParcelable.Class(creator="UserAttributeParcelCreator")
public final class zzfu extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfu> CREATOR = new zzfv();

  @SafeParcelable.Field(id=2)
  public final String name;

  @SafeParcelable.Field(id=7)
  public final String origin;

  @SafeParcelable.Field(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=6)
  public final String zzamn;

  @SafeParcelable.Field(id=3)
  public final long zzaum;

  @SafeParcelable.Field(id=4)
  public final Long zzaun;

  @SafeParcelable.Field(id=5)
  private final Float zzauo;

  @SafeParcelable.Field(id=8)
  public final Double zzaup;

  @SafeParcelable.Constructor
  zzfu(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) long paramLong, @SafeParcelable.Param(id=4) Long paramLong1, @SafeParcelable.Param(id=5) Float paramFloat, @SafeParcelable.Param(id=6) String paramString2, @SafeParcelable.Param(id=7) String paramString3, @SafeParcelable.Param(id=8) Double paramDouble)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaum = paramLong;
    this.zzaun = paramLong1;
    this.zzauo = null;
    Double localDouble;
    if (paramInt == 1)
    {
      localDouble = null;
      if (paramFloat != null)
        localDouble = Double.valueOf(paramFloat.doubleValue());
    }
    for (this.zzaup = localDouble; ; this.zzaup = paramDouble)
    {
      this.zzamn = paramString2;
      this.origin = paramString3;
      return;
    }
  }

  zzfu(zzfw paramzzfw)
  {
    this(paramzzfw.name, paramzzfw.zzaum, paramzzfw.value, paramzzfw.origin);
  }

  zzfu(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.versionCode = 2;
    this.name = paramString1;
    this.zzaum = paramLong;
    this.origin = paramString2;
    if (paramObject == null)
    {
      this.zzaun = null;
      this.zzauo = null;
      this.zzaup = null;
      this.zzamn = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzaun = ((Long)paramObject);
      this.zzauo = null;
      this.zzaup = null;
      this.zzamn = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzaun = null;
      this.zzauo = null;
      this.zzaup = null;
      this.zzamn = ((String)paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      this.zzaun = null;
      this.zzauo = null;
      this.zzaup = ((Double)paramObject);
      this.zzamn = null;
      return;
    }
    throw new IllegalArgumentException("User attribute given of un-supported type");
  }

  public final Object getValue()
  {
    if (this.zzaun != null)
      return this.zzaun;
    if (this.zzaup != null)
      return this.zzaup;
    if (this.zzamn != null)
      return this.zzamn;
    return null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.name, false);
    SafeParcelWriter.writeLong(paramParcel, 3, this.zzaum);
    SafeParcelWriter.writeLongObject(paramParcel, 4, this.zzaun, false);
    SafeParcelWriter.writeFloatObject(paramParcel, 5, null, false);
    SafeParcelWriter.writeString(paramParcel, 6, this.zzamn, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.origin, false);
    SafeParcelWriter.writeDoubleObject(paramParcel, 8, this.zzaup, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzfu
 * JD-Core Version:    0.6.2
 */