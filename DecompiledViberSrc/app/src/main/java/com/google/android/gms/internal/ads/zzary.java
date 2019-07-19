package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator="NonagonRequestParcelCreator")
public final class zzary extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzary> CREATOR = new zzarz();

  @SafeParcelable.Field(id=3)
  public final ApplicationInfo applicationInfo;

  @SafeParcelable.Field(id=4)
  public final String packageName;

  @SafeParcelable.Field(id=2)
  public final zzbaj zzdlf;

  @Nullable
  @SafeParcelable.Field(id=6)
  public final PackageInfo zzdlo;

  @SafeParcelable.Field(id=5)
  public final List<String> zzdma;

  @SafeParcelable.Field(id=7)
  public final String zzdmk;

  @SafeParcelable.Field(id=1)
  public final Bundle zzdov;

  @SafeParcelable.Field(id=8)
  public final boolean zzdow;

  @SafeParcelable.Field(id=9)
  public final String zzdox;

  @SafeParcelable.Constructor
  public zzary(@SafeParcelable.Param(id=1) Bundle paramBundle, @SafeParcelable.Param(id=2) zzbaj paramzzbaj, @SafeParcelable.Param(id=3) ApplicationInfo paramApplicationInfo, @SafeParcelable.Param(id=4) String paramString1, @SafeParcelable.Param(id=5) List<String> paramList, @SafeParcelable.Param(id=6) @Nullable PackageInfo paramPackageInfo, @SafeParcelable.Param(id=7) String paramString2, @SafeParcelable.Param(id=8) boolean paramBoolean, @SafeParcelable.Param(id=9) String paramString3)
  {
    this.zzdov = paramBundle;
    this.zzdlf = paramzzbaj;
    this.packageName = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.zzdma = paramList;
    this.zzdlo = paramPackageInfo;
    this.zzdmk = paramString2;
    this.zzdow = paramBoolean;
    this.zzdox = paramString3;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 1, this.zzdov, false);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzdlf, paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.applicationInfo, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.packageName, false);
    SafeParcelWriter.writeStringList(paramParcel, 5, this.zzdma, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zzdlo, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, this.zzdmk, false);
    SafeParcelWriter.writeBoolean(paramParcel, 8, this.zzdow);
    SafeParcelWriter.writeString(paramParcel, 9, this.zzdox, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzary
 * JD-Core Version:    0.6.2
 */