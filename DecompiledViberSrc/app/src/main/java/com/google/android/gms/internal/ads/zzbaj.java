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
@SafeParcelable.Class(creator="VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbaj extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzbaj> CREATOR = new zzbak();

  @SafeParcelable.Field(id=2)
  public String zzbsy;

  @SafeParcelable.Field(id=3)
  public int zzdze;

  @SafeParcelable.Field(id=4)
  public int zzdzf;

  @SafeParcelable.Field(id=5)
  public boolean zzdzg;

  @SafeParcelable.Field(id=6)
  private boolean zzdzh;

  public zzbaj(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean, false, false);
  }

  public zzbaj(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramInt1, paramInt2, true, false, false);
  }

  private zzbaj(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
  }

  @SafeParcelable.Constructor
  zzbaj(@SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) boolean paramBoolean1, @SafeParcelable.Param(id=6) boolean paramBoolean2)
  {
    this.zzbsy = paramString;
    this.zzdze = paramInt1;
    this.zzdzf = paramInt2;
    this.zzdzg = paramBoolean1;
    this.zzdzh = paramBoolean2;
  }

  public static zzbaj zzxc()
  {
    return new zzbaj(12451009, 12451009, true);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzbsy, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdze);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzdzf);
    SafeParcelWriter.writeBoolean(paramParcel, 5, this.zzdzg);
    SafeParcelWriter.writeBoolean(paramParcel, 6, this.zzdzh);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbaj
 * JD-Core Version:    0.6.2
 */