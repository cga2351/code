package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="GassRequestParcelCreator")
public final class zzdba extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzdba> CREATOR = new zzdbb();

  @SafeParcelable.Field(id=2)
  private final String packageName;

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=3)
  private final String zzgov;

  @SafeParcelable.Constructor
  zzdba(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2)
  {
    this.versionCode = paramInt;
    this.packageName = paramString1;
    this.zzgov = paramString2;
  }

  public zzdba(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzgov, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdba
 * JD-Core Version:    0.6.2
 */