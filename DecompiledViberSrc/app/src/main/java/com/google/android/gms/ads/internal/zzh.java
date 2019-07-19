package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.ads.zzare;

@zzare
@SafeParcelable.Class(creator="InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzh extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzh> CREATOR = new zzi();

  @SafeParcelable.Field(id=2)
  public final boolean zzbrf;

  @SafeParcelable.Field(id=3)
  public final boolean zzbrg;

  @SafeParcelable.Field(id=4)
  private final String zzbrh;

  @SafeParcelable.Field(id=5)
  public final boolean zzbri;

  @SafeParcelable.Field(id=6)
  public final float zzbrj;

  @SafeParcelable.Field(id=7)
  public final int zzbrk;

  @SafeParcelable.Field(id=8)
  public final boolean zzbrl;

  @SafeParcelable.Field(id=9)
  public final boolean zzbrm;

  @SafeParcelable.Field(id=10)
  public final boolean zzbrn;

  @SafeParcelable.Constructor
  zzh(@SafeParcelable.Param(id=2) boolean paramBoolean1, @SafeParcelable.Param(id=3) boolean paramBoolean2, @SafeParcelable.Param(id=4) String paramString, @SafeParcelable.Param(id=5) boolean paramBoolean3, @SafeParcelable.Param(id=6) float paramFloat, @SafeParcelable.Param(id=7) int paramInt, @SafeParcelable.Param(id=8) boolean paramBoolean4, @SafeParcelable.Param(id=9) boolean paramBoolean5, @SafeParcelable.Param(id=10) boolean paramBoolean6)
  {
    this.zzbrf = paramBoolean1;
    this.zzbrg = paramBoolean2;
    this.zzbrh = paramString;
    this.zzbri = paramBoolean3;
    this.zzbrj = paramFloat;
    this.zzbrk = paramInt;
    this.zzbrl = paramBoolean4;
    this.zzbrm = paramBoolean5;
    this.zzbrn = paramBoolean6;
  }

  public zzh(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat, int paramInt, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    this(false, paramBoolean2, null, false, 0.0F, -1, paramBoolean4, paramBoolean5, paramBoolean6);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzbrf);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzbrg);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzbrh, false);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzbri);
    SafeParcelWriter.writeFloat(paramParcel, 6, this.zzbrj);
    SafeParcelWriter.writeInt(paramParcel, 7, this.zzbrk);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzbrl);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzbrm);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzbrn);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.zzh
 * JD-Core Version:    0.6.2
 */