package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="RtbVersionInfoParcelCreator")
public final class zzapk extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzapk> CREATOR = new zzapl();

  @SafeParcelable.Field(id=1)
  private final int major;

  @SafeParcelable.Field(id=2)
  private final int minor;

  @SafeParcelable.Field(id=3)
  private final int zzdho;

  @SafeParcelable.Constructor
  zzapk(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3)
  {
    this.major = paramInt1;
    this.minor = paramInt2;
    this.zzdho = paramInt3;
  }

  public static zzapk zza(VersionInfo paramVersionInfo)
  {
    return new zzapk(paramVersionInfo.getMajorVersion(), paramVersionInfo.getMinorVersion(), paramVersionInfo.getMicroVersion());
  }

  public final String toString()
  {
    int i = this.major;
    int j = this.minor;
    int k = this.zzdho;
    return 35 + i + "." + j + "." + k;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.major);
    SafeParcelWriter.writeInt(paramParcel, 2, this.minor);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzdho);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzapk
 * JD-Core Version:    0.6.2
 */