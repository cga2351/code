package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@SafeParcelable.Class(creator="AppMetadataCreator")
@SafeParcelable.Reserved({1, 20})
public final class zzk extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzk> CREATOR = new zzl();

  @SafeParcelable.Field(id=2)
  public final String packageName;

  @SafeParcelable.Field(id=6)
  public final long zzade;

  @SafeParcelable.Field(id=3)
  public final String zzafi;

  @SafeParcelable.Field(id=12)
  public final String zzafk;

  @SafeParcelable.Field(defaultValueUnchecked="Integer.MIN_VALUE", id=11)
  public final long zzafo;

  @SafeParcelable.Field(id=5)
  public final String zzafp;

  @SafeParcelable.Field(id=7)
  public final long zzafq;

  @SafeParcelable.Field(defaultValue="true", id=9)
  public final boolean zzafr;

  @SafeParcelable.Field(id=13)
  public final long zzafs;

  @SafeParcelable.Field(defaultValue="true", id=16)
  public final boolean zzaft;

  @SafeParcelable.Field(defaultValue="true", id=17)
  public final boolean zzafu;

  @SafeParcelable.Field(id=19)
  public final String zzafv;

  @SafeParcelable.Field(id=8)
  public final String zzagm;

  @SafeParcelable.Field(id=10)
  public final boolean zzagn;

  @SafeParcelable.Field(id=14)
  public final long zzago;

  @SafeParcelable.Field(id=15)
  public final int zzagp;

  @SafeParcelable.Field(id=18)
  public final boolean zzagq;

  @SafeParcelable.Field(id=4)
  public final String zzts;

  zzk(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, boolean paramBoolean1, boolean paramBoolean2, String paramString6, long paramLong4, long paramLong5, int paramInt, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString7)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.packageName = paramString1;
    if (TextUtils.isEmpty(paramString2))
      paramString2 = null;
    this.zzafi = paramString2;
    this.zzts = paramString3;
    this.zzafo = paramLong1;
    this.zzafp = paramString4;
    this.zzade = paramLong2;
    this.zzafq = paramLong3;
    this.zzagm = paramString5;
    this.zzafr = paramBoolean1;
    this.zzagn = paramBoolean2;
    this.zzafk = paramString6;
    this.zzafs = paramLong4;
    this.zzago = paramLong5;
    this.zzagp = paramInt;
    this.zzaft = paramBoolean3;
    this.zzafu = paramBoolean4;
    this.zzagq = paramBoolean5;
    this.zzafv = paramString7;
  }

  @SafeParcelable.Constructor
  zzk(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) long paramLong1, @SafeParcelable.Param(id=7) long paramLong2, @SafeParcelable.Param(id=8) String paramString5, @SafeParcelable.Param(id=9) boolean paramBoolean1, @SafeParcelable.Param(id=10) boolean paramBoolean2, @SafeParcelable.Param(id=11) long paramLong3, @SafeParcelable.Param(id=12) String paramString6, @SafeParcelable.Param(id=13) long paramLong4, @SafeParcelable.Param(id=14) long paramLong5, @SafeParcelable.Param(id=15) int paramInt, @SafeParcelable.Param(id=16) boolean paramBoolean3, @SafeParcelable.Param(id=17) boolean paramBoolean4, @SafeParcelable.Param(id=18) boolean paramBoolean5, @SafeParcelable.Param(id=19) String paramString7)
  {
    this.packageName = paramString1;
    this.zzafi = paramString2;
    this.zzts = paramString3;
    this.zzafo = paramLong3;
    this.zzafp = paramString4;
    this.zzade = paramLong1;
    this.zzafq = paramLong2;
    this.zzagm = paramString5;
    this.zzafr = paramBoolean1;
    this.zzagn = paramBoolean2;
    this.zzafk = paramString6;
    this.zzafs = paramLong4;
    this.zzago = paramLong5;
    this.zzagp = paramInt;
    this.zzaft = paramBoolean3;
    this.zzafu = paramBoolean4;
    this.zzagq = paramBoolean5;
    this.zzafv = paramString7;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzafi, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzts, false);
    SafeParcelWriter.writeString(paramParcel, 5, this.zzafp, false);
    SafeParcelWriter.writeLong(paramParcel, 6, this.zzade);
    SafeParcelWriter.writeLong(paramParcel, 7, this.zzafq);
    SafeParcelWriter.writeString(paramParcel, 8, this.zzagm, false);
    SafeParcelWriter.writeBoolean(paramParcel, 9, this.zzafr);
    SafeParcelWriter.writeBoolean(paramParcel, 10, this.zzagn);
    SafeParcelWriter.writeLong(paramParcel, 11, this.zzafo);
    SafeParcelWriter.writeString(paramParcel, 12, this.zzafk, false);
    SafeParcelWriter.writeLong(paramParcel, 13, this.zzafs);
    SafeParcelWriter.writeLong(paramParcel, 14, this.zzago);
    SafeParcelWriter.writeInt(paramParcel, 15, this.zzagp);
    SafeParcelWriter.writeBoolean(paramParcel, 16, this.zzaft);
    SafeParcelWriter.writeBoolean(paramParcel, 17, this.zzafu);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzagq);
    SafeParcelWriter.writeString(paramParcel, 19, this.zzafv, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzk
 * JD-Core Version:    0.6.2
 */