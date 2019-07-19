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
import com.google.android.gms.wearable.Node;

@SafeParcelable.Class(creator="NodeParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzfo extends AbstractSafeParcelable
  implements Node
{
  public static final Parcelable.Creator<zzfo> CREATOR = new zzfp();

  @SafeParcelable.Field(getter="getDisplayName", id=3)
  private final String zzbk;

  @SafeParcelable.Field(getter="getId", id=2)
  private final String zzdm;

  @SafeParcelable.Field(getter="getHopCount", id=4)
  private final int zzen;

  @SafeParcelable.Field(getter="isNearby", id=5)
  private final boolean zzeo;

  @SafeParcelable.Constructor
  public zzfo(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) int paramInt, @SafeParcelable.Param(id=5) boolean paramBoolean)
  {
    this.zzdm = paramString1;
    this.zzbk = paramString2;
    this.zzen = paramInt;
    this.zzeo = paramBoolean;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzfo))
      return false;
    return ((zzfo)paramObject).zzdm.equals(this.zzdm);
  }

  public final String getDisplayName()
  {
    return this.zzbk;
  }

  public final String getId()
  {
    return this.zzdm;
  }

  public final int hashCode()
  {
    return this.zzdm.hashCode();
  }

  public final boolean isNearby()
  {
    return this.zzeo;
  }

  public final String toString()
  {
    String str1 = this.zzbk;
    String str2 = this.zzdm;
    int i = this.zzen;
    boolean bool = this.zzeo;
    return 45 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Node{" + str1 + ", id=" + str2 + ", hops=" + i + ", isNearby=" + bool + "}";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getDisplayName(), false);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzen);
    SafeParcelWriter.writeBoolean(paramParcel, 5, isNearby());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfo
 * JD-Core Version:    0.6.2
 */