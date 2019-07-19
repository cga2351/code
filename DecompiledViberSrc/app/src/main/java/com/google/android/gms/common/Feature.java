package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@KeepForSdk
@SafeParcelable.Class(creator="FeatureCreator")
public class Feature extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Feature> CREATOR = new zzb();

  @SafeParcelable.Field(getter="getName", id=1)
  private final String name;

  @Deprecated
  @SafeParcelable.Field(getter="getOldVersion", id=2)
  private final int zzk;

  @SafeParcelable.Field(defaultValue="-1", getter="getVersion", id=3)
  private final long zzl;

  @SafeParcelable.Constructor
  public Feature(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) long paramLong)
  {
    this.name = paramString;
    this.zzk = paramInt;
    this.zzl = paramLong;
  }

  @KeepForSdk
  public Feature(String paramString, long paramLong)
  {
    this.name = paramString;
    this.zzl = paramLong;
    this.zzk = -1;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Feature;
    boolean bool2 = false;
    if (bool1)
    {
      Feature localFeature = (Feature)paramObject;
      if ((getName() == null) || (!getName().equals(localFeature.getName())))
      {
        String str1 = getName();
        bool2 = false;
        if (str1 == null)
        {
          String str2 = localFeature.getName();
          bool2 = false;
          if (str2 != null);
        }
      }
      else
      {
        boolean bool3 = getVersion() < localFeature.getVersion();
        bool2 = false;
        if (!bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  @KeepForSdk
  public String getName()
  {
    return this.name;
  }

  @KeepForSdk
  public long getVersion()
  {
    if (this.zzl == -1L)
      return this.zzk;
    return this.zzl;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = getName();
    arrayOfObject[1] = Long.valueOf(getVersion());
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, this.zzk);
    SafeParcelWriter.writeLong(paramParcel, 3, getVersion());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.Feature
 * JD-Core Version:    0.6.2
 */