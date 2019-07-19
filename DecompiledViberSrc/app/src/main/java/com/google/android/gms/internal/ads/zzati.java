package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@zzare
@SafeParcelable.Class(creator="RewardedVideoAdRequestParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzati extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzati> CREATOR = new zzatj();

  @SafeParcelable.Field(id=3)
  public final String zzchl;

  @SafeParcelable.Field(id=2)
  public final zzxx zzdlm;

  @SafeParcelable.Constructor
  public zzati(@SafeParcelable.Param(id=2) zzxx paramzzxx, @SafeParcelable.Param(id=3) String paramString)
  {
    this.zzdlm = paramzzxx;
    this.zzchl = paramString;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdlm, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzchl, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzati
 * JD-Core Version:    0.6.2
 */