package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.DataItemAsset;

@KeepName
@SafeParcelable.Class(creator="DataItemAssetParcelableCreator")
@SafeParcelable.Reserved({1})
public class DataItemAssetParcelable extends AbstractSafeParcelable
  implements ReflectedParcelable, DataItemAsset
{
  public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new zzda();

  @SafeParcelable.Field(getter="getId", id=2)
  private final String zzdm;

  @SafeParcelable.Field(getter="getDataItemKey", id=3)
  private final String zzdn;

  public DataItemAssetParcelable(DataItemAsset paramDataItemAsset)
  {
    this.zzdm = ((String)Preconditions.checkNotNull(paramDataItemAsset.getId()));
    this.zzdn = ((String)Preconditions.checkNotNull(paramDataItemAsset.getDataItemKey()));
  }

  @SafeParcelable.Constructor
  DataItemAssetParcelable(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2)
  {
    this.zzdm = paramString1;
    this.zzdn = paramString2;
  }

  public String getDataItemKey()
  {
    return this.zzdn;
  }

  public String getId()
  {
    return this.zzdm;
  }

  public boolean isDataValid()
  {
    return true;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzdm == null)
      localStringBuilder.append(",noid");
    while (true)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.zzdn);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.zzdm);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDataItemKey(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.6.2
 */