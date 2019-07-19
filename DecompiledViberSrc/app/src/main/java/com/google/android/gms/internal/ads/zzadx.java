package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;

@zzare
@SafeParcelable.Class(creator="NativeAdOptionsParcelCreator")
public final class zzadx extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzadx> CREATOR = new zzady();

  @SafeParcelable.Field(id=1)
  public final int versionCode;

  @SafeParcelable.Field(id=3)
  public final int zzbqc;

  @SafeParcelable.Field(id=8)
  public final int zzbqd;

  @SafeParcelable.Field(id=4)
  public final boolean zzbqe;

  @SafeParcelable.Field(id=5)
  public final int zzbqf;

  @SafeParcelable.Field(id=7)
  public final boolean zzbqh;

  @SafeParcelable.Field(id=2)
  public final boolean zzcym;

  @SafeParcelable.Field(id=6)
  public final zzacc zzcyn;

  @SafeParcelable.Constructor
  public zzadx(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) boolean paramBoolean2, @SafeParcelable.Param(id=5) int paramInt3, @SafeParcelable.Param(id=6) zzacc paramzzacc, @SafeParcelable.Param(id=7) boolean paramBoolean3, @SafeParcelable.Param(id=8) int paramInt4)
  {
    this.versionCode = paramInt1;
    this.zzcym = paramBoolean1;
    this.zzbqc = paramInt2;
    this.zzbqe = paramBoolean2;
    this.zzbqf = paramInt3;
    this.zzcyn = paramzzacc;
    this.zzbqh = paramBoolean3;
    this.zzbqd = paramInt4;
  }

  public zzadx(NativeAdOptions paramNativeAdOptions)
  {
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzcym);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzbqc);
    SafeParcelWriter.writeBoolean(paramParcel, 4, this.zzbqe);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzbqf);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzcyn, paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 7, this.zzbqh);
    SafeParcelWriter.writeInt(paramParcel, 8, this.zzbqd);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzadx
 * JD-Core Version:    0.6.2
 */