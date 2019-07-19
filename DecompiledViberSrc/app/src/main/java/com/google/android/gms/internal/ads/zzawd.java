package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="SignalConfigurationParcelCreator")
public final class zzawd extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzawd> CREATOR = new zzawe();

  @SafeParcelable.Field(id=2)
  public final String zzbsv;

  @SafeParcelable.Field(id=1)
  public final String zzchl;

  @SafeParcelable.Field(id=3)
  public final zzyb zzdsw;

  @SafeParcelable.Constructor
  public zzawd(@SafeParcelable.Param(id=1) String paramString1, @SafeParcelable.Param(id=2) String paramString2, @SafeParcelable.Param(id=3) zzyb paramzzyb)
  {
    this.zzchl = paramString1;
    this.zzbsv = paramString2;
    this.zzdsw = paramzzyb;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.zzchl, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzbsv, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzdsw, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawd
 * JD-Core Version:    0.6.2
 */