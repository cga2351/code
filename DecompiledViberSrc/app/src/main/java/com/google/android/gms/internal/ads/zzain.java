package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzare
@SafeParcelable.Class(creator="AdapterStatusParcelCreator")
public final class zzain extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzain> CREATOR = new zzaio();

  @SafeParcelable.Field(id=4)
  public final String description;

  @SafeParcelable.Field(id=1)
  public final String zzdba;

  @SafeParcelable.Field(id=2)
  public final boolean zzdbb;

  @SafeParcelable.Field(id=3)
  public final int zzdbc;

  @SafeParcelable.Constructor
  public zzain(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) boolean paramBoolean, @SafeParcelable.Param(id=3) int paramInt, @SafeParcelable.Param(id=4) String paramString2)
  {
    this.zzdba = paramString1;
    this.zzdbb = paramBoolean;
    this.zzdbc = paramInt;
    this.description = paramString2;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzdba, false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzdbb);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdbc);
    SafeParcelWriter.writeString(paramParcel, 4, this.description, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzain
 * JD-Core Version:    0.6.2
 */